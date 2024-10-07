import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Cat cat;
    private Cloud cloud; // Добавляем облака как поле

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud; // Метод для установки облаков
    }

    public void updateScene() {
        cloud.move(); // Обновляем положение облаков
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawingPrimitives.drawHouseYard(g, getWidth(), getHeight()); // Отрисовка двора
        cloud.draw(g); // Рисуем облака
        DrawingPrimitives.drawSun(g, getWidth() - 150, 50); // Отрисовка солнца
        DrawingPrimitives.drawMouse(g, cat.getMouseX(), cat.getMouseY()); // Отрисовка мыши
        cat.draw(g); // Рисуем кота
    }
}
