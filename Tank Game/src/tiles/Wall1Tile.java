/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import Graphics.Assets;

/**
 *
 * @author pl3nny
 */
public class Wall1Tile extends Tile
{
    public Wall1Tile(int id)
    {
        super(Assets.wall1, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
