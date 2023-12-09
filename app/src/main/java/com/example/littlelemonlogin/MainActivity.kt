package com.example.littlelemonlogin

import android.content.ClipData.Item
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
            //AppScreen()
            //LoginScreen()
        }
    }


}

@Composable
fun HomeScreen() {


 Scaffold(
     topBar = { TopAppBar() }
 ) {

     Column {
         UpperPanel()
         LowerPanel()
     }
 }
}

@Composable
fun AppScreen() {
    var counter by rememberSaveable() {
        mutableStateOf(0)
    }
    ItemOrder(counter, { counter++ }, { counter-- })
}

@Composable
fun ItemOrder(counter: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(modifier = Modifier.padding(32.dp)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Greek Salad", fontWeight = FontWeight.W700, fontSize = 30.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { onDecrement()}) {
                        Icon(
                            imageVector = Icons.Default.Remove, contentDescription = "Remove"
                        )
                    }
                    Text(
                        text = "$counter",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    IconButton(onClick = { onIncrement() }) {
                        Icon(
                            imageVector = Icons.Default.Add, contentDescription = "Add"
                        )
                    }
                }
                Button(
                    onClick = {}, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add")
                }
            }


        }

    }
}




