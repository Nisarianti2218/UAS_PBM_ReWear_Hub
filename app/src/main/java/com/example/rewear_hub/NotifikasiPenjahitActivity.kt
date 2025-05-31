package com.example.rewear_hub

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NotifikasiPenjahitActivity : AppCompatActivity() {

    private var backButton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif_penjahit)

        backButton = findViewById(R.id.backButton)

        backButton?.setOnClickListener {
            finish()
        }
    }
}
