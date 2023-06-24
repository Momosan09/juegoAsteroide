package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstaculo {

	public Sprite sprite;
	public Vector2 position;
	public Rectangle colision;
	public float puntosNecesarios;
	
	public Obstaculo(Texture img){
		sprite = new Sprite(img);
		position = new Vector2();
		colision = new Rectangle();
		position.x = MathUtils.random(0, Gdx.graphics.getWidth()*2);
		position.y = MathUtils.random(0, Gdx.graphics.getHeight()*2);
		colision.setSize(sprite.getWidth(), sprite.getHeight());
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch batch) {
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
		update();
	}
	
	public Rectangle getColision() {
		return colision;
	}
}
