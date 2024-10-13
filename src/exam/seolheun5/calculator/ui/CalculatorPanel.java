package exam.seolheun5.calculator.ui;

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
 * @lastModified 2024-10-12
 *
 * @changelog
 * <ul>
 *     <li>2024-10-12: 최초 생성</li>
 *     <li>2024-10-12: 타이틀 패널 생성 및 구성</li>
 *     <li>2024-10-13: 패널 배경색 설정</li>
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
     * @lastModified 2024-10-12
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-12: 타이틀 패널 추가</li>
     *     <li>2024-10-13: 메인 패널 추가 및 배경색 설정</li>
     * </ul>
     *
     * @see <a href="https://blog.naver.com/highkrs/220544498754">색상 설정 참고</a>
     */
    CalculatorPanel() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Constants.CALCULATOR_BACGROUND);

        createTitlePanel();

        mainPanel.add(titlePanel, BorderLayout.NORTH);

        add(mainPanel);
    }

    /**
     * {@code titlePanel}은 계산기의 종류를 표시해주는 패널.
     *
     * @author seolheun5(김은성, priberius5@gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-12
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     *     <li>2024-10-12: 타이틀 레이아웃 생성 및 설정</li>
     *     <li>2024-10-13: 타이틀 패널 배경색 설정</li>
     * </ul>
     */
    private void createTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Constants.CALCULATOR_BACGROUND);

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
     * @lastModified 2024-10-12
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     * </ul>
     */
    private void createResultPanel() {

    }

    /**
     *
     *
     * @author seolheun5(김은성, priberius5 @ gmail.com)
     *
     * @created 2024-10-12
     * @lastModified 2024-10-12
     *
     * @changelog
     * <ul>
     *     <li>2024-10-12: 최초 생성</li>
     * </ul>
     */
    private void createButtonPanel() {

    }
}
