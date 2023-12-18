package com.example.littlelemonlogin.data

import com.example.littlelemonlogin.R

data class Dish(
    val name: String,
    val price: String,
    val description: Int,
    val image: Int
)


val Dishes = listOf<Dish>(
    Dish("Greek Salad", "$12.99", R.string.description_greek_salad, R.drawable.greeksalad),
    Dish("Bruschetta", "$5.99", R.string.description_bruschetta, R.drawable.bruschetta),
    Dish("Lemon Dessert", "$9.99", R.string.description_lemon_dessert, R.drawable.lemon_dessert),
    Dish("Greek Salad", "$12.99", R.string.description_greek_salad, R.drawable.greeksalad),
    Dish("Bruschetta", "$5.99", R.string.description_bruschetta, R.drawable.bruschetta),
    Dish("Lemon Dessert", "$9.99", R.string.description_lemon_dessert, R.drawable.lemon_dessert),
    Dish("Greek Salad", "$12.99", R.string.description_greek_salad, R.drawable.greeksalad),
    Dish("Bruschetta", "$5.99", R.string.description_bruschetta, R.drawable.bruschetta),
    Dish("Lemon Dessert", "$9.99", R.string.description_lemon_dessert, R.drawable.lemon_dessert),
    Dish("Greek Salad", "$12.99", R.string.description_greek_salad, R.drawable.greeksalad),
    Dish("Bruschetta", "$5.99", R.string.description_bruschetta, R.drawable.bruschetta),
    Dish("Lemon Dessert", "$9.99", R.string.description_lemon_dessert, R.drawable.lemon_dessert),
    Dish("Greek Salad", "$12.99", R.string.description_greek_salad, R.drawable.greeksalad),
    Dish("Bruschetta", "$5.99", R.string.description_bruschetta, R.drawable.bruschetta),
    Dish("Lemon Dessert", "$9.99", R.string.description_lemon_dessert, R.drawable.lemon_dessert)
)