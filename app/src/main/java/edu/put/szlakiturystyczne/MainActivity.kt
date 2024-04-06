package edu.put.szlakiturystyczne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrailApp()
}
