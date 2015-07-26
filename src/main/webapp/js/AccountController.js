'use strict'

var app = angular.module('account.controllers', []);

app.controller('accountBoardCtrl', ['$http', '$scope', 'AccountsFactory','AccountFactory',function($http, $scope, AccountsFactory, AccountFactory) {
	
	$scope.accounts = AccountsFactory.query();
	
	$scope.remove = function(id) {
		alert(id);
		AccountFactory.remove({id:id});
		$scope.accounts = AccountsFactory.query();
	};
	
	
}]);