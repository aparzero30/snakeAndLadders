package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

import java.time.LocalDateTime

open class Player(var username:String) {
    lateinit var userID: String
            private set
    var imagePath:String = ""
    var position: Int = 0;
    var place: Int = 0;
}





class Winner(username: String) : Player(username){
    lateinit var lastPlayed: LocalDateTime
        private set
}


