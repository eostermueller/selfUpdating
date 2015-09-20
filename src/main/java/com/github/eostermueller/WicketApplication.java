package com.github.eostermueller;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.github.eostermueller.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	 public static final String MY_COUNTER = "my.counter";
	Timer timer;
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}
//    class IncrementTask extends TimerTask {
//        public void run() {
//        	getCounter().incrementAndGet();
//        }
//    }
    public AtomicInteger getCounter() {
		ServletContext servletContext = WebApplication.get().getServletContext();
		AtomicInteger myCounter = (AtomicInteger) servletContext.getAttribute(MY_COUNTER);
    	return myCounter;
    }
    private void setCounter(AtomicInteger val) {
		ServletContext servletContext = WebApplication.get().getServletContext();
		servletContext.setAttribute(MY_COUNTER, val);
    }
    
	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		
		ServletContext servletContext = WebApplication.get().getServletContext();
		AtomicInteger myCounter = new AtomicInteger(23);
		setCounter(myCounter);
		
//        timer = new Timer();
//        timer.schedule(new IncrementTask(), 0, 1000);//increment every second		
		// add your configuration here
	}
}
