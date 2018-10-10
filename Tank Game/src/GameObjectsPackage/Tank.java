package GameObjectsPackage;

import java.awt.Graphics;
import Graphics.Assets;
import Game.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import tiles.Tile;
import Graphics.*;

public class Tank extends GameObject {
    public static final int DEFAULT_HEALTH = 10;
    //3 as float
    public static final float DEFAULT_SPEED = 6.0f;
    
    public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
    protected float speed;
    protected int health;
    protected float xMove, yMove;
    
    private BufferedImage tank1, tank2;
    
    protected GameCamera camera1, camera2;
    
    //constructor calls GameObject constructor
    public Tank(Handler handler, float x_pos, float y_pos, int width, int height, int up, int down, int left, int right, GameCamera camera) {
        super(handler, x_pos, y_pos, DEFAULT_WIDTH, DEFAULT_HEIGHT, up, down, left, right, camera);
        this.handler = handler;        

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = DEFAULT_WIDTH;
        bounds.height = DEFAULT_HEIGHT;
        
        //place holder for health
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        
        this.camera = camera;
    }
    
    @Override
    public void tick2() {
        getInput2();
        move();
        
        handler.getGameCamera().centerOnPlayer(this);
    }
    @Override
    public void tick1() {
        getInput1();
        move();
        
        handler.getGameCamera().centerOnPlayer(this);
    }
    
    private void getInput2() {
        xMove = 0;
        yMove = 0;
        
        tank2 = Assets.tank2;
        
        //tank2
        if(handler.getKeyControls2().upArrow) {
            yMove = -speed;
            tank2 = Assets.tank2Up;
        }
        if(handler.getKeyControls2().downArrow) {
            yMove = speed;
            tank2 = Assets.tank2Down;
        }
        if(handler.getKeyControls2().leftArrow) {
            xMove = -speed;
            tank2 = Assets.tank2Left;
        }
        if(handler.getKeyControls2().rightArrow) {
            xMove = +speed;
            tank2 = Assets.tank2Right;
        } 
        
        // angle movement img for tank2
        if(handler.getKeyControls2().upArrow && handler.getKeyControls2().rightArrow)
        {
            tank2 = Assets.tank2UpRight;
        }
        
        if(handler.getKeyControls2().upArrow && handler.getKeyControls2().leftArrow)
        {
            tank2 = Assets.tank2UpLeft;
        }
        
        if(handler.getKeyControls2().downArrow && handler.getKeyControls2().rightArrow)
        {
            tank2 = Assets.tank2DownRight;
        }
        
        if(handler.getKeyControls2().downArrow && handler.getKeyControls2().leftArrow)
        {
            tank2 = Assets.tank2DownLeft;
        }
    }
    private void getInput1() {
        xMove = 0;
        yMove = 0;
        
        tank1 = Assets.tank1;
        
        //tank1
        if(handler.getKeyControls1().upW) {
            yMove = -speed;
            tank1 = Assets.tank1Up;
        }
        if(handler.getKeyControls1().downS) {
            yMove = +speed;
            tank1 = Assets.tank1Down;
        }
        if(handler.getKeyControls1().leftA) {
            xMove = -speed;
            tank1 = Assets.tank1Left;
        }
        if(handler.getKeyControls1().rightD) {
            xMove = +speed;
            tank1 = Assets.tank1Right;
        } 
        
        // angle movement img for tank2
        if(handler.getKeyControls1().upW && handler.getKeyControls1().rightD)
        {
            tank1 = Assets.tank1UpRight;
        }
        
        if(handler.getKeyControls1().upW && handler.getKeyControls1().leftA)
        {
            tank1 = Assets.tank1UpLeft;
        }
        
        if(handler.getKeyControls1().downS && handler.getKeyControls1().rightD)
        {
            tank1 = Assets.tank1DownRight;
        }
        
        if(handler.getKeyControls1().downS && handler.getKeyControls1().leftA)
        {
            tank1 = Assets.tank1DownLeft;
        }
    }
    
    @Override 
    public void render(Graphics g) {
        g.drawImage(tank1, (int)(x_pos - handler.getGameCamera().getXOffset()), (int)(y_pos - handler.getGameCamera().getYOffset()), width, height, null);
        g.drawImage(tank2, (int)(x_pos - handler.getGameCamera().getXOffset()), (int)(y_pos - handler.getGameCamera().getYOffset()), width, height, null);
    }
    
    public void move() {
        moveX();
        moveY();
    }
    
    public void moveX() {
        //moving right
        if(xMove > 0) {
            int tmpX = (int)(x_pos + xMove + bounds.width) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tmpX,(int)(y_pos) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tmpX, (int)(y_pos + bounds.height) / Tile.TILE_HEIGHT)) {
                x_pos += xMove;
            }
            else {
                x_pos = tmpX * Tile.TILE_WIDTH - bounds.width - 1;
            }
        }
        
        //moving left
        else if(xMove < 0) {
            int tmpX = (int)(x_pos + xMove) / Tile.TILE_WIDTH;
            
            if(!collisionWithTile(tmpX,(int)(y_pos) / Tile.TILE_HEIGHT) && 
                    !collisionWithTile(tmpX, (int)(y_pos + bounds.height) / Tile.TILE_HEIGHT)) {
                x_pos += xMove;
            }
            else {
                x_pos = tmpX * Tile.TILE_WIDTH + Tile.TILE_WIDTH;
            }
        }
    }
    
    public void moveY() {
        //moving up
        if(yMove < 0) {
            int tmpY = (int)(y_pos + yMove) / Tile.TILE_HEIGHT;
            
            if(!collisionWithTile((int)(x_pos) / Tile.TILE_WIDTH, tmpY) && 
                    !collisionWithTile((int)(x_pos + bounds.width) / Tile.TILE_WIDTH, tmpY)) {
                y_pos += yMove;
            }
            else {
                y_pos = tmpY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT; 
            }
        }
        
        //moving down
        else if(yMove > 0) {
            int tmpY = (int)(y_pos + yMove + bounds.height) / Tile.TILE_HEIGHT;
            
            if(!collisionWithTile((int)(x_pos) / Tile.TILE_WIDTH, tmpY) && 
                    !collisionWithTile((int)(x_pos + bounds.width) / Tile.TILE_WIDTH, tmpY)) {
                y_pos += yMove;
            }
            else {
                y_pos = tmpY * Tile.TILE_HEIGHT - bounds.height - 1;
            }
        }
    }
    
    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
    
    //getters and setters
    public int getHealth() {
        return this.health;
    }
    
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    public float getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(float newSpeed) {
        this.speed = newSpeed;
    }
    
    public float getXMove() {
        return xMove;
    }
    
    public void setXMove(float newXMove) {
        this.xMove = newXMove;
    }
    
    public float getYMove() {
        return this.yMove;
    }
    
    public void setYMove(float newYMove) {
        this.yMove = newYMove;
    }
}
