package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHandler(context: Context):
    SQLiteOpenHelper(context, DATABASENAME,null, DATABASEVERSION) {

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "PlayersDatabase"

        const val TABLE_PLAYER= "player_table"
        const val TABLE_PLAYER_USERID = "user_id"
        const val TABLE_PLAYER_USER_NAME = "username"
        const val TABLE_PLAYER_POSITION = "position"
        const val TABLE_PLAYER_LAST_POSITION = "last_position"
        const val TABLE_PLAYER_IMAGE_PATH = "image_path"


    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE =
            "CREATE TABLE $TABLE_PLAYER " +
                    "($TABLE_PLAYER_USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$TABLE_PLAYER_USER_NAME TEXT, " +
                    "$TABLE_PLAYER_POSITION REAL, " +
                    "$TABLE_PLAYER_LAST_POSITION REAL, " +
                    "$TABLE_PLAYER_IMAGE_PATH TEXT)"

        db?.execSQL(CREATE_PRODUCTS_TABLE)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_PLAYER")
        onCreate(db)
    }


}