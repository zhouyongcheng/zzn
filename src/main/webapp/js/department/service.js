'use strict';

var services = angular.module("department.services",['ngResource']);

services.factory('DepartmentsService', function($resource){
	return $resource('../rest/departments',{}, {
		query : {method:'GET', isArray:true},
		create :{method: 'POST'}
	})
});

services.factory('DepartmentService', function($resource){
	return $resource('../rest/departments/:id',{}, {
		show : {method:'GET'},
		update: {method: 'PUT'},
		remove :{method: 'DELETE', params:{id: '@id'}}
	})
});