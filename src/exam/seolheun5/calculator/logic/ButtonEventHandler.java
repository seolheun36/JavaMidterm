package exam.seolheun5.calculator.logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * {@code ButtonEventHandler}는 버튼 클릭에 대한 이벤트를 처리하는 클래스.
 *
 * @author seolheun5
 *
 * @create 2024-10-15
 * @lastModified 2024-10-15
 *
 * @changelog
 * <ul>
 *     <li>2024-10-15: 최초 생성</li>
 *     <li>2024-10-15: 이벤트 처리를 위한 필드 설정 및 이벤트 처리 코드 작성</li>
 * </ul>
 *
 * @see <a href="https://velog.io/@sunk2205/JAVA-Swing-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC">클래스 사용 이벤트 처리</a>
 */
public class ButtonEventHandler implements ActionListener {

    JLabel resultLabel;

    /**
     * {@code ButtonEventHandler}의 생성자.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: {@code CalculatorPanel}의 {@code resultLabel}변수 설정</li>
     * </ul>
     *
     * @param resultLabel 결과 정보를 보여주는 {@code JLabel} 타입 변수
     */
    public ButtonEventHandler(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    /**
     *
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: 숫자버튼 이벤트 처리 코드 작성</li>
     * </ul>
     *
     * @param e 처리해야할 이벤트
     *
     * @see <a href="https://hamait.tistory.com/342">정규표현식 참고</a>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        String resultText = resultLabel.getText();

        if(buttonText.matches("^[0-9]$")) {
            if(resultLabel.getText().equals("0")) {
                resultLabel.setText(buttonText);
            } else {
                resultLabel.setText(resultText + buttonText);
            }
        }
    }
}
