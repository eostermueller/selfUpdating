package com.github.eostermueller;

import java.util.Map;
import java.util.SortedMap;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

public class LiveUpdateLabel extends Label {

	public LiveUpdateLabel(String id) {
		super(id, new LiveUpdateModel() );
	}
	private static final long _1L = 98749871L;
	/**
	 * 
	 */
	private static final long serialVersionUID = _1L;
	
	private static class LiveUpdateModel extends AbstractReadOnlyModel<String>  {

		private LiveUpdateModel() {
		}
		@Override
		public String getObject() {
			return ""+System.currentTimeMillis();
		}
		
	}

}
