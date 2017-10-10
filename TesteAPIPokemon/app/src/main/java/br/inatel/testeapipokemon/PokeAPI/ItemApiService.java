package br.inatel.testeapipokemon.PokeAPI;

import br.inatel.testeapipokemon.Model.ListItem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodrigo on 09/10/2017.
 */

public interface ItemApiService {
    @GET("item") //https://pokeapi.co/api/v2/item/
    Call<ListItem> obtainListItem();

}
