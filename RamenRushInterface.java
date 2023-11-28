package RR;

import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *This is a an app that emulates a menu, cart and receipt builder for a ramen restaurant
 *
 *The idea is to be a sale system that one would use on a Ipad
 *
 *you can add and delete items to/from cart. See your total, and input how much you or 
 *the cusomter is gonna pay, then see change and print receipt.
 *
 * @author Kyle Blunt and Su Man
 */
public class RamenRushInterface extends javax.swing.JFrame {
	
    private static final long serialVersionUID = 1L;
    //declares the variables 
   
    private javax.swing.JButton Item1Button; // item buttons for each of our dishes, represented by icons.
    private javax.swing.JButton Item2Button;
    private javax.swing.JButton Item3Button;
    private javax.swing.JButton Item6Button;
    private javax.swing.JButton Item5Button;
    private javax.swing.JButton Item4Button;
    private javax.swing.JButton Item9Button;
    private javax.swing.JButton Item8Button;
    private javax.swing.JButton Item7Button;
    private javax.swing.JLabel ItemL1; //directly under our item buttons, representing the names of our dishes.
    private javax.swing.JLabel ItemL2;
    private javax.swing.JLabel ItemL3;
    private javax.swing.JLabel ItemL4;
    private javax.swing.JLabel ItemL5;
    private javax.swing.JLabel ItemL6;
    private javax.swing.JLabel ItemL7;
    private javax.swing.JLabel ItemL8;
    private javax.swing.JLabel ItemL9;
    private JLabel a1; // this is the amount added to our cart, increased with each click.
    private JLabel a2;
    private JLabel a3;
    private JLabel a4;
    private JLabel a5;
    private JLabel a6;
    private JLabel a7;
    private JLabel a8;
    private JLabel a9;
    private javax.swing.JLabel TotalLabel;// This is "Total :"
    private javax.swing.JLabel TotalPrice;// actual calculation of the total price (all our items added up)
    private javax.swing.JLabel CashLabel;// this is "Cash :"
    private javax.swing.JTextField CashGiven;// text field for input of amount paid
    private javax.swing.JLabel BalanceLabel; // this is "Balance :"
    private javax.swing.JLabel bnumber; //label that represents the cashback or balance remaining on purchase
    private javax.swing.JPanel MenuPanel; // biggest and main panel containing everything but mostly for the icons and labels for our menu
    private javax.swing.JPanel CartNPrintPanel;// this contains the Cart (table) and reciept and two scroll panes for each.
    private javax.swing.JPanel CalculatorPanel;// this contains the balance, total, cash, pay button, print button, and delete button.
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton PayButton; //calculates the remaining balance or cashback depeding on Total - Cash = balance
    private javax.swing.JButton PrintButton; // creates reciept based on Cart and Pay button calculations.
    private javax.swing.JButton DeleteButton; // this will delete an item out of cart and calculations.
    private JTable cart; //table that represents our cart.
    private JTextArea eceipt; // this is a text area that is space to create our reciept
    
    
    public static void main(String args[]) {//runs the file - Main
    	   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RamenRushInterface().setVisible(true);
            }
        });
    }
    
    
	public RamenRushInterface() {
        
        Components(); // declares components
        cart.getColumnModel().getColumn(0).setPreferredWidth(30);
        cart.getColumnModel().getColumn(1).setPreferredWidth(200); // creates layout of our table         
    }
	

    /**
     * This is what builds out our window builders
     * 
     * 3 panels - menu, CartNPrint and Calculator panel
     *  
     *  Menu panel consists of =
     *   9 item buttons
     *  18 corresponding labels - 9 for names (itemL1-ItemL9) and 9 for cart amount (a1-a9)
     *
     * 	CartNPrint =
     * 	Cart Table
     * 	receipt text area
     * 	2 scrollpanes
     * 
     * Calculator Panel=
     * 2 labels for Total- Total - 00.00
     * 2 labelss for Balance- Balance - 00-000
     * 1 label and 1 textfield for cash - Cash - [     ]
     * 3 buttons
     * delete button
     * pay button
     * print button
     * 	
     * 
     */
    private void Components() {
        Item1Button = new javax.swing.JButton();
        item1();
        
        ItemL1 = new javax.swing.JLabel();
        item1Label();
        
        Item2Button = new javax.swing.JButton();
        item2();
        
        ItemL2 = new javax.swing.JLabel();
        item2Label();
        
        Item3Button = new javax.swing.JButton();
        ItemL3 = new javax.swing.JLabel();
        item3();
        item3Label();
        
        ItemL4 = new javax.swing.JLabel();
        Item4Button = new javax.swing.JButton();
        item4();
        
        Item5Button = new javax.swing.JButton();
        ItemL5 = new javax.swing.JLabel();
        item5();
        item5Label();
        
        Item6Button = new javax.swing.JButton();
        ItemL6 = new javax.swing.JLabel();
        item6();
        item6Label();
        
        Item7Button = new javax.swing.JButton();
        ItemL7 = new javax.swing.JLabel();
        item7();
        
        ItemL8 = new javax.swing.JLabel();
        Item8Button = new javax.swing.JButton();
        item8();
        
        Item9Button = new javax.swing.JButton();
        ItemL9 = new javax.swing.JLabel();
        item9();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(cart);
        
        jScrollPane2 = new javax.swing.JScrollPane();
      
        TotalLabel = new javax.swing.JLabel();
        TotalPrice = new javax.swing.JLabel();
        total();
        
        CashLabel = new javax.swing.JLabel();
        CashLabel.setForeground(Color.RED);
        CashGiven = new javax.swing.JTextField();
        CashGiven.setBackground(Color.LIGHT_GRAY);
        cash(); 
        
        BalanceLabel = new javax.swing.JLabel();
        
        balance();
 
        PayButton = new javax.swing.JButton();
        pay();
        
        PrintButton = new javax.swing.JButton();
        print();
        
        DeleteButton = new javax.swing.JButton();
        delete();
       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      
        CalculatorPanel = new javax.swing.JPanel();
        javax.swing.GroupLayout gl_CalculatorPanel = calculatorPanel();
        CalculatorPanel.setLayout(gl_CalculatorPanel);
        
        getContentPane().setLayout(new BorderLayout(0, 0));

        CartNPrintPanel = new javax.swing.JPanel();
        javax.swing.GroupLayout gl_CartNPrintPanel = cartAndPrintPanel();
        CartNPrintPanel.setLayout(gl_CartNPrintPanel);
        
        eceipt = new JTextArea();
        jScrollPane2.setViewportView(eceipt);
        receipt();
        
        cart = new JTable();
        jScrollPane1.setColumnHeaderView(cart);
        shoppingCart();
	
        a1 = new JLabel("0");
        a1.setForeground(Color.LIGHT_GRAY);
        a1.setHorizontalAlignment(SwingConstants.CENTER);
        
        a2 = new JLabel("0");
        a2.setForeground(Color.LIGHT_GRAY);
        a2.setHorizontalAlignment(SwingConstants.CENTER);
        
        a3 = new JLabel("0");
        a3.setHorizontalAlignment(SwingConstants.CENTER);
        a3.setForeground(Color.LIGHT_GRAY);
        
        a4 = new JLabel("0");
        a4.setHorizontalAlignment(SwingConstants.CENTER);
        a4.setForeground(Color.LIGHT_GRAY);
        
        a5 = new JLabel("0");
        a5.setHorizontalAlignment(SwingConstants.CENTER);
        a5.setForeground(Color.LIGHT_GRAY);
        
        a6 = new JLabel("0");
        a6.setHorizontalAlignment(SwingConstants.CENTER);
        a6.setForeground(Color.LIGHT_GRAY);
        
        a7 = new JLabel("0");
        a7.setHorizontalAlignment(SwingConstants.CENTER);
        a7.setForeground(Color.LIGHT_GRAY);
        
        a8 = new JLabel("0");
        a8.setHorizontalAlignment(SwingConstants.CENTER);
        a8.setForeground(Color.LIGHT_GRAY);
        
        a9 = new JLabel("0");
        a9.setHorizontalAlignment(SwingConstants.CENTER);
        a9.setForeground(Color.LIGHT_GRAY);
        
        MenuPanel = new javax.swing.JPanel();
        javax.swing.GroupLayout gl_MenuPanel = menuPanel();
        MenuPanel.setLayout(gl_MenuPanel);
        getContentPane().add(MenuPanel);
        
        JLabel TitleLabel = new JLabel("Welcome to Ramen Rush!!");
        title(TitleLabel);
        getContentPane().add(TitleLabel, BorderLayout.NORTH);
       
        pack();
    } // end to components


    	/**
    	 * builds the table for our Cart.
    	 * adds font and 
    	 * string for ID item QTY and Price
    	 */
    	private void shoppingCart() {
    		cart.setFont(new Font("Arial Black", Font.PLAIN, 15)); 
    		cart.setModel(new javax.swing.table.DefaultTableModel(
    				new Object [][] {

    				},
    				new String [] {
    						"ID", "Item", "Qty", "Price"
    				}
    				));
    		cart.addMouseListener(new java.awt.event.MouseAdapter() {
    			public void mouseClicked(java.awt.event.MouseEvent evt) {
    				cartMouseClicked(evt);
    			}
    		});
    	}
    	
    /**
     * creates layout and fonts of our title label	
     * @param TitleLabel
     */
	private void title(JLabel TitleLabel) {
		TitleLabel.setOpaque(true);
        TitleLabel.setBackground(Color.BLACK);
        TitleLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 27));
        TitleLabel.setForeground(Color.RED);
        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	 /**
	  * This will create a format for the price and then
	  * 
	  * use an eguation of quantity * price = total price of items if more than one.
	  * 
	  * This then creates layout and parameters for the table we will be using for our cart using vectors
	  * 
	  * @param id- id of the item or item number
	  * @param Name- description of item ordered
	  * @param Qty - amount of item your gonna purchase
	  * @param Price- total price of item( so if one item @ 4.99 it will display 4.99, but 2 will display 9.98
	  */
    public void addtables(int id ,String Name,int Qty ,Double Price){
        
		DefaultTableModel tableM = (DefaultTableModel) cart.getModel();
    
		DecimalFormat format = new DecimalFormat("00.00") ;       
		double totalPrice = Price * Double.valueOf(Qty) ;
   
		String TotalPrice = format.format(totalPrice);
    
    
			for (int row = 0; row < cart.getRowCount(); row++) {
        
					if (Name == cart.getValueAt(row, 1)) {
            
					tableM.removeRow(cart.convertRowIndexToModel(row));
            
					} 
			}
			
		Vector vector = new Vector();
    
		vector.add(id);
		vector.add(Name);
		vector.add(Qty);
		vector.add(TotalPrice); // total price
    
		tableM.addRow(vector);
    }


    /**
     * This will take the amount from each row and use it to get the Total of all items in cart
     * 
     * using the format for money
     */
    public void calculateTotal(){

    	int totalRows = cart.getRowCount() ;
    	double total = 0.0 ;

   			for (int i = 0; i < totalRows; i++) {
       
   				double value = Double.valueOf(cart.getValueAt(i, 3).toString());
      
   				total += value ;
       
   			}
   
   		DecimalFormat format = new DecimalFormat("00.00") ;
   		TotalPrice.setText(format.format(total));
	} 
    
    
    /**
     * delete button method
     * sets font
     * text
     * and actionListener
     */
	private void delete() {
		DeleteButton.setFont(new java.awt.Font("Arial Black", 1, 24));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
	}
	
	
	 /**
     * print button method
     * sets font
     * text
     * and actionListener
     */
	private void print() {
		PrintButton.setFont(new java.awt.Font("Arial Black", 1, 38)); 
        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });
	}
	
	
	 /**
     * pay button method
     * sets font
     * text
     * and actionListener
     */
	private void pay() {
		PayButton.setFont(new java.awt.Font("Arial Black", 1, 36)); 
        PayButton.setText("Pay");
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });
	}
	
	
	 /**
     * cash button method
     * and cash label method
     * sets font
     * text
     * and actionListener
     */
	private void cash() {
		CashLabel.setFont(new java.awt.Font("Arial Black", 1, 29)); 
        CashLabel.setText("Cash :");

        CashGiven.setFont(new java.awt.Font("Arial Black", 0, 30));
	}
	
	
	 /**
     * balance button method
     * and balance lable method
     * sets font
     * text
     * and actionListener
     */
	private void balance() {
		BalanceLabel.setFont(new java.awt.Font("Arial Black", 1, 29)); 
        BalanceLabel.setText("Balance :");
        BalanceLabel.setForeground(Color.RED);
        bnumber = new javax.swing.JLabel();
        bnumber.setForeground(Color.RED);
        bnumber.setFont(new java.awt.Font("Arial Black", 1, 29)); 
        bnumber.setText("00");
	}
	
	
	 /**
     * total labels method
     * sets font
     * text
     * and actionListener
     */
	private void total() {
		TotalLabel.setFont(new Font("Arial Black", Font.BOLD, 29));
        TotalLabel.setText("Total :");
        TotalPrice.setFont(new java.awt.Font("Arial Black", 1, 29)); 
        TotalPrice.setText("00");
        TotalPrice.setForeground(Color.RED);
        TotalLabel.setForeground(Color.RED);
	}
	
	
	 /**
     * sets receipt rows and columns
     */
	private void receipt() {
		eceipt.setColumns(20);
        eceipt.setRows(5);
	}
	
	
	/**
	 * method for item 7
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item7() {
		Item7Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item8.png")));
        Item7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item7ButtonActionPerformed(evt);
            }
        });

        ItemL7.setFont(new Font("Arial Black", Font.BOLD, 18));
        ItemL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL7.setForeground(new Color(255, 51, 0));
        ItemL7.setText("Chicken Wings");
	}
	
	
	/**
	 * method for item 8
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item8() {
		ItemL8.setFont(new Font("Arial Black", Font.BOLD, 18)); // NOI18N
        ItemL8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL8.setForeground(new Color(255, 51, 0));
        ItemL8.setText("Pork Gyoza");
        Item8Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item7.png")));
        Item8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item8ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 9
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item9() {
		Item9Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item9.png"))); 
        Item9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item9ButtonActionPerformed(evt);
            }
        });

        ItemL9.setFont(new Font("Arial Black", Font.BOLD, 18)); // NOI18N
        ItemL9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL9.setText("Mochi Ice Cream");
        ItemL9.setForeground(new Color(255, 51, 0));
	}
	
	
	/**
	 * method for item 4
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 *
	 */
	private void item4() {
		ItemL4.setFont(new Font("Arial Black", Font.BOLD, 18)); // NOI18N
        ItemL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL4.setText("Chicken Wonton");
        ItemL4.setForeground(new Color(255, 51, 0));
        Item4Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item4.png")));
        Item4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item4ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 5
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item5Label() {
		ItemL5.setFont(new Font("Arial Black", Font.BOLD, 18)); 
        ItemL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL5.setText("Shrimp Wonton");
        ItemL5.setForeground(new Color(255, 51, 0));
	}

	private void item5() {
		Item5Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item5.png"))); 
        Item5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item5ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 6
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item6Label() {
		ItemL6.setFont(new Font("Arial Black", Font.BOLD, 15)); 
        ItemL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL6.setForeground(new Color(255, 51, 0));
        ItemL6.setText("Spicy Creamy Vegan");
	}

	private void item6() {
		Item6Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item6.png")));
        Item6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item6ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 3
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item3Label() {
		ItemL3.setFont(new Font("Arial Black", Font.BOLD, 18)); 
        ItemL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL3.setText("Spicy Chicken");
        ItemL3.setForeground(new Color(255, 51, 0));
	}

	private void item3() {
		Item3Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item3.png"))); 
        Item3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item3ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 2
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item2Label() {
		ItemL2.setFont(new Font("Arial Black", Font.BOLD, 16));
        ItemL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL2.setText("Tonkotsu Original");
        ItemL2.setForeground(new Color(255, 51, 0));
	}

	private void item2() {
		Item2Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item1.png")));
        Item2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item2ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * method for item 1
	 * sets icon photo
	 * and action listener
	 * sets font
	 * and horizontal alignment
	 */
	private void item1Label() {
		ItemL1.setFont(new Font("Arial Black", Font.BOLD, 18)); 
        ItemL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemL1.setText("Tonkotsu Red");
        ItemL1.setForeground(new Color(255, 51, 0));
	}

	private void item1() {
		Item1Button.setIcon(new ImageIcon(RamenRushInterface.class.getResource("/RR/item2.png"))); 
        Item1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item1ButtonActionPerformed(evt);
            }
        });
	}
	
	
	/**
	 * action for Item 1 button adds item 1 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item1ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 int i = Integer.valueOf(a1.getText());
         ++i;
         a1.setText(String.valueOf(i));
         
		 
        addtables(1, "Tktsu Red", i, 13.99);
        
        calculateTotal();
        
    }
    
    
    /**
	 * action for Item 2 button adds item 2 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item2ButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
    	 int i = Integer.valueOf(a2.getText());
         ++i;
         a2.setText(String.valueOf(i));
        addtables(2, "Org. Tnktsu ", i, 13.59);
        
        calculateTotal();
        
    }
    
    
    /**
	 * action for Item 3 button adds item 3 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item3ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
    	 int i = Integer.valueOf(a3.getText());
         ++i;
         a3.setText(String.valueOf(i));
        addtables(3, "Chick Ramen", i, 14.99);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 4 button adds item 4 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item4ButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
    	 int i = Integer.valueOf(a4.getText());
         ++i;
         a4.setText(String.valueOf(i));
        addtables(4, "Chicken W.T.", i, 11.29);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 5 button adds item 5 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item5ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 int i = Integer.valueOf(a5.getText());
         ++i;
         a5.setText(String.valueOf(i));
        
        addtables(5, "Shrimp W.T.", i, 13.19);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 6 button adds item 6 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item6ButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
    	 int i = Integer.valueOf(a6.getText());
         ++i;
         a6.setText(String.valueOf(i));
        addtables(6, "Spicy Vegan", i, 13.99);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 7 button adds item 7 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item7ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 int i = Integer.valueOf(a7.getText());
         ++i;
         a7.setText(String.valueOf(i));
        addtables(7, "Wings", i, 9.99);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 8 button adds item 8 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item8ButtonActionPerformed(java.awt.event.ActionEvent evt) {
       
    	 int i = Integer.valueOf(a8.getText());
         ++i;
         a8.setText(String.valueOf(i));
        addtables(8, "Gyoza", i, 5.99);
        
        calculateTotal();
    }
    
    
    /**
	 * action for Item 9 button adds item 9 to table
	 * and increases the guantity of each click
	 * then calculates total
	 * @param evt
	 */
    private void Item9ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 int i = Integer.valueOf(a9.getText());
         ++i;
         a9.setText(String.valueOf(i));
        addtables(9, "Mochi", i, 4.99);
        
        calculateTotal();
    }
    
    
    /**
	 * action for delete button 
	 * you first click on the row or item you want to delete
	 * then press delete button
	 * 
	 * this will delete selected row and turn the corresponding quantity label to 0.
	 * @param evt
	 */
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
           
        DefaultTableModel table = (DefaultTableModel) cart.getModel(); 
        String reset = table.getValueAt(cart.getSelectedRow(), 0).toString();
        //remove product
        int rw = cart.getSelectedRow();
        table.removeRow(rw);       
        System.out.println(reset);
        switch (reset) {
                   
                   case "1":                       
                   a1.setText("0");
                   break;
                   
                   case "2":                       
                   a2.setText("0");
                   break;
                   
                   case "3":                       
                   a3.setText("0");
                   break;
                   
                   case "4":                       
                   a4.setText("0");
                   break;
                   
                   case "5":                       
                   a5.setText("0");
                   break;
                   
                   case "6":                       
                   a6.setText("0");
                   
                   case "7":                       
                   a7.setText("0");
                   break;
                   
                   case "8":                       
                   a8.setText("0");
                   break;
                   
                   case "9":                       
                   a9.setText("0");
                   break;
                   
                   default:
                       System.out.println("over");
               }
        
        calculateTotal(); 
        
    }// closing brakcet delete button

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {
       
    }
    
    /**
     * pay button action event
     * 
     * when you select pay it will take the inputted cash value and minus the total to give you remaining 
     * balance or the cashback total
     * @param evt
     */
    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
        
        double tot = Double.valueOf(TotalPrice.getText());
        double paid = Double.valueOf(CashGiven.getText());
        double balance = paid - tot ;
                
        DecimalFormat format = new DecimalFormat("00.00") ;   
       
       
        bnumber.setText(String.valueOf(format.format(balance)));
       
    }// end to paybutton action
    
    
    /**
     * This is an event for the Print button
     * 
     * it creates a text layout of the companies receipt
     * 
     * entering in the item qty and price for every item purchased
     * 
     * as well as total
     * cash paid
     * and balance
     * @param evt
     */
    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
        
        try {
            
            eceipt.setText("                               Ramen Rush    \n");
            eceipt.setText(eceipt.getText() + "                            1220 Ash Drive, \n");
            eceipt.setText(eceipt.getText() + "                          New York, New York, \n");
            eceipt.setText(eceipt.getText() + "                           84040 8013905795, \n");
            eceipt.setText(eceipt.getText() + "---------------------------------------------------------------------\n");
            eceipt.setText(eceipt.getText() + "  Item \t\tQty \tPrice" +"\n");
            eceipt.setText(eceipt.getText() + "---------------------------------------------------------------------\n");
            
            DefaultTableModel format = (DefaultTableModel) cart.getModel();
            
           
            
            for (int i = 0; i < cart.getRowCount(); i++) {
                
                String Name = format.getValueAt(i, 1).toString();
                String Qty = format.getValueAt(i, 2).toString();
                String Price = format.getValueAt(i, 3).toString();
                
                eceipt.setText(eceipt.getText() +"  "+ Name+"\t\t"+Qty +"\t"+Price + "\n");
            }
            
            eceipt.setText(eceipt.getText() + "---------------------------------------------------------------------\n");
            eceipt.setText(eceipt.getText() + "Total     : " + TotalPrice.getText() +"\n");
            eceipt.setText(eceipt.getText() + "Cash      : " + CashGiven.getText() +"\n");
            eceipt.setText(eceipt.getText() + "Balance   : " + bnumber.getText() +"\n");
            eceipt.setText(eceipt.getText() + "---------------------------------------------------------------------\n");
            eceipt.setText(eceipt.getText() + "                     Gaurunteed Yummy Ramen!        "+"\n");
            eceipt.setText(eceipt.getText() + "---------------------------------------------------------------------\n");
       
            eceipt.setText(eceipt.getText() + "                 Dont forget to check out our website "+"\n");
            eceipt.setText(eceipt.getText() + "                            and leave a review!! "+"\n");
            eceipt.setText(eceipt.getText() + "                     Interface Built by Su and Kyle"+"\n");
        eceipt.print(); //print
            
            
        } catch (Exception e) {
            
            System.out.println(e);
            
            
        }
        
         }// end to print create action
    
    private javax.swing.GroupLayout menuPanel() {
    	MenuPanel.setBackground(Color.DARK_GRAY);
    	javax.swing.GroupLayout gl_MenuPanel = new javax.swing.GroupLayout(MenuPanel);
    	gl_MenuPanel.setHorizontalGroup(
    		gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_MenuPanel.createSequentialGroup()
    				.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(Alignment.TRAILING, gl_MenuPanel.createSequentialGroup()
    						.addContainerGap()
    						.addComponent(Item1Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
    					.addGroup(gl_MenuPanel.createSequentialGroup()
    						.addGap(14)
    						.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    							.addComponent(Item7Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    							.addComponent(Item4Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(ItemL1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addComponent(a1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
    								.addGap(14))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(ItemL4)
    								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    								.addComponent(a4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(ItemL7)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addComponent(a7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))))
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_MenuPanel.createSequentialGroup()
    						.addComponent(ItemL2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addComponent(a2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
    					.addGroup(gl_MenuPanel.createSequentialGroup()
    						.addComponent(ItemL5)
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addComponent(a5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
    					.addGroup(gl_MenuPanel.createSequentialGroup()
    						.addComponent(ItemL8, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addComponent(a8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
    					.addComponent(Item2Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    					.addComponent(Item5Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    					.addComponent(Item8Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING, false)
    						.addGroup(gl_MenuPanel.createSequentialGroup()
    							.addComponent(ItemL3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
    							.addPreferredGap(ComponentPlacement.RELATED)
    							.addComponent(a3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
    						.addGroup(gl_MenuPanel.createSequentialGroup()
    							.addComponent(ItemL6)
    							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    							.addComponent(a6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
    						.addGroup(gl_MenuPanel.createSequentialGroup()
    							.addComponent(ItemL9)
    							.addPreferredGap(ComponentPlacement.RELATED)
    							.addComponent(a9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
    					.addComponent(Item3Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    					.addComponent(Item6Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
    					.addComponent(Item9Button, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addComponent(CartNPrintPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	);
    	gl_MenuPanel.setVerticalGroup(
    		gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_MenuPanel.createSequentialGroup()
    				.addContainerGap(16, Short.MAX_VALUE)
    				.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_MenuPanel.createSequentialGroup()
    						.addGroup(gl_MenuPanel.createParallelGroup(Alignment.TRAILING, false)
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item3Button, 0, 0, Short.MAX_VALUE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.TRAILING)
    									.addComponent(Item2Button, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
    									.addComponent(Item1Button, 0, 0, Short.MAX_VALUE))
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.LEADING)
    									.addGroup(Alignment.TRAILING, gl_MenuPanel.createSequentialGroup()
    										.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    											.addComponent(ItemL1)
    											.addComponent(a1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
    										.addGap(9))
    									.addGroup(Alignment.TRAILING, gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    										.addComponent(ItemL2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    										.addComponent(a2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addGroup(gl_MenuPanel.createParallelGroup(Alignment.TRAILING)
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item6Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item5Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addComponent(ItemL5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item4Button, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
    						.addPreferredGap(ComponentPlacement.RELATED)
    						.addGroup(gl_MenuPanel.createParallelGroup(Alignment.TRAILING)
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item9Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item8Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
    							.addGroup(gl_MenuPanel.createSequentialGroup()
    								.addComponent(Item7Button, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_MenuPanel.createParallelGroup(Alignment.BASELINE)
    									.addComponent(ItemL7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
    									.addComponent(a7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
    					.addComponent(CartNPrintPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
    	);
    	return gl_MenuPanel;
    } // end to menupanel
    
    /**
	 * this creates our group layout for the calculator panel
	 * @return
	 */
	private javax.swing.GroupLayout calculatorPanel() {
		CalculatorPanel.setBackground(Color.DARK_GRAY);
		javax.swing.GroupLayout gl_CalculatorPanel = new javax.swing.GroupLayout(CalculatorPanel);
		gl_CalculatorPanel.setHorizontalGroup(
				gl_CalculatorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CalculatorPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(CashLabel)
								.addComponent(BalanceLabel)
								.addComponent(TotalLabel))
						.addGap(18)
						.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(bnumber, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
										.addComponent(CashGiven))
								.addComponent(TotalPrice, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
						.addGap(37)
						.addComponent(PayButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(PrintButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
				);
		gl_CalculatorPanel.setVerticalGroup(
				gl_CalculatorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CalculatorPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_CalculatorPanel.createSequentialGroup()
										.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(TotalPrice)
												.addComponent(TotalLabel))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(CashGiven, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(CashLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(BalanceLabel)
												.addComponent(bnumber)))
								.addGroup(gl_CalculatorPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(PrintButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(PayButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		return gl_CalculatorPanel;
	}// end to calculator panel
	
	/**
	 * this builds out the group layout for our cart and print panel
	 * @return
	 */
	private javax.swing.GroupLayout cartAndPrintPanel() {
		CartNPrintPanel.setBackground(Color.BLACK);
		javax.swing.GroupLayout gl_CartNPrintPanel = new javax.swing.GroupLayout(CartNPrintPanel);

		gl_CartNPrintPanel.setHorizontalGroup(
				gl_CartNPrintPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_CartNPrintPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_CartNPrintPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(DeleteButton)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(10, Short.MAX_VALUE))
				.addGroup(gl_CartNPrintPanel.createSequentialGroup()
						.addComponent(CalculatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		gl_CartNPrintPanel.setVerticalGroup(
				gl_CartNPrintPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gl_CartNPrintPanel.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_CartNPrintPanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane2)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(CalculatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18))
				);
		return gl_CartNPrintPanel;
	}//end to cartNPrintPanel
	
}// end to program (ramenrushinterface)
