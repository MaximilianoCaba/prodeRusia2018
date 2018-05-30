var prode =(function () {

    function urlBase() {
        return 'http://localhost:8080/'
    }

    function urlMyRound() {
        return urlBase() + 'myRound'
    }

    return {
        urlBase: urlBase,
        urlMyRound: urlMyRound
    }

})();