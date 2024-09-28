package pe.edu.upc.diligencetech.dashboard.presentation

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.diligencetech.R
import pe.edu.upc.diligencetech.common.WorkbenchScreen
import pe.edu.upc.diligencetech.ui.theme.Montserrat

@Composable
fun DashboardScreen(
    onHomeClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onMessagesClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
) = WorkbenchScreen(
    onHomeClick = onHomeClick,
    onProjectsClick = onProjectsClick,
    onMessagesClick = onMessagesClick,
    onProfileClick = onProfileClick,
    onSettingsClick = onSettingsClick
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF1A1A1A)), // Fondo oscuro
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 20.dp, start = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Descripción de proyectos",
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White, // Color del texto
                        fontSize = 22.sp
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centrar la card
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f) // Hacer que la Card ocupe el 90% del ancho
                        .clickable { /* Acción de click */ },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Bordes redondeados
                ) {
                    Row(
                        modifier = Modifier.padding(start= 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Total de proyectos",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "0", // Valor de ejemplo
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White, // Texto blanco
                                    fontSize = 40.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "Proyectos en el mes",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 14.sp
                                )
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp) // Tamaño del círculo
                                    .background(Color(0xFF9B4A18), CircleShape), // Fondo marrón
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.projects_dashboard_icon), // Icono personalizado
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(36.dp) // Tamaño del icono
                                )
                            }
                            Spacer(modifier = Modifier.height(13.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color(0xFFBF616A), CircleShape) // Fondo rojo para el badge
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "↓ 0.00%", // Porcentaje de ejemplo
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE0E0E0), // Texto claro
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centrar la card
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f) // Hacer que la Card ocupe el 90% del ancho
                        .clickable { /* Acción de click */ },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Bordes redondeados
                ) {
                    Row(
                        modifier = Modifier.padding(start= 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Proyectos activos",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "0", // Valor de ejemplo
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White, // Texto blanco
                                    fontSize = 40.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "Proyectos en el mes",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 14.sp
                                )
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp) // Tamaño del círculo
                                    .background(Color(0xFFC16933), CircleShape), // Fondo marrón
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.projects_active_icon), // Icono personalizado
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(36.dp) // Tamaño del icono
                                )
                            }
                            Spacer(modifier = Modifier.height(13.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color(0xFFBF616A), CircleShape) // Fondo rojo para el badge
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "↓ 0.00%", // Porcentaje de ejemplo
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE0E0E0), // Texto claro
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centrar la card
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f) // Hacer que la Card ocupe el 90% del ancho
                        .clickable { /* Acción de click */ },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Bordes redondeados
                ) {
                    Row(
                        modifier = Modifier.padding(start= 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Proyectos completos",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "0", // Valor de ejemplo
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White, // Texto blanco
                                    fontSize = 40.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "Proyectos en el mes",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 14.sp
                                )
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp) // Tamaño del círculo
                                    .background(Color(0xFFDB8652), CircleShape), // Fondo marrón
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.projects_complete_icon), // Icono personalizado
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(36.dp) // Tamaño del icono
                                )
                            }
                            Spacer(modifier = Modifier.height(13.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color(0xFFBF616A), CircleShape) // Fondo rojo para el badge
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "↓ 0.00%", // Porcentaje de ejemplo
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE0E0E0), // Texto claro
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centrar la card
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f) // Hacer que la Card ocupe el 90% del ancho
                        .clickable { /* Acción de click */ },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Bordes redondeados
                ) {
                    Row(
                        modifier = Modifier.padding(start= 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Total de miembros",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "0", // Valor de ejemplo
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White, // Texto blanco
                                    fontSize = 40.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "Participantes del proyecto",
                                style = TextStyle(
                                    fontFamily = Montserrat,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFFE0E0E0), // Texto gris claro
                                    fontSize = 14.sp
                                )
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp) // Tamaño del círculo
                                    .background(Color(0xFFF7B187), CircleShape), // Fondo marrón
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.projects_members_icon), // Icono personalizado
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(36.dp) // Tamaño del icono
                                )
                            }
                            Spacer(modifier = Modifier.height(13.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color(0xFFBF616A), CircleShape) // Fondo rojo para el badge
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "↓ 0.00%", // Porcentaje de ejemplo
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE0E0E0), // Texto claro
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
