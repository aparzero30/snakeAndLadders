package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

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


// TODO("Not yet implemented")
    override fun deletePlayer(product: Player) {

    }

}

