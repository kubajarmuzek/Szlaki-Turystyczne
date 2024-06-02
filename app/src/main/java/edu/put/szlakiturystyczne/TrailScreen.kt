package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TrailScreen(
    trails: List<Trail>,
    type: String,
    navController: NavController,
    selectedTrail: MutableState<Trail?>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (isWideScreen()) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(1f)) {
                    TrailList(trails = trails, type = type) { trail ->
                        selectedTrail.value = trail
                    }
                }
                selectedTrail.value?.let { trail ->
                    Column(modifier = Modifier.weight(1f)) {
                        TrailDetails(trail, filter = type, navController = navController) {
                            selectedTrail.value = null
                        }
                    }
                }
            }
        } else {
            if (selectedTrail.value == null) {
                // Show the list if no trail is selected
                TrailList(trails = trails, type = type) { trail ->
                    selectedTrail.value = trail
                }
            } else {
                // Show the details if a trail is selected
                TrailDetails(
                    trail = selectedTrail.value!!,
                    filter = type,
                    navController = navController
                ) {
                    selectedTrail.value = null
                }
            }
        }
    }
}
