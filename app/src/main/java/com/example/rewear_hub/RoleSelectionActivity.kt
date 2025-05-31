package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class RoleSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role_selection)

        val btnPenjahit = findViewById<LinearLayout>(R.id.btnPenjahit)
        val btnKonsumen = findViewById<LinearLayout>(R.id.btnKonsumen)

        btnPenjahit.setOnClickListener {
            val intent = Intent(this, RegisterPenjahitActivity::class.java)
            startActivity(intent)
        }

        btnKonsumen.setOnClickListener {
            val intent = Intent(this, RegisterKonsumenActivity::class.java)
            startActivity(intent)
        }
    }
}
