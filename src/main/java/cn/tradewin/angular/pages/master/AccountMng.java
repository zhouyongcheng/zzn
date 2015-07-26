package cn.tradewin.angular.pages.master;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class AccountMng {
	
	@Inject
    private JavaScriptSupport javaScriptSupport;
	
	void afterRender() {
		javaScriptSupport.require("apps/account/main");
	}
}
