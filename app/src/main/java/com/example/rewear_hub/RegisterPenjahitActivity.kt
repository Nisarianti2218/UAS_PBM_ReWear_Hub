package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterPenjahitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_penjahit)

        val backButton = findViewById<ImageView>(R.id.backButton)
        val daftarButton = findViewById<Button>(R.id.daftarButton)
        val masukLink = findViewById<TextView>(R.id.masukLink)

        backButton.setOnClickListener {
            // Kembali ke halaman Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        daftarButton.setOnClickListener {
            // Setelah daftar, langsung ke halaman MainPenjahitActivity
            val intent = Intent(this, MainPenjahitActivity::class.java)
            startActivity(intent)
            finish()
        }

        masukLink.setOnClickListener {
            // Jika klik teks masuk, langsung ke halaman Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
