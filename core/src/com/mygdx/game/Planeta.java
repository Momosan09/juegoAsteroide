package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Planeta extends Obstaculo{

	public Planeta(Texture img, Texture imgRoto){
		super(img, imgRoto);

        super.position.x = MathUtils.random(0, Gdx.graphics.getWidth() * 3);
        super.position.y = MathUtils.random(0, Gdx.graphics.getHeight() * 3);
        super.puntosNecesarios = MathUtils.random(0, 10);
	}
}

