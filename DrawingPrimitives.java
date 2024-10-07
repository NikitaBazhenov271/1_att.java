import java.awt.*;

class DrawingPrimitives {

    public static void drawHouseYard(Graphics g, int screenWidth, int screenHeight) {
        //отрисовка неба
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, screenWidth, screenHeight / 2);

        //отрисовка травы
        g.setColor(Color.GREEN);
        g.fillRect(0, screenHeight / 2, screenWidth, screenHeight / 2);

        //отрисовка дома
        int houseWidth = screenWidth / 4;
        int houseHeight = screenHeight / 3;
        int houseX = screenWidth / 4;
        int houseY = screenHeight / 3;

        g.setColor(Color.ORANGE);
        g.fillRect(houseX, houseY, houseWidth, houseHeight);

        //крыша
        g.setColor(Color.RED);
        g.fillPolygon(new int[]{houseX, houseX + houseWidth / 2, houseX + houseWidth}, new int[]{houseY, houseY - houseHeight / 4, houseY}, 3);

        // окно
        g.setColor(Color.BLUE);
        g.fillRect(houseX + houseWidth / 4, houseY + houseHeight / 4, houseWidth / 3, houseHeight / 3);
        g.setColor(Color.BLACK);
        g.drawRect(houseX + houseWidth / 4, houseY + houseHeight / 4, houseWidth / 3, houseHeight / 3);

        // дверь
        g.setColor(Color.BLACK);
        g.fillRect(houseX + houseWidth / 10, houseY + houseHeight / 2, 60, houseHeight / 2);

        // Забор
        g.setColor(new Color(139, 69, 19));
        int fenceHeight = 80;
        for (int i = 0; i < screenWidth; i += 20) {
            g.fillRect(i, screenHeight - fenceHeight, 10, fenceHeight); // Вертикальные столбы
            g.fillPolygon(new int[]{i, i + 5, i + 10}, new int[]{screenHeight - fenceHeight, screenHeight - fenceHeight - 10, screenHeight - fenceHeight}, 3); // Треугольные вершины
        }
    }

    public static void drawClouds(Graphics g, int[] cloudX, int cloudY) {
        g.setColor(Color.WHITE);
        for (int x : cloudX) {
            g.fillOval(x, cloudY, 100, 50);
            g.fillOval(x + 40, cloudY - 20, 80, 40);
            g.fillOval(x - 40, cloudY - 10, 70, 40);
        }
    }

    public static void drawSun(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 100, 100);
    }

    public static void drawMouse(Graphics g, int x, int y) {
    g.setColor(Color.GRAY);
    g.fillOval(x, y, 20, 10); // тело
    g.setColor(Color.BLACK);
    g.drawOval(x, y, 20, 10); // контур
    g.drawLine(x + 20, y + 5, x + 30, y + 5); // хвост
    }
}
