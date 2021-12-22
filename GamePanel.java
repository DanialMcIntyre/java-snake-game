import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Timer timer = new Timer(125, this); //Set framerate (1000 = 1 frame/second)

    Player player = new Player(0, 0, 0);

    public GamePanel() {
    }

    //Draw stuff on screen method
    public void paint(Graphics g) {

        //Returns panel to original state, clearing the screen
        super.paint(g);

        //Draws shape
        g.setColor(Color.red);
        g.fillRect(player.x, player.y, 25, 25);

        //Starts a timer that basically calls the "actionPerformed" method every x amount per second
        timer.start();

    }

    //Main loop?
    public void actionPerformed(ActionEvent e) {

        //Moves player
        movePlayer();

        //Repaints screen (calls paint method)
        repaint();

    }


    public void movePlayer() {

        //Move player in desired direction
        if (player.direction == 0) {
            player.x+=25;
        } else if (player.direction == 1) {
            player.y+=25;
        } else if (player.direction == 2) {
            player.x-=25;
        } else if (player.direction == 3) {
            player.y-=25;
        }

    }


    /*

    Event Listeners

    */
    
    public void keyPressed(KeyEvent e) {

        //Choose player direction
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player.direction = 3;          
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            player.direction = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.direction = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            player.direction = 2;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
}
