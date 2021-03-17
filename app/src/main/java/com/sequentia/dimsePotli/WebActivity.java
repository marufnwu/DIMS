package com.sequentia.dimsePotli;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import im.delight.android.webview.AdvancedWebView;

public class WebActivity extends Activity implements AdvancedWebView.Listener {

    AdvancedWebView mWebView;
    ImageView imgBack;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mWebView = findViewById(R.id.webview);
        imgBack = findViewById(R.id.imgBack);
        CustomWebViewClient myCustomWebViewClient = new CustomWebViewClient();
        mWebView.setWebViewClient(myCustomWebViewClient);
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (!TextUtils.isEmpty(title)) {
                    WebActivity.this.setTitle(title);
                }
            }
        });
        mWebView.setMixedContentAllowed(false);
        mWebView.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getStringExtra("link");
        mWebView.loadUrl(url);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) { }

    @Override
    public void onPageFinished(String url) { }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) { }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }


    private class CustomWebViewClient extends WebViewClient implements com.sequentia.dimsePotli.CustomWebViewClient {
        @Override
        /**
         * Take control over the loaded url so the url is open in the current Webview and not by the OS browser
         */
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            WebActivity.this.setTitle(view.getTitle());
        }

    }

}