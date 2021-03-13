package com.sequentia.dimsePotli;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.drawerlayout.widget.DrawerLayout;

import com.sequentia.dimsePotli.Models.Shop;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private Object Uri;

    public List<Shop> shopList = new ArrayList<>();
    private DrawerLayout drawer;
    private ActionBarDrawerToggle  toggle;
    private NavigationView navView;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));

        builder.setShowTitle(true);
        CustomTabsIntent customTabsIntent = builder.build();



        buildShopItem();
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener((OnItemClickListener) (parent, v, position, id) -> {
//            Intent intent = new Intent(this, WebActivity.class);
//            intent.putExtra("link", shopList.get(position).getUrl());
//            startActivity(intent);

            customTabsIntent.launchUrl(this, android.net.Uri.parse(shopList.get(position).getUrl()));
        }
        );

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_item_share){
                    shareApp();
                }
                return true;
            }
        });

    }

    private void shareApp() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "DIMS ePotli");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }

    private void buildShopItem() {

        Shop shop = new Shop("Amazon", "https://www.amazon.in", R.drawable.amazon);
        shopList.add(shop);

         shop = new Shop("Flipkart", "https://www.flipkart.com", R.drawable.flipkart);
        shopList.add(shop);

         shop = new Shop("TataCliq", "https://www.tatacliq.com", R.drawable.tatacliq);
        shopList.add(shop);

         shop = new Shop("Myntra", "https://www.myntra.com", R.drawable.myntra);
        shopList.add(shop);

        shop = new Shop("Ajio", "https://www.ajio.com", R.drawable.ajio);
        shopList.add(shop);

        shop = new Shop("Zivame", "https://www.zivame.com", R.drawable.zivame);
        shopList.add(shop);

        shop = new Shop("Zomato", "https://www.zomato.com/ncr", R.drawable.zomato);
        shopList.add(shop);

        shop = new Shop("Swiggy", "https://www.swiggy.com", R.drawable.swiggy);
        shopList.add(shop);

        shop = new Shop("Dominos", "https://m.dominos.com.bd", R.drawable.dominos);
        shopList.add(shop);

        shop = new Shop("Paytm", "https://paytm.com", R.drawable.paytm);
        shopList.add(shop);

        shop = new Shop("PhonePe", "https://www.phonepe.com", R.drawable.phone_pe);
        shopList.add(shop);

        shop = new Shop("Bigbasket", "https://www.bigbasket.com", R.drawable.big_basket);
        shopList.add(shop);

        shop = new Shop("Grofers", "https://grofers.com", R.drawable.grofers);
        shopList.add(shop);

        shop = new Shop("Makemytrip", "https://www.makemytrip.com", R.drawable.makemytrip);
        shopList.add(shop);

        shop = new Shop("Goibibo", "https://www.goibibo.com", R.drawable.goibibo);
        shopList.add(shop);

        shop = new Shop("Lenskart", "https://www.lenskart.com", R.drawable.lenskart);
        shopList.add(shop);

        shop = new Shop("OLA", "https://www.olacabs.com", R.drawable.ola);
        shopList.add(shop);

        shop = new Shop("UBER", "https://www.uber.com/in/en", R.drawable.ubar);
        shopList.add(shop);

        shop = new Shop("Zoomcar", "https://www.zoomcar.com/", R.drawable.zoomcar);
        shopList.add(shop);

        shop = new Shop("Bookmyshow", "https://in.bookmyshow.com", R.drawable.bookmyshow);
        shopList.add(shop);

        shop = new Shop("Cult.fit", "https://www.cure.fit", R.drawable.cult_fit);
        shopList.add(shop);

        shop = new Shop("Decathlon", "https://www.decathlon.in", R.drawable.decathlon);
        shopList.add(shop);

    }

    public class ImageAdapter extends BaseAdapter{
        private Context context; // Context class object - context

        public ImageAdapter(Context c)
        {
            context = c;
        }

        //return number of images
        public int getCount()
        {
            return shopList.size();
        }

        public Object getItem(int position)     // return type of getItem method is an Object
        {
            return position;
        }

        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent){

            View view = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);

            ImageView img = view.findViewById(R.id.img);
            TextView name = view.findViewById(R.id.name);

            img.setImageResource(shopList.get(position).getImgId());
            name.setText(shopList.get(position).name);


            return  view;

        }
    }
}