package GameObjectsPackage; 

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyControls implements KeyListener {
    //used to see if a key has been pressed by using true or false
    private boolean[] keys;
    
    //arrows control one tank, WASD control second tank
    public boolean upArrow, downArrow, leftArrow, rightArrow; 
    public boolean upW, downS, leftA, rightD;
    
    public KeyControls() {
        //array holds all keys on keyboard
        keys = new boolean[256];
    }
    
    public void tick1() {
        //set the booleans to each key wanted
        
        //using WSAD
        upW = keys[KeyEvent.VK_W];
        downS = keys[KeyEvent.VK_S];
        leftA = keys[KeyEvent.VK_A];
        rightD = keys[KeyEvent.VK_D]; 
    }
    
    public void tick2() {
        //set the booleans to each key wanted
        
        //using arrow keys
        upArrow = keys[KeyEvent.VK_UP];
        downArrow = keys[KeyEvent.VK_DOWN];
        leftArrow = keys[KeyEvent.VK_LEFT];
        rightArrow = keys[KeyEvent.VK_RIGHT];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //set array to true if key that was passed in was pressed
        keys[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //set array to false if key that was passed in was released
        keys[e.getKeyCode()] = false; 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}