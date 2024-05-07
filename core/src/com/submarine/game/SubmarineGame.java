package com.submarine.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.submarine.game.Entities.Player;
import com.submarine.game.Entities.Ship;
import com.submarine.game.Modules.Steer;

public class SubmarineGame extends ApplicationAdapter {
	Player p1, p2;
	Ship ship;
	
	@Override
	public void create () {
		p1 = new Player(0);
		p2 = new Player(1);
		ship = new Ship();
		Global.ship = new Ship();
		Global.players[0] = p1;
		Global.players[1] = p2;
		Global.steer = new Steer();
		ship.create();
		p1.create();
		p2.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.05f, 0.05f, 0.125f, 1);
		ship.render();
		p1.render();
		p2.render();
	}
	
	@Override
	public void dispose () {
		p1.dispose();
		p2.dispose();
	}
}
