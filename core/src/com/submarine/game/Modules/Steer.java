package com.submarine.game.Modules;

import com.submarine.game.Global;

public class Steer extends Interactable{

    @Override
    public void moveL() {
        Global.ship.x -=10;
    }

    @Override
    public void moveR() {
        Global.ship.x +=10;
    }

    @Override
    public void moveU() {
        Global.ship.y +=10;
    }

    @Override
    public void moveD() {
        Global.ship.y -=10;
    }

    @Override
    public void useA() {
        user.locked = false;
        exit();
    }

    @Override
    public void useB() {

    }
}
