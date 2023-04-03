package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.adapters.PlayerAdapter
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.ActivityMainBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.FragmentBoardBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.Player
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BoardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentBoardBinding
    private lateinit var mainBinding: ActivityMainBinding;
    private var currentPlayer = 0;
    private lateinit var player:Player;
    private var players1 = ArrayList<Player>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val players = arguments?.getParcelableArrayList<Player>("key");
        if(players!=null){
            players1 = players
        }


        var playerCount = players?.size?.minus(1)

        binding = FragmentBoardBinding.inflate(inflater, container, false)
        val boardView = binding.boardView
        createBoard(boardView)
        updatePlayerTiles(boardView)



        if (players != null) {
            if(players.isNotEmpty()){
                setUPCurrentPlayer(players?.get(0) ?: player)
            }
        }




        binding.rollButton.setOnClickListener {





            val initPos = players1.get(currentPlayer).position;


            if(initPos!=-1){

                updateTile(players1.get(currentPlayer), boardView, requireContext())
            }

            players1.get(currentPlayer).lastPosition =  players1.get(currentPlayer).position

            if(initPos!=-1){

                removeLastPosition( players1.get(currentPlayer).lastPosition , boardView, requireContext())
            }

            var rollPosition  = rollDice(players1.get(currentPlayer).position)




            if(rollPosition >99){
                var excess  = rollPosition  - 99;
                rollPosition = 99 - excess;

            }


            if(rollPosition == 0){
                rollPosition = 37;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 3){
                rollPosition = 13;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 7){
                rollPosition = 29;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 20){
                rollPosition = 41;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 27){
                rollPosition = 75;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 49){
                rollPosition = 66;
                portalMessageLadder(rollPosition+1)
            }

            if(rollPosition == 79){
                rollPosition = 98;
                portalMessageLadder(rollPosition+1)
            }

            // snake

            if(rollPosition == 96){
                rollPosition = 77;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 94){
                rollPosition = 55;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 87){
                rollPosition = 23;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 61){
                rollPosition = 17;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 47){
                rollPosition = 25;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 35){
                rollPosition = 5;
                portalMessageSnake(rollPosition+1)
            }

            if(rollPosition == 31){
                rollPosition = 9;
                portalMessageSnake(rollPosition+1)
            }


            val mainActivity = activity as MainActivity





//            rollPosition = 99


            players1.get(currentPlayer).position = rollPosition
            updatePlayerTiles(boardView)

            if(rollPosition==99){

                players1.get(currentPlayer).position =  -1
                mainActivity.updatePlayerList(players1)
                players1.clear()
                mainActivity.updatePlayerList(players1)
                mainActivity.removeBoardFragment()
                mainActivity.setPlayerCount()
                binding.rollButton.isEnabled = false

            }


                mainActivity.updatePlayerList(players1)



            if(playerCount == currentPlayer){
                currentPlayer = 0;
            }
            else{
                currentPlayer+=1;
            }

            if (players != null) {
                if (!players.isEmpty()) {
                    setUPCurrentPlayer(players?.get( currentPlayer) ?: player)
                }
            }


        }


        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




    private fun removeLastPosition(position: Int, boardView: LinearLayout, context: Context) {
        val boardSize = 10
        val row = boardSize - 1 - (position / boardSize)
        val col = if (row % 2 == 0) boardSize - 1 - (position % boardSize) else position % boardSize
        val rowView = boardView.getChildAt(row) as LinearLayout
        val cellView = rowView.getChildAt(col)
        val tileLayout = cellView.findViewById<ConstraintLayout>(R.id.tile1)

        tileLayout.setBackgroundResource(0)

        if (row % 2 == 0 && col % 2 == 0 || row % 2 != 0 && col % 2 != 0) {
            tileLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.tile2))
        } else {
            tileLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.tile1))
        }

        if(position==0 || position==3 || position==7 || position==13 || position==20 || position==27 || position==29 || position==41 || position==49
            || position==66 || position==70 || position==75 || position== 79 || position== 91 || position==98 || position==37

        ){
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.board_ladder)
            cellView.background = drawable
        }

        if(position==96 || position==77 || position==94 || position==55 || position==87 || position==23 || position==61 || position==17 || position==47
            || position==25 || position==35 || position==5 || position== 31 || position== 9

        ){
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.board_snake)
            cellView.background = drawable
        }

        val textView = cellView.findViewById<TextView>(R.id.tile_text)
        val positionReal = position +1
        textView.text = positionReal.toString()
    }



    fun setUPCurrentPlayer(player:Player){


        val bitmap = BitmapFactory.decodeFile(player.imagePath)
        binding.playerturn.setImageBitmap(bitmap)
        binding.playername.text = player.username

    }


    private fun rollDice(position:Int):Int{


        var rollNum = (1..6).random()
        Toast.makeText(requireContext(), "You rolled $rollNum", Toast.LENGTH_SHORT).show()

        return  position +  rollNum

    }

    private fun updatePlayerTiles(boardView: LinearLayout){
        for (currentPlayer in players1) {
            if(currentPlayer.position!=-1){
                updateTile(currentPlayer, boardView, requireContext())
            }
        }
    }







    private fun updateTile(player:Player, boardView: LinearLayout, context: Context) {
        val boardSize = 10
        val row = boardSize - 1 - (player.position / boardSize)
        val col = if (row % 2 == 0) boardSize - 1 - (player.position % boardSize) else player.position % boardSize
        val rowView = boardView.getChildAt(row) as LinearLayout
        val cellView = rowView.getChildAt(col)
        val tileLayout = cellView.findViewById<ConstraintLayout>(R.id.tile1)

        val textView = cellView.findViewById<TextView>(R.id.tile_text)
        textView.text = ""


        val bitmap = BitmapFactory.decodeFile(player.imagePath)

        // Create a BitmapDrawable from the bitmap
        val bitmapDrawable = BitmapDrawable(context.resources, bitmap)

        // Set the bitmap drawable as the background of the tileLayout
        tileLayout.background = bitmapDrawable


        tileLayout.background = bitmapDrawable

    }



    private fun createBoard(boardView: LinearLayout) {
        val boardSize = 10
        val color1 = ContextCompat.getColor(requireContext(), R.color.tile2)
        val color2 = ContextCompat.getColor(requireContext(), R.color.tile1)



        var count = 100
        var leftToRight = true;



        for (i in 0 until boardSize) {
            val rowView = LinearLayout(context)
            rowView.orientation = LinearLayout.HORIZONTAL


            if(i%2==1){

                if(count == 90 && i == 1){
                    count = 81;
                }
                if(count ==70 && i == 3){
                    count = 61;
                }
                if(count ==50 && i == 5){
                    count = 41;
                }
                if(count ==30 && i == 7){
                    count = 21;
                }
                if(count ==10 && i == 9){
                    count = 1;
                }

                leftToRight  = false;
            }
            else{
                leftToRight  = true;

                if(count == 91 && i == 2){
                    count = 80;
                }
                if(count ==71 && i == 4){
                    count = 60;
                }
                if(count ==51 && i == 6){
                    count = 40;
                }
                if(count ==31 && i == 8){
                    count = 20;
                }


            }




            for (j in 0 until boardSize) {
                val cellView = LayoutInflater.from(context).inflate(
                    R.layout.tile, rowView, false
                )

                val textView = cellView.findViewById<TextView>(R.id.tile_text)
                textView.text = count.toString()


                // Set background color based on row and column
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    cellView.setBackgroundColor(color1)
                } else {
                    cellView.setBackgroundColor(color2)
                }

                // Set image for specific tiles ladder
                if (i == 0 && j == 1 || i == 0 && j == 8 || i == 2 && j == 0 || i == 2 && j == 9 ||
                    i == 2 && j == 4 || i == 3 && j == 6 || i == 5 && j == 1 ||
                    i == 5 && j == 9 || i == 7 && j == 0 || i == 7 && j == 7 || i == 6 && j == 2 ||
                    i == 7 && j == 9 || i == 8 && j == 6 || i == 9 && j == 0 || i == 9 && j == 3 || i == 9 && j == 7
                ) {

                    val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.board_ladder)
                    cellView.background = drawable
                }



                // Set image for specific tiles snake
                if (i == 0 && j == 3 || i == 2 && j == 2 || i == 0 && j == 5 || i == 4 && j == 4
                    || i == 1 && j == 7 || i == 7 && j == 3 || i == 3 && j == 1 || i == 8 && j == 2
                    || i == 5 && j == 7 || i == 7 && j == 5 || i == 6 && j == 4 || i == 9 && j == 5
                    || i == 6 && j == 8 || i == 9 && j == 9
                ) {
                    val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.board_snake)
                    cellView.background = drawable
                }

                if(leftToRight){
                    count = count - 1;
                }
                else{
                    count = count +1;
                }

                rowView.addView(cellView)
            }

            boardView.addView(rowView)
        }
    }

    fun portalMessageLadder(position: Int) {
        Toast.makeText(requireContext(), "You've entered a warp portal! You are transported in ${position}", Toast.LENGTH_SHORT).show()
    }

    fun portalMessageSnake(position: Int) {
        Toast.makeText(requireContext(), "You've entered a warp portal! You are sent back in ${position}", Toast.LENGTH_SHORT).show()
    }



}
