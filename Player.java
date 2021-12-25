public class Player {

    int headx;
    int heady;

    int length; // 1 = 1 head + 1 body piece

    int[] bodyx = new int[10000];
    int[] bodyy = new int[10000];

    int[] oldx = new int[10000];
    int[] oldy = new int[10000];

    int direction; // 0 = Right, 1 = Down, 2 = Left, 3 = Up

    final int width;

    public Player(int x, int y, int direction, int width, int length) {
        this.headx = x;
        this.heady = y;
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

    //Store positions for body 
    public void bodyMovementCalculation() {

        //First body piece
        if (length >= 1) {
            oldx[0] = headx;
            oldy[0] = heady;
        }

        //Rest of body pieces
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

    }

    //Player collision with wall
    public void wallCollision() {

        if (headx < 0) {
            headx = 500;
            heady = 375;
        }
        if (headx > 1000 - width) {
            headx = 500;
            heady = 375;
        }
        if (heady < 0) {
            headx = 500;
            heady = 375;
        }
        if (heady > 740 - width) {
            headx = 500;
            heady = 375;
        }

    }

    //Runs all player methods
    public void playerLogic() {
        bodyMovementCalculation();
        headMovement();
        bodyMovement();
        wallCollision();
    }
    
}
