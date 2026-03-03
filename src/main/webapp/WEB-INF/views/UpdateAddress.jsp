<%@page import="java.util.List"%>
<%@page import="com.mybanks.dto.Address"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Existing Address</title>
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
<h1>Update Address</h1>
<div style="color:red">Note: *=required</div> <br>
<form action="/employee/updateaddress" method="post" modelAttribute="UpdateAddress">
<label for="addressId">Address ID <span style="color:red">*</span></label>
<input type="number" required="required" placeholder="enter street name" name="id" id="addressId"/>
<label for="streetName">Street Name <span style="color:red">*</span></label>
<input type="text" required="required" placeholder="enter street name" name="streetName" id="streetName"/>
<label for="cityName">City Name <span style="color:red">*</span></label>
<input type="text" required="required" placeholder="enter city name" name="cityName" id="cityName"/>
<label for="country">Country name <span style="color:red">*</span></label>
<input type="text" required="required" placeholder="enter country name" name="country" id="country"/>
<label for="ifsccode">IFSC code <span style="color:red">*</span></label>
<input type="text" required="required" placeholder="enter IFSC Code" name="ifsccode"/ id="ifsccode">
<button type="submit">submit</button>
</form>
</main>
</div>
</body>
</html>