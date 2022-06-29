package at.compus02.swd.ss2022.game.repositories;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

import java.util.*;

public class AssetRepository {


    private static AssetRepository instance;
    private AssetRepository(){}

    public static AssetRepository getInstance(){
        if(instance == null){
            instance = new AssetRepository();
        }
        return instance;
    }
    private static final Texture bush = new Texture("bush.png");
    private static final Texture log = new Texture("log.png");
    private static final Texture stone = new Texture("stone.png");
    private static final Texture tile_gras = new Texture("tile_gras.png");
    private static final Texture tile_gravel = new Texture("tile_gravel.png");
    private static final Texture tile_wall = new Texture("tile_wall.png");
    private static final Texture tile_water = new Texture("tile_water.png");

    private static final Texture player = new Texture("animation/player/player_idle.png");
    private static final Texture zombie = new Texture("enemy/zombie.png");
    private static final Texture fireball = new Texture("enemy/fireball.png");

    private static final Texture pixel_heart = new Texture("hud/pixel_heart.png");

    private HashMap<String, Texture> textureHashMap = new HashMap<String, Texture>(){{

        put("bush", bush);
        put("log", log);
        put("stone", stone);
        put("gras", tile_gras);
        put("gravel", tile_gravel);
        put("water", tile_water);
        put("wall", tile_wall);

        put("player", player);
        put("fireball", fireball);
        put("zombie", zombie);

        put("pixel_heart", pixel_heart);

    }};

    public Texture loadAsset(String key) {
        return textureHashMap.get(key);
    }
}
