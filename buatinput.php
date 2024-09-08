
<?php

require_once "Classes/PHPExcel.php";
$namasheet = $_POST["daritextboxlogin"];
$ijin = $_POST["daritextboxketerangan"];
//$namasheet = "Dewok";
$kolom;

$spiner=$_POST["spiner"];

$cekA = false;
$cekB =false;
$cekC =false;
$cekD = false;
$cekE = false;

//$_absen = $_POST["_absen"];

		$tmpfname = "kus.xlsx";
		$excelReader = PHPExcel_IOFactory::createReaderForFile($tmpfname);
		$excelObj = $excelReader->load($tmpfname);
		$worksheet = $excelObj->getSheetByName($namasheet);
		$lastRow = $worksheet->getHighestRow();	
		
		
		
$excelObj->getActiveSheet()->getColumnDimension('A')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('B')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('C')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('D')->setAutoSize(true);
$excelObj->getActiveSheet()->getColumnDimension('E')->setAutoSize(true);
date_default_timezone_set("Asia/Jakarta");	
		
if($worksheet->getCell('E'.$lastRow)!=""){
	
	$lastRow=($lastRow+1);	
}

		
		if($spiner=="Masuk"){
			$kolom='A';
		}
		else if($spiner=="Istirahat"){
			$kolom='B';		
		}
		else if($spiner=="Kembali"){
			$kolom='C';	
		}
		else if($spiner=="Pulang"){
			$kolom='D';
			$excelObj->setActiveSheetIndexByName($namasheet);
			$excelObj->getActiveSheet()->setCellValue('E'.($lastRow), "ok");
		}
		else{
			$kolom='E';	
		}	
		
		if($kolom!='E'){
			$excelObj->setActiveSheetIndexByName($namasheet);
			$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), $ijin.date(" d-m-Y h:i:sa"));
			
		}
		else{
			$excelObj->setActiveSheetIndexByName($namasheet);
			$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), $ijin." ".date(" d-m-Y h:i:sa"));
			if($worksheet->getCell('A'.($lastRow))!=""){
				$excelObj->setActiveSheetIndexByName($namasheet);
				$excelObj->getActiveSheet()->setCellValue('D'.($lastRow),$ijin." ".date(" d-m-Y h:i:sa") );
			}
		}
		
//gawe save	
	require_once 'Classes/PHPExcel/IOFactory.php';
	$objWriter = PHPExcel_IOFactory::createWriter($excelObj, 'Excel2007');
	$objWriter->save('kus.xlsx');
//gawe save	

?>

