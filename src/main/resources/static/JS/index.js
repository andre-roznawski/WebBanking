function empfaenger1( antwort ) {
console.log("Die Daten wurden empfangen");
console.log(antwort);


var json = antwort.json();
return json;
}

function zahlung( json ) {
	for (var i = 0; i<3; i++){
console.log('Zahlung_ID: '+json[i].Zahlung_id);
console.log('Empfänger: '+json[i].Empfaenger);
console.log('Betrag: '+json[i].Betrag);
console.log('Verwendungszweck: '+json[i].Verwendungszweck);
console.log('Echtzeitüberweisung: '+json[i].Echtzeitueberweisung);
console.log('IBAN: '+json[i].IBAN);
document.getElementById("zahlung_id").value= json[i].Zahlung_id;
document.getElementById("empfaenger").value= json[i].Empfaenger;
document.getElementById("betrag").value= json[i].Betrag;
document.getElementById("verwendungszweck").value= json[i].Verwendungszweck;
document.getElementById("echtzeitueberweisung").value= json[i].Echtzeitueberweisung;
document.getElementById("iban").value= json[i].IBAN;
}
//document.getElementById("zahlungen").value= json.Zahlung_id + json.Empfaenger + json.Betrag + json.Verwendungszweck + json.Echtzeitueberweisung + json.IBAN;
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


/*let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');

table.appendChild(thead);
table.appendChild(tbody);

// Adding the entire table to the body tag
document.getElementById('body').appendChild(table);

// Creating and adding data to first row of the table
let row_1 = document.createElement('tr');
let heading_1 = document.createElement('th');
heading_1.innerHTML = "Sr. No.";
let heading_2 = document.createElement('th');
heading_2.innerHTML = "Name";
let heading_3 = document.createElement('th');
heading_3.innerHTML = "Company";

row_1.appendChild(heading_1);
row_1.appendChild(heading_2);
row_1.appendChild(heading_3);
thead.appendChild(row_1);


// Creating and adding data to second row of the table
let row_2 = document.createElement('tr');
let row_2_data_1 = document.createElement('td');
row_2_data_1.innerHTML = "1.";
let row_2_data_2 = document.createElement('td');
row_2_data_2.innerHTML = "James Clerk";
let row_2_data_3 = document.createElement('td');
row_2_data_3.innerHTML = "Netflix";

row_2.appendChild(row_2_data_1);
row_2.appendChild(row_2_data_2);
row_2.appendChild(row_2_data_3);
tbody.appendChild(row_2);

// Creating and adding data to third row of the table
let row_3 = document.createElement('tr');
let row_3_data_1 = document.createElement('td');
row_3_data_1.innerHTML = "2.";
let row_3_data_2 = document.createElement('td');
row_3_data_2.innerHTML = "Adam White";
let row_3_data_3 = document.createElement('td');
row_3_data_3.innerHTML = "Microsoft";

row_3.appendChild(row_3_data_1);
row_3.appendChild(row_3_data_2);
row_3.appendChild(row_3_data_3);
tbody.appendChild(row_3);

*/