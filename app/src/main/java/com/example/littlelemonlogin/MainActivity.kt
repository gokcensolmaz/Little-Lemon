package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}
/***&****Some Trials****&
@Composable
fun AppScreen() {
    LittleLemonLoginTheme() {
        Column() {
            Text(
                text = "Gökçen", style = TextStyle(
                    fontSize = 24.sp,
                    color = LittleLemonColor.yellow,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(8f, 8f), blurRadius = 4f
                    ),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.width(300.dp),

            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = LittleLemonColor.yellow,
                            fontSize = 20.sp
                        )
                    ){
                        append("G")
                    }
                    append("ökçen")
                }
            )

            Surface(
                color = LittleLemonColor.yellow, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Lemon",
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(30.dp)
                        .wrapContentSize(align = Alignment.TopStart)
                        .border(2.dp, LittleLemonColor.charcoal)
                )

            }
            Surface(
                color = LittleLemonColor.pink, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Lemon",
                    fontSize = 80.sp,
                    modifier = Modifier
                        .padding(30.dp)
                        .wrapContentSize(align = Alignment.TopStart)
                        .border(2.dp, LittleLemonColor.charcoal)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreviewLight() {
    AppScreen()
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppScreenPreviewDark() {
    AppScreen()
}
**/
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
            MenuListScreen(navController)
        }
        composable(Settings.route) {
            SettingScreen()
        }
        composable(Location.route) {
            LocationScreen()
        }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
        ) {
            val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
            DishDetails(id)
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavHostController) {
    val destinationList = listOf<Destinations>(
        Home, Settings, Menu, Location
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation() {
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(label = { Text(text = destination.title) }, icon = {
                Icon(
                    painter = painterResource(id = destination.icon!!),
                    contentDescription = destination.title
                )
            }, selected = index == selectedIndex.value, onClick = {
                selectedIndex.value = index
                navController.navigate(destinationList[index].route) {
                    popUpTo(Home.route)
                    launchSingleTop = true
                }
            })
        }
    }
}
