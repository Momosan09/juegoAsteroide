package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Interfaz {
	
	private int ancho;
	private int alto;
	BitmapFont puntos;
	OrthographicCamera camara;
	
	public Interfaz(OrthographicCamera camara) {
			this.camara = new OrthographicCamera();
			this.camara = camara;
			ancho = Gdx.graphics.getWidth();
			alto = Gdx.graphics.getHeight();
			puntos = new BitmapFont();
		}
	
	public void draw(SpriteBatch batch) {
		//puntos.draw(batch, "Puntos", (camara.position.x - (Gdx.graphics.getWidth()/2) + 10), (camara.position.y + (Gdx.graphics.getHeight()/2 - 10)));
	}
	
}
