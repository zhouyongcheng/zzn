(function() {

	'use strict';
	
	define(['angular', 'ngRoute'], function(angular) {
		
		angular.module('department', ['ngRoute','department.services', 'department.controllers'])
		.config(['$routeProvider',function($routeProvider) {
			$routeProvider.when("/list", {
				templateUrl : 'department/list.html',
				controller : 'listCtrl'
			}).when("/create", {
				templateUrl : 'department/create.html',
				controller : 'createCtrl'
			}).when("/update/:id", {
				templateUrl : 'department/update.html',
				controller : 'detailCtrl'
			}).otherwise({
				redirectTo : '/list'
			});
		}]);
	})
})();