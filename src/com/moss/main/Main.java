package com.moss.main;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");
	static PanneauJeu pan = new PanneauJeu();

	public static void main(String[] args) {

		Fenetre fenetre = new Fenetre();
		pan.startGameThread();
		// String userDirectory=System.getProperty("user.dir");
		// System.out.println(userDirectory);
		// Path currentDirPath = Paths.get("");
		// String currentDir = currentDirPath.toAbsolutePath().toString();
		// System.out.println(currentDirPath.toString());
	}

}
