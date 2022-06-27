package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.collision.Collision;
import at.compus02.swd.ss2022.game.enemies.Zombie;
import at.compus02.swd.ss2022.game.factorys.EnemyFactory;
import at.compus02.swd.ss2022.game.factorys.PlayerFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.PositionObserver;
import at.compus02.swd.ss2022.game.repositories.AssetRepository;
import at.compus02.swd.ss2022.game.world.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	//Input & Viewport
	private ExtendViewport viewport = new ExtendViewport(1200.0f, 800.0f, 1200.0f, 800.0f);
	private GameInput gameInput = new GameInput();

	//Gamelogic
	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

	//Gameobjects
	private Array<GameObject> gameObjects = new Array<>();

	private GameObject player;
	private GameObject zombie;
	private GameObject fireball;

	//Assetsrepo
	private AssetRepository assetRepository;

	//Observer
	PositionObserver positionObserver;


	//Statetime (delta)
	float stateTime = 0f;
	float stateTime2 = 0f;

	//Collision
	Collision playerCollision;

	@Override
	public void create() {

		batch = new SpriteBatch();


		assetRepository = new AssetRepository();
		assetRepository.preLoadAssets();

		positionObserver = new PositionObserver();

		//WORLD
		World level = new World();
		level.create();

		for (GameObject gm:level.getWorldObjects()) {
			gameObjects.add(gm);
		}


		//FACTORIES
		player = new PlayerFactory().create();
		zombie = new EnemyFactory().create("zombie");
		fireball = new EnemyFactory().create("fireball");

		playerCollision = new Collision();

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

		//PLAYER ENEMY COLLISION
		if(playerCollision.getCollisionDetection(player.getSprite(), fireball.getSprite())) {
			player.getSprite().setColor(Color.RED);
		}



		//INPUT
		gameInput.input(player.getSprite(), 3);


		//DRAW GAMEOBJECTS
		player.draw(batch);
		zombie.draw(batch);
		fireball.draw(batch);


		fireball.act(stateTime * 300);
		stateTime2 += Gdx.graphics.getDeltaTime();
		zombie.act(stateTime2 , player.getX(), player.getY());


		//OBSERVER
		//positionObserver.output(player.getX(), player.getY());
		//positionObserver.output(player.getX(), player.getY());


		//STATETIME
		stateTime += Gdx.graphics.getDeltaTime();

		//FONT DRAWS
		font.draw(batch, "Tiles on screen: " + gameObjects.size, -viewport.getMaxWorldWidth()/3, -viewport.getMaxWorldHeight()/3);
		font.draw(batch, "Player - Zombie Collision: " + playerCollision.getCollisionDetection(player.getSprite(), zombie.getSprite()), -viewport.getMaxWorldWidth()/4, -viewport.getMaxWorldHeight()/5);


		stateTime2 = 0f;
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