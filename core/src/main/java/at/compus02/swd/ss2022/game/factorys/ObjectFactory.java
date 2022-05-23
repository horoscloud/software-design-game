package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.gameobjects.Object;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ObjectFactory implements GameObject {
    Sprite sprite;
    Object object;


    public ObjectFactory() {
        object = new Object();
    }

    public void create(String tileName){
        switch (tileName){
            case "bush": sprite = object.create("bush"); break;
            case "sign": sprite = object.create("sign"); break;
            case "log": sprite = object.create("log"); break;
            case "stone": sprite = object.create("stone"); break;
        }
    }


    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x,y);
    }

    @Override
    public void setRotation(float deg){
        sprite.setRotation(deg);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
