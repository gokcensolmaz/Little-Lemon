package com.example.littlelemonlogin

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route: String = "Home"
}

object MenuList : Destinations {
    override val route: String = "MenuList"
}