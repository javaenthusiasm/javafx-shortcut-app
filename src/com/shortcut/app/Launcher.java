package com.shortcut.app;

import com.shortcut.app.handlers.ShortcutHandler;
import com.shortcut.app.utils.CustomKeyCombination;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Launcher extends Application {

	public static void main(String[] args) {
		Application.launch(Launcher.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		StackPane root = new StackPane();
		Scene scene = new Scene(root,400,100);


		stage.setTitle("Window to secret world");
		stage.setScene(scene);

		stage.addEventHandler(KeyEvent.KEY_PRESSED, 
				new ShortcutHandler(new CustomKeyCombination(KeyCombination.ALT_DOWN, KeyCode.A, KeyCode.S, KeyCode.W),
						() -> {
							Stage lStage = new Stage();
		                    try {
		                    	StackPane secretPane = new StackPane();
		                    	Label secretLbl = new Label("Secret Stage");
		                    	secretPane.getChildren().add(secretLbl);
		                    	Scene secretScene = new Scene(secretPane, 800, 600);

		                    	lStage.setTitle("Hello in secret stage");
		                    	lStage.setScene(secretScene);

		                        lStage.show();
		                    }
		                    catch (Exception e) {
		                        // TODO Auto-generated catch block
		                        e.printStackTrace();
		                    }
						}));  
		stage.show();

		stage.setOnCloseRequest(evt -> {
			System.exit(0);
		});
	}
}