import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Timer timer = new Timer(125, this); //Set framerate (1000 = 1 frame/second)

    Player player = new Player(0, 0, 0, 25);

    public GamePanel() {
    }

    //Draw stuff on screen method
    public void paint(Graphics g) {

        //Returns panel to original state, clearing the screen
        super.paint(g);

        //Draw stuff
        drawPlayer(g);

        //Starts a timer that basically calls the "actionPerformed" method every x amount per second
        timer.start();

    }

    //Main loop?
    public void actionPerformed(ActionEvent e) {

        //Game logic
        movePlayer();

        wallCollision();

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
        g.setColor(Color.red);
        g.fillRect(player.x, player.y, player.length, player.length);
    }

    /*
    **************
    Logic methods
    **************
    */

    //Move player
    public void movePlayer() {

        //Move player in desired direction
        if (player.direction == 0) {
            player.x += player.length;
        } else if (player.direction == 1) {
            player.y += player.length;
        } else if (player.direction == 2) {
            player.x -= player.length;
        } else if (player.direction == 3) {
            player.y -= player.length;
        }

    }

    //Player collision with wall
    public void wallCollision() {

        if (player.x < 0) {
            player.x = 500;
            player.y = 375;
        }

        if (player.x > 1000 - player.length) {
            player.x = 500;
            player.y = 375;
        }

        if (player.y < 0) {
            player.x = 500;
            player.y = 375;
        }

        if (player.y > 740 - player.length) {
            player.x = 500;
            player.y = 375;
        }

    }

    /*
    ***************
    Event Listeners
    ***************
    */
    
    public void keyPressed(KeyEvent e) {

        //Choose player direction
        if (e.getKeyCode() == KeyEvent.VK_W && player.direction != 1) {
            player.direction = 3;          
        } else if (e.getKeyCode() == KeyEvent.VK_D && player.direction != 2) {
            player.direction = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_S && player.direction != 3) {
            player.direction = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_A && player.direction != 0) {
            player.direction = 2;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
}
