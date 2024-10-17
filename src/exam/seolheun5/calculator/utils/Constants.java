package exam.seolheun5.calculator.utils;

import java.awt.*;

/**
 * {@code Constants}는 계산기 앱에서 활용할 상수들을 정의하는 클래스.<br>
 * 색상, 레이블, 레이아웃 등의 상수를 관리.
 *
 * @author seolheun5(김은성, priberius5@gmail.com)
 *
 * @create 2024-10-13
 * @lastModified 2024-10-16
 *
 * @changelog
 * <ul>
 *     <li>2024-10-13: 최초 생성</li>
 *     <li>2024-10-13: 타이틀 상수 생성 및 기본 계산기 타이틀 상수 선언</li>
 *     <li>2024-10-13: 색상 상수 생성 및 배경 색상 상수 선언</li>
 *     <li>2024-10-14: 배경 색상 상수명 오타 수정</li>
 *     <li>2024-10-14: 레이블 상수 및 레이블 리스트 선언</li>
 *     <li>2024-10-14: 버튼 색상 상수 선언 및 색상 상수명에 COLOR 추가</li>
 *     <li>2024-10-15: 지우기 버튼 텍스트 변경</li>
 *     <li>2024-10-15: 외부 사용을 위한 일부 숫자 제외 레이블 상수 공개</li>
 *     <li>2024-10-16: 버튼 외에 다른 역할도 수행하는 상수명 수정</li>
 * </ul>
 *
 * @see <a href="https://blog.naver.com/highkrs/220544498754">색상 설정 참고</a>
 */
public class Constants {
    // 타이틀 상수
    public static final String STANDARD_TITLE = "Standard";


    // 메시지 상수
    public static final String NO_DIVIDE = "0으로 나눌 수 없습니다.";


    // 레이블 상수
    // 연산자
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "×";
    public static final String DIVIDE = "÷";
    public static final String EQUALS = "=";

    // 숫자
    public static final String ZERO = "0";
    private static final String BUTTON_ONE = "1";
    private static final String BUTTON_TWO = "2";
    private static final String BUTTON_THREE = "3";
    private static final String BUTTON_FOUR = "4";
    private static final String BUTTON_FIVE = "5";
    private static final String BUTTON_SIX = "6";
    private static final String BUTTON_SEVEN = "7";
    private static final String BUTTON_EIGHT = "8";
    private static final String BUTTON_NINE = "9";

    // 기타
    public static final String DOT = ".";
    public static final String BUTTON_REVERSE_SIGN = "±";

    // 기능
    public static final String BUTTON_CLEAR_ENTRY = "CE";
    public static final String BUTTON_ALL_CLEAR = "AC";
    public static final String BUTTON_BACKSPACE = "←";

    // 레이블 리스트
    public static final String[] BUTTONS_LIST = {
                Constants.BUTTON_ALL_CLEAR,
                Constants.BUTTON_CLEAR_ENTRY,
                Constants.BUTTON_BACKSPACE,
                Constants.DIVIDE,
                Constants.BUTTON_SEVEN,
                Constants.BUTTON_EIGHT,
                Constants.BUTTON_NINE,
                Constants.MULTIPLY,
                Constants.BUTTON_FOUR,
                Constants.BUTTON_FIVE,
                Constants.BUTTON_SIX,
                Constants.ADD,
                Constants.BUTTON_ONE,
                Constants.BUTTON_TWO,
                Constants.BUTTON_THREE,
                Constants.SUBTRACT,
                Constants.BUTTON_REVERSE_SIGN,
                Constants.ZERO,
                Constants.DOT,
                Constants.EQUALS
        };


    // 색상 상수
    public static final Color CALCULATOR_BACKGROUND_COLOR = new Color(0xf3f3f3);
    public static final Color CALCULATOR_NUMBERPAD_COLOR = new Color(0xfcfcfc);
    public static final Color CALCULATOR_FUN_AND_OPERPAD_COLOR = new Color(0xf6f6f6);
    public static final Color CALCULATOR_EQUALS_COLOR = new Color(0x7b7161);
    public static final Color SOLUTION_LABEL_COLOR = new Color(0x939393);
}
