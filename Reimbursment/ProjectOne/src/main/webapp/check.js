let user = {};

window.onload = function() {
    fetch(empUrl, { method: "GET", headers: { "Accept": "application/json" } })
    fetch(empUrlC, { method: "GET", headers: { "Accept": "application/json" } })


	populateUser();
    document.getElementById("getInfo").addEventListener("click", getInfo);
    document.getElementById("getInfoC").addEventListener("click", getInfoC);
    document.getElementById("getInfoMang").addEventListener("click", getInfoMang);
    document.getElementById("getInfoCMang").addEventListener("click", getInfoCMang);

}

let empUrl = 'http://localhost:8081/ProjectOne/reimbursement';
let empUrlC = 'http://localhost:8081/ProjectOne/completedreimbursement';


let mUrl = 'http://localhost:8081/ProjectOne/mangreimbursement';
let mUrlC = 'http://localhost:8081/ProjectOne/mangcompletedreimbursement';


function getInfo() {
	    fetch(empUrl, { method: "GET", headers: { "Accept": "application/json" } })
	        .then((response) => {
	            let data = response.json();
	            return data;
	        })
	        .then((data) => {
	            console.log(data);
	            while (document.getElementById("reimbursements-submitted").firstChild) {
	                document.getElementById("reimbursements-submitted").removeChild(document.getElementById("reimbursements-submitted").firstChild);
	            }
	            var headPen = document.createElement("H3");
	            var headNote = document.createTextNode("Submitted: ")
	            headPen.appendChild(headNote);
	            document.getElementById("reimbursements-submitted").appendChild(headPen);
	            for (let i = 0; i < data.length; i++) {

	                var node = document.createElement("DIV");
	                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId)
	                node.appendChild(reimId);

	                var node1 = document.createElement("DIV");
	                var reimBal = document.createTextNode("Reimbursement Balace: $" + data[i].reimbursementBalance)
	                node1.appendChild(reimBal);

	              

	                var node2= document.createElement("BR");
	                
	                document.getElementById("reimbursements-submitted").appendChild(node);
	                document.getElementById("reimbursements-submitted").appendChild(node1);
	                document.getElementById("reimbursements-submitted").appendChild(node2);

	            }
	          
	            
	        })
	        // catching an error
	        .catch((error) => {
	            alert('something went wrong');
	            console.log(error);
	        	        })
}
function getInfoC() {
	console.log("here1");
	    fetch(empUrlC, { method: "GET", headers: { "Accept": "application/json" } })
	        .then((response) => {
	            let data = response.json();
	            return data;
	        })
	        .then((data) => {
	            console.log(data);
	            while (document.getElementById("reimbursements-completed").firstChild) {
	                document.getElementById("reimbursements-completed").removeChild(document.getElementById("reimbursements-completed").firstChild);
	            }
	            var headPen = document.createElement("H3");
	            var headNote = document.createTextNode("Completed: ")
	            headPen.appendChild(headNote);
	            document.getElementById("reimbursements-completed").appendChild(headPen);
	            for (let i = 0; i < data.length; i++) {

	                var node = document.createElement("DIV");
	                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId)
	                node.appendChild(reimId);

	                var node1 = document.createElement("DIV");
	                var reimBal = document.createTextNode("Reimbursement Balace: $" + data[i].reimbursementBalance)
	                node1.appendChild(reimBal);

	              

	                var node2= document.createElement("BR");
	                
	                document.getElementById("reimbursements-completed").appendChild(node);
	                document.getElementById("reimbursements-completed").appendChild(node1);
	                document.getElementById("reimbursements-completed").appendChild(node2);

	            }
	          
	            
	        })
	        // catching an error
	        .catch((error) => {
	            alert('something went wrong');
	            console.log(error);
	        	        })
}
function getInfoMang() {
    fetch(mUrl, { method: "GET", headers: { "Accept": "application/json" } })
        .then((response) => {
            let data = response.json();
            return data;
        })
        .then((data) => {
            console.log(data);
            while (document.getElementById("all-reimbursements-submitted").firstChild) {
                document.getElementById("all-reimbursements-submitted").removeChild(document.getElementById("all-reimbursements-submitted").firstChild);
            }
            var headPen = document.createElement("H3");
            var headNote = document.createTextNode("Submitted: ")
            headPen.appendChild(headNote);
            document.getElementById("all-reimbursements-submitted").appendChild(headPen);
            for (let i = 0; i < data.length; i++) {

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID:" + data[i].reimbursementId)
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBal = document.createTextNode("Reimbursement Balace: $" + data[i].reimbursementBalance)
                node1.appendChild(reimBal);

                var node2 = document.createElement("DIV");
                var empId = document.createTextNode(" Employee ID:" + data[i].employeeId)
                node.appendChild(empId);

                var node3= document.createElement("BR");
                

                document.getElementById("all-reimbursements-submitted").appendChild(node3);
                document.getElementById("all-reimbursements-submitted").appendChild(node);
                document.getElementById("all-reimbursements-submitted").appendChild(node3);
                document.getElementById("all-reimbursements-submitted").appendChild(node1);
                document.getElementById("all-reimbursements-submitted").appendChild(node3);
                document.getElementById("all-reimbursements-submitted").appendChild(node2);

            }
          
            
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong');
            console.log(error);
        	        })
}
function getInfoCMang() {
console.log("here1");
    fetch(mUrlC, { method: "GET", headers: { "Accept": "application/json" } })
        .then((response) => {
            let data = response.json();
            return data;
        })
        .then((data) => {
            console.log(data);
            while (document.getElementById("all-reimbursements-completed").firstChild) {
                document.getElementById("all-reimbursements-completed").removeChild(document.getElementById("all-reimbursements-completed").firstChild);
            }
            var headPen = document.createElement("H3");
            var headNote = document.createTextNode("Completed: ")
            headPen.appendChild(headNote);
            document.getElementById("all-reimbursements-completed").appendChild(headPen);
            for (let i = 0; i < data.length; i++) {

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID:" + data[i].reimbursementId)
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBal = document.createTextNode("Reimbursement Balace: $" + data[i].reimbursementBalance)
                node1.appendChild(reimBal);

                var node2 = document.createElement("DIV");
                var empId = document.createTextNode(" Employee ID:" + data[i].employeeId)
                node.appendChild(empId);

                var node3= document.createElement("BR");
                
                document.getElementById("all-reimbursements-completed").appendChild(node3);
                document.getElementById("all-reimbursements-completed").appendChild(node);
                document.getElementById("all-reimbursements-completed").appendChild(node3);
                document.getElementById("all-reimbursements-completed").appendChild(node1);
                document.getElementById("all-reimbursements-completed").appendChild(node3);
                document.getElementById("all-reimbursements-completed").appendChild(node2);


            }
          
            
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong');
            console.log(error);
        	        })
}

function populateUser() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8081/ProjectOne/session").then(function(response) {
		return response.json(); // parsing data in the response as a JS
								// object
	}).then(function(data) {
		console.log("here");

		console.log(data);

		// check whether there is a valid session
		// define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/ProjectOne/login"
		} else {
			// define behavior for when a user is returned
			user = data;

			document.getElementById("name").innerText = user.firstname+" "+user.lastname;
			console.log(user.email);
			document.getElementById("email").innerText ="Email: "+ user.email;
			document.getElementById("id").innerText = "Employee Identification Number: "+user.id;


		}
	})
}