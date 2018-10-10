//main class for all objects in game (tank, wall, bullet)
package GameObjectsPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import Game.*;
import Graphics.*;

public abstract class GameObject {
    
    protected Handler handler;
    //position (xpos, ypos) on screen
    protected float x_pos, y_pos;
    protected int width, height; 
    protected Rectangle bounds;
    protected int up, down, left, right;
    
    protected GameCamera camera;
    
    
    //constructor takes starting position and sets the variables
    public GameObject(Handler handler, float x_pos, float y_pos, int width, int height, int up, int down, int left, int right, GameCamera camera) {
        this.handler = handler;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.width = width;
        this.height = height; 
        
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        
        this.camera = camera;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    //where gameObjects update all their variables and move
    public abstract void tick1();
    public abstract void tick2();
    //where gameObject will draw itself to screen using Graphics g
    public abstract void render(Graphics g); 
    
    
    //getters and setters
    public float getXPos() {
        return x_pos;
    }
    
    public void setXPos(float newXPos) {
        this.x_pos = newXPos;
    }
    
    public float getYPos() {
        return y_pos;
    }
    
    public void setYPos(float newYPos) {
        this.y_pos = newYPos;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int newHeight) {
        this.height = newHeight; 
    }
}