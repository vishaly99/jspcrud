<%-- 
    Document   : delete
    Created on : Apr 2, 2022, 5:12:26 PM
    Author     : Dell
--%>

<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="sessionBean.examSessionBeanLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! examSessionBeanLocal examSessionBean; %>
<%
    Context c = new InitialContext();
   
    examSessionBean = (examSessionBeanLocal)c.lookup("java:global/exam/exam-ejb/examSessionBean!sessionBean.examSessionBeanLocal");
    try{
        if(request.getParameter("b2")!=null)
        {
            out.print(examSessionBean.deletemobile(Integer.parseInt(request.getParameter("mobileId"))));
             response.sendRedirect("show.jsp");
        }
    }
    catch(Exception e)
    {
        e.getMessage();
    }
%>
<form action="delete.jsp" method="post">
    <button name="b2">Delete</button>
</form>
    </body>
</html>
