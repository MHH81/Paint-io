/*import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaintIOGame
{
    import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

    public static class PaintIOGame extends JPanel implements ActionListener {
        private static final int SCREEN_WIDTH = 800;
        private static final int SCREEN_HEIGHT = 600;
        private static final int TIMER_DELAY = 10;

        private List<Player> players;
        private Timer timer;
        private Random random;

        public PaintIOGame() {
            players = new ArrayList<>();
            random = new Random();

            // Create a new player at a random position
            Point startPos = getRandomStartPosition();
            players.add(new Player(startPos.x, startPos.y, Color.BLUE));

            // Start the game timer
            timer = new Timer(TIMER_DELAY, this);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Move the player in a random direction
            for (Player player : players) {
                player.move(random.nextInt(3) - 1, random.nextInt(3) - 1, SCREEN_WIDTH, SCREEN_HEIGHT);
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
            int x = random.nextInt(SCREEN_WIDTH - Player.RADIUS * 2) + Player.RADIUS;
            int y = random.nextInt(SCREEN_HEIGHT - Player.RADIUS * 2) + Player.RADIUS;
            return new Point(x, y);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Paint.io");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

            PaintIOGame game = new PaintIOGame.PaintIOGame();
            frame.add(game);

            JButton restartButton = new JButton("Restart");
            restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.timer.stop();
                    game.players.clear();
                    Point startPos = game.getRandomStartPosition();
                    game.players.add(new Player(startPos.x, startPos.y, Color.BLUE));
                    game.timer.start();
                }
            });
            frame.add(restartButton, "South");

            frame.pack();
            frame.setVisible(true);
        }
    }
}
*/