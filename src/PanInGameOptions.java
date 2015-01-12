

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanInGameOptions extends JPanel {
//OptionsPanelBackground.png

    ImageIcon imgGBG = new ImageIcon("OptionsPanelBackground.png");
    Image iGBG;

    public PanInGameOptions() {
        super();
        setPreferredSize(new Dimension(100, 700));
        setBackground(Color.red);
        iGBG = imgGBG.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(iGBG, 0, 0, null);
    }
}
