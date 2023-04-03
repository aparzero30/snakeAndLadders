package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.adapters.PlayerAdapter
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.ActivityMainBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.AddPlayerBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.MapLegendBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.MusicBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.WinnerPageBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.Player
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.PlayerDAO
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.PlayertDAOStubImplementation
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var playerAdapter: PlayerAdapter
    private lateinit var playerDAO: PlayerDAO

    private lateinit var parentView: ViewGroup
    private lateinit var recyclerView: RecyclerView
    private var page = 0
    private var playerCount = 5

    private lateinit var mediaPlayer: MediaPlayer
    private var musicOn:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )



        mediaPlayer = MediaPlayer.create(this, R.raw.pokemon)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






        val frameLayout = findViewById<FrameLayout>(R.id.home) // get a reference to the FrameLayout
        val textView = TextView(this) // create a new TextView object
        frameLayout.addView(textView) // add the TextView to the FrameLayout


        binding.trophy.setOnClickListener {

            if (page == 1) {
                page = 2
            } else {
                page = 1;
                println("dumaan sakne ${page}")
            }


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


        binding.mapLegend.setOnClickListener {
            showMapLegends().show()
        }

        binding.music.setOnClickListener {
            showMusicSettings().show()
        }

        binding.addButton.setOnClickListener {
            if (playerCount > 0) {
                showAddPlayerDialogue().show()
            } else {
                Toast.makeText(applicationContext, "Max player reached!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.startButton.setOnClickListener {


            if (playerCount != 5) {
                page = 1
                parentView = binding.playersList.parent as ViewGroup

                binding.addButton.visibility = View.INVISIBLE
                binding.startButton.visibility = View.INVISIBLE


                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                // Replace FragmentName with the name of your fragment class
                val fragment = BoardFragment()

                val bundle = Bundle()
                bundle.putParcelableArrayList("key", playerDAO.getPlayers())
                fragment.arguments = bundle
                fragmentTransaction.replace(R.id.home, fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()


            } else {
                Toast.makeText(applicationContext, "Add player first", Toast.LENGTH_SHORT)
                    .show()
            }


        }

        loadPlayers()


    }


    fun loadPlayers() {
        playerDAO = PlayertDAOStubImplementation()
        playerAdapter =
            PlayerAdapter(applicationContext, playerDAO.getPlayers() as ArrayList<Player>)
        with(binding.playersList) {
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


                var imagePath = "a"

                val image = BitmapFactory.decodeResource(
                    applicationContext.resources,
                    R.drawable.lobby1
                )
                val file = File(applicationContext.filesDir, "default.jpg")
                val fileOutputStream = FileOutputStream(file)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                fileOutputStream.flush()
                fileOutputStream.close()
                imagePath = file.absolutePath


                dialogueAddPlayerBinding.avatar1.setOnClickListener {
                    val image = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.lobby1
                    )
                    val file = File(applicationContext.filesDir, "avatar1.jpg")
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
                    val file = File(applicationContext.filesDir, "avatar2.jpg")
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
                    val file = File(applicationContext.filesDir, "avatar3.jpg")
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
                    val file = File(applicationContext.filesDir, "avatar4.jpg")
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
                    val file = File(applicationContext.filesDir, "avatar5.jpg")
                    val fileOutputStream = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.flush()
                    fileOutputStream.close()
                    imagePath = file.absolutePath

                }

                setPositiveButton("ADD", DialogInterface.OnClickListener { dialog, id ->
                    val name = dialogueAddPlayerBinding.playerName.text.toString().trim()
                    if (name.isNotEmpty()) {


                        val player = Player(name)
                        player.imagePath = imagePath;
                        val playerDAO = PlayertDAOStubImplementation()


                        playerDAO.addPlayer(player)

                        playerAdapter.addPlayer(player)
                        playerCount -= 1


                    } else {
                        Toast.makeText(context, "Player name  cannot be empty", Toast.LENGTH_SHORT)
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


    fun showMapLegends(): Dialog {
        return this!!.let {
            val builder = AlertDialog.Builder(it)
            var dialogueMapLegendsBinding: MapLegendBinding =
                MapLegendBinding.inflate(it.layoutInflater)
            with(builder) {

                setNeutralButton("CLOSE", DialogInterface.OnClickListener { dialog, id ->

                })

                setView(dialogueMapLegendsBinding.root)
                create()
            }
        }
    }


    override fun onBackPressed() {


        println("the page is ${page}")

        if (page == 1) {
            binding.addButton.visibility = View.VISIBLE
            binding.startButton.visibility = View.VISIBLE
            page = 0;
        } else {
            page = page - 1;
        }


        recyclerView = binding.playersList

        if (recyclerView.parent == null) {
            binding.home.addView(recyclerView)

        }


        val fragmentManager = supportFragmentManager
        val backStackEntryCount = fragmentManager.backStackEntryCount



        if (backStackEntryCount > 0) {
            // Remove the latest fragment from the back stack
            fragmentManager.popBackStack(
                fragmentManager.getBackStackEntryAt(backStackEntryCount - 1).id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        } else {
            super.onBackPressed()
        }
    }


    fun removeBoardFragment() {

        val fragmentManager = supportFragmentManager
        val backStackEntryCount = fragmentManager.backStackEntryCount
        binding.addButton.visibility = View.VISIBLE
        binding.startButton.visibility = View.VISIBLE


        if (backStackEntryCount > 0) {
            // Remove the latest fragment from the back stack
            fragmentManager.popBackStack(
                fragmentManager.getBackStackEntryAt(backStackEntryCount - 1).id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }

    }

    fun updatePlayerList(playerList: List<Player>) {
        playerAdapter.playerList = playerList as ArrayList<Player>
        val playerDAO = PlayertDAOStubImplementation()

        playerAdapter.notifyDataSetChanged()
    }

    fun setPlayerCount() {
        playerCount = 5
    }

    fun setWinner(player: Player) {
        val fragment = leaderboard_fragment.newInstance("param1", "param2")
        fragment.addWinner(player, applicationContext)
    }








    fun startMusic(){
        mediaPlayer.start()
    }

    fun startMusic1(){
        pauseMusic()
        mediaPlayer = MediaPlayer.create(this, R.raw.pokemon)
        mediaPlayer.start()
    }


    fun startMusic2(){
        pauseMusic()
        mediaPlayer = MediaPlayer.create(this, R.raw.space)
        mediaPlayer.start()
    }

    fun pauseMusic(){
        mediaPlayer.pause()
    }





    fun showMusicSettings(): Dialog {
        return this!!.let {
            val builder = AlertDialog.Builder(it)
            var dialogueMusicSettingsBinding: MusicBinding =
                MusicBinding.inflate(it.layoutInflater)
            with(builder) {



                val radioGroup =  dialogueMusicSettingsBinding.radioGroup

                radioGroup.setOnCheckedChangeListener{ group, checkedId ->

                    if(musicOn){
                        when (checkedId) {
                            R.id.radio_button1 -> startMusic1()
                            R.id.radio_button2  -> startMusic2()
                        }

                    }
                }


                dialogueMusicSettingsBinding.switch1.isChecked = musicOn
                dialogueMusicSettingsBinding.switch1.setOnClickListener{
                    musicOn = if(musicOn){
                        pauseMusic()
                        false
                    }else{
                        startMusic()
                        true
                    }


                }

                val volumeSeekBar = dialogueMusicSettingsBinding.volume
                volumeSeekBar.max = 100
                volumeSeekBar.progress = 50
                val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
                val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

                volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                        // Set the media volume based on the SeekBar progress
                        val volume = (maxVolume * (progress / 100f)).toInt()
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0)
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {
                        // Do nothing
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        // Do nothing
                    }
                })





                setNeutralButton("CLOSE", DialogInterface.OnClickListener { dialog, id ->

                })

                setView(dialogueMusicSettingsBinding.root)
                create()
            }
        }
    }




}
