package edu.put.szlakiturystyczne

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.navigation.NavController

@Composable
fun TrailDetails(trail: Trail, filter:String, navController: NavController, onBackClicked: () -> Unit) {
    var selectedPace by remember { mutableStateOf(Pace.NORMALNIE) }
    var activeStage by remember { mutableStateOf<Int?>(null) }
    var factShown by remember { mutableStateOf(false) }
    var dialogDismissed by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { factShown = true }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
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

                if (factShown && !dialogDismissed) {
                    AlertDialog(
                        onDismissRequest = {
                            dialogDismissed = true
                            factShown = false
                        },
                        title = { Text(text = "Ciekawostka") },
                        text = { Text(text = getRandomFact(filter)) },
                        confirmButton = {
                            Button(onClick = {
                                dialogDismissed = true
                                factShown = false
                            }) {
                                Text(text = "OK")
                            }
                        }
                    )
                }
            }
        }
    )

    BackHandler(onBack = {
        onBackClicked()
        navController.popBackStack()
    })
}

@Composable
private fun getRandomFact(filter: String): String {
    val tatryFacts = remember {
        listOf(
            "Tatry to najwyższe pasmo górskie w Polsce.",
            "W Tatrach znajduje się wiele jaskiń, w tym jaskinia Wielka Śnieżna.",
            "Najwyższym szczytem Tatr jest Gerlach (2655 m n.p.m.)."
        )
    }

    val otherFacts = remember {
        listOf(
            "Beskidy to pasmo górskie w Polsce i Czechach.",
            "W Sudetach znajduje się wiele pięknych wodospadów, takich jak Wodospad Kamieńczyka.",
            "Bieszczady słyną z dzikiej przyrody i niezwykłych widoków."
        )
    }

    if (filter == "Tatry") {
        return tatryFacts.random()
    }
    else {
        return otherFacts.random()
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
        Pace.POWOLI -> 3f
        Pace.NORMALNIE -> 5f
        Pace.SZYBKO -> 6f
    }
    val timeInMinutes = distance / paceFactor * 60
    val hours = timeInMinutes.toInt() / 60
    val minutes = timeInMinutes.toInt() % 60
    return String.format("%02d:%02d", hours, minutes)
}

fun calculateEstimatedTimeMillis(distance: Float, pace: Pace): Long {
    val paceFactor = when (pace) {
        Pace.POWOLI -> 3f
        Pace.NORMALNIE -> 5f
        Pace.SZYBKO -> 6f
    }
    return (distance / paceFactor * 60 * 60 * 1000).toLong()
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
