package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PrimeroMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture FondoImg;
	Sprite fondo;
	
	Jugador jugador;
	Texture jugadorImg;
	
	Obstaculo obstaculo;
	Texture obstaculoImg;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		FondoImg = new Texture("fondo.png");
		fondo = new Sprite(FondoImg);
		
		jugadorImg = new Texture("jugadorImagen.png");
		jugador = new Jugador(jugadorImg);
		
		obstaculoImg = new Texture("obstaculo1.png");
		obstaculo = new Obstaculo(obstaculoImg);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();
		batch.setProjectionMatrix(jugador.camara.combined);//Al renderizar los elementos del juego, asegúrate de utilizar la matriz de proyección de la cámara para que los objetos se muestren correctamente en relación con la vista de la cámara. chat gpt me dijo eso lol
		fondo.draw(batch);
		//fondo.setPosition(jugador.position.x-(Gdx.graphics.getDeltaTime()*2), 0); hacer un efecto piola en el fondo, como que se mueve lento o algun paralaje
		obstaculo.draw(batch);
		jugador.draw(batch);//no termino de entendeer lo del Batch 
		
		jugador.checkearColision(obstaculo.getColision());
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		jugadorImg.dispose();
		obstaculoImg.dispose();

		}
}
