import processing.core.PApplet;

public class Four_Balls extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Four_Balls", args);
    }

    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;

    private final Ball[] fourBalls = new Ball[4];

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        super.setup();
        background(255);
        int oneFifth = HEIGHT / 5;
        for (int i = 1; i <= 4; i++) {
            fourBalls[i-1] = new Ball(this, i* oneFifth, i );
        }
    }

    @Override
    public void draw() {
        for (Ball ball : fourBalls) {
            ball.draw();
        }
    }
}

