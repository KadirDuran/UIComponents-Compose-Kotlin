package com.example.uicomponents_compose_kotlin.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomponents_compose_kotlin.R
data class Menu(
    val imgId : Int,
    val name : String
)
data class Person(
    val name : String,
    val email : String,
    val img : Int
)
@Composable
fun PageThree(modifier: Modifier, person: Person,menu : ArrayList<Menu> )
{
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
                Image(painter = painterResource(id =person.img), contentDescription = null)
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.light_white))
                ) {
                    Text(
                        text = person.name,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.boldfont)),
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = person.email,
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
                menu.forEach {
                    CreateListItem(title = it.name, img =it.imgId)
                }
        }
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