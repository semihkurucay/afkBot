package afkBot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class MouseMover {

    private Robot bot;
    private int width;
    private int height;
    private Random random = new Random();

    public MouseMover() {
        try {
            bot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screenSize.getWidth();
            height = (int) screenSize.getHeight();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void startMoving() {
        
        int x = random.nextInt(width - 100) + 50;
        int y = random.nextInt(height - 100) + 50;
        smoothMouseMove(x, y);
        System.out.println("Mouse moved to: " + x + ", " + y);
    }

    private void smoothMouseMove(int targetX, int targetY) {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point currentPos = pointerInfo.getLocation();

        int steps = random.nextInt(20) + 20;
        for (int i = 0; i <= steps; i++) {
            int x = (int) (currentPos.x + (targetX - currentPos.x) * ((double) i / steps));
            int y = (int) (currentPos.y + (targetY - currentPos.y) * ((double) i / steps));

            x += random.nextInt(3) - 1;
            y += random.nextInt(3) - 1;

            bot.mouseMove(x, y);
            try {
                Thread.sleep(random.nextInt(20) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
