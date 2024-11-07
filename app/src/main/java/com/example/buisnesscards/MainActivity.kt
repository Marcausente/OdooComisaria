package com.example.buisnesscards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }

    @Composable
    fun MainApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "formScreen") {
            composable("formScreen") { FormScreen(navController) }
            composable("BackgroundScreen") { BackgroundScreen() }
        }
    }

    @Composable
    fun FormScreen(navController: NavController) {
        // Estados para los campos del formulario y los checkboxes
        val userPreferredDarkMode = remember { mutableStateOf(false) }
        val nombre = remember { mutableStateOf("") }
        val apellido = remember { mutableStateOf("") }
        val empresa = remember { mutableStateOf("") }
        val correo = remember { mutableStateOf("") }
        val telefono = remember { mutableStateOf("") }
        val puesto = remember { mutableStateOf("") }
        val isCheckedApellido = remember { mutableStateOf(false) }
        val isCheckedEmpresa = remember { mutableStateOf(false) }
        val isCheckedCorreo = remember { mutableStateOf(false) }
        val isCheckedTelefono = remember { mutableStateOf(false) }
        val isCheckedPuesto = remember { mutableStateOf(false) }
        val selectedGender = remember { mutableStateOf("") }

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize().matchParentSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 110.dp)
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

                // Campos de entrada y checkboxes
                TextFieldWithCheckbox("Nombre", nombre)
                TextFieldWithCheckbox("Apellido", apellido, isCheckedApellido)
                TextFieldWithCheckbox("Empresa", empresa, isCheckedEmpresa)
                TextFieldWithCheckbox("Correo", correo, isCheckedCorreo)
                TextFieldWithCheckbox("Telefono", telefono, isCheckedTelefono)
                TextFieldWithCheckbox("Puesto / Cargo", puesto, isCheckedPuesto)

                // Selección de género
                GenderSelection(selectedGender)

                Spacer(modifier = Modifier.height(20.dp))

                // Switch para el modo oscuro
                Row(
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Modo Oscuro", color = Color.White, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Switch(
                        checked = userPreferredDarkMode.value,
                        onCheckedChange = { userPreferredDarkMode.value = it }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Botón de Enviar
                Button(
                    onClick = {
                        val savedData = mutableMapOf<String, String>()
                        savedData["Nombre"] = nombre.value
                        if (isCheckedApellido.value) savedData["Apellido"] = apellido.value
                        if (isCheckedEmpresa.value) savedData["Empresa"] = empresa.value
                        if (isCheckedCorreo.value) savedData["Correo"] = correo.value
                        if (isCheckedTelefono.value) savedData["Telefono"] = telefono.value
                        if (isCheckedPuesto.value) savedData["Puesto"] = puesto.value
                        savedData["Género"] = selectedGender.value
                        savedData["Modo Oscuro Activado"] = userPreferredDarkMode.value.toString()

                        navController.navigate("BackgroundScreen")
                    },
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth(0.8f)
                ) {
                    Text("ENVIAR", fontSize = 30.sp, color = Color.White)
                }
            }
        }
    }

    @Composable
    fun BackgroundScreen() {
        val selectedImage = remember { mutableStateOf("") }

        // Listado de imágenes con sus nombres personalizados
        val imageList = listOf(
            Pair(R.drawable.background1, "Fondo de madera"),
            Pair(R.drawable.background2, "Fondo de metal"),
            Pair(R.drawable.background3, "Fondo de papiro"),
            Pair(R.drawable.background4, "Fondo de cuero")
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.background), // Este es el fondo general
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize().matchParentSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Elige uno de los siguientes fondos:",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(
                            Color.Gray.copy(alpha = 0.6f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .padding(horizontal = 24.dp, vertical = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Crear las filas de imágenes
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    // Fila 1 de imágenes
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        imageList.subList(0, 2).forEachIndexed { index, pair ->
                            Image(
                                painter = painterResource(id = pair.first),
                                contentDescription = "Background $index",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(250.dp) // Mantener la misma altura
                                    .width(160.dp) // Establecer un tamaño fijo para la anchura
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Gray.copy(alpha = 0.5f))
                                    .clickable {
                                        selectedImage.value = pair.second // Guardar la selección con el nombre del fondo
                                    },
                                contentScale = ContentScale.Crop // Ajuste para llenar el espacio y recortar si es necesario
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Fila 2 de imágenes
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        imageList.subList(2, 4).forEachIndexed { index, pair ->
                            Image(
                                painter = painterResource(id = pair.first),
                                contentDescription = "Background ${index + 2}",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(250.dp) // Mantener la misma altura
                                    .width(160.dp) // Establecer un tamaño fijo para la anchura
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Gray.copy(alpha = 0.5f))
                                    .clickable {
                                        selectedImage.value = pair.second // Guardar la selección con el nombre del fondo
                                    },
                                contentScale = ContentScale.Crop // Ajuste para llenar el espacio y recortar si es necesario
                            )
                        }
                    }
                }

                // Mostrar el fondo seleccionado
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Seleccionaste: ${selectedImage.value}",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }





    @Composable
    fun TextFieldWithCheckbox(
        label: String,
        textState: MutableState<String>,
        checkboxState: MutableState<Boolean>? = null
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text(label) },
                modifier = Modifier
                    .weight(1f)
                    .background(
                        Color.Gray.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
            )
            checkboxState?.let {
                Spacer(modifier = Modifier.width(10.dp))
                Checkbox(
                    checked = it.value,
                    onCheckedChange = { checked -> it.value = checked },
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

    @Composable
    fun GenderSelection(selectedGender: MutableState<String>) {
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
                Text("Hombre", color = Color.White, fontSize = 18.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedGender.value == "Female",
                    onClick = { selectedGender.value = "Female" },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.White)
                )
                Text("Mujer", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
