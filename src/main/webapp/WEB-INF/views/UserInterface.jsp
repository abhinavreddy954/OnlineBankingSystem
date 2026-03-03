
<%@page import="com.mybanks.dto.BankAccounts"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="com.mybanks.dao.BankAccountsDao"%>
<%@page import="java.util.List"%>
<%@page import="com.mybanks.controller.LoginController"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.mybanks.dto.*"%>
<html>
<head>
<title>User Interface</title>
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
<button onclick="logout()" style="border-radius:5px;">Logout</button> <br> <br>

<script>
function logout() {
    window.location.href = "/user/logout";
}
</script>

<%
BankAccounts bankAccount = (BankAccounts) request.getAttribute("bankAccount");
BankAccountsRequest accountRequest = 
        (BankAccountsRequest) request.getAttribute("accountRequest");
if (bankAccount != null) {
%>

    <form action="customer/editbankinternetaccountdetails" method="post">
        <button style="border-radius:5px;">Edit Internet banking details</button>
    </form> <br>

    <form action="customer/bankaccountdetails" method="post">
        <input type="hidden" name="accountId" 
               value="<%= bankAccount.getBankId() %>">
        <button style="border-radius:5px;">Bank Account Details</button>
    </form>  <br>
    
    
 <button type="button" id="send" style="border-radius:5px;">Send Amount</button>
<div id="formContainer"></div>

<script>
var send = document.getElementById("send");  
var container = document.getElementById("formContainer");

send.addEventListener("click", function() {

    container.innerHTML = `
        <form method="post" action="customer/sendmoney">
            <h2>Enter Details Required To Continue</h2>
            <input type="hidden" name="accountIdSender"
                   value="<%= bankAccount.getBankId() %>"/>
            <label for="amt">Enter amount <span style="color:red;">*</span></label> <br>
            <input type="number" name="amount"
                   placeholder="Enter amount" required id="amt" style="border-radius:5px;width:20vw;"> <br> <br>
                   
            <label for="user">Enter receiver account number <span style="color:red;">*</span></label> <br>
            <input type="number" name="receiverAccountNo"
                   placeholder="Enter receiver account number" required id="user" style="border-radius:5px;width:20vw;"> <br> <br>

            <button type="submit" style="border-radius:5px;">Transfer Amount</button>
        </form>
    `;
});
</script>
    

<%
} 
else if (accountRequest != null) {
%>

    <form action="customer/editbankinternetaccountdetails" method="post">
        <button style="border-radius:5px;">Edit Internet banking details</button>
    </form>  <br>

    <form action="customer/fetchbankaccountrequest" method="post">
        <input type="hidden" name="accountRequestId" 
               value="<%= accountRequest.getBankReqId() %>">
        <button style="border-radius:5px;">My New Bank Account Requests</button>
    </form>
    

<%
} 
else {
%>

    <form action="customer/editbankinternetaccountdetails" method="post">
        <button style="border-radius:5px;">Edit Internet banking details</button>
    </form>  <br>

    <form action="customer/fetchAllAddressforNewACC" method="post">
        <button style="border-radius:5px;">Create New Bank Account</button>
    </form>

<%
}
%>


<%
/* =SUCCESS MESSAGE = */
String successMessage = (String) request.getAttribute("successRequest");
if (successMessage != null) {
%>
    <div style="color:green;"><%=successMessage%></div>
<%
}

/* =ERROR MESSAGE = */
String errormessage = (String) request.getAttribute("errormsg");
if (errormessage != null) {
%>
    <div style="color:red;"><%=errormessage%></div>
<%
}
%>
</main>
</div>
</body>
</html>