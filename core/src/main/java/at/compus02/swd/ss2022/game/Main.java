package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.collision.ObjectCollision;
import at.compus02.swd.ss2022.game.factorys.AnimationFactory;
import at.compus02.swd.ss2022.game.factorys.EnemyFactory;
import at.compus02.swd.ss2022.game.factorys.HeartFactory;
import at.compus02.swd.ss2022.game.factorys.PlayerFactory;
import at.compus02.swd.ss2022.game.objects.hud.PixelHeart;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.observer.EnemyPositionObserver;
import at.compus02.swd.ss2022.game.observer.Observer;
import at.compus02.swd.ss2022.game.observer.PlayerPositionObserver;
import at.compus02.swd.ss2022.game.world.TiledMapWorld;
import at.compus02.swd.ss2022.game.world.oldworldgeneration.World;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
	public SpriteBatch batch;

	//Input & Viewport
	private ExtendViewport viewport = new ExtendViewport(1216.0f, 832.0f, 1216.0f, 832.0f);
	private GameInput gameInput = new GameInput();

	//Gamelogic
	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	public BitmapFont font;

	//VARIABLES
	int collisionCounter = 0;
	int gameState = 0;

	//Gameobjects
	private Array<GameObject> gameObjects = new Array<>();

	private GameObject player;
	private GameObject zombie;
	private GameObject fireball;

	//HUD
	private HeartFactory heart;

	//Observer
	Observer observer;
	PlayerPositionObserver playerPositionObserver;
	EnemyPositionObserver enemyPositionObserver;

	//Statetime (delta)
	float stateTime = 0f;
	float stateTime2 = 0f;

	//ObjectCollision
	ObjectCollision playerObjectCollision;


	@Override
	public void create() {

		batch = new SpriteBatch();

		World world = new World();
		world.create();

		for (GameObject go: world.getWorldObjects()) {
			gameObjects.add(go);
		}


		//CREATE OBSERVER
		observer = new Observer();
		playerPositionObserver = new PlayerPositionObserver();
		enemyPositionObserver = new EnemyPositionObserver();
		observer.addObserver(playerPositionObserver);
		observer.addObserver(enemyPositionObserver);


		//FACTORIES
		player = new PlayerFactory().create();

		zombie = new EnemyFactory().create("zombie");
		gameObjects.add(zombie);

		fireball = new EnemyFactory().create("fireball");
		heart = new HeartFactory();
		heart.create(viewport);

		playerObjectCollision = new ObjectCollision();

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


		if(gameState == 0){

			//DRAW GAMEOBJECTS
			drawGameobjects();

			//COLLISION
			setCollisionDetection();

			//INPUT
			setGameInput(3);


			//LOGIC (Act)
			setObjectLogic();

			//FONT DRAWS
			setFonts();

			//OBSERVER
			//playerPositionObserver.update(player.getX(), player.getY());
			//enemyPositionObserver.update(zombie.getX(), zombie.getY());


			//STATETIME
			setStateTime();

		}else if(gameState==1){
			setGameOver();
		}


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


	private void checkGameOverCondition(){

		if(heart.getHealth().size()>0 && collisionCounter > 6){

			heart.getHealth().remove(0);
			collisionCounter = 0;
		}else if(heart.getHealth().size()==0){
			gameState=1;
			System.out.println("Game Over");
		}
		collisionCounter++;
	}

	private void setCollisionDetection(){
		//PLAYER ENEMY COLLISION

		if(playerObjectCollision.getCollisionDetection(player.getSprite(), fireball.getSprite())) {
			checkGameOverCondition();
		}

		if(playerObjectCollision.getCollisionDetection(player.getSprite(), zombie.getSprite())) {
			checkGameOverCondition();
		}

		if(playerObjectCollision.getHitCollisionDetection(player.getSprite(), zombie.getSprite())) {

			if(gameInput.isHit()){


				int zombieHealth = zombie.getHealth();

				if(zombieHealth > 0){
					zombieHealth-=1;
					zombie.setHealth(zombieHealth);

				}else{
					for (int i = 0; i < gameObjects.size; i++) {
						if(gameObjects.get(i).equals(zombie)){
							gameObjects.get(i).setPosition((int)(Math.random() * viewport.getMaxWorldWidth() + -viewport.getMinWorldWidth()),(int)(Math.random() * viewport.getMaxWorldHeight() + -viewport.getMinWorldHeight()));
							gameObjects.get(i).setHealth((int)(Math.random() * (20-1)+1) + 1);
						}
					}
				}


			}

		}
	}

	private void setGameInput(int speed){
		gameInput.input(player.getSprite(), speed);
	}

	private void setObjectLogic(){

		fireball.act(stateTime * 300);
		stateTime2 += Gdx.graphics.getDeltaTime();
		zombie.act(stateTime2 , player.getX(), player.getY());

	}

	private void setFonts(){

		font.draw(batch, ""+zombie.getHealth(), zombie.getX()+10, zombie.getY()+50);

		font.draw(batch, "Game Data: ", -585,-330);
		font.draw(batch, "Tiles on screen: " + gameObjects.size, -585,-345);
		font.draw(batch, "Player-Zombie-Col: " + playerObjectCollision.getCollisionDetection(player.getSprite(), zombie.getSprite()), -585,-360);
		font.draw(batch, "PlayerHealth: " + heart.getHealth().size(), -585,-375);
	}

	private void drawGameobjects(){
		for(GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}

		player.draw(batch);

		fireball.draw(batch);

		for (PixelHeart px: heart.getHealth()) {
			px.draw(batch);
		}
	}

	private void setStateTime(){
		stateTime += Gdx.graphics.getDeltaTime();
		stateTime2 = 0f;
	}

	private void setGameOver(){
		if(gameState==1){
			font.getData().setScale(2);
			font.draw(batch, "GAME OVER!", -100, +100);
			font.draw(batch, "EXIT: 'ESCAPE'", -100, 0);
			font.draw(batch, "REPLAY: 'ENTER'", -100, -100);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
				Gdx.app.exit();
			}else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
				gameState=0;
				heart.setHealthCount(3);
				heart.create(viewport);
				player.setPosition(0,0);
				zombie.setPosition(-300,300);
				font.getData().setScale(1);
			}
		}
	}
}