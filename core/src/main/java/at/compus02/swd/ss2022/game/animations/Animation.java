package at.compus02.swd.ss2022.game.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
    com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> animation;
    Texture sheet;

    public com.badlogic.gdx.graphics.g2d.Animation createAnimation(String filepath, int frame_rows, int frame_cols, float frameDuration){

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

        return animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(frameDuration, walkFrames);
    }
}
