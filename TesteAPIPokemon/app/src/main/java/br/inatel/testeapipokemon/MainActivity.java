package br.inatel.testeapipokemon;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.inatel.testeapipokemon.Model.Items;
import br.inatel.testeapipokemon.Model.ListItem;
import br.inatel.testeapipokemon.PokeAPI.ItemAdapter;
import br.inatel.testeapipokemon.PokeAPI.ItemApiService;
import br.inatel.testeapipokemon.PokeAPI.PokemonAdapter;
import retrofit2.Call;

import java.util.ArrayList;

import br.inatel.testeapipokemon.Model.ListPokemon;
import br.inatel.testeapipokemon.Model.Pokemon;
import br.inatel.testeapipokemon.PokeAPI.PokeApiService;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofitP, retrofitI;
    private static final String TAG = "POKEDEX";

    private RecyclerView recyclerViewP, recyclerViewI;
    PokemonAdapter pokemonAdapter;
    ItemAdapter itemAdapter;
    Button showPoke, showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showPoke = (Button) findViewById(R.id.showPoke);
        showItems = (Button) findViewById(R.id.showItems);

       /* recyclerViewP = (RecyclerView) findViewById(R.id.recView);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerViewP.setAdapter(pokemonAdapter);
        recyclerViewP.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerViewP.setLayoutManager(layoutManager);

        recyclerViewI = (RecyclerView)findViewById(R.id.recView);
        itemAdapter = new ItemAdapter(this);
        recyclerViewI.setAdapter(itemAdapter);
        recyclerViewI.setHasFixedSize(true);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this,1);
        recyclerViewI.setLayoutManager(layoutManager2);*/


      //  retrofitP = new Retrofit.Builder()
        //        .baseUrl("https://pokeapi.co/api/v2/")
          //      .addConverterFactory(GsonConverterFactory.create())
            //    .build();
        showPokeClick(recyclerViewP);
        showItemClick(recyclerViewI);

    }

    public void showPokeClick(View view){
        recyclerViewP = (RecyclerView) findViewById(R.id.recView);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerViewP.setAdapter(pokemonAdapter);
        recyclerViewP.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerViewP.setLayoutManager(layoutManager);

        retrofitP = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.e(TAG,"pok");
        obtainPokemon();
    }
    public void showItemClick(View view) {
        recyclerViewI = (RecyclerView)findViewById(R.id.recView);
        itemAdapter = new ItemAdapter(this);
        recyclerViewI.setAdapter(itemAdapter);
        recyclerViewI.setHasFixedSize(true);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this,1);
        recyclerViewI.setLayoutManager(layoutManager2);

        retrofitI = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.e(TAG,"item");
        obtainItem();
    }

    private void obtainItem() {
        ItemApiService service = retrofitI.create(ItemApiService.class);
        Call<ListItem> listItemCall = service.obtainListItem();
        listItemCall.enqueue(new Callback<ListItem>() {
            @Override
            public void onResponse(Call<ListItem> call, Response<ListItem> response) {
                if (response.isSuccessful()) {
                    ListItem listItem = response.body();
                    ArrayList<Items> listI = listItem.getResults();

                    itemAdapter.addItems(listI);

                } else{
                Log.e(TAG," onResponse: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ListItem> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }


    private void obtainPokemon() {
        PokeApiService service = retrofitP.create(PokeApiService.class);
        Call<ListPokemon> listPokemonCall = service.obtainListPokemon();
        listPokemonCall.enqueue(new Callback<ListPokemon>() {
            @Override
            public void onResponse(Call<ListPokemon> call, Response<ListPokemon> response) {

                if(response.isSuccessful()){
                    ListPokemon listPokemon = response.body();
                    ArrayList<Pokemon> listP = listPokemon.getListPokemons();

                    pokemonAdapter.addPokemon(listP);

                }else{
                    Log.e(TAG," onResponse: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ListPokemon> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
