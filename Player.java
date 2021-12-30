import java.util.Arrays;

public class Player {

    int headx;
    int heady;

    int length; // 1 = 1 head + 1 body piece

    int[] bodyx = {500, 500, 500};
    int[] bodyy = {375, 375, 375};

    int[] oldx = new int[3];
    int[] oldy = new int[3];

    int direction; // 0 = Right, 1 = Down, 2 = Left, 3 = Up

    final int width;

    boolean hasTurned = false;

    public Player(int x, int y, int direction, int width, int length) {
        this.headx = 500;
        this.heady = 375;
        this.direction = direction;
        this.width = width;
        this.length = length;
    }

    //Move player head in desired direction
    public void headMovement() {

        if (direction == 0) {
            headx += width;
        } else if (direction == 1) {
            heady += width;
        } else if (direction == 2) {
            headx -= width;
        } else if (direction == 3) {
            heady -= width;
        }
    }

    //Calculate first body piece movement
    public void firstBodyPieceMovementCalculation() {

        if (length >= 1) {
            oldx[0] = headx;
            oldy[0] = heady;
        }

    }

    //Calculate rest of body piece movement
    public void bodyMovementCalculation() {

        for (int i = 1; i < length; i++) {
            oldx[i] = bodyx[i - 1];
            oldy[i] = bodyy[i - 1];
        }

    }

    //Move body pieces
    public void bodyMovement() {

        //First body
        if (length >= 1) {
            bodyx[0] = oldx[0];
            bodyy[0] = oldy[0];
        }

        //Rest of body pieces
        for (int i = 1; i < length; i++) { 
            bodyx[i] = oldx[i];
            bodyy[i] = oldy[i];
        }

        hasTurned = false;

    }

    //Reset on collision with wall
    public void collision() {

        length = 3;

        headx = 500;
        heady = 375;

        oldx = Arrays.copyOf(oldx, 3);
        oldy = Arrays.copyOf(oldy, 3);
        bodyx = Arrays.copyOf(bodyx, 3);
        bodyy = Arrays.copyOf(bodyy, 3);

        Arrays.fill(oldx, 500);
        Arrays.fill(oldy, 375);
        Arrays.fill(bodyx, 500);
        Arrays.fill(bodyy, 375);

    }

    //Player collision with wall
    public void detectWallCollision() {
        if (headx < 0 || headx > 1000 - width || heady < 0 || heady > 740 - width) {
            collision();
        }
    }

    //Player collision with itself
    public void detectPlayerCollision() {
        for (int i = 1; i < length; i++) {
            if (headx == bodyx[i] && heady == bodyy[i]) {
                collision();
            }
        }
    }

    //Player apple collision
    public void appleCollision(Apple apple, int applex, int appley) {
        if (applex == this.headx && appley == this.heady) {
            apple.spawn();
            length++;

            oldx = Arrays.copyOf(oldx, oldx.length + 1);
            oldy = Arrays.copyOf(oldy, oldy.length + 1);
            bodyx = Arrays.copyOf(bodyx, bodyx.length + 1);
            bodyy = Arrays.copyOf(bodyy, bodyy.length + 1);
            bodyMovementCalculation();

        }
    }

    //Runs all player methods
    public void playerLogic(Apple apple, int applex, int appley) {
        firstBodyPieceMovementCalculation();
        bodyMovementCalculation();
        headMovement();
        appleCollision(apple, applex, appley);
        bodyMovement();
        detectPlayerCollision();
        detectWallCollision();
    }
    
}
