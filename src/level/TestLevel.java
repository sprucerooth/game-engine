package level;

import entity.Player;
import entity.collidable.CollidableBox;
import entity.collidable.ColliddablePolygon;

import java.awt.*;

public class TestLevel implements Level {

    Canvas canvas;

    public TestLevel(Canvas canvas, Player player) {
        this.canvas = canvas;
        player.x = 60;
        player.y = 20;
    }

    @Override
    public void generate() {

        Polygon poly = new Polygon();
        poly.xpoints = new int[]{50, 50, 450, 500, 600, 800, 1000, 1000};
        poly.ypoints = new int[]{100, 100, 840, 800, 760, 820, 700, 900};
        poly.npoints = 8;
        new ColliddablePolygon(poly);
        new CollidableBox(0, 800, 400, 20);
        new CollidableBox(0, 700, 50, 80);
        new CollidableBox(300, 700, 50, 80);
        new CollidableBox(100, 600, 50, 80);

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}