package com.example.uicomponents_compose_kotlin

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicomponents_compose_kotlin.ui.theme.UIComponentsComposeKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIComponentsComposeKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Column(modifier= Modifier
      .fillMaxWidth()
      .background(Color.Blue)
      .padding(0.dp, 50.dp, 0.dp, 0.dp)
      .wrapContentSize(),
      verticalArrangement =Arrangement.Top,
     ) {
      Row(modifier= Modifier
          .fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceEvenly){
          Image(painter = painterResource(id = R.drawable.women) , contentDescription = "")

      }
      Image(
              painter = painterResource(id = R.drawable.arc_3),
            contentDescription = "",
      modifier = Modifier
          .fillMaxWidth()
          .wrapContentSize()
      )




  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIComponentsComposeKotlinTheme {
        Greeting("Android")
    }
}