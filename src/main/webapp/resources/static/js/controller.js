app.controller("singUpController", function ($scope, $http, $location, $cookies) {
    if($cookies.get('agromarketUserId') !== null)
        $cookies.remove('agromarketUserId');

    $scope.user = {
        firstname : "",
        lastname : "",
        email : "",
        password : "",
        phone : ""
    };

    $scope.registrate = function () {

        alert($scope.user.email + '\n' + $scope.user.password);

        $http.post('http://localhost:8080/users/save', $scope.user).then(
            function (response) {

                $http.get('http://localhost:8080/users/login' + $scope.user).then(
                    function (response) {
                        var id = response.data;

                        if(id !== null)
                            $cookies.put('agromarketUserId', id);

                        $location.path('/add_user_info');
                    }, function (response) {}
                );

            }, function (response) {
                alert('Error!');
            }
        );
    }
});

app.controller('singInController', function($scope, $http, $cookies, $location) {
    if($cookies.get('agromarketUserId') !== null)
        $cookies.remove('agromarketUserId');

    $scope.incorrectly = false;

    $scope.user = {
        email : "",
        password : ""
    };

    $scope.login = function () {
        alert($scope.user.email + '\n' + $scope.user.password);

        $http.post('http://localhost:8080/users/login', $scope.user).then(
            function (response) {
                alert(response.data);
                var id = response.data;

                if(user !== null) {
                    $cookies.put('agromarketUserId', id);
                    $location.path('/add_user_info');
                }

                $scope.incorrectly = true;
            }, function (response) {
                alert('Error!');
                $scope.incorrectly = true;
            }
        );
    }
});

app.controller('newSingInController', function ($scope, $http) {
    $scope.user = {
        email : '',
        password : ''
    };

    $scope.buttonClick = function () {
        alert($scope.user.email + "\n" + $scope.user.password);
    }
});

app.controller('addUserInfoController', function($scope, $http, $location, $cookies) {
    /* if cookies absent, redirect to "/" */
    if($cookies.get('agromarketUserId') === null)
        $location.path('/');

    $scope.regions = [];
    $scope.cities = [];

    /* Get Regions */
    $http.get('http://localhost:8080/location/regions').then(
        function (response) {
            $scope.regions = response.data;
        },function (response) {
            alert('Sorry error!');
        });

    /* Get Cities */
    $scope.changeRegion = function () {
        $http.post('http://localhost:8080/location/cities', $scope.region).then(
            function (response) {
                $scope.cities = response.data;
            }, function (response) {
                alert('Sorry error!');
            }
        );
    };

    /* onClick save */
    $scope.save = function () {
        var user = {
            firstname : '',
            lastname : '',
            email : '',
            password : '',
            phone : '',
            address : {
                region : '',
                city : '',
                location : ''
            },
            description : ''
        };

        $http.get('http://localhost:8080/users/' + $cookies.get('agromarketUserId')).then(
            function (response) {
                user = response.data;
                console.log(user);

                //$http.put('http://localhost:8080/update', user);
            }, function (response) {
                alert('Error!');
            }
        );

        $location.path('/');
    };

    /* onClick later */
    $scope.later = function () {
        $location.path('/');
    };
});
