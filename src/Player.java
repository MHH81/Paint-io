/*public class Player
{
    import java.awt.Color;

    public class Player {
        public static final int RADIUS = 10;
        public static final int SPEED = 5;

        private int x;
        private int y;
        private Color color;

        public Player(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void move(int dx, int dy, int screenWidth, int screenHeight) {
            x += dx * SPEED;
            y += dy * SPEED;

            if (x < 0) {
                x = screenWidth - RADIUS;
            } else if (x > screenWidth) {
                x = RADIUS;
            }
            if (y < 0) {
                y = screenHeight - RADIUS;
            } else if (y > screenHeight) {
                y = RADIUS;
            }
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRadius() {
            return RADIUS;
        }

        public Color getColor() {
            return color;
        }
    }
}
*/