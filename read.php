<!doctype>
<html>
<head>
</head>
<body>
<?php

require_once "Classes/PHPExcel.php";

		$tmpfname = "Book1.xlsx";
		$excelReader = PHPExcel_IOFactory::createReaderForFile($tmpfname);
		$excelObj = $excelReader->load($tmpfname);
		$worksheet = $excelObj->getSheet(0);
		$lastRow = $worksheet->getHighestRow();
		
		echo $lastRow;	
?>

</body>
</html>