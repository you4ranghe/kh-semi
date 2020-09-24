<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>

<!-- Include the plugin's CSS and JS: -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-multiselect.css" type="text/css"/>
 --%>
    <select id="example-getting-started" multiple="multiple">
        <option value="cheese">Cheese</option>
        <option value="tomatoes">Tomatoes</option>
        <option value="mozarella">Mozzarella</option>
        <option value="mushrooms">Mushrooms</option>
        <option value="pepperoni">Pepperoni</option>
        <option value="onions">Onions</option>
    </select>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#example-getting-started').multiselect();
        });
    </script>