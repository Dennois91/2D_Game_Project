package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {


    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private int playerSpeed = 4;
    private KeyboardInputs keyboardInputs = new KeyboardInputs(this);

    private BufferedImage img, subImage;


    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImg();
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        setDoubleBuffered(true);
        setFocusable(true);
        setPanelSize();
    }

    private void importImg() {
        try (InputStream is = getClass().getResourceAsStream("/player_sprites.png")) {
            assert is != null;
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        final int originalTileSize = 16;
        final int scale = 5;
        final int tileSize = originalTileSize * scale; // 16*5 = 80*80 Tile
        final int maxScreenCol = 16;
        final int maxScreenRow = 12;
        final int screenWidth = tileSize * maxScreenCol; //1280
        final int screenHight = tileSize * maxScreenRow; //960

        Dimension size = new Dimension(screenWidth, screenHight);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }

    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        subImage = img.getSubimage(1 * 64, 8 * 40, 64, 40);
        g2.drawImage(subImage, (int) xDelta, (int) yDelta, 128, 80, null);

    }

    public void update() {

        if (keyboardInputs.up) {
            yDelta -= playerSpeed;
        } else if (keyboardInputs.down) {
            yDelta += playerSpeed;
        } else if (keyboardInputs.left) {
            xDelta -= playerSpeed;
        } else if (keyboardInputs.right) {
            xDelta += playerSpeed;
        }
    }
}
