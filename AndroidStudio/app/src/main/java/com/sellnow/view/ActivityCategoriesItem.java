package com.sellnow.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.controller.AuctionsAdapter;
import com.sellnow.model.Auction;
import com.sellnow.model.Category;
import com.sellnow.model.SellNow;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategoriesItem extends AppCompatActivity {

    public SellNow sellNowContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_item);
        //Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Ver Categoría");

        // Calling SellNow class (see application tag in AndroidManifest.xml)
        this.sellNowContext = (SellNow) getApplicationContext();

        Bundle vars = getIntent().getExtras();

        TextView categoryActivityName = (TextView) findViewById(R.id.categoryActivityName);

        String categoryName = "";
        String errMsg = "";

        if(vars != null) {
            List<Auction> auctions = new ArrayList<>();
            categoryName = vars.getString("category");
            categoryActivityName.setText(categoryName);

            RecyclerView auctionRecyclerView = (RecyclerView) findViewById(R.id.productList);
            auctionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            AuctionsAdapter adapter = new AuctionsAdapter();
            auctionRecyclerView.setAdapter(adapter);

            Category category = sellNowContext.getCategoryByName(categoryName);

            if(category == null){
                errMsg = "Dicha categoría no existe";
            }
            else{
                auctions = sellNowContext.getAuctionsByCategory(category);
            }

            if(auctions.size() == 0) {
                errMsg = "No existen productos para esta categoría";
            }
            if(!errMsg.isEmpty()){
                LinearLayout categoriesLayout = (LinearLayout) findViewById(R.id.categoriesLayout);
                TextView text =new TextView(this);
                text.setGravity(Gravity.CENTER);
                text.setText("No existen productos para esta categoría");

                categoriesLayout.addView(text);
            }
            for(int i = 0; i< auctions.size(); i++){
                Auction auction = auctions.get(i);
                adapter.addItem(auction.getText(), auction.getImageDraw());
            }
        }
        else{
            categoryActivityName.setText("Ninguna categoría seleccionada");
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
