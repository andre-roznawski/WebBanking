function empfaenger1(antwort) {
	console.log("Die Daten wurden empfangen");
	console.log(antwort);
	var json = antwort.json();
	return json;
}

function zahlungen_view(json) {
	table_zahlungenview_header();
	for (var i = 0; i < json.liste.length; i++) {
		if ((json.liste[i]) !== null) {
		/*console.log('Zahlung_ID: ' + json.liste[i].zahlung_id);
		console.log('Empfänger: ' + json.liste[i].empfaenger);
		console.log('Betrag: ' + json.liste[i].betrag);
		console.log('Verwendungszweck: ' + json.liste[i].verwendungszweck);
		console.log('Echtzeitüberweisung: ' + json.liste[i].echtzeitueberweisung);
		console.log('IBAN: ' + json.liste[i].iban);
		/*document.getElementById("zahlung_id").value = json[i].Zahlung_id;
		document.getElementById("empfaenger").value = json[i].Empfaenger;
		document.getElementById("betrag").value = json[i].Betrag;
		document.getElementById("verwendungszweck").value = json[i].Verwendungszweck;
		document.getElementById("echtzeitueberweisung").value = json[i].Echtzeitueberweisung;
		document.getElementById("iban").value = json[i].IBAN;*/
		let row_d = document.createElement('tr');
		let row_d_data_1 = document.createElement('td');
		let row_d_data_2 = document.createElement('td');
		let row_d_data_3 = document.createElement('td');
		let row_d_data_4 = document.createElement('td');
		let row_d_data_5 = document.createElement('td');
		let row_d_data_6 = document.createElement('td');
		row_d_data_1.innerHTML = json.liste[i].zahlung_id;
		row_d_data_2.innerHTML = json.liste[i].empfaenger;
		row_d_data_3.innerHTML = json.liste[i].betrag;
		row_d_data_4.innerHTML = json.liste[i].verwendungszweck;;
		row_d_data_5.innerHTML = json.liste[i].echtzeitueberweisung;
		row_d_data_6.innerHTML = json.liste[i].iban;
		row_d.appendChild(row_d_data_1);
		row_d.appendChild(row_d_data_2);
		row_d.appendChild(row_d_data_3);
		row_d.appendChild(row_d_data_4);
		row_d.appendChild(row_d_data_5);
		row_d.appendChild(row_d_data_6);
		tbody.appendChild(row_d);
		}
	}
}

function table_zahlungenview_header() {
	// Creating and adding data to first row of the table
	let row_1 = document.createElement('tr');
	let heading_1 = document.createElement('th');
	heading_1.innerHTML = "ZahlungID";
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
}

function request_all() {
	//	console.log(input_id);
	fetch("/zahlung/") // URL: was wird geholt
		.then(empfaenger1) // was macht man damit: auspacken
		.then(zahlungen_view); // was macht man damit: ...
}

let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');
table.appendChild(thead);
table.appendChild(tbody);
// Adding the entire table to the body tag
document.getElementById('table_z1').appendChild(table);

request_all();