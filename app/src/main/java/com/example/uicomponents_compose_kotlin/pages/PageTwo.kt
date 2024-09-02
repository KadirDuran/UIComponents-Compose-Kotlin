package com.example.uicomponents_compose_kotlin.pages

import android.media.audiofx.AudioEffect.Descriptor
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uicomponents_compose_kotlin.R
data class MidItemList(
    val icon: Int,
    val description: String
)
data class BottomItemList(
    val newsId:Int,
    val  image : Int,
    val description: String
)
@Composable
fun PageTwo(navController: NavController,midItemList: ArrayList<MidItemList>,bottomItemList: ArrayList<BottomItemList>)
{
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.darkblue))) {
        Column(modifier = Modifier
            .weight(0.6f)
            .fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 50.dp, 0.dp, 0.dp), Arrangement.SpaceEvenly) {
                Image(painter = painterResource(id = R.drawable.user_1) , contentDescription ="",
                    modifier = Modifier.weight(1.25f))
                Text(text = "Hi, Kadir",color = Color.White, modifier= Modifier
                    .align(Alignment.CenterVertically)
                    .weight(2.5f), fontSize = 20.sp)
                Image(painter = painterResource(id = R.drawable.notification) , contentDescription ="",
                    modifier = Modifier.weight(1.25f))
            }

            Text(text = "Find Your Favorits", fontFamily = FontFamily(Font(R.font.boldfont)),color = Color.White, fontSize =20.sp,modifier = Modifier.padding(30.dp,10.dp,0.dp,0.dp) )
            Text(text = "Here", fontFamily = FontFamily(Font(R.font.boldfont)),color =Color.White, fontSize =20.sp,modifier = Modifier.padding(30.dp,2.dp,0.dp,0.dp) )
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
                .wrapContentHeight()
        ) {
            Box(modifier= Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .offset(0.dp, 35.dp)) {
                Image(painter = painterResource(id = R.drawable.arc_2), contentDescription ="",modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, -2.dp))
                LazyRow(modifier= Modifier.fillMaxWidth()){
                  items(midItemList){item: MidItemList ->
                      CreateCard(icon = item.icon, description =item.description )
                  }
                }

            }
        }

        Column(modifier= Modifier
            .weight(1f)
            .background(Color.White))
        {
            Card(modifier= Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.light_white),
                contentColor = colorResource(id = R.color.black)
            )){
                LazyRow(modifier= Modifier.fillMaxWidth()) {
                    items(bottomItemList){
                        item:BottomItemList->
                        CreateImgDesc(item.image,item.description, item.newsId)
                    }
                }

            }
            Row(modifier= Modifier.fillMaxSize(),verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Absolute.Right){
                Button(onClick = {
                    navController.navigate("PageThree")
                },modifier= Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 40.dp), shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.darkblue),
                    contentColor = colorResource(id = R.color.light_white)
                )) {
                    Text("PROFILE", fontSize = 16.sp)
                }
            }

        }
    }
}
@Composable
fun CreateImgDesc(img:Int,description: String,newsId: Int)
{
    val context = LocalContext.current
    Column(
        Modifier
            .padding(5.dp)
            .fillMaxWidth()) {
        Spacer(modifier = Modifier.width(5.dp))
        Image(painter = painterResource(id = img), contentDescription ="",
        modifier = Modifier.width(175.dp).clickable {
            Toast.makeText(context,newsId.toString(),Toast.LENGTH_LONG).show()

        })
        Text(text=description,modifier= Modifier
            .width(175.dp)
            .padding(5.dp))
        Spacer(modifier = Modifier.width(5.dp))
    }
}
@Composable
fun CreateCard(icon:Int,description: String)
{
    Spacer(modifier = Modifier.width(5.dp))
    ElevatedCard(shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(id = R.color.light_white),
            contentColor = colorResource(id = R.color.black)
        ),
        modifier= Modifier
            .background(Color.Transparent)
            .height(120.dp)
            .width(120.dp)


    ) {
        Image(painter = painterResource(id = icon), contentDescription ="",modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .padding(15.dp, 15.dp, 15.dp, 0.dp)

        )

        Text(text = description,modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
            textAlign = TextAlign.Center)
    }
    Spacer(modifier = Modifier.width(5.dp))

}
