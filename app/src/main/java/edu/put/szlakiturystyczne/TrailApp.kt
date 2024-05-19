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
                                TrailList(trails,"Tatry") { trail -> selectedTrail.value = trail }
                            }
                            selectedTrail.value?.let { trail ->
                                Column(modifier = Modifier.weight(1f)) {
                                    TrailDetails(trail,filter = "Tatry") {
                                        selectedTrail.value = null
                                    }
                                }
                            }
                        }
                    } else {
                        if (selectedTrail.value == null) {
                            TrailList(trails,"Tatry") { trail -> selectedTrail.value = trail }
                        } else {
                            TrailDetails(selectedTrail.value!!,filter = "Tatry") {
                                selectedTrail.value = null
                            }
                        }
                    }
                }
                composable("rest") {
                    if (isWideScreen()) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier.weight(1f)) {
                                TrailList(trails,"Rest") { trail -> selectedTrail.value = trail }
                            }
                            selectedTrail.value?.let { trail ->
                                Column(modifier = Modifier.weight(1f)) {
                                    TrailDetails(trail,filter = "Rest") {
                                        selectedTrail.value = null
                                    }
                                }
                            }
                        }
                    } else {
                        if (selectedTrail.value == null) {
                            TrailList(trails,"Rest") { trail -> selectedTrail.value = trail }
                        } else {
                            TrailDetails(selectedTrail.value!!,filter = "Rest") {
                                selectedTrail.value = null
                            }
                        }
                    }
                }
            }
        }

    }}
