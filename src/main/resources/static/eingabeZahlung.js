
// Listener
document.getElementById("btn4").addEventListener("click", post);

function post() {

    var input = {
        empfaenger:         document.getElementById("inputemp").value,
        empfaengerIBAN:     document.getElementById("inputiban").value,
        empfaengerBIC:         document.getElementById("inputbic").value,
        betrag:               document.getElementById("inputbetrag").value,
        waehrung:           document.getElementById("inputwaeh").value,
        verwendungszweck:     document.getElementById("inputzweck").value,
    }

    var json = JSON.stringify(input)

    fetch("/zahlung/",

    {
        headers: {"Content-Type":"application/json"},
        method: "POST",
        body: json
    }

    ).then(alert("Danke für die Nutzung unseres Webservices! Es wurden Ihnen Gebühren in Höhe von 0,05 Euro in Rechnung gestellt!"))

}