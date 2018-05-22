prode.service.travel = (function () {

    var uriFix = prode.service.uriFixture();
    var uriApi = prode.service.uriApi();
    var url = prode.urlBase();

    function editar(fixtureRound) {
        var data = {
            url: url + uriApi + uriFix,
            type: 'POST',
            contentType: 'application/json',
            data: fixtureRound
        };
        return $.ajax(data)
    }

    return {
        editar: editar
    };

})();

