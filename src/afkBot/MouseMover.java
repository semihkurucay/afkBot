package afkBot;

import java.awt.*;
import java.util.Random;

public class MouseMover {

    private Robot bot;
    private Random random = new Random();
    private int width;
    private int height;

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
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point currentPos = pointerInfo.getLocation();
        int x = currentPos.x + random.nextInt(20) - 10; // -10 ile +10 arasında hareket
        int y = currentPos.y + random.nextInt(20) - 10; // -10 ile +10 arasında hareket

        // Ekran boyutları dahilinde kalmayı sağla
        x = Math.max(0, Math.min(x, width - 1));
        y = Math.max(0, Math.min(y, height - 1));

        bot.mouseMove(x, y);
        System.out.println("Mouse moved to: " + x + ", " + y);
    }
}
