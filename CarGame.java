// version 1
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import java.util.ArrayList;
// import java.util.Random;

// public class CarGame extends JPanel implements ActionListener {
//     private int carX = 250, carY = 400;
//     private int speed = 5;
//     private int score = 0;
//     private int lives = 3;
//     private boolean gameOver = false;
//     private Timer timer;
//     private ArrayList<Obstacle> obstacles;
//     private ArrayList<Item> items;
//     private Random random;

//     public CarGame() {
//         setPreferredSize(new Dimension(500, 600));
//         setBackground(Color.DARK_GRAY);
//         addKeyListener(new KeyAdapter() {
//             @Override
//             public void keyPressed(KeyEvent e) {
//                 if (e.getKeyCode() == KeyEvent.VK_A && carX > 50) {
//                     carX -= 30;
//                 } else if (e.getKeyCode() == KeyEvent.VK_D && carX < 400) {
//                     carX += 30;
//                 }
//             }
//         });
//         setFocusable(true);
//         timer = new Timer(50, this);
//         obstacles = new ArrayList<>();
//         items = new ArrayList<>();
//         random = new Random();
//         timer.start();
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (!gameOver) {
//             score++;
//             if (random.nextInt(100) < 5) {
//                 obstacles.add(new Obstacle(random.nextInt(400) + 50, 0, random.nextBoolean() ? "cone" : "spike"));
//             }
//             if (random.nextInt(200) < 5) {
//                 items.add(new Item(random.nextInt(400) + 50, 0, random.nextBoolean() ? "life" : "boost"));
//             }
//             for (Obstacle obs : obstacles) {
//                 obs.y += speed;
//                 if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(obs.x, obs.y, 50, 50))) {
//                     if (obs.type.equals("cone")) {
//                         lives--;
//                     } else {
//                         lives -= 2;
//                     }
//                     obstacles.remove(obs);
//                     break;
//                 }
//             }
//             for (Item item : items) {
//                 item.y += speed;
//                 if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(item.x, item.y, 50, 50))) {
//                     if (item.type.equals("life")) {
//                         lives++;
//                     } else {
//                         speed += 2;
//                     }
//                     items.remove(item);
//                     break;
//                 }
//             }
//             if (lives <= 0) {
//                 gameOver = true;
//             }
//             repaint();
//         }
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.setColor(Color.GRAY);
//         g.fillRect(50, 0, 400, 600);
//         g.setColor(Color.WHITE);
//         g.fillRect(45, 0, 5, 600);
//         g.fillRect(445, 0, 5, 600);
//         g.fillRect(245, 0, 10, 600);
//         g.setColor(Color.BLUE);
//         g.fillRect(carX, carY, 50, 100);
//         g.setColor(Color.RED);
//         for (Obstacle obs : obstacles) {
//             g.fillRect(obs.x, obs.y, 50, 50);
//         }
//         g.setColor(Color.GREEN);
//         for (Item item : items) {
//             g.fillOval(item.x, item.y, 50, 50);
//         }
//         g.setColor(Color.WHITE);
//         g.drawString("Score: " + score, 10, 20);
//         g.drawString("Lives: " + lives, 10, 40);
//         if (gameOver) {
//             g.drawString("Game Over!", 200, 300);
//         }
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Car Game");
//         CarGame game = new CarGame();
//         frame.add(game);
//         frame.pack();
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }

//     class Obstacle {
//         int x, y;
//         String type;

//         public Obstacle(int x, int y, String type) {
//             this.x = x;
//             this.y = y;
//             this.type = type;
//         }
//     }

//     class Item {
//         int x, y;
//         String type;

//         public Item(int x, int y, String type) {
//             this.x = x;
//             this.y = y;
//             this.type = type;
//         }
//     }
// }



// version 2 last working version
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import java.util.ArrayList;
// import java.util.Random;

// public class CarGame extends JPanel implements ActionListener {
//     private int carX = 250, carY = 400;
//     private int speed = 5;
//     private int score = 0;
//     private int lives = 3;
//     private boolean gameOver = false;
//     private Timer timer;
//     private ArrayList<Obstacle> obstacles;
//     private ArrayList<Item> items;
//     private Random random;
//     private Image carImage, coneImage, spikeImage, heartImage, boostImage;
//     private Image[] backgrounds;
//     private int currentBackgroundIndex = 0;
    
