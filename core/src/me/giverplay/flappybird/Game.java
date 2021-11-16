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

  private float birdIndex;

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

    birdIndex = 0;
  }

  @Override
  public void render() {
    batch.begin();
    batch.draw(background, 0.0f, 0.0f, width, height);

    birdIndex += Gdx.graphics.getDeltaTime() * 10;

    if(birdIndex > BIRDS) {
      birdIndex = 0;
    }

    batch.draw(birds[(int) birdIndex], 100f, height / 2);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
