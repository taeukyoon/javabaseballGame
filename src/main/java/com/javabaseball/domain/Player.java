package com.javabaseball.domain;

import static java.lang.System.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.javabaseball.type.Constants;

/*
 3자리 숫자 사용자 입력
 */
public class Player {
	public List<Integer> playerInputNumbers() {
		out.println(Constants.EXCEPTION_NUMBER_LENGTH);
		Scanner sc = new Scanner(in);
		String input = sc.next();
		validateLength(input);
		validateDuplicate(input);

		return Arrays.stream(input.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private void validateDuplicate(String input) {
		Set<Character> charSet = input.chars()
			.mapToObj(c -> (char)c).collect(Collectors.toSet());

		if (charSet.size() != 3) {
			throw new IllegalArgumentException(Constants.EXCEPTION_DUPLICATE);
		}
	}

	private void validateLength(String input) {
		if (input.length() != Constants.BASEBALL_LENGTH) {
			throw new IllegalArgumentException(Constants.EXCEPTION_NUMBER_LENGTH);
		}
	}

}
