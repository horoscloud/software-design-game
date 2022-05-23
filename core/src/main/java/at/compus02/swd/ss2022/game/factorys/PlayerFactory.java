package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerFactory implements GameObject{

    Player player;
    Sprite sprite;
    GameInput playerInput;

    public PlayerFactory() {
        player = new Player();
        sprite = player.create();
        playerInput = new GameInput();
    }

    @Override
    public void act(float playerSpeed) {
        playerInput.input(sprite, playerSpeed);
    }

    @Override
    public void setPosition(float x, float y) {sprite.setPosition(x,y);}

    @Override
    public void setRotation(float deg) {sprite.rotate(deg);}

    @Override
    public void draw(SpriteBatch batch) {sprite.draw(batch);}
}
