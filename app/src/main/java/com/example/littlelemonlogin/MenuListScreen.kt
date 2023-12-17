package com.example.littlelemonlogin

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuListScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        repeat(10) {
            Row(
                Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(2) {
                    GridCell()
                }
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

@Preview(showBackground = true)
@Composable
fun MenuCategoryPreview() {
    MenuCategory(category = "Category")
}

val Categories = listOf<String>(
    "Lunch", "Dessert", "Mains"
)