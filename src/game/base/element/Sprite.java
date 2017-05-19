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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    protected BufferedImage image;
    
    public Sprite(int x, int y, int width, int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(new Color((int)(Math.random()*256), 
                           (int)(Math.random()*256), 
                           (int)(Math.random()*256)));
        setGameSection(null);
    }
    
    public Sprite(int x, int y, int width, int height, GameSection gameSection)
    {
        this(x, y, width, height);
        setGameSection(gameSection);
    }
    
    public void paint(Graphics g)
    {
        // TODO

        if(getColor() != null)
        {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        
        if(getImage() != null)
            g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
    }

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

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage setImage(String filename)
    {
        try 
        {
            setImage(ImageIO.read(new File(filename)));
            
            return getImage();
        } 
        catch (IOException e) 
        {
            // There was a problem reading the selected image.
        }
        
        return null;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
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