//     public CarGame() {
//         setPreferredSize(new Dimension(500, 600));
//         setBackground(Color.DARK_GRAY);
//         addKeyListener(new KeyAdapter() {
//             @Override
//             public void keyPressed(KeyEvent e) {
//                 if (e.getKeyCode() == KeyEvent.VK_A && carX > 50) {
//                     carX -= 30;
//                 } else if (e.getKeyCode() == KeyEvent.VK_D && carX < 400) {
//                     carX += 30;
//                 }
//             }
//         });
//         setFocusable(true);
//         timer = new Timer(50, this);
//         obstacles = new ArrayList<>();
//         items = new ArrayList<>();
//         random = new Random();
        
//         carImage = new ImageIcon("car.png").getImage();
//         coneImage = new ImageIcon("cone.png").getImage();
//         spikeImage = new ImageIcon("spike.png").getImage();
//         heartImage = new ImageIcon("heart.png").getImage();
//         boostImage = new ImageIcon("boost.png").getImage();
        
//         backgrounds = new Image[]{
//             new ImageIcon("background1.png").getImage(),
//             new ImageIcon("background2.png").getImage(),
//             new ImageIcon("background3.png").getImage()
//         };
        
//         timer.start();
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (!gameOver) {
//             score++;
//             if (score % 100 == 0) {
//                 currentBackgroundIndex = random.nextInt(backgrounds.length);
//             }
            
//             if (random.nextInt(100) < 5) {
//                 obstacles.add(new Obstacle(random.nextInt(400) + 50, 0, random.nextBoolean() ? "cone" : "spike"));
//             }
//             if (random.nextInt(200) < 5) {
//                 items.add(new Item(random.nextInt(400) + 50, 0, random.nextBoolean() ? "life" : "boost"));
//             }
//             for (Obstacle obs : obstacles) {
//                 obs.y += speed;
//                 if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(obs.x, obs.y, 50, 50))) {
//                     if (obs.type.equals("cone")) {
//                         lives--;
//                     } else {
//                         lives -= 2;
//                     }
//                     obstacles.remove(obs);
//                     break;
//                 }
//             }
//             for (Item item : items) {
//                 item.y += speed;
//                 if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(item.x, item.y, 50, 50))) {
//                     if (item.type.equals("life")) {
//                         lives++;
//                     } else {
//                         speed += 2;
//                     }
//                     items.remove(item);
//                     break;
//                 }
//             }
//             if (lives <= 0) {
//                 gameOver = true;
//             }
//             repaint();
//         }
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.drawImage(backgrounds[currentBackgroundIndex], 0, 0, 500, 600, this);
//         g.setColor(Color.GRAY);
//         g.fillRect(50, 0, 400, 600);
//         g.setColor(Color.WHITE);
//         g.fillRect(45, 0, 5, 600);
//         g.fillRect(445, 0, 5, 600);
//         g.fillRect(245, 0, 10, 600);
//         g.drawImage(carImage, carX, carY, 50, 100, this);
        
//         for (Obstacle obs : obstacles) {
//             g.drawImage(obs.type.equals("cone") ? coneImage : spikeImage, obs.x, obs.y, 50, 50, this);
//         }
        
//         for (Item item : items) {
//             g.drawImage(item.type.equals("life") ? heartImage : boostImage, item.x, item.y, 50, 50, this);
//         }
        
//         g.setColor(Color.WHITE);
//         g.drawString("Score: " + score, 10, 20);
//         g.drawString("Lives: " + lives, 10, 40);
//         if (gameOver) {
//             g.drawString("Game Over!", 200, 300);
//         }
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Car Game");
//         CarGame game = new CarGame();
//         frame.add(game);
//         frame.pack();
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }

//     class Obstacle {
//         int x, y;
//         String type;

//         public Obstacle(int x, int y, String type) {
//             this.x = x;
//             this.y = y;
//             this.type = type;
//         }
//     }

//     class Item {
//         int x, y;
//         String type;

//         public Item(int x, int y, String type) {
//             this.x = x;
//             this.y = y;
//             this.type = type;
//         }
//     }
// }

