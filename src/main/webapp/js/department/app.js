'use strict'

angular.module('department', ['department.services', 'department.controllers','ngRoute']).
	config(['$routeProvider', function($routeProvider) {
		$routeProvider.when('/list', {templateUrl:'partials/list.html', controller: 'listCtrl'});
//		$routeProvider.when('/detail', {templateUrl:'partials/detail.html', controller: 'detailCtrl'});
//		$routeProvider.when('/creation', {templateUrl:'partial/creation.html', controller: 'creationCtrl'});
//		$routeProvider.when('/update', {templateUrl:'partial/update.html', controller: 'updateCtrl'});
		$routeProvider.otherwise({redirectTo : '/list.html'});
	}]);
