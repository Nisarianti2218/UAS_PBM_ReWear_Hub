package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView

class MainPenjahitActivity : AppCompatActivity() {

    private lateinit var backButton: ImageButton
    private lateinit var settingIcon: ImageView
    private lateinit var chatIcon: ImageView
    private lateinit var profileImage: ShapeableImageView
    private lateinit var profileName: TextView
    private lateinit var profileRole: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_penjahit)

        // Inisialisasi semua view
        backButton = findViewById(R.id.backButton)
        settingIcon = findViewById(R.id.setting_icon)
        chatIcon = findViewById(R.id.chat_icon)
        profileImage = findViewById(R.id.profile_image)
        profileName = findViewById(R.id.profile_name)
        profileRole = findViewById(R.id.profile_role)
        progressBar = findViewById(R.id.progress_bar)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Aksi tombol kembali
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Aksi tombol pengaturan
        settingIcon.setOnClickListener {
            Toast.makeText(this, "Pengaturan dibuka", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, PengaturanActivity::class.java))
        }

        // Aksi tombol chat -> pindah ke NotifikasiPenjahitActivity
        chatIcon.setOnClickListener {
            val intent = Intent(this, NotifikasiPenjahitActivity::class.java)
            startActivity(intent)
        }

        // Bottom navigation item listener
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Beranda", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_notification -> {
                    val intent = Intent(this, NotifikasiPenjahitActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profil", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // Contoh: mengatur nilai progress bar (bisa diganti dengan data real)
        progressBar.progress = 70
    }
}
