package com.purestudios.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.purestudios.game.FlappyDemo;
import com.purestudios.game.sprites.Bird;

public class PlayState extends State {
  
  private Bird bird;
  
  public PlayState(GameStateManager gsm) {
    super(gsm);
    bird = new Bird(50, 300);
    cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
  }
  
  @Override
  public void handleInput() {
    // TODO Auto-generated method stub
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
    sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
    sb.end();
  }
  
  @Override
  public void dispose() {
    
  }
  
}
