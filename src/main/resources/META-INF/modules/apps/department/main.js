(function () {
	
    'use strict';
    
    require.config({
    	
	    paths: {
	        'angular': 'lib/angular.min',
	        'ngRoute': 'lib/angular-route.min',
	        'ngResource': 'lib/angular-resource.min',
	        'app':'apps/department/app',
	        'controller':'apps/department/controller',
	        'service':'apps/department/service'
	    },
	    shim: {
	    	'angular' : {'exports' : 'angular'},
	    	'ngResource' : ['angular'],
	    	'ngRoute' : ['angular']
	    }
	});
    
    define(['angular','controller'],function(angular){
        angular.bootstrap(document, ['department']);
    });
}());