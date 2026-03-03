<%@page import="org.springframework.security.crypto.password.PasswordEncoder"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.mybanks.dto.*" %>
<%@page import="com.mybanks.dao.*" %>
<html>
<head>
<title>Bank Account Details</title>
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
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
BankAccounts bankAccounts=(BankAccounts)request.getAttribute("account");
String userName=(String)request.getAttribute("un");
//String pwd=(String)request.getAttribute("pwd");
InternetBankingRegistration editInternetBanking=(InternetBankingRegistration)request.getAttribute("internetbankingaccount");
BankAccountsRequest bankAccountsRequest= (BankAccountsRequest)request.getAttribute("accountsRequest");

//System.out.println("details fetched in jsp page"+editInternetBanking+" "+userName+" "+pwd);
if(bankAccounts != null){
String name= bankAccounts.getUserfullname();
long accountNo = bankAccounts.getBankAccNo();
double balance = bankAccounts.getBalance();
Address address = bankAccounts.getAddress();
String branchaddress= address.getStreetName()+","+address.getCityName()+","+address.getCountry();
String IFSCCode= address.getIfscCode();
%>

<h2 aria-level="h1">Welcome to bank user interface</h2>
<h3 aria-level="h2">Your Bank account details:</h3>
Name:
<h5><%= name %></h5>
Bank Account Number :
<h5><%= accountNo %></h5>
Account Balance :
<h5><%= balance %></h5>
Branch Address :
<h5><%=branchaddress %></h5>
Bank IFSC Code:
<h5><%=IFSCCode %></h5>
<%
} else if(editInternetBanking != null && userName != null){
	%>
	<h2 aria-level="h1">Edit your Internet Banking Account details</h2>
	
 <span style="color:red"><strong>Note:</strong>This changes also affects in your new bank accounts Requests and existing Bank Accounts if available</span>
	<form action="${pageContext.request.contextPath}/ibrupdate" method="post"  style=" display:flex; align-items:center;gap:4px;">
	<label for="phone">phone Number</label><br>
	<input style="border:solid grey 2px; width:16vw;" id="phone" name="phone" type="tel"  placeholder="enter phone number" value="<%=editInternetBanking.getPhone()%>"/><br><br>
	<label for="username">user name</label><br>
	<input style="border:solid grey 2px; width:16vw;" id="username" name="user" type="text" placeholder="enter user name" readonly value="<%=editInternetBanking.getUserName()%>"/><br><br>
	<label for="pwd">Password</label><br>
	<div style="border:solid grey 2px; width:16vw; display:flex; align-items:center;" >
	    <img  onclick="togglePwd()" src="/images/eye.png" alt="eye" id="eye" height="20px" width="40px">
	    <input style="border:none;" id="pwd" type="password" name="pwd" placeholder="enter your new password" ">
	</div>
	
	<script>
    function togglePwd() {
      const p = document.getElementById("pwd");
      if(p) p.type = p.type === "password" ? "text" : "password";
    }
    </script>

	<br>
	<label for="email">Email</label><br>
	<input style="border:solid grey 2px; width:16vw;" id="email" type="text" name="email" placeholder="enter email" value="<%=editInternetBanking.getEmail()%>"/><br><br>
	<button style="height:25px; width:100px;">update</button>
	</form>
<%
}else if(bankAccountsRequest != null && bankAccounts==null){
	    String userFullName = (String)request.getAttribute("name");
	    Integer bankReqID = (Integer)request.getAttribute("bankReqId");
	    String email = (String)request.getAttribute("email");
	    Double amount = (Double)request.getAttribute("amount");
	    %>
	<h2 aria-level="h1">Welcome to bank user interface</h2>
    <h3 aria-level="h2">Your Requested bank account details:</h3>
    <label for=""></label>
    Name :
    <h5><%= userFullName %></h5>
    Bank Request ID :
    <h5><%= bankReqID %></h5>
    Email :
    <h5><%= email %></h5>
    Amount To be deposited:
    <h5><%= amount %></h5>
	<% 
}else{
	String failuremsg= (String)request.getAttribute("key");
	if(failuremsg != null){
		%>
		<div style="color:green;"><%= failuremsg %></div>
		<% 	
	}
}

String successMessage = (String) request.getAttribute("successRequest");
if (successMessage != null) {
%>
    <div style="color:green;"><%= successMessage %></div>
    <br> <br>
    <button onclick="window.location.href='${pageContext.request.contextPath}/user/logout?bankuserlogout=0'" style="height:25px; width:100px;color:white; background-color:black;">back to home</button>
<%
}
%> <br> <br>


</main>
</div>
</body>
</html>