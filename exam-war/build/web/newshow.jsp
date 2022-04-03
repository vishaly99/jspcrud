<%-- 
    Document   : newshow
    Created on : Apr 3, 2022, 10:37:04 AM
    Author     : Dell
--%>

<%@page import="entity.MobileMaster"%>
<%@page import="sessionBean.examSessionBean"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context" %>
<%@page import="entity.CategoryMaster"%>
<%@page import ="sessionBean.examSessionBeanLocal"%>

<% MobileMaster mobile =new MobileMaster(); %>
<% CategoryMaster category = new CategoryMaster();%>
<%! examSessionBeanLocal examSessionBean; %>

<%
    Context c = new InitialContext();
   int mobileid = 0;
    examSessionBean = (examSessionBeanLocal)c.lookup("java:global/exam/exam-ejb/examSessionBean!sessionBean.examSessionBeanLocal");
    try{
        if(request.getParameter("b2")!=null)
        {
            
            mobileid=Integer.parseInt(request.getParameter("mobileid"));
            out.print(examSessionBean.deletemobile(mobileid));
             System.out.println("ID:="+mobileid);
        } 
        else
        {
           System.out.println("Else:="+mobileid);
        }
    }
    catch(Exception e)
    {
        e.getMessage();
    }
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            
            <h1 align="center">Employee List</h1>
       
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>company</th>
                    <th>model</th>
                    <th>year</th>
                    <th>size</th>
                    <th>camera</th>
                    <th>memory</th>
                    <th>category</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
//                    Context c = new InitialContext();
                    examSessionBean = (examSessionBeanLocal)c.lookup("java:global/exam/exam-ejb/examSessionBean!sessionBean.examSessionBeanLocal");
                    List <MobileMaster> mobileList = examSessionBean.showmobile();
                    for(int i = 0;i<mobileList.size();i++)
                    {
                        mobile = mobileList.get(i);
                        
                    
                %>
                <tr>
                    <td><%=mobile.getMobileId() %></td>
                    <td><%=mobile.getCompany() %></td>
                    <td><%=mobile.getMemory() %></td>
                    <td><%= mobile.getModel() %></td>
                    <td><%=mobile.getYear()%></td>
                    <td><%=mobile.getSize() %></td>
                    <td><%=mobile.getCamera() %></td>
                    <td><%=mobile.getCategoryId().getCategoryName() %></td>
                    <td>
                        <form action="newshow.jsp?mobileid=<%=mobile.getMobileId()%>" method="post">
                            <input type="submit" name="b2" value="Select"/>
                        </form>           
                    </td>
                    
                    
                    
                </tr>
                
                <% } %>
            </tbody>
        </table>
    </form>
    </body>
</html>
