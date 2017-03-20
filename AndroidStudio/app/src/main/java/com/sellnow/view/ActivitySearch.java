package com.sellnow.view;

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

        getSupportActionBar().setTitle("Búsqueda");

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
                text.setText("No existen productos para dicha búsqueda");

                searchLayout.addView(text);
            }
            adapter.setAuctions(auctions);
        }
        else{
            searchTextTitle.setText("No se ha buscado nada");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
