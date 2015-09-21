package com.github.eostermueller;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		
		Object o = this.getApplication();
		if (o instanceof WicketApplication) {
			WicketApplication w = (WicketApplication)o;
			
//			add(new Label("myCounter", w.getCounter().get() ));     		// BROKEN
			
			AbstractReadOnlyModel<Integer> counterModel 					// FIXED
				= new AbstractReadOnlyModel<Integer>() {					// FIXED
				  	@Override 												// FIXED
		             public Integer getObject() 							// FIXED
		             { 														// FIXED
		                 Object o = getApplication(); 						// FIXED
		                 if (o instanceof WicketApplication) { 				// FIXED
		                     WicketApplication w = (WicketApplication)o; 	// FIXED
		                     return w.getCounter().get(); 					// FIXED
		                 } 													// FIXED
		                 return null; 										// FIXED
		             } 														// FIXED
			};																// FIXED
			add( new Label("myCounter", counterModel ) );					// FIXED
			
		}
		System.out.println("Found wicket application [" + o.getClass().getCanonicalName() + "]");

		LiveUpdateLabel label = new LiveUpdateLabel("liveUpdate");
        add(label);

        // add the ajax behavior which will keep updating the component every 5
        // seconds
        label.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
		
		
		//
		
		// TODO Add your page's components here

    }
}
