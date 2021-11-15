package me.giverplay.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

  private SpriteBatch batch;
  private Texture passaro;

  @Override
  public void create() {
    batch = new SpriteBatch();
    passaro = new Texture("passaro1.png");
  }

  @Override
  public void render() {
    batch.begin();
    batch.draw(passaro, 100f, 100f);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
