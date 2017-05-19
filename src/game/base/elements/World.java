/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public class World extends Sprite 
{
    private Player player;
    
    public World(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        
        // TODO        
        setColor(Color.green);
        player = new Player(10, 10);
    }
    
    public void paint(Graphics g)
    {
        // TODO
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
        player.paint(g);
    }

    public void keyPressed(KeyEvent evt) 
    {
        // TODO
        System.out.println("[World] Key pressed: " + evt.getKeyChar());

        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
    }                               

    public void mousePressed(MouseEvent evt) 
    {
        // TODO
        System.out.println("[World] Mouse pressed: " + evt.getPoint());
    }
}
