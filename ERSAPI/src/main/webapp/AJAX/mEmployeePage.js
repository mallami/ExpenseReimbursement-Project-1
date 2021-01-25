
window.onload = function(){
     document.getElementById("save").addEventListener("click",saveInfo);
};

function saveInfo(){
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let roleId = document.getElementById("empRole").value;

    //console.log(firstName + "  " + lastName + "  " + phone + "  " + email + "  " + password + "  " + roleId);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){

        if(xhttp.readyState == 4 && xhttp.status == 200){
                //let emp = JSON.stringify(xhttp.responseText);
       } 
    }

    let empURL = "http://localhost:8080/ERSAPI/api/manager/employee?firstName=" + firstName + "&lastName=" + lastName + "&phone=" + phone + "&email=" + email + "&password=" + password + "&roleId=" + roleId;
    
    xhttp.open("POST",empURL);
    xhttp.send();

    //alert("New employee saved successfully");

}
