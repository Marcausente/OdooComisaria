package com.example.buisnesscards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

                // Variables para recordar los valores introducidos
                val nombre = remember { mutableStateOf("") }
                val apellido = remember { mutableStateOf("") }
                val empresa = remember { mutableStateOf("") }
                val correo = remember { mutableStateOf("") }
                val telefono = remember { mutableStateOf("") }
                val puesto = remember { mutableStateOf("") }

                // Nombre
                TextField(
                    value = nombre.value,
                    onValueChange = { nombre.value = it },
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

                // Apellido con Checkbox
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = apellido.value,
                        onValueChange = { apellido.value = it },
                        label = { Text("Apellido") },
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                Color.Gray.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val isCheckedApellido = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isCheckedApellido.value,
                        onCheckedChange = { isCheckedApellido.value = it },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Empresa con Checkbox
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = empresa.value,
                        onValueChange = { empresa.value = it },
                        label = { Text("Empresa") },
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                Color.Gray.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val isCheckedEmpresa = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isCheckedEmpresa.value,
                        onCheckedChange = { isCheckedEmpresa.value = it },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Correo con Checkbox
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = correo.value,
                        onValueChange = { correo.value = it },
                        label = { Text("Correo") },
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                Color.Gray.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val isCheckedCorreo = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isCheckedCorreo.value,
                        onCheckedChange = { isCheckedCorreo.value = it },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Telefono con Checkbox
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = telefono.value,
                        onValueChange = { telefono.value = it },
                        label = { Text("Telefono") },
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                Color.Gray.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val isCheckedTelefono = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isCheckedTelefono.value,
                        onCheckedChange = { isCheckedTelefono.value = it },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                // Puesto con Checkbox
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = puesto.value,
                        onValueChange = { puesto.value = it },
                        label = { Text("Puesto / Cargo") },
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                Color.Gray.copy(alpha = 0.6f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val isCheckedPuesto = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isCheckedPuesto.value,
                        onCheckedChange = { isCheckedPuesto.value = it },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))

                // Selección de Género
                val selectedGender = remember { mutableStateOf("") }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp)),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Género: ",
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp),
                        fontSize = 18.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedGender.value == "Male",
                            onClick = { selectedGender.value = "Male" },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = "Hombre",
                            color = Color.White,
                            modifier = Modifier.padding(end = 16.dp),
                            fontSize = 18.sp
                        )
                        RadioButton(
                            selected = selectedGender.value == "Female",
                            onClick = { selectedGender.value = "Female" },
                            colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                        )
                        Text(
                            text = "Mujer",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }

            // Botón de Enviar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp) // Ajusta el espacio desde la parte inferior
                    .align(Alignment.BottomCenter), // Alinea la columna en la parte inferior
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /* Acción para el botón */ },
                    modifier = Modifier.height(60.dp).fillMaxWidth(0.8f)
                ) {
                    Text("ENVIAR", fontSize = 30.sp, color = Color.White)
                }
            }
        }
    }
}
