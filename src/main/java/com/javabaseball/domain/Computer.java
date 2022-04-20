package com.javabaseball.domain;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.javabaseball.type.Constants;

public class Computer {
	private ArrayList<Integer> generateNumbers;

	public void generateRandomNumbers() {
		generateNumbers = new ArrayList<>();
		while (generateNumbers.size() < Constants.BASEBALL_LENGTH) {
			int num = ThreadLocalRandom.current().nextInt(Constants.MIN_NUM, Constants.MAX_NUM);
			if (!generateNumbers.contains(num)) {
				generateNumbers.add(num);
			}
		}
	}
}
