/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.elements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public class Player extends Sprite 
{
    private int step;
    
    public Player(int x, int y) {
        super(x, y, 50, 50);
        
        step = 5;
        
        // TODO
    }

    public void move(int direction)
    {
        int nx = getX();
        int ny = getY();
        
        switch(direction)
        {
            case KeyEvent.VK_UP:
                ny -= step;
            break;
            case KeyEvent.VK_DOWN:
                ny += step;
            break;
            case KeyEvent.VK_LEFT:
                nx -= step;
            break;
            case KeyEvent.VK_RIGHT:
                nx += step;
            break;
            
            default:
                System.err.println("[PLAYER.MOVE] Invalid Direction: " + direction);
            break;
        }
        
        setX(nx);
        setY(ny);
        
        getUpdatable().update();
    }
    
    @Override
    public void paint(Graphics g) {
        // TODO
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }    

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
