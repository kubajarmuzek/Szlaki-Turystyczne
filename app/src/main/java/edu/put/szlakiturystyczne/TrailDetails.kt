package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

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
        for (stage in trail.stages) {
            val estimatedTimeMillis = calculateEstimatedTimeMillis(stage.distance, selectedPace)
            val estimatedTime = calculateEstimatedTime(stage.distance,selectedPace)
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
        Row{Text(text = "Szacowany czas przejścia: ${estimatedTime}", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = onStartClicked) {
                Text(text = "Stoper", style = MaterialTheme.typography.body2)
            }}
        Spacer(modifier = Modifier.height(8.dp))

    }
}

enum class Pace {
    POWOLI, NORMALNIE, SZYBKO
}

fun calculateEstimatedTime(distance: Float, pace: Pace): String {
    val paceFactor = when (pace) {
        Pace.POWOLI -> 0.8f
        Pace.NORMALNIE -> 1.0f
        Pace.SZYBKO -> 1.2f
    }
    val estimatedTime = distance / paceFactor
    return "${String.format("%.1f", estimatedTime)} godzin"
}

@Composable
fun PaceSelector(selectedPace: Pace, onPaceSelected: (Pace) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Tempo:", style = MaterialTheme.typography.subtitle1, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(1.dp))
        Pace.values().forEach { pace ->
            RadioButton(
                selected = selectedPace == pace,
                onClick = { onPaceSelected(pace) },
                modifier = Modifier.padding(end = 1.dp)
            )
            Text(pace.name, style = MaterialTheme.typography.body2, fontSize = 12.sp)
        }
    }
}
fun calculateEstimatedTimeMillis(distance: Float, pace: Pace): Long {
    val paceFactor = when (pace) {
        Pace.POWOLI -> 0.8f
        Pace.NORMALNIE -> 1.0f
        Pace.SZYBKO -> 1.2f
    }
    val estimatedTime = distance / paceFactor * 3600000 // Convert hours to milliseconds
    return estimatedTime.toLong()
}

