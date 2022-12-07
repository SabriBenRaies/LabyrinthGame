package com.moss.personange;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.moss.main.Clavier;
import com.moss.main.PanneauJeu;

public class Hero extends Personnage {
	PanneauJeu pan;
	Clavier clavier;

	public Hero(PanneauJeu pan, Clavier clavier) {
		this.pan = pan;
		this.clavier = clavier;
		setDefaultValue();
		getPlayerImage();
	}

	public void setDefaultValue() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_0.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_0.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_0.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_1.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_2.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/Hero/up/up_3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/Hero/down/down_3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Hero/right/right_3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/Hero/left/left_3.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (clavier.upPressed || clavier.downPressed || clavier.leftPressed || clavier.rightPressed) {
			if (clavier.upPressed) {
				direction = "up";
				y -= speed;
			}
			if (clavier.downPressed) {
				direction = "down";
				y += speed;
			}
			if (clavier.leftPressed) {
				direction = "left";
				x -= speed;
			}
			if (clavier.rightPressed) {
				direction = "right";
				x += speed;
			}
			spriteCounter++;
			if (spriteCounter > 12) {
				spriteNum++;
				if (spriteNum == 5) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			if (spriteNum == 3) {
				image = up3;
			}
			if (spriteNum == 4) {
				image = up4;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			if (spriteNum == 3) {
				image = down3;
			}
			if (spriteNum == 4) {
				image = down4;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			if (spriteNum == 3) {
				image = left3;
			}
			if (spriteNum == 4) {
				image = left4;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			if (spriteNum == 3) {
				image = right3;
			}
			if (spriteNum == 4) {
				image = right4;
			}
			break;
		}
		g2.drawImage(image, x, y, pan.tileSize, pan.tileSize, null);

	}

}
