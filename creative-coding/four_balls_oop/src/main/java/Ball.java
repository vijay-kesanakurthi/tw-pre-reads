import processing.core.PApplet;

class Ball  {
    private final PApplet p;
    private int x;
    private final int y;
    private final int speed;

    private static final int diameter=20;

    public Ball(PApplet p, int y, int speed) {
        this.p = p;
        this.y = y;
        this.speed = speed;
        this.x = 0;
    }
    public void draw() {
        p.ellipse(x, y, Ball.diameter, Ball.diameter);
        x += speed;
    }
}
