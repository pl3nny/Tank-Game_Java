package Game;


import Game.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pl3nny
 */
public class Launcher
{
    public static void main(String [] args)
    {
        Game game = new Game("Tank Game",1366, 768);
        game.start();
    }
}
