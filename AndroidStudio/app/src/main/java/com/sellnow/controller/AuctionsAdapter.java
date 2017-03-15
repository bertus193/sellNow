package com.sellnow.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sellnow.R;
import com.sellnow.model.Auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionsAdapter extends RecyclerView.Adapter<AuctionsAdapter.ProductsAdapterViewHolder> {

    List<Auction> auctions;

    public AuctionsAdapter(){
        auctions = new ArrayList<>();
    }

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_auction_item, parent, false);
        return new ProductsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsAdapterViewHolder holder, int position) {
        holder.auctionID.setId(position);
        holder.text.setText(auctions.get(position).getText());
        holder.image.setImageResource(auctions.get(position).getImageDraw());
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
        LinearLayout auctionID;
        public ProductsAdapterViewHolder(View itemView) {
            super(itemView);
            auctionID = (LinearLayout) itemView.findViewById(R.id.auctionID);
            text = (TextView) itemView.findViewById(R.id.auctionText);
            image = (ImageView) itemView.findViewById(R.id.auctionImage);

        }

    }
}
