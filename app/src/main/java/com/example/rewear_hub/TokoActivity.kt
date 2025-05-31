package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class TokoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toko)

        val tailor = intent.getParcelableExtra<Tailor>("tailor_data")

        val headerImage: ImageView = findViewById(R.id.headerImage)
        val titleText: TextView = findViewById(R.id.tailorTitle)
        val subtitleText: TextView = findViewById(R.id.tailorSubtitle)
        val backButton: ImageButton = findViewById(R.id.backButton)
        val chatButton: ImageButton = findViewById(R.id.chatButton)
        val perbaikanLayout: CardView = findViewById(R.id.perbaikanLayout)

        // Set data tailor
        tailor?.let {
            headerImage.setImageResource(it.imageResId)
            titleText.text = it.name
            subtitleText.text = it.location
        }

        // Back button
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardPenggunaActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Chat button -> ke NotifikasiActivity
        chatButton.setOnClickListener {
            val intent = Intent(this, NotifikasiActivity::class.java)
            startActivity(intent)
        }

        // Perbaikan
        perbaikanLayout.setOnClickListener {
            val intent = Intent(this, CustomRequestActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.nav_home

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_notification -> {
                    Toast.makeText(this, "Halaman Notifikasi belum tersedia", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

}
