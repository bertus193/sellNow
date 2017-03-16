package com.sellnow.model;

import com.sellnow.R;

import java.util.ArrayList;
import java.util.List;

public class Auction {

    private String name;
    private String text;
    private Integer imageDraw;

    public Auction(){}

    public Auction(String name, String text, Integer imageDraw){
        this.name = name;
        this.text = text;
        this.imageDraw = imageDraw;
    }

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
        auction1.text = "Nintendo Switch";
        auction1.imageDraw = R.drawable.auction1;
        auctions.add(auction1);

        auction2.name = "prod2";
        auction2.text = "Play Station 4";
        auction2.imageDraw = R.drawable.auction2;
        auctions.add(auction2);

        auction3.name = "prod3";
        auction3.text = "Xbox One";
        auction3.imageDraw = R.drawable.auction3;
        auctions.add(auction3);

        auction4.name = "prod4";
        auction4.text = "Nintendo 3DS";
        auction4.imageDraw = R.drawable.auction4;
        auctions.add(auction4);

        return auctions;
    }


}
