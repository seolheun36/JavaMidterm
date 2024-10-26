package exam.seolheun5.calculator.logic;

import exam.seolheun5.calculator.utils.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * {@code ButtonEventHandler}는 버튼 클릭에 대한 이벤트를 처리하는 클래스.
 *
 * @author seolheun5(김은성, piberius5 @ gmail.com)
 *
 * @create 2024-10-15
 * @lastModified 2024-10-27
 *
 * @changelog
 * <ul>
 *     <li>2024-10-15: 최초 생성</li>
 *     <li>2024-10-15: 이벤트 처리를 위한 필드 설정 및 이벤트 처리 코드 작성</li>
 *     <li>2024-10-15: 결과값 처리 메서드를 위한 {@code resultText}, {@code buttonText} 필드로 변환</li>
 *     <li>2024-10-16: changelog 통합 및 changelog 이전</li>
 *     <li>2024-10-16: all clear, clear entry 체크 메서드 연동</li>
 *     <li>2024-10-27: 이벤트 체크 if else문에서 switch문으로 변경</li>
 * </ul>
 *
 * @see <a href="https://velog.io/@sunk2205/JAVA-Swing-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC">클래스 사용 이벤트 처리</a>
 */
public class ButtonEventHandler implements ActionListener {

    private JLabel resultLabel;
    private JLabel solutionLabel;

    /**
     * {@code ButtonEventHandler}의 생성자.
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @param resultLabel 결과 정보를 보여주는 {@code JLabel} 타입 변수
     * @param solutionLabel 풀이 과정을 보여주는 {@code JLabel} 타입 변수
     */
    public ButtonEventHandler(JLabel resultLabel, JLabel solutionLabel) {
        this.resultLabel = resultLabel;
        this.solutionLabel = solutionLabel;
    }

    /**
     * {@code actionPerformed}는 이벤트를 받아와 올바르게 처리하는 메서드.
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @param e 처리해야할 이벤트
     *
     * @see <a href="https://hamait.tistory.com/342"><del>정규표현식 참고</del></a>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        ButtonEventCheck bec = new ButtonEventCheck(resultLabel, solutionLabel, buttonText);
        
        switch (buttonText) {
            case Constants.DOT:
                bec.dotCheck();
                break;
            case Constants.ADD:
                bec.addCheck();
                break;
            case Constants.SUBTRACT:
                bec.subtractCheck();
                break;
            case Constants.MULTIPLY:
                bec.multiplyCheck();
                break;
            case Constants.DIVIDE:
                bec.divideCheck();
                break;
            case Constants.EQUALS:
                bec.equalsCheck();
                break;
            case Constants.BUTTON_REVERSE_SIGN:
                bec.reverseCheck();
                break;
            case Constants.BUTTON_BACKSPACE:
                bec.backspaceCheck();
                break;
            case Constants.BUTTON_ALL_CLEAR:
                bec.clearAllCheck();
                break;
            case Constants.BUTTON_CLEAR_ENTRY:
                bec.clearEntryCheck();
                break;
            default:
            bec.numCheck();
                break;
        }
    }
}
