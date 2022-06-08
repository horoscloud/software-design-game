package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.factorys.AnimationFactory;
import at.compus02.swd.ss2022.game.factorys.PlayerFactory;
import at.compus02.swd.ss2022.game.factorys.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.world.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(1200.0f, 800.0f, 1200.0f, 800.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

	PlayerFactory player;

	float stateTime = 0f;


	@Override
	public void create() {

		batch = new SpriteBatch();



		///////////////////////////////////////////

		//Create World and add worldObjects to gameObjects


		World level = new World();
		level.create();

		for (GameObject gm:level.getWorldObjects()) {
			gameObjects.add(gm);
		}


		player = new PlayerFactory();


		//////////////////////////////////////////////

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);

		batch.begin();
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}


		gameInput.input(player.create().getSprite(), 3);
		player.create().draw(batch);



		stateTime += Gdx.graphics.getDeltaTime();

		font.draw(batch, "Tiles on screen: " + gameObjects.size, -viewport.getMaxWorldWidth()/3, -viewport.getMaxWorldHeight()/3);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}