package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.model

interface PlayerDAO {

    fun addPlayer(player: Player)
    fun getPlayers(): ArrayList<Player>
    fun deleteProduct(product: Player)

}

class PlayertDAOStubImplementation: PlayerDAO{
    private var playerList: ArrayList<Player> = ArrayList()

    // TODO("Not yet implemented")
    override fun addPlayer(player: Player) {
        playerList.add(player)
    }

    override fun getPlayers(): ArrayList<Player>  = playerList

// TODO("Not yet implemented")
    override fun deleteProduct(product: Player) {

    }

}

