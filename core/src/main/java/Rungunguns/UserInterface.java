package Rungunguns;

import Rungunguns.TextureBox.UserInterfaceTexture;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.graphics.Graphics;


import java.util.LinkedList;
import java.util.List;
import static Rungunguns.Maingame.GAME_HEIGHT;
import static Rungunguns.Maingame.GAME_WIDTH;

public class UserInterface {
    Texture[] numTexture = new Texture[10];
    Texture startText,resultText,highscoreText,scoreText;

    List<Integer> Score = new LinkedList<Integer>();


    Integer[] digits;

    private int numWidth = 53;
    private int highscoreY = 75;
    private int messageY = (int)(GAME_HEIGHT - 100);

    public UserInterface(UserInterfaceTexture userInterfaceTexture){
        highscoreText = new Texture("TextUI/0.png" );
        startText = new Texture("TextUI/PressSpace.png");
        resultText = new Texture("TextUI/result.png");
        scoreText = new Texture("TextUI/score.png");
        numTexture[0] = userInterfaceTexture.numZeroTexture();
        numTexture[1] = userInterfaceTexture.numOneTexture();
        numTexture[2] = userInterfaceTexture.numTwoTexture();
        numTexture[3] = userInterfaceTexture.numThreeTexture();
        numTexture[4] = userInterfaceTexture.numFourTexture();
        numTexture[5] = userInterfaceTexture.numFiveTexture();
        numTexture[6] = userInterfaceTexture.numSixTexture();
        numTexture[7] = userInterfaceTexture.numSevenTexture();
        numTexture[8] = userInterfaceTexture.numEightTexture();
        numTexture[9] = userInterfaceTexture.numNineTexture();
    }

    private Integer[] intToIntArrayByDigits(int integer){
        Score.clear();

        while(integer>0){
            int d = integer%10;
            Score.add(0,d);
            integer/=10;
        }
        return Score.toArray(new Integer[0]);

    }

    void displayScore(Graphics g,int tempScore){
        digits = intToIntArrayByDigits(tempScore);
        for(int i = 0; i<digits.length; i++){
            g.drawTexture(numTexture[digits[i]],i*numWidth,0);
        }
    }

    void displayHighscore (Graphics g, int highscore){

        digits = intToIntArrayByDigits(highscore);

        g.drawTexture(highscoreText, GAME_WIDTH/2 - highscoreText.getWidth()/2, highscoreY);

        if(digits.length > 0) {
            for (int i = 0; i < digits.length; i++) {
                g.drawTexture(numTexture[digits[i]],
                        (GAME_WIDTH / 2) - (digits.length * numWidth / 2) + (i * numWidth)+1,
                        highscoreY + 30);
            }
        } else {
            g.drawTexture(numTexture[0],GAME_WIDTH/2 - numWidth/2, highscoreY + 60);
        }
    }

    void displayStartMessage(Graphics g){
        g.drawTexture(startText, GAME_WIDTH/2 - startText.getWidth()/2 , messageY);
    }

    void displayResultMessage(Graphics g){
        g.drawTexture(resultText, GAME_WIDTH/2 - resultText.getWidth()/2 , messageY-300);
    }

    void displayScoreMessage(Graphics g){
        g.drawTexture(scoreText,GAME_WIDTH/2 - scoreText.getWidth()/2 , messageY);
    }






}
