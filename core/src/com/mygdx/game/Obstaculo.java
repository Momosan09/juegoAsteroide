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
	private Texture imgRoto;
	private Vector2 position;
	private Rectangle colision;
	private final float PUNTOS_NECESARIOS;
	public boolean obstaculoMuerto = false;

	
	public Obstaculo(Texture img, Texture imgRoto, float x, float y, float puntosNecesarios){
		sprite = new Sprite(img);
		this.imgRoto = imgRoto;
		position = new Vector2();
		colision = new Rectangle();
		puntos = new BitmapFont();
		position.x = x;
		position.y = y;
		PUNTOS_NECESARIOS = puntosNecesarios;
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
			sprite.setTexture(imgRoto);
			sprite.draw(batch);
		}
	}
	
	public Rectangle getColision() {
		return colision;
	}
	public float getPuntosNecesarios() {
		return PUNTOS_NECESARIOS;
	}
	
	//ver como hacer para que no se superpongan
	public void checkOverlapInicial(Rectangle colision) {
		if(this.colision.overlaps(colision))position.x = MathUtils.random(0, Gdx.graphics.getWidth());
	}
	
}
