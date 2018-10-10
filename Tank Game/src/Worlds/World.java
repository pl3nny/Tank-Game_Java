/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worlds;

import Game.Handler;
import Util.Utils;
import java.awt.Graphics;
import tiles.Tile;

/**
 *
 * @author pl3nny
 */
public class World
{
    private Handler handler;
    private int width, height;
    
    
    private int[][] tiles;
    
    private int spawnX, spawnY;
    
    public World(Handler handler, String path)
    {
        this.handler = handler;
        loadWorld(path);
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g)
    {
        int xStart = (int)Math.max(0,handler.getGameCamera().getXOffset() / Tile.TILE_WIDTH);
        int xEnd = (int)Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart1 = (int)Math.max(0,handler.getGameCamera().getYOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int)Math.min(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);;
        
        for(int y = yStart1; y < yEnd; y++)
        {
            for(int x = xStart; x < xEnd; x++)
            {
                getTile(x,y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getXOffset()),
                        (int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getYOffset()));
            }
        }
    }
    
    public Tile getTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.bimg;
        }
        
        Tile t = Tile.tiles[tiles[x][y]];
        
        if(t == null)
        {
            return Tile.bimg;
        }
        
        return t;
    }
    
    private void loadWorld(String path)
    {
       String file = Utils.loadFileAsString(path);
       String[] tokens = file.split("\\s+");
       width = Utils.parseInt(tokens[0]);
       height = Utils.parseInt(tokens[1]);
       
       spawnX = Utils.parseInt(tokens[2]);
       spawnY = Utils.parseInt(tokens[3]);
       
       tiles = new int[width][height];
       
       for(int y = 0; y < height; y++)
       {
           for(int x = 0; x < width; x++)
           {
               tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+ 4]);
           }
       }
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}
