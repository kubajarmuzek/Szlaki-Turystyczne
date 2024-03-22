package edu.put.szlakiturystyczne

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Parcel
import android.os.Parcelable

data class Trail(
    val name: String,
    val type: String,
    val description: String,
    val stages: List<Stage>,
    val walkingStyles: List<String>,
    val durationPerStage: List<Int>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(Stage.CREATOR)!!,
        parcel.createStringArrayList()!!,
        parcel.readArrayList(Int::class.java.classLoader) as List<Int> // Odczytanie listy jako List<Int>
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeString(description)
        parcel.writeTypedList(stages)
        parcel.writeStringList(walkingStyles)
        parcel.writeList(durationPerStage.toList()) // Konwersja IntArray na List<Int> i zapisanie jej
    }



    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Trail> {
        override fun createFromParcel(parcel: Parcel): Trail {
            return Trail(parcel)
        }

        override fun newArray(size: Int): Array<Trail?> {
            return arrayOfNulls(size)
        }
    }
}

data class Stage(
    val name: String,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stage> {
        override fun createFromParcel(parcel: Parcel): Stage {
            return Stage(parcel)
        }

        override fun newArray(size: Int): Array<Stage?> {
            return arrayOfNulls(size)
        }
    }
}



class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewTrails)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = TrailAdapter(getDummyTrailData())

        return view
    }

    private fun getDummyTrailData(): List<Trail> {
        return listOf(
            Trail(
                name = "Szlak Górski",
                type = "Górski",
                description = "Opis szlaku górskiego...",
                stages = listOf(
                    Stage("Etap 1", "Opis etapu 1..."),
                    Stage("Etap 2", "Opis etapu 2..."),
                    Stage("Etap 3", "Opis etapu 3...")
                ),
                walkingStyles = listOf("Wolno", "Normalnie", "Szybko"),
                durationPerStage = listOf(2, 3, 4) // Przykładowe czasy przejścia etapów
            ),
            // Dodaj więcej szlaków według potrzeb
        )
    }


    inner class TrailAdapter(private val trails: List<Trail>) :
        RecyclerView.Adapter<TrailAdapter.TrailViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trail, parent, false)
            return TrailViewHolder(view)
        }

        override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
            val trail = trails[position]
            holder.bind(trail)
        }

        override fun getItemCount(): Int {
            return trails.size
        }

        inner class TrailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val nameTextView: TextView = itemView.findViewById(R.id.textViewTrailName)
            private val typeTextView: TextView = itemView.findViewById(R.id.textViewTrailType)
            private val stagesTextView: TextView = itemView.findViewById(R.id.textViewStages)

            fun bind(trail: Trail?) {
                trail?.let { // Using safe call operator to handle nullable trail
                    nameTextView.text = trail.name
                    typeTextView.text = trail.type
                    stagesTextView.text = "Etapów: ${trail.stages.size}"

                    // Add click listener to handle item click and launch DetailsActivity
                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailsActivity::class.java)
                        intent.putExtra("trail", trail) // Using safe call operator to pass nullable trail
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }

    }

}
