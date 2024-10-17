package exam.seolheun5.calculator.main;

import exam.seolheun5.calculator.ui.CalculatorFrame;

import javax.swing.*;

/**
 * 메인 클래스.<br>
 * 계산기의 UI와 logic 코드를 불러와 실행시킨다.
 *
 * @author seolheun5(김은성, piberius5@gmail.com)
 *
 * @created 2024-10-11
 * @lastModified 2024-10-12
 *
 * @changelog
 * <ul>
 *     <li>2024-10-11: 최초 생성 (seolheun5)</li>
 *     <li>2024-10-12: {@code CalculatorFrame} 호출 방식 변경</li>
 *     <li>2024-10-16: changelog 통합</li>
 * </ul>
 */
public class Calculator {

    /**
     * 메인 메서드.
     *
     * @created 2024-10-11
     * @lastModified 2024-10-12
     *
     * @param args
     */
    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
