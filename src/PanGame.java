

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanGame extends JPanel{
    PanDisplay pandisplay = new PanDisplay();
    PanInGameOptions paningameoptions = new PanInGameOptions();
   //panel to hold the main game and the ingame options 
    public PanGame(){
        setLayout(new BorderLayout());
        add(paningameoptions, BorderLayout.EAST);
        add(pandisplay, BorderLayout.CENTER);

    }
}
