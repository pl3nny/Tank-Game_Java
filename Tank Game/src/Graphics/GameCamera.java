package Graphics;

import Game.Game;
import Game.Handler;
import GameObjectsPackage.GameObject;
import tiles.Tile;

public class GameCamera {
    
    private Handler handler;
    //offsets to show different tiles in the bigger map not on screen
    private float xOffset, yOffset;
    
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void checkBlankSpace()
    {
        if(xOffset < 0)
        {
            xOffset = 0;
        }
        else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth())
        {
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }
        
        if(yOffset < 0)
        {
            yOffset = 0;
        }
        else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight())
        {
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }
    
    public void centerOnPlayer(GameObject e) {
        xOffset = e.getXPos() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getYPos() - handler.getHeight() / 2 + e.getHeight() / 2;
        
        checkBlankSpace();
    }
    
    public void move(float xAmount, float yAmount) {
        xOffset += xAmount;
        yOffset += yAmount;
        
        checkBlankSpace();
    }
    
    //getters and setters
    public float getXOffset() {
        return xOffset;
    }
    
    public void setXOffset(float xOffset) {
        this.xOffset = xOffset;
    }
    
    public float getYOffset() {
        return yOffset;
    }
    
    public void setYOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}