package exam.seolheun5.calculator.ui;

import exam.seolheun5.calculator.utils.RoundedButton;
import exam.seolheun5.calculator.utils.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * {@code CalculatorPanel}은 계산기 UI를 제공하는 {@code JPanel} 클래스.<br>
 * 계산기 앱의 내부 구조를 구성
 *
 * @author seolheun5(김은성, piberius5@gmail.com)
 *
 * @create 2024-10-12
 * @lastModified 2024-10-13
 *
 * @changelog
 * <ul>
 *     <li>2024-10-12: 최초 생성</li>
 *     <li>2024-10-12: 타이틀 패널 생성 및 구성</li>
 *     <li>2024-10-13: 패널 배경색 설정</li>
 *     <li>2024-10-14: 결과 패널 생성 및 구성</li>
 *     <li>2024-10-14: 버튼 패널 생성 및 구성</li>
 *     <li>2024-10-14: 버튼 패널 버튼 색상 설정</li>
 *     <li>2024-10-14: 버튼 타입 변경</li>
 * </ul>
 */
public class CalculatorPanel extends JPanel {

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    /**
     * {@code CalculatorPanel}의 생성자.<br>
     *
     * @author seolheun5(김은성, priberius5@gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-14
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-12: 타이틀 패널 추가</li>
     *     <li>2024-10-13: 메인 패널 추가 및 메인 패널, 타이틀 패널 배경색 설정</li>
     *     <li>2024-10-14: 결과 패널 추가</li>
     *     <li>2024-10-14: 버튼 패널 추가</li>
     *     <li>2024-10-14: 메인 패널 배치관리자 변경</li>
     * </ul>
     *
     * @see <a href="https://blog.naver.com/highkrs/220544498754">색상 설정 참고</a>
     * @see <a href="https://itdeveloper.tistory.com/20">메인 패널 레이아웃 변경 참고</a>
     */
    CalculatorPanel() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Constants.CALCULATOR_BACKGROUND_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        createTitlePanel();
        createResultPanel();
        createButtonPanel();

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridy = 0;
        mainPanel.add(titlePanel, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.2;
        gbc.gridy = 1;
        mainPanel.add(resultPanel, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridy = 2;
        mainPanel.add(buttonPanel, gbc);


        add(mainPanel);
    }

    /**
     * {@code titlePanel}은 계산기의 종류를 표시해주는 패널.
     *
     * @author seolheun5(김은성, priberius5@gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-13
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-12: 타이틀 레이아웃 생성 및 설정</li>
     *     <li>2024-10-13: 타이틀 패널 배경색 설정</li>
     * </ul>
     */
    private void createTitlePanel() {
        titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Constants.CALCULATOR_BACKGROUND_COLOR);

        JLabel titleLabel = new JLabel(Constants.STANDARD_TITLE, SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        titlePanel.add(titleLabel, BorderLayout.WEST);
    }

    /**
     *
     *
     * @author seolheun5(김은성, priberius5@gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-14
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-14: 결과 레이아웃 생성 및 설정</li>
     * </ul>
     */
    private void createResultPanel() {
        resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(Constants.CALCULATOR_BACKGROUND_COLOR);

        JLabel resultLabel = new JLabel("0", SwingConstants.RIGHT);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        resultPanel.add(resultLabel, BorderLayout.CENTER);
    }

    /**
     *
     *
     * @author seolheun5(김은성, priberius5 @ gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-14
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-14: 버튼 레이아웃 생성 및 설정</li>
     *     <li>2024-10-14: 버튼 색상 설정</li>
     *     <li>2024-10-14: 라운드 버튼으로 버튼 변경</li>
     * </ul>
     *
     * @see <a href="https://hamait.tistory.com/342">정규표현식 참고</a>
     */
    private void createButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(Constants.CALCULATOR_BACKGROUND_COLOR);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for(String label : Constants.BUTTONS_LIST) {
            RoundedButton button = new RoundedButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 15));

            if(label.matches("^[0-9±.]$")) {
                button.setBackground(Constants.CALCULATOR_NUMBERPAD_COLOR);
            } else if(label.equals("=")) {
                button.setBackground(Constants.CALCULATOR_EQUALS_COLOR);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(Constants.CALCULATOR_FUN_AND_OPERPAD_COLOR);
            }

            buttonPanel.add(button);
        }
    }
}
