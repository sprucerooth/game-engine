package entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    public static List<Entity> allEntities = new ArrayList<>();

    public double x, y;
    public int width, height;
    boolean solid;

    Entity(int x, int y, int width, int height, boolean solid) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        allEntities.add(this);
    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
