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
public abstract class Sprite 
{
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Sprite()
    {
        this(0, 0, 100, 100);
    }
    
    public Sprite(int x, int y, int width, int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }
    
    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
