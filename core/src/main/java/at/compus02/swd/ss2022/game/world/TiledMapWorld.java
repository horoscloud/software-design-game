package at.compus02.swd.ss2022.game.world;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;

public class TiledMapWorld {
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;


    public TiledMapWorld() {


    }

    public void create() {
        TmxMapLoader loader = new TmxMapLoader();
        tiledMap = loader.load("maps/RPGNatureTilemap.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

}
