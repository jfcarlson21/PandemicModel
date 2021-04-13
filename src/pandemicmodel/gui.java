/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author lainiecederholm
 */
public class gui extends JPanel{
    private static final int BOX_WIDTH = 800;
    private static final int BOX_HEIGHT = 800;
    
    private float ballRad = 2;
    private float ballX = ballRad+10;
    private float ballY = ballRad+10;
    private float ballVx;
    private float ballVy;
    private static final int UPDATE_RATE = 30;
    static ArrayList hPop = ParkPop.healthyPeople;
    
    public gui(float ballvx, float ballvy, float ballx, float bally){
        
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        ballX = ballx;
        ballY = bally;
        ballVx = ballvx;
        ballVy = ballvy;
        //start ball bouncing in its own thread
        Thread gameThread = new Thread(){
            public void run(){
                while(true){
                    ballX+=ballVx;
                    ballY+=ballVy;
                    if(ballX-ballRad<0){
                        ballVx = -ballVx;
                        ballX = ballRad;
                    }
                    else if(ballX + ballRad > BOX_WIDTH){
                        ballVx = -ballVx;
                        ballX = BOX_WIDTH - ballRad;
                    }
                    if(ballY-ballRad<0){
                        ballVy = -ballRad;
                        ballY = ballRad;
                    }
                    else if(ballY+ballRad> BOX_HEIGHT){
                        ballVy = -ballVy;
                        ballY = BOX_HEIGHT - ballRad;
                    }
                    repaint();
                    try{
                        Thread.sleep(1000 / UPDATE_RATE);
                    }
                    catch(InterruptedException ex){    
                    }
                }
            }
        };
        gameThread.start();    
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,BOX_WIDTH,BOX_HEIGHT);
        g.setColor(Color.GREEN);
        g.fillOval((int)(ballX-ballRad),(int)(ballY-ballRad),(int)(2*ballRad), 
                (int)(2*ballRad));
    }
}
