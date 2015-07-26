'use strict';

var services = angular.module("account.services",['ngResource']);

services.factory('AccountsFactory', function($resource){
	return $resource('../rest/accounts',{}, {
		query : {method:'GET', isArray:true},
		create :{method: 'POST'}
	})
});

services.factory('AccountFactory', function($resource){
	return $resource('../rest/accounts/:id',{}, {
		show : {method:'GET'},
		update: {method: 'PUT', params:{id: '@id'}},
		remove :{method: 'DELETE', params:{id: '@id'}}
	})
});