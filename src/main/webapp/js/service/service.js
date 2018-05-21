snoopooling.service = (function () {


    function uriTravel() {
        return 'travel/'
    }

    function uriPerson() {
        return 'person/'
    }

    function uriApi() {
        return 'api/'
    }

    return {
        uriTravel: uriTravel,
        uriApi: uriApi,
        uriPerson: uriPerson
    }

})();