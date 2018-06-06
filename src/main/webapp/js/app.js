var prode =(function () {

    function urlBase() {
        return 'http://prode.snoopconsulting.com:8090/'
    }

    function urlMyRound() {
        return urlBase() + 'myRound'
    }

    return {
        urlBase: urlBase,
        urlMyRound: urlMyRound
    }

})();