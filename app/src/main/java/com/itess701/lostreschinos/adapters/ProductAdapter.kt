package com.itess701.lostreschinos.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itess701.lostreschinos.R
import com.itess701.lostreschinos.models.Product
import com.itess701.lostreschinos.ui.payment.PaymentActivity
import com.itess701.lostreschinos.ui.products.ProductDetailsActivity

class ProductAdapter(private val context: Context, private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        // Establecer los datos del producto en la tarjeta
        holder.imageViewProduct.setImageResource(product.image)
        holder.textViewTitle.text = product.title
        holder.textViewCode.text = "Código: ${product.code}"
        holder.textViewPrice.text = "Precio: $${product.price}"

        // Configurar clics de botones
        holder.btnAddToCart.setOnClickListener {
            // Lógica para agregar al carrito
        }

        holder.btnBuyNow.setOnClickListener {
            // Lógica para comprar ahora
            val intent = Intent(context, PaymentActivity::class.java)
            context.startActivity(intent)
        }

        holder.itemView.setOnClickListener {
            // Lógica al tocar tarjeta
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProduct: ImageView = itemView.findViewById(R.id.imgProductCart)
        val textViewTitle: TextView = itemView.findViewById(R.id.tvNameProductCart)
        val textViewCode: TextView = itemView.findViewById(R.id.tvCodeProductCart)
        val textViewPrice: TextView = itemView.findViewById(R.id.tvPriceProductCart)
        val btnAddToCart: ImageButton = itemView.findViewById(R.id.btnAddToCartProductCart)
        val btnBuyNow: Button = itemView.findViewById(R.id.btnBuyNowProductCart)
    }
}
