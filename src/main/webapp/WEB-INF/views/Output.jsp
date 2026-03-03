<%@page import="com.mybanks.dto.Address"%>
<!DOCTYPE html>
<html>
<head>
<title>
Results 
</title>
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
Address a=(Address) request.getAttribute("result");

String msg=(String) request.getAttribute("key");
if(msg != null){
	%>
	<h1><%=msg %></h1>
	<%
}

else if(a !=null){
	%>
	<table>
	<caption> Bank Address updated in database</caption>
	<tr>
	<th>
	address id
	</th>
	<th>
	city name
	</th>
	<th>
	street name
	</th>
	<th>
	country name
	</th>
	</tr>
	
	<tr>
	<td>
	<%=a.getAddressId() %>
	</td>
	<td>
	<%=a.getCityName() %>
	</td>
	<td>
	<%=a.getStreetName() %>
	</td>
	<td>
	<%=a.getCountry() %>
	</td>
	</tr>
	</table>
	<%
	}
	else{
		%>
		<h1>something went wrong</h1>
		<%
	}
%>


<br> <br>
<a href="bankuserinterface">Continue here to Bank User Interface</a>
</main>
</div>
</body>
</html>