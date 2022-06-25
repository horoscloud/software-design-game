package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject{

    private Texture texture;
    private Sprite sprite;

    public Player() {
        texture = new Texture("sp1/player_idle.png");
        sprite = new Sprite(this.texture);

    }

    public float getX(){return sprite.getX();}
    public float getY(){return sprite.getY();}

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    public Sprite getSprite(){return sprite;}

    @Override
    public void act(float temp) {}

    @Override
    public GameObject setPosition(float x, float y) {sprite.setPosition(x,y);
        return this;
    }

    @Override
    public GameObject setRotation(float deg) {
        sprite.rotate(deg);
        return this;
    }

    @Override
    public void draw(SpriteBatch batch) {sprite.draw(batch);}
}
