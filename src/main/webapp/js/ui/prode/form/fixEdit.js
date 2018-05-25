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
            for (var indexRounds in inputs) {

                if (indexRounds < 7) {

                    round = inputs[indexRounds];

                    var rondaLista = round.children[0].children[1].children;

                    for (var indexMatch in rondaLista) {

                        if (rondaLista[indexMatch].id === "matchId") {

                            var indexMatchId = parseInt(indexMatch);
                            var indexUserId = indexMatchId + 1;
                            var indexMyMatchId = indexMatchId + 2;

                            var goalHome = rondaLista[indexMyMatchId].children[0].children[0].children[2].children[0].value;
                            var goalAway = rondaLista[indexMyMatchId].children[0].children[0].children[4].children[0].value;

                            var goalPenaltyHome = "";
                            var goalPenaltyAway = "";

                            if (indexRounds > 2) {
                                goalPenaltyHome = rondaLista[indexMyMatchId].children[0].children[1].children[2].children[0].value;
                                goalPenaltyAway = rondaLista[indexMyMatchId].children[0].children[1].children[4].children[0].value;
                            }

                            var pronosticMatch = {
                                "matchId": rondaLista[indexMatchId].value,
                                "userId": rondaLista[indexUserId].value,
                                "goalHome": goalHome,
                                "goalAway": goalAway,
                                "goalPenaltyHome": goalPenaltyHome,
                                "goalPenaltyAway": goalPenaltyAway
                            };

                            listResult.push(pronosticMatch);

                        }
                    }

                }
            }

            editarFix(listResult)

        })
    }

    function editarFix(listResult) {
        prode.service.travel.editar(listResult).done(function () {
            redireccionarAUrlRetorno()
        }).fail(function (error) {
            console.log(error.responseJSON)
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