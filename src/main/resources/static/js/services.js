/*
 * AngularJS Services
 */

//Candidate Services for manipulate Candidate data
app.factory('CandidateService', function ($http, $q) {
    //implementation
    //get all candidate
    var loadAllCandidate = function () {
        var defer = $q.defer();
        $http.get('/api/candidates').then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });
        return defer.promise;
    };

    //insert new candidate
    var saveCandidate = function (name, sureName, position, curriculum) {
        var defer = $q.defer();
        $http.post('/api/candidates', {
            'name': name,
            'sureName': sureName,
            'position': position,
            'curriculum': curriculum
        }).then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });

        return defer.promise;
    };
    
    //get a candidate by id
    var getCandidate = function (id) {
        var defer = $q.defer();
        $http.get('/api/candidates/' + id).then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });
        return defer.promise;
    };

    //update a candidate
    var updateCandidate = function (id, name, sureName, position, curriculum) {
        var defer = $q.defer();
        $http.put('/api/candidates', {
            'id': id,
            'name': name,
            'sureName': sureName,
            'position': position,
            'curriculum': curriculum
        }).then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });

        return defer.promise;
    };

    //delete a candidate by id
    var deleteCandidate = function (id) {
        var defer = $q.defer();
        $http.delete('/api/candidates/' + id).then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });
        return defer.promise;
    };

    //service list return
    return {
        loadAllCandidate: loadAllCandidate,
        saveCandidate: saveCandidate,
        getCandidate: getCandidate,
        updateCandidate: updateCandidate,
        deleteCandidate: deleteCandidate
    };

});


//Position Service for manipulate Position data
app.factory('PositionService', function ($http, $q) {
    //implementation    
    //get all position
    var loadAllPosition = function () {
        var defer = $q.defer();
        $http.get("/api/positions").then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response.data);
        });
        return defer.promise;
    };
    
    //service list return
    return {
        loadAllPosition: loadAllPosition
    };
});

