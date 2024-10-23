package ru.nsu.fit.android.lab_1.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import ru.nsu.fit.android.lab_1.R

class ActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_c)
    }

    fun goToA(view: View) {
        val intent = Intent(this, ActivityA::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
        startActivity(intent, options.toBundle())
    }

}
