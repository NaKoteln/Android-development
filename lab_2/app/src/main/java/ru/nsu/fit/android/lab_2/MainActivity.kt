package ru.nsu.fit.android.lab_2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.android.lab_2.adapter.SongAdapter
import ru.nsu.fit.android.lab_2.data.songsList

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: Activity created")

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        Log.d(TAG, "onCreate: Songs list size: ${songsList.size}")

        recyclerView.adapter = SongAdapter(songsList)
    }
}
