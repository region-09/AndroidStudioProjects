package com.example.webpages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker possibilities;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilities = (NumberPicker) findViewById(R.id.numberpicker_main_picker);
        webView = (WebView) findViewById(R.id.web);

        String[] possibleStrings = {
                "Android",
                "Coursera",
                "Udemy"
        };
        possibilities.setDisplayedValues(possibleStrings);
        possibilities.setMinValue(0);
        possibilities.setMaxValue(possibleStrings.length - 1);

    }
    public void navigate(View v) {
        int choice = possibilities.getValue();
        if (choice == 0) {
            //webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://android.com");
        }else if (choice == 1) {
            webView.loadUrl("https://coursera.org");
        }else if (choice == 2) {
            webView.loadUrl("https://udemy.com");
        }
    }
}