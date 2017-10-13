package test;

/*import static org.junit.Assert.assertEquals;
import main.ChessGame2016.myChessGame2016.ChessGame2016;*/
import main.ChessGame2016.myChessGame2016.GameManager;
//import javafx.application.Platform;
import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
import javafx.stage.Stage;
//import org.testfx.matcher.*;
//import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxAssert;
//import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

public class ChessGameTest extends ApplicationTest {

	/*@Override
	public void start(Stage arg0) throws Exception {
		System.out.println("HUH?");
		Platform.setImplicitExit(false);
		GameManager gameManager = new GameManager();
		gameManager.beginGame();
	}
	*/
	@Test
	public void isPlayButonAvailable() {
		targetWindow(0);
		Node n = (Node)find("#PLAY");
		System.out.println("ID IS ------ "+n.getId());
		FxAssert.verifyThat(n.getId(), org.hamcrest.Matchers.equalTo("PLAY"));
	}
	
	@Test
	public void clickPlayButton() {
		targetWindow(0);
		Node playButton = (Node)find("#PLAY");
		clickOn(playButton);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Node> T find(final String query) {
		return (T) lookup(query).queryAll().iterator().next();
	}
	
	//GameManager gameManager = new GameManager();
	/*2017-10-03 20:25:34,781 INFO [main] GameManager init : starting
	2017-10-03 20:25:34,929 INFO [main] GameManager init : complete
	2017-10-03 20:25:34,929 INFO [main] Starting ChessGame...
	2017-10-03 20:25:34,929 INFO [main] GameManager beginGame : preparing to init view & data
	guibuttons: 
	called addGUIButtons*/

	/*@Before
	public void runGame() throws Exception{
		System.out.println("HUH?");
		Platform.setImplicitExit(false);
		GameManager gameManager = new GameManager();
		gameManager.beginGame();
	}*/
	
	@Override
	public void start(Stage stg) throws Exception {		
		GameManager gameManager = new GameManager();
		//gameManager.beginGame(stg);			 //UNCOMMENT THIS LINE TO TEST. there will be fixes in the code as well
	}

}