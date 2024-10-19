package ru.nsu.fit.android.lab_1.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import ru.nsu.fit.android.lab_1.R

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_a)
    }

    fun goToB(view: View) {
        val intent = Intent(this, ActivityB::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this) // Создайте объект для анимации
        startActivity(intent, options.toBundle())
    }

}