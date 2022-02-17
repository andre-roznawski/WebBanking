function empfaenger1( antwort ) {
console.log("Die Daten wurden empfangen");
console.log(antwort);

var json = antwort.json();
return json;
}

function zahlung( json ) {
//console.log(json);
console.log('Zahlung_ID: '+json.Zahlung_id);
console.log('Empfänger: '+json.Empfaenger);
console.log('Betrag: '+json.Betrag);
console.log('Verwendungszweck: '+json.Verwendungszweck);
console.log('Echtzeitüberweisung: '+json.Echtzeitueberweisung);
console.log('IBAN: '+json.IBAN);
document.getElementById("zahlung_id").value= json.Zahlung_id;
document.getElementById("empfaenger").value= json.Empfaenger;
document.getElementById("betrag").value= json.Betrag;
document.getElementById("verwendungszweck").value= json.Verwendungszweck;
document.getElementById("echtzeitueberweisung").value= json.Echtzeitueberweisung;
document.getElementById("iban").value= json.IBAN;
//var vorname = json.vorname;
//var nachname = json.nachname;

//document.getElementById("vorname").value = vorname;
//document.getElementById("nachname").value = nachname;
}

//function mit_key_vor_nachname_abrufen() {
// Eingabe
//var key = document.getElementById("eingabe").value;
// Verarbeitung
fetch("/index.json") // URL: was wird geholt
.then( empfaenger1 ) // was macht man damit: auspacken
.then( zahlung ); // was macht man damit: ...
