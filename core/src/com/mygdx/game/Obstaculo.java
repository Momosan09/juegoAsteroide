package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstaculo {

	BitmapFont puntos;
	
	private Sprite sprite;
	private Vector2 position;
	private Rectangle colision;
	private final float PUNTOS_NECESARIOS = MathUtils.random(0,1000);
	private boolean obstaculoMuerto = false;

	
	public Obstaculo(Texture img){
		sprite = new Sprite(img);
		position = new Vector2();
		colision = new Rectangle();
		puntos = new BitmapFont();
		position.x = MathUtils.random(0, Gdx.graphics.getWidth()*2);
		position.y = MathUtils.random(0, Gdx.graphics.getHeight()*2);
		colision.setSize(sprite.getWidth(), sprite.getHeight());
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch batch) {
		if(!obstaculoMuerto) {			
		sprite.setPosition(position.x, position.y);
		colision.setPosition(position.x, position.y);
		sprite.draw(batch);
		puntos.draw(batch, "" + PUNTOS_NECESARIOS, position.x + 15, position.y - 5);
		update();
		}else {
			Texture img = new Texture("obstaculo1Roto.png");
			sprite.setTexture(img);
			sprite.draw(batch);
		}
	}
	
	public Rectangle getColision() {
		return colision;
	}
	public float getPuntosNecesarios() {
		return PUNTOS_NECESARIOS;
	}
	
	public void setObstaculoMuerto() {
		obstaculoMuerto = true;
		
	}
}
