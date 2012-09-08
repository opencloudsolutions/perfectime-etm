<?php
	require_once ('../settings.php');
	include_once('../adodb_connect.php');
	$ud_timeid = $_POST['ud_timeid'];
	$ud_timeStart = $_POST['ud_timeStart'];
	$ud_timeStop = $_POST['ud_timeStop'];
	$ud_timeTips = $_POST['ud_timeTips'];
	$updateTimeStatement = "update timetable set start='$ud_timeStart', stop='$ud_timeStop', tipMade='$ud_timeTips' where timeid=".$ud_timeid;
	if (!mysql_query($updateTimeStatement)) {
  		die('Error: ' . mysql_error());
  	} else {
		print '<html><body><div align="center" style="color:#FFF;"><strong><h1>Success!!</h1></strong><table border=1 bordercolor="#DDDDDD" style="border-collapse: collapse; color:#FFF;">';
		print "<tr>MySQL said. 1 Row affected in database!</tr>";
		print "<tr><td>Clock In:</td><td>Clock Out:</td><td>Tips:</td></tr>";
		print "<tr><td>".$ud_timeStart."</td><td>".$ud_timeStop."</td><td>".$ud_timeTips."</td></tr>";
	?>
<?php
		}
		print '</table>';
		//print '<input type="submit" value="Close & Reload Window" onClick="javascript:window.close();window.opener.location.reload();" />';
		print "</body></html>";
?>