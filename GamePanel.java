import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    final int framerate = 10;
    Timer timer = new Timer(1000 / framerate, this); //Set framerate (1000 = 1 frame/second)

    Player player = new Player(0, 0, 0, 25, 3);
    Apple apple = new Apple(25);

    public GamePanel() {
    }

    //Draw stuff on screen method
    public void paint(Graphics g) {

        //Returns panel to original state, clearing the screen
        super.paint(g);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
        g.drawString(String.valueOf(player.length - 3), 50, 50);

        //Draw stuff
        drawPlayer(g);

        //Starts a timer that basically calls the "actionPerformed" method every x amount per second
        timer.start();

    }

    //Main loop?
    public void actionPerformed(ActionEvent e) {

        //Game logic
        player.playerLogic(apple, apple.x, apple.y);

        //Repaints screen (calls paint method)
        repaint();

    }

    /*
    **************
    Paint methods
    **************
    */

    //Draw player
    public void drawPlayer(Graphics g) {

        //Player head
        g.setColor(Color.red);
        g.fillRect(player.headx, player.heady, player.width, player.width);

        //Player body
        g.setColor(Color.green);
        for (int i = 0; i < player.length; i++) {
            g.fillRect(player.bodyx[i], player.bodyy[i], player.width, player.width);
        }

        //Apple
        g.setColor(Color.blue);
        g.fillRect((int)apple.x, (int)apple.y, apple.width, apple.width);

    }

    /*
    ***************
    Event Listeners
    ***************
    */
    
    public void keyPressed(KeyEvent e) {

        //Choose player direction
        if (player.hasTurned == false) {
            if (e.getKeyCode() == KeyEvent.VK_W && player.direction != 1) {
                player.direction = 3;  
                player.hasTurned = true;        
            } else if (e.getKeyCode() == KeyEvent.VK_D && player.direction != 2) {
                player.direction = 0;
                player.hasTurned = true;  
            } else if (e.getKeyCode() == KeyEvent.VK_S && player.direction != 3) {
                player.direction = 1;
                player.hasTurned = true;  
            } else if (e.getKeyCode() == KeyEvent.VK_A && player.direction != 0) {
                player.direction = 2;
                player.hasTurned = true;  
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
}
