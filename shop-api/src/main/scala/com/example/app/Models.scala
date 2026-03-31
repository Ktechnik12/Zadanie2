package com.example.app

case class Product(id: Int, name: String, price: Double)
case class Category(id: Int, name: String)
case class CartItem(id: Int, productId: Int, quantity: Int)
