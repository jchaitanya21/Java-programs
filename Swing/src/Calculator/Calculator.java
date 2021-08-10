package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.lang.*;
class Calculator extends JFrame implements ActionListener
{
    JButton b[] = new JButton[10];
    JButton b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
    JTextField ans;
    String op;
    int i,r,n1,n2;
    
    
    Calculator()
    {
        super("Calculator");
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        //setLayout( new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,4,5,5));
        p.setBorder(new EmptyBorder(10,10,10,10));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBorder(new EmptyBorder(10,10,10,10));
        
        for(int i=0;i<=9;i++)
        {
            b[i] = new JButton(i+" ");
            p.add(b[i]);
            b[i].addActionListener(this);
        }
        b10 = new JButton("+");
        p.add(b10);
        b10.addActionListener(this);
        
        b11 = new JButton("-");
        p.add(b11);
        b11.addActionListener(this);
        
        b12 = new JButton("*");
        p.add(b12);
        b12.addActionListener(this);
        
        b13 = new JButton("/");
        p.add(b13);
        b13.addActionListener(this);
        
        b14 = new JButton("%");
        p.add(b14);
        b14.addActionListener(this);
        
        b15 = new JButton("X^2");
        p.add(b15);
        b15.addActionListener(this);
        
        b16 = new JButton("sqrt");
        p.add(b16);
        b16.addActionListener(this);
        
        b17 = new JButton("log");
        p.add(b17);
        b17.addActionListener(this);
        
        b18 = new JButton("pow");
        p.add(b18);
        b18.addActionListener(this);
        
        b19 = new JButton("sin");
        p.add(b19);
        b19.addActionListener(this);
        
        b20 = new JButton("cos");
        p.add(b20);
        b20.addActionListener(this);
        
        b21 = new JButton("tan");
        p.add(b21);
        b21.addActionListener(this);
        
        b22 = new JButton("=");
        p.add(b22);
        b22.addActionListener(this);
        
        b23 = new JButton("Reset");
        p.add(b23);
        b23.addActionListener(this);
        ans=new JTextField(30);
        ans.setFont(new Font("SansSerif", Font.PLAIN, 16));
        ans.setBackground(Color.white);
        ans.setBorder(BorderFactory.createLineBorder(Color.black));
        ans.setPreferredSize(new Dimension(200, 35));
        p1.add(ans);
        contentPane.add(p1);
        contentPane.add(p);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(p,BorderLayout.CENTER);
        //add(ans,BorderLayout.NORTH);
        setVisible(true);
        setSize(500,320);
    }
    public void actionPerformed(ActionEvent ae)
    {
        JButton pb = (JButton)ae.getSource();
        if(pb==b23)
        {
            r=n1=n2=0;
            ans.setText("");
        }
        else
        {
            if(pb==b22)
            {
                n2=Integer.parseInt(ans.getText());
  		 eval();
  		 ans.setText(""+r);
            }
            else
            {
                boolean opf = false;
                if(pb==b10)
			{ op="+";
			  opf=true;
			}
 		  if(pb==b11)
			{ op="-";opf=true;}
		  if(pb==b12)
			{ op="*";opf=true;}
		  if(pb==b13)
			{ op="/";opf=true;}
                  if(pb==b14)
			{ op="%";
			  opf=true;
			}
 		  if(pb==b15)
			{ op="X^2";opf=true;}
		  if(pb==b16)
			{ op="sqrt";opf=true;}
		  if(pb==b17)
			{ op="log";opf=true;}
                  if(pb==b18)
			{ op="pow";
			  opf=true;
			}
 		  if(pb==b19)
			{ op="sin";opf=true;}
		  if(pb==b20)
			{ op="cos";opf=true;}
		  if(pb==b21)
			{ op="tan";opf=true;}
                  if(opf==false)
		  {
  		   for(i=0;i<10;i++)
		   {
		  	if(pb==b[i])
     		  	{
           	   	String t=ans.getText();
           		t+=i;
            		ans.setText(t);
		  	}
                   }
                  }
                  else
                  {
                      n1=Integer.parseInt(ans.getText());
     			ans.setText("");
                  }
            }  
        }
    }
    int eval()
{
	switch(op)
	{
        case"+":   r=n1+n2;  break;
 	case "-":    r=n1-n2;  break;
 	case "*":    r=n1*n2; break;
 	case "/":    r=n1/n2; break;
        case "%":    r=n1%n2; break;
        case "X^2":  r=n1*n1; break;
        case "sqrt": r=(int) Math.sqrt(n1); break;
        case "log": r=(int) Math.log(n1); break;
        case "pow": r=(int) Math.pow(n1, n2); break;
        case "sin": r=(int) Math.sin(n1); break;
        case "cos": r=(int) Math.cos(n1); break;
        case "tan": r=(int) Math.tan(n1); break;
	}
	return 0;
}

    public static void main(String args[])
    {
        Calculator C = new Calculator();
        C.setVisible(true);
    }
  
   
    
}
