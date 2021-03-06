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
    private List<Category> categories;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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

        categories = new ArrayList<>();
        this.addCategory(new Category("Consolas"));
        this.addCategory(new Category("Componentes"));
        this.addCategory(new Category("Smartphones"));

        users = new ArrayList<>();
        this.addUser(new User("admin", "admin", "richard@gnu.com",   "Richard Stallman"));
        this.addUser(new User("root" , "root",  "root@internet.com", "R2D2"));

        auctions = new ArrayList<>();
        this.addAuction(new Auction(1, "Nintendo Switch", R.drawable.auction1, categories.get(0), 290.0, users.get(0)));
        this.addAuction(new Auction(2, "Play Station 4" , R.drawable.auction2, categories.get(0), 250.0, users.get(1)));
        this.addAuction(new Auction(3, "Xbox One"       , R.drawable.auction3, categories.get(0), 250.0, users.get(0)));
        this.addAuction(new Auction(4, "Nintendo 3DS"   , R.drawable.auction4, categories.get(0), 150.0, users.get(0)));

    }

    public void addAuction(Auction auction){
        auctions.add(auction);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addCategory(Category category){
        categories.add(category);
    }


    public User getUserByNamePass(String username, String pass){
        User out = null;
        for(User user : users){
            if(user.getUser().equals(username) && user.getPass().equals(pass)){
                out = user;
            }
        }
        return out;
    }

    public Category getCategoryByName(String name){
        Category out = null;
        for(Category category : categories){
            if(category.getName().equals(name)){
                out = category;
            }
        }
        return out;
    }

    public List<String> getStringCategories(){
        List<String> out = new ArrayList<>();
        for(Category category : categories){
            out.add(category.getName());
        }
        return out;

    }

    public List<Auction> getAuctionsByCategory(Category category){
        List<Auction> out = new ArrayList<>();
        for(Auction auction : auctions){
            if(auction.getCategory().getName() == category.getName()){
                out.add(auction);
            }
        }
        return out;
    }

    public List<Auction> getAuctionsByAuctionText(String auctionText){
        List<Auction> out = new ArrayList<>();
        for(Auction auction : auctions){
            if(auction.getText().toLowerCase().contains(auctionText.toLowerCase())){
                out.add(auction);
            }
        }
        return out;
    }

    public User getUserByName(String name){
        User out = null;
        for(User user : users){
            if(user.getUser().equals(name)){
                out = user;
            }
        }
        return out;
    }

    public List<Auction> getAuctionsByuser(User user){
        List<Auction> out = new ArrayList<>();
        for(Auction auction : auctions){

            if(auction.getOwner().getUser() == user.getUser()){
                System.out.println(auction.getOwner().getUser() + " "+ user.getUser());
                out.add(auction);
            }
        }
        return out;
    }

    public Auction getAuctionById(int id){
        Auction out = null;
        for(Auction auction : auctions){
            if(auction.getId() == id){
                out = auction;
            }
        }

        return out;
    }
}
