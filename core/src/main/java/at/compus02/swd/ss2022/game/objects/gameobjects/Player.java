package at.compus02.swd.ss2022.game.objects.gameobjects;

import at.compus02.swd.ss2022.game.factorys.AnimationFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.repositories.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player implements GameObject{

    private Texture texture;
    private Sprite sprite;


    public Player() {
        texture = AssetRepository.getInstance().loadAsset("player");
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
    public void draw(SpriteBatch batch) {
       sprite.draw(batch);
    }

}
