prode.ui.form.fixEdit = (function () {

    var urlBase = prode.urlBase();

    var $buttonEditRoundFix = $("#botonEditarFix");

    function init() {
        bindearEventosABotonEditar();
    }

    function bindearEventosABotonEditar() {
        $buttonEditRoundFix.on("click", function () {
            var inputs = document.getElementById('form').children;

            var listResult = [];
            var round;
            var i;
            for (i in inputs) {

                if(i === "0"){
                    round =  inputs[i].value
                }

                if(i !== "0" && inputs.length > i ){

                    var pronosticMatch = {
                        "matchId": inputs[i].children[0].value,
                        "userId": inputs[i].children[1].value,
                        "goalHome": inputs[i].children[2].children[3].children[1].value,
                        "goalAway": inputs[i].children[2].children[6].children[1].value,
                        "goalPenaltyHome": "",
                        "goalPenaltyAway": ""
                    };
                    if (!isEmpty(pronosticMatch.goalAway) && !isEmpty(pronosticMatch.goalHome) &&
                        !isEmpty(pronosticMatch.userId) && !isEmpty(pronosticMatch.matchId)) {
                        listResult.push(pronosticMatch)
                    }

                    if(round > 3){
                        pronosticMatch.goalPenaltyHome = inputs[i].children[2].children[4].children[1].value;
                        pronosticMatch.goalPenaltyAway = inputs[i].children[2].children[5].children[1].value;
                    }
                }
            }

            var result = JSON.stringify({
                "round": round,
                "pronosticResult": listResult
            });

            editarFix(result)
        })
    }

    function editarFix(listResult) {
        prode.service.travel.editar(listResult).done(function () {
            redireccionarAUrlRetorno()
        }).fail(function (error) {
            console.log(error.responseJSON.message)
        })
    }

    function redireccionarAUrlRetorno() {
        window.location.href = urlBase
    }

    function isEmpty(str) {
        return (!str || 0 === str.length);
    }

    return {
        init: init
    };

})();

$(document).on("ready", function () {
    prode.ui.form.fixEdit.init();
});