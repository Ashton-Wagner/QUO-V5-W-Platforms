

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class PanDisplay extends JPanel implements ActionListener {

    private Yeti yeti;
    ImageIcon imgGBG = new ImageIcon("GameBackground.png");
    Image iGBG;
    int nFrame = 0;
    int nBgX = 0;
    private Timer timer;
    int nLevel[] = new int[10];
    boolean bGenLevel = true;
    Image iRooms[] = new Image[4];
    ////
    int nPlat[][] = new int[50][3];
    Image iPlat[] = new Image[4];
    int nNumRooms = 10;
    ////

    public PanDisplay() {

        super();
        iGBG = imgGBG.getImage();
        setBackground(Color.black);
        yeti = new Yeti();
        addKeyListener(new MovementChecker());
        setFocusable(true);
        timer = new Timer(80, this);
        ////This is a toggle, so that we dont constantly generate levels
        if (bGenLevel = true) {
            ////The '4' value determines how many rooms to generate
            GenerateLevel();
            bGenLevel = false;
        }
        ////Generates the platforms based on rooms
        for (int i = 0; i < 4; i++) {
            ImageIcon iiTemp = new ImageIcon("BG" + i + ".png");
            iRooms[i] = iiTemp.getImage();
        }
        for (int i = 0; i < 4; i++) {
            ImageIcon iiTemp = new ImageIcon("PL" + i + ".png");
            iPlat[i] = iiTemp.getImage();
        }
        timer.start();
    }

    ////Generates the level backgrounds
    public void GenerateLevel() {
        for (int i = 0; i < nNumRooms; i++) {
            ////the 4 is the # of room types
            ////For some reson it generates twice. This causes no problems, however.
            nLevel[i] = (int) (Math.random() * 4);
        }

        int nPlX = 0;
        int nTemp = 0;
        for (int i = 0; i < nNumRooms; i++) {
            if (nLevel[i] == 0) {
                nPlat[nTemp][0] = 0;
                nPlat[nTemp][1] = nPlX + 100;
                nPlat[nTemp][2] = 100;
                nPlat[(nTemp + 1)][0] = 0;
                nPlat[(nTemp + 1)][1] = nPlX + 200;
                nPlat[(nTemp + 1)][2] = 200;
                nPlat[(nTemp + 2)][0] = 0;
                nPlat[(nTemp + 2)][1] = nPlX + 200;
                nPlat[(nTemp + 2)][2] = 300;
                nPlat[(nTemp + 3)][0] = 0;
                nPlat[(nTemp + 3)][1] = nPlX + 200;
                nPlat[(nTemp + 3)][2] = 400;
            }
            if (nLevel[i] == 1) {
                nPlat[nTemp][0] = 1;
                nPlat[nTemp][1] = nPlX + 100;
                nPlat[nTemp][2] = 100;
                nPlat[(nTemp + 1)][0] = 1;
                nPlat[(nTemp + 1)][1] = nPlX + 200;
                nPlat[(nTemp + 1)][2] = 200;
                nPlat[(nTemp + 2)][0] = 1;
                nPlat[(nTemp + 2)][1] = nPlX + 200;
                nPlat[(nTemp + 2)][2] = 300;
                nPlat[(nTemp + 3)][0] = 1;
                nPlat[(nTemp + 3)][1] = nPlX + 200;
                nPlat[(nTemp + 3)][2] = 400;
            }
            if (nLevel[i] == 2) {
                nPlat[nTemp][0] = 2;
                nPlat[nTemp][1] = nPlX + 100;
                nPlat[nTemp][2] = 100;
                nPlat[(nTemp + 1)][0] = 2;
                nPlat[(nTemp + 1)][1] = nPlX + 200;
                nPlat[(nTemp + 1)][2] = 200;
                nPlat[(nTemp + 2)][0] = 2;
                nPlat[(nTemp + 2)][1] = nPlX + 200;
                nPlat[(nTemp + 2)][2] = 300;
                nPlat[(nTemp + 3)][0] = 2;
                nPlat[(nTemp + 3)][1] = nPlX + 200;
                nPlat[(nTemp + 3)][2] = 400;
            }
            if (nLevel[i] == 3) {
                nPlat[nTemp][0] = 3;
                nPlat[nTemp][1] = nPlX + 100;
                nPlat[nTemp][2] = 100;
                nPlat[(nTemp + 1)][0] = 3;
                nPlat[(nTemp + 1)][1] = nPlX + 200;
                nPlat[(nTemp + 1)][2] = 200;
                nPlat[(nTemp + 2)][0] = 3;
                nPlat[(nTemp + 2)][1] = nPlX + 200;
                nPlat[(nTemp + 2)][2] = 300;
                nPlat[(nTemp + 3)][0] = 3;
                nPlat[(nTemp + 3)][1] = nPlX + 200;
                nPlat[(nTemp + 3)][2] = 400;
            }
            nPlX += 1250;
            nTemp+=4;
        }
    }
    ////Changes the BG's x-value

    public void MoveChar(int _CharX) {
        nBgX = _CharX;
    }

    public void actionPerformed(ActionEvent arg0) {
        yeti.move();
        repaint();
    }

    public void paint(Graphics g) {
super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ////Paints the Bg's
        try {
            //TEST
            nBgX -= 30;
            ////Room 1
            if (nNumRooms >= 1) {
                g2d.drawImage(iRooms[nLevel[0]], nBgX, 0, null);
                g2d.drawImage(iPlat[nPlat[0][0]], nBgX + nPlat[0][1], nPlat[0][2], null);
                g2d.drawImage(iPlat[nPlat[1][0]], nBgX + nPlat[1][1], nPlat[1][2], null);
                g2d.drawImage(iPlat[nPlat[2][0]], nBgX + nPlat[2][1], nPlat[2][2], null);
                g2d.drawImage(iPlat[nPlat[3][0]], nBgX + nPlat[3][1], nPlat[3][2], null);
            }
            ////Room 2

            if (nNumRooms >= 2) {
                g2d.drawImage(iRooms[nLevel[1]], nBgX + iRooms[nLevel[0]].getWidth(this), 0, null);

                g2d.drawImage(iPlat[nPlat[4][0]], nBgX + nPlat[4][1], nPlat[4][2], null);
                g2d.drawImage(iPlat[nPlat[5][0]], nBgX + nPlat[5][1], nPlat[5][2], null);
                g2d.drawImage(iPlat[nPlat[6][0]], nBgX + nPlat[6][1], nPlat[6][2], null);
                g2d.drawImage(iPlat[nPlat[7][0]], nBgX + nPlat[7][1], nPlat[7][2], null);

            }

            ////Room 3
            if (nNumRooms >= 3) {
                g2d.drawImage(iRooms[nLevel[2]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 2, 0, null);
                g2d.drawImage(iPlat[nPlat[8][0]], nBgX + nPlat[8][1], nPlat[8][2], null);
                g2d.drawImage(iPlat[nPlat[9][0]], nBgX + nPlat[9][1], nPlat[9][2], null);
                g2d.drawImage(iPlat[nPlat[10][0]], nBgX + nPlat[10][1], nPlat[10][2], null);
                g2d.drawImage(iPlat[nPlat[11][0]], nBgX + nPlat[11][1], nPlat[11][2], null);

            }
            ////Room 4
            if (nNumRooms >= 4) {
                g2d.drawImage(iRooms[nLevel[3]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 3, 0, null);
                g2d.drawImage(iPlat[nPlat[12][0]], nBgX + nPlat[12][1], nPlat[12][2], null);
                g2d.drawImage(iPlat[nPlat[13][0]], nBgX + nPlat[13][1], nPlat[13][2], null);
                g2d.drawImage(iPlat[nPlat[14][0]], nBgX + nPlat[14][1], nPlat[14][2], null);
                g2d.drawImage(iPlat[nPlat[15][0]], nBgX + nPlat[15][1], nPlat[15][2], null);

            }
            ////Room 5
            if (nNumRooms >= 5) {
                g2d.drawImage(iRooms[nLevel[4]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 4, 0, null);
                g2d.drawImage(iPlat[nPlat[16][0]], nBgX + nPlat[16][1], nPlat[16][2], null);
                g2d.drawImage(iPlat[nPlat[17][0]], nBgX + nPlat[17][1], nPlat[17][2], null);
                g2d.drawImage(iPlat[nPlat[18][0]], nBgX + nPlat[18][1], nPlat[18][2], null);
                g2d.drawImage(iPlat[nPlat[19][0]], nBgX + nPlat[19][1], nPlat[19][2], null);

            }
            ////Room 6
            if (nNumRooms >= 6) {
                g2d.drawImage(iRooms[nLevel[5]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 5, 0, null);
                g2d.drawImage(iPlat[nPlat[20][0]], nBgX + nPlat[20][1], nPlat[20][2], null);
                g2d.drawImage(iPlat[nPlat[21][0]], nBgX + nPlat[21][1], nPlat[21][2], null);
                g2d.drawImage(iPlat[nPlat[22][0]], nBgX + nPlat[22][1], nPlat[22][2], null);
                g2d.drawImage(iPlat[nPlat[23][0]], nBgX + nPlat[23][1], nPlat[23][2], null);
            }
            ////Room 7
            if (nNumRooms >= 7) {
                g2d.drawImage(iRooms[nLevel[6]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 6, 0, null);
                g2d.drawImage(iPlat[nPlat[24][0]], nBgX + nPlat[24][1], nPlat[24][2], null);
                g2d.drawImage(iPlat[nPlat[25][0]], nBgX + nPlat[25][1], nPlat[25][2], null);
                g2d.drawImage(iPlat[nPlat[26][0]], nBgX + nPlat[26][1], nPlat[26][2], null);
                g2d.drawImage(iPlat[nPlat[27][0]], nBgX + nPlat[27][1], nPlat[27][2], null);
            }
            ////Room 8
            if (nNumRooms >= 8) {
                g2d.drawImage(iRooms[nLevel[7]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 7, 0, null);
                g2d.drawImage(iPlat[nPlat[28][0]], nBgX + nPlat[28][1], nPlat[28][2], null);
                g2d.drawImage(iPlat[nPlat[29][0]], nBgX + nPlat[29][1], nPlat[29][2], null);
                g2d.drawImage(iPlat[nPlat[30][0]], nBgX + nPlat[30][1], nPlat[30][2], null);
                g2d.drawImage(iPlat[nPlat[31][0]], nBgX + nPlat[31][1], nPlat[31][2], null);
            }
            ////Room 9
            if (nNumRooms >= 9) {
                g2d.drawImage(iRooms[nLevel[8]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 8, 0, null);
                g2d.drawImage(iPlat[nPlat[32][0]], nBgX + nPlat[32][1], nPlat[32][2], null);
                g2d.drawImage(iPlat[nPlat[33][0]], nBgX + nPlat[33][1], nPlat[33][2], null);
                g2d.drawImage(iPlat[nPlat[34][0]], nBgX + nPlat[34][1], nPlat[34][2], null);
                g2d.drawImage(iPlat[nPlat[35][0]], nBgX + nPlat[35][1], nPlat[35][2], null);
            }
            ////Room 10
            if (nNumRooms >= 10) {
                g2d.drawImage(iRooms[nLevel[9]], nBgX + (iRooms[nLevel[0]].getWidth(this)) * 9, 0, null);
                g2d.drawImage(iPlat[nPlat[36][0]], nBgX + nPlat[36][1], nPlat[36][2], null);
                g2d.drawImage(iPlat[nPlat[37][0]], nBgX + nPlat[37][1], nPlat[37][2], null);
                g2d.drawImage(iPlat[nPlat[38][0]], nBgX + nPlat[38][1], nPlat[38][2], null);
                g2d.drawImage(iPlat[nPlat[39][0]], nBgX + nPlat[39][1], nPlat[39][2], null);
            }
            //TEST
        } catch (Exception e) {
            e.printStackTrace();
        }

        ////Paints the Character
        g2d.drawImage(yeti.getImage(), yeti.getX(), yeti.getY(), null);

    }

    private class MovementChecker extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k) {
            yeti.keyReleased(k);
        }

        @Override
        public void keyPressed(KeyEvent k) {
            yeti.keyPressed(k);
        }
    }
     private class AttackChecker extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k2) {
            yeti.keyReleased2(k2);
        }

        @Override
        public void keyPressed(KeyEvent k2) {
            yeti.keyPressed2(k2);
        }
    }
}