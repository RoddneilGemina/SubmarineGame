package com.submarine.game.Entities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.submarine.game.Global;

public class Player extends ApplicationAdapter{
    SpriteBatch batch;
    Texture img;
    Sprite spr;
    public int x, y;
    public boolean locked;
    private static int[] controlsSet1 = {Input.Keys.LEFT,Input.Keys.RIGHT,Input.Keys.UP,Input.Keys.DOWN,Input.Keys.NUMPAD_1};
    private static int[] controlsSet2 = {Input.Keys.A,Input.Keys.D,Input.Keys.W,Input.Keys.S,Input.Keys.H};
    private int[] controls;
    private boolean isLeft, prevLeft;
    public Player(int playerNo){
        super();
        int[][] controlSets = {controlsSet1,controlsSet2};
        controls = controlSets[playerNo];
    }
    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("amogus.png");
        spr = new Sprite(img);
        spr.scale(0.5f);
        spr.setOrigin(spr.getWidth()/2,spr.getHeight()/2);
        spr.setScale(0.25f,0.25f);

    }

    @Override
    public void render () {
        if(isLeft ^ prevLeft){
            isLeft = !isLeft;
            prevLeft = !prevLeft;
            spr.flip(true, false);
        }
        batch.begin();
        //spr.setPosition(x,y);
        spr.setPosition(x+ Global.ship.x,y+ Global.ship.y);
        spr.draw(batch);
        batch.end();
        if(!locked){
            movePlayer();
        } else {
            if(Gdx.input.isKeyPressed(controls[0])) Global.steer.moveL();
            if(Gdx.input.isKeyPressed(controls[1])) Global.steer.moveR();
            if(Gdx.input.isKeyPressed(controls[2])) Global.steer.moveU();
            if(Gdx.input.isKeyPressed(controls[3])) Global.steer.moveD();;
            if(Gdx.input.isKeyPressed(controls[4])) Global.steer.useA();
        }
    }
    private void movePlayer(){
        if(Gdx.input.isKeyPressed(controls[0])) {
            x -= 10;
            isLeft = true;
        }
        if(Gdx.input.isKeyPressed(controls[1])) {
            x += 10;
            isLeft = false;
        }
        if(Gdx.input.isKeyPressed(controls[2])) y+=10;
        if(Gdx.input.isKeyPressed(controls[3])) y-=10;
        if(Gdx.input.isKeyPressed(controls[4])) {
            Global.steer.interact(this);
            locked=true;
        }
    }
    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
