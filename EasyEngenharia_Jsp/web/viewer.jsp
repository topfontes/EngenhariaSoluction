<%
            String url = request.getParameter("url");
            url = url.replace("|", "?");
            url = url.replace("$", "&");
%>
<embed src="<%=url%>" width=100% height=95%>
</embed>