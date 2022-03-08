// Cole Delong
// window for Wordle clone
// 3-4-22


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;


public class WordleFrame extends JFrame
{

    // event handler object
    WordleEventHandler event_handler = new WordleEventHandler(this);

    // rectangle object to contain the window dimensions
    Rectangle dimensions;

    // grid layouts
    BorderLayout layout = new BorderLayout();
    FlowLayout layout0 = new FlowLayout(FlowLayout.CENTER);
    GridLayout layout1 = new GridLayout(6, 5, 10, 10);
    FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
    
    // borders
    Border border0;
    Border border1;
    Border border2;
    Border letter_border;

    // jpanels
    JPanel row0 = new JPanel();
    JPanel row1 = new JPanel();
    JPanel row2 = new JPanel();
    
    // top jpanel: title
    JLabel title = new JLabel();

    // middle jpanel: guess grid
    JLabel[][] grid = new JLabel[6][5];

    // bottom jpanel: inputs
    JTextField input_field = new JTextField(6);
    JButton submit_button = new JButton();


    // frame constructor
    public WordleFrame()
    {

        // initialize window
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("   Wordle");
        setLookAndFeel();
        setSize(400, 550);

        // window dimensions
        dimensions = this.getBounds();

        // layouts
        setLayout(layout);
        row0.setLayout(layout0);
        row1.setLayout(layout1);
        row2.setLayout(layout2);

        // borders
        border0 = BorderFactory.createEmptyBorder(10, 0, 10, 0);
        border1 = BorderFactory.createEmptyBorder(10, dimensions.width/12, 5, dimensions.width/12);
        border2 = BorderFactory.createEmptyBorder(10, 0, 20, 0);
        letter_border = BorderFactory.createLineBorder(new Color(200, 200, 200), 2);
        row0.setBorder(border0);
        row1.setBorder(border1);
        row2.setBorder(border2);

        // backgrounds
        row0.setBackground(Color.white);
        row1.setBackground(Color.white);
        row2.setBackground(Color.white);


        // top jpanel: title
        title.setText("Wordle");
        title.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        row0.add(title);

        // middle jpanel: guess grid
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = new JLabel();
                grid[i][j].setOpaque(true);
                grid[i][j].setBackground(new Color(255, 255, 255));
                grid[i][j].setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
                grid[i][j].setHorizontalAlignment(JLabel.CENTER);
                grid[i][j].setBorder(letter_border);
                row1.add(grid[i][j]);
            }

        }

        // bottom jpanel: inputs
        input_field.addKeyListener(event_handler);
        input_field.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        submit_button.addActionListener(event_handler);
        submit_button.setText("Guess");
        submit_button.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        row2.add(input_field);
        row2.add(submit_button);        


        // add panels to window
        add(row0, BorderLayout.NORTH);
        add(row1, BorderLayout.CENTER);
        add(row2, BorderLayout.SOUTH);

        // make the window visible
        setVisible(true);

    }

    public static void main (String[] args)
    {

        new WordleFrame();

    }

    // a method that sets the look and feel of the window with error handling
    private void setLookAndFeel()
    {
        try 
        {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        }
        catch (Exception exc)
        {
            // ignore error
        }
    }
    
}