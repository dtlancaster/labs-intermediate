
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator
{
    private JFrame jframe;
    private JButton addButton;
    private JButton subButton;
    private JButton multButton;
    private JButton divButton;
    private JLabel resultLabel;
    private JTextField leftOperand;
    private JTextField rightOperand;
    private JPanel buttonPanel;
    private JPanel resultPanel;
    private JPanel inputPanel;
    private JLabel jlResult;
    
    private final static int DIMENSION = 400;
    
    private enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }
    
    public Calculator()
    {
        jframe = new JFrame();
        jframe.setLocation(100, 100);
        jframe.setSize(DIMENSION, DIMENSION);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("Calculator");
        
        initComponents();
        
        jframe.pack();
        jframe.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Calculator();
    }
    
    public JFrame getFrame()
    {
        return this.jframe;
    }
    
    public void initComponents()
    {
        addButton = new JButton("ADD");
        addButton.setName("addButton");        
        
        subButton = new JButton("SUB");
        subButton.setName("subButton");
        
        multButton = new JButton("MULT");
        multButton.setName("multButton");
        
        divButton = new JButton("DIV");
        divButton.setName("divButton");
        
        resultLabel = new JLabel(" ");
        resultLabel.setName("resultLabel");
        
        jlResult = new JLabel("Result = ");
        jlResult.setName("jlResult");
        
        leftOperand = new JTextField(10);
        leftOperand.setName("leftOperand");
        
        rightOperand = new JTextField(10);
        rightOperand.setName("rightOperand");     
        
        addPanel();
        addActionListeners();
    }
    
    public void addPanel()
    {
        buttonPanel = new JPanel();
        resultPanel = new JPanel();
        inputPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);
        resultPanel.add(jlResult);
        resultPanel.add(resultLabel);
        inputPanel.add(leftOperand);
        inputPanel.add(rightOperand);
        
        jframe.add(inputPanel, BorderLayout.PAGE_START);
        jframe.add(resultPanel, BorderLayout.WEST);
        jframe.add(buttonPanel, BorderLayout.PAGE_END);
    }
    
    public void addActionListeners()
    {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                operation(Operation.ADD);
            }
        });
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                operation(Operation.SUBTRACT);
            }
        });
        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                operation(Operation.MULTIPLY);
            }
        });
        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                operation(Operation.DIVIDE);
            }
        });
    }
    
    public void operation(Operation op)
    {
        String first = leftOperand.getText();
        String second = rightOperand.getText();
        
        double num1;
        double num2;
        double result = 0.0;
        
        if (first.trim().matches("[0-9.-]+") 
            && second.trim().matches("[0-9.-]+"))
        {
            num1 = Double.parseDouble(first);
            num2 = Double.parseDouble(second);
            
            if (num2 == 0.0 && op == Operation.DIVIDE)
            {
                resultLabel.setText("Error");
            }
            else {
                switch (op) {
                    case ADD:
                        result = num1 + num2;
                        break;
                    case SUBTRACT:
                        result = num1 - num2;
                        break;
                    case MULTIPLY:
                        result = num1 * num2;
                        break;
                    case DIVIDE:
                        result = num1 / num2;
                        break;
                }
                
                resultLabel.setText("" + result);
            }
        }
        else
        {
            resultLabel.setText("Error");
        }
    }
}

