package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrimeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	
	Interfaz interfaz;
	
	OrthographicCamera camara;
	
	Texture FondoImg;
	Sprite fondo;
	
	Jugador jugador;
	Texture jugadorImg;
	Texture jugadorImgRoto;
	
	
	Texture obstaculoImg;
	Texture obstaculoImgRoto;
	
	Texture planetaImg;
	Texture planetaImgRoto;
	
	Array<Obstaculo> obstaculos;
	
	BitmapFont font;
	
	private int cantidadObstaculos = 30;
	
	
	
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
		jugadorImgRoto = new Texture("jugadorImagenRoto.png");
		jugador = new Jugador(jugadorImg, jugadorImgRoto, camara);
		
		//Obstaculo
		obstaculoImg = new Texture("obstaculo1.png");
		obstaculoImgRoto = new Texture("obstaculo1Roto.png");
		planetaImg = new Texture("planeta1.png");
		planetaImgRoto = new Texture("planeta1Roto.png");
		
		obstaculos = new Array<>();
		
		
		for(int i=0;i<cantidadObstaculos;i++) {

			Obstaculo obstaculo = new Planeta(planetaImg,planetaImgRoto);
			Obstaculo obstaculo1 = new Planeta(obstaculoImg,obstaculoImgRoto);
			obstaculos.add(obstaculo);
			obstaculos.add(obstaculo1);
			
		}
			
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		seguimientoDeLaCamara();
		fondo.draw(batch);
		interfaz.draw(batch);
		//fondo.setPosition(jugador.position.x-(Gdx.graphics.getDeltaTime()*2), 0); hacer un efecto piola en el fondo, como que se mueve lento o algun paralaje
		
	    for (Obstaculo o : obstaculos) {
	    	o.update();
	        o.draw(batch);
			jugador.checkearColision(o);
	    }
		
		jugador.draw(batch);//no termino de entenderr lo del Batch 
		

		
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
		camara.zoom = 1.0f;
		camara.update();
	}
}
