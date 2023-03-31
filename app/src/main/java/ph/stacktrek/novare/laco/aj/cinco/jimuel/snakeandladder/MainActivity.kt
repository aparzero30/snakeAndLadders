package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.adapters.PlayerAdapter
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.ActivityMainBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.AddPlayerBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.Player
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.PlayerDAO
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.PlayertDAOStubImplementation
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var playerAdapter: PlayerAdapter
    private lateinit var playerDAO: PlayerDAO
    private lateinit var itemTouchHelper: ItemTouchHelper

    private lateinit var parentView: ViewGroup
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    private var page = 0







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val frameLayout = findViewById<FrameLayout>(R.id.home) // get a reference to the FrameLayout
        val textView = TextView(this) // create a new TextView object
        frameLayout.addView(textView) // add the TextView to the FrameLayout


        binding.trophy.setOnClickListener {

            page = 1

            binding.addButton.visibility = View.INVISIBLE
            binding.startButton.visibility = View.INVISIBLE

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace FragmentName with the name of your fragment class
            val fragment = leaderboard_fragment()
            fragmentTransaction.replace(R.id.home, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        binding.addButton.setOnClickListener {
            showAddPlayerDialogue().show()
        }

        binding.startButton.setOnClickListener {

            page = 2

            parentView = binding.playersList.parent as ViewGroup
            parentView.removeView(binding.playersList)

            binding.addButton.visibility = View.INVISIBLE
            binding.startButton.visibility = View.INVISIBLE


            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Replace FragmentName with the name of your fragment class
            val fragment = BoardFragment()
            fragmentTransaction.replace(R.id.home, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        loadPlayers()


    }



    fun loadPlayers(){
        playerDAO = PlayertDAOStubImplementation()
        playerAdapter = PlayerAdapter(applicationContext, playerDAO.getPlayers() as ArrayList<Player>)
        with(binding.playersList){
            layoutManager = GridLayoutManager(applicationContext, 1)
            adapter = playerAdapter


        }
    }

    fun showAddPlayerDialogue(): Dialog {
        return this!!.let {
            val builder = AlertDialog.Builder(it)
            var dialogueAddPlayerBinding: AddPlayerBinding =
                AddPlayerBinding.inflate(it.layoutInflater)
            with(builder) {

               var imagePath = ""

                dialogueAddPlayerBinding.avatar1.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby1
                    )
                    val file = File(applicationContext.filesDir, "main_image.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                dialogueAddPlayerBinding.avatar2.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby2
                    )
                    val file = File(applicationContext.filesDir, "main_image.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                dialogueAddPlayerBinding.avatar3.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby3
                    )
                    val file = File(applicationContext.filesDir, "main_image.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                dialogueAddPlayerBinding.avatar4.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby4
                    )
                    val file = File(applicationContext.filesDir, "main_image.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                dialogueAddPlayerBinding.avatar5.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby5
                    )
                    val file = File(applicationContext.filesDir, "main_image.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                setPositiveButton("ADD", DialogInterface.OnClickListener { dialog, id ->
                    val name = dialogueAddPlayerBinding.playerName.text.toString().trim()
                    if (name.isNotEmpty()) {
                        val product = Player(name)
                        product.imagePath = imagePath;
                        val playerDAO = PlayertDAOStubImplementation()
                        playerDAO.addPlayer(product)
                        playerAdapter.addPlayer(product)
                    } else {
                        Toast.makeText(context, "Product name cannot be empty", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
                setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, id ->

                })
                setView(dialogueAddPlayerBinding.root)
                create()
            }
        }
    }
    override fun onBackPressed() {

            binding.addButton.visibility = View.VISIBLE
            binding.startButton.visibility = View.VISIBLE

        recyclerView = binding.playersList

        if (recyclerView.parent == null) {
            binding.home.addView(recyclerView)

        } else {
            // Handle the default back press behavior
            super.onBackPressed()
        }

        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}