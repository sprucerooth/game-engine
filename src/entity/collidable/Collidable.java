package entity.collidable;

import entity.Being;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Collidable {

    public static List<Collidable> all = new ArrayList<>();

    Shape shape;

    public Collidable(Shape shape) {
        this.shape = shape;
        all.add(this);
    }

    public abstract void draw(Graphics g);

    public boolean intersects(Rectangle2D rect) {
        return shape.intersects(rect);
    }


    public static double possibleDistanceRight(Being b, double desiredDistance, double yOffset) {
        double possibleDistance = desiredDistance;
        for (Collidable c : all) {
            for (double i = desiredDistance; i >= 0; i--) {
                if (!c.intersects(new Rectangle((int) (b.x + i), (int) (b.y + yOffset), b.width, b.height))) {
                    possibleDistance = Math.min(i, possibleDistance);
                    break;
                }
            }
        }
        return possibleDistance;
    }

    public static double possibleDistanceLeft(Being b, double desiredDistance, double yOffset) {
        double possibleDistance = desiredDistance;
        for (Collidable c : all) {
            for (double i = desiredDistance; i <= 0; i++) {
                if (!c.intersects(new Rectangle((int) (b.x + i), (int) (b.y + yOffset), b.width, b.height))) {
                    possibleDistance = Math.max(i, possibleDistance);
                    break;
                }
            }
        }
        return possibleDistance;
    }

    public static double possibleDistanceDown(Being b, double desiredDistance, double xOffset) {
        double possibleDistance = desiredDistance;
        for (Collidable c : all) {
            for (double i = desiredDistance; i >= 0; i--) {
                if (!c.intersects(new Rectangle((int) (b.x + xOffset), (int) (b.y + i), b.width, b.height))) {
                    possibleDistance = Math.min(i, possibleDistance);
                    break;
                }
            }
        }
        return possibleDistance;
    }

    public static double possibleDistanceUp(Being b, double desiredDistance) {
        double possibleDistance = desiredDistance;
        for (Collidable c : all) {
            for (double i = desiredDistance; i <= 0; i++) {
                if (!c.intersects(new Rectangle((int) b.x, (int) (b.y + i), b.width, b.height))) {
                    possibleDistance = Math.max(i, possibleDistance);
                    break;
                }
            }
        }

        return possibleDistance;
    }
}
