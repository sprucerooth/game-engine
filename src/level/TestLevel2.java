package level;

import entity.Player;
import entity.collidable.CollidableBox;

import java.awt.*;

public class TestLevel2 implements Level {

    Canvas canvas;

    public TestLevel2(Canvas canvas, Player player) {
        this.canvas = canvas;
        player.x = 100;
        player.y = 50;
    }

    @Override
    public void generate() {
        new CollidableBox(0, 800, canvas.getWidth(), 50);
        new CollidableBox(0, 700, 50, 80);
        new CollidableBox(300, 660, 50, 80);
        new CollidableBox(101, 600, 50, 80);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(156, 209, 255));
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
