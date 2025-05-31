package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var ivChat: ImageView
    private lateinit var ivSettings: ImageView

    private lateinit var llStatusPermintaan: LinearLayout
    private lateinit var llBelumBayar: LinearLayout
    private lateinit var llProgresJahitan: LinearLayout
    private lateinit var llBeriPenilaian: LinearLayout
    private lateinit var llPengaturanPengiriman: LinearLayout

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Inisialisasi View
        ivBack = findViewById(R.id.iv_back)
        ivChat = findViewById(R.id.iv_chat)
        ivSettings = findViewById(R.id.iv_settings)

        llStatusPermintaan = findViewById(R.id.ll_status_permintaan)
        llBelumBayar = findViewById(R.id.ll_belum_bayar)
        llProgresJahitan = findViewById(R.id.ll_progres_jahitan)
        llBeriPenilaian = findViewById(R.id.ll_beri_penilaian)
        llPengaturanPengiriman = findViewById(R.id.ll_pengaturan_pengiriman)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Tombol back arrow
        ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Tombol chat
        ivChat.setOnClickListener {
            Toast.makeText(this, "Fitur Chat belum tersedia", Toast.LENGTH_SHORT).show()
        }

        // Tombol settings
        ivSettings.setOnClickListener {
            Toast.makeText(this, "Pengaturan dibuka", Toast.LENGTH_SHORT).show()
        }

        // Click listener untuk beberapa fitur
        llStatusPermintaan.setOnClickListener {
            Toast.makeText(this, "Status Permintaan", Toast.LENGTH_SHORT).show()
        }

        llBelumBayar.setOnClickListener {
            Toast.makeText(this, "Belum Bayar", Toast.LENGTH_SHORT).show()
        }

        llProgresJahitan.setOnClickListener {
            Toast.makeText(this, "Progres Jahitan", Toast.LENGTH_SHORT).show()
        }

        llBeriPenilaian.setOnClickListener {
            // Buka RatingActivity saat diklik
            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
        }

        llPengaturanPengiriman.setOnClickListener {
            Toast.makeText(this, "Pengaturan Pengiriman", Toast.LENGTH_SHORT).show()
        }

        // Bottom navigation
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, TokoActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_notification -> {
                    Toast.makeText(this, "Notifikasi", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profile -> {
                    // Sudah di halaman profil
                    true
                }
                else -> false
            }
        }

        // Set profil sebagai menu aktif
        bottomNavigation.selectedItemId = R.id.nav_profile
    }
}
