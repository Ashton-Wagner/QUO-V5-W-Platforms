

import java.awt.Image;
import javax.swing.ImageIcon;
//ashton has all of these split up in a different branch
public class LoadImages {
    ////Ashton's Images
    ImageIcon imgiTime = new ImageIcon("Time.png");
    ImageIcon imgiScore = new ImageIcon("Score.png");
    ImageIcon imgiLives = new ImageIcon("Lives.png");
    ImageIcon imgiCoins = new ImageIcon("Coins.png");
    ImageIcon img0 = new ImageIcon("img0.png");
    ImageIcon img1 = new ImageIcon("img1.png");
    ImageIcon img2 = new ImageIcon("img2.png");
    ImageIcon img3 = new ImageIcon("img3.png");
    ImageIcon img4 = new ImageIcon("img4.png");
    ImageIcon img5 = new ImageIcon("img5.png");
    ImageIcon img6 = new ImageIcon("img6.png");
    ImageIcon img7 = new ImageIcon("img7.png");
    ImageIcon img8 = new ImageIcon("img8.png");
    ImageIcon img9 = new ImageIcon("img9.png");
    ImageIcon imgUIBG = new ImageIcon("UIBackground.png");
    ImageIcon imgGBG = new ImageIcon("GameBackground.png");
    Image iUIBG;
    Image iGBG;
    Image ariNumbers[] = new Image[10];
    Image imgTime;
    Image imgScore;
    Image imgLives;
    Image imgCoins;
    Image imgTimeCount1;
    Image imgTimeCount2;
    Image imgTimeCount3;
    ////Kevin's Images
    ImageIcon ir1 = new ImageIcon("YetiWalkLeft1.png");
    ImageIcon il1 = new ImageIcon("YetiWalkRight1.png");
    ImageIcon ir2 = new ImageIcon("YetiWalkLeft2.png");
    ImageIcon il2 = new ImageIcon("YetiWalkRight2.png");
    ImageIcon ir3 = new ImageIcon("YetiWalkLeft3.png");
    ImageIcon il3 = new ImageIcon("YetiWalkRight3.png");
    ImageIcon ir4 = new ImageIcon("YetiWalkLeft4.png");
    ImageIcon il4 = new ImageIcon("YetiWalkRight4.png");
    ImageIcon ir5 = new ImageIcon("YetiWalkLeft5.png");
    ImageIcon il5 = new ImageIcon("YetiWalkRight5.png");
    Image ImgMovement[][] = new Image[5][2];
    ////

    public LoadImages() {
        iUIBG = imgUIBG.getImage();
        iGBG = imgGBG.getImage();
        ariNumbers[0] = img0.getImage();
        ariNumbers[1] = img1.getImage();
        ariNumbers[2] = img2.getImage();
        ariNumbers[3] = img3.getImage();
        ariNumbers[4] = img4.getImage();
        ariNumbers[5] = img5.getImage();
        ariNumbers[6] = img6.getImage();
        ariNumbers[7] = img7.getImage();
        ariNumbers[8] = img8.getImage();
        ariNumbers[9] = img9.getImage();
        imgTime = imgiTime.getImage();
        imgScore = imgiScore.getImage();
        imgLives = imgiLives.getImage();
        imgCoins = imgiCoins.getImage();
        ////
        ImgMovement[0][0] = ir1.getImage();
        ImgMovement[0][1] = il1.getImage();
        ImgMovement[1][0] = ir2.getImage();
        ImgMovement[1][1] = il2.getImage();
        ImgMovement[2][0] = ir3.getImage();
        ImgMovement[2][1] = il3.getImage();
        ImgMovement[3][0] = ir4.getImage();
        ImgMovement[3][1] = il4.getImage();
        ImgMovement[4][0] = ir5.getImage();
        ImgMovement[4][1] = il5.getImage();
    }

    public Image GetimgUIBG() {
        return iUIBG;
    }
    public Image GetimgGameBG() {
        return iGBG;
    }

    public Image GetimgTime() {
        return imgTime;
    }

    public Image GetimgScore() {
        return imgScore;
    }

    public Image GetimgLives() {
        return imgLives;
    }

    public Image GetimgCoins() {
        return imgCoins;
    }

    public Image[] GetNumbers() {
        return ariNumbers;
    }
    public Image[][] GetYeti(){
    return ImgMovement;
    }
}