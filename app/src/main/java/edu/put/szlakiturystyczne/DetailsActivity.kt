package edu.put.szlakiturystyczne

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.put.szlakiturystyczne.Trail

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve the Trail object from intent extras
        val trail: Trail? = intent.getParcelableExtra("trail")

        // Populate UI with trail details
        trail?.let { populateTrailDetails(it) }
    }

    private fun populateTrailDetails(trail: Trail) {
        // Find UI elements
        val nameTextView: TextView = findViewById(R.id.textViewTrailName)
        val typeTextView: TextView = findViewById(R.id.textViewTrailType)
        val descriptionTextView: TextView = findViewById(R.id.textViewDescription)
        val stagesLayout: LinearLayout = findViewById(R.id.layoutStages)

        // Set trail details to UI elements
        nameTextView.text = trail.name
        typeTextView.text = trail.type
        descriptionTextView.text = trail.description

        // Populate stages
        for (stage in trail.stages) {
            val stageTextView = TextView(this)
            stageTextView.text = "${stage.name}: ${stage.description}"
            stagesLayout.addView(stageTextView)
        }
    }

}
