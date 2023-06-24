package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GenerarObstaculo {

    private Texture obstaculoImg;
    private Texture obstaculoImgRoto;
    
    public GenerarObstaculo(Texture obstaculoImg, Texture obstaculoImgRoto) {
        this.obstaculoImg = obstaculoImg;
        this.obstaculoImgRoto = obstaculoImgRoto;
    }
	
	public Obstaculo generarObstaculo() {
        float x = MathUtils.random(0, Gdx.graphics.getWidth() * 3);
        float y = MathUtils.random(0, Gdx.graphics.getHeight() * 3);
        float puntosNecesarios = MathUtils.random(0, 10);
        
        
        // Crear un nuevo obstáculo con las propiedades aleatorias
        return new Obstaculo(obstaculoImg, obstaculoImgRoto, x, y, puntosNecesarios);
    }
	

}
