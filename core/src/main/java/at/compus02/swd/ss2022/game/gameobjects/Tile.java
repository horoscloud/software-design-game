package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tile {

    private Texture texture;
    private Sprite sprite;

    public Sprite create(String tileName){
        switch (tileName){
            case "gras":
                texture = new Texture("tile_gras.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "gravel":
                texture = new Texture("tile_gravel.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "wall":
                texture = new Texture("tile_wall.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "water":
                texture = new Texture("tile_water.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "bush":
                texture = new Texture("bush.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "sign":
                texture = new Texture("sign.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "log":
                texture = new Texture("log.png");
                sprite = new Sprite(this.texture);
                return sprite;
            case "stone":
                texture = new Texture("stone.png");
                sprite = new Sprite(this.texture);
                return sprite;
        }
        return null;
    }
}
