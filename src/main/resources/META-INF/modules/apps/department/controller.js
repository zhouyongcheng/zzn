(function() {
	'use strict';
	
	define(['angular','service'],function(angular) {
		
		var app = angular.module('department.controllers', ['department.services']);
				
		app.controller('listCtrl', ['$scope','$location','departmentsService', 'departmentService' ,function($scope, $location,departmentsService, departmentService) {
			
			$scope.message = null;
			
			$scope.update = function(deptId) {
				$location.path('/update/' + deptId);
			};

			$scope.remove = function(deptId) {
				departmentService.remove({id : deptId} ,function(data) {
					console.log("--------------------------------");
					console.log(data);
					console.log("--------------------------------");
					$scope.departments = departmentsService.query();
				}, function() {
					console.log("--------------------------------");
					console.log("error occurs!!!!");
					$scope.message = 'delete failure!'
					console.log("--------------------------------");
				});				
			};
			
			$scope.create = function() {
				$location.path('/create');
			};
			
			$scope.departments = departmentsService.query();
					
		}]);
		
		app.controller('detailCtrl', ['$scope','$location','$routeParams','departmentService',function($scope, $location,$routeParams,departmentService) {
			
			$scope.update = function() {
				departmentService.update($scope.department, function(data) {
					$location.path('/list');
				});
			};

			$scope.cancel = function() {
				$location.path('/list');
			};
			
			$scope.department = departmentService.detail({id : $routeParams.id});
					
		}]);
		
		
		app.controller('createCtrl', ['$scope','$location','departmentsService',function($scope, $location,departmentsService) {
			$scope.create = function() {
				departmentsService.create($scope.department, function(data) {
					$location.path('/list');
				});
				
			};
		}]);
	});
})();