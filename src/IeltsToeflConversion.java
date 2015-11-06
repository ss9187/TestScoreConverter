

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class IeltsToeflConversion extends JFrame implements ActionListener
{

    public IeltsToeflConversion()
    {
        setTitle("Unoffical IELTS->TOEFL Converter");
        BufferedImage myPicture = null;
        try
        {
            myPicture = ImageIO.read(new File("LightBolt.jpg"));
            picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(90, 85, 2)));
            add(picLabel);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        Container container = getContentPane();
        getContentPane().setLayout(null);
        IYOE.setBounds(5, 5, 80, 20);
        ieltsscore.setBounds(90, 5, 150, 20);
        add.setBounds(5, 30, 80, 20);
        toeflscore.setBounds(90, 30, 150, 20);
        toeflscore.setEnabled(false);
        toeflscore.setDisabledTextColor(Color.BLUE);
        equals.setBounds(5, 60, 90, 30);
        equals.addActionListener(this);
        exit.setBounds(150, 60, 90, 30);
        exit.addActionListener(this);
        picLabel.setBounds(260, 5, 90, 85);
        container.add(IYOE);
        container.add(ieltsscore);
        container.add(add);
        container.add(toeflscore);
        container.add(equals);
        container.add(exit);
        container.add(picLabel);
        setDefaultCloseOperation(3);
        setSize(365, 124);
        setResizable(false);
        setLocation(200, 100);
        setVisible(true);
        
    }



    public final void actionPerformed(ActionEvent actionEvent)
    {
        String string = actionEvent.getActionCommand();
        if(string.equals("Exit"))
        {
            setVisible(false);
            System.exit(0);
        } else
        if(string.equals("Convert"))
        {
        	ConversionLogic l1=new ConversionLogic();
        	String Message=l1.scoreconversion(ieltsscore, toeflscore);
        	if(Message!=null)
        	JOptionPane.showMessageDialog(this, Message);
        	
        }
    }

    public static final void main(String arrstring[])
    {
        IeltsToeflConversion cM1 = new IeltsToeflConversion();
        ConversionLogic cM2=new ConversionLogic();
        cM2.actionPerformed2(ieltsscore,toeflscore);
    }

    private static JLabel IYOE = new JLabel("IELTS-Score:");
    private static JLabel add = new JLabel("TOEFL-Score:");
    private static JTextField ieltsscore = new JTextField();
    private static JTextField toeflscore = new JTextField();
    private static JButton equals = new JButton("Convert");
    private static JButton exit = new JButton("Exit");
    private static JLabel picLabel = null;



}
