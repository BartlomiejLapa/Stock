var stockApp = angular.module('stockApp', []);

stockApp.controller('StockController', function StockController($scope) {
    $scope.items = [];

    var websocket = new WebSocket("ws://webtask.future-processing.com:8068/ws/stocks");
    websocket.onmessage = function (message) {
        var data = JSON.parse(message.data);
        console.log(data.Items);
        $scope.items = data.Items;
        $scope.$apply();
    };
});