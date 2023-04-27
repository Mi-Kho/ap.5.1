import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.EnumMap;

public class Soldier<G extends Gun, B extends Bullet> {
    private Position position;
    private G gun;
    private Stack<B> bullets;
    Map<ShotStatus, Integer> ShotResults;
    Integer counterMiss = 0;
    Integer counterSemi_Hit = 0;
    Integer counterHit = 0;

    public Soldier (Position position, G gun) {
        ShotResults = new EnumMap<>(ShotStatus.class);
        bullets = new Stack<>();
        ShotResults.put(ShotStatus.MISS, 0);
        ShotResults.put(ShotStatus.SEMI_HIT, 0);
        ShotResults.put(ShotStatus.HIT, 0);
        this.position = position;
        this.gun = gun;
    }
    public G giveNewGun (G gun) {
        G temp = this.gun;
        this.gun = gun;
        return temp;
    }
    public void giveBullet(B bullet){
        bullets.push(bullet);
    }
    public B shoot(Target target){
        if (bullets.isEmpty()) {
            return null;
        }
        if (this.position.distanceTo(target.getPosition()) > this.gun.getRange()){
            ShotResults.replace(ShotStatus.MISS, ++counterMiss);
        }else if (this.bullets.peek().getDamage() < target.getHealth()) {
            ShotResults.replace(ShotStatus.SEMI_HIT, ++counterSemi_Hit);
        }else {
            ShotResults.replace(ShotStatus.HIT, ++counterHit);
        }
        B temp = bullets.peek();
        bullets.pop();
        return temp;
    }
    Map<ShotStatus, Integer> getShotStatusCounts(){
        return ShotResults;
    }
}
