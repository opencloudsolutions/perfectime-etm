<?php
	require_once ('../settings.php');
	require_once ('../adodb_connect.php');
	$sqlUsers = "select * from users order by employeeName asc";
	$rs = mysql_query($sqlUsers);
	//$userRows = mysql_num_rows($rs);
	while($en = mysql_fetch_assoc($rs)){
		$output[] = $en;
		//$empKeyID[] = $en['keyid'];
		//$empStreet[] = $en['street'];
		//$empCity[] = $en['city'];
		//$empPay[] = $en['payrate'];
		print (json_encode($output));
	}
	require_once ('../adodb_disconnect.php');
?>
