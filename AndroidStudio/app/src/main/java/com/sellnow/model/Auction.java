package com.sellnow.model;

public class Auction {

    private String name;
    private String text;
    private Integer imageDraw;
    private Category category;
    private double txtActualBid;

    public Auction(){}

    public Auction(String text, Integer imageDraw, Category category, double txtActualBid){
        this.text = text;
        this.imageDraw = imageDraw;
        this.category = category;
        this.txtActualBid = txtActualBid;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getActualBid() {
        return txtActualBid;
    }

    public void setActualBid(double txtActualBid) {
        this.txtActualBid = txtActualBid;
    }
}
