package com.purestudios.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.purestudios.game.FlappyDemo;
import com.purestudios.game.sprites.Bird;

public class PlayState extends State {
  
  private Bird bird;
  private Texture background;
  
  public PlayState(GameStateManager gsm) {
    super(gsm);
    bird = new Bird(50, 300);
    cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    background = new Texture("bg.png");
  }
  
  @Override
  public void handleInput() {
    if (Gdx.input.justTouched()) {
      bird.jump();
    }
  }
  
  @Override
  public void update(float dt) {
    handleInput();
    
    bird.update(dt);
  }
  
  @Override
  public void render(SpriteBatch sb) {
    sb.setProjectionMatrix(cam.combined);
    
    sb.begin();
    sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
    sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
    sb.end();
  }
  
  @Override
  public void dispose() {
    
  }
  
}
