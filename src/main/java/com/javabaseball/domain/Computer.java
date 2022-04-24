package com.javabaseball.domain;

import java.util.ArrayList;
import java.util.List;
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

	private void generateRandomNumbers() {
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

	public void countBall(List<Integer> input) {
		int count = 0;
		for (int i = 0; i < Constants.BASEBALL_LENGTH; i++) {
			if (this.generateNumbers.contains(input.get(i))) {
				count++;
			}
		}
		this.ball = count - this.strike; // ball이 strike랑 중복가능성이 있다.
	}

}
