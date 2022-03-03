function e1(data) {
	console.log(data);
	console.log('Status: '+ data.status);
	return data.json();
}

function e2(data) {
	 console.log(data);
	// return data;
}

function request_update() {
	var zahlung_id = document.getElementById("zahlung_id").value;
	var empfaenger = document.getElementById("empfaenger").value;
	var betrag = document.getElementById("betrag").value;
	var verwendungszweck = document.getElementById("verwendungszweck").value;
	var echtzeitueberweisung = document.getElementById("echtzeitueberweisung").value;
	var iban = document.getElementById("iban").value;

	var data = {
		zahlung_id: zahlung_id,
		empfaenger: empfaenger,
		betrag: betrag,
		verwendungszweck: verwendungszweck,
		echtzeitueberweisung: echtzeitueberweisung,
		iban: {
			iban: iban
		}
	}
	var json = JSON.stringify(data);
	console.log(json);
	fetch("/zahlung/",
		{
			headers: { "Content-type": "application/json" },
			method: "PUT", // GET, POST, PUT, DELETE (,...)
			body: json // JSON.stringify(data)
		}
	)
		// Antwort auswerten - in zwei Stufen!!!
		.then(e1).then(e2);
}

function request_delete() {
	var zahlung_id = document.getElementById("zahlung_id").value;

	var data = {
		zahlung_id: zahlung_id,
	}
	var json = JSON.stringify(data);
	console.log(json);
	fetch("/zahlung/" + zahlung_id + "/",
		{
			headers: { "Content-type": "application/json" },
			method: "DELETE", // GET, POST, PUT, DELETE (,...)
			body: json // JSON.stringify(data)
		}
	)
		// Antwort auswerten - in zwei Stufen!!!
		.then(e1).then(delete_view);
}

function empfaenger1(antwort) {
	console.log("Die Daten wurden empfangen");
	console.log(antwort);
	console.log('Status des Requests: '+ antwort.status)
	var json = antwort.json();
	return json;
}
//document.getElementById("zahlungen").value= json.Zahlung_id + json.Empfaenger + json.Betrag + json.Verwendungszweck + json.Echtzeitueberweisung + json.IBAN;
//var vorname = json.vorname;
//var nachname = json.nachname;

//document.getElementById("vorname").value = vorname;
//document.getElementById("nachname").value = nachname;


function set_input_id() {
	var input_id = document.getElementById("input_id").value
	return input_id;
}

function request_single() {
	input_id = set_input_id();
	console.log('input_id: ' + input_id);

	fetch("/zahlung/" + input_id + "/") // URL: was wird geholt
		.then(empfaenger1) // was macht man damit: auspacken
		.then(zahlung_view); // was macht man damit: ...
}

function zahlung_view(json) {
	//	var input_id = document.getElementById("input_id").value
	if (json.zahlung_id == 0) {
		document.getElementById("zahlung_id").value = "Zahlung existiert nicht!!!";
		document.getElementById("empfaenger").value = "";
		document.getElementById("betrag").value = "";
		document.getElementById("verwendungszweck").value = "";
		document.getElementById("echtzeitueberweisung").value = "";
		document.getElementById("iban").value = "";
	} else {
		document.getElementById("zahlung_id").value = json.zahlung_id;
		document.getElementById("empfaenger").value = json.empfaenger;
		document.getElementById("betrag").value = json.betrag;
		document.getElementById("verwendungszweck").value = json.verwendungszweck;
		document.getElementById("echtzeitueberweisung").value = json.echtzeitueberweisung;
		document.getElementById("iban").value = json.iban.iban;
	}
}

function delete_view() {
	    document.getElementById("zahlung_id").value = "Zahlung wurde gelöscht";
		document.getElementById("empfaenger").value = "";
		document.getElementById("betrag").value = "";
		document.getElementById("verwendungszweck").value = "";
		document.getElementById("echtzeitueberweisung").value = "";
		document.getElementById("iban").value = "";
}

//function mit_key_vor_nachname_abrufen() {
// Eingabe
//var key = document.getElementById("eingabe").value;
// Verarbeitung
let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');
table.appendChild(thead);
table.appendChild(tbody);
// Adding the entire table to the body tag
document.getElementById('table_z').appendChild(table);

//document.getElementById("button_zahlungen_all").addEventListener("click", request_all);
document.getElementById("button_zahlung_id").addEventListener("click", request_single);
document.getElementById("button_zahlung_update").addEventListener("click", request_update);
document.getElementById("button_zahlung_delete").addEventListener("click", request_delete);