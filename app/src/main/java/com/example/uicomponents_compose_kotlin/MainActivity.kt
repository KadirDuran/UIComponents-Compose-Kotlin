package com.example.uicomponents_compose_kotlin

import android.content.res.Resources
import android.os.Bundle
import android.provider.ContactsContract.Profile
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uicomponents_compose_kotlin.R.color.light_white
import com.example.uicomponents_compose_kotlin.pages.BottomItemList
import com.example.uicomponents_compose_kotlin.pages.Menu
import com.example.uicomponents_compose_kotlin.pages.MidItemList
import com.example.uicomponents_compose_kotlin.pages.PageOne
import com.example.uicomponents_compose_kotlin.pages.PageThree
import com.example.uicomponents_compose_kotlin.pages.PageTwo
import com.example.uicomponents_compose_kotlin.pages.Person
import com.example.uicomponents_compose_kotlin.ui.theme.UIComponentsComposeKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "PageOne" ){
                    composable(route = "PageOne"){
                            PageOne(navController)
                    }
                composable(route = "PageTwo") {
                    val midItemList = ArrayList<MidItemList>()
                    midItemList.add(MidItemList(R.drawable.favorites,"Favorites"))
                    midItemList.add(MidItemList(R.drawable.message,"Messages"))
                    midItemList.add(MidItemList(R.drawable.social,"Social"))
                    midItemList.add(MidItemList(R.drawable.favorites,"Favorites"))
                    midItemList.add(MidItemList(R.drawable.message,"Messages"))
                    midItemList.add(MidItemList(R.drawable.social,"Social"))
                    val bottomItemList = ArrayList<BottomItemList>()
                    bottomItemList.add(BottomItemList(1,R.drawable.trends,"İmportant points in concluding a work on."))
                    bottomItemList.add(BottomItemList(2,R.drawable.trends2,"İmportant points in concluding a work on."))
                    bottomItemList.add(BottomItemList(3,R.drawable.trends,"İmportant points in concluding a work on."))
                    bottomItemList.add(BottomItemList(4,R.drawable.trends2,"İmportant points in concluding a work on."))
                    PageTwo(navController,midItemList,bottomItemList)
                }
                composable(route = "PageThree"){
                    ThreePageStart(modifier =Modifier,navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIComponentsComposeKotlinTheme {
        Greeting()
    }
}
@Composable
fun ThreePageStart(modifier: Modifier,navController: NavController)
{
    val menuItemList = ArrayList<Menu>()
    menuItemList.add(Menu(R.drawable.btn_1,"Notification"))
    menuItemList.add(Menu(R.drawable.btn_2,"Calendar"))
    menuItemList.add(Menu(R.drawable.btn_3,"Gallery"))
    menuItemList.add(Menu(R.drawable.btn_4,"My Playlist"))
    menuItemList.add(Menu(R.drawable.btn_5,"Share"))
    menuItemList.add(Menu(R.drawable.btn_6,"Logout"))
    val person = Person("Kadir Duran","kadirduran61@gmail.com",R.drawable.user_2)
    PageThree(navController, modifier = modifier, person,menuItemList )
}

