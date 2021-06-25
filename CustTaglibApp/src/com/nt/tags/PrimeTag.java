package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeTag extends TagSupport {
	private String uptoRange;
		
	public String getUptoRange() {
		return uptoRange;
	}

	public void setUptoRange(String uptoRange) {
		this.uptoRange = uptoRange;
	}

	@Override
	public int doStartTag() throws JspException {
		int uptoRange=10;
		int totalPrime=0;
		if(this.uptoRange!=null)
			uptoRange = Integer.parseInt(this.uptoRange);
		
		try {
			pageContext.getOut().write("<h1>Prime Numbers 1 to "+uptoRange+"</h1>");
			for (int i = 1; i < uptoRange; i++) {
				if(isPrime(i)) {
					pageContext.getOut().write("<h6>"+i+"</h6>");
					totalPrime++;
				}
			}//for
			pageContext.getOut().write("<h2 style='color:blue'> Total number of Primes:: "+totalPrime+"</h2>");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error In MessageTag.class");
		}
		return SKIP_BODY;
	}//doStart
		
	@Override
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}//doEnd

	static boolean isPrime(int number){
		if(number==0 || number ==1)
			return false;
		else if(number==2 || number==3 || number==5 || number==7)
			return true;
		else if(number%2!=0 && number%3!=0 && number%5!=0 && number%7!=0) 
			return true;
		else
			return false;
	}
	
	
}//class
