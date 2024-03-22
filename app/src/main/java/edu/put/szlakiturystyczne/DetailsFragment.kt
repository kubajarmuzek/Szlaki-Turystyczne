package edu.put.szlakiturystyczne

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.put.szlakiturystyczne.Trail

class DetailsFragment : Fragment() {
    private var trail: Trail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trail = it.getParcelable("trail")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        // Populate UI with trail details
        trail?.let { populateTrailDetails(view, it) }

        return view
    }

    private fun populateTrailDetails(view: View, trail: Trail) {
        // Find UI elements
        val nameTextView: TextView = view.findViewById(R.id.textViewTrailName)
        val typeTextView: TextView = view.findViewById(R.id.textViewTrailType)
        val descriptionTextView: TextView = view.findViewById(R.id.textViewDescription)
        val stagesLayout: LinearLayout = view.findViewById(R.id.layoutStages)

        // Set trail details to UI elements
        nameTextView.text = trail.name
        typeTextView.text = trail.type
        descriptionTextView.text = trail.description

        Log.d("Stages","${trail.stages}")
        // Populate stages
        for (stage in trail.stages) {
            val stageTextView = TextView(context)
            stageTextView.text = "${stage.name}: ${stage.description}"
            stagesLayout.addView(stageTextView)
        }
    }



    companion object {
        @JvmStatic
        fun newInstance(trail: Trail) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("trail", trail)
                }
            }
    }
}

