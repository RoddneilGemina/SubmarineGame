package com.submarine.game.Entities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship extends ApplicationAdapter {
    SpriteBatch batch;
    public int x=0, y=0;
    Texture texture;
    Sprite spr;
    @Override public void create(){
        batch = new SpriteBatch();
        texture = new Texture("shipdaw.png");
        spr = new Sprite(texture);
        spr.scale(0.5f);
        spr.setOrigin(spr.getWidth()/2,spr.getHeight()/2);
        spr.setScale(0.25f,0.25f);
    }
    @Override public void render(){
        batch.begin();
        spr.setPosition(x,y);
        spr.draw(batch);
        batch.end();
    }
    @Override public void dispose(){
        batch.dispose();
        texture.dispose();
    }
}
