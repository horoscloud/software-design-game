package at.compus02.swd.ss2022.game.TileFactory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tile {

    private Texture texture;
    private Sprite sprite;

    public Sprite gras(){
        texture = new Texture("tile_gras.png");
        sprite = new Sprite(this.texture);
        return sprite;
    }
    public Sprite gravel(){
        texture = new Texture("tile_gravel.png");
        sprite = new Sprite(this.texture);
        return sprite;
    }

    public Sprite wall(){
        texture = new Texture("tile_wall.png");
        sprite = new Sprite(this.texture);
        return sprite;
    }
    public Sprite water(){
        texture = new Texture("tile_water.png");
        sprite = new Sprite(this.texture);
        return sprite;
    }
}
