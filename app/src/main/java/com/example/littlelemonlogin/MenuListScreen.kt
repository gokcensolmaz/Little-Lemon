package com.example.littlelemonlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonlogin.data.Categories
import com.example.littlelemonlogin.data.Dish
import com.example.littlelemonlogin.data.Dishes

@Composable
fun MenuListScreen() {
    Column {
        LazyRow {
            items(Categories) { category ->
                MenuCategory(category)
            }
        }
        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
        LazyColumn {
            items(Dishes) { Dish ->
                MenuDish(Dish)
            }
        }

    }
}


@Composable
fun GridCell() {
    Card(
        elevation = 16.dp, modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredSize(180.dp, 180.dp)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad"
            )
            Text(
                text = "Greek Salad",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(Color.White)
                    .align(Alignment.TopStart)
            )
            Text(
                text = "$12.99",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = category)
    }
}

@Composable
fun MenuDish(Dish: Dish) {
    Card() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column() {
                Text(
                    text = Dish.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = Dish.description),
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 8.dp)
                        .fillMaxWidth(0.75f)
                )
                Text(
                    text = Dish.price,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = Dish.image),
                contentDescription = Dish.name
            )
        }
    }
}

