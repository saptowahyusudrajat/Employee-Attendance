
<?php

require_once "Classes/PHPExcel.php";
$namasheet = $_POST["daritextboxlogin"];
//$ijin = $_POST["daributtoninput"];
//$namasheet = "Dipra";
$ijin="";
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
		
		
if($worksheet->getCell('E'.$lastRow)==""){	
	//autosize kolom	
	$excelObj->getActiveSheet()->getColumnDimension('A')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('B')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('C')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('D')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('E')->setAutoSize(true);
	//autosize kolom	
	date_default_timezone_set("Asia/Jakarta");	
		
			if($ijin==""){				
				if($worksheet->getCell('B'.($lastRow))==""){
					echo "2";
					$cekB=true;
					$cekC=true;
					$cekD=true;
					$cekE=true;
					$kolom='B';		
					$excelObj->setActiveSheetIndexByName($namasheet);
					$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), "absesnsi ".date(" d-m-Y h:i:sa"));
				}
			
					if($cekB==false&&$worksheet->getCell('C'.($lastRow))==""){
					echo "3";
					$cekC=true;
					$cekD=true;
					$cekE=true;
					$kolom='C';		
					$excelObj->setActiveSheetIndexByName($namasheet);
					$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), "absesnsi ".date(" d-m-Y h:i:sa"));
				}
			
					if($cekC==false&&$worksheet->getCell('D'.($lastRow))==""){
					echo "4";
					$cekD=true;
					$cekE=true;
					$kolom='D';		
					$excelObj->setActiveSheetIndexByName($namasheet);
					$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), "absesnsi ".date(" d-m-Y h:i:sa"));
				}
			
					if($cekD==false&&$worksheet->getCell('E'.($lastRow))==""){
					echo "5";
					$cekE=true;
					$kolom='E';		
					$excelObj->setActiveSheetIndexByName($namasheet);
					$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), "ok");
				}
			}
			
			else{
				echo "5";
				$kolom='E';		
				$excelObj->setActiveSheetIndexByName($namasheet);
				$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow), $ijin." ,".date(" d-m-Y h:i:sa"));
			}
}
else{
	echo "1";
	date_default_timezone_set("Asia/Jakarta");
	$excelObj->getActiveSheet()->getColumnDimension('A')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('B')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('C')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('D')->setAutoSize(true);
	$excelObj->getActiveSheet()->getColumnDimension('E')->setAutoSize(true);
			
			if($ijin==""){
				if($worksheet->getCell('A'.($lastRow+1))==""
				&&$worksheet->getCell('B'.($lastRow+1))==""
				&&$worksheet->getCell('C'.($lastRow+1))==""
				&&$worksheet->getCell('D'.($lastRow+1))==""
				&&$worksheet->getCell('E'.($lastRow+1))==""){
				$cekA=true;
				$kolom='A';		
				$excelObj->setActiveSheetIndexByName($namasheet);
				$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow+1), "absesnsi ".date(" d-m-Y h:i:sa"));
}
			}
			else{
				$kolom='E';		
				$excelObj->setActiveSheetIndexByName($namasheet);
				$excelObj->getActiveSheet()->setCellValue($kolom.($lastRow+1), $ijin." ,".date(" d-m-Y h:i:sa"));
			}
}

//gawe save	
	//require_once 'Classes/PHPExcel/IOFactory.php';
	//$objWriter = PHPExcel_IOFactory::createWriter($excelObj, 'Excel2007');
	//$objWriter->save('kus.xlsx');
//gawe save
?>

