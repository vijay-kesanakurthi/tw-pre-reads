import processing.core.PApplet;

public class TryProcessing extends PApplet {
    public static void main(String[] args) {
        PApplet.main("TryProcessing", args);
    }

    private static  final int WIDTH = 1080;
    private static final int HEIGHT=720;
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
            drawRowOfCircles();
    }

    private void drawCircle(int x ){
        ellipse(x, 50, 50, 50);
        fill(200, 0, 100);
    }

    private void drawRowOfCircles(){
        for (int i = 1; i < 10; i++) {
            drawCircle(50+ i * 100);
        }
    }
}
