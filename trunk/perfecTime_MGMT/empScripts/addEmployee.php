<?php
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
function OnButtonAdd()
{
    document.AddEmployeeForm.action = "../empFunctions/empadd.php"
    document.AddEmployeeForm.target = "_self";    // Open in same window
    document.AddEmployeeForm.submit();             // Submit to self
    return true;
}
-->
</script>
<body><div align="center" style="color:#FFF;">
<form method="post" enctype="application/x-www-form-urlencoded" name="AddEmployeeForm">
  <p><strong>Key ID:</strong><br />
    <input type="text" name="keyID" />
  </p>
  <p><strong>Employee Name:</strong><br />
    <input type="text" name="empName" />
</p>
  <p><strong>Street Address:</strong><br />
    <input type="text" name="streetAddress" />
  </p>
  <p><strong>City Name:</strong><br />
    <input type="text" name="cityAddress" />
  </p>
  <p><strong>Pay Rate:</strong><br />
    <input type="text" name="payRate" />
  </p>
  <p>
    <input type="submit" value="Add New Employee" onClick="return OnButtonAdd();" /><br /><br />
  </p>
  <p>&nbsp; </p>
</form></div>
</body>
</html>