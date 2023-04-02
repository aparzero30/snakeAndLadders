package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding.PlayerUserBinding
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model.Player
import java.io.File

class PlayerAdapter(private val context: Context,
                     var playerList:ArrayList<Player>):
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {



    fun addPlayer(player: Player){
        playerList.add(0, player)
        notifyItemInserted(0)
    }

    fun resetPlayers(){
        playerList.clear();
        notifyDataSetChanged()
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.ViewHolder {
        val playerUserBinding =PlayerUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(playerUserBinding)
    }

    override fun onBindViewHolder(holder: PlayerAdapter.ViewHolder, position: Int) {
        holder.bindItems(playerList[position])
    }

    override fun getItemCount(): Int = playerList.size
    fun updatePlayerList(newPlayerList: ArrayList<Player>) {
        playerList = newPlayerList
        notifyDataSetChanged()
    }



    inner class ViewHolder(private val playerUserBinding: PlayerUserBinding):
        RecyclerView.ViewHolder(playerUserBinding.root){

        fun bindItems(player: Player){

            playerUserBinding.playerName.text = player.username

            if(player.position==-1){
                playerUserBinding.playerPosition.text = ""
            }


            if(player.position!=-1){
                var pos = player.position + 1
                playerUserBinding.playerPosition.text = pos.toString()
            }




            val imagePath = player.imagePath
            println("heres the path  ${imagePath}" )
            val file = File(imagePath)
            if (file.exists()) {
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                playerUserBinding.playerImage.setImageBitmap(bitmap)
            } else {
                Log.e(TAG, "File not found: $imagePath")
            }

        }
    }
}