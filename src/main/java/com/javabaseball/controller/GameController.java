package com.javabaseball.controller;

import com.javabaseball.domain.Computer;
import com.javabaseball.domain.Player;

public class GameController {
	Player player;
	Computer computer;

	public GameController() {
		this.player = new Player();
		this.computer = new Computer();
	}

	public void play() {
		computer.generateRandomNumbers();
		do {
			computer.countScore(player.playerInputNumbers());
			computer.printScore();
		} while (!computer.gameOver());
	}

	public void start() {
		do {
			play();
		} while (computer.restart());
	}
}
