package pe.edu.upc.diligencetech.duediligencemanagement.presentation

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.diligencetech.R
import pe.edu.upc.diligencetech.common.WorkbenchScreen
import pe.edu.upc.diligencetech.ui.theme.Montserrat

@Composable
fun ProjectsListScreen(
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = buildAnnotatedString {
                append("Bienvenido ")
                withStyle(style = SpanStyle(color = Color(0xFFD6773D))) {
                    append("Jorge Valdivia")
                }
            },
            style = TextStyle(
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, bottom = 30.dp, top = 30.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF282828))
                .padding(top= 16.dp, bottom = 16.dp, start= 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "Todos los proyectos",
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 16.sp,
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()), // Hacer la columna desplazable
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                ProjectCard(projectName = "Proyecto Messi", projectType = "Buy-Side")
                ProjectCard(projectName = "Proyecto Vinicius", projectType = "Sell-Side")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre filas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                ProjectCard(projectName = "Proyecto Ronaldo", projectType = "Buy-Side")
                ProjectCard(projectName = "Proyecto Neymar", projectType = "Sell-Side")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre filas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                ProjectCard(projectName = "Proyecto Ronaldo", projectType = "Buy-Side")
                ProjectCard(projectName = "Proyecto Neymar", projectType = "Sell-Side")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre filas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                ProjectCard(projectName = "Proyecto Ronaldo", projectType = "Buy-Side")
                ProjectCard(projectName = "Proyecto Neymar", projectType = "Sell-Side")
            }
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

@Composable
fun ProjectCard(projectName: String, projectType: String) {
    Card(
        modifier = Modifier
            .width(180.dp) // Adjust width proportionally for two cards in a row
            .height(180.dp)
            .clickable { /* Handle click here */ },
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF282828)),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Number at top left (example)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "1.",
                    color = Color.White,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold
                )
            }

            // Folder Icon in the center
            Icon(
                painter = painterResource(id = R.drawable.project_icon), // Replace with your folder icon
                contentDescription = "Folder",
                tint = Color(0xFFD6773D),
                modifier = Modifier.size(64.dp)
            )

            // Project Name at the bottom
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = projectName,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = projectType,
                    color = Color(0xFFD6773D),
                    fontFamily = Montserrat,
                    fontSize = 12.sp
                )
            }
        }
    }
}