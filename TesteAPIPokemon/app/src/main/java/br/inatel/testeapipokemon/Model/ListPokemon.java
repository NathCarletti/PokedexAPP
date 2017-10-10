package br.inatel.testeapipokemon.Model;

import java.util.ArrayList;

/**
 * Created by rodrigo on 06/10/2017.
 */

public class ListPokemon {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getListPokemons(){
        return results;
    }

    public void setListPokemons(ArrayList<Pokemon> listPokemons){
        this.results = listPokemons;
    }
}
