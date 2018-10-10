package Game;
import GameObjectsPackage.KeyControls;
import Graphics.GameCamera;
import Worlds.*;

public class Handler {
    private Game game;
    private World world;
    
    public Handler(Game game) {
        this.game = game;
    }
 
    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }
   
    public KeyControls getKeyControls1() {
        return game.getKeyControls1();
    }
    
    public KeyControls getKeyControls2() {
        return game.getKeyControls2();
    }
    
    public int getWidth() {
        return game.getWidth();
    }
    
    public int getHeight() {
        return game.getHeight();
    }
    
    //getters and setters
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public World getWorld() {
        return world;
    }
    
    public void setWorld(World newWorld) {
        this.world = newWorld;
    }
}