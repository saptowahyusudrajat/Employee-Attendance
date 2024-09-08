
<?php

require_once "Classes/PHPExcel.php";
$user = "#".$_POST["uname"]."#";
$pass = "#".$_POST["pword"]."#";
$namasheet = 'DataPegawai';
$last;

		$tmpfname = "kus.xlsx";
		$excelReader = PHPExcel_IOFactory::createReaderForFile($tmpfname);
		$excelObj = $excelReader->load($tmpfname);
		$worksheet = $excelObj->getSheetByName($namasheet);
		$lastRow = $worksheet->getHighestRow();
		
		
		for ($row = 1; $row <= $lastRow; $row++) {			
			 //echo $worksheet->getCell('A'.$row)->getValue();			 
			 //echo $worksheet->getCell('B'.$row)->getValue();
			 //echo '#';
			 
			 $un = "#".($worksheet->getCell('A'.$row)->getValue())."#";
			 $ps = "#".($worksheet->getCell('B'.$row)->getValue())."#";
			 if($un== $user && $ps==$pass ){				 
				echo 'login sukses!'; 								
				break;
			 }
			if($row==$lastRow&&$un!=$user&$ps!=$pass){
				echo 'username atau password salah!';
			}
			 
		}
		
		

//gawe save	
require_once 'Classes/PHPExcel/IOFactory.php';
$objWriter = PHPExcel_IOFactory::createWriter($excelObj, 'Excel2007');
$objWriter->save('kus.xlsx');
//gawe save
?>

