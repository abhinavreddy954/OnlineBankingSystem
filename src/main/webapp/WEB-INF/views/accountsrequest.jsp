
<%@page import="java.util.List"%>
<%@page import="com.mybanks.dto.BankAccountsRequest"%>
<%@page import="com.mybanks.util.ResponseStructureList"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.mybanks.service.BankingAccountsRequestService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Requests</title>

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
<h1>Bank Account requests</h1>
<%
List<BankAccountsRequest> accountsRequest=(List<BankAccountsRequest>) request.getAttribute("key");
if(accountsRequest != null && !accountsRequest.isEmpty()){
	for (BankAccountsRequest req : accountsRequest) {
	%>
	<table border="1">
	<tr>
	<th>
	user Name
	</th>
	<th>
	gender 
	</th>
	<th>
	mobile No
	</th>
	<th>
	scheme Type
	</th>
	<th>
	district
	</th>
	<th>
	State
	</th>
	<th>
	Requested Branch Address ID
	</th>
	<th colspan="2">
	Select
	</th>
	</tr>
	<tr>
	<td>
	<%=req.getUserName() %>
	</td>
	<td>
	<%=req.getGender() %>
	</td>
	<td>
	<%=req.getMobileNo() %>
	</td>
	<td>
	<%=req.getSchemeType() %>
	</td>
	<td>
	<%=req.getDistrict() %>
	</td>
	<td>
	<%=req.getState() %>
	</td>
	<td>
	<%=req.getBranchID() %>
	</td>
   <form action="/employee/NewBAcc" method="post">
    <td>
        <input type="hidden" name="bankreqid" value=<%=req.getBankReqId()%> >
        <input type="hidden" name="scheme" value=<%=req.getSchemeType()%> >
        <input type="hidden" name="salutation" value=<%=req.getSalutation() %> >
        <input type="hidden" name="userName" value=<%=req.getUserName() %> >
        <input type="hidden" name="userFullName" value=<%=req.getUserfullname() %> >
        <input type="hidden" name="fatherName" value=<%=req.getFatherName() %> >
        <input type="hidden" name="motherName" value=<%=req.getMotherName()%> >
        <input type="hidden" name="gender" value=<%=req.getGender()%> >
        <input type="hidden" name="dob" value=<%=req.getDateOfBirth()%> >
        <input type="hidden" name="mobileNo" value=<%=req.getMobileNo()%> >
        <input type="hidden" name="emailId" value=<%=req.getEmailId()%> >
        <input type="hidden" name="state" value=<%=req.getState()%> >
        <input type="hidden" name="district" value=<%=req.getDistrict()%> >
        <input type="hidden" name="branchAddressID" value=<%=req.getBranchID()%> >  
        <input type="hidden" name="amount" value=<%=req.getAmountdeposited()%>/>
        <button type="submit" name="action" >Accept</button>
    </td>
   </form>
	<td>
	<button onsubmit="#">Reject</button>
	</td>
	</tr>
	</table>
	<%
	}
} else {
%>
	<h3 style="color:red;"> No new account requests found</h3>
	<%
	}
%>
</main>
</div>
</body>
</html>