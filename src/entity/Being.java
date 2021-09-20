package entity;

import graphics.Sprite;


public abstract class Being extends Entity {
    Sprite sprite;

    Being(int x, int y, int width, int height, boolean solid, Sprite sprite) {
        super(x, y, width, height, solid);
        this.sprite = sprite;
    }

    void move(final int xa, final int ya) {
        x += xa;
        y += ya;
    }

}
