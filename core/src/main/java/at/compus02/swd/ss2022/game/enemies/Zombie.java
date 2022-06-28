package at.compus02.swd.ss2022.game.enemies;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.repositories.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Zombie implements GameObject {

    private Texture texture;
    private Sprite sprite;


    Vector2 zPos;
    Vector2 pPos;
    Vector2 direction;


    public Zombie() {
        texture = AssetRepository.getInstance().loadAsset("zombie");
        sprite = new Sprite(this.texture);
        sprite.setSize(20,32);
        sprite.setCenter(16,48);
        sprite.setPosition(100, 100);

        direction = new Vector2();

        zPos = new Vector2();
        pPos = new Vector2();

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
    public void act(float delta, float x, float y) {

        pPos.x = x;
        pPos.y = y;

        zPos.x = getX();
        zPos.y = getY();

        direction = pPos.sub(zPos).nor();

        sprite.translateX(direction.x * delta * 50);
        sprite.translateY(direction.y * delta * 50);
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
