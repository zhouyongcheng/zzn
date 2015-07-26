(function() {
	'use strict';
	
	define(['angular', 'service'],function(angular) {
		
		var app = angular.module('account.controllers', ['account.services']);
				
		app.controller('listCtrl', ['$scope','$location','accountsService', 'accountService','data' ,function($scope, $location,accountsService, accountService, data) {
			
			$scope.message = null;
			
			$scope.update = function(accountId) {
				$location.path('/update/' + accountId);
			};

			$scope.remove = function(accountId) {
				accountService.remove({id : accountId}
				,function(response) {
					$scope.accounts = accountsService.query();
				},function(response) {
					console.log("--------------------------------");
					console.log("error occurs!!!!");
					console.log("--------------------------------");
				});				
			};
			
			$scope.create = function() {
				$location.path('/create');
			};
			
			console.log("************call in controller area********************");
			
//			$scope.accounts = accountsService.query();
			$scope.accounts = data;
					
		}]);
		
		app.controller('detailCtrl', ['$scope','$location','$stateParams','accountService',function($scope, $location,$stateParams,accountService) {
			
			$scope.update = function() {
				accountService.update($scope.account, function(data) {
					$location.path('/list');
				});
			};

			$scope.cancel = function() {
				$location.path('/list');
			};
			
			$scope.account = accountService.detail({id : $stateParams.id});
					
		}]);
		
		
		app.controller('createCtrl', ['$scope','$location','accountsService',function($scope, $location,accountsService) {
			$scope.create = function() {
				accountsService.create($scope.account, function(data) {
					$location.path('/list');
				});
				
			};
		}]);
	});
})();