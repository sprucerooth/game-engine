package level;

import entity.Player;
import entity.collidable.CollidableBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level1 implements Level {

    private Canvas canvas;
    private Player player;
    private BufferedImage background, shade;
    private BufferedImage ground, groundMask;
    private BufferedImage cloud, cloud2;

    public Level1(final Canvas canvas, final Player player) {
        this.canvas = canvas;
        this.player = player;
        player.x = 20;
        player.y = 20;
    }

    public void generate() {
        try {
            background = ImageIO.read(new File("res/bg2.png"));
            shade = ImageIO.read(new File("res/shade.png"));
            ground = ImageIO.read(new File("res/ground.png"));
            groundMask = ImageIO.read(new File("res/ground_mask.png"));
            cloud = ImageIO.read(new File("res/cloud.png"));
            cloud2 = ImageIO.read(new File("res/cloud2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        new CollidableBox(0, 585, 700, 50);
        new CollidableBox(400, 450, 400, 50);

    }

    public void render(Graphics g) {
        g.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        g.drawImage(shade, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        g.drawImage(ground, 0, canvas.getHeight() - ground.getHeight(), canvas.getWidth(), ground.getHeight(), null);
        g.drawImage(cloud, 400, 220, cloud.getWidth() * 2, cloud.getHeight() * 2, null);
        g.drawImage(cloud2, 850, 350, cloud2.getWidth() * 2, cloud2.getHeight() * 2, null);
    }

    private void loadLevel(String path) {
        //load level file
    }

    public void update() {

    }

}
