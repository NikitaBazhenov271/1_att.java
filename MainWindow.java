import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MainWindow extends JFrame {
    private final BackgroundPanel backgroundPanel;
    private final Cat cat;

    public MainWindow() {
        setTitle("Cat and Mouse");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Инициализация панели, кота и облаков
        backgroundPanel = new BackgroundPanel();
        cat = new Cat(100, 100);
        Cloud cloud = new Cloud(new int[]{100, 300, 500}, 100, 2); // Создаем облака с начальными координатами

        backgroundPanel.setCat(cat);
        backgroundPanel.setCloud(cloud); // Передаем облака в панель фона

        backgroundPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cat.setTarget(e.getX(), e.getY());
                backgroundPanel.repaint();
            }
        });

        // Таймер для обновления состояния анимации
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                backgroundPanel.updateScene();
                cat.moveToTarget();
                backgroundPanel.repaint();
            }
        }, 0, 30); // Обновление каждые 30 миллисекунд

        setContentPane(backgroundPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
