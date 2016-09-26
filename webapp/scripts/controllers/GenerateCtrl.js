'use strict';

angular.module('nncloud')
  .controller('GenerateCtrl', function ($scope) {
		$scope.generate = function()
		{
			if(!validate())
				return;
			
			var request = 
			{
				method: "POST",
				url: API['GENERATE'],
				headers:
				{
					"Content-Type": "application/json"
				},
				data: {"name": $scope.network.name ,"1stlayer": $scope.network.first, "2ndlayer": $scope.network.first, "3rdlayer": $scope.network.third, "4thlayer": $scope.network.fourth, activationFunction: $scope.network.activationFunction }
			}
		}
		
		var validate = function()
		{
			var error_message = "";
			
			if($scope.name == "")
				error_message = "Name must not be empty!"
			
			if($scope.first == "" || $scope.second == "" || $scope.third == "" || $scope.fourth == "")
				error_message = "Neuron number in layer must not be empty!";
			
			if(error_message != )
			{
				$alert({title: 'Cannot register: ', content: error_message, placement: 'top', type: 'danger', show: true});
				return false;
			}
			return true;
		}
  });
