package pe.edu.upc.diligencetech.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pe.edu.upc.diligencetech.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkbenchScreen(
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.brand),
                        contentDescription = null,
                        modifier = Modifier
                            .size(187.dp, 100.dp)
                            .padding(bottom = 8.dp),
                        contentScale = ContentScale.Fit
                    )
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Constants.CARD_BACKGROUND_COLOR,
                )
            )
        },
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            content()
        }
    }
}

@Composable
fun BottomBar() {
    Row (
        modifier = Modifier
            .background(Constants.CARD_BACKGROUND_COLOR)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        BottomBarItem(
            imageVector = Icons.Filled.Home,
            text = "Inicio"
        ) {

        }
        BottomBarItem(
            imageVector = Icons.Filled.DateRange,
            text = "Proyectos"
        ) {

        }
        BottomBarItem(
            imageVector = Icons.Filled.Email,
            text = "Mensajes"
        ) {

        }
        BottomBarItem(
            imageVector = Icons.Filled.Person,
            text = "Perfil"
        ) {

        }
        BottomBarItem(
            imageVector = Icons.Filled.Settings,
            text = "Ajustes"
        ) {

        }
    }
}

@Composable
fun BottomBarItem(imageVector: ImageVector, text: String, onClick: () -> Unit = {}) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = text,
                tint = Color.White
            )
            Text(text, color = Color.White)
        }
    }
}