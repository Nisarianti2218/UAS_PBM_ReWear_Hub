package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NotifikasiActivity : AppCompatActivity() {

    private val TAG = "NotifikasiActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif)

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            Log.d(TAG, "Back button clicked, returning to DashboardPenggunaActivity")
            val intent = Intent(this, DashboardPenggunaActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        profileImage.setOnClickListener {
            Log.d(TAG, "Profile image clicked, opening ChatActivity")
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        Log.d(TAG, "Back pressed, returning to DashboardPenggunaActivity")
        val intent = Intent(this, DashboardPenggunaActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
