package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

import android.content.ContentValues
import android.content.Context

interface PlayerDAO {

    fun addPlayer(player: Player)
    fun getPlayers(): ArrayList<Player>
    fun deletePlayer(product: Player)

}

class PlayertDAOStubImplementation: PlayerDAO{
    private var playerList: ArrayList<Player> = ArrayList()

    // TODO("Not yet implemented")
    override fun addPlayer(player: Player) {
        playerList.add(player)
    }

    override fun getPlayers(): ArrayList<Player>  = playerList

    fun resetPlayers(players:ArrayList<Player>) {
        playerList = players
    }


    override fun deletePlayer(product: Player) {

    }

}

//class PlayerDAOSQLLiteImplementation(var context: Context): PlayerDAO{
//    override fun addProduct(product: Product) {
//        val databaseHandler = DatabaseHandler(context)
//        val db = databaseHandler.writableDatabase
//
//        val contentValues = ContentValues()
//        contentValues.put(DatabaseHandler.TABLE_PRODUCT_NAME, product.name)
//
//        var status = db.insert(DatabaseHandler.TABLE_PRODUCT,
//            null,
//            contentValues)
//        db.close()
//    }
//
//}

