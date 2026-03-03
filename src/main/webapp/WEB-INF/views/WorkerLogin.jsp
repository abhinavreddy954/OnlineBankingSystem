<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee login</title>

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

.child2form{
display:flex;
justify-content: center;
margin-top: 10vh;
}

        form{
            background-color: black;
            color: white;
            height: 60vh;
            width: 34vw;
            display: flex;      
            align-items: center;   
            justify-content: center;
            flex-direction: column;
        }
        h2{
            align-items:flex-start;
            justify-content: center;
        }
        #row1,#row2{
            flex-direction: row;
        }
        
         button:hover{
           cursor: pointer;
           transform: scale(1.05);
           transition: 0.3s;
        }
        
        button {
    border: 2px solid transparent;   /* remove default grey */
    border-radius: 5px;
    padding: 6px;
    width: 6vw;
    background: black;
    color: gold;
}

button:focus-visible {
    border: 4px solid #5C6BC0;
    outline: none;
}
      
    </style>
    
    <script>
window.onload = function () {
	<%
	String error = (String) session.getAttribute("errorMessage");
	String errorField = (String) session.getAttribute("errorField");
	%>

    <% if ("username".equals(errorField)) { %>
        var userField = document.getElementById("user");
        userField.focus();
        userField.style.border = "2px solid red";
    <% } else if ("password".equals(errorField)) { %>
        var pwdField = document.getElementById("pwd");
        pwdField.focus();
        pwdField.style.border = "2px solid red";
    <% } %>

};
</script>
    
</head>
<body>
<div class="parent">
<header class="child1">
<img class="child1img" alt="Online Banking System" src="/images/banklogo.png">
<span class="child1text">Online Banking System</span>
</header> <br> <br>

<main class="child2">
 <a href="/home"><button  style="color:gold;background-color:black;padding:6px;">Back to home Page</button></a>
<div class="child2form">
    <form action="${pageContext.request.contextPath}/perform_workerlogin" method="post">
    <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
    
<% if (error != null) { %>
<div id="errorcredentials" 
     style="color:red;background-color:white;height:4vh; width:30vw; font-weight:bold;"
     role="alert" aria-live="assertive">
    <%= error %>
</div>
<%
}
%>
         
          <%
         String msg= (String) request.getAttribute("msg");
         if(msg != null){
        	 %>
        	 <div style="color:white"><%=msg %></div>
        	 <% 
         }
         %>
         
         
        <h1>Bank Worker Login</h1>
        <br><br>
        <div id="row1">
        <div style="color:red"> *= required</div> <br>
        <label for="user"><span style="color:red;">*</span>user name :</label>
        <input autocomplete="off" required id="user" type="text" placeholder="user name" name="username" <%= ("password".equals(errorField) ? 
            "aria-describedby='errorcredentials' aria-invalid='true'" 
            : "") %>>
        
        </div>
        <br><br>
        <div id="row2">
        <label for="pwd"><span style="color:red;">*</span> password :</label>
        <input autocomplete="off" required id="pwd" type="password" placeholder="password" name="password" <%= ("password".equals(errorField) ? 
            "aria-describedby='errorcredentials' aria-invalid='true'" 
            : "") %>>  
      
        </div>
        <br><br>
         <input type="submit" placeholder="submit" name="sbt">  
    </form>
    </div>
</main>
</div>
</body>
</html>