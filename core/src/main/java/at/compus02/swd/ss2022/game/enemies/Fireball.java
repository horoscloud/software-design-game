package at.compus02.swd.ss2022.game.enemies;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fireball implements GameObject {

    private Texture texture;
    private Sprite sprite;

  private int direction;

    public Fireball() {
        texture = new Texture("enemy/fireball.png");
        sprite = new Sprite(this.texture);
        sprite.setSize(32,32);
        sprite.setCenter(16,48);
        direction = -1;

        sprite.setPosition(10,-100);
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

        delta = (delta % 1200);



        if(direction == -1){
            setPosition(600 - delta, getY());

            if(delta > 1195 && direction == -1){
                direction = 1;
            }
        }else if(direction == 1){
            setPosition(delta - 600, getY());

            if(delta > 1195 && direction == 1){
                direction = -1;
            }
        }
    }

    @Override
    public void act(float delta, float x, float y) {

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
