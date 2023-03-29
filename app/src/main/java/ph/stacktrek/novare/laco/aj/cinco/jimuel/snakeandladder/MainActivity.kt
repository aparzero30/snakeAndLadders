package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trophyImageView = findViewById<AppCompatImageView>(R.id.trophy)

        trophyImageView.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace FragmentName with the name of your fragment class
            val fragment = leaderboard_fragment()
            fragmentTransaction.replace(R.id.fragment_container_leaderboard, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}
