<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to bank</title>
<style type="text/css">
*{
box-sizing:border-box;
margin:0;
}
#main{
display:flex;
align-items: center;
justify-content: center;
height:100vh;
width:100vw;
color:grey;
}

button:hover{
    cursor: pointer;
    transform: scale(1.05);
    transition: 0.3s;
}

button:focus{
	border-color:#5C6BC0;
	border-width:4px;
	outline:none;
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
<div id="main">
<div id="sub">
<h1 >Welcome to online Banking System</h1> <br> <br>
<button onclick="window.location.href='/home'" style="color:gold;background:black; border-radius:5px;padding:6px;width:6vw;align-content: center; ">start</button>
</div>
</div>
</body>
</html>