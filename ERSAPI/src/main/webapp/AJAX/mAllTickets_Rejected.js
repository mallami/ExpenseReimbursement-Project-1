
window.onload = function() {
    getAllTickets();
    document.getElementById("approve").addEventListener("click",approveTicket);
    document.getElementById("reject").addEventListener("click",rejectTicket);
    document.getElementById("delete").addEventListener("click",deleteTicket);
    document.getElementById("mcheck").addEventListener("click",function() {
        if(document.getElementById("mcheck").checked) {
            let tRow = document.querySelectorAll(".chk");
            for(let i of tRow) {
                i.checked = true;
            }
        } else {
            let tRow = document.querySelectorAll(".chk");
            for(let i of tRow) {
                i.checked = false;
            }
        }
    });
}

function getAllTickets() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200) {

            let ticketList = JSON.parse(xhttp.responseText);
            
            DOMManipulation(ticketList);
        }

    } 

    let key = document.getElementById("statusName").value="Rejected"; 
    let reqURL = "http://localhost:8080/ERSAPI/api/manager/ticketstatus?statusName=" + key; 
     
    xhttp.open("GET",reqURL);
    xhttp.send();
}

function approveTicket() {
    let tRow = document.querySelectorAll(".chk");
    let array = [];
    for(let i of tRow) {
        if(i.checked) {
            array.push(i.value);
        }
    }

    if(array.length === 0) {
        window.alert("No ticket selected");
    } else {
        for(let tId of array) {
            reqURL = "http://localhost:8080/ERSAPI/api/manager/ticketapprove?ticketId=" + tId + "&statusId=3&comment=null";
            let xhttp = new XMLHttpRequest();
            xhttp.open("PUT",reqURL);
            xhttp.send();
        }
        location.reload();
        window.alert("(" + array.length + ") Ticket(s) approved successfully");
    }
}

function rejectTicket() {
    let tRow = document.querySelectorAll(".chk");
    let array = [];
    for(let i of tRow) {
        if(i.checked) {
            array.push(i.value);
        }
    }

    if(array.length === 0) {
        window.alert("No ticket selected");
    } else {
        for(let tId of array) {
            reqURL = "http://localhost:8080/ERSAPI/api/manager/ticketapprove?ticketId=" + tId + "&statusId=4&comment=null";
            let xhttp = new XMLHttpRequest();
            xhttp.open("PUT",reqURL);
            xhttp.send();
        }
        location.reload();
        window.alert("(" + array.length + ") Ticket(s) rejected successfully");
    }
}

function deleteTicket() {
    let tRow = document.querySelectorAll(".chk");
    let array = [];
    for(let i of tRow) {
        if(i.checked) {
            array.push(i.value);
        }
    }

    if(array.length === 0) {
        window.alert("No ticket selected");
    } else {
        for(let tId of array) {
            reqURL = "http://localhost:8080/ERSAPI/api/manager/ticket?ticketId=" + tId;
            let xhttp = new XMLHttpRequest();
            xhttp.open("DELETE",reqURL);
            xhttp.send();
        }
        location.reload();
        window.alert("(" + array.length + ") Ticket(s) deleted successfully");
    }
}

function DOMManipulation(tList) {

    let tBody = document.getElementById("allTickets");

   for(let i in tList) {
        
        let tRow = document.createElement("tr");

        let rCell = document.createElement("td");
        let check = document.createElement("input");
        check.setAttribute("type","checkbox");
        check.setAttribute("value",tList[i].ticketId);
        check.className = "chk";
        rCell.appendChild(check);
        tRow.appendChild(rCell);

        let rCell1 = document.createElement("td");
        rCell1.innerHTML = tList[i].ticketId;
        rCell1.id = tList[i].ticketId;
        tRow.appendChild(rCell1);

        let rCell2 = document.createElement("td");
        rCell2.innerHTML = tList[i].firstName;
        tRow.appendChild(rCell2);
        
        let rCell3 = document.createElement("td");
        rCell3.innerHTML = tList[i].lastName;
        tRow.appendChild(rCell3);
        
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
        rCell8.title = tList[i].resultComment;
        tRow.appendChild(rCell8);
        
        tBody.appendChild(tRow);
   }

}