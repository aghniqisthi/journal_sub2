package com.example.news

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.news.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val data = intent.getParcelableExtra<Journal>("data")

        Log.d("get detail data", data!!.title)
        showSelectedItem(data)

        binding.iconShare.setOnClickListener{
            shareData(data)
        }
    }

    private fun shareData(journal: Journal) {
        val number = +6282231474110
        val pindah = Intent(Intent.ACTION_VIEW)
        pindah.data = Uri.parse(String.format("https://api.whatsapp.com/send?phone=$number&text="+"Read these following journal \"${journal.title}\" by clicking this link ${journal.link}"))
        startActivity(pindah)
    }

    private fun showSelectedItem(journal: Journal) {
        binding.apply {
            txtDetailTitle.text = journal.title
            txtDetailVol.text = journal.volume
            txtDetailDesc.text = journal.desc
            txtDetailLink.text = journal.link
            imgDetailCover.setImageResource(journal.image)
        }
    }
}