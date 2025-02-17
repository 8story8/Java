<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.StringWriter"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>

<%@ page import="org.codehaus.jackson.map.ObjectMapper"%>

<%
    // http://127.0.0.1:8888/jquery-study6-jsonp/server.jsp
	Map<String, String> dummyData = new HashMap<String, String>();
	dummyData.put("Code1", "Bourbon");
	dummyData.put("Code2", "Jin");
	dummyData.put("Code3", "Vermouth");
	
	StringWriter sw = new StringWriter();
	
	// Jackson JSON Mapper를 사용해서 Map을 JSON 문자열로 변환
	ObjectMapper mapper = new ObjectMapper();
	mapper.writeValue(sw, dummyData);
	
	request.setAttribute("sw", sw);
%>

<%-- AJAX에서 넘겨준 Callback 함수 Parameter 가져오기 --%>
${param.callback}(${sw});



