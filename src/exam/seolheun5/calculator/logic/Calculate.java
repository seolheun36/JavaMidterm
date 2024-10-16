package exam.seolheun5.calculator.logic;


import exam.seolheun5.calculator.utils.Constants;

import javax.swing.*;

/**
 * {@code Calculate} 클래스는 계산을 담당하는 메서드 종합 클래스.
 *
 * @author seolheun5
 *
 * @create 2024-10-16
 * @lastModified 2024-10-17
 *
 * @changelog
 * <ul>
 *     <li>2024-10-16: 최초 생성</li>
 *     <li>2024-10-16: 더하기 계산 메서드 작성</li>
 *     <li>2024-10-16: 빼기, 곱하기, 나누기 계산 메서드 작 성</li>
 *     <li>2024-10-17: 첫 번째 숫자가 음수일 때 버그 수정</li>
 * </ul>
 */
public class Calculate {

    private JLabel resultLabel;
    private JLabel solutionLabel;

    private String buttonText;
    private String resultText;
    private String solutionText;

    /**
     * {@code Calculate} 클래스의 생성자.<br>
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
    public Calculate(JLabel resultLabel, JLabel solutionLabel, String buttonText) {
        this.resultLabel = resultLabel;
        this.solutionLabel = solutionLabel;

        this.buttonText = buttonText;
        this.resultText = resultLabel.getText();
        this.solutionText = solutionLabel.getText();
    }

    /**
     * {@code calculateAdd} 메서드는 더하기를 수행하는 계산 메서드.
     *
     * @author seolheun5
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     */
    public void calculateAdd() {
        double firstNum = Double.parseDouble(solutionText.substring(0, (solutionText.indexOf(Constants.ADD))));
        double secondNum = Double.parseDouble(solutionText.substring((solutionText.indexOf(Constants.ADD) + 1), solutionText.length() - 1));

        String result = String.valueOf(firstNum + secondNum);
        if(result.substring(result.length() - 2).equals(".0")) {
            result = result.substring(0, result.length() - 2);
        }

        resultLabel.setText(result);
    }

    /**
     * {@code calculateSubtract} 메서드는 빼기를 수행하는 계산 메서드.
     *
     * @author seolheun5
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     */
    public void calculateSubtract() {
        double firstNum;
        double secondNum;

        if(solutionText.startsWith(Constants.SUBTRACT)) {
            int firstIndex = solutionText.indexOf(Constants.SUBTRACT);

            firstNum = Double.parseDouble(solutionText.substring(0, (solutionText.indexOf(Constants.SUBTRACT, firstIndex + 1))));
            secondNum = Double.parseDouble(solutionText.substring((solutionText.indexOf(Constants.SUBTRACT, firstIndex + 1) + 1), solutionText.length() - 1));
        } else {
            firstNum = Double.parseDouble(solutionText.substring(0, (solutionText.indexOf(Constants.SUBTRACT))));
            secondNum = Double.parseDouble(solutionText.substring((solutionText.indexOf(Constants.SUBTRACT) + 1), solutionText.length() - 1));
        }

        String result = String.valueOf(firstNum - secondNum);
        if(result.substring(result.length() - 2).equals(".0")) {
            result = result.substring(0, result.length() - 2);
        }

        resultLabel.setText(result);
    }

    /**
     * {@code calculateMultiply} 메서드는 곱하기를 수행하는 계산 메서드.
     *
     * @author seolheun5
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     */
    public void calculateMultiply() {
        double firstNum = Double.parseDouble(solutionText.substring(0, (solutionText.indexOf(Constants.MULTIPLY))));
        double secondNum = Double.parseDouble(solutionText.substring((solutionText.indexOf(Constants.MULTIPLY) + 1), solutionText.length() - 1));

        String result = String.valueOf(firstNum * secondNum);
        if(result.substring(result.length() - 2).equals(".0")) {
            result = result.substring(0, result.length() - 2);
        }

        resultLabel.setText(result);
    }

    /**
     * {@code calculateDivide} 메서드는 나누기를 수행하는 계산 메서드.
     *
     * @author seolheun5
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     */
    public void calculateDivide() {
        double firstNum = Double.parseDouble(solutionText.substring(0, (solutionText.indexOf(Constants.DIVIDE))));
        double secondNum = Double.parseDouble(solutionText.substring((solutionText.indexOf(Constants.DIVIDE) + 1), solutionText.length() - 1));

        String result = String.valueOf(firstNum / secondNum);
        if(result.substring(result.length() - 2).equals(".0")) {
            result = result.substring(0, result.length() - 2);
        }

        resultLabel.setText(result);
    }
}
