package pndg.code.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import pndg.code.model.*;
import pndg.code.presenter.PresenterSnake;

public class BoardSnake extends JPanel implements ActionListener {

    private PresenterSnake pres;

    private boolean inGame = true;

    private Timer timer;

    private Image ball;
    private Image apple;
    private Image head;

    public BoardSnake(PresenterSnake p) {
        pres = p;
        initBoard();
    }
    
    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(C.B_WIDTH, C.B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    private void initGame() {

        for (int z = 0; z < pres.getDots(); z++) {
            pres.getTerrainTabX()[z] = 50 - z * 10;
            pres.getTerrainTabY()[z] = 50;
        }
        //System.out.println(pres.afficherTerrain());
        timer = new Timer(C.DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, pres.getAppleX(), pres.getAppleY(), this);

            for (int z = 0; z < pres.getDots(); z++) {
                if (z == 0) {
                    g.drawImage(head, pres.getTerrainTabX()[z], pres.getTerrainTabY()[z], this);
                } else {
                    g.drawImage(ball, pres.getTerrainTabX()[z], pres.getTerrainTabY()[z], this);
                }
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = C.MSG_GAME_OVER;
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (C.B_WIDTH - metr.stringWidth(msg)) / 2, C.B_HEIGHT / 2);

        //proposition une nouvelle partie
        int reponse = JOptionPane.showConfirmDialog (null, "Une autre partie?","WARNING", JOptionPane.YES_NO_OPTION);

        if(reponse == JOptionPane.YES_OPTION) {
            inGame=true;
            initBoard();
        }else{
            System.exit(0);
        }

    }

    private void checkApple() {

        if ((pres.getTerrainTabX()[0] == pres.getAppleX())
                && (pres.getTerrainTabY()[0] == pres.getAppleY())) {
            pres.addPomme();
            pres.getFjs().faireGrandirSerpent();
            pres.getFjs().deplacerPomme();
        }
    }

    private void move() {

        for (int z = pres.getDots(); z > 0; z--) {
            pres.getTerrainTabX()[z] = pres.getTerrainTabX()[(z - 1)];
            pres.getTerrainTabY()[z] = pres.getTerrainTabY()[(z - 1)];
        }

        if (pres.isLeftDirection()) {
            pres.getTerrainTabX()[0] -= C.DOT_SIZE;
        }

        if (pres.isRightDirection()) {
            pres.getTerrainTabX()[0] += C.DOT_SIZE;
        }

        if (pres.isUpDirection()) {
            pres.getTerrainTabY()[0] -= C.DOT_SIZE;
        }

        if (pres.isDownDirection()) {
            pres.getTerrainTabY()[0] += C.DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = pres.getDots(); z > 0; z--) {
            /* test si le serpent est revenu sur sa queue */
            if ((z > 4) && (pres.getTerrainTabX()[0] == pres.getTerrainTabX()[z])
                    && (pres.getTerrainTabY()[0] == pres.getTerrainTabY()[z])) {
                inGame = false;
            }
        }
       //si toujours en jeu
        if (inGame) {
            inGame = checkInTerrain();
        }
        if (!inGame) {
            timer.stop();
        }
    }
    private boolean checkInTerrain(){
        boolean in=true;
        if (pres.getTerrainTabY()[0] >= C.B_HEIGHT) {
            in = false;
        }

        if (pres.getTerrainTabY()[0] < 0) {
            in = false;
        }

        if (pres.getTerrainTabX()[0] >= C.B_WIDTH) {
            in = false;
        }

        if (pres.getTerrainTabX()[0] < 0) {
            in = false;
        }
        return in;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!pres.isRightDirection())) {
                pres.setLeftDirection(true);
                pres.setUpDirection(false);
                pres.setDownDirection(false);
            }

            if ((key == KeyEvent.VK_RIGHT) && (!pres.isLeftDirection())) {
                pres.setRightDirection(true);
                pres.setUpDirection(false);
                pres.setDownDirection(false);
             }

            if ((key == KeyEvent.VK_UP) && (!pres.isDownDirection())) {
                pres.setUpDirection(true);
                pres.setRightDirection(false);
                pres.setLeftDirection(false);
            }

            if ((key == KeyEvent.VK_DOWN) && (!pres.isUpDirection())) {
                pres.setDownDirection(true);
                pres.setRightDirection(false);
                pres.setLeftDirection(false);
            }
        }
    }
}
