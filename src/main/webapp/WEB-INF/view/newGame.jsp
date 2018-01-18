<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head></head>>
<h2>Tic tac toe</h2>
<c:url value="/tictactoe" var="tictactoeUrl"/>
<form action="${tictactoeUrl}" method="post">
    <p>
        <label for="user_symbol">User Symbol:</label>
        <input type="text" id="user_symbol" name="user_symbol"/>
        <button type="submit" class="btn">New game</button>
    </p>
</form>
</body>
</html>

