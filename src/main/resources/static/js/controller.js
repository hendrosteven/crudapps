/*
 * AngularJS Controller
 */

//load modul base64 for converting CV file to base64 encoding 
var app = angular.module('myApp', ['naif.base64', 'ngPatternRestrict']);

app.controller('CandidateController', function ($scope, CandidateService, PositionService) {

    //load allcandidate and allposition
    $scope.setup = function () {
        CandidateService.loadAllCandidate().then(function (response) {
            $scope.candidates = response.payload;
        });

        PositionService.loadAllPosition().then(function (response) {
            $scope.positions = response.payload;
        });
    };

    //prepare the form for input
    $scope.showForm = function () {
        $scope.clearForm();
        $('#form-title').text("Add New Candidate");
        $('#btn-update').hide();
        $('#btn-save').show();
        $('#modal-form-candidate').modal('show');
    };


    //clear the form
    $scope.clearForm = function () {
        $('#errorMsg').addClass('hide');
        $('#infoMsg').addClass('hide');
        $scope.id = "";
        $scope.name = "";
        $scope.sureName = "";
        $scope.position = null;
        $scope.curriculum = null;
    };

    //save new candidate
    $scope.saveCandidate = function () {
        CandidateService.saveCandidate($scope.name, $scope.sureName, $scope.position, $scope.curriculum).then(
                function (response) {
                    console.log(response);
                    $scope.clearForm();
                    $scope.setup();
                    $('#infos').text(response.messages);
                    $('#errorMsg').addClass('hide');
                    $('#infoMsg').removeClass('hide');
                    
                    //push to Quixxi
                    Quixxi.q.push(['InputCandidate', {
                            "event_category": "Candidate",
                            "event_value": response.messages,
                            "event_detail": "Input New Candidate",
                            "event_object": response.payload
                        }]);
                },
                function (response) {
                    console.log(response);
                    $('#errors').text(response.messages);
                    $('#infoMsg').addClass('hide');
                    $('#errorMsg').removeClass('hide');
                });
    };

    //delete a candidate
    $scope.deleteCandidate = function (candidateId) {
        CandidateService.deleteCandidate(candidateId).then(function (response) {
            $scope.setup();
        });
    };

    //populate a candidate for editing in the form
    $scope.editCandidate = function (candidateId) {
        CandidateService.getCandidate(candidateId).then(function (response) {
            console.log(response);
            $scope.clearForm();
            $scope.id = response.payload.id;
            $scope.name = response.payload.name;
            $scope.sureName = response.payload.sureName;
            $scope.position = response.payload.position;
            $scope.curriculum = response.payload.curriculum;

            $('#form-title').text("Edit Candidate");
            $('#btn-update').show();
            $('#btn-save').hide();
            $('#modal-form-candidate').modal('show');
        });
    };

    //update a candidate
    $scope.updateCandidate = function () {
        CandidateService.updateCandidate($scope.id, $scope.name, $scope.sureName, $scope.position, $scope.curriculum).then(
                function (response) {
                    console.log(response);
                    $scope.setup();
                    $('#infos').text(response.messages);
                    $('#errorMsg').addClass('hide');
                    $('#infoMsg').removeClass('hide');
                },
                function (response) {
                    console.log(response);
                    $('#errors').text(response.messages);
                    $('#infoMsg').addClass('hide');
                    $('#errorMsg').removeClass('hide');
                });
    };
});

