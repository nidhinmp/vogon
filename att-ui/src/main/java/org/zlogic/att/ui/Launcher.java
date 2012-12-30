package org.zlogic.att.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java FX launcher/initializer
 * <p/>
 * User: Dmitry Zolotukhin <zlogic@gmail.com>
 * Date: 27.12.12
 * Time: 21:06
 */
public class Launcher extends Application {
	private final static Logger log = Logger.getLogger(Launcher.class.getName());

	@Override
	public void start(Stage stage) throws Exception {
		initApplication();
		Parent root;
		FXMLLoader loader;
		try {
			//Load FXML
			loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			loader.setLocation(getClass().getResource("MainWindow.fxml"));
			root = (Parent) loader.load();
		} catch (IOException ex) {
			log.log(java.util.logging.Level.SEVERE, null, ex);
			return;
		}

		//Create scene
		Scene scene = new Scene(root);

		//Set scene properties
		stage.setTitle("Awesome Time Tracker");

		stage.setScene(scene);

		stage.getIcons().addAll(getIconImages());

		stage.show();
		initTrayIcon(stage);
	}

	@Override
	public void stop() {
		//TODO: perform final cleanup here
	}

	private void initTrayIcon(Stage primaryStage) {
		Platform.setImplicitExit(false);
		Platform.runLater(new Runnable() {
			private Stage primaryStage;

			public Runnable setStage(Stage primaryStage) {
				this.primaryStage = primaryStage;
				return this;
			}

			@Override
			public void run() {
				new TrayIcon(primaryStage);
			}
		}.setStage(primaryStage));
	}

	/**
	 * Returns the list of icons
	 *
	 * @return the list of icons
	 */
	public List<Image> getIconImages() {
		List<Image> images = new LinkedList<>();
		int[] iconSizes = new int[]{16/*, 24, 32, 48, 64, 128, 256, 512*/};//TODO: Create other icons as well
		for (int iconName : iconSizes)
			images.add(new Image("org/zlogic/att/ui/icon/att-" + Integer.toString(iconName) + ".png"));
		return images;
	}

	/**
	 * Performs initialization of application's dependencies
	 */
	private void initApplication() {
		//Configure logging to load config from classpath
		String loggingFile = System.getProperty("java.util.logging.config.file");
		if (loggingFile == null || loggingFile.isEmpty()) {
			try {
				java.net.URL url = ClassLoader.getSystemClassLoader().getResource("logging.properties");
				if (url != null)
					java.util.logging.LogManager.getLogManager().readConfiguration(url.openStream());
			} catch (IOException | SecurityException e) {
				log.log(Level.SEVERE, "Error when loading logging configuration", e);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}