
// Listener
document.getElementById("btn4").addEventListener("click", post);

function post() {

    var input = {
        empfaenger:         document.getElementById("inputemp").value,
        iban:			     document.getElementById("inputiban").value,
        bic:         document.getElementById("inputbic").value,
        betrag:               document.getElementById("inputbetrag").value,
        waehrung:           document.getElementById("inputwaeh").value,
        verwendungszweck:     document.getElementById("inputzweck").value,
    }

    var json = JSON.stringify(input)

    //fetch("/zahlung/",	- ArrayList
    fetch("/newzahlungDB/", // Datenbank

    {
        headers: {"Content-Type":"application/json"},
        method: "POST",
        body: json
    }

    ).then(alert("Zahlung wurde gespeichert!"))

}