package com.example.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Journal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutPage.setOnClickListener {
            val move = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(move)
        }

        binding.rvJournal.setHasFixedSize(true)

        list.addAll(getListJournal())
        showRecyclerList()
    }

    private fun getListJournal(): ArrayList<Journal> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataVolume = resources.getStringArray(R.array.data_volume)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataLink = resources.getStringArray(R.array.data_link)
        val dataImage = resources.obtainTypedArray(R.array.data_image)
        val listJournal = ArrayList<Journal>()
        for (i in dataTitle.indices) {
            val journal = Journal(dataTitle[i], dataVolume[i], dataDesc[i], dataLink[i], dataImage.getResourceId(i, -1))
            listJournal.add(journal)
        }
        return listJournal
    }

    private fun showRecyclerList() {
        val adapter = JournalAdapter(list)
        binding.rvJournal.layoutManager = GridLayoutManager(this, 2)
        binding.rvJournal.adapter = adapter
    }

}