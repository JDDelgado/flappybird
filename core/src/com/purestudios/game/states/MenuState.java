package com.purestudios.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.purestudios.game.FlappyDemo;

public class MenuState extends State {
  
  private Texture background;
  private Texture playButton;
  
  public MenuState(GameStateManager gsm) {
    super(gsm);
    
    background = new Texture("bg.png");
    playButton = new Texture("playbtn.png");
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
    int playBtnWidth = (FlappyDemo.WIDTH / 2) - (playButton.getWidth() / 2);
    int playBtnHeight = (FlappyDemo.HEIGHT / 2) - (playButton.getHeight() / 2);
    
    sb.begin();
    sb.draw(background, 0,0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
    sb.draw(playButton, playBtnWidth, playBtnHeight);
    sb.end();
  }
}
