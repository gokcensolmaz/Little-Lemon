package com.example.littlelemonlogin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        UpperPanel(navController)
        LowerPanel()
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
                navController.navigate(MenuList.route)
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff4ce14))
        ) {
            Text(
                text = stringResource(id = R.string.order_button_text),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
        }

    }
}

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecialCard()
        MenuDish()
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

@Composable
fun MenuDish() {
    // TODO:  Lazy Column eklenecek
    Card() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column() {
                Text(text = "Greek Salad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "The famous Greek Salad of crispy lettuce, peppers, olives, our Chicago...",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 8.dp)
                        .fillMaxWidth(0.75f)
                )
                Text(text = "$12.99", color = Color.Gray, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad Image"
            )
        }
    }
}

