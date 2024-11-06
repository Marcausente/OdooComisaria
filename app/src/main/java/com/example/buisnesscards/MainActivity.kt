package com.example.buisnesscards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscards.ui.theme.BuisnessCardsTheme

//test

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            main()
        }
    }

    @Composable
    fun main() {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize().matchParentSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Business Cards",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 41.sp,
                    modifier = Modifier
                        .padding(20.dp) // Aumentamos el padding interno
                        .background(Color.Gray.copy(alpha = 0.6f), shape = RoundedCornerShape(20.dp)) // Primero fondo y forma
                        .clip(RoundedCornerShape(80.dp)) // Aplicamos clip después para el redondeado
                        .padding(horizontal = 24.dp, vertical = 16.dp) // Añadimos padding extra para más espacio en el fondo
                )
            }
            Spacer( modifier = Modifier.padding(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(90.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("ARRIBA ESPAÑA")
            }









        }
    }
}
