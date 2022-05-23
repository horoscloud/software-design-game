package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.animations.Animation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AnimationFactory {


    Animation animation = new Animation();


    public com.badlogic.gdx.graphics.g2d.Animation create(String name){
        switch (name){
            case "idle": return animation.createAnimation("player/player_idle.png", 8,1,0.08f);
            case "wake": return animation.createAnimation("player/player_wake.png", 5,1,0.15f);
            case "run": return animation.createAnimation("player/player_move.png", 8,1,0.08f);
            case "shoot": return animation.createAnimation("player/player_shoot.png", 4,1,0.08f);

            default: return null;
        }

    }
}
