package com.sellnow.model;

public class Auction {

    private String name;
    private String text;
    private Integer imageDraw;

    public Auction(){}

    public Auction(String text, Integer imageDraw){
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


}
