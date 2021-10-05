package com.rashik.fruitdeliveryv2.ui.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rashik.fruitdeliveryv2.R;
import com.rashik.fruitdeliveryv2.model.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {

    List<MenuItem> allMenuItems;
    Context context;

    public MenuAdapter(List<MenuItem> allFruitShop) {
        this.allMenuItems = allFruitShop;
        //this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);

        return new MenuAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.viewHolder holder, int position) {
        MenuItem currentFruitShopMenuItem= allMenuItems.get(position);
        /*holder.fruitShopName.setText(currentFruitShop.getFruitShopName());
        holder.fruitShopDescription.setText(currentFruitShop.getFruitShopDescription());
        Picasso.get().load(currentFruitShop.getFruitShopImageUrl()).fit().into(holder.fruitShopImage);*/

    }

    @Override
    public int getItemCount() {
        if (allMenuItems==null || allMenuItems.size()==0)
        {
            return 0;
        }
        else
        {
            return allMenuItems.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{


        TextView menuItemName, menuItemDescription,menuItemPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);


            menuItemName =itemView.findViewById(R.id.fruitShopNameTextView);
            menuItemDescription =itemView.findViewById(R.id.fruitShopDescription);
            menuItemPrice=itemView.findViewById(R.id.itemPriceTextView);


        }
    }
}
