<!doctype>
<html>
<script>
var a=5;
function myFunction() {
	a++;
if(a==20){
document.getElementById("demo").innerHTML = "sukses input";

	<?php
require_once "Classes/PHPExcel.php";
$objPHPExcel = new PHPExcel();
//$objPHPExcel->createSheet(3);	


$myWorkSheet = new PHPExcel_Worksheet($objPHPExcel, 'pegawai999');
$objPHPExcel->addSheet($myWorkSheet, 0);
$myWorkSheet = new PHPExcel_Worksheet($objPHPExcel, 'sudrajat');
$objPHPExcel->addSheet($myWorkSheet, 1);
$objPHPExcel->setActiveSheetIndex(1);
$objPHPExcel->getActiveSheet()->setCellValue('D1', 'hai sapto dont give up');
require_once 'Classes/PHPExcel/IOFactory.php';
$objWriter = PHPExcel_IOFactory::createWriter($objPHPExcel, 'Excel2007');
$objWriter->save('kirab.xlsx');
?>

}
else{
document.getElementById("demo").innerHTML = a;
}
  return 0;
}

</script>
<p id="demo">A Paragraph.</p>

<button type="button" onclick="myFunction()">KLIK</button>


	




</html>