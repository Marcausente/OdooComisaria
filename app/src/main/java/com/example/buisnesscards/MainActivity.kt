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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

            // Primera columna con el título en el centro superior
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp) // Ajusta el espacio desde la parte superior
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Business Cards",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 41.sp,
                    modifier = Modifier
                        .padding(20.dp)
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }

            // Segunda columna con el texto adicional, justo debajo de la primera
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 110.dp) // Ajusta el espacio entre el título y el segundo texto
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Ingrese sus datos:",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(20.dp)
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .padding(horizontal = 24.dp, vertical = 15.dp)
                )
                Spacer(modifier = Modifier.height(1.dp))
                val text = remember { mutableStateOf("") }

                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Nombre") },
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Apellido") },
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Empresa") },
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Correo") },
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp) // Ajusta el espacio desde la parte inferior
                    .align(Alignment.BottomCenter), // Alinea la columna en la parte inferior
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /* Acción para el botón */ },
                    modifier = Modifier.padding(top = 8.dp) // Ajusta el espacio entre el texto y el botón
                ) {
                    Text("ENVIAR")
                }
            }
        }
    }
}