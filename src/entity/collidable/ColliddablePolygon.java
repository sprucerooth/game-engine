package entity.collidable;

import java.awt.*;

public class ColliddablePolygon extends Collidable {

    public ColliddablePolygon(Polygon shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon((Polygon) shape);
    }
}
