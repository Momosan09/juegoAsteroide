package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Jugador {

	private Vector3 position;
	private Sprite sprite;
	private Rectangle colision;
	public OrthographicCamera  camara;
	private float speed = 4.8f;
	private float rotation = 0;
	private float velocidadDeRotacion = 2.4f;
	private int puntosDeChoque = 1001;
	
	BitmapFont puntos;
	
	
	
	
	public Jugador(Texture img, OrthographicCamera camara) {
		sprite = new Sprite(img);
		position = new Vector3(Gdx.graphics.getWidth()/2 - (sprite.getWidth()/2), Gdx.graphics.getHeight()/2 - (sprite.getHeight()/2), rotation );	//posicion inicial
		colision = new Rectangle(position.x, position.y,sprite.getWidth(),sprite.getHeight());
		puntos = new BitmapFont();
		camara = new OrthographicCamera();
		this.camara = new OrthographicCamera();
		this.camara = camara;
		
	}
	
	public void draw(SpriteBatch batch) {//no entiendo muy bien lo del batch
		sprite.setPosition(position.x, position.y);//Va a dibujar el sprite en la posicion del jugador
		sprite.setRotation(position.z);
		sprite.draw(batch);
		mostrarPuntos(batch);
		update();
	}
	
	public void update() {
		colision.setPosition(position.x, position.y);
		
		moverse(Gdx.graphics.getDeltaTime());
		rotar(Gdx.graphics.getDeltaTime());
		movimientoCamara();
	}
	
	public void moverse(float deltaTime) {
		/*
		* Bueno esta parte no la termine de entender a la perfeccion 
		* Pero tiene sentido al usar el seno y el coseno DEL MISMO VALOR (position.z) en las posiciones del jugador esto hace que su posicion sea la deseada
		*/
		float jugadorRotacionX = MathUtils.cosDeg(position.z);
		float jugadorRotacionY = MathUtils.sinDeg(position.z);
		
		//if(Gdx.input.isKeyPressed(Keys.W)) {
			position.x += jugadorRotacionX*speed;
			position.y += jugadorRotacionY*speed;
		//}
	}
	
	public void movimientoCamara() {
		camara.position.set(position.x, position.y,0);
		camara.update();

	}
	
	public void rotar(float deltaTime) {
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) position.z += velocidadDeRotacion;
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) position.z -= velocidadDeRotacion;
		//sprite.rotate(position.z);
	}
	
	public void checkearColision(Obstaculo obstaculo) {

	    if (colision != null && colision.overlaps(obstaculo.getColision())) {
	    	evaluarChoque(Gdx.graphics.getDeltaTime(), obstaculo.getPuntosNecesarios());
	    	obstaculo.setObstaculoMuerto();
	        System.out.println("Auch!");
	    }
	}
	
	public void evaluarChoque(float deltaTime, float puntosDelObjeto) {
		if(puntosDeChoque > puntosDelObjeto) {
			System.out.println("Rompiste el objeto");
		}else {
			System.out.println("Moriste");
		}
	}
	
	public void mostrarPuntos(SpriteBatch batch) {
		puntos.draw(batch, "Puntos = " + puntosDeChoque, (camara.position.x - (Gdx.graphics.getWidth()/2) + 10), (camara.position.y + (Gdx.graphics.getHeight()/2 - 10)));
	}
	
	public float getPositionX() {
		return position.x;
	}
	public float getPositionY() {
		return position.y;
	}
	
	
	
	
}
