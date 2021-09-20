package entity.collidable;

import java.awt.*;

public class CollidableBox extends Collidable {

    public CollidableBox(int x, int y, int width, int height) {
        super(new Rectangle(x, y, width, height));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(13, 23, 17));
        g.fillRect(shape.getBounds().x, shape.getBounds().y, shape.getBounds().width, shape.getBounds().height);
    }
}
