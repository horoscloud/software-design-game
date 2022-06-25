package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerFactory{

    Player player;

    public PlayerFactory() {
        player = new Player();
    }

    public GameObject create(){
        return player;
    }

}
