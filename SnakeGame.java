import javax.swing.*;
public class SnakeGame {

    public static void main(String args[]) {
        
        //Setup window settings
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1006, 760);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Snake Game");
        
        GamePanel panel = new GamePanel();

        frame.add(panel);
        frame.addKeyListener(panel);

    }
    
}
