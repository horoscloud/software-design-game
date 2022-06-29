package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.objects.gameobjects.Tile;

public class TileFactory {

   Tile tile;

    public TileFactory() {

    }

    public Tile create(String tileName){
        switch (tileName){
            case "gras": return tile = new Tile("gras");
            case "gravel": return tile = new Tile("gravel");
            case "wall": return tile = new Tile("wall");
            case "water": return tile = new Tile("water");
            case "bush": return tile = new Tile("bush");
            case "sign": return tile = new Tile("sign");
            case "log": return tile = new Tile("log");
            case "stone": return tile = new Tile("stone");
        }
        return null;
    }

    public Tile createWithID(int id){
        switch (id){
            case 1: return tile = new Tile("gras");
            case 2: return tile = new Tile("gravel");
            case 3: return tile = new Tile("wall");
            case 4: return tile = new Tile("water");
            case 5: return tile = new Tile("bush");
            case 6: return tile = new Tile("sign");
            case 7: return tile = new Tile("log");
            case 8: return tile = new Tile("stone");
        }
        return null;
    }

}
