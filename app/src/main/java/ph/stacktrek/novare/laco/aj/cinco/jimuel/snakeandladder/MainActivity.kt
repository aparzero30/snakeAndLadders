package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.AddPlayerBinding


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

        addButton.setOnClickListener {
            showAddProductDialogue().show()
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

    fun showAddProductDialogue(): Dialog {
        return this!!.let{
            val builder = AlertDialog.Builder(it)
            var dialogueAddProductBinding : AddPlayerBinding =
                AddPlayerBinding.inflate(it.layoutInflater)
            with(builder){
                setPositiveButton("ADD", DialogInterface.OnClickListener{
                        dialog, id ->

                })
                setNegativeButton("CANCEL", DialogInterface.OnClickListener{ dialog, id ->

                })
                setView(dialogueAddProductBinding.root)
                create()
            }
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
