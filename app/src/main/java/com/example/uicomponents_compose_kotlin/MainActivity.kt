package com.example.uicomponents_compose_kotlin

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.uicomponents_compose_kotlin.R.color.light_white
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
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.darkblue))) {
Column(modifier = Modifier
    .weight(0.6f)
    .fillMaxWidth()) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 50.dp, 0.dp, 0.dp),Arrangement.SpaceEvenly) {
        Image(painter = painterResource(id = R.drawable.user_1) , contentDescription ="",
            modifier = Modifier.weight(1.25f))
        Text(text = "Hi, Kadir", modifier= Modifier
            .align(Alignment.CenterVertically)
            .weight(2.5f), fontSize = 20.sp)
        Image(painter = painterResource(id = R.drawable.notification) , contentDescription ="",
            modifier = Modifier.weight(1.25f))
    }

    Text(text = "Find Your Favorits", fontFamily = FontFamily(Font(R.font.boldfont)), fontSize =20.sp,modifier = Modifier.padding(30.dp,10.dp,0.dp,0.dp) )
    Text(text = "Here", fontFamily = FontFamily(Font(R.font.boldfont)), fontSize =20.sp,modifier = Modifier.padding(30.dp,2.dp,0.dp,0.dp) )
    TextField(
        value = text, onValueChange = { text = it },
        label = { Text("Search", color = colorResource(id = R.color.light_white)) },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp, 20.dp),

        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.search), contentDescription = "")
        },
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.microphone), contentDescription = "")
        },
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = colorResource(id = R.color.dark_white),
            unfocusedContainerColor = colorResource(id = R.color.dark_white)
        ),
    )

}
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.light_white))
                .offset(0.dp, -35.dp)
                .weight(1f)
        ) {
                Box(modifier= Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)) {
                    Image(painter = painterResource(id = R.drawable.arc_2), contentDescription ="",modifier = Modifier
                        .fillMaxWidth()
                        .offset(0.dp, -2.dp))
                    Row(modifier=Modifier.fillMaxWidth()){
                        Spacer(modifier = Modifier.width(8.dp))
                        ElevatedCard(shape = RoundedCornerShape(15.dp),
                            colors =CardDefaults.elevatedCardColors(
                            containerColor = colorResource(id = R.color.light_white),
                                contentColor = colorResource(id = R.color.black)
                            ),
                            modifier= Modifier
                                .background(Color.Transparent)
                                .height(120.dp)
                                .width(120.dp)
                                )
                        {
                            Image(painter = painterResource(id = R.drawable.favorites), contentDescription ="",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(15.dp, 15.dp, 15.dp, 0.dp))

                            Text(text = "Favorites",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(0.dp, 10.dp),
                                textAlign = TextAlign.Center)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        ElevatedCard(shape = RoundedCornerShape(15.dp),
                            colors =CardDefaults.elevatedCardColors(
                                containerColor = colorResource(id = R.color.light_white),
                                contentColor = colorResource(id = R.color.black)
                            ),
                            modifier= Modifier
                                .background(Color.Transparent)
                                .height(120.dp)
                                .width(120.dp)
                        )
                        {
                            Image(painter = painterResource(id = R.drawable.favorites), contentDescription ="",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(15.dp, 15.dp, 15.dp, 0.dp))

                            Text(text = "Favorites",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(0.dp, 10.dp),
                                textAlign = TextAlign.Center)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        ElevatedCard(shape = RoundedCornerShape(15.dp),
                            colors =CardDefaults.elevatedCardColors(
                                containerColor = colorResource(id = R.color.light_white),
                                contentColor = colorResource(id = R.color.black)
                            ),
                            modifier= Modifier
                                .background(Color.Transparent)
                                .height(120.dp)
                                .width(120.dp)
                        )
                        {
                            Image(painter = painterResource(id = R.drawable.favorites), contentDescription ="",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(15.dp, 15.dp, 15.dp, 0.dp))

                            Text(text = "Favorites",modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(0.dp, 10.dp),
                                textAlign = TextAlign.Center)
                        }
                    }

                }
        }
}


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIComponentsComposeKotlinTheme {
        Greeting("Android")
    }
}