package at.compus02.swd.ss2022.game.objects.hud;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.repositories.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PixelHeart implements GameObject {


    private Sprite sprite;
    private Texture texture;

    public PixelHeart() {
        texture = AssetRepository.getInstance().loadAsset("pixel_heart");
        sprite = new Sprite(this.texture);
        sprite.setSize(32,32);
        sprite.setPosition(-450, +350);
    }


    @Override
    public GameObject setPosition(float x, float y) {
        sprite.setPosition(x,y);
        return this;
    }

    @Override
    public GameObject setRotation(float deg) {
        return null;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

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
       return sprite;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void act(float delta, float x, float y) {

    }
}
