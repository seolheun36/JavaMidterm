package exam.seolheun5.calculator.ui;

import java.awt.*;
import javax.swing.*;

/**
 * {@code CalculatorFrame}은 계산기 UI를 제공하는 {@code JFrame} 클래스.<br>
 * 계산기 앱의 메인 윈도우를 생성.
 *
 * @author seolheun5(김은성, piberius5 @ gmail.com)
 *
 * @created 2024-10-11
 * @lastModified 2024-10-14
 *
 * @changelog
 * <ul>
 *     <li>2024-10-11: 최초 생성</li>
 *     <li>2024-10-11: 프레임 기본 설정</li>
 *     <li>2024-10-12: 프레임 위치 설정</li>
 *     <li>2024-10-12: 패널 클래스 연동</li>
 *     <li>2024-10-14: 앱 아이콘 변경</li>
 *     <li>2024-10-16: changelog 통합</li>
 * </ul>
 */
public class CalculatorFrame extends JFrame {

    /**
     * {@code CalculatorFrame}의 생성자.<br>
     * 프레임의 제목과 크기, 기본 설정을 초기화.
     *
     * @created 2024-10-11
     * @lastModified 2024-10-14
     *
     * @see <a href="https://i.namu.wiki/i/7AftaBTkBYLrir8txkuzxu7eNGCkaVFXVK7eQx1V1og3mjP9ezTQrv7FTq0XaPrRFlYShB7ui0Q7wfaQd_ZP4Q.svg">아이콘 출처</a>
     * @see <a href="https://selfinvestfriends.tistory.com/15">패널 중앙에 띄우기 참고</a>
     * @see <a href="https://chatgpt.com/share/670d1343-ab58-8008-92be-bdc7ae286b2c">아이콘 변경 참고</a>
     */
    public CalculatorFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 550);
        setLocationRelativeTo(null);

        Image icon = new ImageIcon(getClass().getResource("../resources/icons/calculatorIcon.png")).getImage();
        setIconImage(icon);

        CalculatorPanel calculatorPanel = new CalculatorPanel();
        add(calculatorPanel);

        setVisible(true);
    }
}
