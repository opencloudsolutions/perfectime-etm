<?php
	require_once ('../settings.php');
	include_once('../adodb_connect.php');
	$deleteEmpStatement = "delete from users where keyid=".$_COOKIE['EmployeeId'];
	$deleteRecStatement = "delete from timetable where keyid=".$_COOKIE['EmployeeId'];
	if (!mysql_query($deleteRecStatement)) {
  		die('Error: ' . mysql_error());
  	} else {
		if (!mysql_query($deleteEmpStatement)) {
		die('Error: ' . mysql_error());
		} else {
		print '<html><body><div align="center" style="color:#FFF;"><strong><h1>Success!!</h1></strong><br><br><table border=1 bordercolor="#DDDDDD" style="border-collapse: collapse; color:#FFF;">';
		print "Clock records deleted for employee!<br>";
		print "User record deleted for employee!<br>";
		print "<tr>MySQL said: 1 Row affected in database!</tr><tr></tr>";
		print "<tr><td>Removed Key ID:</td><td>".$_POST[keyID]."</td></tr>";
		print "<tr><td>Employee Name:</td><td>".$_POST[empName]."</td></tr>";
		print "<tr><td>Employee Street Address:</td><td>".$_POST[streetAddress]."</td></tr>";
		print "<tr><td>City:</td><td>".$_POST[cityAddress]."</td></tr>";
		print "<tr><td>Pay Rate:</td><td>$".$_POST[payRate]."</td></tr>";
	?>
<?php
		} }
		print '</table>';
		//print '<br><input type="submit" value="Close & Reload Window" onClick="javascript:window.close();window.opener.location.reload();" />';
		print "</body></html>";
?>