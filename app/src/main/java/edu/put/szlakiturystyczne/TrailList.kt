package edu.put.szlakiturystyczne

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrailList(trails: List<Trail>,type: String, onTrailSelected: (Trail) -> Unit) {
    FilteredTrailList(trails = trails, type = type, onTrailSelected = onTrailSelected)

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

@Composable
fun FilteredTrailList(trails: List<Trail>, type: String, onTrailSelected: (Trail) -> Unit) {
    val filteredTrails = remember(trails, type) {
        trails.filter { it.type == type }
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(filteredTrails.size) { index ->
            TrailListItem(trail = filteredTrails[index], onTrailSelected = onTrailSelected)
        }
    }
}

