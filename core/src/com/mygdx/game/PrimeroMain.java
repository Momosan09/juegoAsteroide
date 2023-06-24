package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrimeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	
	Jugador jugador;
	Texture jugadorImg;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		jugadorImg = new Texture("jugadorImagen.png");
		jugador = new Jugador(jugadorImg);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.setProjectionMatrix(jugador.camara.combined);//Al renderizar los elementos del juego, asegúrate de utilizar la matriz de proyección de la cámara para que los objetos se muestren correctamente en relación con la vista de la cámara. chat gpt me dijo eso lol
		jugador.draw(batch);//no termino de entendeer lo del Batch 
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		jugadorImg.dispose();
	}
}
