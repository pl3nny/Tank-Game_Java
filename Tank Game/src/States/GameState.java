/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Game.Game;
import Game.Handler;
import GameObjectsPackage.Tank;
import Graphics.Assets;
import Worlds.World;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import tiles.Tile;
import Graphics.*;

/**
 *
 * @author pl3nny
 */
public class GameState extends State
{
    private Tank tank1;
    private World world;
    
    //testing second tank
    private Tank tank2;
    
    private GameCamera camera1, camera2;
    
    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, System.getProperty("user.dir") + "/src/Resources/worlds/world1.txt");
        handler.setWorld(world);
        
        //tank1 uses WASD
        tank1 = new Tank(handler, Tile.TILE_WIDTH + 10, Tile.TILE_HEIGHT + 10, 64, 64, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, camera1);
        
        //testing adding a second tank
        //tank2 uses arrow keys
        tank2 = new Tank(handler, Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT + 10, 64, 64,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, camera2);
    }
    
    @Override
    public void tick()
    {
        world.tick();
        tank1.tick1();
        
        //testing second tank
        tank2.tick2();
    }
    
    @Override
    public void render(Graphics g)
    {
        world.render(g);
        tank1.render(g);
        
        //testing second tank
        tank2.render(g);

        // just testing atm
        
        // they works
//        g.drawImage(Assets.bimg, 0, 0, null);
//        g.drawImage(Assets.tank1, 20, 20, null);
//        g.drawImage(Assets.tank2, 60, 60, null);
//        g.drawImage(Assets.tank2, 60, 60, null);
//        g.drawImage(Assets.shield1, 60, 60, null);
//        g.drawImage(Assets.shield2, 60, 60, null);
//        g.drawImage(Assets.rocket, 60, 60, null);
//        g.drawImage(Assets.TITLE, 100, 100, null);
    }
}
