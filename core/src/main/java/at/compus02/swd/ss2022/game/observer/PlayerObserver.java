package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.interfaces.GameObserver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerObserver implements GameObserver {

    private float rotX = 0;
    private float rotY = 0;

    public PlayerObserver() {}

    public void outputPosition(float x,float y){
        System.out.println(x);
        System.out.println(y);
    }


    public void outputRotation(float x, float y){
       if(x < rotX){
           System.out.println("PLayer is facing LEFT");
           rotX = x;
       }
       if(x > rotX){
            System.out.println("PLayer is facing RIGHT");
            rotX = x;
       }
        if(y < rotY){
            System.out.println("PLayer is facing DOWN");
            rotY = y;
        }
        if(y > rotY){
            System.out.println("PLayer is facing UP");
            rotY = y;
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
