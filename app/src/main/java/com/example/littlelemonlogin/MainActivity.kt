package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyNavigation()
            //HomeScreen()
            AppScreen()
            //LoginScreen()
        }
    }


}

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState, scope) },
        topBar = {
            TopAppBar(scaffoldState, scope)
        },
        bottomBar = { MyBottomNavigation(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            MyNavigation(navController = navController)
        }
    }

}


@Composable
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(Menu.route) {
            MenuListScreen()
        }
        composable(Settings.route) {
            SettingScreen()
        }
        composable(Location.route) {
            LocationScreen()
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavHostController) {
    val destinationList = listOf<Destinations>(
        Home,
        Settings,
        Menu,
        Location
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation() {
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                label = { Text(text = destination.title) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title
                    )
                },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}






