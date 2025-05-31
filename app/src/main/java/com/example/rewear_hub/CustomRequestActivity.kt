package com.example.rewear_hub

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CustomRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_request)

        // Spinner options
        val pengirimanOptions = arrayOf("Pilih Metode Pengiriman", "JNE", "J&T", "POS", "Gojek")
        val pembayaranOptions = arrayOf("Pilih Metode Pembayaran", "Transfer Bank", "COD", "E-Wallet")

        val spinnerPengiriman = findViewById<Spinner>(R.id.spinnerPengiriman)
        val spinnerPembayaran = findViewById<Spinner>(R.id.spinnerPembayaran)
        val backIcon = findViewById<ImageView>(R.id.back_icon)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Setup spinner adapter
        val adapterPengiriman = ArrayAdapter(this, android.R.layout.simple_spinner_item, pengirimanOptions)
        adapterPengiriman.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPengiriman.adapter = adapterPengiriman

        val adapterPembayaran = ArrayAdapter(this, android.R.layout.simple_spinner_item, pembayaranOptions)
        adapterPembayaran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPembayaran.adapter = adapterPembayaran

        // Back icon click listener - kembali ke halaman sebelumnya
        backIcon.setOnClickListener {
            finish()  // menutup activity ini dan kembali ke activity sebelumnya
        }

        // Submit button listener (contoh sederhana)
        submitButton.setOnClickListener {
            val description = findViewById<EditText>(R.id.editTextDescription).text.toString()
            val pengiriman = spinnerPengiriman.selectedItem.toString()
            val pembayaran = spinnerPembayaran.selectedItem.toString()

            // Contoh validasi sederhana
            if (description.isBlank()) {
                Toast.makeText(this, "Harap isi deskripsi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pengiriman == pengirimanOptions[0]) {
                Toast.makeText(this, "Pilih metode pengiriman", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pembayaran == pembayaranOptions[0]) {
                Toast.makeText(this, "Pilih metode pembayaran", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Lakukan aksi submit data ke backend atau simpan lokal dsb.
            Toast.makeText(this, "Permintaan terkirim!", Toast.LENGTH_SHORT).show()

            // Jika sudah submit, bisa tutup activity atau reset form
            finish()
        }
    }
}
