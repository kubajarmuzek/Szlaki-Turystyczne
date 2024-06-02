package edu.put.szlakiturystyczne

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailAppWithAnimation()
        }
    }
}

@Composable
fun TrailAppWithAnimation() {
    // Define a boolean state to toggle visibility
    var isVisible by remember { mutableStateOf(false) }

    // Define the transition
    val transition = updateTransition(targetState = isVisible, label = "visibilityTransition")

    // Define alpha value based on transition
    val alpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 1000) },
        label = "alphaTransition"
    ) { visibility ->
        if (visibility) 1f else 0f
    }

    // Content of the app with animation
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            // AnimatedVisibility animates the content based on visibility
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(5000)),
                exit = fadeOut(animationSpec = tween(5000))
            ) {
                TrailApp()
            }
        }
    }

    // Toggle visibility after delay
    LaunchedEffect(key1 = isVisible) {
        isVisible = true // Show the content
        delay(1000) // Wait for 1000 milliseconds (1 second)
        isVisible = false // Hide the content
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrailAppWithAnimation()
}

