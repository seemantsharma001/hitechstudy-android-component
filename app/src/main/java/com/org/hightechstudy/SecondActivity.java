package com.org.hightechstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends ParentActivity {

    private WebView webView;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_second);
        webView = findViewById(R.id.wvVideo);
        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webSetting.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.ndtv.com/india-news/sushant-singh-rajput-death-cbi-in-mumbai-questions-sushant-singh-rajputs-staff-member-meets-cops-2282958");
    }
}