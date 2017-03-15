package com.sellnow.model;

import com.sellnow.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Auction {

    private String name;
    private String text;
    private Integer imageDraw;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getImageDraw() {
        return imageDraw;
    }

    public void setImageDraw(Integer imageDraw) {
        this.imageDraw = imageDraw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Auction> getListAuctions(){
        List<Auction> auctions = new ArrayList<>();

        Auction auction1 = new Auction();
        Auction auction2 = new Auction();
        Auction auction3 = new Auction();
        Auction auction4 = new Auction();

        auction1.name = "prod1";
        auction1.text = "Producto 1";
        auction1.imageDraw = R.drawable.auction;
        auctions.add(auction1);

        auction1.name = "prod2";
        auction2.text = "Producto 2";
        auction2.imageDraw = R.drawable.auction;
        auctions.add(auction2);

        auction1.name = "prod3";
        auction3.text = "Producto 3";
        auction3.imageDraw = R.drawable.auction;
        auctions.add(auction3);

        auction1.name = "prod4";
        auction4.text = "Producto 4";
        auction4.imageDraw = R.drawable.auction;
        auctions.add(auction4);

        return auctions;
    }


}
