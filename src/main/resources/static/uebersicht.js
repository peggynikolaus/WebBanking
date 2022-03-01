listFromJson();
		
		function loescheZelle(i) {
			fetch("/deletezahlungDB/" + i, 
					{ 
					headers: {"Content-Type":"application/json"}, 
					method: "DELETE",
					body: "",
					}) .then(alert("Datensatz gelöscht!"))
					location.reload();
		}
		
		
		var table = document.createElement("table");  //erzeugt Speicherplatz für eine leere Tabelle
		
		function listFromJson() {
			var jsonURL="/zahlungDB"
			fetch(jsonURL)
			.then(empfaenger1)
			.then(empfaenger2)
		}
		
		function empfaenger1(antwort) {
			var json = antwort.json();
			return json;
		}
		
		function empfaenger2(json) {
			var spalte = [];
			for(var i = 0; i < json.length; i++) {					//ermitteln und anlegen leerer Spalten 
				for(var key in json[i]) {
					if(spalte.indexOf(key) === -1) {
						spalte.push(key);
					}
				}
			}
			var zeile = table.insertRow(-1);
			
			for(var i = 0; i < spalte.length; i++) { 				//befuellen der Spalten Ueberschriften
				var ueberschrift = document.createElement("th");	//erzeugen der leeren header
				ueberschrift.innerHTML=spalte[i];					//Wert eintragen
				zeile.appendChild(ueberschrift);					//Zeile hinzufuegen
			}
			for(var i = 0; i < json.length; i++) {
				zeile = table.insertRow(-1);
				for(var j = 0; j < spalte.length; j++) {
					var tabellenzellen = zeile.insertCell(-1);		//erzeugen der Zellen
					tabellenzellen.innerHTML=json[i][spalte[j]];
				}
			var link = json[i].id;
			var tabellenzellen = zeile.insertCell(-1);				//erzeugt weitere Zelle für delete Link
				tabellenzellen.innerHTML='<a href = "#" onclick="loescheZelle('+link+');" title="delete">delete</a>';
			}
		var divContainer = document.getElementById("ListAusgabe");
		divContainer.innerHTML = "";
		divContainer.appendChild(table);
		}









