<?php
	require_once ('../settings.php');
	include_once('../adodb_connect.php');
	$ud_keyID = $_POST['ud_keyID'];
	$ud_empName = $_POST['ud_empName'];
	$ud_streetAddress = $_POST['ud_streetAddress'];
	$ud_cityAddress = $_POST['ud_cityAddress'];
	$ud_payRate = $_POST['ud_payRate'];
	$updateStatement = "update users set employeeName='$ud_empName', street='$ud_streetAddress', city='$ud_cityAddress', payrate='$ud_payRate' where keyid=".$_COOKIE['EmployeeId'];;
	if (!mysql_query($updateStatement)) {
  		die('Error: ' . mysql_error());
  	} else {
		print '<html><body><div align="center" style="color:#FFF;"><strong><h1>Success!!</h1></strong><br><br><table border=1 bordercolor="#DDDDDD" style="border-collapse: collapse; color:#FFF;">';
		print "<tr>MySQL said:<br>1 Row affected in database!</tr><tr></tr>";
		print "<tr><td>Key ID:</td><td>".$ud_keyID."</td></tr>";
		print "<tr><td>Employee Name:</td><td>".$ud_empName."</td></tr>";
		print "<tr><td>Employee Street Address:</td><td>".$ud_streetAddress."</td></tr>";
		print "<tr><td>City:</td><td>".$ud_cityAddress."</td></tr>";
		print "<tr><td>Pay Rate:</td><td>$".$ud_payRate."</td></tr>";
	?>
<?php
		}
		print '</table>';
		//print '<br><input type="submit" value="Close & Reload Window" onClick="javascript:window.close();window.opener.location.reload();" />';
		print "</body></html>";
?>