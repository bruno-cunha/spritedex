package com.pokemon.spritedex;

import com.pokemon.spritedex.model.pojo.Pokemon;

import java.util.Comparator;

/**
 * Created by brunocunha on 5/18/18.
 */

public class Ordem implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon p1, Pokemon o2) {
        if (p1.getId() == o2.getId()) {
            return 0;
        } else if (p1.getId() < o2.getId()) {
            return -1;
        }
        return 1;
    }
}