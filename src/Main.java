import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Soldier<AK47, B7_62x33mm> captainMiller = new Soldier<>(new Position(8, -11), new AK47());
        Soldier<AK47, B9x19mm> privateRyan = new Soldier<>(new Position(-4, 3), new AK47());
        Box box = new Box(new Position(0, 0));

        for (int i = 0; i < 4; i++) {
            captainMiller.giveBullet(new B7_62x33mm(i > 1));
        }
        for (int i = 0; i < 4; i++) {
            privateRyan.giveBullet(new B9x19mm());
        }

        Map<ShotStatus, Integer> millerStats = captainMiller.getShotStatusCounts();
        Map<ShotStatus, Integer> ryanStats = privateRyan.getShotStatusCounts();

        captainMiller.shoot(box);
        captainMiller.shoot(box);
        captainMiller.shoot(box);
        privateRyan.shoot(box);
        privateRyan.shoot(box);
        System.out.println(millerStats);
        System.out.println(ryanStats);

        box.setPosition(new Position(22, 0));

        captainMiller.shoot(box);
        captainMiller.shoot(box);
        privateRyan.shoot(box);
        privateRyan.shoot(box);
        System.out.println(millerStats);
        System.out.println(ryanStats);
    }
}

class Box implements Target {
    private Position position;

    Box(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public double getHealth() {
        return 100;
    }
}

class B7_62x33mm extends Bullet {

    private final boolean goodQuality;

    B7_62x33mm(boolean goodQuality) {
        this.goodQuality = goodQuality;
    }

    @Override
    public double getDamage() {
        return goodQuality ? 110 : 50;
    }
}

class B9x19mm extends Bullet {

    @Override
    public double getDamage() {
        return 60;
    }
}

class AK47 extends Gun {

    @Override
    public double getRange() {
        return 15;
    }
}