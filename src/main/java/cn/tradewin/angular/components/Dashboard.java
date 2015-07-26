package cn.tradewin.angular.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;


public class Dashboard {
	
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;
	
	@Inject
    private JavaScriptSupport javaScriptSupport;
	
	void afterRender() {
		
	}
}