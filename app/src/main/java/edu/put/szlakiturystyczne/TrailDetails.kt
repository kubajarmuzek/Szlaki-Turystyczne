package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState

@Composable
fun TrailDetails(trail: Trail, onBackClicked: () -> Unit) {
    var selectedPace by remember { mutableStateOf(Pace.NORMALNIE) }
    var activeStage by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = trail.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Opis: ${trail.description}", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(16.dp))
        Stopwatch()
        trail.stages.forEach { stage ->
            val estimatedTimeMillis = calculateEstimatedTimeMillis(stage.distance, selectedPace)
            val estimatedTime = calculateEstimatedTime(stage.distance, selectedPace)
            StageItem(stage = stage, estimatedTime = estimatedTime) {
                activeStage = stage.id
            }
            if (activeStage == stage.id) {
                CountdownTimer(estimatedTimeMillis)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        PaceSelector(selectedPace = selectedPace, onPaceSelected = { selectedPace = it })
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onBackClicked) {
            Text("Wróć do listy")
        }
    }
}

@Composable
fun StageItem(stage: Stage, estimatedTime: String, onStartClicked: () -> Unit) {
    Column {
        Text(text = "Odcinek: ${stage.name}", style = MaterialTheme.typography.body1)
        Text(text = "Długość: ${stage.distance} km", style = MaterialTheme.typography.body2)
        Row {
            Text(text = "Szacowany czas przejścia: $estimatedTime", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onStartClicked) {
                Text(text = "Stoper", style = MaterialTheme.typography.body2)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

enum class Pace {
    POWOLI, NORMALNIE, SZYBKO
}

fun calculateEstimatedTime(distance: Float, pace: Pace): String {
    val paceFactor = when (pace) {
        Pace.POWOLI -> 5f
        Pace.NORMALNIE -> 4f
        Pace.SZYBKO -> 3f
    }
    val timeInMinutes = distance * paceFactor * 60
    val hours = timeInMinutes.toInt() / 60
    val minutes = timeInMinutes.toInt() % 60
    return String.format("%02d:%02d", hours, minutes)
}

fun calculateEstimatedTimeMillis(distance: Float, pace: Pace): Long {
    val paceFactor = when (pace) {
        Pace.POWOLI -> 5f
        Pace.NORMALNIE -> 4f
        Pace.SZYBKO -> 3f
    }
    return (distance * paceFactor * 60 * 60 * 1000).toLong()
}

@Composable
fun PaceSelector(selectedPace: Pace, onPaceSelected: (Pace) -> Unit) {
    Column {
        Text(text = "Wybierz tempo:", style = MaterialTheme.typography.h6)
        Row {
            Pace.values().forEach { pace ->
                Button(
                    onClick = { onPaceSelected(pace) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = pace.name)
                }
            }
        }
    }
}
