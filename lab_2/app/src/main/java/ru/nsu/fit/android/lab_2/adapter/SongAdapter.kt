package ru.nsu.fit.android.lab_2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.android.lab_2.R
import ru.nsu.fit.android.lab_2.model.Song

class SongAdapter(private val songs: List<Song>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private val TAG = "SongAdapter"

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.song_title)
        val artist: TextView = view.findViewById(R.id.song_artist)
        val playIcon: ImageView = view.findViewById(R.id.icon_play)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        Log.d(TAG, "onCreateViewHolder: Creating view holder for song")
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.title.text = song.title
        holder.artist.text = song.artist

        Log.d(TAG, "onBindViewHolder: Binding song at position $position - ${song.title}")

        var currentToast: Toast? = null

        holder.playIcon.setOnClickListener {
            val message = "Playing: ${song.title}"

            Log.d(TAG, "onBindViewHolder: Play icon clicked for song: ${song.title}")

            if (currentToast != null) {
                Log.d(TAG, "onBindViewHolder: Cancelling previous toast")
                currentToast?.cancel()
            }

            val inflater = LayoutInflater.from(holder.itemView.context)
            val layout = inflater.inflate(R.layout.toast_layout, null)

            val toastMessage: TextView = layout.findViewById(R.id.toast_message)
            toastMessage.text = message

            currentToast = Toast(holder.itemView.context)
            currentToast?.duration = Toast.LENGTH_SHORT
            currentToast?.view = layout
            currentToast?.show()

            Log.d(TAG, "onBindViewHolder: New toast shown for song: ${song.title}")
        }
    }

    override fun getItemCount(): Int = songs.size
}
