package br.inatel.testeapipokemon.PokeAPI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import br.inatel.testeapipokemon.Model.ListPokemon;
import br.inatel.testeapipokemon.Model.Pokemon;
import br.inatel.testeapipokemon.R;

/**
 * Created by rodrigo on 08/10/2017.
 */

public class  PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> pokemon;
    private Context context;

    public  PokemonAdapter(Context context){
        this.context = context;
        pokemon = new ArrayList<>();
    }

    public void addPokemon(ArrayList<Pokemon> listPok){
        pokemon.addAll(listPok);
        notifyDataSetChanged();
    }

    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.ViewHolder holder, int position) {
        Pokemon pok = pokemon.get(position);
        holder.textView.setText(pok.getName());

        Glide.with(context)
                .load("https://pokeapi.co/media/sprites/pokemon/"+ pok.getNum() +".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgPoke);
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPoke;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPoke = (ImageView)itemView.findViewById(R.id.imgPok);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
