package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.interfaces.Observer;

public class RotationObserver implements Observer {
    private float rotX = 0;
    private float rotY = 0;

    @Override
    public void output(float x, float y) {
            if(x < rotX){
                System.out.println("PLayer is facing LEFT");
                rotX = x;
            }
            if(x > rotX){
                System.out.println("PLayer is facing RIGHT");
                rotX = x;
            }
            if(y < rotY){
                System.out.println("PLayer is facing DOWN");
                rotY = y;
            }
            if(y > rotY){
                System.out.println("PLayer is facing UP");
                rotY = y;

        }
    }
}
