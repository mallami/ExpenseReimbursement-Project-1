
window.onload = function() {
    getAllTickets();
}

function getAllTickets() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200) {

            let ticketList = JSON.parse(xhttp.responseText);
            
            DOMManipulation(ticketList);
        }

    } 

    let reqURL = "http://localhost:8080/ERSAPI/api/employee/ticket";
     
    xhttp.open("GET",reqURL);
    xhttp.send();
}

function DOMManipulation(tList) {

    let tBody = document.getElementById("allTickets");

   for(let i in tList) {
        
        let tRow = document.createElement("tr");

        let rCell1 = document.createElement("td");
        rCell1.innerHTML = tList[i].ticketId;
        //rCell1.innerHTML = String(tList[i].ticketId).link("http://localhost:8080/ERSAPI/api/ticket?ticketId=" + String(tList[i].ticketId));
        tRow.appendChild(rCell1);

        let rCell4 = document.createElement("td");
        rCell4.innerHTML = tList[i].expenseTypeName;
        rCell4.title = tList[i].expenseDate.monthValue + "/" + tList[i].expenseDate.dayOfMonth + "/" + tList[i].expenseDate.year + " : " + tList[i].expenseDescription;
        tRow.appendChild(rCell4);
        
        let rCell5 = document.createElement("td");
        rCell5.innerHTML = tList[i].statusName;
        tRow.appendChild(rCell5);
        
        let rCell6 = document.createElement("td");
        rCell6.innerHTML = "$ " + tList[i].expenseAmount;
        tRow.appendChild(rCell6);
                
        let rCell7 = document.createElement("td");
        if(tList[i].statusName !== "Draft") {
            rCell7.innerHTML = tList[i].submitDate.monthValue + "/" + tList[i].submitDate.dayOfMonth + "/" + tList[i].submitDate.year;
        } else {
            rCell7.innerHTML = " ";
        }
        tRow.appendChild(rCell7);    

        let rCell8 = document.createElement("td");
        if(tList[i].statusName !== "Draft" && tList[i].statusName !== "Submitted") {
            rCell8.innerHTML = tList[i].resultDate.monthValue + "/" + tList[i].resultDate.dayOfMonth + "/" + tList[i].resultDate.year;
        } else {
            rCell8.innerHTML = " ";
        }
        tRow.appendChild(rCell8);

        let rCell9 = document.createElement("td");
        rCell9.innerHTML = tList[i].resultComment;
        tRow.appendChild(rCell9);

        tBody.appendChild(tRow);
   }

}