package com.example.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SecondActivity : AppCompatActivity() {

    lateinit var webview:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        webview=findViewById(R.id.web)

        webview.loadUrl("https://www.tops-int.com")

    }
}