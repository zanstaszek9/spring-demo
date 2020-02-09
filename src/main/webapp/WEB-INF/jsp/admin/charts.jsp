<%--
  Created by IntelliJ IDEA.
  User: Stasio
  Date: 05.02.2020
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../incl/head.jsp"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.charts.load('current', {'packages':['corechart', 'table', 'controls']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

        var users = ${usersList};
        var data2 = new google.visualization.DataTable();


        data2.addColumn('number','user_id');
        data2.addColumn('string', 'email');
        data2.addColumn('string', 'password');
        data2.addColumn('string', 'name');
        data2.addColumn('string', 'lastName');
        data2.addColumn('number', 'active');
        data2.addColumn('string', 'role');


        for(let i = 0; i <users.length; i++){
            data2.addRow([
                users[i]['id'],
                users[i]['email'],
                users[i]['password'],
                users[i]['name'],
                users[i]['lastName'],
                users[i]['active'],
                users[i]['roles'][0]['role']
            ]);
        }

        var result = google.visualization.data.group(
            data2, [5], [
            {column: 5,
            aggregation: google.visualization.data.count,
            type: 'number',
            label: 'Count'
        }]
        );

        var options3 = {
            height: 200,
            width: 300
        };

        var chart3 = new google.visualization.Table(document.getElementById('piechart_div'));
        chart3.draw(result, options3);
    }
</script>


<title><s:message code="menu.charts"/></title> <!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->


<button class="foo-button mdc-button">Button</button>
<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
    Button
</button>
<button class="mdc-fab mdc-fab--extended">
    <div class="mdc-fab__ripple"></div>
    <span class="material-icons mdc-fab__icon">add</span>
    <span class="mdc-fab__label">Create</span>
</button>

<button class="mdc-fab" aria-label="Favorite">
    <div class="mdc-fab__ripple"></div>
    <span class="mdc-fab__icon material-icons">favorite</span>
</button>
<table class="columns">
    <tr>
        <td><div id="chart_div" style="width:400px; height:300px"></div></td>
        <td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
        <td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
    </tr>
</table>


<%@include file="../../incl/footer.jsp" %>

