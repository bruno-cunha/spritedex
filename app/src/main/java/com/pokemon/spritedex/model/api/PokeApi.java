package com.pokemon.spritedex.model.api;

import com.pokemon.spritedex.model.pojo.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApi {

    @GET("api/v2/pokemon/{id}/")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("api/v2/pokemon/{name}/")
    Call<Pokemon> getPokemon(@Path("name") String name);

}
