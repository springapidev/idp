package com.codebd.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
WebView webView;
EditText editUrl;
Button btnHit;
ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webView);
        editUrl=findViewById(R.id.editUrl);
        btnHit=findViewById(R.id.btnHit);
        progressBar=findViewById(R.id.progressBar);
        WebViewClient webViewClient=new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
              editUrl.setText(url);
               editUrl.setText(webView.getUrl());
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progressBar.setVisibility(View.GONE);
            }
        };
        webView.setWebViewClient(webViewClient);
      //  progressBar.setVisibility(View.GONE);
        final WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        System.out.println("===========================My URL:====================================================================== "+editUrl.getText().toString());
        webView.loadUrl("https://google.com");

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editUrl.getText().toString();
                if (url.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter an url",Toast.LENGTH_SHORT).show();
                }else {
//                    String reqex="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!;,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
//                    Pattern pattern = Pattern.compile(reqex);
//                    Matcher matcher = pattern.matcher(url);
//                    if(matcher.matches()){
//                        webView.loadUrl(url);
//                    }else {
//                        webView.loadUrl("https://www.google.com/search?q="+url);
//                    }
                    webView.loadUrl(url);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
