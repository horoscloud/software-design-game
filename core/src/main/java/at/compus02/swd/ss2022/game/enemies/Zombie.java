package at.compus02.swd.ss2022.game.enemies;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.observer.PositionObserver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Zombie implements GameObject {

    private Texture texture;
    private Sprite sprite;


    public Zombie() {
        texture = new Texture("enemy/zombie.png");
        sprite = new Sprite(this.texture);
        sprite.setSize(20,32);
        sprite.setCenter(16,48);
        sprite.setPosition(100, 100);


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

    @Override
    public Sprite getSprite() {
        return this.sprite;
    }


    @Override
    public void act(float delta) {



    }


    @Override
    public GameObject setPosition(float x, float y) {
        sprite.setPosition(x,y);
        return this;
    }

    @Override
    public GameObject setRotation(float deg) {
        sprite.setRotation(deg);
        return this;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
