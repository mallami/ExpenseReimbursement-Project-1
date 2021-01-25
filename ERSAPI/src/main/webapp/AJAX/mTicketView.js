
window.onload = function() {
    getTicket();
}

function getTicket() {

    let tId = document.getElementById("ticketId").value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200) {

            let ticket = JSON.parse(xhttp.responseText);
            
            DOMManipulation(ticket);
        }

    } 

    let reqURL = "http://localhost:8080/ERSAPI/api/ticket?ticketId=" + tId; 
     
    xhttp.open("GET",reqURL);
    xhttp.send();
}

function DOMManipulation(ticket) {

    document.getElementById("expenseDate").value = ticket.submitDate.monthValue + "/" + ticket.submitDate.dayOfMonth + "/" + ticket.submitDate.year;
    document.getElementById("expenseType").value = ticket.expenseType;
    document.getElementById("expenseDescription").value = ticket.expenseDescription;
    document.getElementById("expenseAmount").value = ticket.expenseAmount;

}