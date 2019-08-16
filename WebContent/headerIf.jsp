<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserDTO" %>
<%-- Include que invoca a la cabecera de la WEB --%>
<% 
	UserDTO log_user = (UserDTO) request.getSession().getAttribute("user");
	if(log_user == null) {%>
<jsp:include page="header.jsp"></jsp:include>
<%} else { %>
<jsp:include page="headerLog.jsp"></jsp:include>
<%}%>