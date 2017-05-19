/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public class World extends Sprite 
{
    public World(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }
    
    public void paint(Graphics g)
    {
        // TODO
        g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void keyPressed(KeyEvent evt) 
    {
        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
    }                               
}
