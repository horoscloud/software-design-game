package at.compus02.swd.ss2022.game.world.oldworldgeneration;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.utils.Array;

public class World {

    private Array<GameObject> worldObjects = new Array<>();

    private WorldGround ground;
    private WorldTerrain terrain;

    public World() {
        this.worldObjects = new Array<>();
        ground = new WorldGround();
        terrain = new WorldTerrain();

    }

    public void create() {

        ground.create();
        terrain.create();

        worldObjects.addAll(ground.getWorldObjects());
        worldObjects.addAll(terrain.getTerrainObjects());
    }

    public Array<GameObject> getWorldObjects() {
        return worldObjects;
    }
}
