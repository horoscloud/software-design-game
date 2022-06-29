package at.compus02.swd.ss2022.game.factorys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AnimationFactory {


    com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> textureRegionAnimation;
    Texture sheet;


    public com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> create(String name){
        switch (name){
            case "idle": return createAnimation("animation/player/player_idle.png", 6,1,0.1f);
            case "wake": return createAnimation("animation/player/player_run.png", 6,1,0.08f);
            case "run": return createAnimation("animation/player/player_slash.png", 4,1,0.05f);
            case "shoot": return createAnimation("animation/player/player_shoot.png", 4,1,0.08f);


            default: return null;
        }
    }

    public com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> createAnimation(String filepath, int frame_rows, int frame_cols, float frameDuration){

        try {
            sheet = new Texture(Gdx.files.internal(filepath));
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


        TextureRegion[][] tmp = TextureRegion.split(sheet,
                sheet.getWidth() / frame_cols,
                sheet.getHeight() / frame_rows);

        TextureRegion[] walkFrames = new TextureRegion[frame_cols * frame_rows];

        int index = 0;

        for (int i = 0; i < frame_rows; i++) {
            for (int j = 0; j < frame_cols; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        return textureRegionAnimation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(frameDuration, walkFrames);
    }
}
