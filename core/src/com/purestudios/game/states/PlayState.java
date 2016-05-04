package com.purestudios.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.purestudios.game.FlappyDemo;

public class PlayState extends State {
  
  private Texture bird;
  
  public PlayState(GameStateManager gsm) {
    super(gsm);
    bird = new Texture("bird.png");
    cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
  }
  
  @Override
  public void handleInput() {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void update(float dt) {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void render(SpriteBatch sb) {
    sb.setProjectionMatrix(cam.combined);
    
    sb.begin();
    sb.draw(bird, 50, 50);
    sb.end();
  }
  
  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    
  }
  
}
