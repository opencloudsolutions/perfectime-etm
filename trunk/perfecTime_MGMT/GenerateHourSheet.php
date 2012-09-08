<?
	require_once ('settings.php');
	require_once ('employeeInfo.php');
	include_once( 'adodb_connect.php' );
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
	$minimumWageFL = 7.31;
	for ($i = 0; $i < $userRows; $i++) {
		if ($_COOKIE['EmployeeId'] == $empKeyID[$i]) {
			$EmployeeName = $empName[$i];
			$EmployeeAddress = $empStreet[$i].', '.$empCity[$i];
			$EmployeeRate = $empPay[$i];
			if ($EmployeeRate < 7.00) {
				$minimumWageAdjusted = $minimumWageFL - $EmployeeRate;
			}
		}
	}
	## Getting Time Values
	$fromTimestamp = strtotime($_POST['fromMonth']." ".$_POST['fromDay']." ".$_POST['fromYear']." 05:30:00");
	$toTimestamp = strtotime($_POST['toMonth']." ".$_POST['toDay']." ".$_POST['toYear']." 23:59:59");
	## INCLUDES
	require('fpdf153/fpdf.php');
	## EXTEND CLASS
	class PDF extends FPDF {
		//Page header
		function Header() {
			global $EmployeeName;
			global $EmployeeAddress;
			global $EmployeeRate;
			global $TotalHours;
			global $TotalTipMade;
			global $minimumWageAdjusted;
		    $this->SetFont('Times','B',15);
		    $this->Cell(10);
		    $this->Cell(170,10, COMPANY_NAME,0,1,'C');
			$this->Line(200,18,10,18);
			$this->SetFont('Times','',8);
			$this->Cell(10);
			$this->Cell(170,1, COMPANY_ADDR.'  -  '.COMPANY_PHONE.'  -  '.COMPANY_WEB.' ',0,1,'C');
			$this->Ln(12);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Employee Name:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,$EmployeeName,0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Employee Address:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,$EmployeeAddress,0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Hourly Rate:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format($EmployeeRate, 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Total Hours Worked:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,$TotalHours,0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Total Tips:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format($TotalTipMade, 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Pay period Earning:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format($EmployeeRate * $TotalHours, 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'State Tax Deduction:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format((($EmployeeRate * $TotalHours * 7.5)/100), 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Pay Check Amount:',0,0,'L');
			$this->SetFont('Times','B',12);
			$this->Cell(0,0,'$ '.number_format((($EmployeeRate * $TotalHours)-(($EmployeeRate * $TotalHours * 7.5)/100)), 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Minimum Wage Adjusted Amount:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format($minimumWageAdjusted * $TotalHours, 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Minimum Wage Adjusted Tax:',0,0,'L');
			$this->SetFont('Times','I',10);
			$this->Cell(0,0,'$ '.number_format((($minimumWageAdjusted * $TotalHours * 7.5)/100), 2),0,1,'L');
			$this->Ln(6);
			$this->SetFont('Times','B',10);
			$this->Cell(90,0,'Total Adjusted Tax Owed:',0,0,'L');
			$this->SetFont('Times','B',12);
			$this->Cell(0,0,'$ '.number_format((($minimumWageAdjusted * $TotalHours * 7.5)/100) + (($EmployeeRate * $TotalHours * 7.5)/100), 2),0,1,'L');
			$this->Ln(15);
			global $col1;
			global $col2;
			global $col3;
			global $col4;
			$this->Line(200,104,10,104);
			$this->SetFont('Times','B',12);
			$this->Cell($col1,0,'Clock In Time',0,0);
			$this->Cell($col2,0,'Clock Out Time',0,0);
			$this->Cell($col3,0,'Tip Reported',0,0);
			$this->Cell($col4,0,'Hours Worked',0,0);
			$this->Line(200,112,10,112);
		    //Line break
		    $this->Ln(10);
			
		}
		//Page footer
		function Footer() {
		    //Position at 1.5 cm from bottom
		    $this->SetY(-15);
		    //Arial italic 8
		    $this->SetFont('Times','',8);
		    //Page number
		    $this->Cell(0,10,'Page '.$this->PageNo().' of {nb}',0,0,'C');
		}
	}
	## FUNCTIONS
	function formatDateForTimeclock($timestamp) {
		if ($timestamp == "0000-00-00 00:00:00") return '<span id="open">Waiting for Employee to Clock Out . . . . .</span>';
		else return date("M j 'y - g:i a", strtotime($timestamp));
	}
	function getDurationClockedIn($start, $stop) {
		if ($stop < $start) return "";
		else return number_format( ( ( strtotime($stop) - strtotime($start) ) / 3600 ), 2);
	}
	function stripPDFComment($text) {
		$text = str_replace("<p>", "", $text);
		$text = str_replace("</p>", "", $text);
		$text = str_replace("<br />", "\n", $text);
		$text = str_replace("<br>", "\n", $text);
		$text = str_replace("<em>", "", $text);
		$text = str_replace("</em>", "", $text);
		$text = str_replace("<strong>", "", $text);
		$text = str_replace("</strong>", "", $text);
		$text = str_replace("&nbsp;", " ", $text);
		return $text;
	}

	$sql = "
		select * from timetable 
		where keyid = " . $_COOKIE['EmployeeId'] . " 
		and start >= '" . date( "Y-m-d H:i:s", $fromTimestamp ) . "' 
		and start <= '" . date( "Y-m-d H:i:s", $toTimestamp ). "' 
		order by timeid desc
		";
	$rs = $conn->Execute( $sql );
	## GET MAX HOURS
	while ( !$rs->EOF )
	{
		$TotalHours = number_format( $TotalHours + getDurationClockedIn( $rs->fields['start'], $rs->fields['stop'] ), 2 );
		$TotalTipMade = $rs->fields['tipMade'] + $TotalTipMade;
		$rs->MoveNext();
	}
	## PDF SETTINGS
	$col1 = 35;
	$col2 = 35;
	$col3 = 30;
	$col4 = 20;
	$pdf=new PDF('P','mm','A4');
	$pdf->AliasNbPages();
	$pdf->AddPage();
	## RERUN SQL FOR PDF
	$rs = $conn->Execute( $sql );
	while ( !$rs->EOF )
	{
		$pdf->SetFont('Times','I',9);
		$pdf->Cell($col1,4,formatDateForTimeclock($rs->fields['start']),0,0);
		$pdf->Cell($col2,4,formatDateForTimeclock($rs->fields['stop']),0,0);
		$pdf->Cell($col3,4,'$ '.$rs->fields['tipMade'],0,0,C);
		$pdf->Cell($col4,4,getDurationClockedIn($rs->fields['start'], $rs->fields['stop']),0,0,C);
		$pdf->Ln(5);
		$rs->MoveNext();
	}
	
	## DO PDF
	$pdf->Output();
	include_once( 'adodb_disconnect.php' );
?>