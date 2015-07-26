'use strict'

var app = angular.module('department.controllers', []);

app.controller('departmentCtrl', ['$http', '$scope', 'DepartmentsService','DepartmentService',function($http, $scope, DepartmentsService, DepartmentService) {
	
	$scope.departments = DepartmentsService.query();
	
	$scope.remove = function(id) {
		DepartmentService.remove({id:id});
		$scope.departments = DepartmentsService.query();
	};
	
}]);

app.controller('listCtrl',['$scope',function($scope) {
	$scope.message = 'hello world';
}]);