package com.submarine.game.Entities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends ApplicationAdapter{
    SpriteBatch batch;
    Texture img;
    Sprite spr;
    int x, y;
    private static int[] controlsSet1 = {Input.Keys.LEFT,Input.Keys.RIGHT,Input.Keys.UP,Input.Keys.DOWN};
    private static int[] controlsSet2 = {Input.Keys.A,Input.Keys.D,Input.Keys.W,Input.Keys.S};
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
        spr.setPosition(x,y);
        spr.draw(batch);
        batch.end();
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
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
