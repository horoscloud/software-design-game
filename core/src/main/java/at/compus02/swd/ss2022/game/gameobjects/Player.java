package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.factorys.AnimationFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player implements GameObject{

    private Texture texture;
    private Sprite sprite;


    public Player() {
        texture = new Texture("player/player_idle.png");
        sprite = new Sprite(this.texture);
    }

    @Override
    public void act(float temp) {


    }

    @Override
    public void setPosition(float x, float y) {sprite.setPosition(x,y);}

    @Override
    public void setRotation(float deg) {sprite.rotate(deg);}

    @Override
    public void draw(SpriteBatch batch) {sprite.draw(batch);}
}
