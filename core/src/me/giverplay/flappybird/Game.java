package me.giverplay.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

  private static final int BIRDS = 3;

  private SpriteBatch batch;
  private Texture background;
  private Texture[] birds;

  private float birdY;
  private float birdSpriteIndex;
  private float gravity;

  private float width;
  private float height;

  @Override
  public void create() {
    width = Gdx.graphics.getWidth();
    height = Gdx.graphics.getHeight();

    batch = new SpriteBatch();
    background = new Texture("fundo.png");

    birds = new Texture[BIRDS];

    for (int index = 0; index < BIRDS; index++) {
      birds[index] = new Texture("passaro" + (index + 1) + ".png");
    }

    birdSpriteIndex = 0;
    gravity = 0;
    birdY = height / 2;
  }

  @Override
  public void render() {
    batch.begin();
    batch.draw(background, 0.0f, 0.0f, width, height);

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

    birdSpriteIndex += Gdx.graphics.getDeltaTime() * 10;

    if(birdSpriteIndex > BIRDS) {
      birdSpriteIndex = 0;
    }

    batch.draw(birds[(int) birdSpriteIndex], 100f, birdY);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
