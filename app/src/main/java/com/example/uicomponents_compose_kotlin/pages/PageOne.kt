package com.example.uicomponents_compose_kotlin.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomponents_compose_kotlin.R


@Composable
fun PageOne()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(top = 50.dp)
    ) {

        Box(
            modifier = Modifier
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.women),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.arc_3),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .offset(0.dp, 2.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.light_white))
                .weight(1f)

        ) {
            Text(text = "Welcome",modifier= Modifier.align(Alignment.CenterHorizontally), fontSize = 25.sp,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.boldfont))
            )
            Text(text = "To The Company",modifier= Modifier.align(Alignment.CenterHorizontally), fontSize = 25.sp,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.boldfont))
            )
            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                color = colorResource(id = R.color.black),
                modifier = Modifier.padding(20.dp,10.dp)
            )

            Button(
                onClick = { /* Handle button click */ },
                shape = RoundedCornerShape(5.dp), modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 0.dp)
                    .padding(0.dp,20.dp,0.dp,50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.darkblue),
                    contentColor = Color.White
                ),

                ) {

                Text(text = "GET STARTED")
            }
        }
    }
}