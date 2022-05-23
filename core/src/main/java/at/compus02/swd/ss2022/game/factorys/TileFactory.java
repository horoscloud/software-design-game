package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Tile;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileFactory implements GameObject {

    Sprite sprite;
    Tile tile;

    public TileFactory() {
        tile = new Tile();
    }

    public void create(String tileName){
        switch (tileName){
            case "gras": sprite = tile.create("gras"); break;
            case "gravel": sprite = tile.create("gravel"); break;
            case "wall": sprite = tile.create("wall"); break;
            case "water": sprite = tile.create("water"); break;
            case "bush": sprite = tile.create("bush"); break;
            case "sign": sprite = tile.create("sign"); break;
            case "log": sprite = tile.create("log"); break;
            case "stone": sprite = tile.create("stone"); break;
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
