<%@page import="java.util.List"%>
<%@page import="com.mybanks.dto.Address"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch All Bank Address</title>
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
<h1>All Bank Address</h1> <br>
<%
List<Address> address = (List<Address>) request.getAttribute("keyfetchall");
System.out.println(address);
if (address != null && !address.isEmpty()) {
%>
    <table border="1">
        <caption>Bank Addresses Saved in Database</caption>
        <tr>
            <th>Address ID</th>
            <th>City Name</th>
            <th>Street Name</th>
            <th>Country Name</th>
        </tr>
<%
    for (Address a : address) {
%>
        <tr>
            <td><%= a.getAddressId() %></td>
            <td><%= a.getCityName() %></td>
            <td><%= a.getStreetName() %></td>
            <td><%= a.getCountry() %></td>
        </tr>
<%
    }
%>
    </table>
<%
} else {
%>
    <h1>No addresses found in DB</h1>
<%
}
%>
<br><br>
<a href="bankuserinterface">continue to bank user interface</a>
</main>
</div>
</body>
</html>