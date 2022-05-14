package at.compus02.swd.ss2022.game.TileFactory;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileFactory implements GameObject {

    Sprite sprite;
    Tiles tile;

    public TileFactory(String tileName) {
        tile = new Tiles();

       switch (tileName){
           case "gras": sprite = tile.gras(); break;
           case "gravel": sprite = tile.gravel(); break;
           case "wall": sprite = tile.wall(); break;
           case "water": sprite = tile.water(); break;
       }
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x,y);
    }

    public void setRotation(float deg){
        sprite.setRotation(deg);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
