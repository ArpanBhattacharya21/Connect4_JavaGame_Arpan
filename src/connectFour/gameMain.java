package connectFour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class gameMain extends Application {
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loader.load();

		controller = loader.getController();
		controller.createPlayground();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		menuBar.setStyle("-fx-base: black;");   //menuBar color

		Scene scene = new Scene(rootGridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect4 - The Game!");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private MenuBar createMenu() {
		//File menu
		Menu fileMenu = new Menu("File");

		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(event -> controller.resetGame());  //event listener

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction(event -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(event -> exitGame());

		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

		//Help Menu
		Menu helpMenu = new Menu("Help");

		MenuItem aboutGame = new MenuItem("About Connect4!");
		aboutGame.setOnAction(event -> aboutConnect4());

		SeparatorMenuItem separator = new SeparatorMenuItem();

		MenuItem aboutDeveloper = new MenuItem("About Developer!");
		aboutDeveloper.setOnAction(event -> aboutDeveloper());

		SeparatorMenuItem separate = new SeparatorMenuItem();

		MenuItem aboutApp = new MenuItem("About App!");
		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutGame, separator, aboutDeveloper , separate , aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ABOUT THE APP");
		alert.setHeaderText("Connect4 : Application Information");
		alert.setContentText("Development Phase: 5 June 2022 - 6 June 2022" +
				"\nDevelopment Origin: Greater NOIDA (Delhi-NCR), India" +
				"\nDevelopment Technology: JavaFX 8" +
				"\nApplication Type: Desktop App - Install and Run." +
				"\nApplication Domain: Lite Gaming" +
				"\nDevelopment Tool: IDE supporting Java");
		alert.show();
	}

	private void aboutDeveloper() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ABOUT DEVELOPER");
		alert.setHeaderText("ARPAN BHATTACHARYA");
		alert.setContentText("Arpan Bhattacharya, developer of this app is an Delhi-NCR based Indian Programmer. " +
				"Likes to spend time in playing around with codes, programming languages, innovating new ideas for new apps or software. " +
				"Has experience in basic coding since since 2014 and conceptual programming since 2016." +
				"This is developer's 4th Desktop App in a row, and soon will be available with more apps and ideas." +
				"apps in future! \n Thank You! ");
		alert.show();
	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("GUIDE!");
		alert.setHeaderText("How to play the game?");
		alert.setContentText("Connect Four is a two-player connection game in which the players" +
				" first choose a color and then take turns dropping colored discs from the top into a " +
				"seven-column, six-row vertically suspended grid. The pieces fall straight down, " +
				"occupying the next available space within the column. The objective of the game is to " +
				"be the first to form a horizontal, vertical, or diagonal line of four of one's own " +
				"discs. Connect Four is a solved game. The first player can always win by playing the" +
				" right moves.");
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
