package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                System.out.println("W");
                up = true;
            }
            case KeyEvent.VK_A -> {
                System.out.println("A");
                left = true;
            }
            case KeyEvent.VK_S -> {
                System.out.println("S");
                down = true;
            }
            case KeyEvent.VK_D -> {
                System.out.println("D");
                right = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                System.out.println("W");
                up = false;
            }
            case KeyEvent.VK_A -> {
                System.out.println("A");
                left = false;
            }
            case KeyEvent.VK_S -> {
                System.out.println("S");
                down = false;
            }
            case KeyEvent.VK_D -> {
                System.out.println("D");
                right = false;
            }
        }
    }
}
