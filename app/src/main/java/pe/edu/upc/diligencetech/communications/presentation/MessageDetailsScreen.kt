package pe.edu.upc.diligencetech.communications.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
fun MessageDetailsScreen(
    onHomeClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onMessagesClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    WorkbenchScreen(
        onHomeClick = onHomeClick,
        onProjectsClick = onProjectsClick,
        onMessagesClick = onMessagesClick,
        onProfileClick = onProfileClick,
        onSettingsClick = onSettingsClick,
        myOption = "Mensajes"
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF1A1A1A)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 24.dp, start = 16.dp),
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
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF282828))
                    .padding(top = 16.dp, bottom = 32.dp, start = 8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Consulta sobre las contrataciones",
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 18.sp,
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 18.dp, bottom = 18.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.personal_profile_icon),
                    contentDescription = "Folder",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Jeremy Quispe",
                        color = Color.White,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "u2022192212@upc.edu.pe",
                        color = Color.White,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                }

            }

            Divider(
                color = Color(0xFF626262),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 9.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column() {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
                    elevation = CardDefaults.cardElevation(5.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Espero que este correo le encuentre bien.\n" +
                                    "\n" +
                                    "Me pongo en contacto con usted como representante de Vinicius, un talentoso delantero con una destacada trayectoria en el fútbol europeo. Actualmente, estamos explorando nuevas oportunidades de contratación para la próxima temporada y creemos que el Real Madrid podría ser un excelente destino para continuar con su desarrollo y aportar al equipo.\n" +
                                    "\n" +
                                    "Nos gustaría saber si están interesados en discutir posibles acuerdos o si existen vacantes disponibles que puedan ajustarse a las habilidades y perfil de Vinicius. Estoy seguro de que su incorporación al equipo podría ser de gran valor, y me encantaría coordinar una reunión o llamada para hablar en más detalle sobre sus cualidades y expectativas.\n" +
                                    "\n" +
                                    "Quedo a la espera de su respuesta, y agradezco de antemano su atención y consideración.\n" +
                                    "\n" +
                                    "Un cordial saludo,\n" +
                                    "\n" +
                                    "Jeremy Quispe\n" +
                                    "Representante de Vinicius",
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                                fontSize = 14.sp,
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}