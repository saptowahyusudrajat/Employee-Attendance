<!doctype>
<html>
<head>
</head>
<body>
<?php

require_once "Classes/PHPExcel.php";

$namasheet = 'Anas';
$last;

		$tmpfname = "kus.xlsx";
		$excelReader = PHPExcel_IOFactory::createReaderForFile($tmpfname);
		$excelObj = $excelReader->load($tmpfname);
		$worksheet = $excelObj->getSheetByName($namasheet);
		$lastRow = $worksheet->getHighestRow();
		
		echo "<table>";
		for ($row = 1; $row <= $lastRow; $row++) {
			 echo "<tr><td>";
			 echo $worksheet->getCell('A'.$row)->getValue();
			 echo "</td><td>";echo "</td><td>";echo "</td><td>";echo "</td><td>";echo "</td><td>";
			 echo $worksheet->getCell('B'.$row)->getValue();
			 echo "</td><td>";echo "</td><td>";echo "</td><td>";echo "</td><td>";echo "</td><td>";
			 echo $worksheet->getCell('C'.$row)->getValue();
			 echo "</td><tr>";
		}
		echo "</table>";	
	
	$cek = $worksheet->getCell('A'.($lastRow))->getValue();
	$akhir;
	echo $cek;
	if($cek=='Masuk'){
		$akhir=($lastRow+1);
	}
	
	else if (($worksheet->getCell('A'.$row)->getValue())!=""){
		
		$akhir=$lastRow;
	}
	else{
		
		$akhir=($lastRow+1);
	}
	
//autosize kolom	
$excelObj->getActiveSheet()->getColumnDimension('A')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('B')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('C')->setAutoSize(true);
//autosize kolom
	
date_default_timezone_set("Asia/Jakarta");	

//gawe nambah baris kebawah	
$kolom='A';		
$excelObj->setActiveSheetIndexByName($namasheet);
$excelObj->getActiveSheet()->setCellValue($kolom.$akhir, "balek ".date(" d-m-Y h:i:sa"));
//gawe nambah baris kebawah
		
//gawe save	
require_once 'Classes/PHPExcel/IOFactory.php';
$objWriter = PHPExcel_IOFactory::createWriter($excelObj, 'Excel2007');
$objWriter->save('kus.xlsx');
//gawe save
?>

</body>
</html>