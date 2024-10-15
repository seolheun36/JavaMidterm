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
 *     <li>2024-10-15: 결과값 처리 메서드를 위한 {@code resultText}, {@code buttonText} 필드로 변환</li>
 *     <li>2024-10-15: 숫자, '.', 부호변환에 대한 기능 처리 코드 작성</li>
 * </ul>
 *
 * @see <a href="https://velog.io/@sunk2205/JAVA-Swing-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC">클래스 사용 이벤트 처리</a>
 */
public class ButtonEventHandler implements ActionListener {

    JLabel resultLabel;
    String resultText;
    String buttonText;

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
        buttonText = button.getText();
        resultText = resultLabel.getText();

        if(buttonText.matches("^[0-9]$")) {
            numCheck();
        } else if(buttonText.equals(".")) {
            dotCheck();
        } else if(buttonText.equals("±")) {
            reverseCheck();
        }
    }

    /**
     * {@code numCheck} 메서드는 숫자 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: 숫자 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void numCheck() {
        if(resultText.equals("0")) {
                resultLabel.setText(buttonText);
        } else {
            resultLabel.setText(resultText + buttonText);
        }
    }

    /**
     * {@code dotCheck} 메서드는 '.' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '.' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void dotCheck() {
        if(!resultText.contains(".")) {
            resultLabel.setText(resultText + buttonText);
        }
    }

    /**
     * {@code reverseCheck} 메서드는 부호변환 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: 부호변환 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     *
     * @see <a href="https://velog.io/@e_juhee/String-to-Number">부호변환 참고</a>
     */
    private void reverseCheck() {
        if(!resultText.equals("0")) {
            try {
                int reverseNum = Integer.parseInt(resultText) * -1;
                resultLabel.setText(String.valueOf(reverseNum));
            } catch (NumberFormatException e) {
                double reverseNum = Double.parseDouble(resultText) * -1;
                resultLabel.setText(String.valueOf(reverseNum));
            }
        }
    }
}
