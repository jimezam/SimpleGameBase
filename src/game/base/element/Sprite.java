/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.element;

import java.awt.Color;
import java.awt.Graphics;
import game.base.ui.GameSection;
import java.awt.Rectangle;

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
    private GameSection section;
    
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
    
    public Sprite(int x, int y, int width, int height, GameSection gameSection)
    {
        this(x, y, width, height);
        setGameSection(gameSection);
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

    public GameSection getGameSection() {
        return section;
    }

    public void setGameSection(GameSection section) {
        this.section = section;
    }
    
    public boolean isOutOfGameSection()
    {
        if(getGameSection() == null)
            return false;
        
        Rectangle bounds = getGameSection().getBoundaries();
        
        if(getX() >= bounds.getX() &
           getY() >= bounds.getY() & 
           getX() + getWidth() <= bounds.getX() + bounds.getWidth() &
           getY() + getHeight()<= bounds.getY() + bounds.getHeight())
        {
            return false;
        }
        
        return true;
    }
    
    public void updateGameSection()
    {
        if(getGameSection() != null)
            getGameSection().update();
    }

    public boolean checkCollision(Sprite other)
    {
        // Collision x-axis?
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

        // Collision y-axis?
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

        // Collision only if on both axes
        return collisionX && collisionY;        
    }
}
