/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.elements;

import game.base.ui.Updatable;
import java.awt.Color;
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
    private Color color;
    private Updatable updatable;
    
    /*
    public Sprite()
    {
        this(0, 0, 100, 100);
    }
    */
    
    public Sprite(int x, int y, int width, int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(new Color((int)(Math.random()*256), 
                           (int)(Math.random()*256), 
                           (int)(Math.random()*256)));
    }
    
    public Sprite(int x, int y, int width, int height, Updatable updatable)
    {
        this(x, y, width, height);
        setUpdatable(updatable);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Updatable getUpdatable() {
        return updatable;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }
}
