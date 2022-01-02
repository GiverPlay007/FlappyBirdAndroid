package me.giverplay.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

  private static final int BIRDS = 3;

  private SpriteBatch batch;
  private Texture[] birds;
  private Texture background;
  private Texture pipeTop;
  private Texture pipeDown;

  private float birdY;
  private float birdSpriteIndex;
  private float gravity;

  private int width;
  private int height;

  private int maxHeight;

  @Override
  public void create() {
    initializeGraphics();
    initializeTextures();
    initializeObjects();
  }

  @Override
  public void render() {
    update();
    draw();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }

  private void initializeGraphics() {
    width = Gdx.graphics.getWidth();
    height = Gdx.graphics.getHeight();

    batch = new SpriteBatch();
  }

  private void initializeTextures() {
    background = new Texture("fundo.png");
    pipeTop = new Texture("cano_topo_maior.png");
    pipeDown = new Texture("cano_baixo_maior.png");

    birds = new Texture[BIRDS];

    for (int index = 0; index < BIRDS; index++) {
      birds[index] = new Texture("passaro" + (index + 1) + ".png");
    }

    birdSpriteIndex = 0;
  }

  private void initializeObjects() {
    gravity = 0;
    birdY = height / 2f;
    maxHeight = height - birds[0].getHeight();
  }

  private void update() {
    if(Gdx.input.justTouched()) {
      gravity = -12;
    }

    gravity += 0.7;

    if(birdY >= 0) {
      birdY -= gravity;
    }

    if(birdY < 0){
      birdY = 0;
    }

    if(birdY > maxHeight) {
      birdY = maxHeight;
      gravity += 6;
    }

    birdSpriteIndex += Gdx.graphics.getDeltaTime() * 10;

    if(birdSpriteIndex > BIRDS) {
      birdSpriteIndex = 0;
    }
  }

  private void draw() {
    batch.begin();
    batch.draw(background, 0.0f, 0.0f, width, height);
    batch.draw(birds[(int) birdSpriteIndex], 100f, birdY);
    batch.end();
  }
}
