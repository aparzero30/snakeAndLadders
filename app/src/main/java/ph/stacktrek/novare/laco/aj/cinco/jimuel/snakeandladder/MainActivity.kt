package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frameLayout = findViewById<FrameLayout>(R.id.home) // get a reference to the FrameLayout
        val textView = TextView(this) // create a new TextView object
        frameLayout.addView(textView) // add the TextView to the FrameLayout

        val startButton = findViewById<AppCompatButton>(R.id.start_button)
        val addButton = findViewById<AppCompatButton>(R.id.add_button)


        val trophyImageView = findViewById<AppCompatImageView>(R.id.trophy)

        trophyImageView.setOnClickListener {


            startButton.visibility = View.GONE
            addButton.visibility = View.GONE

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace FragmentName with the name of your fragment class
            val fragment = leaderboard_fragment()
            fragmentTransaction.replace(R.id.home, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        startButton.setOnClickListener {


            startButton.visibility = View.GONE
            addButton.visibility = View.GONE

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace FragmentName with the name of your fragment class
            val fragment = BoardFragment()
            fragmentTransaction.replace(R.id.home, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val startButton = findViewById<AppCompatButton>(R.id.start_button)
        val addButton = findViewById<AppCompatButton>(R.id.add_button)
        startButton.visibility = View.VISIBLE
        addButton.visibility = View.VISIBLE
    }

}
