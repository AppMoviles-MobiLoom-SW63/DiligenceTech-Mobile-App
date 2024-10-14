package pe.edu.upc.diligencetech.communications.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.diligencetech.R
import pe.edu.upc.diligencetech.ui.theme.Montserrat

@Composable
fun MessagesListFromProjectScreen() {

    var showDialog by remember { mutableStateOf(false) }
    val selectedTab = remember { mutableStateOf("Recibidos") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 30.dp, start = 16.dp),
            verticalAlignment = Alignment.CenterVertically, // Esto asegura que el contenido esté alineado verticalmente
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFF282828), shape = CircleShape)
                    .clickable {},
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Mensajes del Proyecto XXXX",
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFD6773D),
                    fontSize = 22.sp
                ),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF282828))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        selectedTab.value = "Recibidos"
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Recibidos",
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = if (selectedTab.value == "Recibidos") Color(0xFFD6773D) else Color.White
                        ),
                        modifier = Modifier.padding(8.dp)
                    )
                    if (selectedTab.value == "Recibidos") {
                        Divider(
                            color = Color(0xFFD6773D),
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .clickable {
                        selectedTab.value = "Enviados"
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Enviados",
                        style = TextStyle(
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = if (selectedTab.value == "Enviados") Color(0xFFD6773D) else Color.White
                        ),
                        modifier = Modifier.padding(8.dp)
                    )
                    if (selectedTab.value == "Enviados") {
                        Divider(
                            color = Color(0xFFD6773D),
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        if (selectedTab.value == "Recibidos") {
            Text(
                text = "Mostrando mensajes recibidos...",
                style = TextStyle(fontFamily = Montserrat, color = Color.Gray)
            )
        } else {
            Text(
                text = "Mostrando mensajes enviados...",
                style = TextStyle(fontFamily = Montserrat, color = Color.Gray)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = { },
                containerColor = Color.White,
                modifier = Modifier
                    .padding(bottom = 40.dp, end = 16.dp)
                    .size(64.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Agregar",
                    tint = Color(0xFFD6773D),
                    modifier = Modifier.size(40.dp)
                )
            }
        }

    }

}