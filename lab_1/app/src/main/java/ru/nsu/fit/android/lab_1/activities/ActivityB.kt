package ru.nsu.fit.android.lab_1.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import ru.nsu.fit.android.lab_1.R

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_b)

        onBackPressedDispatcher.addCallback(this) {
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            finish()
        }
    }

    fun goToC(view: View) {
        val intent = Intent(this, ActivityC::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this) // Создайте объект для анимации
        startActivity(intent, options.toBundle())
    }
}
