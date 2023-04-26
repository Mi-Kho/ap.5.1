public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position other) {
        int xDiff = this.x - other.x;
        int yDiff = this.y - other.y;
        return Math.hypot(xDiff, yDiff);
    }
}
