package com.itess701.lostreschinos.ui.products

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.itess701.lostreschinos.R
import com.itess701.lostreschinos.models.Product

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var imageViewProduct:ImageView
    lateinit var textViewTitle:TextView
    lateinit var textViewCode:TextView
    lateinit var textViewPrice:TextView
    lateinit var textViewDescription:TextView
    lateinit var tableCharacteristics:TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        // Obtén el objeto Product de algún lugar (puede ser un Intent, ViewModel, etc.)
        val product = intent.getSerializableExtra("product") as Product

        imageViewProduct = findViewById(R.id.imageViewProduct)
        textViewTitle = findViewById(R.id.textViewTitle)
        textViewCode = findViewById(R.id.textViewCode)
        textViewPrice = findViewById(R.id.textViewPrice)
        textViewPrice = findViewById(R.id.textViewPrice)
        textViewDescription = findViewById(R.id.textViewDescription)
        tableCharacteristics = findViewById(R.id.tableLayoutCharacteristics)

        // Llena la vista con los datos del producto

        imageViewProduct.setImageResource(product.image)
        textViewTitle.text = product.title
        textViewCode.text = "Código: ${product.code}"
        textViewPrice.text = "Precio: $${product.price}"
        textViewDescription.text = product.description

        // Llena la tabla de características
        product.characteristics.forEach {
            addCharacteristicRow(it.first, it.second)
        }
    }

    var color:Boolean = false
    private fun addCharacteristicRow(characteristic: String, value: String) {
        val row = TableRow(this)
        // Obtén el valor en píxeles para 16dp
        val paddingInDp = 10
        val scale = resources.displayMetrics.density
        val paddingInPx = (paddingInDp * scale + 0.5f).toInt()
        // Establece el relleno en píxeles en la fila
        row.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx)
        if(color) {
            row.background = getDrawable(R.drawable.row_selector)
            color = false
        } else {
            row.background = getDrawable(R.drawable.row_selector2)
            color = true
        }
        val characteristicView = TextView(this)
        val valueView = TextView(this)

        characteristicView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        characteristicView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
        characteristicView.setTextColor(Color.BLACK)
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        valueView.setTextColor(Color.BLACK)

        characteristicView.text = characteristic
        valueView.text = value

        row.addView(characteristicView)
        row.addView(valueView)

        tableCharacteristics.addView(row)
    }
}