package com.example.foodorderingapp

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.foodorderingapp.databinding.ActivityDetailsBinding
import com.example.foodorderingapp.model.CartItems
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding :ActivityDetailsBinding
    private var foodName: String?= null
    private var foodImage: String?= null
    private var foodDescriptions: String?= null
    private var foodIngredients: String?= null
    private var foodPrice: String?= null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        foodName = intent.getStringExtra("MenuItemName")
        foodDescriptions = intent.getStringExtra("MenuItemDescription")
        foodIngredients = intent.getStringExtra("MenuItemIngredients")
        foodPrice = intent.getStringExtra("MenuItemPrice")
        foodImage = intent.getStringExtra("MenuItemImage")

        with(binding){
            detailFoodName.text = foodName
            detailsDescription.text = foodDescriptions
            detailsIngredients.text = foodIngredients
            Glide.with(this@DetailsActivity).load(Uri.parse(foodImage)).into(detailFoodImage)
        }

        binding.imageButton.setOnClickListener {
            finish()
        }
        binding.addItemButton.setOnClickListener {
            addItemToCart()
        }
    }
    private fun DetailsActivity.addItemToCart() {
        val database = FirebaseDatabase.getInstance().reference
        val userId = auth.currentUser?.uid?:""
        val cartItem = CartItems(foodName.toString(), foodPrice.toString(), foodDescriptions.toString(),foodImage.toString(),1)
        database.child("user").child(userId).child("CartItems").push().setValue(cartItem).addOnSuccessListener {
            Toast.makeText(this,"Món ăn đã thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Món ăn không được thêm", Toast.LENGTH_SHORT).show()
        }
    }
}
