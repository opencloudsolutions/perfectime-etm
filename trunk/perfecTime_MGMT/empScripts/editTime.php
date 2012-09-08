<?php
	include_once ('../settings.php');
	include_once( '../adodb_connect.php' );
	####################
	# Session Validity
	####################
	session_start();

	// is the one accessing this page logged in or not?
	if (!isset($_SESSION['db_is_logged_in'])
   || $_SESSION['db_is_logged_in'] !== true) {

   // not logged in, move to login page
   header('Location: ../index.php');
   exit;
	}
	//print $_GET['timeIdentificationNumber'];
	$timeRowStatement = "select * from timetable where timeid=".$_GET['timeIdentificationNumber'];
	$trsQuery = mysql_query($timeRowStatement);
	//$tRowsCounted = mysql_num_rows($trs);
	while ($trDataArray = mysql_fetch_array($trsQuery)){
?>
<html>
<script language="Javascript">
<!--
function OnButtonTimeEdit()
{
    document.EditTimeForm.action = "../empFunctions/timeedit.php"
    document.EditTimeForm.target = "_self";    // Open in same window
    document.EditTimeForm.submit();             // Submit to self
    return true;
}
-->
</script>
<body><div align="center" style="padding-top:40px;">
<form method="post" enctype="application/x-www-form-urlencoded" name="EditTimeForm">
  <table width="400" border=1 bordercolor="#DDDDDD" style="border-collapse: collapse; color:#FFF;">
    <tr>
      <td align="center"><strong>Clock In</strong></td>
      <td align="center"><strong>Clock Out</strong></td>
      <td align="center"><strong>Tips</strong></td>
    </tr>
    <tr>
    	  <input type="hidden" name="ud_timeid" value="<?php print $trDataArray['timeid']; ?>" />
      <td><input type="text" name="ud_timeStart" value="<?php print $trDataArray['start']; ?>" /></td>
      <td><input type="text" name="ud_timeStop" value="<?php print $trDataArray['stop']; ?>" /></td>
      <td><input type="text" name="ud_timeTips" value="<?php print $trDataArray['tipMade']; ?>" /></td>
    </tr>
  </table>
  <p><input type="submit" value="Update Time & Tip Record" onClick="return OnButtonTimeEdit();" /></p>
</form>
</div>
</body>
</html> <?php } ?>