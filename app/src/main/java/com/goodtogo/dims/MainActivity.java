package com.goodtogo.dims;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goodtogo.dims.Models.Shop;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    // Images to display-----------------------//
//    Integer[] imageIds =    {R.drawable.aliexpress,R.drawable.amazon,R.drawable.aliexpress,
//            R.drawable.amazon,R.drawable.aliexpress,R.drawable.amazon};
    private Object Uri;

    public List<Shop> shopList = new ArrayList<>();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); //calls the method from super class Activity
        setContentView(R.layout.activity_main);          //sets the UI
        buildShopItem();
        GridView gridView = (GridView) findViewById(R.id.gridview);// Bring gridView into context from main.xml
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener((OnItemClickListener) (parent, v, position, id) -> {
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra("link", shopList.get(position).getUrl());
            startActivity(intent);
        }
        );  //setOnItemClickListener declaration ends here.

    }  //onCreate() ends here.

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

    public class ImageAdapter extends BaseAdapter
    {
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

        //returns an ImageView view--------------
        public View getView(int position, View convertView, ViewGroup parent)
        {
//            ImageView imageView;
//            TextView name;
//            if(convertView == null)
//            {
//                imageView = new ImageView(context);
//                imageView.setLayoutParams(new GridView.LayoutParams(270, 270));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(10, 10, 10, 10);
//            }
//
//            else
//            {
//                imageView = (ImageView) convertView;
//            }
//            imageView.setImageResource(shopList.get(position).getImgId());
//            return imageView;





            View view = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);

            ImageView img = view.findViewById(R.id.img);
            TextView name = view.findViewById(R.id.name);

            img.setImageResource(shopList.get(position).getImgId());
            name.setText(shopList.get(position).name);


            return  view;

        }
    }
}