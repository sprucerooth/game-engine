package graphics;

import java.awt.image.BufferedImage;

public class Sprite {

    private int width, height, x, y;
    private double xScale, yScale;
    public int[] pixels;
    private SpriteSheet sheet;
    private BufferedImage image;

    public Sprite(int column, int row, int width, int height, SpriteSheet sheet) {
        this.x = column * width;
        this.y = row * height;
        this.width = width;
        this.height = height;
        this.sheet = sheet;
        pixels = new int[width * height];
        load();
    }

    public Sprite(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.xScale = 1;
        this.yScale = 1;
    }

    private void load() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}
