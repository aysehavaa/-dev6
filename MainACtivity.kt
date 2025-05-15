package com.example.aysikstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView'ları başlat
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView)
        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Layout Manager'ları ayarla
        categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Adapter'ları ayarla
        setupAdapters()

        // Bottom Navigation'ı ayarla
        setupBottomNavigation()
    }

    private fun setupAdapters() {
        // Kategori adapter'ını ayarla
        val categories = listOf(
            Category("Elektronik", R.drawable.category_electronics),
            Category("Moda", R.drawable.category_fashion),
            Category("Ev & Yaşam", R.drawable.category_home),
            Category("Kozmetik", R.drawable.category_cosmetics)
        )
        categoriesRecyclerView.adapter = CategoryAdapter(categories)

        // Ürün adapter'ını ayarla
        val products = listOf(
            Product(
                "iPhone 13 Pro",
                "En yeni iPhone modeli",
                29999.99,
                4.5f,
                R.drawable.product_iphone
            ),
            Product(
                "Samsung Galaxy S21",
                "Güçlü Android telefon",
                19999.99,
                4.3f,
                R.drawable.product_samsung
            ),
            Product(
                "MacBook Pro",
                "Profesyonel dizüstü bilgisayar",
                39999.99,
                4.8f,
                R.drawable.product_macbook
            )
        )
        productsRecyclerView.adapter = ProductAdapter(products)
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Ana sayfa işlemleri
                    true
                }
                R.id.navigation_categories -> {
                    // Kategoriler sayfası işlemleri
                    true
                }
                R.id.navigation_cart -> {
                    // Sepet sayfası işlemleri
                    true
                }
                R.id.navigation_profile -> {
                    // Profil sayfası işlemleri
                    true
                }
                else -> false
            }
        }
    }
} 
