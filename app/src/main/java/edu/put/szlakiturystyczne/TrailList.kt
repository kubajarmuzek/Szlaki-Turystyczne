package edu.put.szlakiturystyczne

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrailListItem(trail: Trail, onTrailSelected: (Trail) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onTrailSelected(trail) },
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trail.name, style = MaterialTheme.typography.h6)
            Text(text = trail.description, style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun TrailList(trails: List<Trail>, onTrailSelected: (Trail) -> Unit) {
    LazyColumn {
        items(trails) { trail ->
            TrailListItem(trail = trail, onTrailSelected = { onTrailSelected(trail) })
        }
    }
}