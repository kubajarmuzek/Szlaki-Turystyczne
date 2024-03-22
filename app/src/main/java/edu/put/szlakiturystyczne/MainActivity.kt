package edu.put.szlakiturystyczne

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if savedInstanceState is null to avoid adding fragment on configuration changes
        if (savedInstanceState == null) {
            // Add MainFragment as the initial fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment())
                .commit()
        }
    }

    // Function to navigate to another fragment
    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)  // Add fragment transaction to back stack
            .commit()
    }
}
