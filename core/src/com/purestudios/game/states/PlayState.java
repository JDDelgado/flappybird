package com.purestudios.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.purestudios.game.FlappyDemo;
import com.purestudios.game.sprites.Bird;
import com.purestudios.game.sprites.Tube;

public class PlayState extends State {
  
  private static final int TUBE_SPACING = 125;
  private static final int TUBE_COUNT = 4;
  private static final int GROUND_Y_OFFSET = -50;
  
  private Bird bird;
  private Texture background;
  private Texture ground;
  private Vector2 groundPosition1, groundPosition2;
  
  private Array<Tube> tubes;
  public PlayState(GameStateManager gsm) {
    super(gsm);
    bird = new Bird(50, 300);
    cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    background = new Texture("bg.png");
    ground = new Texture("ground.png");
    groundPosition1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
    groundPosition2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);
    tubes = new Array<Tube>();
    
    for (int i = 1; i <= TUBE_COUNT; i++) {
      tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
    }
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
    updateGround();
    
    bird.update(dt);
    cam.position.x = bird.getPosition().x + 80;
    
    for (int i = 0; i < tubes.size; i++) {
      Tube tube = tubes.get(i);
      
      if (cam.position.x - (cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
        tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
      }
      
      if (tube.collides(bird.getBounds())) {
        gsm.set(new PlayState(gsm));
      }
    }
    
    if (bird.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET) {
      gsm.set(new PlayState(gsm));
    }
    
    cam.update();
  }
  
  @Override
  public void render(SpriteBatch sb) {
    sb.setProjectionMatrix(cam.combined);
    
    sb.begin();
    sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
    sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
    
    for (Tube tube : tubes) {
      sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
      sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
    }
    
    sb.draw(ground,  groundPosition1.x, groundPosition1.y);
    sb.draw(ground,  groundPosition2.x, groundPosition2.y);
    
    sb.end();
  }
  
  @Override
  public void dispose() {
    background.dispose();
    bird.dispose();
    ground.dispose();
    
    for (Tube tube : tubes) {
      tube.dispose();
    }
    
    System.out.println("Play State Disposed");
  }
  
  private void updateGround() {
    if ((cam.position.x - (cam.viewportWidth / 2)) > (groundPosition1.x + ground.getWidth())) {
      groundPosition1.add(ground.getWidth() * 2, 0);
    }
    
    if ((cam.position.x - (cam.viewportWidth / 2)) > (groundPosition2.x + ground.getWidth())) {
      groundPosition2.add(ground.getWidth() * 2, 0);
    }
  }
}
