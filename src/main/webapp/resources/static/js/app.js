var app = angular.module('app', ['ngRoute','ngResource', 'ngCookies']);
app.config(function($routeProvider){
    $routeProvider
        .when('/new_sing_in', {
            controller: 'newSingInController',
            templateUrl: 'resources/static/views/new_sing_in.html'
        })
        .when('/sing_in', {
            controller: 'singInController',
            templateUrl: 'resources/static/views/sing_in.html'
        })
        .when('/sing_up', {
            controller: 'singUpController',
            templateUrl: 'resources/static/views/sing_up.html'
        })
        .when('/add_user_info', {
            controller: 'addUserInfoController',
            templateUrl: 'resources/static/views/add_user_info.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});