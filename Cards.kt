package com.example.application


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Cards : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold {innerPadding ->
                CardsBody(innerPadding)
            }
        }
    }
}

@Composable
fun CardsBody(innerPadding: PaddingValues) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color(0xFF1BD29A))
    )
    {
        Row (
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)

        ){
            Image(
                painter  = painterResource(R.drawable.profile_image),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(100.dp))

            )
        }
        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ){
            Text(text = "Card", style = TextStyle(
                fontSize = 50.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            ))
            Text(text = "Simple and easy to use app.", style = TextStyle(
                fontSize = 25.sp,
                color = Color.White
            ))
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        Column {
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                CardItem(iconRes = R.drawable.book, text = "Text")
                CardItem(iconRes = R.drawable.school, text = "Address")
            }

            Spacer(modifier = Modifier
                .height(20.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                CardItem(iconRes = R.drawable.character, text = "Character")
                CardItem(iconRes = R.drawable.card, text = "Bank Card")
            }
            Spacer(modifier = Modifier
                .height(20.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
             ){
                CardItem(iconRes = R.drawable.key, text = "Password")
                CardItem(iconRes = R.drawable.logistics, text = "Logistics")
            }
            Spacer(modifier = Modifier
                .height(20.dp))
        }
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(70.dp)
                .width(355.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(10.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = null,
                    modifier = Modifier
                        .height(70.dp)

                )
                Spacer(modifier = Modifier
                    .width(10.dp))
                Text(text = "Settings",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    ))
            }
        }

    }

}

@Composable
fun CardItem(iconRes: Int, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(170.dp)
            .width(170.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .width(90.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCards() {
    CardsBody(innerPadding = PaddingValues(0.dp))
}