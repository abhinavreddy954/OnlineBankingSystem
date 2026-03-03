<%@page import="com.mybanks.dto.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.mybanks.dto.BankAccountsRequest"%>
<%@page import="com.mybanks.dao.BankAccountsRequestDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank User Interface</title>
    <style>
        *{
            margin: 0;
            box-sizing: border-box;
        }
        

.parent{
display:flex;
flex-direction: column;
height:100vh;
width:100vw;
}

.child1{
background-color:green;
color:white;
height:10vh;
width:100vw;
display:flex;
align-items: center;
position:relative;
}

.child1img{
flex-basis: 20%;
height:16vh;
}

.child1text{
flex-basis:80%;
font-size: 34px;
font-weight: 600;
left:-10px;
}

.child2{
margin-left: 40px;
}

.childimg{
background-image: url("/images/banklogo.png");
    background-size: cover;         
    background-position: center;    
    background-repeat: no-repeat;    
    height: 60%;
    width: 40%;
    filter: blur(2px);
}

.parentimg{
height:100vh;
width:100vw;
position:absolute;
z-index:-1;
display:flex;
align-items:center;
justify-content:center;
}
       
</style>
</head>
<body>
<div class="parent">
<div class="parentimg">
<span class="childimg"></span>
</div>
<header class="child1">
<img class="child1img" alt="Online Banking System" src="/images/banklogo.png">
<span class="child1text">Online Banking System</span>
</header> <br> <br>

<main class="child2">
<h1>welcome to Bank employees Interface</h1>
<div style="color:red;">Note: *=required</div> <br>
<button onclick="logout()">Logout</button> <br> <br>

<script>
function logout() {
    // Clear browser history
    window.history.replaceState(null, null, "WorkerLogin.jsp");

    // Redirect to logout URL (or login page)
    window.location.replace("/worker/logout?bankworkerlogout=1");
}
</script>

<%
String successmsg= (String) request.getAttribute("msg");
if(successmsg != null){
%>
<div style="color:green;font-size:13px;"><%=successmsg%></div>
<%
}%>

<form action="employee/emp" method="post">
  <button type="submit" style="height:25px;">Create New Login Account For Another Employee</button>
</form>

<form action="employee/accrequest" method="post">
  <button type="submit" style="height:25px;">Bank Account Requests</button>
</form>

<form action="employee/saveAddress" method="post">
  <button type="submit" style="height:25px;">Add NewBank Address</button>
</form>

<form action="employee/fetchAllAddress" method="get">
  <button type="submit" style="height:25px;">check all address</button>
</form>


<form action="employee/fetchAddress" method="get" modelAttribute="CheckAddress">
<label for="id">Enter Address ID <span style="color:red">*</span></label> <br>
<input type="number" placeholder="enter address id" name="id" required="required" id="id">
  <button type="submit" style="height:25px;">check address by id</button>
</form>

  <a href="employee/updateAddress"><button type="submit" style="height:25px; ">update address by id</button></a>


<!-- <a href="employee/accountsrequest"><button style="height:25px;">New credit or debit card requests</button></a>
 -->
</main>
</div>
</body>
</html>