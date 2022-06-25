package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements GameObject {

    private Texture texture;
    private Sprite sprite;

    public Enemy(String enemyName) {
        switch (enemyName){
            case "zombie":
                texture = new Texture("enemy/zombie.png");
                sprite = new Sprite(this.texture);
                sprite.setSize(32,32);
                break;
            case "fireball":
                texture = new Texture("enemy/fireball.png");
                sprite = new Sprite(this.texture);
                sprite.setSize(32,32);
                break;
        }
    }

    public float getX(){return sprite.getX();}
    public float getY(){return sprite.getY();}


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
