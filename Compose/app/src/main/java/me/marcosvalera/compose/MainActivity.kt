package me.marcosvalera.compose


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            viewmyScreen()

        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun viewmyScreen(){
   Scaffold(
       topBar = {toolbar()},
       content = {myScreen()},
       floatingActionButton = {fav()},
       floatingActionButtonPosition = FabPosition.End

   )
}
@Composable
fun fav(){
    val contex= LocalContext.current
    FloatingActionButton(onClick = { Toast.makeText(contex,"hola", Toast.LENGTH_SHORT).show()
     }){
        Text(text = "hola")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun toolbar(){
    TopAppBar(
        title = { Text(text = "Marcos Valera") }


    )
}
@Composable
fun myScreen(){
    var counter by remember { mutableStateOf(0) }
    LazyColumn(modifier = Modifier.background(Color.DarkGray).fillMaxHeight(),content = {
        item {
        val painter= painterResource(id= R.drawable.hola)
        Image(painter=painter, contentDescription = "hola", modifier = Modifier.padding(10.dp).fillMaxWidth())
        Text(text = "Marcos Valera", fontSize = 40.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(35.dp,0.dp,0.dp,0.dp))
        Text(text = "Ing. Sistemas", fontSize = 30.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(10.dp,20.dp,0.dp,0.dp))

        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            content ={item {
                Text(text = " Python", fontSize = 15.sp, color= Color.White)
                Text(text = " JavaScript", fontSize = 15.sp, color= Color.White)
                Text(text = " MySql", fontSize = 15.sp, color= Color.White)
                Text(text = " Java", fontSize = 15.sp, color= Color.White)
            }

        })
        Row {
            Image(
            painter=painterResource(id= R.drawable.like),
            contentDescription = "like",
            modifier = Modifier.padding(start = 15.dp).clickable {counter++})
            Text(text = counter.toString(), fontSize = 20.sp, color= Color.White, modifier = Modifier.padding(start = 10.dp))

        }

        }

    })




}