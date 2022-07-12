package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.objects.hud.PixelHeart;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class HeartFactory {

    private ArrayList<PixelHeart> health;


    private int healthCount = 3;
    private int healthOffset = 0;

    public HeartFactory() {
        health = new ArrayList<>();
    }

    public void create(Viewport viewport){

        for (int i = 0; i <= healthCount; i++) {
            health.add(new PixelHeart());
        }

        for (PixelHeart ph :health) {
            ph.setPosition(ph.getX() - healthOffset, ph.getY());
            healthOffset+=40;
        }

        healthOffset = 0;
    }

    public ArrayList<PixelHeart> getHealth() {
        return health;
    }

    public void setHealth() {
        for (int i = 0; i <= healthCount; i++) {
            health.add(new PixelHeart());
        }

    }

    public void setHealthOffset(int healthOffset) {
        this.healthOffset = healthOffset;
    }

    public int getHealthOffset() {
        return healthOffset;
    }

    public int getHealthCount() {
        return healthCount;
    }

    public void setHealthCount(int healthCount) {
        this.healthCount = healthCount;
    }
}
