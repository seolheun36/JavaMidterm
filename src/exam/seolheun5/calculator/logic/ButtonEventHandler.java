package exam.seolheun5.calculator.logic;

import exam.seolheun5.calculator.utils.Constants;

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
 *     <li>2024-10-15: 지우기 버튼에 대한 기능 처리 코드 작성</li>
 *     <li>2024-10-15: 연산 체크 메서드 생성</li>
 * </ul>
 *
 * @see <a href="https://velog.io/@sunk2205/JAVA-Swing-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC">클래스 사용 이벤트 처리</a>
 */
public class ButtonEventHandler implements ActionListener {

    private JLabel resultLabel;
    private String resultText;
    private JLabel solutionLabel;
    private String solutionText;
    private String buttonText;

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
    public ButtonEventHandler(JLabel resultLabel, JLabel solutionLabel) {
        this.resultLabel = resultLabel;
        this.solutionLabel = solutionLabel;
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
        solutionText = solutionLabel.getText();

        if(buttonText.matches("^[0-9]$")) {
            numCheck();
        } else if(buttonText.equals(Constants.BUTTON_DOT)) {
            dotCheck();
        } else if(buttonText.equals(Constants.BUTTON_REVERSE_SIGN)) {
            reverseCheck();
        } else if(buttonText.equals(Constants.BUTTON_BACKSPACE)) {
            backspaceCheck();
        } else if(buttonText.equals(Constants.BUTTON_ADD)) {
            addCheck();
        } else if(buttonText.equals(Constants.BUTTON_SUBTRACT)) {
            subtractCheck();
        } else if(buttonText.equals(Constants.BUTTON_MULTIPLY)) {
            multiplyCheck();
        } else if(buttonText.equals(Constants.BUTTON_DIVIDE)) {
            divideCheck();
        } else if(buttonText.equals(Constants.BUTTON_EQUALS)) {
            equalsCheck();
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
        if(resultText.equals(Constants.ZERO)) {
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
        if(!resultText.contains(Constants.BUTTON_DOT)) {
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
        if(!resultText.equals(Constants.ZERO)) {
            try {
                int reverseNum = Integer.parseInt(resultText) * -1;
                resultLabel.setText(String.valueOf(reverseNum));
            } catch (NumberFormatException e) {
                double reverseNum = Double.parseDouble(resultText) * -1;
                resultLabel.setText(String.valueOf(reverseNum));
            }
        }
    }

    /**
     * {@code backspaceCheck} 메서드는 '←' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '←' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void backspaceCheck() {
        if(resultText.startsWith(Constants.BUTTON_SUBTRACT) && resultText.length() == 2) {
            resultLabel.setText(Constants.ZERO);
        } else if(resultText.length() == 1) {
            resultLabel.setText(Constants.ZERO);
        } else {
            resultLabel.setText(resultText.substring(0, resultText.length() - 1));
        }
    }

    /**
     * {@code addCheck} 메서드는 '+' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '+' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void addCheck() {
        if(!solutionText.contains(Constants.BUTTON_ADD) &&
           !solutionText.contains(Constants.BUTTON_SUBTRACT) &&
           !solutionText.contains(Constants.BUTTON_MULTIPLY) &&
           !solutionText.contains(Constants.BUTTON_DIVIDE)) {
            solutionText = resultText + Constants.BUTTON_ADD;
            solutionLabel.setText(solutionText);
            resultLabel.setText(Constants.ZERO);
        }
    }

    /**
     * {@code subtractCheck} 메서드는 '-' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '-' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void subtractCheck() {
        if(!solutionText.contains(Constants.BUTTON_ADD) &&
           !solutionText.contains(Constants.BUTTON_SUBTRACT) &&
           !solutionText.contains(Constants.BUTTON_MULTIPLY) &&
           !solutionText.contains(Constants.BUTTON_DIVIDE)) {
            solutionText = resultText + Constants.BUTTON_SUBTRACT;
            solutionLabel.setText(solutionText);
            resultLabel.setText(Constants.ZERO);
        }
    }

    /**
     * {@code multiplyCheck} 메서드는 '×' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '×' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void multiplyCheck() {
        if(!solutionText.contains(Constants.BUTTON_ADD) &&
           !solutionText.contains(Constants.BUTTON_SUBTRACT) &&
           !solutionText.contains(Constants.BUTTON_MULTIPLY) &&
           !solutionText.contains(Constants.BUTTON_DIVIDE)) {
            solutionText = resultText + Constants.BUTTON_MULTIPLY;
            solutionLabel.setText(solutionText);
            resultLabel.setText(Constants.ZERO);
        }
    }

    /**
     * {@code divideCheck} 메서드는 '÷' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '÷' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void divideCheck() {
        if(!solutionText.contains(Constants.BUTTON_ADD) &&
           !solutionText.contains(Constants.BUTTON_SUBTRACT) &&
           !solutionText.contains(Constants.BUTTON_MULTIPLY) &&
           !solutionText.contains(Constants.BUTTON_DIVIDE)) {
            solutionText = resultText + Constants.BUTTON_DIVIDE;
            solutionLabel.setText(solutionText);
            resultLabel.setText(Constants.ZERO);
        }
    }

    /**
     * {@code equalsCheck} 메서드는 '=' 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     *
     * @changelog
     * <ul>
     *     <li>2024-10-15: 최초 생성</li>
     *     <li>2024-10-15: '=' 입력에 대한 결과값 처리 기능 작성</li>
     * </ul>
     */
    private void equalsCheck() {
        solutionText = solutionText + resultText + Constants.BUTTON_EQUALS;
        solutionLabel.setText(solutionText);
        resultLabel.setText(Constants.ZERO);
    }
}
