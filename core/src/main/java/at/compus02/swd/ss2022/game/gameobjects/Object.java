package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Object {

    private Texture texture;
    private Sprite sprite;

    public Object() {
    }

    public Sprite create(String objektName){
        switch (objektName){
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
