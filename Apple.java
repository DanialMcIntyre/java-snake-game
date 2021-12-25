import java.util.Random;

public class Apple {

    long x;
    long y;

    final int width;

    final Random random = new Random(System.currentTimeMillis());

    public Apple(int width) {
        this.x = random.nextInt(1000 / 25) * 25;
        this.y = random.nextInt(750 / 25) * 25;
        this.width = width;
    }

    //Respawn apple
    public void spawn() {
        x = random.nextInt(1000 / 25) * 25;
        y = random.nextInt(750 / 25) * 25;
    }

    //Player apple collision
    public int collision(int playerx, int playery, int playerlength) {
        if (playerx == x && playery == y) {
            spawn();
            playerlength++;
        }
        return playerlength;
    }
    
}
