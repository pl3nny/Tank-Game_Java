/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author pl3nny
 */
public class Assets
{
    public static BufferedImage bimg, tank1, tank1Right, tank1Down, tank1Left, tank1Up,
            tank2, tank2Right, tank2Down, tank2Left, tank2Up, 
            tank2UpRight, tank2UpLeft, tank2DownLeft, tank2DownRight,
            tank1UpRight, tank1UpLeft, tank1DownLeft, tank1DownRight,
            wall1, wall2, bouncing, lg_Explosion,
            sm_Explosion, Pickup, rocket, shell, shield1, shield2, TITLE, weapon, icon;
    
    public static void init()
    {
        bimg = ImageLoader.loadImage("/resources/Background.bmp");
        tank1 = ImageLoader.loadImage("/resources/tank1.png");
        tank1Right = ImageLoader.loadImage("/resources/tank1Right.png");
        tank1Down = ImageLoader.loadImage("/resources/tank1Down.png");
        tank1Left = ImageLoader.loadImage("/resources/tank1Left.png");
        tank1Up = ImageLoader.loadImage("/resources/tank1Up.png");
        
        tank1UpRight = ImageLoader.loadImage("/resources/tank1UpRight.png");
        tank1UpLeft = ImageLoader.loadImage("/resources/tank1UpLeft.png");
        tank1DownRight = ImageLoader.loadImage("/resources/tank1DownRight.png");
        tank1DownLeft = ImageLoader.loadImage("/resources/tank1DownLeft.png");
        
        tank2 = ImageLoader.loadImage("/resources/tank2.png");
        tank2Right = ImageLoader.loadImage("/resources/tank2Right.png");
        tank2Down = ImageLoader.loadImage("/resources/tank2Down.png");
        tank2Left = ImageLoader.loadImage("/resources/tank2Left.png");
        tank2Up = ImageLoader.loadImage("/resources/tank2Up.png");
        
        tank2UpRight = ImageLoader.loadImage("/resources/tank1UpRight.png");
        tank2UpLeft = ImageLoader.loadImage("/resources/tank1UpLeft.png");
        tank2DownRight = ImageLoader.loadImage("/resources/tank1DownRight.png");
        tank2DownLeft = ImageLoader.loadImage("/resources/tank1DownLeft.png");
        
        wall1 = ImageLoader.loadImage("/resources/Wall1.gif");
        wall2 = ImageLoader.loadImage("/resources/Wall2.gif");
        
        bouncing = ImageLoader.loadImage("/resources/Bouncing.gif");
        lg_Explosion = ImageLoader.loadImage("/resources/Explosion_large.gif");
        sm_Explosion = ImageLoader.loadImage("/resources/Explosion_small.gif");
        Pickup = ImageLoader.loadImage("/resources/Pickup.gif");
        rocket = ImageLoader.loadImage("/resources/Rocket.gif");
        shell = ImageLoader.loadImage("/resources/shell.gif");
        shield1 = ImageLoader.loadImage("/resources/Shield1.gif");
        shield2 = ImageLoader.loadImage("/resources/Shield2.gif");
        TITLE = ImageLoader.loadImage("/resources/Title.bmp");
        weapon = ImageLoader.loadImage("/resources/Weapon.gif");
        icon = ImageLoader.loadImage("/resources/icon.ico");
        
        
    }
}
