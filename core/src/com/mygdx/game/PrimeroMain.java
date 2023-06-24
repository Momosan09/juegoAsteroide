package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrimeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	
	Interfaz interfaz;
	
	OrthographicCamera camara;
	
	Texture FondoImg;
	Sprite fondo;
	
	Jugador jugador;
	Texture jugadorImg;
	
	Obstaculo obstaculo;
	Texture obstaculoImg;
	
	BitmapFont font;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();	
		//Fondo
		FondoImg = new Texture("fondo.png");
		fondo = new Sprite(FondoImg);
		
		//Camara
		crearCamara();	//Sera mejor crearlo asi en metodos distintos o este metodo "crearCamara" no es necesario
		
		//Interfaz
		interfaz = new Interfaz(camara);
		
		//Jugador
		jugadorImg = new Texture("jugadorImagen.png");
		jugador = new Jugador(jugadorImg, camara);
		
		//Obstaculo
		obstaculoImg = new Texture("obstaculo1.png");
		obstaculo = new Obstaculo(obstaculoImg);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		seguimientoDeLaCamara();
		fondo.draw(batch);
		interfaz.draw(batch);
		//fondo.setPosition(jugador.position.x-(Gdx.graphics.getDeltaTime()*2), 0); hacer un efecto piola en el fondo, como que se mueve lento o algun paralaje
		obstaculo.draw(batch);
		jugador.draw(batch);//no termino de entenderr lo del Batch 
		
		jugador.checkearColision(obstaculo);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		jugadorImg.dispose();
		obstaculoImg.dispose();

		}
	
	public void crearCamara() {
		camara = new OrthographicCamera();
		camara.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void seguimientoDeLaCamara() {
		batch.setProjectionMatrix(camara.combined);//Al renderizar los elementos del juego, asegúrate de utilizar la matriz de proyección de la cámara para que los objetos se muestren correctamente en relación con la vista de la cámara. chat gpt me dijo eso lol
		camara.position.set(jugador.getPositionX(), jugador.getPositionY(),0);
		camara.update();
	}
}
