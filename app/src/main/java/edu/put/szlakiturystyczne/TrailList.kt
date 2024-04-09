package edu.put.szlakiturystyczne

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrailList(trails: List<Trail>, selectedTrail: MutableState<Trail?>, onTrailSelected: (Trail) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        // Pierwsza kolumna dla listy szlaków
        Column(modifier = Modifier.weight(1f)) {
            LazyColumn {
                items(trails) { trail ->
                    TrailListItem(
                        trail = trail,
                        isSelected = trail == selectedTrail.value,
                        onTrailSelected = { onTrailSelected(trail) }
                    )
                }
            }
        }
    }
}
@Composable
fun TrailListItem(trail: Trail, isSelected: Boolean, onTrailSelected: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onTrailSelected() },
        elevation = 8.dp,
        backgroundColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trail.name, style = MaterialTheme.typography.h6)
            Text(text = trail.description, style = MaterialTheme.typography.body2)
        }
    }
}
