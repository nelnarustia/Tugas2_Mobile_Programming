package com.example.tugas2webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    lateinit var wvMain : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wvMain = findViewById(R.id.wvMain)

        wvMain.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }

        }



    }
    override fun onCreateOptionsMenu(menu:Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_unissula -> {
                wvMain.clearCache(true)
                wvMain.loadUrl("https://unissula.ac.id/")
                true
            }
            R.id.menu_republika -> {
                wvMain.clearCache(true)
                wvMain.loadUrl("https://www.republika.co.id/")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}