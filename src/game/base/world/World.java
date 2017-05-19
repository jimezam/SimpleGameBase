/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.world;

import game.base.element.Player;
import game.base.element.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import game.base.ui.GameSection;
import java.awt.Rectangle;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public class World extends Sprite implements GameSection
{
    private Player player;
    
    public World(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        
        // TODO        
        setColor(Color.green);

        player = new Player(10, 10);
        player.setGameSection(this);
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
        // System.out.println("[WORLD] Key pressed: " + evt.getKeyChar());

        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
        
        ////////////////////////////////////////////////////////////////////////

        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.move(evt.getKeyCode());
            
            return;
        }

        ////////////////////////////////////////////////////////////////////////
    }                               

    public void mousePressed(MouseEvent evt) 
    {
        // TODO
        // System.out.println("[WORLD] Mouse pressed: " + evt.getPoint());
    }

    @Override
    public void update() {
        updateGameSection();
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
