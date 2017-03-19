package com.sellnow.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.sellnow.MainActivity;
import com.sellnow.R;
import com.sellnow.model.SellNow;

public class CategoriesItemActivity extends AppCompatActivity {

    public SellNow sellNowContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Calling SellNow class (see application tag in AndroidManifest.xml)
        this.sellNowContext = (SellNow) getApplicationContext();

        Bundle vars = getIntent().getExtras();

        String category = "";
        if(vars != null)
            category = vars.getString("category");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
