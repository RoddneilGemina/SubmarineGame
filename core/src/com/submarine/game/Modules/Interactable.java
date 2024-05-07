package com.submarine.game.Modules;

import com.badlogic.gdx.ApplicationAdapter;
import com.submarine.game.Entities.Player;

public abstract class Interactable extends ApplicationAdapter {
    public Player user;
    public boolean interact(Player p){
        this.user = p;
        return true;
    }
    protected void exit(){
        user = null;
    }
    public abstract void moveL();
    public abstract void moveR();
    public abstract void moveU();
    public abstract void moveD();
    public abstract void useA();
    public abstract void useB();
}
