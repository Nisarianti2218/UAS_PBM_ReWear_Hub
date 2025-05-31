package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PenilaianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating) // Pastikan file ini ada di res/layout/

        // Inisialisasi view
        val backButton = findViewById<ImageView>(R.id.backButton)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val editTextUlasan = findViewById<EditText>(R.id.editTextUlasan)
        val btnTambahFoto = findViewById<LinearLayout>(R.id.btnTambahFoto)
        val btnKirimUlasan = findViewById<Button>(R.id.btnKirimUlasan)

        // Klik tombol back arrow
        backButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }

        // Klik tombol tambah foto
        btnTambahFoto.setOnClickListener {
            Toast.makeText(this, "Fitur tambah foto belum diimplementasi", Toast.LENGTH_SHORT).show()
        }

        // Klik tombol kirim ulasan
        btnKirimUlasan.setOnClickListener {
            val rating = ratingBar.rating
            val ulasan = editTextUlasan.text.toString()

            // Validasi
            if (rating == 0f) {
                Toast.makeText(this, "Silakan beri rating terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (ulasan.isBlank()) {
                Toast.makeText(this, "Silakan tulis ulasan kamu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kirim data (dummy)
            Toast.makeText(this, "Terima kasih atas penilaian kamu!", Toast.LENGTH_SHORT).show()

            // Kembali ke ProfileActivity setelah kirim
            val intent = Intent(this, ProfileActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }
    }
}
