import processing.core.PApplet;

public class FourBalls extends PApplet {
    public static void main(String[] args) {
        PApplet.main("FourBalls", args);
    }

    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;
    private static final int DIAMETER = 20;
    private int x1 = 0;
    private int x2 = 0;
    private int x3 = 0;
    private int x4 = 0;

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        background(255);
    }

    @Override
    public void draw() {
        drawCircle1();
        drawCircle2();
        drawCircle3();
        drawCircle4();
    }

    private void drawCircle1() {
        ellipse(x1, (float) HEIGHT / 5, DIAMETER, DIAMETER);
        x1 += 1;
    }

    private void drawCircle2() {
        ellipse(x2, (float) (2 * HEIGHT) / 5, DIAMETER, DIAMETER);
        x2 += 2;
    }

    private void drawCircle3() {
        ellipse(x3, (float) (3 * HEIGHT) / 5, DIAMETER, DIAMETER);
        x3 += 3;
    }

    private void drawCircle4() {
        ellipse(x4, (float) (4 * HEIGHT) / 5, DIAMETER, DIAMETER);
        x4 += 4;
    }
}
