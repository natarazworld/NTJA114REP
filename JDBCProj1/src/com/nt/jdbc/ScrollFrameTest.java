package com.nt.jdbc;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrameTest extends JFrame {
	private static final String  GET_STUDENTS="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private JLabel  lsno,lsname,lsadd,lavg;
	private JTextField  tsno,tsname,tsadd,tavg;
	private JButton  bFirst ,bNext,bPrevious,bLast;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ScrollFrameTest() {
		System.out.println("ScrollFrameTest:: 0-param constructor");
		setTitle("Scroll Frame");
		setSize(400, 500);
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
		  new ScrollFrameTest();  //anonymous object  (Object with out name)
		  System.out.println("end  of ScrollFrameTest.main()");
	}

}
