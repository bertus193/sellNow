package com.sellnow.model;

import com.sellnow.R;

import java.util.ArrayList;
import java.util.List;
import android.app.Application;
import android.content.Context;

/**
 * Created by albertoricogarcia on 17/3/17.
 */

public class SellNow extends Application {

    private static Context mContext;
    private List<User> users;
    private List<Auction> auctions;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initSellNow();
        mContext = getApplicationContext();
    }

    public void initSellNow(){
        auctions = new ArrayList<>();
        this.addAuction(new Auction("Nintendo Switch", R.drawable.auction1));
        this.addAuction(new Auction("Play Station 4" , R.drawable.auction2));
        this.addAuction(new Auction("Xbox One"       , R.drawable.auction3));
        this.addAuction(new Auction("Nintendo 3DS"   , R.drawable.auction4));

        //users = new ArrayList<>();
    }

    public void addAuction(Auction auction){
        auctions.add(auction);
    }
}
