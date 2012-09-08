<?
require_once ('settings.php');
include 'siteHeader.php';
include_once( 'adodb_connect.php' );
##############
# Functions
##############
function formatDateForTimeclock($timestamp) {
	if ($timestamp == "0000-00-00 00:00:00") return '<span id="open">Waiting for Employee to Clock Out . . . . .</span>';
	else return date("M j 'y - g:i a", strtotime($timestamp));
}
function getDurationClockedIn($start, $stop) {
	if ($stop < $start) return "";
	else return number_format( ( ( strtotime($stop) - strtotime($start) ) / 3600 ), 2);
}
function printTableRow($rowArray, $cssid = "") {
	print '<tr id="'.$cssid.'">';
	for ($rArrayCounter = 0; $rArrayCounter < sizeof($rowArray); $rArrayCounter++) {
		print '<td>'.$rowArray[$rArrayCounter].'</td>';
	}	
	print '</tr>';
}
##############
?>
<style>
div#timelist {
	width: 100%;
	height: 420px;;
	overflow: auto;
}
table#timelisttable {
	width:100%;
	border: 1px;
	border-color: #DDDDDD;
	border-collapse: collapse;
}
table#timelisttable tr#labels {
	background-color: #DDDDDD;
}
table#timelisttable tr td {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: small;
	padding: 10px;
}
span#open {
	color: #CC0000;
}
table#etm-menu {
	width:20%;
	float:left;
	margin-top: 10px;
	color:#444;
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: medium;
}
table#etm-menu a:active {
	text-decoration: none;
}
table#etm-menu a:visited {
	color:#444;
	text-decoration: none;
}
	font-style: italic;
table#etm-menu a:hover {
	text-decoration: none;
}
table#reportlist {
	margin-top: 10px;
	width: 79%;
	float:left;
}
table#reportlist tr#labels {
	background-color: #DDDDDD;
}
table#reportlist tr td {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: small;
	padding: 10px;
}
table#reportlist-bottom {
	width: 80%;
	float:right;
}
table#reportlist-bottom tr#labels {
	background-color: #DDDDDD;
}
table#reportlist-bottom tr td {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: small;
	padding: 4px;
}
</style>
<script language="Javascript">
<!--
function OnButtonView()
{
    document.TimeForm.action = "#"
    document.TimeForm.target = "_self";    // Open in same window
    document.TimeForm.submit();             // Submit to self
    return false;
}
function OnButtonGenerate()
{
    document.TimeForm.action = "GenerateHourSheet.php"
    document.TimeForm.target = "_blank";    // Open in a new window
    document.TimeForm.submit();             // Submit the page
    return true;
}
-->
</script>
<table id="etm-menu" border=1 bordercolor="#DDDDDD" style="border-collapse: collapse;">
	<tr><td style="padding-bottom:10px; background-color:#DDD; padding-top:16px;" align="center"><strong>Current Employees</strong>
    </td></tr>
    <?
		for ($i = 0; $i < $userRows; $i++) {
			print '<tr><td style="background-image:url(images/button-rev01.png); background-repeat:no-repeat; background-position:center; height:51px;" align="center">';
			print '<a href="setCookie.php?EmployeeId='.$empKeyID[$i].'">'.$empName[$i].'</a>';
			print '</td></tr>';
		}
	?>
</table>
  <table id="reportlist" border=1 bordercolor="#DDDDDD" style="border-collapse: collapse;">
    <tr>
      <td><?
	$fromTimestamp = strtotime($_POST['fromMonth']." ".$_POST['fromDay']." ".$_POST['fromYear']." 05:30:00");
	$toTimestamp = strtotime($_POST['toMonth']." ".$_POST['toDay']." ".$_POST['toYear']." 23:59:59");
	$sql = "
		select * from timetable 
		where keyid = " . $_COOKIE['EmployeeId'] . " 
		and start >= '" . date( "Y-m-d H:i:s", $fromTimestamp ) . "' 
		and start <= '" . date( "Y-m-d H:i:s", $toTimestamp ). "' 
		order by timeid desc
		";
	$rpResult = mysql_query($sql);
	$rpResultRows = mysql_num_rows($rpResult);
	//$rs = $conn->Execute( $sql );
	//print '<center>';
	print '<div id="timelist"><table id="timelisttable">';
	//$rowArray = array (
	//	0 => "Clock In Time",
	//	1 => "Clock Out Time",
	//	2 => "Reported Tip ($) Dollar Amount ",
	//	3 => "Duration",
	//	4 => "Edit Time",
	//);
	print '<tr id="labels"><td>Clock In Time</td><td>Clock Out Time</td><td>Reported Tip ($) Dollar Amount </td><td>Duration</td><td>Edit Time</td></tr>';
	//printTableRow($rowArray, "labels");
	//while ( !$rs->EOF )
	//{
		// Getting timeid for slect statement.
	//	$rs->fields['timeid'];
	//	$rowArray = array(
	//		0 => formatDateForTimeclock( $rs->fields['start'] ),
	//		1 => formatDateForTimeclock( $rs->fields['stop'] ),
	//		2 => $rs->fields['tipMade'],
	//		3 => getDurationClockedIn( $rs->fields['start'], $rs->fields['stop'] ),
	//		4 => '<input type="button" value="Edit" onclick="#">',
	//		);
	//	printTableRow( $rowArray );
		#$totaltip = $rs->fields['tipMade'] + $totaltip;
	//	$rs->MoveNext();
	//}
		//$rpr = mysql_fetch_array($rpResult);
		for ($runner = 0; $runner < $rpResultRows; $runner++) {
			$rpr = mysql_fetch_array($rpResult);
			print '<tr>';
			print '<td>'.formatDateForTimeclock( $rpr['start'] ).'</td>';
			print '<td>'.formatDateForTimeclock( $rpr['stop'] ).'</td>';
			print '<td>'.$rpr['tipMade'].'</td>';
			print '<td>'.getDurationClockedIn( $rpr['start'], $rpr['stop'] ).'</td><td>';
			print "<input name="."edit"." value="."<--&nbsp;&nbsp;Edit"." href="."empScripts/editTime.php?timeIdentificationNumber=".$rpr['timeid'].""." class="."tu_iframe_660x200"." type="."image"." src="."images/edit-it.png".">";
		print '</td></tr>';
	}
	print '</table>';
	print '</center>';
