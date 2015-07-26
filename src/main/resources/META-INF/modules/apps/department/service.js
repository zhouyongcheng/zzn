(function() {
	
	'use strict';
	
	define(['angular','ngResource', 'app'],function(angular) {
	
		var services = angular.module('department.services', ['ngResource']);
		
		services.factory('departmentsService', function($resource) {
			return $resource("./../api/departments", {}, {
				query : {method : 'GET', isArray : true},
				create : {method : 'POST'}
			});
		});	
		
		services.factory('departmentService', function($resource) {
			return $resource("./../api/departments/:id", {}, {
				detail : {method : 'GET'},
				update : {method : 'PUT', params : {id: "@id"}},
				remove : {method : 'DELETE'}
			});
		});
	});
})();