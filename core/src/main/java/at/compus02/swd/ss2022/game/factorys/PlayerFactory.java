package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.objects.gameobjects.Player;

public class PlayerFactory{

    Player player;

    public PlayerFactory() {
        player = new Player();
    }

    public Player create(){
        return player;
    }

}
