import java.util.Random;

public class Apple {

    int x;
    int y;

    final int width;

    final Random random = new Random(System.currentTimeMillis());

    public Apple(int width) {
        this.x = random.nextInt(1000 / 25) * 25;
        this.y = random.nextInt(725 / 25) * 25;
        this.width = width;
    }

    //Respawn apple
    public void spawn() {
        x = random.nextInt(1000 / 25) * 25;
        y = random.nextInt(725 / 25) * 25;
    }
    
}
