<?php
// Starting the session
session_start();
$errorMessage = '';
if (isset($_POST['swipedHash'])) {
   include 'settings.php';
   include 'adodb_connect.php';
	$hashSwipe = $_POST['swipedHash'];
// checking if the user exists in database
   $sql = "select * from tbl_auth_user where magPass = MD5('$hashSwipe')";
   $result = mysql_query($sql)
             or die('Query failed. ' . mysql_error());
   if (mysql_num_rows($result) == 1) {
      // user id matching,
      // setting the session
      $_SESSION['db_is_logged_in'] = true;
      // after login we move to the main page
      header('Location: timeclock.php');
      exit;
   } else {
      $errorMessage = 'Wrong Mag Pass. Try again...';
   }
   //close database connection
   include 'adodb_disconnect.php';
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>perfecTime Manager</title>
</head>
<body bgcolor="#DDDDDD">
<div style="width:100%; padding-top:200px;">
<center>
    <p style="font-size:64px;">perfecTime Management Panel <h5>(0.1alpha)</h5></p>
<p style="font-style:italic">Enter Pass Code</p>
<?php
	if ($errorMessage != '') {
		?>
	<align="top"><font color="#990000" size="2"><?php echo $errorMessage; ?></font>
<?php
	}
		?>
<form action="<?php echo $PHP_SELF;?>" method="post" enctype="application/x-www-form-urlencoded" name="auth">
<input name="swipedHash" type="password" />
</form>
</center>
</div>
</body>
</html>
