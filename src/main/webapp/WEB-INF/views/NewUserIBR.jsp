<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Internet Banking Account</title>
</head>
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
position:relative;
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

main{
margin-left: 8%;
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
<body>
<%
String msg=(String) request.getAttribute("key");
if(msg!=null){
	%>
	<h1><%=msg%></h1>
	<%
}
%>
<div class="parent">
<div class="parentimg">
<span class="childimg"></span>
</div>
<header class="child1">
<img class="child1img" alt="Online Banking System" src="/images/banklogo.png">
<span class="child1text">Online Banking System</span>
</header> <br> <br>

<main>
<form action="IBR" method="post">
<h1>Enter Details below to create internet banking account</h1>
 <span style="color:red;">*= Required</span> <br> <br>
    <label for="user"> <span style="color:red;">*</span>User Name (i.e user name for internet banking account)</label> <br>
    <input id="user" required type="text" placeholder="enter user name*" name="user"> <br> <br>
    <label for="pwd"><span style="color:red;">*</span> Password</label> <br>
    <input id="pwd" required type="password" placeholder="enter password*" name="pwd"> <br> <br>
    <label for="rpwd"><span style="color:red;">*</span> Retype Password</label> <br>
    <input id="rpwd"required type="password" placeholder="retype password*" name="retypepwd"> <br> <br>
    <label for="phone"><span style="color:red;">*</span> Phone number</label> <br>
    <input id="phone" required type="number" placeholder="enter phone number*" name="phone"> <br> <br>
    <label for="email"><span style="color:red;">*</span> Email address</label> <br>
    <input id="email" required type="email" placeholder="enter your email address*" name="email"> <br> <br>
    <input required type="submit" value="Register">
    <!--<input type="number" placeholder="enter your debit card number*" name="debitno">
    <input type="date" placeholder="enter expiry date*" name="expirydate">
    <input type="text" placeholder="enter bank ifsc code*" name="ifsccode">
     -->
</form>
</main>
</div>
</body>
</html>