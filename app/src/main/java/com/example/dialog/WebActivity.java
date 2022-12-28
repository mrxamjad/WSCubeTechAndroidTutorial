package com.example.dialog;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    Button btnSearch;
    EditText edtWebAdrees;
    ProgressBar prossBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);




        //Initialization

        webView= findViewById(R.id.webview);
        btnSearch=findViewById(R.id.btnSearch);
        edtWebAdrees=findViewById(R.id.edtWebAdress);
        prossBar=findViewById(R.id.prossBar);

        //set visibility of progress bar
        prossBar.setVisibility(View.INVISIBLE);

        // get url by textFiled


        //load google as defoult
        webView.loadUrl("https://www.google.com");





//        search on SerchButton Click
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HttpsURL;
                String url=edtWebAdrees.getText().toString();

                if (url.contains("https://" ) | url.contains("http://")){
                    HttpsURL=url;


                    webView.loadUrl(HttpsURL);
                    Toast.makeText(getApplicationContext(),"If exexuted "+HttpsURL, Toast.LENGTH_SHORT).show();
                }else {
                    HttpsURL="https://"+url;


                    webView.loadUrl(HttpsURL);
                    Toast.makeText(getApplicationContext(),"else exexuted"+HttpsURL, Toast.LENGTH_SHORT).show();
                }


            }
        });


        //multiple tab or webpage loading in one activity
        webView.setWebViewClient(new WebViewClient()
        {

            //code for page loading  show Process Bar on loading
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                prossBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                prossBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });






    }

    // On back Press don't close the activity close the tab of web
    @Override
    public void onBackPressed(){
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }





}