

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.Timer;

public class FraMain extends JFrame {

    PanMainMenu panMainMenu = new PanMainMenu();
    int i = 0;
    PanGame panGame = new PanGame();
    //PanPauseMenu panpausemenu = new PanPauseMenu();
    PanMain panMain = new PanMain();
    //PanStats panstats = new PanStats();
    File BackGroundMusic = new File("BGMusic2.wav"), NickCageLaughSound = new File("StartingLaugh.wav");
    AudioClip BGMusic, LaughSound;
    //for the backgroung music
    boolean hasDrawnPanMain, hasDrawnPanMainMenu, hasDrawnpanpausemenu, hasDrawnStats, isPlayingMusic;
    Timer MusicLoopTimer;
    
    public FraMain() {

        setTitle("Caged in");
        try {
            BGMusic = Applet.newAudioClip(BackGroundMusic.toURL());
            LaughSound = Applet.newAudioClip(NickCageLaughSound.toURL());

        } catch (Exception e) {
        }
        //Makes sure the frame is in the middle of the screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //This obtains screensize; we probably will take out
        setSize(1250, 700);
        setVisible(true);
        setLocationRelativeTo(null);

        add(panMainMenu);

        // draws the main menu
        if (hasDrawnPanMainMenu == false) {
            add(panMainMenu);
            if(isPlayingMusic == false){
                BGMusic.play();
                //isPlayingMusic=true;
            }
            
            hasDrawnPanMainMenu = true;
            //if(hasDrawnPanMainMenu == true){
               // BGMusic.play();
            //}
        }
        
        panMainMenu.btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                //this closes all components of the game running
            }
        });

        panMainMenu.btnPlay.addActionListener(switchListen);
        MusicLoopTimer = new Timer(66000, BGMusicUpdate);
        MusicLoopTimer.start();
    }

    class SwitchListen implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (hasDrawnPanMain == false) {
                add(panMain);
                LaughSound.play();
                hasDrawnPanMain = true;
            }
            panMainMenu.setVisible(false);
            panGame.setVisible(true);
        }
    }
    ActionListener switchListen = new SwitchListen();
        ActionListener BGMusicUpdate = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if(i==0){
                BGMusic.play();
            }
            else{
            BGMusic.stop();
            BGMusic.play();
        }
            i++;

        }
    };
}
