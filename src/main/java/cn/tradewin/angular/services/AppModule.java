package cn.tradewin.angular.services;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ScopeConstants;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Scope;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;
import org.tynamo.resteasy.ResteasySymbols;

import cn.tradewin.angular.commons.AngularSymbolConstants;
import cn.tradewin.angular.persist.services.AccountService;
import cn.tradewin.angular.persist.services.DepartmentService;
import cn.tradewin.angular.persist.services.impl.AccountServiceImpl;
import cn.tradewin.angular.persist.services.impl.DepartmentServiceImpl;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AppModule {
	
	private final Logger log;

	public AppModule(ApplicationGlobals globals, Logger log) {
		this.log = log;
	}

	/**
	 * get SqlSessionFactory by mybatis.
	 * 
	 * @param log
	 * @return
	 */
	@Scope(ScopeConstants.DEFAULT)
	public SqlSessionFactory buildSqlSessionFactory() {
		SqlSessionFactory factory = null;
		try {
			String resource = "configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return factory;
	}
	
    public static void bind(ServiceBinder binder) {
    	binder.bind(AccountService.class, AccountServiceImpl.class);
    	binder.bind(DepartmentService.class, DepartmentServiceImpl.class);
    }

    public static void contributeFactoryDefaults(
            MappedConfiguration<String, Object> configuration) {
        configuration.override(SymbolConstants.APPLICATION_VERSION, "0.0.1-SNAPSHOT");
		configuration.override(SymbolConstants.PRODUCTION_MODE, false);
		configuration.add(AngularSymbolConstants.ANGULAR_CORE_PATH, "context:js/bower_components");
        configuration.add(AngularSymbolConstants.ANGULAR_VERSION, "1.3.9");
    }

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,zh");
        configuration.add(SymbolConstants.HMAC_PASSPHRASE,"a1TAzRnjBZRKubgwSRlpX");
        configuration.add(ResteasySymbols.MAPPING_PREFIX, "/api");
    }

	/**
	 * Use annotation or method naming convention: <code>contributeApplicationDefaults</code>
	 */
	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void setupEnvironment(MappedConfiguration<String, Object> configuration) {
		//configuration.add(SymbolConstants.BOOTSTRAP_ROOT, "context:mybootstrap");
		configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
		configuration.add(SymbolConstants.MINIFICATION_ENABLED, true);
	}
	
     public static void contributeResponseCompressionAnalyzer(final Configuration<String> configuration) {
    	 configuration.add("application/json");
	 }

     public static void contributeClasspathAssetAliasManager(MappedConfiguration<String, String> configuration) {
    	 configuration.add("tap-angular", "cn/tradewin");
	 }
     
     public static void contributeResteasyPackageManager(Configuration<String> configuration) {
    	 configuration.add("cn.tradewin.angular.ws.resource");
     }

     public static void contributeIgnoredPathsFilter(Configuration<String> configuration) {
    	 configuration.add("/partials/*");
     }

     
	/*
	// This will override the bundled bootstrap version and will compile it at runtime
	@Contribute(JavaScriptStack.class)
	@Core
	public static void overrideBootstrapCSS(OrderedConfiguration<StackExtension> configuration)
	{
		configuration.override("bootstrap.css",
				new StackExtension(StackExtensionType.STYLESHEET, "context:mybootstrap/css/bootstrap.css"), "before:tapestry.css");
	}
	*/

    /**
     * This is a service definition, the service will be named "TimingFilter". The interface,
     * RequestFilter, is used within the RequestHandler service pipeline, which is built from the
     * RequestHandler service configuration. Tapestry IoC is responsible for passing in an
     * appropriate Logger instance. Requests for static resources are handled at a higher level, so
     * this filter will only be invoked for Tapestry related requests.
     * <p/>
     * <p/>
     * Service builder methods are useful when the implementation is inline as an inner class
     * (as here) or require some other kind of special initialization. In most cases,
     * use the static bind() method instead.
     * <p/>
     * <p/>
     * If this method was named "build", then the service id would be taken from the
     * service interface and would be "RequestFilter".  Since Tapestry already defines
     * a service named "RequestFilter" we use an explicit service id that we can reference
     * inside the contribution method.
     */
    public RequestFilter buildTimingFilter(final Logger log)
    {
        return new RequestFilter()
        {
            public boolean service(Request request, Response response, RequestHandler handler)
                    throws IOException
            {
                long startTime = System.currentTimeMillis();

                try
                {
                    return handler.service(request, response);
                } finally
                {
                    long elapsed = System.currentTimeMillis() - startTime;

                    log.info(String.format("Request time: %d ms", elapsed));
                }
            }
        };
    }

    /**
     * This is a contribution to the RequestHandler service configuration. This is how we extend
     * Tapestry using the timing filter. A common use for this kind of filter is transaction
     * management or security. The @Local annotation selects the desired service by type, but only
     * from the same module.  Without @Local, there would be an error due to the other service(s)
     * that implement RequestFilter (defined in other modules).
     */
    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
                                         @Local
                                         RequestFilter filter){
        configuration.add("Timing", filter);
    }
}
