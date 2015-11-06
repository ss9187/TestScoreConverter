import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class ConversionLogic 
{

    public final void actionPerformed2(final JTextField ieltsscore,final JTextField toeflscore)
    {
    	ieltsscore.getInputMap().put(KeyStroke.getKeyStroke('\b'), "clear");
        ieltsscore.getActionMap().put("clear", new AbstractAction() {

            public void actionPerformed(ActionEvent e)
            {
                toeflscore.setText("");
            	ieltsscore.setText("");
            }

            private static final long serialVersionUID = 1L;
            
        }
);
    }


public final String scoreconversion(final JTextField ieltsscore,final JTextField toeflscore)
{

String string2 = ieltsscore.getText();
Double stringDoubleValue=null;
if(string2.equalsIgnoreCase(""))
{
	String Message= "Please enter a valid IELTS score";
	return Message;
    // JOptionPane.showMessageDialog(this, "Please enter a valid IELTS score");
    // return;
}
try
{
    stringDoubleValue = Double.parseDouble(string2);
    if(stringDoubleValue > 9D)
    {
    	String Message= "Please enter a score less than or equal to 9.0";
    	return Message;
        //JOptionPane.showMessageDialog(this, "Please enter a score less than or equal to 9.0");
        //return;
    }
}
catch(NumberFormatException e)
{
	String Message= "Please enter a valid IELTS score";
	return Message;
    //JOptionPane.showMessageDialog(this, "Please enter a valid IELTS score");
    // return;
}
HashMap<Double, String> hmap = new HashMap<Double, String>();
hmap.put(Double.valueOf(0.0D), "0");
hmap.put(Double.valueOf(0.5D), "0");
hmap.put(Double.valueOf(1.0D), "0");
hmap.put(Double.valueOf(1.5D), "0");
hmap.put(Double.valueOf(2D), "31");
hmap.put(Double.valueOf(2.5D), "31");
hmap.put(Double.valueOf(3D), "31");
hmap.put(Double.valueOf(3.5D), "31");
hmap.put(Double.valueOf(4D), "31");
hmap.put(Double.valueOf(4.5D), "34");
hmap.put(Double.valueOf(5D), "45");
hmap.put(Double.valueOf(5.5D), "59");
hmap.put(Double.valueOf(6D), "78");
hmap.put(Double.valueOf(6.5D), "93");
hmap.put(Double.valueOf(7D), "101");
hmap.put(Double.valueOf(7.5D), "109");
hmap.put(Double.valueOf(8D), "114");
hmap.put(Double.valueOf(8.5D), "117");
hmap.put(Double.valueOf(9D), "120");

if(hmap.get(Double.valueOf(stringDoubleValue)) != null)
{
    toeflscore.setText((String)hmap.get(Double.valueOf(stringDoubleValue)));
} else
{
	String Message= "Please enter integers or floating point numbers that end with 0.5";
	return Message;
	//JOptionPane.showMessageDialog(this, "Please enter integers or floating point numbers that end with 0.5");
    // return;
}

return null;
} }
