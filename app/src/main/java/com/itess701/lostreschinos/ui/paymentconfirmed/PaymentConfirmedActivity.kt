package com.itess701.lostreschinos.ui.paymentconfirmed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.itess701.lostreschinos.MainActivity
import com.itess701.lostreschinos.R

class PaymentConfirmedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmed)

        val btnBack:Button = findViewById(R.id.btnHomePaymentConfirmed)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}