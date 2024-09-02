package com.example.uicomponents_compose_kotlin

import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.darkblue))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
                    .background(colorResource(id = R.color.dark_white))
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.back), contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                )

            }
            Text(
                text = "PROFILE",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.boldfont)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
                    .align(Alignment.CenterVertically)
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 110.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.arc_3),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 0.dp)
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.user_2), contentDescription = null)
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.light_white))
                ) {
                    Text(
                        text = "Kadir Duran",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.boldfont)),
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "kadirduran61@gmail.com",
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.boldfont)),
                        color = colorResource(id = R.color.black)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.light_white))
        ) {
            CreateListItem(title = "Notification", img = R.drawable.btn_1)
            CreateListItem(title = "Calendar", img = R.drawable.btn_2)
            CreateListItem(title = "Gallery", img = R.drawable.btn_3)
            CreateListItem(title = "My Playlist", img = R.drawable.btn_4)
            CreateListItem(title = "Share", img = R.drawable.btn_5)
            CreateListItem(title = "Logout", img = R.drawable.btn_6)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIComponentsComposeKotlinTheme {
        Greeting()
    }
}

@Composable
fun CreateListItem(title: String, img: Int) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .clickable {
                Toast
                    .makeText(context, title.toString(), Toast.LENGTH_LONG)
                    .show()
            },
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(
            painter = painterResource(id = img), contentDescription = null,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = title,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}
