<?php
	require_once ('settings.php');
	include_once('adodb_connect.php');
	$sqlUsers = "select * from users order by employeeName asc";
	$rs = mysql_query($sqlUsers);
	$userRows = mysql_num_rows($rs);
	while($en = mysql_fetch_array($rs)){
		$empName[] = $en['employeeName'];
		$empKeyID[] = $en['keyid'];
		$empStreet[] = $en['street'];
		$empCity[] = $en['city'];
		$empPay[] = $en['payrate'];
	}
?>