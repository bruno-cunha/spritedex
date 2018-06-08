package com.pokemon.spritedex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokemon.spritedex.model.pojo.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bruno on 02/05/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private int lastIndexClick = 0;
    private View.OnClickListener listener;
    public List<Pokemon> pokemons;

    public Adapter(Context context) {
        this.context = context;
        this.pokemons = new ArrayList<>();
    }

    public Adapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    public Adapter(Context context, View.OnClickListener listener) {
        this.context = context;
        this.pokemons = new ArrayList<>();
        this.listener = listener;
    }

    public Adapter(Context context, List<Pokemon> pokemons, View.OnClickListener listener) {
        this.context = context;
        this.pokemons = pokemons;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        lastIndexClick = position;
        final Pokemon pokemon = pokemons.get(position);
        Picasso.get().load(pokemon.getSprites().getFrontDefault()).into(holder.ivSprite);
        holder.tvNome.setText(setFirstLeterUpperCase(pokemon.getName()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", pokemon.getId());
                intent.putExtra("name", pokemon.getName());
                intent.putExtra("weight", pokemon.getWeight());
                intent.putExtra("height", pokemon.getHeight());
                intent.putExtra("frontDefault", pokemon.getSprites().getFrontDefault());
                intent.putExtra("backDefault", pokemon.getSprites().getBackDefault());
                intent.putExtra("frontShiny", pokemon.getSprites().getFrontShiny());
                intent.putExtra("backShiny", pokemon.getSprites().getBackShiny());
                intent.putExtra("frontFemale", pokemon.getSprites().getFrontFemale());
                intent.putExtra("backFemale", pokemon.getSprites().getBackFemale());
                intent.putExtra("frontShinyFemale", pokemon.getSprites().getFrontShinyFemale());
                intent.putExtra("backShinyFemale", pokemon.getSprites().getBackShinyFemale());
                context.startActivity(intent);
            }
        });

        holder.ibDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Download.checkPermissionsAndDoDownload(context, pokemon);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
        Collections.sort(this.pokemons, new Ordem());
        notifyDataSetChanged();
    }

    public void addAll(List<Pokemon> pokemons) {
        this.pokemons.clear();
        this.pokemons.addAll(pokemons);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        pokemons.remove(position);
        notifyItemRemoved(position);
    }

    public void updateAll(List<Pokemon> pokemons){
        this.pokemons.clear();
        this.pokemons.addAll(pokemons);
        Collections.sort(this.pokemons, new Ordem());
        notifyDataSetChanged();
    }

    public void clear() {
        pokemons.clear();
        notifyDataSetChanged();
    }

    public void doDownloadLastIndex() {
        Download.doDownload(context, pokemons.get(lastIndexClick));
    }

    public static String setFirstLeterUpperCase(String texto) {
        return String.format("%s%s", texto.substring(0, 1).toUpperCase(), texto.substring(1).toLowerCase());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView ivSprite;
        TextView tvNome;
        ImageButton ibDownload;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            ivSprite = (ImageView) itemView.findViewById(R.id.iv_sprite);
            tvNome = (TextView) itemView.findViewById(R.id.tv_nome);
            ibDownload = (ImageButton) itemView.findViewById(R.id.ib_download);
        }
    }
}
