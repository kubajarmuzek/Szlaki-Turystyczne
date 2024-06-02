package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrailApp() {
    val navController = rememberNavController()
    val trails = remember { trails }
    val selectedTrail = remember { mutableStateOf<Trail?>(null) }
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

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
                HomeScreen(navController = navController)
            }
        }}

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val tabTitles = listOf("home", "tatry", "rest")
                tabTitles.forEachIndexed { index, title ->
                    BottomNavigationItem(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                            navController.navigate(title) {
                                launchSingleTop = true
                            }
                            // Reset selectedTrail when navigating to a different destination
                            selectedTrail.value = null
                        },
                        icon = { /* Icon based on title */ },
                        label = { Text(title.capitalize()) }
                    )
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            HorizontalPager(
                count = 3,
                state = pagerState,
            ) { page ->
                val currentPage by rememberUpdatedState(newValue = page)

                // No need to reset selectedTrail here

                when (currentPage) {
                    0 -> HomeScreen(navController = navController)
                    1 -> TrailScreen(trails = trails, type = "Tatry", navController = navController, selectedTrail = selectedTrail)
                    2 -> TrailScreen(trails = trails, type = "Rest", navController = navController, selectedTrail = selectedTrail)
                }
            }
        }
    }




}

