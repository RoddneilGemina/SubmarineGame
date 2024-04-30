package com.submarine.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.submarine.game.Entities.Player;

public class SubmarineGame extends ApplicationAdapter {
	Player p1, p2;
	
	@Override
	public void create () {
		p1 = new Player(0);
		p2 = new Player(1);
		p1.create();
		p2.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		p1.render();
		p2.render();
	}
	
	@Override
	public void dispose () {
		p1.dispose();
		p2.dispose();
	}
}
