<!DOCTYPE html>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.mybanks.dao.BankAccountsRequestDao"%>
<%@page import="com.mybanks.dto.Address"%>
<%@page import="com.mybanks.dto.BankAccountsRequest"%>
<%@page import="com.mybanks.dto.BankAccounts"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bank request accepting page</title>
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
<h1>New Bank Account</h1>
<form action="BankAccountsController" method="post" modelAttribute="BankAccData">
<label>Bank AccNo</label>
<input type="number" maxlength=12 minlength=12 required="required" placeholder="enter bank acc no" name="AccNo" >
<%
String amountDeposited= request.getParameter("amount");
int AddressID= Integer.parseInt(request.getParameter("branchAddressID"));
System.out.println("AddressID"+" "+AddressID);
 int bankreqId=Integer.parseInt(request.getParameter("bankreqid"));
 String schemeType=request.getParameter("scheme");
 String salutation=request.getParameter("salutation");
 String userFullName=request.getParameter("userFullName");
 String userName=request.getParameter("userName");
 String fatherName=request.getParameter("fatherName");
 String motherName=request.getParameter("motherName");
 String gender=request.getParameter("gender");
 String dateOfBirth=request.getParameter("dob");
 long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
 String emailId=request.getParameter("emailId");
 String state=request.getParameter("state");
 String district=request.getParameter("district");
 //String branchAddress=request.getParameter("branchAddress");
%>
<label for="bal">Account Balance <span style="color:red;">*</span></label>
<input id="bal" type="number" required 
       placeholder="enter balance to be deposited" 
       name="bal" value="<%=amountDeposited %>">

<label for="addressId">Address Id <span style="color:red;">*</span></label>
<input id="addressId" type="number" required 
       placeholder="enter branch Address Id" 
       name="addressId" value="<%=AddressID %>">

<label for="bankReqId">Bank Req Id <span style="color:red;">*</span></label>
<input id="bankReqId" type="text" required 
       placeholder="enter bank id" 
       name="bankReqId" value="<%=bankreqId %>">

<label for="scheme">Scheme Type <span style="color:red;">*</span></label>
<input id="scheme" type="text" required 
       placeholder="enter scheme Type" 
       name="scheme" value="<%=schemeType %>">

<label for="salutation">Salutation <span style="color:red;">*</span></label>
<input id="salutation" type="text" required 
       placeholder="enter salutation" 
       name="salutation" value="<%=salutation %>">

<label for="username">User Name <span style="color:red;">*</span></label>
<input id="username" type="text" required 
       placeholder="enter user Name" 
       name="username" value="<%=userName%>">

<label for="userfullname">User Full Name <span style="color:red;">*</span></label>
<input id="userfullname" type="text" required 
       placeholder="enter user full name" 
       name="userfullname" value="<%=userFullName%>">

<label for="fatherName">Father Name <span style="color:red;">*</span></label>
<input id="fatherName" type="text" required 
       placeholder="enter father Name" 
       name="fatherName" value="<%=fatherName %>">

<label for="motherName">Mother Name <span style="color:red;">*</span></label>
<input id="motherName" type="text" required 
       placeholder="enter mother Name" 
       name="motherName" value="<%=motherName %>">

<label for="gender">Gender <span style="color:red;">*</span></label>
<input id="gender" type="text" required 
       placeholder="enter your gender" 
       name="gender" value="<%=gender %>">

<label for="dob">Date Of Birth <span style="color:red;">*</span></label>
<input id="dob" type="date" required 
       name="dob" value="<%=dateOfBirth %>">

<label for="mobileno">Mobile No <span style="color:red;">*</span></label>
<input id="mobileno" type="tel" required 
       placeholder="enter mobile No" 
       name="mobileno" value="<%=mobileNo %>">

<label for="emailId">Email Id <span style="color:red;">*</span></label>
<input id="emailId" type="email" required 
       placeholder="enter email Id" 
       name="emailId" value="<%=emailId %>">

<label for="state">State <span style="color:red;">*</span></label>
<input id="state" type="text" required 
       placeholder="enter state" 
       name="state" value="<%=state %>">

<label for="district">District <span style="color:red;">*</span></label>
<input id="district" type="text" required 
       placeholder="enter district" 
       name="district" value="<%=district %>">
<button type="submit">submit</button>
</form>
</main>
</div>
</body>
</html>