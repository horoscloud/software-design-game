package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.repositories.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile implements GameObject {

    private Texture texture;
    private Sprite sprite;

    public Tile(String tileName) {
        switch (tileName){
            case "gras":
                texture = AssetRepository.getInstance().loadAsset("gras");
                sprite = new Sprite(this.texture);
                break;
            case "gravel":
                texture = AssetRepository.getInstance().loadAsset("gravel");
                sprite = new Sprite(this.texture);
                break;
            case "wall":
                texture = AssetRepository.getInstance().loadAsset("wall");
                sprite = new Sprite(this.texture);
                break;
            case "water":
                texture = AssetRepository.getInstance().loadAsset("water");
                sprite = new Sprite(this.texture);
                break;
            case "bush":
                texture = AssetRepository.getInstance().loadAsset("bush");
                sprite = new Sprite(this.texture);
                break;
            case "sign":
                texture = AssetRepository.getInstance().loadAsset("sign");
                sprite = new Sprite(this.texture);
                break;
            case "log":
                texture = AssetRepository.getInstance().loadAsset("log");
                sprite = new Sprite(this.texture);
                break;
            case "stone":
                texture = AssetRepository.getInstance().loadAsset("stone");
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
