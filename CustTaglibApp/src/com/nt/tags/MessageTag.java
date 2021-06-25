package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write("<h1>Hello</h1>");
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

}//class
