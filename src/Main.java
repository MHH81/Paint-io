import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PaintIOGame extends JPanel implements ActionListener {
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int PLAYER_RADIUS = 10;
    private static final int PLAYER_SPEED = 5;
    private static final int TIMER_DELAY = 10;

    private List<Player> players;
    private Timer timer;
    private Random random;

    public PaintIOGame() {
        players = new ArrayList<>();
        random = new Random();

        // Create a new player at a random position
        Point startPos = getRandomStartPosition();
        players.add(new Player(startPos.x, startPos.y, PLAYER_RADIUS, Color.BLUE));

        // Start the game timer
        timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the player in a random direction
        for (Player player : players) {
            int dx = random.nextInt(PLAYER_SPEED * 2 + 1) - PLAYER_SPEED;
            int dy = random.nextInt(PLAYER_SPEED * 2 + 1) - PLAYER_SPEED;
            player.move(dx, dy, SCREEN_WIDTH, SCREEN_HEIGHT);
        }

        // Repaint the game screen
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the players
        for (Player player : players) {
            g.setColor(player.getColor());
            g.fillOval(player.getX() - player.getRadius(), player.getY() - player.getRadius(),
                    player.getRadius() * 2, player.getRadius() * 2);
        }
    }

    private Point getRandomStartPosition() {
        int x = random.nextInt(SCREEN_WIDTH - PLAYER_RADIUS * 2) + PLAYER_RADIUS;
        int y = random.nextInt(SCREEN_HEIGHT - PLAYER_RADIUS * 2) + PLAYER_RADIUS;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint.io");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        PaintIOGame game = new PaintIOGame();
        frame.add(game);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.timer.stop();
                game.players.clear();
                Point startPos = game.getRandomStartPosition();
                game.players.add(new Player(startPos.x, startPos.y, PLAYER_RADIUS, Color.BLUE));
                game.timer.start();
            }
        });
        frame.add(restartButton, "South");

        frame.pack();
        frame.setVisible(true);
    }
}

class Player {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Player(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void move(int dx, int dy, int screenWidth, int screenHeight) {
        x += dx;
        y += dy;

        if (x < 0) {
            x = screenWidth - radius;
        } else if (x > screenWidth) {
            x = radius;
        }
        if (y < 0) {
            y = screenHeight - radius;
        } else if (y > screenHeight) {
            y = radius;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}