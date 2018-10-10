/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author pl3nny
 */
public class Tile
{
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    
    public static Tile[] tiles = new Tile[256];
    
    public static Tile bimg = new BackgroundTile(0);
    public static Tile wall1 = new Wall1Tile(1);
    public static Tile wall2 = new Wall2Tile(2);
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
        
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    
    public boolean isSolid()
    {
        return false;
    }
    
    public int getId()
    {
        return id;
    }
}
