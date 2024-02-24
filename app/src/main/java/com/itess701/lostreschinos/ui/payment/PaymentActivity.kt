package com.itess701.lostreschinos.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.itess701.lostreschinos.R
import com.itess701.lostreschinos.ui.paymentconfirmed.PaymentConfirmedActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val btnPay:Button = findViewById(R.id.btnPayPayment)
        btnPay.setOnClickListener {
            val intent = Intent(this, PaymentConfirmedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}