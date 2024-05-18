package edu.put.szlakiturystyczne

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrailList(trails: List<Trail>, onTrailSelected: (Trail) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(trails.size) { index ->
            TrailListItem(trail = trails[index], onTrailSelected = onTrailSelected)
        }
    }
}

@Composable
fun TrailListItem(trail: Trail, onTrailSelected: (Trail) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onTrailSelected(trail) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trail.name, style = MaterialTheme.typography.h6)
            Text(text = trail.description, style = MaterialTheme.typography.body2)
        }
    }
}
