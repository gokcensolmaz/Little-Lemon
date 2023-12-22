package com.example.littlelemonlogin

interface Destinations {
    val route: String
    val icon: Int?
    val title: String
}

object Home : Destinations {
    override val route: String = "Home"
    override val icon: Int = R.drawable.ic_home
    override val title: String = "Home"
}

object Menu : Destinations {
    override val route: String = "Menu"
    override val icon: Int = R.drawable.ic_menu
    override val title: String = "Menu"
}

object Settings : Destinations{
    override val route: String = "Settings"
    override val icon: Int = R.drawable.ic_settings
    override val title: String = "Settings"
}
object Location : Destinations {
    override val route: String = "Location"
    override val icon: Int = R.drawable.ic_location
    override val title: String = "Location"
}

object DishDetails : Destinations {
    override val route: String = "Menu"
    override val icon: Int? = null
    override val title: String = "Menu"
    const val argDishId = "dishId"
}