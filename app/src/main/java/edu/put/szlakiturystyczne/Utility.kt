package edu.put.szlakiturystyczne

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity

@Composable
fun isWideScreen(): Boolean {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val smallestScreenWidthDp = configuration.smallestScreenWidthDp
    val density = LocalDensity.current.density
    return screenWidthDp / density >= 600 || smallestScreenWidthDp / density >= 600
}
