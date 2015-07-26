(function() {
	
	'use strict';
	
	define(['angular','ngResource'],function(angular) {
	
		var services = angular.module('account.services', ['ngResource']);
		
		services.factory('accountsService', function($resource) {
			return $resource("./../api/accounts", {}, {
				query : {method : 'GET', isArray : true},
				create : {method : 'POST'}
			});
		});	
		
		services.factory('accountService', function($resource) {
			return $resource("./../api/accounts/:id", {}, {
				detail : {method : 'GET'},
				update : {method : 'PUT', params : {id: "@id"}},
				remove : {method : 'DELETE'}
			});
		});
	});
})();