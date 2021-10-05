package com.rashik.fruitdeliveryv2.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rashik.fruitdeliveryv2.R;
import com.rashik.fruitdeliveryv2.model.DataController;
import com.rashik.fruitdeliveryv2.model.FruitShop;
import com.squareup.picasso.Picasso;

import java.nio.channels.DatagramChannel;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.viewHolder> {

    List<FruitShop> allFruitShop;
    Context context;

    public HomeRecyclerAdapter(List<FruitShop> allFruitShop) {
        this.allFruitShop = allFruitShop;
        //this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FruitShop currentFruitShop= allFruitShop.get(position);
        holder.fruitShopName.setText(currentFruitShop.getFruitShopName());
        holder.fruitShopDescription.setText(currentFruitShop.getFruitShopDescription());
        Picasso.get().load(currentFruitShop.getFruitShopImageUrl()).fit().into(holder.fruitShopImage);

    }

    @Override
    public int getItemCount() {
        if (allFruitShop==null || allFruitShop.size()==0)
        {
            return 0;
        }
        else
        {
            return allFruitShop.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView fruitShopImage;
        TextView fruitShopName,fruitShopDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            fruitShopImage=itemView.findViewById(R.id.fruitShopImageView);
            fruitShopName=itemView.findViewById(R.id.fruitShopNameTextView);
            fruitShopDescription=itemView.findViewById(R.id.fruitShopDescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FruitShop currentFruitShop=allFruitShop.get(getAdapterPosition());
                    DataController.instance.getFruitShopInterface().onFruitShopClick(currentFruitShop);
                }
            });

        }
    }

}
