<%-- 
    Document   : insert
    Created on : Apr 2, 2022, 10:29:27 AM
    Author     : Dell
--%>
<%@page import="entity.CategoryMaster"%>
<%@page import="entity.MobileMaster"%>
<%@page import="sessionBean.examSessionBean"%>
<%@page import="sessionBean.examSessionBeanLocal"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext" %>
<%@page import="javax.naming.Context"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! examSessionBeanLocal examSessionBean; %>

<%
    String company="",model="",year="",size="",camera="",memory="";
    int mobile_id =0,categoryID=0;
    
    Context c = new InitialContext();
    MobileMaster mobile =new MobileMaster();
    CategoryMaster category = new CategoryMaster();
   
    examSessionBean = (examSessionBeanLocal)c.lookup("java:global/exam/exam-ejb/examSessionBean!sessionBean.examSessionBeanLocal");
    try
    {
        if(request.getParameter("b1")!=null)
        {
            company = request.getParameter("t1");
            model = request.getParameter("t2");
            year = request.getParameter("t3");
            size = request.getParameter("t4");
            camera = request.getParameter("t5"); 
            memory = request.getParameter("t6");
            categoryID = Integer.parseInt(request.getParameter("t7"));
            category = examSessionBean.searchcategory(categoryID);
            
            mobile.setMobileId(0);
            mobile.setCompany(company);
            mobile.setMemory(memory);
            mobile.setModel(model);
            mobile.setSize(size);
            mobile.setCamera(camera);
            mobile.setYear(year);
            mobile.setCategoryId(category);
            out.print(examSessionBean.insertmobile(mobile));
            
        }
    }catch(Exception e)
    {
        e.getMessage();
    }
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="insert.jsp" method="post">
            <table>
                <tr><td>company name:</td><td><input type="text" name="t1"/></td></tr>         
                <tr><td>model:</td><td><input type="text" name="t2"/></td></tr>         
                <tr><td>year:</td><td><input type="text" name="t3"/></td></tr>         
                <tr><td>size:</td><td><input type="text" name="t4"/></td></tr>         
                <tr><td>camera:</td><td><input type="text" name="t5"/></td></tr>         
                <tr><td>memory:</td><td><input type="text" name="t6"/></td></tr>         
                <tr>
                    <td>category:</td><td>
                        
                        <select name="t7">
                            <%
                             List <CategoryMaster> categoryList = examSessionBean.showcategory();
                    for(int i = 0;i<categoryList.size();i++)
                    {
                        category = categoryList.get(i);
                    
                            %>
                            <option value="<%= category.getCategoryId() %>"><%= category.getCategoryName() %></option>
                                    
                            <% } %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td></td><td>
                        
                        <input type="submit" name="b1" value="submit"/>
                   
                    </td>
                </tr>
            </table>
        </form>
       
    </body>
</html>
