package com.javabaseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.javabaseball.type.Constants;

public class Computer {
	private ArrayList<Integer> generateNumbers;
	private int strike;
	private int ball;

	public void countScore(List<Integer> input) {
		countStrike(input);
		countBall(input);
	}

	public void generateRandomNumbers() {
		generateNumbers = new ArrayList<>();
		while (generateNumbers.size() < Constants.BASEBALL_LENGTH) {
			int num = ThreadLocalRandom.current().nextInt(Constants.MIN_NUM, Constants.MAX_NUM);
			if (!generateNumbers.contains(num)) {
				generateNumbers.add(num);
			}
		}
	}

	private void countStrike(List<Integer> input) {
		int count = 0;
		for (int i = 0; i < Constants.BASEBALL_LENGTH; i++) {
			if (input.get(i).equals(this.generateNumbers.get(i))) {
				count++;
			}
		}
		this.strike = count;
	}

	private void countBall(List<Integer> input) {
		int count = 0;
		for (int i = 0; i < Constants.BASEBALL_LENGTH; i++) {
			if (this.generateNumbers.contains(input.get(i))) {
				count++;
			}
		}
		this.ball = count - this.strike; // ball이 strike랑 중복가능성이 있다.
	}

	// 출력 부분 구현
	public void printScore() {
		if (this.strike == 0 && this.ball == 0) {
			System.out.println(Constants.RESULT_NOTHING);
		} else if (this.strike != 0 && this.ball == 0) {
			System.out.println(this.strike + Constants.RESULT_STRIKE);
			if (gameOver()) {
				System.out.println(Constants.RESULT_FINISH);
			}
		} else if (this.strike == 0) {
			System.out.println(this.ball + Constants.RESULT_BALL);
		} else {
			System.out.println(this.strike + Constants.RESULT_STRIKE + " " + this.ball + Constants.RESULT_BALL);
		}
	}

	public boolean gameOver() {
		return this.strike == 3;
	}

	public boolean restart() {
		System.out.println(Constants.RESTART_MESSAGE);
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		validateReStart(input);
		return input == Constants.RESTART;
	}

	private void validateReStart(int input) {
		if (input != Constants.RESTART && input != Constants.FINISH) {
			throw new IllegalArgumentException(Constants.RESTART_MESSAGE);
		}
	}
}
