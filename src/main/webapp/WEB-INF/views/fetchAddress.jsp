<%@page import="com.mybanks.dto.Address"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch Address</title>
<head>
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
<%
Address a=(Address) request.getAttribute("keyfetched");
if(a != null){
	%>
	<h1> Address fetch with the address ID</h1>
	<br><br>
	<table border="1">
	<tr>
            <th>ID </th>
            <th>CityName() </th>
            <th>StreetName() </th>
            <th> Country()</th>
        </tr>
	<tr>
            <td><%= a.getAddressId() %></td>
            <td><%= a.getCityName() %></td>
            <td><%= a.getStreetName() %></td>
            <td><%= a.getCountry() %></td>
        </tr>
        </table>
	<%
}
else{
	%>
	<h1><%=a %></h1>
	<%
}
%>

<br><br>
<a href="bankuserinterface" >continue to bank user interface</a>

</main>
</div>
</body>
</html>