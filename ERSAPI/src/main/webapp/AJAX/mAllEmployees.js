
window.onload = function() {
    getAllEmployees();
}

function getAllEmployees() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200) {

            let employeeList = JSON.parse(xhttp.responseText);
            
            DOMManipulation(employeeList);
        }

    } 

    let reqURL = "http://localhost:8080/ERSAPI/api/manager/allemployees";
     
    xhttp.open("GET",reqURL);
    xhttp.send();
}

function DOMManipulation(eList) {

    let tBody = document.getElementById("allEmployees");

   for(let i in eList) {
        
        let tRow = document.createElement("tr");

        let rCell1 = document.createElement("td");
        //rCell1.innerHTML = String(eList[i].employeeId).link("http://localhost:8080/ERSAPI/api/manager/employee?employeeId=" + String(eList[i].employeeId));
        rCell1.innerHTML = eList[i].employeeId;
        tRow.appendChild(rCell1);

        let rCell2 = document.createElement("td");
        rCell2.innerHTML = eList[i].firstName;
        tRow.appendChild(rCell2);
        
        let rCell3 = document.createElement("td");
        rCell3.innerHTML = eList[i].lastName;
        tRow.appendChild(rCell3);
        
        let rCell4 = document.createElement("td");
        let p = String(eList[i].phone);
        rCell4.innerHTML = "(" + p.substr(0,3) + ") " + p.substr(3,3) + "-" + p.substr(6,9);
        tRow.appendChild(rCell4);
        
        let rCell5 = document.createElement("td");
        rCell5.innerHTML = eList[i].email;
        tRow.appendChild(rCell5);
        
        let rCell6 = document.createElement("td");
        let str = "";
        switch(eList[i].roleId) {
            case 1: str = "Chief Financial Officer";
                    break;
            case 2: str = "Finance Manager";
                    break;
            case 3: str = "Employee";
        }
        rCell6.innerHTML = str;
        tRow.appendChild(rCell6);

        tBody.appendChild(tRow);
   }

}