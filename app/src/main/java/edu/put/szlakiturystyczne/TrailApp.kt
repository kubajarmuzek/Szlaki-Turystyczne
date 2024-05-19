package edu.put.szlakiturystyczne

import androidx.compose.material.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun TrailApp() {
    val navController = rememberNavController()
    val trails = remember { trails }
    val selectedTrail = remember { mutableStateOf<Trail?>(null) }



    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "home",
                    onClick = {
                        navController.navigate("home") {
                            launchSingleTop = true
                        }
                    },
                    icon = { /* Home icon */ },
                    label = { Text("Home") }
                )
                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "tatry",
                    onClick = {
                        navController.navigate("tatry") {
                            launchSingleTop = true
                        }
                    },
                    icon = { /* Details icon */ },
                    label = { Text("Tatry") }
                )
                BottomNavigationItem(
                    selected = navController.currentDestination?.route == "rest",
                    onClick = {
                        navController.navigate("rest") {
                            launchSingleTop = true
                        }
                    },
                    icon = { /* Details icon */ },
                    label = { Text("Rest") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        )
        {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(navController = navController)
                }
                composable("tatry") {
                    if (isWideScreen()) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier.weight(1f)) {
                                TrailList(trails,"Tatry") { trail ->
                                    navController.navigate("details/${trail.name}")
                                }
                            }
                            selectedTrail.value?.let { trail ->
                                Column(modifier = Modifier.weight(1f)) {
                                    TrailDetails(trail,filter = "Tatry", navController) {
                                        selectedTrail.value = null
                                    }
                                }
                            }
                        }
                    } else {
                        if (true || selectedTrail.value == null) {
                            TrailList(trails,"Tatry") { trail ->
                                navController.navigate("details/${trail.name}")
                            }
                        } else {
                            TrailDetails(selectedTrail.value!!,filter = "Tatry",navController) {
                                selectedTrail.value = null
                            }
                        }
                    }
                }
                composable("rest") {
                    if (isWideScreen()) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier.weight(1f)) {
                                TrailList(trails,"Rest") { trail ->
                                    navController.navigate("details/${trail.name}")
                                }
                            }
                            selectedTrail.value?.let { trail ->
                                Column(modifier = Modifier.weight(1f)) {
                                    TrailDetails(trail,filter = "Rest",navController) {
                                        selectedTrail.value = null
                                    }
                                }
                            }
                        }
                    } else {
                        if (true || selectedTrail.value == null) {
                            TrailList(trails,"Rest") {  trail ->
                                navController.navigate("details/${trail.name}")
                             }
                        } else {
                            TrailDetails(selectedTrail.value!!,filter = "Rest",navController) {
                                selectedTrail.value = null
                            }
                        }
                    }
                }
                composable("details/{trailName}") { backStackEntry ->
                    val trailName = backStackEntry.arguments?.getString("trailName")
                    val trail = trails.find { it.name == trailName }
                    if (trail != null) {
                        TrailDetailsScreen(trail = trail, filter = "Tatry", navController = navController)
                    } else {
                        // Handle case where trail is not found
                    }
                }
            }
        }

    }}
