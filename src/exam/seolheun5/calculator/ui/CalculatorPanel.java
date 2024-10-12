package exam.seolheun5.calculator.ui;

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
 * </ul>
 */
public class CalculatorPanel extends JPanel {
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
     * </ul>
     */
    CalculatorPanel() {
        setLayout(new BorderLayout());

        createTitlePanel();

        add(titlePanel, BorderLayout.NORTH);
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
     * </ul>
     */
    private void createTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Standard", SwingConstants.LEFT);
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
