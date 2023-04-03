package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R
import java.io.File
import java.io.FileOutputStream

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

class PlayerDAOSQLLiteImplementation(var context: Context): PlayerDAO {
    override fun addPlayer(player: Player) {
        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.TABLE_PLAYER_USER_NAME, player.username)
        contentValues.put(DatabaseHandler.TABLE_PLAYER_IMAGE_PATH, player.imagePath)
        var status = db.insert(DatabaseHandler.TABLE_PLAYER,
            null,
            contentValues)
        db.close()
    }
    override fun getPlayers(): ArrayList<Player> {

        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var result = ArrayList<Player>()
        var cursor: Cursor? = null



        val columns =  arrayOf(DatabaseHandler.TABLE_PLAYER_USERID,
            DatabaseHandler.TABLE_PLAYER_USER_NAME, DatabaseHandler.TABLE_PLAYER_IMAGE_PATH)

        try {
            cursor = db.query(DatabaseHandler.TABLE_PLAYER,
                columns,
                null,
                null,
                null,
                null,
                null)


        }catch (sqlException: SQLException){
            db.close()
            return result
        }

        var player: Player
        if(cursor.moveToFirst()){
            do{
                player = Player("")
                player.username = cursor.getString(1)
                player.userID = cursor.getInt(0).toString()

//                product.imagePath = cursor.getString(2);

                if (!cursor.isNull(2)) {
                    player.imagePath = cursor.getString(2)
                }
                else{
                    val image = BitmapFactory.decodeResource(context.resources, R.drawable.lobby1)
                    val file = File(context.filesDir, "default.jpg")
                    val fileOutputStream2 = FileOutputStream(file)
                    image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2)
                    fileOutputStream2.flush()
                    fileOutputStream2.close()
                    player.imagePath = file.absolutePath
                }
                result.add(player)
            }while(cursor.moveToNext())

        }
        return result











    }

    override fun deletePlayer(product: Player) {
        TODO("Not yet implemented")
    }

}
