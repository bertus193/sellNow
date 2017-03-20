package com.sellnow.model;

public class Auction {

    private int id;
    private String text;
    private Integer imageDraw;
    private Category category;
    private double txtActualBid;
    private User owner;

    public Auction(){}

    public Auction(int id, String text, Integer imageDraw, Category category, double txtActualBid, User owner){
        this.id = id;
        this.text = text;
        this.imageDraw = imageDraw;
        this.category = category;
        this.txtActualBid = txtActualBid;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
