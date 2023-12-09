package com.example.littlelemonlogin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color(0Xff495e57))
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp).fillMaxWidth()
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
            modifier = Modifier
                .padding(top=18.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                Modifier
                    .padding(bottom=28.dp)
                    .fillMaxWidth(0.6f),
                color = Color(0xFFEDEFEE),
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(id = R.drawable.upper_panel_image),
                contentDescription = "Upper Panel Image",
                Modifier
                    .clip(RoundedCornerShape(20.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Order received. Thank you!", Toast.LENGTH_SHORT).show()
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

@Preview
@Composable
fun UpperPanelPrev() {
    UpperPanel()
}