package at.compus02.swd.ss2022.game.interfaces;

public interface Collision<T> {
    boolean getCollisionDetection(T obj1, T obj2);
    boolean getHitCollisionDetection(T obj1, T obj2);
}
