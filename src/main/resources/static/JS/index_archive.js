function empfaenger1( antwort ) {
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
}

fetch("/index.json") // URL: was wird geholt
.then( empfaenger1 ) // was macht man damit: auspacken
.then( zahlung ) 
.then( table_fill );


let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');
table.appendChild(thead);
table.appendChild(tbody);
// Adding the entire table to the body tag
document.getElementById('body').appendChild(table);
// Erstellen der ersten Zeile mit Überschriften
let row_1 = document.createElement('tr');
let heading_1 = document.createElement('th');
heading_1.innerHTML = "Zahlungs ID";
let heading_2 = document.createElement('th');
heading_2.innerHTML = "Empfänger";
let heading_3 = document.createElement('th');
heading_3.innerHTML = "Betrag";
let heading_4 = document.createElement('th');
heading_4.innerHTML = "Verwendungszweck";
let heading_5 = document.createElement('th');
heading_5.innerHTML = "Echtzeitüberweisung";
let heading_6 = document.createElement('th');
heading_6.innerHTML = "IBAN";
row_1.appendChild(heading_1);
row_1.appendChild(heading_2);
row_1.appendChild(heading_3);
row_1.appendChild(heading_4);
row_1.appendChild(heading_5);
row_1.appendChild(heading_6);
thead.appendChild(row_1);

// Erstellen der zweiten Zeile
function table_fill(json){
for (var i = 0; i<3; i++){
	
let row_2 = document.createElement('tr');
let row_2_data_1 = document.createElement('td');
row_2_data_1.innerHTML +=  json[i].Zahlung_id;
let row_2_data_2 = document.createElement('td');
row_2_data_2.innerHTML += json[i].Empfaenger;
let row_2_data_3 = document.createElement('td');
row_2_data_3.innerHTML += json[i].Betrag;
let row_2_data_4 = document.createElement('td');
row_2_data_4.innerHTML += json[i].Verwendungszweck;
let row_2_data_5 = document.createElement('td');
row_2_data_5.innerHTML += json[i].Echtzeitueberweisung;
let row_2_data_6 = document.createElement('td');
row_2_data_6.innerHTML += json[i].IBAN;
row_2.appendChild(row_2_data_1);
row_2.appendChild(row_2_data_2);
row_2.appendChild(row_2_data_3);
row_2.appendChild(row_2_data_4);
row_2.appendChild(row_2_data_5);
row_2.appendChild(row_2_data_6);
tbody.appendChild(row_2);
}
}