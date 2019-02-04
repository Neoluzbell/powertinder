'use strict';

/**
 * @ngdoc function
 * @name webtinFrontApp.controller:MatchesCtrl
 * @description
 * # MatchesCtrl
 * Controller of the webtinFrontApp
 */
angular.module('webtinFrontApp')
  .controller('MatchesCtrl', ['$resource', '$scope', 'baseUrl', function ($resource, $scope, baseUrl) {

    $scope.sortCriteria = 'person.age';

    init($resource, baseUrl, $scope);

    function init($resource, baseUrl, $scope) {
      $scope.loading = true;
      var Matches = $resource(baseUrl + '/user/matches');
      Matches.get(function (response) {
        $scope.loading = false;
        console.log(response);
        $scope.matches = response.matches;
      });
    }

    // refresh
    $scope.refresh = function () {
      init($resource, baseUrl, $scope);
    }

    $scope.sort = function (criteria) {
      $scope.sortCriteria = criteria;
    }

  }]);



