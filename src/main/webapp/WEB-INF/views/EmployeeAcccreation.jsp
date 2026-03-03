<html>
<head>
<title>New Employee Account Create</title>
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

input:focus{
border:2px solid red;
outline:none;
box-shadow:0 0 5px rgb(46,204,113,0.5);
}

</style>
</head>
<body>
<%
  String msg= (String) request.getAttribute("errmsg");
    if(msg != null){
%>
      <div style="color:red"><%=msg %></div>
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
<h1>Employee Account Creation</h1>
<div style="color:red">*= required</div>
<form action="empaccdetails" method="post">
<label for="user">Employee User Name<span style="color:red;">*</span></label><br>
<input style="width:240px; border-radius:5px;padding:4px;" type="text" placeholder="enter new employee username" name="user" id="user" autocomplete="off" required/> <br><br>
<label for="pwd">Employee Password<span style="color:red;">*</span></label><br>
<input style="width:240px; border-radius:5px;padding:4px;" type="password" placeholder="enter new employee password" name="pwd" id="pwd" autocomplete="off" required/> <br><br>
<button>submit</button>
</form>
</main>
</div>
</body>
</html>