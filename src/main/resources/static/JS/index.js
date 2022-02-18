function antwort(antwort) {
	var json = antwort.json();
	return json;
}

function zahlung(json) {

	console.log('Zahlung_ID: ' + json.Zahlung_id);
	console.log('Empfänger: ' + json.Empfaenger);
	console.log('Betrag: ' + json.Betrag);
	console.log('Verwendungszweck: ' + json.Verwendungszweck);
	console.log('Echtzeitüberweisung: ' + json.Echtzeitueberweisung);
	console.log('IBAN: ' + json.IBAN);

	document.getElementById("zahlung_id").value = json.Zahlung_id;
	document.getElementById("empfaenger").value = json.Empfaenger;
	document.getElementById("betrag").value = json.Betrag;
	document.getElementById("verwendungszweck").value = json.Verwendungszweck;
	document.getElementById("echtzeitueberweisung").value = json.Echtzeitueberweisung;
	document.getElementById("iban").value = json.IBAN;

}

fetch("/index.json")
	.then(antwort)
	.then(zahlung);
