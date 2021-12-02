package pndg.codeV2.ihm;

import pndg.codeV2.model.Localisable;
import pndg.codeV2.model.exceptions.JeuSnakeException;
import pndg.codeV2.presenter.PresenterSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BoardSnake extends JPanel implements ActionListener {

    private PresenterSnake pres;
    private boolean inGame = true;
    private Timer timer;

    public BoardSnake(PresenterSnake p) {
        pres = p;
        initBoard();
    }
    
    private void initBoard() {
        inGame = true;
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(C.B_WIDTH, C.B_HEIGHT));

        initGame();
    }

    private void initGame() {
        timer = null;
        for (int z = 0; z < pres.getDots(); z++) {
            pres.getTerrainTabX()[z] = 50 - z * 10;
            pres.getTerrainTabY()[z] = 50;
        }
        timer = new Timer(C.DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        Localisable[] tabloPommes = pres.getLesPommes();
        if (inGame && tabloPommes!=null) {
                //Dessine les pommes
                for (int l = 0; l < tabloPommes.length; l++) {
                    if (tabloPommes[l] != null) {
                        g.drawImage(FabriqueIhmSnake.creerObjet(TypeObjet.APPLE),
                                tabloPommes[l].getApple_x(), tabloPommes[l].getApple_y(),
                                this);
                    }
                }
                //dessine le serpent
                for (int z = 0; z < pres.getDots(); z++) {
                    if (z == 0) {
                        g.drawImage(FabriqueIhmSnake.creerObjet(TypeObjet.HEAD),
                                pres.getTerrainTabX()[z], pres.getTerrainTabY()[z],
                                this);
                    } else {
                        g.drawImage(FabriqueIhmSnake.creerObjet(TypeObjet.BALL),
                                pres.getTerrainTabX()[z], pres.getTerrainTabY()[z],
                                this);
                    }
                }
                Toolkit.getDefaultToolkit().sync();
        } else {
           gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        timer.stop();

        String msg = C.MSG_GAME_OVER;
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (C.B_WIDTH - metr.stringWidth(msg)) / 2, C.B_HEIGHT / 2);

        //proposition une nouvelle partie
        int reponse = JOptionPane.showConfirmDialog (this, "Une autre partie?","WARNING", JOptionPane.YES_NO_OPTION);

        if(reponse == JOptionPane.YES_OPTION){
            pres.init();
            initBoard();
        }else{
            System.exit(0);
        }

    }
    private void checkApple() throws JeuSnakeException {
        //tester si le serpent passe sur une pomme
        int idxPommeCollision=calculerCollisionApple(pres.getTerrainTabX()[0],pres.getTerrainTabY()[0]);

        if(idxPommeCollision!=-1){
            pres.gererCollision(idxPommeCollision);
            pres.getFen().majPomme(pres.getFjs().getScorePomme());
        }
    }
    public int calculerCollisionApple(int serpentX, int serpentY){
        return pres.calculerCollisionApple(serpentX,serpentY);
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
           try {
               checkApple();
               checkCollision();
               move();
           } catch (Exception ex){
               timer.stop();
           }
           repaint();
        }


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
