/**
 * @ngdoc overview
 * @name webappApp
 * @description
 * # webappApp
 *
 * Main module of the application.
 */
var app = angular.module('nncloud', ['ngRoute','mgcrea.ngStrap', 'mgcrea.ngStrap.tooltip','mgcrea.ngStrap.modal','ngCookies','mgcrea.ngStrap.helpers.dimensions','angular-websocket']);
  app.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
  $httpProvider.defaults.withCredentials = true;  
  $routeProvider
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/register', {
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl'
      })
      .when('/core/workbench', {
	templateUrl: 'views/core/workbench.html',
	controller: 'WorkbenchCtrl'
      })
      .when('/core/generate', {
	templateUrl: 'views/core/generate.html',
	controller: 'GenerateCtrl'
      })
      .when('/core/export', {
	templateUrl: 'views/core/export.html',
	controller: 'ExportCtrl'
      })
      .when('/core/training', {
	templateUrl: 'views/core/training.html',
	controller: 'TrainingCtrl'
      })
      .when('/core/settings', {
	templateUrl: 'views/core/settings.html',
	controller: 'SettingsCtrl'
      })
      .when('/core/load', {
	templateUrl: 'views/core/load.html',
	controller: 'LoadCtrl'
      })
      .when('/core/saveas', {
	templateUrl: 'views/core/saveas.html',
	controller: 'SaveAsCtrl'
      })
      .when('/logout', {
	templateUrl: 'views/login.html',
	controller: 'LogoutCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      })
  }]).run(['$rootScope','$cookies', function($rootScope, $cookies){
	$rootScope.authorized = false;
	if($cookies.get('language') === undefined)
		$cookies.put('language','en');
}]);

