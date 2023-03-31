package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDateTime

open class Player(var username: String?) : Parcelable {
    lateinit var userID: String
        private set
    var imagePath:String = ""
    var position: Int = -1;
    var lastPosition: Int = 0;
    var place: Int = 0;

    constructor(parcel: Parcel) : this(parcel.readString()) {
        imagePath = parcel.readString().toString()
        position = parcel.readInt()
        place = parcel.readInt()
        lastPosition = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(imagePath)
        parcel.writeInt(position)
        parcel.writeInt(place)
        parcel.writeInt(lastPosition)
    }

    override fun describeContents(): Int {
        return 0
    }


    @SuppressLint("ParcelCreator")
    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}





class Winner(username: String) : Player(username){
    lateinit var lastPlayed: LocalDateTime
        private set
}