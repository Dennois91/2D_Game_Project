package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {


    public GameWindow(GamePanel gamePanel) throws HeadlessException {


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);



    }
}
