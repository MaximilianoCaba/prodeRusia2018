prode.service.travel = (function () {

    var uriFix = prode.service.uriFixture();
    var uriApi = prode.service.uriApi();
    var url = prode.urlBase();

    function editar(listResult) {
        var data = {
            url: url + uriApi + uriFix,
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            dataType   : "json",
            data:  JSON.stringify(listResult)
        };
        return $.ajax(data)
    }

    return {
        editar: editar
    };

})();

