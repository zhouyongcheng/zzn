(function () {
	
    'use strict';
    
    require.config({
	    paths: {
	        'AdminLTE':'lib/app.min'
	    },
	    shim: {
	    	'AdminLTE' : {
	    		'exports' : 'AdminLTE',
	    		'deps' : 'jquery'
	    	}
	    }
	});
    
    define(['jquery', 'AdminLTE'], function($, AdminLTE){
        
    });
    
}());