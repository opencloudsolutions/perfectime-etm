<?php
	require_once ('employeeInfo.php');
####################
# Session Validity
####################
session_start();

// is the one accessing this page logged in or not?
if (!isset($_SESSION['db_is_logged_in'])
   || $_SESSION['db_is_logged_in'] !== true) {

   // not logged in, move to login page
   header('Location: index.php');
   exit;
}
?>
<html>
<style>
	body {
	margin: 0px;
	}
	div#siteHeader {
	background-color: #EEE;
	padding: 15px;
	margin-bottom: 20px;
	}
	div#siteHeader span#pageHeader {
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
	color: #444;
	font-size: 46px;
	}
	div#siteHeader span#employeeName {
	font-style: italic;
	font-size: 12px;
	color: #444;
	vertical-align:middle;
	}
	div#siteHeader span#employeePanel {
	float:right;
	vertical-align:middle;
	}
</style>
<script type="text/javascript" src="js/top_up-min.js"></script>
<script type="text/javascript">
<!--
function nukeSession() {
parent.location='session_destroy.php'
}
//-->
</script>
<body>
<div id="siteHeader">
	<span id="pageHeader">
    <strong>perfecTime</strong> - Management Panel <h7>(0.1alpha)</h7>
    </span><hr />
  <?
		for ($i = 0; $i < $userRows; $i++) {
			if ($_COOKIE['EmployeeId'] == $empKeyID[$i]) {
				print '<span id="employeeName">';
				print 'Clock sheet for <strong>';
				print $empName[$i];
				print '</strong>. Current registered address is <strong><br>';
				print $empStreet[$i].', '.$empCity[$i];
				print '</strong>, we are paying <strong>';
				print $empPay[$i];
				print '/hour.</span><span id="employeePanel">';
				print '<input type="button" href="empScripts/editEmployee.php" value="Edit '.$empName[$i].'" class="tu_iframe_340x460"> ';
				print '<input type="button" href="empScripts/addEmployee.php" value="Create New Employee" class="tu_iframe_340x416"> ';
				print '<input type="button" onClick="nukeSession()" value="Logout"></span>';
			}
		}
	?>
</div>
