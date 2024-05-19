package edu.put.szlakiturystyczne

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TrailDetailsScreen(trail: Trail, filter: String, navController: NavController) {
    TrailDetails(trail = trail, filter = filter,navController, onBackClicked = { navController.popBackStack() })
}
