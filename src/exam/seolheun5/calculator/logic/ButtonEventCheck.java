package exam.seolheun5.calculator.logic;

import exam.seolheun5.calculator.utils.Constants;
import exam.seolheun5.calculator.logic.Calculate;

import javax.swing.*;

/**
 * {@code ButtonEventCheck} 클라스.<br>
 * 기존 {@code ButtonEventHandler}에 있던 버튼 이벤트 체크 메서드들을 분리 작성하기 위한 클래스.
 *
 * @author seolheun5
 *
 * @create 2024-10-16
 * @lastModified 2024-10-16
 *
 * @changelog
 * <ul>
 *     <li>2024-10-15: 최초 생성</li>
 *     <li>2024-10-16: 기존 {@code ButtonEventHandler}에 존재하는 이벤트 체크 메서드 및 changelog 이전</li>
 *     <ul>
 *         <li>2024-10-15: 숫자, '.', 부호변환에 대한 기능 처리 메서드 작성</li>
 *         <li>2024-10-15: 지우기 버튼에 대한 기능 처리 메서드 작성</li>
 *         <li>2024-10-15: 연산 체크 메서드 생성</li>
 *         <li>2024-10-15: 연산 체크 메서드 작성</li>
 *     </ul>
 *     <li>2024-10-16: changelog 통합</li>
 *     <li>소수점이 마지막에 위치할 때 연산자 사용시 예외처리</li>
 * </ul>
 */
public class ButtonEventCheck {

    private JLabel resultLabel;
    private JLabel solutionLabel;

    private String buttonText;
    private String resultText;
    private String solutionText;

    /**
     * {@code ButtonEventCheck} 클래스의 생성자.<br>
     * {@code resultLabel}, {@code solutionLabel}, {@code buttonText}를 가져와 필드 값을 설정.
     *
     * @author seolheun5
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     *
     * @param resultLabel 결과 정보를 보여주는 {@code JLabel} 타입 변수
     * @param solutionLabel 풀이 과정을 보여주는 {@code JLabel} 타입 변수
     * @param buttonText 버튼 텍스트 정보를 담고 있는 {@code String} 타입 변수
     */
    public ButtonEventCheck(JLabel resultLabel, JLabel solutionLabel, String buttonText) {
        this.resultLabel = resultLabel;
        this.solutionLabel = solutionLabel;

        this.buttonText = buttonText;
        this.resultText = resultLabel.getText();
        this.solutionText = solutionLabel.getText();
    }

    /**
     * {@code numCheck} 메서드는 숫자 입력에 대한 결과값 처리 기능을 담당함.
     *
     * @author seolheun5
     *
     * @create 2024-10-15
     * @lastModified 2024-10-15
     */
    protected void numCheck() {
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
     */
    protected void dotCheck() {
        if(!resultText.contains(Constants.DOT)) {
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
     * @see <a href="https://velog.io/@e_juhee/String-to-Number">부호변환 참고</a>
     */
    protected void reverseCheck() {
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
     */
    protected void backspaceCheck() {
        if(resultText.startsWith(Constants.SUBTRACT) && resultText.length() == 2) {
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
     * @lastModified 2024-10-16
     */
    protected void addCheck() {
        if(!solutionText.contains(Constants.ADD) &&
           !solutionText.contains(Constants.SUBTRACT) &&
           !solutionText.contains(Constants.MULTIPLY) &&
           !solutionText.contains(Constants.DIVIDE)) {
            if(resultText.endsWith(Constants.DOT)) {
                resultText = resultText.substring(0, resultText.length() - 1);
            }

            solutionText = resultText + Constants.ADD;
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
     * @lastModified 2024-10-16
     */
    protected void subtractCheck() {
        if(!solutionText.contains(Constants.ADD) &&
           !solutionText.contains(Constants.SUBTRACT) &&
           !solutionText.contains(Constants.MULTIPLY) &&
           !solutionText.contains(Constants.DIVIDE)) {
            if(resultText.endsWith(Constants.DOT)) {
                resultText = resultText.substring(0, resultText.length() - 1);
            }

            solutionText = resultText + Constants.SUBTRACT;
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
     * @lastModified 2024-10-16
     */
    protected void multiplyCheck() {
        if(!solutionText.contains(Constants.ADD) &&
           !solutionText.contains(Constants.SUBTRACT) &&
           !solutionText.contains(Constants.MULTIPLY) &&
           !solutionText.contains(Constants.DIVIDE)) {
            if(resultText.endsWith(Constants.DOT)) {
                resultText = resultText.substring(0, resultText.length() - 1);
            }

            solutionText = resultText + Constants.MULTIPLY;
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
     * @lastModified 2024-10-16
     */
    protected void divideCheck() {
        if(!solutionText.contains(Constants.ADD) &&
           !solutionText.contains(Constants.SUBTRACT) &&
           !solutionText.contains(Constants.MULTIPLY) &&
           !solutionText.contains(Constants.DIVIDE)) {
            if(resultText.endsWith(Constants.DOT)) {
                resultText = resultText.substring(0, resultText.length() - 1);
            }

            solutionText = resultText + Constants.DIVIDE;
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
     * @lastModified 2024-10-16
     */
    protected void equalsCheck() {
        if(resultText.endsWith(Constants.DOT)) {
            resultText = resultText.substring(0, resultText.length() - 1);
        }

        solutionText = solutionText + resultText + Constants.EQUALS;
        solutionLabel.setText(solutionText);

        Calculate c = new Calculate(resultLabel, solutionLabel, buttonText);

        if(solutionText.contains(Constants.ADD)) {
            c.calculateAdd();
        } else if(solutionText.contains(Constants.SUBTRACT)) {
            c.calculateSubtract();
        } else if(solutionText.contains(Constants.MULTIPLY)) {
            c.calculateMultiply();
        } else if(solutionText.contains(Constants.DIVIDE)) {
            c.calculateDivide();
        }
    }
}
