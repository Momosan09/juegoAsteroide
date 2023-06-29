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
	
	protected Sprite sprite;
	protected Texture imgRoto;
	protected Vector2 position; // protected lo hace publico para la herencia
	private Rectangle colision;
	protected float puntosNecesarios;
	public boolean obstaculoMuerto = false;

	
	public Obstaculo(Texture img, Texture imgRoto){
		sprite = new Sprite(img);
		this.imgRoto = imgRoto;
		position = new Vector2();
		colision = new Rectangle();
		puntos = new BitmapFont();
		position.x = MathUtils.random(0, Gdx.graphics.getWidth() * 3);
		position.y = MathUtils.random(0, Gdx.graphics.getWidth() * 3);;
		puntosNecesarios = MathUtils.random(0, 10);;
		colision.setSize(sprite.getWidth(), sprite.getHeight());
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch batch) {
		if(!obstaculoMuerto) {			
		sprite.setPosition(position.x, position.y);
		colision.setPosition(position.x, position.y);
		sprite.draw(batch);
		puntos.draw(batch, "" + puntosNecesarios, position.x + 15, position.y - 5);
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
		return puntosNecesarios;
	}
	
	//ver como hacer para que no se superpongan
	public void checkOverlapInicial(Rectangle colision) {
		if(this.colision.overlaps(colision))position.x = MathUtils.random(0, Gdx.graphics.getWidth());
	}
	
}
