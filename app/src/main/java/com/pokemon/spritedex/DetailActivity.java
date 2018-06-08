package com.pokemon.spritedex;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pokemon.spritedex.model.pojo.Pokemon;
import com.pokemon.spritedex.model.pojo.Sprites;
import com.squareup.picasso.Picasso;

import static com.pokemon.spritedex.Download.STORAGE_PERMISSION_REQUEST;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvId;
    private TextView tvName;
    private ImageButton ibDownload;

    private ImageView ivFrontDefault;
    private ImageView ivBackDefault;
    private ImageView ivFrontFemale;
    private ImageView ivBackFemale;
    private ImageView ivFrontShiny;
    private ImageView ivBackShiny;
    private ImageView ivFrontShinyFemale;
    private ImageView ivBackShinyFemale;
    private Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvId = (TextView) findViewById(R.id.text_id_value);
        tvName = (TextView) findViewById(R.id.text_name_value);
        ibDownload = (ImageButton) findViewById(R.id.ib_download);

        ivFrontDefault = (ImageView) findViewById(R.id.iv_front_default);
        ivBackDefault = (ImageView) findViewById(R.id.iv_back_default);
        ivFrontShiny = (ImageView) findViewById(R.id.iv_front_shiny);
        ivBackShiny = (ImageView) findViewById(R.id.iv_back_shiny);
        ivFrontFemale = (ImageView) findViewById(R.id.iv_front_female);
        ivBackFemale = (ImageView) findViewById(R.id.iv_back_female);
        ivFrontShinyFemale = (ImageView) findViewById(R.id.iv_front_shiny_female);
        ivBackShinyFemale = (ImageView) findViewById(R.id.iv_back_shiny_female);

        pokemon = new Pokemon();
        pokemon.setSprites(new Sprites());

        Intent intent = getIntent();

        if (intent.hasExtra("id")) {
            pokemon.setId(intent.getIntExtra("id", 0));
            tvId.setText(String.valueOf(pokemon.getId()));
        }
        if (intent.hasExtra("name") && !intent.getStringExtra("name").isEmpty()) {
            pokemon.setName(intent.getStringExtra("name"));
            tvName.setText(Adapter.setFirstLeterUpperCase(pokemon.getName()));
        }

        if (intent.hasExtra("frontDefault") && intent.getStringExtra("frontDefault") != null) {
            pokemon.getSprites().setFrontDefault(intent.getStringExtra("frontDefault"));
            Picasso.get().load(pokemon.getSprites().getFrontDefault()).into(ivFrontDefault);
        }
        if (intent.hasExtra("backDefault") && intent.getStringExtra("backDefault") != null) {
            pokemon.getSprites().setBackDefault(intent.getStringExtra("backDefault"));
            Picasso.get().load(pokemon.getSprites().getBackDefault()).into(ivBackDefault);
        }
        if (intent.hasExtra("frontShiny") && intent.getStringExtra("frontShiny") != null) {
            pokemon.getSprites().setFrontShiny(intent.getStringExtra("frontShiny"));
            Picasso.get().load(pokemon.getSprites().getFrontShiny()).into(ivFrontShiny);
        }
        if (intent.hasExtra("backShiny") && intent.getStringExtra("backShiny") != null) {
            pokemon.getSprites().setBackShiny(intent.getStringExtra("backShiny"));
            Picasso.get().load(pokemon.getSprites().getBackShiny()).into(ivBackShiny);
        }
        if (intent.hasExtra("frontFemale") && intent.getStringExtra("frontFemale") != null) {
            pokemon.getSprites().setFrontFemale(intent.getStringExtra("frontFemale"));
            Picasso.get().load(pokemon.getSprites().getFrontFemale()).into(ivFrontFemale);
        }
        if (intent.hasExtra("backFemale") && intent.getStringExtra("backFemale") != null) {
            pokemon.getSprites().setBackFemale(intent.getStringExtra("backFemale"));
            Picasso.get().load(pokemon.getSprites().getBackFemale()).into(ivBackFemale);
        }
        if (intent.hasExtra("frontShinyFemale") && intent.getStringExtra("frontShinyFemale") != null) {
            pokemon.getSprites().setFrontShinyFemale(intent.getStringExtra("frontShinyFemale"));
            Picasso.get().load(pokemon.getSprites().getFrontShinyFemale()).into(ivFrontShinyFemale);
        }
        if (intent.hasExtra("backShinyFemale") && intent.getStringExtra("backShinyFemale") != null) {
            pokemon.getSprites().setBackShinyFemale(intent.getStringExtra("backShinyFemale"));
            Picasso.get().load(pokemon.getSprites().getBackShinyFemale()).into(ivBackShinyFemale);
        }

        toolbar = (Toolbar) findViewById(R.id.inc_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download.checkPermissionsAndDoDownload(v.getContext(), pokemon);
            }
        });
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
                Download.doDownload(this, pokemon);
            } else {
                Toast.makeText(this, getResources().getText(R.string.msg_permissions).toString(), Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}
