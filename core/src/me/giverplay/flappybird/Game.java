package me.giverplay.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

  private SpriteBatch batch;
  private Texture bird;
  private Texture background;

  private float width;
  private float height;

  @Override
  public void create() {
    width = Gdx.graphics.getWidth();
    height = Gdx.graphics.getHeight();

    batch = new SpriteBatch();
    bird = new Texture("passaro1.png");
    background = new Texture("fundo.png");
  }

  @Override
  public void render() {
    batch.begin();
    batch.draw(background, 0.0f, 0.0f, width, height);
    batch.draw(bird, 100f, 100f);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
