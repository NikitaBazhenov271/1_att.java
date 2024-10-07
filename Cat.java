import java.awt.*;

public class Cat implements Drawable {
    private int x, y;
    private int targetX, targetY;
    private int mouseX, mouseY;

    public Cat(int x, int y) {
        this.x = x;
        this.y = y;
        this.targetX = x;
        this.targetY = y;
    }

    public void setTarget(int mouseX, int mouseY) {//целевые координаты
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.targetX = mouseX;
        this.targetY = mouseY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void moveToTarget() {
        int speed = 6;
        if (x < targetX) x += speed;
        if (x > targetX) x -= speed;
        if (y < targetY) y += speed;
        if (y > targetY) y -= speed;
    }

    @Override
    public void draw(Graphics g) {
        // Проверка координат кота для отладки
        System.out.println("Cat coordinates: " + x + ", " + y);

        // Тело кота
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 120, 80); // Тело кота
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 120, 80);

        // Голова
        g.setColor(Color.ORANGE);
        g.fillOval(x + 100, y - 10, 70, 70);
        g.setColor(Color.BLACK);
        g.drawOval(x + 100, y - 10, 70, 70);

        // Уши
        g.setColor(Color.ORANGE);
        g.fillPolygon(new int[]{x + 110, x + 120, x + 130}, new int[]{y - 5, y - 25, y - 5}, 3); // Левое ухо
        g.fillPolygon(new int[]{x + 140, x + 150, x + 160}, new int[]{y - 5, y - 25, y - 5}, 3); // Правое ухо
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{x + 110, x + 120, x + 130}, new int[]{y - 5, y - 25, y - 5}, 3); // Контур левого уха
        g.drawPolygon(new int[]{x + 140, x + 150, x + 160}, new int[]{y - 5, y - 25, y - 5}, 3); // Контур правого уха

        // Глаза
        g.setColor(Color.WHITE);
        g.fillOval(x + 120, y, 20, 20); // Левый глаз
        g.fillOval(x + 140, y, 20, 20); // Правый глаз

        // Зрачки
        int eyeRadius = 8;
        int eyeXCenterLeft = x + 130;
        int eyeYCenterLeft = y + 10;
        int eyeXCenterRight = x + 150;
        int eyeYCenterRight = y + 10;

        int dxLeft = mouseX - eyeXCenterLeft;
        int dyLeft = mouseY - eyeYCenterLeft;
        double distanceLeft = Math.sqrt(dxLeft * dxLeft + dyLeft * dyLeft);
        if (distanceLeft > 10) {
            dxLeft = (int) (dxLeft * 10 / distanceLeft);
            dyLeft = (int) (dyLeft * 10 / distanceLeft);
        }

        int dxRight = mouseX - eyeXCenterRight;
        int dyRight = mouseY - eyeYCenterRight;
        double distanceRight = Math.sqrt(dxRight * dxRight + dyRight * dyRight);
        if (distanceRight > 10) {
            dxRight = (int) (dxRight * 10 / distanceRight);
            dyRight = (int) (dyRight * 10 / distanceRight);
        }

        g.setColor(Color.BLACK);
        g.fillOval(eyeXCenterLeft + dxLeft - eyeRadius / 2, eyeYCenterLeft + dyLeft - eyeRadius / 2, eyeRadius, eyeRadius); // Левый зрачок
        g.fillOval(eyeXCenterRight + dxRight - eyeRadius / 2, eyeYCenterRight + dyRight - eyeRadius / 2, eyeRadius, eyeRadius); // Правый зрачок

        // Нос
        g.setColor(Color.PINK);
        g.fillOval(x + 130, y + 20, 10, 10);

        // Рот
        g.setColor(Color.BLACK);
        g.drawArc(x + 120, y + 30, 30, 10, 0, -180);

        // Лапы
        g.setColor(Color.ORANGE);
        g.fillOval(x + 10, y + 60, 20, 30); // Передняя левая лапа
        g.fillOval(x + 30, y + 60, 20, 30); // Передняя правая лапа
        g.fillOval(x + 50, y + 60, 20, 30); // Задняя левая лапа
        g.fillOval(x + 70, y + 60, 20, 30); // Задняя правая лапа
        g.setColor(Color.BLACK);
        g.drawOval(x + 10, y + 60, 20, 30); // Контур передней левой лапы
        g.drawOval(x + 30, y + 60, 20, 30); // Контур передней правой лапы
        g.drawOval(x + 50, y + 60, 20, 30); // Контур задней левой лапы
        g.drawOval(x + 70, y + 60, 20, 30); // Контур задней правой лапы

        // Хвост
        g.setColor(Color.ORANGE);
        g.fillOval(x - 20, y + 20, 40, 10); // Хвост
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y + 20, 40, 10);
    }
}