?>
      </td>
    </tr>
    </table>
    <table id="reportlist-bottom" border=1 bordercolor="#DDDDDD" style="border-collapse: collapse;">
    <tr id="labels">
      <td colspan="6">Generate Time Card Report - Portable Document Format (PDF) - <em>From: Date + 05:30:00 - To: Date + 23:59:59</em></td>
    </tr>
    <form name="TimeForm" method="post">
      <tr>
        <td> <p>From (e.g. August 14 2010)&nbsp;&nbsp;
            <select name="fromMonth">
              <? $cur_month = date("F", time()); ?>
              <option<? if ($cur_month == "January") { print ' selected'; } ?>>January</option>
              <option<? if ($cur_month == "February") { print ' selected'; } ?>>February</option>
              <option<? if ($cur_month == "March") { print ' selected'; } ?>>March</option>
              <option<? if ($cur_month == "April") { print ' selected'; } ?>>April</option>
              <option<? if ($cur_month == "May") { print ' selected'; } ?>>May</option>
              <option<? if ($cur_month == "June") { print ' selected'; } ?>>June</option>
              <option<? if ($cur_month == "July") { print ' selected'; } ?>>July</option>
              <option<? if ($cur_month == "August") { print ' selected'; } ?>>August</option>
              <option<? if ($cur_month == "September") { print ' selected'; } ?>>September</option>
              <option<? if ($cur_month == "October") { print ' selected'; } ?>>October</option>
              <option<? if ($cur_month == "November") { print ' selected'; } ?>>November</option>
              <option<? if ($cur_month == "December") { print ' selected'; } ?>>December</option>
            </select>
            <select name="fromDay">
              <?
				for ($i = 1; $i <= 31; $i++) {
					print '<option';
					if ($i == date("j",time())-14) { print ' selected'; }
					print '>'.$i.'</option>';
				}
				?>
            </select>
            <select name="fromYear">
              <?
				for ($i = 2010; $i <= date("Y",time()); $i++) {
					print '<option';
					if ($i == date("Y",time())) { print ' selected'; }
					print '>'.$i.'</option>';
				}
				?>
            </select>
          &nbsp;&nbsp;
          </p>
          <p>To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(e.g. July 4 2011)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <select name="toMonth">
              <? $cur_month = date("F", time()); ?>
              <option<? if ($cur_month == "January") { print ' selected'; } ?>>January</option>
              <option<? if ($cur_month == "February") { print ' selected'; } ?>>February</option>
              <option<? if ($cur_month == "March") { print ' selected'; } ?>>March</option>
              <option<? if ($cur_month == "April") { print ' selected'; } ?>>April</option>
              <option<? if ($cur_month == "May") { print ' selected'; } ?>>May</option>
              <option<? if ($cur_month == "June") { print ' selected'; } ?>>June</option>
              <option<? if ($cur_month == "July") { print ' selected'; } ?>>July</option>
              <option<? if ($cur_month == "August") { print ' selected'; } ?>>August</option>
              <option<? if ($cur_month == "September") { print ' selected'; } ?>>September</option>
              <option<? if ($cur_month == "October") { print ' selected'; } ?>>October</option>
              <option<? if ($cur_month == "November") { print ' selected'; } ?>>November</option>
              <option<? if ($cur_month == "December") { print ' selected'; } ?>>December</option>
            </select>
            <select name="toDay">
              <?
				for ($i = 1; $i <= 31; $i++) {
					print '<option';
					if ($i == date("j",time())) { print ' selected'; }
					print '>'.$i.'</option>';
				}
				?>
            </select>
            <select name="toYear">
              <?
				for ($i = 2010; $i <= date("Y",time()); $i++) {
					print '<option';
					if ($i == date("Y",time())) { print ' selected'; }
					print '>'.$i.'</option>';
				}
				?>
            </select>
        </p></td>
      </tr>
			
      <tr>
        <td>
        <?php
        for ($i = 0; $i < $userRows; $i++) {
			if ($_COOKIE['EmployeeId'] == $empKeyID[$i]) {
		?>
        <span><input type="button" value="View Work Sheet for <?php print $empName[$i]; ?>" onclick="return OnButtonView();"></span>&nbsp;&nbsp;<span><input type="button" value="Generate Pay Period Report" onclick="return OnButtonGenerate();"></span>&nbsp;&nbsp;<span><input type="button" value="Print Pay Check" onclick="return OnButtonGenerate();"></span>
		<?php
		} }
		?>	
          </td>
      </tr>
    </form>
  </table>
<?
include_once( 'adodb_disconnect.php' );
?>
<br />
<br />
</html>