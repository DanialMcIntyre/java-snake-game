public class Player {

    int x;
    int y;
    int direction; // 0 = Right, 1 = Down, 2 = Left, 3 = Up

    final int length;

    public Player(int x, int y, int direction, int length) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.length = length;
    }
    
}
