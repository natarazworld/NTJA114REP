package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {

	private String family;
	private String size;
		
	
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println();
		System.out.println("family:: "+family);
		System.out.println("size:: "+size);
		
		try {
			pageContext.getOut().write("<span style='color:red; font-family:"+family+";  font-size:"+size+";'>");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error In DisplayTag.class");
		}
		return EVAL_BODY_INCLUDE;
	}//doStart
		
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("</span>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}//doEnd

}//class
