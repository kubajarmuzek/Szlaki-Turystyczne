package edu.put.szlakiturystyczne

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

@Composable
fun Stopwatch() {
    var elapsedTime by remember { mutableStateOf(0L) }
    var isRunning by remember { mutableStateOf(false) }
    var timerJob by remember { mutableStateOf<Job?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTime(elapsedTime),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if (!isRunning) {
                    timerJob = startTimer(elapsedTime) { updatedTime ->
                        elapsedTime = updatedTime
                    }
                    isRunning = true
                }
            }) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                timerJob?.cancel()
                isRunning = false
            }) {
                Text(text = "Stop")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                timerJob?.cancel()
                isRunning = false
                elapsedTime = 0
            }) {
                Text(text = "Reset")
            }
        }
    }
}

private fun startTimer(initialTime: Long, onUpdate: (Long) -> Unit): Job {
    return CoroutineScope(Dispatchers.Default).launch {
        var elapsedTime = initialTime
        while (true) {
            delay(1000)
            elapsedTime -= 1000
            if (elapsedTime <= 0) {
                break
            }
            withContext(Dispatchers.Main) {
                onUpdate(elapsedTime)
            }
        }
    }
}

private fun formatTime(timeInMillis: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(timeInMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
fun CountdownTimer(estimatedTimeMillis: Long) {
    var remainingTime by remember { mutableStateOf(estimatedTimeMillis) }
    var isRunning by remember { mutableStateOf(false) }
    var timerJob by remember { mutableStateOf<Job?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTime(remainingTime),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if (!isRunning) {
                    timerJob = startTimer(remainingTime) { updatedTime ->
                        remainingTime = updatedTime
                    }
                    isRunning = true
                }
            }) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                timerJob?.cancel()
                isRunning = false
            }) {
                Text(text = "Stop")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                timerJob?.cancel()
                isRunning = false
                remainingTime = estimatedTimeMillis
            }) {
                Text(text = "Reset")
            }
        }
    }
}
