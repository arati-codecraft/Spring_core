function openLogin(){
document.getElementById("popup").style.display="flex";
}

function closeLogin(){
document.getElementById("popup").style.display="none";
}

function showAdminLogin(){
closeLogin();
document.getElementById("adminPopup").style.display="flex";
}

function closeAdmin(){
document.getElementById("adminPopup").style.display="none";
}

function showStudentLogin(){
closeLogin();
document.getElementById("studentPopup").style.display="flex";
}

function closeStudent(){
document.getElementById("studentPopup").style.display="none";
}

function showRegister(){
closeStudent();
document.getElementById("registerPopup").style.display="flex";
}

function closeRegister(){
document.getElementById("registerPopup").style.display="none";
}