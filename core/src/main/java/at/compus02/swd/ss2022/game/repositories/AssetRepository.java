package at.compus02.swd.ss2022.game.repositories;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssetRepository {

    private AssetManager assetManager = new AssetManager();

    private final List<String> paths = Arrays.asList(
            "assets/bush.png",
            "assets/log.png",
            "assets/sign.png",
            "assets/stone.png",
            "assets/tile_gras.png",
            "assets/tile_gras.png",
            "assets/tile_gravel.png",
            "assets/tile_wall.png",
            "assets/tile_water.png"
    );

    public AssetRepository() {

    }

    public void preLoadAssets(){
        for (String s :paths) {
            assetManager.load(s, Texture.class);
        }
    }

    public void dispose(){
        assetManager.dispose();
    }
}
