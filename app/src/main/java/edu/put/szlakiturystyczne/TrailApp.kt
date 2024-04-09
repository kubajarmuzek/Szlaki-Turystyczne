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
            Row(modifier = Modifier.fillMaxSize()) {
                // Pierwsza kolumna dla listy szlaków
                Column(modifier = Modifier.weight(1f)) {
                    TrailList(trails, selectedTrail) { trail -> selectedTrail.value = trail }
                }
                // Druga kolumna dla szczegółów wybranego szlaku (jeśli istnieje)
                selectedTrail.value?.let { trail ->
                    Column(modifier = Modifier.weight(1f)) {
                        TrailDetails(trail) {
                            selectedTrail.value = null
                        }
                    }
                }
            }
        } else {
            // Wyświetl listę szlaków lub szczegóły wybranego szlaku w zależności od wyboru użytkownika
            if (selectedTrail.value == null) {
                TrailList(trails, selectedTrail) { trail -> selectedTrail.value = trail }
            } else {
                TrailDetails(selectedTrail.value!!) {
                    selectedTrail.value = null
                }
            }
        }
    }
}



