package exam.seolheun5.calculator.logic;

import exam.seolheun5.calculator.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * {@code Calculate} 클래스는 계산을 담당하는 메서드 종합 클래스.
 *
 * @author seolheun5(김은성, piberius5 @ gmail.com)
 *
 * @create 2024-10-16
 * @lastModified 2024-10-27
 *
 * @changelog
 *            <ul>
 *            <li>2024-10-16: 최초 생성</li>
 *            <li>2024-10-16: 더하기 계산 메서드 작성</li>
 *            <li>2024-10-16: 빼기, 곱하기, 나누기 계산 메서드 작 성</li>
 *            <li>2024-10-17: 첫 번째 숫자가 음수일 때 버그 수정</li>
 *            <li>2024-10-17: 0으로 나눌 때 오류 메시지 출력</li>
 *            <li>2024-10-18: 0으로 나눌 때 오류 메시지 폰트 오류 수정</li>
 *            <li>2024-10-19: 각 사칙연산 메서드에서 중복되는 내용을 하나의 메서드로 분리하여 호출</li>
 *            <li>2024-10-19: 피연산자 타입 BigDecimal로 변경</li>
 *            <li>2024-10-27: 피연산자 타입 수정 후 발생한 버그 수정</li>
 *            </ul>
 */
public class Calculate {

    private JLabel resultLabel;
    private JLabel solutionLabel;

    private String solutionText;

    /**
     * {@code Calculate} 클래스의 생성자.<br>
     * {@code resultLabel}, {@code solutionLabel}, {@code buttonText}를 가져와 필드 값을 설정.
     *
     * @create 2024-10-16
     * @lastModified 2024-10-16
     *
     * @param resultLabel   결과 정보를 보여주는 {@code JLabel} 타입 변수
     * @param solutionLabel 풀이 과정을 보여주는 {@code JLabel} 타입 변수
     * @param buttonText    버튼 텍스트 정보를 담고 있는 {@code String} 타입 변수
     */
    public Calculate(JLabel resultLabel, JLabel solutionLabel, String buttonText) {
        this.resultLabel = resultLabel;
        this.solutionLabel = solutionLabel;

        this.solutionText = solutionLabel.getText();
    }

    /**
     * {@code findResult} 메서드는 연산자를 파라미터로 받아 결과를 문자열로 반환해주는 메서드.
     *
     * @create 2024-10-19
     * @lastModified 2024-10-19
     *
     * @param operator 계산할 연산자를 받아옴
     * @return 문자열 계산 결과
     *
     * @see <a href="https://jsonobject.tistory.com/466">BigDecimal 타입 참고</a>
     */
    private String findResult(String operator) {
        BigDecimal firstNum;
        BigDecimal secondNum;

        if (solutionText.startsWith(Constants.SUBTRACT)) {
            int firstIndex = solutionText.indexOf(Constants.SUBTRACT);

            firstNum = new BigDecimal(solutionText.substring(0, (solutionText.indexOf(operator, firstIndex + 1))));
            secondNum = new BigDecimal(solutionText.substring((solutionText.indexOf(operator, firstIndex + 1) + 1),
                    solutionText.length() - 1));
        } else {
            firstNum = new BigDecimal(solutionText.substring(0, (solutionText.indexOf(operator))));
            secondNum = new BigDecimal(
                    solutionText.substring((solutionText.indexOf(operator) + 1), solutionText.length() - 1));
        }

        String result = "";
        switch (operator) {
            case Constants.ADD:
                result = String.valueOf(firstNum.add(secondNum));
                break;

            case Constants.SUBTRACT:
                result = String.valueOf(firstNum.subtract(secondNum));
                break;

            case Constants.MULTIPLY:
                result = String.valueOf(firstNum.multiply(secondNum));
                break;

            case Constants.DIVIDE:
                if (secondNum.equals(BigDecimal.ZERO)) {
                    resultLabel.setText(Constants.NO_DIVIDE);
                    solutionLabel.setText(" ");
                    solutionLabel.setFont(new Font("SanSerif", Font.PLAIN, 35));
                    resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
                    return result;
                } else {
                    result = String.valueOf(firstNum.divide(secondNum, MathContext.DECIMAL128));
                }
                break;
        }

        if (result.length() > 2 && result.substring(result.length() - 2).equals(".0")) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    /**
     * {@code calculateAdd} 메서드는 더하기를 수행하는 계산 메서드.
     *
     * @create 2024-10-16
     * @lastModified 2024-10-19
     */
    public void calculateAdd() {
        String result = findResult(Constants.ADD);

        resultLabel.setText(result);
    }

    /**
     * {@code calculateSubtract} 메서드는 빼기를 수행하는 계산 메서드.
     *
     * @create 2024-10-16
     * @lastModified 2024-10-19
     */
    public void calculateSubtract() {
        String result = findResult(Constants.SUBTRACT);

        resultLabel.setText(result);
    }

    /**
     * {@code calculateMultiply} 메서드는 곱하기를 수행하는 계산 메서드.
     *
     * @create 2024-10-16
     * @lastModified 2024-10-19
     */
    public void calculateMultiply() {
        String result = findResult(Constants.MULTIPLY);

        resultLabel.setText(result);
    }

    /**
     * {@code calculateDivide} 메서드는 나누기를 수행하는 계산 메서드.
     *
     * @create 2024-10-16
     * @lastModified 2024-10-19
     */
    public void calculateDivide() {
        String result = findResult(Constants.DIVIDE);

        if (!result.equals("")) {
            resultLabel.setText(result);
        }
    }
}
