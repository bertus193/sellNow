package com.sellnow.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.model.Auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionsAdapter extends RecyclerView.Adapter<AuctionsAdapter.ProductsAdapterViewHolder> {

    List<Auction> auctions;
    Context context;

    public AuctionsAdapter(){
        auctions = new ArrayList<>();
    }

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_auction_item, parent, false);
        return new ProductsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsAdapterViewHolder holder, int position) {
        final int finalPosition = position;
        //holder.auctionLayout.setTag(auctions.get(position).getId());
        holder.text.setText(auctions.get(position).getText());
        holder.image.setImageResource(auctions.get(position).getImageDraw());

        holder.auctionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                Bundle b = new Bundle();
                b.putString("fragmentName", "product");
                b.putInt("productID", finalPosition);
                intent.putExtras(b);
                v.getContext().startActivity(intent);

                /*FragmentTransaction ft = ((Activity) context).getFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentProduct().newInstance(finalPosition));
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();*/
            }
        });
    }

    public void addItem(String text, Integer image){
        Auction auction = new Auction();
        auction.setText(text);
        auction.setImageDraw(image);
        auctions.add(auction);
    }

    @Override
    public int getItemCount() {
        return auctions.size();
    }

    public class ProductsAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;
        LinearLayout auctionLayout;
        public ProductsAdapterViewHolder(View itemView) {
            super(itemView);
            auctionLayout = (LinearLayout) itemView.findViewById(R.id.auctionID);
            text = (TextView) itemView.findViewById(R.id.auctionText);
            image = (ImageView) itemView.findViewById(R.id.auctionImage);

        }

    }
}
