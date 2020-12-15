package com.nt.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrameGUITest extends JFrame  implements ActionListener,WindowListener{
	private static final String  GET_STUDENTS="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private JLabel  lsno,lsname,lsadd,lavg;
	private JTextField  tsno,tsname,tsadd,tavg;
	private JButton  bFirst ,bNext,bPrevious,bLast;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ScrollFrameGUITest() {
		System.out.println("ScrollFrameTest:: 0-param constructor");
		setTitle("Scroll Frame");
		setSize(400,300);
		setLayout(new FlowLayout());
		//add comps
		lsno=new JLabel("sno::");
		add(lsno);
		tsno=new JTextField(10);
		add(tsno);
		
		lsname=new JLabel("sname::");
		add(lsname);
		tsname=new JTextField(10);
		add(tsname);
		
		lsadd=new JLabel("sadd::");
		add(lsadd);
		tsadd=new JTextField(10);
		add(tsadd);
		
		lavg=new JLabel("avg::");
		add(lavg);
		tavg=new JTextField(10);
		add(tavg);
		
		bFirst=new JButton("first");
		add(bFirst);
		bNext=new JButton("next");
		add(bNext);
		bPrevious=new JButton("previous");
		add(bPrevious);
		bLast=new JButton("last");
		add(bLast);
		//link  Current class obj as the ActionListenr for the 4 Button comps
		bFirst.addActionListener(this);
		bNext.addActionListener(this);
		bPrevious.addActionListener(this);
		bLast.addActionListener(this);
		
		//disable editing on text boxes
		tsno.setEditable(false);
		tsname.setEditable(false);
		tsadd.setEditable(false);
		tavg.setEditable(false);
		
		//add WindowListener to Frame
		this.addWindowListener(this);
		
		//make visiblity true
		setVisible(true);
		//set DefaultClose Operation to Application exit operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initializeJdbc();
	}
	
  private  void initializeJdbc() {
	  System.out.println("ScrollFrameTest.initializeJdbc()");
	  try {
		  //estblish the connection
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		  //create JDBC PreparedStatement obj
		  ps=con.prepareStatement(GET_STUDENTS,
				                                                ResultSet.TYPE_SCROLL_SENSITIVE,
				                                                ResultSet.CONCUR_UPDATABLE);
		  //crreate Scrollable ResultSet obj
		  rs=ps.executeQuery();
		  
	  }//try
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
	
	
	public static void main(String[] args) {
		System.out.println("start of ScrollFrameTest.main()");
		  new ScrollFrameGUITest();  //anonymous object  (Object with out name)
		  System.out.println("end  of ScrollFrameTest.main()");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	  System.out.println("ScrollFrameGUTTest.actionPerformed(-)");
	  boolean flag=false;
	    if(ae.getSource()==bFirst) {
	    	System.out.println("first button");
	    	  try {
	    		  rs.first();
	    		  flag=true;
	    	  }
	    	  catch(SQLException se) {
	    		  se.printStackTrace();
	    	  }
	    }
	    else if(ae.getSource()==bNext) {
	    	  System.out.println("next button");
	    	  try {
	    	  if(!rs.isLast()) {
	    		  rs.next();
	    		  flag=true;
	    	  }
	    	  }//try
	    	  catch(SQLException se) {
	    		  se.printStackTrace();
	    	  }
	    	  
	    }
	    else if(ae.getSource()==bPrevious) {
	    	System.out.println("previous Button");
	    	try {
	    		if(!rs.isFirst()) {
	    			rs.previous();
	    			flag=true;
	    		}
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    }
	    else {
	    	System.out.println("Last button");
	    	try {
	    		rs.last();
	    		flag=true;
	    	}//try
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    	}
	    }//else
	    
	    //write record values  to  text boxes
	    try {
	   
	    if(flag) {
	    	  tsno.setText(rs.getString(1));
    		  tsname.setText(rs.getString(2));
    		  tsadd.setText(rs.getString(3));
    		  tavg.setText(rs.getString(4));
	      }
	    }
	    catch(SQLException se) {
	    	se.printStackTrace();
	    }
		
	}//actionPerfromed(-)

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("ScrollFrameGUTTest.windowClosing()");
		//close jdbc objs
		try {
			if(rs!=null)
				rs.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}//windowClosing(-)

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}//class
