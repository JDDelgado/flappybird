package com.purestudios.game.states;

import com.badlogic.gdx.Gdx;
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
    if (Gdx.input.justTouched()) {
      gsm.set(new PlayState(gsm));
      dispose();
    }
  }

  @Override
  public void update(float dt) {
    handleInput();
  }

  @Override
  public void render(SpriteBatch sb) {
    int playBtnWidth = (FlappyDemo.WIDTH / 2) - (playButton.getWidth() / 2);
    
    sb.begin();
    sb.draw(background, 0,0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
    sb.draw(playButton, playBtnWidth, FlappyDemo.HEIGHT / 2);
    sb.end();
  }
  
  @Override
  public void dispose() {
    background.dispose();
    playButton.dispose();
  }
}
