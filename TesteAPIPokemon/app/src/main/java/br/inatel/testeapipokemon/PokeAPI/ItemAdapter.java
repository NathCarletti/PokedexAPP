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

import br.inatel.testeapipokemon.Model.Items;
import br.inatel.testeapipokemon.R;

/**
 * Created by rodrigo on 09/10/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<Items> items;
    private Context context;

    public  ItemAdapter(Context context){
        this.context = context;
        items = new ArrayList<>();
    }

    public void addItems(ArrayList<Items> listI){
        items.addAll(listI);
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Items item = items.get(position);
        holder.textView.setText(item.getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/"+item.getName()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgPoke);
    }

    @Override
    public int getItemCount() {
        return items.size();
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
