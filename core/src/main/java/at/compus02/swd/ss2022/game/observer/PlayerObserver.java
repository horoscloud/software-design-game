package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.interfaces.GameObserver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerObserver implements GameObserver<Sprite> {

    private float rotX = 0;
    private float rotY = 0;

    public PlayerObserver() {}

    public void getPosition(Sprite sprite){
        System.out.println(sprite.getX());
        System.out.println(sprite.getY());
    }

    public void getPosition(BitmapFont font, Sprite sprite, SpriteBatch batch, float fontPosX, float fontPosY){
        font.draw(batch, "PlayerPosX: " + sprite.getX(), fontPosX, fontPosY);
        font.draw(batch, "PlayerPosY: " + sprite.getY(), fontPosX, fontPosY-15);
    }

    public void getRotation(Sprite sprite){
       if(sprite.getX() < rotX){
           System.out.println("PLayer is facing LEFT");
           rotX = sprite.getX();
       }
       if(sprite.getX() > rotX){
            System.out.println("PLayer is facing RIGHT");
            rotX = sprite.getX();
       }
        if(sprite.getY() < rotY){
            System.out.println("PLayer is facing DOWN");
            rotY = sprite.getY();
        }
        if(sprite.getY() > rotY){
            System.out.println("PLayer is facing UP");
            rotY = sprite.getY();
        }
    }

    public void getRotation(BitmapFont font, Sprite sprite, SpriteBatch batch, float fontPosX, float fontPosY){
        if(sprite.getX() < rotX){
            font.draw(batch, "Player is Facing: LEFT", fontPosX, fontPosY);
            rotX = sprite.getX();
        }
        if(sprite.getX() > rotX){
            font.draw(batch, "Player is Facing: RIGHT", fontPosX, fontPosY);
            rotX = sprite.getX();
        }
        if(sprite.getY() < rotY){
            font.draw(batch, "Player is Facing: DOWN", fontPosX, fontPosY);
            rotY = sprite.getY();
        }
        if(sprite.getY() > rotY){
            font.draw(batch, "Player is Facing: UP", fontPosX, fontPosY);
            rotY = sprite.getY();
        }
    }


}
