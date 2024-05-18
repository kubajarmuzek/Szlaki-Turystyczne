package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting()
        Description()
        CategoryCard(title = "Tatry Trails") {
            navController.navigate("tatry")
        }
        CategoryCard(title = "Other Trails") {
            navController.navigate("rest")
        }
    }
}


@Composable
fun Greeting() {
    Text(
        text = "Welcome to the Trail App!",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun Description() {
    Text(
        text = "Explore and discover various trails for hiking, trekking, and outdoor adventures!",
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun CategoryCard(title: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(title)
    }
}
