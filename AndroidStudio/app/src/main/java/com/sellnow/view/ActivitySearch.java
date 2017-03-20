package com.sellnow.view;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sellnow.R;
import com.sellnow.controller.AuctionsAdapter;
import com.sellnow.model.Auction;
import com.sellnow.model.Category;
import com.sellnow.model.SellNow;

import java.util.ArrayList;
import java.util.List;

public class ActivitySearch extends AppCompatActivity {

    public SellNow sellNowContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Calling SellNow class (see application tag in AndroidManifest.xml)
        this.sellNowContext = (SellNow) getApplicationContext();

        Bundle vars = getIntent().getExtras();

        TextView searchTextTitle = (TextView) findViewById(R.id.searchedText);

        String searchedText = "";
        String errMsg = "";

        if(vars != null) {
            List<Auction> auctions = new ArrayList<>();
            searchedText = vars.getString("searchText");
            searchTextTitle.setText("Buscar: " + searchedText);

            RecyclerView auctionRecyclerView = (RecyclerView) findViewById(R.id.productList);
            auctionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            AuctionsAdapter adapter = new AuctionsAdapter();
            auctionRecyclerView.setAdapter(adapter);

            auctions = sellNowContext.getAuctionsByAuctionText(searchedText);

            if(auctions.size() == 0) {
                errMsg = "No existen productos para esta categoría";
            }
            if(!errMsg.isEmpty()){
                LinearLayout searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
                TextView text =new TextView(this);
                text.setGravity(Gravity.CENTER);
                text.setText("No existen productos para esta categoría");

                searchLayout.addView(text);
            }
            for(int i = 0; i< auctions.size(); i++){
                Auction auction = auctions.get(i);
                adapter.addItem(auction.getText(), auction.getImageDraw());
            }
        }
        else{
            searchTextTitle.setText("Ninguna categoría seleccionada");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
