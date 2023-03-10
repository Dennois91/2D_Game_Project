package main;

public class Game implements Runnable {

    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS_SET = 90;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                lastFrame = now;
            frames++;

            //put stuff here that needs to be updated in 90FPS
                gamePanel.update();
                gamePanel.repaint();

            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS " + frames);
                frames = 0;

            }

        }
    }
}
