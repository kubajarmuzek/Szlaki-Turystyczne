package edu.put.szlakiturystyczne

import androidx.compose.material.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrailApp() {
    val trails = remember { trails }
    val selectedTrail = remember { mutableStateOf<Trail?>(null) }

    Surface(color = MaterialTheme.colors.background) {
        if (isWideScreen()) {
            Row {
                TrailList(trails) { trail -> selectedTrail.value = trail }
                Spacer(modifier = Modifier.width(8.dp))
                selectedTrail.value?.let {
                    TrailDetails(it) {
                        selectedTrail.value = null
                    }
                }
            }
        } else {
            if (selectedTrail.value == null) {
                TrailList(trails) { trail -> selectedTrail.value = trail }
            } else {
                TrailDetails(selectedTrail.value!!) {
                    selectedTrail.value = null
                }
            }
        }
    }
}
