<%--Author: Esin A., created 11.10.2021
    landing page: table data--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<table align="center" border='1'>
    <tr>
        <td><b><%=res.getString("developer")%></b></td>
        <td><b><%=res.getString("game.name")%></b></td>
        <td><b><%=res.getString("completed")%></b></td>
    </tr>
    <tr>
        <td>CD PROJECT RED</td>
        <td>The witcher 3</td>
        <td><%=res.getString("ans.yes")%></td>
    </tr>
    <tr>
        <td>Valve</td>
        <td>Dota 2</td>
        <td><%=res.getString("ans.yes")%></td>
    </tr>
    <tr>
        <td>Gearbox software</td>
        <td>Borderlands 2</td>
        <td><%=res.getString("ans.no")%></td>
    </tr>
    <tr>
        <td>HotFoodGames</td>
        <td>Drunken samurai</td>
        <td><%=res.getString("ans.no")%></td>
    </tr>
</table>
