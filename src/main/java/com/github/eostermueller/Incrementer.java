package com.github.eostermueller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Incrementer extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
    {
		AtomicInteger myCounter = (AtomicInteger) req.getServletContext().getAttribute(WicketApplication.MY_COUNTER);
		int myNewCounter = myCounter.incrementAndGet();
		resp.getOutputStream().print("New count is [" + myNewCounter + "]");
    }
}
