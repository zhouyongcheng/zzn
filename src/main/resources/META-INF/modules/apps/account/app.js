(function() {

	'use strict';
	
	define(['angular', 'ui.router', 'controller'], function(angular) {
		
		angular.module('accountApp', ['ui.router', 'account.controllers', 'account.services'])
		.config(['$stateProvider',function($stateProvider) {
			$stateProvider.state("list", {
				url : '/list',
				templateUrl : 'account/list.html',
				controller : 'listCtrl',
				resolve : {
					data : function(accountsService) {
						return accountsService.query();
					}
				}
			}).state("create", {
				url : '/create',
				templateUrl : 'account/create.html',
				controller : 'createCtrl'
			}).state("/update", {
				url : '/update/:id',
				templateUrl : 'account/update.html',
				controller : 'detailCtrl'
			});
		}]);
	})
})();