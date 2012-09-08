<?php
	require_once ('../employeeInfo.php');
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
?>
<html>
<script language="Javascript">
<!--
function OnButtonEdit()
{
    document.EditEmployeeForm.action = "../empFunctions/empedit.php"
    document.EditEmployeeForm.target = "_self";    // Open in same window
    document.EditEmployeeForm.submit();             // Submit to self
    return true;
}
function OnButtonDelete()
{
    document.EditEmployeeForm.action = "../empFunctions/empdelete.php"
    document.EditEmployeeForm.target = "_self";    // Open in same window
    document.EditEmployeeForm.submit();             // Submit to self
    return true;
}
-->
</script>
<body><div align="center" style="color:#FFF;">
<?
		for ($i = 0; $i < $userRows; $i++) {
			if ($_COOKIE['EmployeeId'] == $empKeyID[$i]) {
				$frmKey = $empKeyID[$i];
				$frmName = $empName[$i];
				$frmStreet = $empStreet[$i];
				$frmCity = $empCity[$i];
				$frmPay = $empPay[$i];
			}
		}
	?>
<form method="post" enctype="application/x-www-form-urlencoded" name="EditEmployeeForm">
  <p><strong>Key ID:</strong><br />
    <input name="ud_keyID" type="text" value="<?php echo $frmKey ?>" readonly="readonly" />
  </p>
  <p><strong>Employee Name:</strong><br />
    <input type="text" name="ud_empName" value="<?php echo $frmName ?>" />
</p>
  <p><strong>Street Address:</strong><br />
    <input type="text" name="ud_streetAddress" value="<?php echo $frmStreet ?>" />
  </p>
  <p><strong>City Name:</strong><br />
    <input type="text" name="ud_cityAddress" value="<?php echo $frmCity ?>" />
  </p>
  <p><strong>Pay Rate:</strong><br />
    <input type="text" name="ud_payRate" value="<?php echo $frmPay ?>" />
  </p>
  <p>
    <input type="submit" value="Update Employee Info" onClick="return OnButtonEdit();" /><br /><br />
    <input type="submit" value="Delete Employee" onClick="return OnButtonDelete();" /><br /><br />
  </p>
  <p>&nbsp; </p>
</form></div>
</body>
</html>