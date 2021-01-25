
window.onload = function(){
     document.getElementById("save").addEventListener("click",saveInfo);
     //document.getElementById("myForm").addEventListener("submit",showMessage);
};

function saveInfo() {
    let expenseDate = document.getElementById("expenseDate").value;
    let expenseType = document.getElementById("expenseType").value;
    let expenseDescription = document.getElementById("expenseDescription").value;
    let expenseAmount = document.getElementById("expenseAmount").value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200){
                //let ticket = JSON.stringify(xhttp.responseText);
       } 
    }

    let ticketURL = "http://localhost:8080/ERSAPI/api/employee/ticket?expenseDate=" + expenseDate + "&expenseType=" + expenseType + "&expenseDescription=" + expenseDescription + "&expenseAmount=" + expenseAmount;
    
    xhttp.open("POST",ticketURL);
    xhttp.send();
    //alert("Expense Ticket saved successfully");
    location.reload();
}

function showMessage() {
    let sMessage = document.getElementById("msg");
    sMessage.className = "alert alert-success fade show";
}
