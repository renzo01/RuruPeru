<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<link rel="stylesheet" href="css/displayTag/displaytag.css">
<link rel="stylesheet" href="css/displayTag/screen.css">
    
    <div align="center">
    	
    	<display:table name="${ listaUsers }" decorator="decorator.WrapperUsers" export="true">
    	
    	<display:column property="code" title="Código"></display:column>
    	<display:column property="image" title="Image"></display:column>
    	<display:column property="username" title="Usuario"></display:column>
    	<display:column property="password" title="Password"></display:column>
    	
    	</display:table>
    	
    </div>