
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
	document.getElementById("empfaenger").innerHTML = empfaenger;
	document.getElementById("iban").innerHTML = iban;
	document.getElementById("bic").innerHTML = bic;
	document.getElementById("betrag").innerHTML = betrag;
	document.getElementById("waehrung").innerHTML = waehrung;
	document.getElementById("verwendungszweck").innerHTML = verwendungszweck;
}

//zahlung.json in class ViewImpl.java und ZahlungImplService.java
function Testdaten_abrufen () {
		
	fetch("zahlung.json")
	.then(empfaenger1)
	.then(empfaenger2);
	
}
document.getElementById("Button").addEventListener("click", Testdaten_abrufen);



function Testdaten_auslesen () {
    var uebergebeneID = document.getElementById("input3").value;
    var jsonURL = "/zahlung/"+uebergebeneID;
    fetch(jsonURL)
    .then(empfaenger1)
    .then(empfaenger2);

}
document.getElementById("btn3").addEventListener("click", Testdaten_auslesen);


// function posteDaten() {
//		--> Daten als Objekt!!!
//		var data = {
//					empfaenger: "Testempfaenger",
//					iban: "DE12345"
//					}
//		--> Daten als String!!! - JSON Daten können nur als String verschickt werden
//		var json = 	JSON.stringify(data);
//		console.log(json);
//		var options = {method: "POST", 		--> "POST" , "GET" , "PUT" , "DELETE"
//						body: 	json 	} --> alternativ kann ich bei body: auch statt var json direkt JSON.stringify(data) angeben
//		         URL
//		fetch('/zahlung/', options	)	
//			.then(e1).then(e2);		--> Antwort auswerten
//			}
//	
//	function e1( data )	{
//			return data.json();
//			}
//	function e2( data )	{
//			console.log(data); 		--> return data
//			}







