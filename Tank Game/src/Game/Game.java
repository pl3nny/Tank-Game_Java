package Game;


import Graphics.ImageLoader;
import Display.Display;
import GameObjectsPackage.KeyControls;
import Graphics.Assets;
import Graphics.GameCamera;
import States.GameState;
import States.MenuState;
import States.State;
import java.awt.Frame;
import java.awt.Graphics;
import static java.awt.SystemColor.window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pl3nny
 */
public class Game implements Runnable
{
    private Display display;
    
    private Thread thread;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //states
    private State gameState;
    private State menuState;
    
    //controls
    private KeyControls keyCont1;
    private KeyControls keyCont2;
    
    //handler
    private Handler handler;
    
    //camera
    private GameCamera gameCamera;
    
    private int width, height;
    public String title;
    
    
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        
        keyCont1 = new KeyControls();
        keyCont2 = new KeyControls();
        
        
        
    }
    
    public void run()
    {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer  = 0;
        int ticks = 0;
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            
            if(delta >= 1)
            {
                tick();
                render();
                delta--;
            }
            
            if(timer >= 1000000000)
            {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
            
        }
        
        stop();
    }
    
    public void init()
    {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyCont1);
        display.getFrame().addKeyListener(keyCont2);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        
        gameState = new GameState(handler);
        menuState =  new MenuState(handler);
        State.setState(gameState);
        
    }
    
    private void tick()
    {
        keyCont1.tick1();
        keyCont2.tick2();
        
        
        if(State.getState() != null)
        {
            State.getState().tick();
        }
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        //clear screen
        g.clearRect(0, 0, width, height);
        
        //draw
        if(State.getState() != null)
        {
            State.getState().render(g);
        }

        //end draw
        bs.show();
        g.dispose();
    }
    
    public KeyControls getKeyControls1()
    {
        return keyCont1;
    }
    public KeyControls getKeyControls2() {
        return keyCont2;
    }
    
    public GameCamera getGameCamera() {
        return gameCamera;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    public synchronized void start()
    {
        if(running)
        {
            return;
        }
        
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    public synchronized void stop()
    {
        if(!running)
            return;
        
        running = false;
        
        try
        {
            thread.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
