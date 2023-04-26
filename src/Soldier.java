import java.util.Stack;
import java.util.EnumMap;

public class Soldier<G extends Gun, B extends Bullet> {
    private Position position;
    private G gun;
    public Soldier (Position position, G gun) {
        this.position = position;
        this.gun = gun;
    }
    public G giveNewGun (G gun) {
        G temp = this.gun;
        this.gun = gun;
        return temp;
    }

}
