
<%
	request.getSession().invalidate();
%>
<%
	response.sendRedirect("paginas/login.html");
%>

