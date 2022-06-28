package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.interfaces.PositionObserver;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    private List<PositionObserver> observers = new ArrayList<>();

    public void addObserver(PositionObserver obs) {
        this.observers.add(obs);
    }
    public void removeObserver(PositionObserver obs) {
        this.observers.remove(obs);
    }
    public void setPosition(int x, int y) {
        for (PositionObserver obs : this.observers) {
            obs.update(x, y);
        }
    }
}