//Version 3.0 play pause restart added

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class CarGame extends JPanel implements ActionListener {
    private int carX = 250, carY = 400;
    private int speed = 5;
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;
    private boolean paused = false;
    private Timer timer;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Item> items;
    private Random random;
    private Image carImage, coneImage, spikeImage, heartImage, boostImage;
    private Image[] backgrounds;
    private int currentBackgroundIndex = 0;
    
    public CarGame() {
        setPreferredSize(new Dimension(500, 600));
        setBackground(Color.DARK_GRAY);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_A && carX > 50) {
                        carX -= 30;
                    } else if (e.getKeyCode() == KeyEvent.VK_D && carX < 400) {
                        carX += 30;
                    } else if (e.getKeyCode() == KeyEvent.VK_P) {
                        paused = !paused;
                    }
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                        restartGame();
                    }
                }
            }
        });
        setFocusable(true);
        timer = new Timer(50, this);
        obstacles = new ArrayList<>();
        items = new ArrayList<>();
        random = new Random();
        
        carImage = new ImageIcon("car.png").getImage();
        coneImage = new ImageIcon("cone.png").getImage();
        spikeImage = new ImageIcon("spike.png").getImage();
        heartImage = new ImageIcon("heart.png").getImage();
        boostImage = new ImageIcon("boost.png").getImage();
        
        backgrounds = new Image[]{
            new ImageIcon("background1.png").getImage(),
            new ImageIcon("background2.png").getImage(),
            new ImageIcon("background3.png").getImage()
        };
        
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) {
            score++;
            if (score % 100 == 0) {
                currentBackgroundIndex = random.nextInt(backgrounds.length);
            }
            
            if (random.nextInt(100) < 5) {
                obstacles.add(new Obstacle(random.nextInt(400) + 50, 0, random.nextBoolean() ? "cone" : "spike"));
            }
            if (random.nextInt(200) < 5) {
                items.add(new Item(random.nextInt(400) + 50, 0, random.nextBoolean() ? "life" : "boost"));
            }
            for (Obstacle obs : obstacles) {
                obs.y += speed;
                if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(obs.x, obs.y, 50, 50))) {
                    if (obs.type.equals("cone")) {
                        lives--;
                    } else {
                        lives -= 2;
                    }
                    obstacles.remove(obs);
                    break;
                }
            }
            for (Item item : items) {
                item.y += speed;
                if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(item.x, item.y, 50, 50))) {
                    if (item.type.equals("life")) {
                        lives++;
                    } else {
                        speed += 2;
                    }
                    items.remove(item);
                    break;
                }
            }
            if (lives <= 0) {
				lives=0;
                gameOver = true;
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgrounds[currentBackgroundIndex], 0, 0, 500, 600, this);
        g.setColor(Color.GRAY);
        g.fillRect(50, 0, 400, 600);
        g.setColor(Color.WHITE);
        g.fillRect(45, 0, 5, 600);
        g.fillRect(445, 0, 5, 600);
        g.fillRect(245, 0, 10, 600);
        g.drawImage(carImage, carX, carY, 50, 100, this);
        
        for (Obstacle obs : obstacles) {
            g.drawImage(obs.type.equals("cone") ? coneImage : spikeImage, obs.x, obs.y, 50, 50, this);
        }
        
        for (Item item : items) {
            g.drawImage(item.type.equals("life") ? heartImage : boostImage, item.x, item.y, 50, 50, this);
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Score:   " + score, 10, 20);
        g.drawString("Lives:   " + lives, 10, 40);
        if (gameOver) {
            g.drawString("Game Over! Press R to Restart", 200, 300);
        }
    }
    
    class Obstacle {
        int x, y;
        String type;
        
        public Obstacle(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    
    class Item {
        int x, y;
        String type;
        
        public Item(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    
    private void restartGame() {
        carX = 250;
        speed = 5;
        score = 0;
        lives = 3;
        gameOver = false;
        obstacles.clear();
        items.clear();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Game");
        CarGame game = new CarGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class CarGame extends JPanel implements ActionListener {
    private int carX = 250, carY = 400;
    private int speed = 5;
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;
    private boolean paused = false;
    private Timer timer;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Item> items;
    private Random random;
    private Image carImage, coneImage, spikeImage, heartImage, boostImage;
    private Image[] backgrounds;
    private int currentBackgroundIndex = 0;
    private final String HEART_EMOJI = "❤️";
    
    public CarGame() {
        setPreferredSize(new Dimension(500, 600));
        setBackground(Color.DARK_GRAY);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_A && carX > 50) {
                        carX -= 30;
                    } else if (e.getKeyCode() == KeyEvent.VK_D && carX < 400) {
                        carX += 30;
                    } else if (e.getKeyCode() == KeyEvent.VK_P) {
                        paused = !paused;
                    }
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_R) {
                        restartGame();
                    }
                }
            }
        });
        setFocusable(true);
        timer = new Timer(50, this);
        obstacles = new ArrayList<>();
        items = new ArrayList<>();
        random = new Random();
        
        carImage = new ImageIcon("car.png").getImage();
        coneImage = new ImageIcon("cone.png").getImage();
        spikeImage = new ImageIcon("spike.png").getImage();
        heartImage = new ImageIcon("heart.png").getImage();
        boostImage = new ImageIcon("boost.png").getImage();
        
        backgrounds = new Image[]{
            new ImageIcon("background1.png").getImage(),
            new ImageIcon("background2.png").getImage(),
            new ImageIcon("background3.png").getImage()
        };
        
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) {
            score++;
            if (score % 100 == 0) {
                currentBackgroundIndex = random.nextInt(backgrounds.length);
            }
            
            if (random.nextInt(100) < 5) {
                obstacles.add(new Obstacle(random.nextInt(400) + 50, 0, random.nextBoolean() ? "cone" : "spike"));
            }
            if (random.nextInt(200) < 5) {
                items.add(new Item(random.nextInt(400) + 50, 0, random.nextBoolean() ? "life" : "boost"));
            }
            for (Obstacle obs : obstacles) {
                obs.y += speed;
                if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(obs.x, obs.y, 50, 50))) {
                    if (obs.type.equals("cone")) {
                        lives--;
                    } else {
                        lives -= 2;
                    }
                    obstacles.remove(obs);
                    break;
                }
            }
            for (Item item : items) {
                item.y += speed;
                if (new Rectangle(carX, carY, 50, 100).intersects(new Rectangle(item.x, item.y, 50, 50))) {
                    if (item.type.equals("life")) {
                        lives++;
                    } else {
                        speed += 2;
                    }
                    items.remove(item);
                    break;
                }
            }
            if (lives <= 0) {
                lives = 0;
                gameOver = true;
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgrounds[currentBackgroundIndex], 0, 0, 100, 600, this);
        g.setColor(Color.GRAY);
        g.fillRect(50, 0, 400, 600);
        g.setColor(Color.WHITE);
        g.fillRect(45, 0, 5, 600);
        g.fillRect(445, 0, 5, 600);
        g.fillRect(245, 0, 10, 600);
        g.drawImage(carImage, carX, carY, 50, 100, this);
        
        for (Obstacle obs : obstacles) {
            g.drawImage(obs.type.equals("cone") ? coneImage : spikeImage, obs.x, obs.y, 50, 50, this);
        }
        
        for (Item item : items) {
            g.drawImage(item.type.equals("life") ? heartImage : boostImage, item.x, item.y, 50, 50, this);
        }
        
        // Draw score and lives
        g.setColor(Color.WHITE);
        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        g.drawString("Score: " + score, 10, 20);
        
        // Draw lives as heart emojis
        g.drawString("Lives: ", 10, 40);
        for (int i = 0; i < lives; i++) {
            g.drawString(HEART_EMOJI, 70 + (i * 25), 40);
        }
        
        if (gameOver) {
            g.setFont(new Font("Dialog", Font.BOLD, 20));
            g.drawString("Game Over! Press R to Restart", 100, 300);
        }
    }
    
    class Obstacle {
        int x, y;
        String type;
        
        public Obstacle(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    
    class Item {
        int x, y;
        String type;
        
        public Item(int x, int y, String type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    
    private void restartGame() {
        carX = 250;
        speed = 5;
        score = 0;
        lives = 3;
        gameOver = false;
        obstacles.clear();
        items.clear();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Game");
        CarGame game = new CarGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
