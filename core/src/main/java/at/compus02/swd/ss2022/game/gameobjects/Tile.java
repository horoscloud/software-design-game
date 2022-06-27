package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile implements GameObject {

    private Texture texture;
    private Sprite sprite;

    public Tile(String tileName) {
        switch (tileName){
            case "gras":
                texture = new Texture("tile_gras.png");
                sprite = new Sprite(this.texture);
                break;
            case "gravel":
                texture = new Texture("tile_gravel.png");
                sprite = new Sprite(this.texture);
                break;
            case "wall":
                texture = new Texture("tile_wall.png");
                sprite = new Sprite(this.texture);
                break;
            case "water":
                texture = new Texture("tile_water.png");
                sprite = new Sprite(this.texture);
                break;
            case "bush":
                texture = new Texture("bush.png");
                sprite = new Sprite(this.texture);
                break;
            case "sign":
                texture = new Texture("sign.png");
                sprite = new Sprite(this.texture);
                break;
            case "log":
                texture = new Texture("log.png");
                sprite = new Sprite(this.texture);
                break;
            case "stone":
                texture = new Texture("stone.png");
                sprite = new Sprite(this.texture);
                break;
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void act(float delta, float x, float y) {

    }


    @Override
    public GameObject setPosition(float x, float y) {
        this.sprite.setPosition(x, y);
        return this;
    }

    @Override
    public GameObject setRotation(float deg) {
        this.setRotation(deg);
        return this;
    }

    @Override
    public void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }

    @Override
    public float getX() {
        return this.sprite.getX();
    }

    @Override
    public float getY() {
        return this.sprite.getY();
    }

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }
}
