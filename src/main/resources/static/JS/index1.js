function e1( data ) {
	return data.json();
}

function e2( data ) {
	console.log(data);
	// return data;
}

function request_add() {
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
	   iban: iban
    }
	var json = JSON.stringify(data);
	console.log(json);
	fetch('/zahlung/',
	  {
		headers: {"Content-type": "application/json"},
		method: "POST", // GET, POST, PUT, DELETE (,...)
		body: json // JSON.stringify(data)
	  }	   
	)
	// Antwort auswerten - in zwei Stufen!!!
	.then(e1).then(e2);
	}
	
	document.getElementById("button_zahlung_add").addEventListener("click", request_add);
	
	
	
	
	
/*	var data = {
	   zahlung_id: zahlung_id
	   empfaenger: "Paul Paulsen",
	   iban: "DE1234"
    }
    
	
	function e1( data ) {
	return data.json();
}
function e2( data ) {
	console.log(data);
	// return data;
}
function posteDaten() { // verschicken
    // Daten als Objekt!!!
    var data = {
	   empfaenger: "Paul Paulsen",
	   iban: "DE1234"
    }
	
	// Daten als String!!!
	var json = JSON.stringify(data);
	console.log(json);
	// var json = '{ "empfaenger": "Paul Paulsen", "iban": "DE1234" }';
	
	// Der JavaScript-Code läuft im Browser
	//
	//    URL
	fetch('/zahlung/',
	
	  {
		method: "POST", // GET, POST, PUT, DELETE (,...)
		body: json // JSON.stringify(data)
	  }	   
	
	)
	// Antwort auswerten - in zwei Stufen!!!
	.then(e1).then(e2);
    // Alternative, vorab die "options" deklarieren
    var options = {
		method: "POST",
		body: json
	}
	// Der JavaScript-Code läuft im Browser
	//
	//    URL
	fetch('/zahlung/', options).then(e1).then(e2);
	
} */