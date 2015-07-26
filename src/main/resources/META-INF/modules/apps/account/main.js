(function () {
	
    'use strict';
    
    require.config({
    	
	    paths: {
	        'angular': 'lib/angular.min',
	        'ui.router': 'lib/angular-ui-router.min',
	        'ngResource': 'lib/angular-resource.min',
	        'app':'apps/account/app',
	        'controller':'apps/account/controller',
	        'service':'apps/account/service'
	    },
	    shim: {
	    	'angular' : {'exports' : 'angular'},
	    	'ngResource' : ['angular'],
	    	'ui.router' : ['angular']
	    }
	});
    
    define(['angular','app'],function(angular){
        angular.bootstrap(document, ['accountApp']);
    });
}());