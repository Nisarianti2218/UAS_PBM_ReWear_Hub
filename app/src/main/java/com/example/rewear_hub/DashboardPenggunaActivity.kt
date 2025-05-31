package com.example.rewear_hub

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardPenggunaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tailorAdapter: TailorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_pengguna)

        recyclerView = findViewById(R.id.recyclerViewTailors)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val tailorList = listOf(
            Tailor("Taylor Custom", 4.9, "Banda Aceh", R.drawable.tailor1),
            Tailor("Signature Tailor", 3.9, "Medan", R.drawable.tailor2),
            Tailor("Tailor Lab", 4.6, "Medan", R.drawable.tailor3),
            Tailor("Royal Threads", 4.5, "Banda Aceh", R.drawable.tailor4),
            Tailor("Elegant Stitch", 4.8, "Jakarta", R.drawable.tailor5),
            Tailor("Perfect Fit", 4.7, "Bandung", R.drawable.tailor6),
            Tailor("Custom Couture", 4.9, "Surabaya", R.drawable.tailor7),
            Tailor("Stitch Masters", 4.6, "Yogyakarta", R.drawable.tailor8)
        )

        tailorAdapter = TailorAdapter(tailorList) { selectedTailor ->
            if (selectedTailor.name == "Taylor Custom") {
                val intent = Intent(this, TokoActivity::class.java)
                intent.putExtra("tailor_data", selectedTailor)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Hanya 'Taylor Custom' yang bisa dibuka", Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView.adapter = tailorAdapter
    }
}