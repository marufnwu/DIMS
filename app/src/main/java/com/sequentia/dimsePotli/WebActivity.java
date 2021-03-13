package com.sequentia.dimsePotli;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity
{



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);         //calls the method from super class Activity
        setContentView(R.layout.activity_main2);          //sets the UI
        //the webview inside the second activity xml
        WebView myWebView = (WebView)findViewById(R.id.webview);
        CustomWebViewClient myCustomWebViewClient = new CustomWebViewClient();
        myWebView.setWebViewClient(myCustomWebViewClient);
        myWebView.getSettings().setJavaScriptEnabled(true);
        //get the url from the previous activity
        String url = getIntent().getStringExtra("link");
        myWebView.loadUrl(url);
    }

    private class CustomWebViewClient extends WebViewClient implements com.sequentia.dimsePotli.CustomWebViewClient {
        @Override
        /**
         * Take control over the loaded url so the url is open in the current Webview and not by the OS browser
         */
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    }

}