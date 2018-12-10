package com.pokemon.spritedex.ui.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.pokemon.spritedex.model.pojo.util.ApiKey;
import com.pokemon.spritedex.ui.adapters.SpriteDexAdapter;
import com.pokemon.spritedex.R;
import com.pokemon.spritedex.model.api.PokeApi;
import com.pokemon.spritedex.model.pojo.Pokemon;
import com.pokemon.spritedex.model.pojo.Sprites;
import com.pokemon.spritedex.model.service.ApiClient;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.pokemon.spritedex.model.pojo.util.Download.STORAGE_PERMISSION_REQUEST;

public class SpriteDexActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpriteDexAdapter spriteDexAdapter;
    private Toolbar toolbar;
    private Retrofit retrofit;
    private ProgressBar progressBar;
    private PokeApi pokeApi;
    private SearchView searchView;
    private String pesqQuery = "";
    private List<Call<Pokemon>> calls = new ArrayList<>();
    private Toast toast;
    private LinearLayout container;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_Bar);
        recyclerView = (RecyclerView) findViewById(R.id.rv_Pokemons);
        spriteDexAdapter = new SpriteDexAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(spriteDexAdapter);

        toolbar = (Toolbar) findViewById(R.id.inc_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_pokeball);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int index = viewHolder.getAdapterPosition();
                spriteDexAdapter.remove(index);
            }

            @Override
            public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
                super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        retrofit = ApiClient.getRetrofit();
        pokeApi = retrofit.create(PokeApi.class);
        carregaPokemons(1, 151);
        //carregaPokemonsMock();

        //Ads
        MobileAds.initialize(this, ApiKey.AppId);
        container = (LinearLayout) findViewById(R.id.container);
        adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setLayoutParams(new AdView.LayoutParams(AdView.LayoutParams.MATCH_PARENT, AdView.LayoutParams.WRAP_CONTENT));
        adView.setAdUnitId(ApiKey.AdUnitId);
        container.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public synchronized void carregaPokemons(int ini, int fim){
        cancelCalls();
        progressBar.setVisibility(View.VISIBLE);
        spriteDexAdapter.clear();

        while (ini <= fim) {
            calls.add(pokeApi.getPokemon(ini));
            calls.get(calls.size()-1).enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if (response.body() != null) {
                        spriteDexAdapter.add(response.body());
                    }
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    if(!t.getMessage().toString().equals("Canceled")) {
                        showToast(getString(R.string.msg_service_off), Toast.LENGTH_SHORT);
                    }
                    Log.d("Error", t.getMessage());
                    progressBar.setIndeterminate(false);
                }
            });
            ini++;
        }
    }

    public void carregaPokemonsMock(){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Bulbasauro");
        pokemon.setSprites(new Sprites());
        pokemon.getSprites().setFrontDefault("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
        spriteDexAdapter.add(pokemon);
    }

    public void buscaPokemon(final String pokemon) {
        cancelCalls();
        progressBar.setVisibility(View.VISIBLE);
        spriteDexAdapter.clear();
        Call<Pokemon> call = pokeApi.getPokemon(pokemon);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.body() != null) {
                    spriteDexAdapter.add(response.body());
                } else {
                    showToast(String.format(getString(R.string.msg_erro), pokemon), Toast.LENGTH_LONG);
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                showToast(String.format(getString(R.string.msg_erro), pokemon), Toast.LENGTH_LONG);
                progressBar.setIndeterminate(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                carregaPokemons(1, 151);
                return true;
            }
        });

        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getString(R.string.hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.equals(pesqQuery)) {
                    pesqQuery = query;
                    buscaPokemon(pesqQuery);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_generation_I:
                carregaPokemons(1, 151);
                break;
            case R.id.action_generation_II:
                carregaPokemons(152, 251);
                break;
            case R.id.action_generation_III:
                carregaPokemons(252, 386);
                break;
            case R.id.action_generation_IV:
                carregaPokemons(387, 493);
                break;
            case R.id.action_generation_V:
                carregaPokemons(494, 649);
                break;
            case R.id.action_generation_VI:
                carregaPokemons(649, 721);
                break;
            case R.id.action_generation_VII:
                carregaPokemons(722, 807);
                break;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST) {
            boolean permissionOk = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    permissionOk = false;
                    break;
                }
            }
            if (permissionOk) {
                spriteDexAdapter.doDownloadLastIndex();
            } else {
                showToast(getResources().getText(R.string.msg_permissions).toString(), Toast.LENGTH_LONG);
            }
        }
    }

    private void cancelCalls() {
        if (calls.size() > 0) {
            for(int index = 0; index <= calls.size() -1 ; index++) {
                calls.get(index).cancel();
            }
            calls.clear();
        }
        progressBar.setIndeterminate(false);
    }

    private void showToast(String message, int duration){
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, duration);
        toast.show();
    }
}
