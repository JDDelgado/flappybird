package com.purestudios.game.sprites;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Tube {
  public static final int TUBE_WIDTH = 52;
  
  private static final int FLUCTUATION = 130;
  private static final int TUBE_GAP = 100;
  private static final int LOWEST_OPENNING_TUBE = 120;
  
  private Texture topTube, bottomTube;
  private Vector2 posTopTube, posBotTube;
  private Random rand;
  
  public Tube(float x) {
    topTube = new Texture("toptube.png");
    bottomTube = new Texture("bottomtube.png");
    rand = new Random();
    
    posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENNING_TUBE);
    posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
  }
  
  public Texture getTopTube() {
    return topTube;
  }
  
  public Texture getBottomTube() {
    return bottomTube;
  }
  
  public Vector2 getPosTopTube() {
    return posTopTube;
  }
  
  public Vector2 getPosBotTube() {
    return posBotTube;
  }
  
  public void reposition(float x) {
    posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENNING_TUBE);
    posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
  }
  
}
