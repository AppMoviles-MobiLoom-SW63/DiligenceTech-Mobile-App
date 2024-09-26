package pe.edu.upc.diligencetech.duediligencemanagement.presentation

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import pe.edu.upc.diligencetech.R
import pe.edu.upc.diligencetech.common.Constants
import pe.edu.upc.diligencetech.common.Resource
import pe.edu.upc.diligencetech.common.WorkbenchScreen
import pe.edu.upc.diligencetech.duediligencemanagement.data.repositories.DueDiligenceProjectsRepository
import pe.edu.upc.diligencetech.duediligencemanagement.domain.DueDiligenceProject
import pe.edu.upc.diligencetech.ui.theme.Montserrat

@Composable
fun ProjectsListScreen(
    viewModel: ProjectsListViewModel = hiltViewModel(),
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
        onSettingsClick = onSettingsClick
    ) {

        var isLoading by remember { mutableStateOf(true) }
        var projects by remember { mutableStateOf(listOf<DueDiligenceProject>()) }
        var showDialog by remember { mutableStateOf(false) }

        viewModel.loadProjects()

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1A1A1A)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Bienvenido ")
                        withStyle(style = SpanStyle(color = Color(0xFFD6773D))) {
                            Constants.username.let {
                                append(Constants.username!!.substringBefore("@"))
                            }
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
                        .padding(top = 16.dp, bottom = 16.dp, start = 8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
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

                if (projects.isEmpty()) {
                    Text(
                        text = "No se encontraron proyectos.",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = Montserrat,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        projects.forEach { project ->
                            ProjectCard(
                                projectName = project.projectName,
                                projectType = project.projectName
                            )
                        }
                    }
                }
            }

                if (showDialog) {
                    ProjectInputDialog(
                        onDismiss = { showDialog = false },
                        onAddProject = {
                            showDialog = false
                        }
                    )
                }


            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
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
            .width(180.dp)
            .height(180.dp)
            .clickable {  },
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

            Icon(
                painter = painterResource(id = R.drawable.project_icon),
                contentDescription = "Folder",
                tint = Color(0xFFD6773D),
                modifier = Modifier.size(64.dp)
            )

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectInputDialog(
    onDismiss: () -> Unit,
    onAddProject: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .background(Color(0xFF282828), shape = RoundedCornerShape(8.dp))
                .padding(25.dp)
        ) {
            Column {
                Text(
                    text = "Crear nuevo proyecto",
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 17.sp
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF626262))
                )
                Spacer(modifier = Modifier.height(25.dp))


                OutlinedTextField(
                    value = "Hola",
                    onValueChange = { },
                    label = { Text("Nombre", fontFamily = Montserrat, color = Color.White) },
                    placeholder = {
                        Text(
                            "Ingrese nombre",
                            fontFamily = Montserrat,
                            color = Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color(0xFFD6773D),
                        unfocusedLabelColor = Color(0xFFD6773D),
                        cursorColor = Color(0xFFD6773D),
                    ),
                    shape = RoundedCornerShape(8.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = Montserrat
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            "Agentes de Compra",
                            fontFamily = Montserrat,
                            color = Color.White
                        )
                    },
                    placeholder = {
                        Text(
                            "Ingrese agentes de compra",
                            fontFamily = Montserrat,
                            color = Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color(0xFFD6773D),
                        unfocusedLabelColor = Color(0xFFD6773D),
                        cursorColor = Color(0xFFD6773D),
                    ),
                    shape = RoundedCornerShape(8.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            "Agentes de Venta",
                            fontFamily = Montserrat,
                            color = Color.White
                        )
                    },
                    placeholder = {
                        Text(
                            "Ingrese agentes de venta",
                            fontFamily = Montserrat,
                            color = Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color(0xFFD6773D),
                        unfocusedLabelColor = Color(0xFFD6773D),
                        cursorColor = Color(0xFFD6773D),
                    ),
                    shape = RoundedCornerShape(8.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.height(46.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            onAddProject()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFFD6773D)
                        ),
                        modifier = Modifier
                            .weight(1f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            "Cancelar",
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD6773D),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .weight(1f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            "Crear",
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }
    }
}
