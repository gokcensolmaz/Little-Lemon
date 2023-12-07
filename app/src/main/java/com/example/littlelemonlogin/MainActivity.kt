package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComponent()
        }
    }
}

@Composable
fun MainComponent() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0Xff495e57))
    ) {
        Text(
            text = stringResource(id = R.string.little_lemon),
            fontSize = 32.sp,
            color = Color(0xFFF4CE14),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 24.sp,
            color = Color(0xFFFfffff),
            modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(id = R.string.description),
                Modifier.width(200.dp),
                color = Color.White,
                fontSize = 21.sp
            )
            Image(
                painter = painterResource(id = R.drawable.little_lemon),
                contentDescription = "",
                Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
        }
        Button(
            onClick = { },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff4ce14))
        ) {
            Text(text = stringResource(id = R.string.order))
        }

    }
}

@Preview
@Composable
fun MainComponentPreview() {
    MainComponent()
}


