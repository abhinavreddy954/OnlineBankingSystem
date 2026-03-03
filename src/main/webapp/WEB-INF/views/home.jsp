<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
*{
box-sizing: border-box;
margin:0;
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
position:relative;
z-index: 1;
}

.child2content{
margin-left:40px;
}

h4{
margin-bottom:10px;
}

a{
text-decoration: none;
}

.childimg{
background-image: url("/images/banklogo.png");
    background-size: cover;          /* image fills div */
    background-position: center;     /* center image */
    background-repeat: no-repeat;    /* no repeat */
    height: 60%;
    width: 40%;
    filter: blur(2px);
}

.parentimg{
height:100vh;
width:100vw;
position:absolute;
display:flex;
align-items:center;
justify-content:center;
z-index: -1;
}

.back:hover{
    cursor: pointer;
    transform: scale(1.05);
    transition: 0.3s;
}

.back:focus-visible {
    border: 4px solid #5C6BC0;
    outline: none;
}

button {
    border: 2px solid transparent;   /* remove default grey */
    border-radius: 5px;
    padding: 6px;
    width: 6vw;
    background: black;
    color: gold;
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
<div class="child2content">
<h1>Welcome to Bank Home Page</h1><br>
<h4 aria-level="2" style="color:red">choose any one of the option you want to proceed with</h4>
<ol>
<li><a href="/emp">create new account for Employee</a></li> <br>
<li><a href="/worker/login">Continue here to login as Bank Employee</a></li> <br>
<li><a href="/ibr">create New Online Banking Account</a></li> <br>
<li><a href="/user/login">Already have a Online Banking account <br>
                                Continue here to login as a customer</a></li>
</ol>
</div>
<br><br>
<button onclick="window.location.href='/'" class="back" style="color:gold;background:black; border-radius:5px;padding:6px;width:9vw;align-content: center; ">Back To Welcome Page</button>
</main>
</div>
</body>
</html>