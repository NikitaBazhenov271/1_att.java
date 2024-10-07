import java.awt.*;

public class Cloud implements Drawable {
    private final int[] cloudX;
    private final int cloudY;
    private final int speed;

    public Cloud(int[] initialPositions, int y, int speed) {
        this.cloudX = initialPositions;
        this.cloudY = y;
        this.speed = speed;
    }

    public void move() {
        for (int i = 0; i < cloudX.length; i++) {
            cloudX[i] += speed;
            if (cloudX[i] > 1920) {
                cloudX[i] = -100;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        DrawingPrimitives.drawClouds(g, cloudX, cloudY);
    }
}
