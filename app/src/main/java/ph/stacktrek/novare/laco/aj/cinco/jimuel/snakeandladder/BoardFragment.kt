package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.FragmentBoardBinding

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

        binding = FragmentBoardBinding.inflate(inflater, container, false)
        val boardView = binding.boardView
        createBoard(boardView)

        var position = 95

        binding.myButton.setOnClickListener {
            // Code to be executed when the button is clicked

            println("current position : ${position}")

            updateTile(position, boardView, requireContext())
            position = position+1;
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


    private fun updateTile(position: Int, boardView: LinearLayout, context: Context) {
        val boardSize = 10
        val row = boardSize - 1 - (position / boardSize)
        val col = if (row % 2 == 0) boardSize - 1 - (position % boardSize) else position % boardSize
        val rowView = boardView.getChildAt(row) as LinearLayout
        val cellView = rowView.getChildAt(col)
        val tileLayout = cellView.findViewById<ConstraintLayout>(R.id.tile1)

        if (row % 2 == 0 && col % 2 == 0 || row % 2 != 0 && col % 2 != 0) {
            tileLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        } else {
            tileLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        }
    }






    private fun createBoard(boardView: LinearLayout) {
        val boardSize = 10
        val color1 = ContextCompat.getColor(requireContext(), R.color.add_color)
        val color2 = ContextCompat.getColor(requireContext(), R.color.start_color)

        for (i in 0 until boardSize) {
            val rowView = LinearLayout(context)
            rowView.orientation = LinearLayout.HORIZONTAL

            for (j in 0 until boardSize) {
                val cellView = LayoutInflater.from(context).inflate(
                    R.layout.tile, rowView, false
                )

                // Set background color based on row and column
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    cellView.setBackgroundColor(color1)
                } else {
                    cellView.setBackgroundColor(color2)
                }

                rowView.addView(cellView)
            }

            boardView.addView(rowView)
        }
    }


}
