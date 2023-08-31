package com.example.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val back : ImageView = findViewById(R.id.icon_back)
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}