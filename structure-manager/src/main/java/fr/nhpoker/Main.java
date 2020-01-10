package fr.nhpoker;

import com.airhacks.afterburner.injection.Injector;

import fr.nhpoker.gui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		Injector.instantiateModelOrService(ApplicationController.class);
//		ApplicationController controller = new ApplicationController();
		
		MainView view = new MainView();
		
//		String javaVersion = System.getProperty("java.version");
//		String javafxVersion = System.getProperty("javafx.version");
//		Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//		Scene scene = new Scene(new StackPane(l), 640, 480);
		Scene scene = new Scene(view.getView());
		stage.setScene(scene);
		stage.show();
	}
}
