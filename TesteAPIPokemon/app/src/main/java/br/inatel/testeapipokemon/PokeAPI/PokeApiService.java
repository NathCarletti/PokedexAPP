package br.inatel.testeapipokemon.PokeAPI;

import br.inatel.testeapipokemon.Model.ListItem;
import br.inatel.testeapipokemon.Model.ListPokemon;
import br.inatel.testeapipokemon.Model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodrigo on 06/10/2017.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<ListPokemon> obtainListPokemon();


}
