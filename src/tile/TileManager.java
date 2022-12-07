package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Main;
import com.moss.main.PanneauJeu;

public class TileManager {
	PanneauJeu pan;
	Tile[] tile;
	int mapTileNum[][];

	public TileManager(PanneauJeu pan) {
		this.pan = pan;
		tile = new Tile[10];
		mapTileNum = new int[pan.maxScreenLigne][pan.maxScreenCol];
		getTileImage();
		loadMap(Main.currentDir + "/maps/map.txt");
	}

	public void getTileImage() {
		String path = new String();
		File file;
		try {
			path = Main.currentDir + "/images/tiles/grass.png";
			file = new File(path);
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(file);

			path = Main.currentDir + "/images/tiles/wall.png";
			file = new File(path);
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(file);

			path = Main.currentDir + "/images/tiles/water.png";
			file = new File(path);
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String mapPath) {
		File file = new File(mapPath);
		BufferedReader bufferedReader = null;
		String line;
		String mapCase[];
		int col = 0;
		int row = 0;
		System.out.println(mapPath);
		try {
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				for (col = 0; col < pan.maxScreenCol; col++) {
					mapCase = line.split(" ");
					mapTileNum[row][col] = Integer.parseInt(mapCase[col]);
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pan.maxScreenLigne; i++) {
			for (int j = 0; j < pan.maxScreenCol; j++) {
				System.out.print(mapTileNum[i][j]);
			}
			System.out.print("\n");
		}
	}

	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		for (row = 0, y = 0; row < pan.maxScreenLigne; row++, y += pan.tileSize) {
			for (col = 0, x = 0; col < pan.maxScreenCol; col++, x += pan.tileSize) {
				g2.drawImage(tile[mapTileNum[row][col]].image, x, y, pan.tileSize, pan.tileSize, null);

			}
		}
	}

}
