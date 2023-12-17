package com.example.littlelemonlogin

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val icon: Int
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