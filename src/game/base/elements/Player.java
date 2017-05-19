/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.elements;

import java.awt.Graphics;

/**
 *
 * @author Jorge I. Meza <jimezam at>
 */
public class Player extends Sprite 
{
    public Player(int x, int y) {
        super(x, y, 50, 50);
        
        // TODO
    }

    @Override
    public void paint(Graphics g) {
        // TODO
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }    
}
