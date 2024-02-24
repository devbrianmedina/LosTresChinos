package com.itess701.lostreschinos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.itess701.lostreschinos.databinding.ActivityMainBinding
import com.itess701.lostreschinos.models.Product
import com.itess701.lostreschinos.ui.about.AboutActivity
import com.itess701.lostreschinos.ui.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_support, R.id.nav_contact, R.id.nav_guarantee, R.id.nav_categories, R.id.nav_products, R.id.nav_cart
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    companion object {
        val products = ArrayList<Product>(listOf(
            Product(R.drawable.product_1, "Destornillador Eléctrico", "SKU123", 49.99, "Destornillador eléctrico recargable para trabajos de precisión", listOf(
                Pair("Potencia", "20V"),
                Pair("Tipo de cabezal", "Phillips"),
                Pair("Material", "Acero inoxidable"),
            )),
            Product(R.drawable.product_2, "Juego de Llaves de Vaso", "SKU456", 79.99, "Conjunto completo de llaves de vaso de alta calidad con estuche", listOf(
                Pair("Tamaño de las llaves", "6mm-24mm"),
                Pair("Material", "Cromo vanadio"),
                Pair("Estuche incluido", "Sí"),
            )),
            Product(R.drawable.product_3, "Sierra Circular Profesional", "SKU789", 149.99, "Sierra circular potente y precisa para cortes en madera y materiales compuestos", listOf(
                Pair("Potencia", "1200W"),
                Pair("Diámetro de la hoja", "7.25 pulgadas"),
                Pair("Velocidad ajustable", "Sí"),
            )),
            Product(R.drawable.product_4, "Martillo de Garra Anti Vibración", "SKU101", 29.99, "Martillo de garra con mango ergonómico y tecnología anti vibración", listOf(
                Pair("Peso", "16 oz"),
                Pair("Material del mango", "Fibra de vidrio"),
                Pair("Uso recomendado", "Trabajos de construcción"),
            )),
            Product(R.drawable.product_5, "Taladro Percutor Inalámbrico", "SKU202", 89.99, "Taladro inalámbrico con función percutora y batería de larga duración", listOf(
                Pair("Potencia", "18V"),
                Pair("Tipo de mandril", "Portabrocas sin llave"),
                Pair("Función percutora", "Sí"),
            ))
        ))
    }
}