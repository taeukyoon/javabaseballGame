package com.javabaseball.type;

public class Constants {
	public static final int MIN_NUM = 1;
	public static final int MAX_NUM = 10;
	public static final int BASEBALL_LENGTH= 3;
	public static final int RESTART = 1;
	public static final int FINISH = 2;

	public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려 2를 입력하세요.";

	public static final String RESULT_NOTHING = "낫싱";
	public static final String RESULT_BALL = "볼";
	public static final String RESULT_STRIKE = "스트라이크";
	public static final String RESULT_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static final String EXCEPTION_RESTART_FLAG = "입력한 수가 잘못되었습니다. 재시작 하려면 1, 종료하려면 2를 입력하세요.";
	public static final String EXCEPTION_NUMBER_LENGTH = "3자리의 숫자를 입력해주세요.";
	public static final String EXCEPTION_NUMBER_RANGE = "1 ~ 9의 숫자를 입력해주세요.";
	public static final String EXCEPTION_DUPLICATE = "중복된 수가 있습니다.";
}
