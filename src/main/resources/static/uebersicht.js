
function empfaenger1(antwort) {
	var v_json = antwort.json();
	return v_json;
}

function empfaenger2(json) {
	var empfaenger = json.empfaenger;
	var iban = json.iban;
	var bic = json.bic;
	var betrag = json.betrag;
	var waehrung = json.waehrung;
	var verwendungszweck = json.verwendungszweck;

	//Ausgabe Bankdaten
	//document.getElementById("Output").innerHTML;
	document.getElementById("empfaenger").innerHTML = empfaenger;
	document.getElementById("iban").innerHTML = iban;
	document.getElementById("bic").innerHTML = bic;
	document.getElementById("betrag").innerHTML = betrag;
	document.getElementById("waehrung").innerHTML = waehrung;
	document.getElementById("verwendungszweck").innerHTML = verwendungszweck;
}

function Testdaten_abrufen () {
		
	fetch("zahlung.json")
	.then(empfaenger1)
	.then(empfaenger2);
	
}









