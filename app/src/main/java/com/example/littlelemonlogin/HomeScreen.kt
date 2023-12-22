package com.example.littlelemonlogin

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemonlogin.data.Categories
import com.example.littlelemonlogin.data.Dish
import com.example.littlelemonlogin.data.DishRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        UpperPanel(navController)
        LowerPanel(navController,DishRepository.dishes)
    }
}

@Composable
fun TopAppBar(scaffoldState: ScaffoldState? = null, scope: CoroutineScope? = null) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                scope?.launch { scaffoldState?.drawerState?.open() }
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(horizontal = 20.dp)
        )

        IconButton(
            onClick = { /*TODO*/ }
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_basket),
                contentDescription = "Basket",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun UpperPanel(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color(0Xff495e57))
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.little_lemon),
            fontSize = 40.sp,
            color = Color(0xFFF4CE14),
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 24.sp,
            color = Color(0xFFEDEFEE),
        )
        Row(
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                Modifier
                    .padding(bottom = 28.dp)
                    .fillMaxWidth(0.6f),
                color = Color(0xFFEDEFEE),
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.drawable.upper_panel_image),
                contentDescription = "Upper Panel Image",
                Modifier.clip(RoundedCornerShape(20.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Order received. Thank you!", Toast.LENGTH_SHORT).show()
                navController.navigate(Menu.route)
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff4ce14))
        ) {
            Text(
                text = stringResource(id = R.string.order_button_text),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )


            )
        }
    }
}

@Composable
fun LowerPanel(navController: NavHostController,dishes: List<Dish> = listOf()) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Categories.forEach {
                MenuCategory(category = it)
            }
        }
        WeeklySpecialCard()
        LazyColumn {
            items(dishes.size) {  index ->
                MenuDish(navController, dishes[index])
            }
        }
        /*Column() {
            DishRepository.weekly_special_dishes.forEach { dish ->
                MenuDish(
                    navController = navController,
                    dish
                )
            }
        }*/
    }
}
@Composable
fun WeeklySpecialCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.weekly_special),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}


