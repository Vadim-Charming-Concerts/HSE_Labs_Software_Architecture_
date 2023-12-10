# Лабораторная работа №3

## Краткое описание варианта использования

Выберем процесс аутентификации в приложении по учёту ПО и КТС с использованием разных ролей пользователя, как один из основных вариантов использования. На диаграмме компонентов, представленной ниже, можно увидеть, как процесс авторизации в приложении связан с системой в целом (с клиентской и серверной частями):

![Общая диаграмма компонентов](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/dd65565c-8e4f-4eba-855a-d5ea99524145)

После этого перейдем к более детальному описанию процесса аутентификации в приложении различными видами пользователей. Построим диаграмму последовательностей, на которой отразим основные моменты авторизации пользователя (администратора, пользователя с расширенным функционалом и пользователя с огранченным функционалом) в приложении:

![Диаграмма последовательностей](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/d8957e42-ad57-4896-b0a7-017d83af20bc)

## Схемы базы данных

В настоящей работе предусмотрено использование двух баз данных (по учёту программного обеспечения и комплекса технических средств), которые существуют независимо друг от друга.

___Схема базы данных по учёту ПО:___

![Схема БД по учёту ПО](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/063a0ba9-b21b-41a8-9033-93f3c2501ef2)

___Схема базы данных по учёту КТС:___

![Схема БД по учёту КТС](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/e73ad181-2264-4ccf-9a89-fd82e7efe067)

Структура базы данных по учёту ПО (описание таблицы):

![POT1](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/4abc914c-00b3-41ea-9458-48ff6badbb6c)

Структура базы данных по учёту КТС (описание таблиц):

![Equip](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/7cc6369f-b13c-46f4-bb0e-89143f0cbb84)

![Status](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/d87483ae-c4a3-43ab-8011-50200eb6e485)

![Users](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/c55e9378-4d58-4c0c-a36e-40cb31826c97)

![Address](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/eafe2ad5-020d-4626-9022-dbbb3d7d2f3c)

![Job](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/0c60a615-b1ea-4097-8816-42c257485a76)

![Offices](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/27b690d3-1acb-4198-8230-84a044b39405)

![Type](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/b6e73d30-0195-4d6a-bc6a-02edb044cd56)

![NaSt](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/5bd9a524-7d56-4b6b-967f-e0b1cecd7b5b)

![NetH](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/84887b24-f464-4e9c-ad02-9c2143815fcb)

![THNB](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/f6eadd1d-2cea-40ab-8c0e-391bdb70c89a)

![THSB](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/7a5b7dda-60c9-4e14-a6fb-4eb1e285f7b3)

Приступим к реализации серверного и клиентского кода с учётом принципов KISS, YAGNI, DRY и SOLID.
Для начала необходимо понять, что означает каждый из этих принципов:
* KISS (Keep It Simple, Stupid / Будь проще) - код должен быть производительным, эффективным и простым;
* YAGNI (You Aren’t Gonna Need It / Вам это не понадобится) - нужно писать только тот код, который понадобится;
* DRY (Don’t Repeat Yourself / Не повторяйтесь) - нужно избегать дублирования кода;
* SOLID (Single-responsibility principle /Принцип единственной ответственности) - Каждый объект, класс и метод должны отвечать только за что-то одно.
Далее представлены фрагменты кода с использованием вышеперечисленных принципов проектирования и реализации модулей.

KISS (названия переменных интуитивно понятны, код является простым, эффективным и в то же время производительным):

$sql="SELECT * FROM Equip WHERE id=$nst";
if($result = $conn->query($sql)){
	$row=$result->fetch_assoc();
	$NPP=$row["id"]; // $NPP=$nst
	$NTE=$row["NType"];
	$Model=$row["Model"];
	$SN=$row["SN"];
	$IN=$row["Inv_Num"];
	$SiNa=$row["SiNa"];
}
//***************************************	
echo '<form  method="post" action="DB_in.php"  target=_parent>';

//	echo '<p>Выбрать тип оборудования:<br>';
$NaT="Type";$NaP="Type";
echo '<p>Тип оборудования:<input type="text" name="Type" 
readonly value="'.seq($NaT,$NTE,$NaP),'">';
    echo '<p>Модель оборудования:';
    echo '<input type="text" name="Model" readonly value="'.$Model.'">';
    echo '<p>Серийный номер:';
    echo '<input type="text" name="SN" readonly value='.$SN.'>';
	echo '<p>Инвентарный номер:';
    echo '<input type="text" name="Inv_Num" readonly value='.$IN.'>';
	echo '<p>Сетевое имя:';
    echo '<input type="text" name="SiNa" readonly value='.$SiNa.'>';
echo '</form>';
echo '</td>';
echo '<td valign="top">';

YAGNI (исключаем те методы и функции, которые не пригодятся (закомментируем их) и оставляем только те, которые понадобятся):

<?php
//echo "UStoExcel.php\n";
//spl_autoload_unregister('autoload');
//echo __DIR__;
require_once __DIR__ .'/PHPExcel/Classes/PHPExcel.php';
require_once __DIR__ .'/PHPExcel/Classes/PHPExcel/Writer/Excel2007.php';
//$items=array();
$xls = new PHPExcel();
$xls->setActiveSheetIndex(0);
$sheet = $xls->getActiveSheet();
// Шапка
$sheet->getStyle("A1:B1")->getFont()->setBold(true);
$sheet->setCellValue("A1", 'id');
$sheet->setCellValue("B1", 'Адрес (город, улица, дом и номер корпуса)');
// Выборка из БД
$conn = new mysqli("localhost", "root", "","Eq01");
if($conn->connect_error){die("Ошибка: " . $conn->connect_error);}
$sql="SELECT * FROM Address";
if($result=$conn->query($sql))$rowsCount=$result->num_rows;
$index = 2;
while($row=$result->fetch_assoc()){
$sheet->setCellValue("A" . $index, $row['id']);
$sheet->setCellValue("B" . $index, $row['AdReg']);
$index++;
}
$conn->close();
//foreach ($items as $row) {
// Отдача файла в браузер
header("Expires: Mon, 1 Apr 1974 05:00:00 GMT");
header("Last-Modified: " . gmdate("D,d M YH:i:s") . " GMT");
header("Cache-Control: no-cache, must-revalidate");
header("Pragma: no-cache");
header("Content-type: application/vnd.ms-excel" );
header("Content-Disposition: attachment; filename=Address.xlsx");
$objWriter = new PHPExcel_Writer_Excel2007($xls);
$objWriter->save('php://output'); 
exit(); 
?>

DRY (чтобы избежать дублирование кода, было принято решение создать функции):

<?php
function seq($NaT,$NTE,$NaP)
{global $conn;
	//	echo '<p>Выбрать тип оборудования:<br>';
$sql1 = "SELECT * FROM $NaT WHERE id=$NTE";
if($res = $conn->query($sql1)){
    $rowsCount = $res->num_rows; // количество полученных строк
	$row = $res->fetch_assoc();
	$TE=$row["$NaP"];
}
return $TE;
}
function odb($NDB)
{global $conn;
	$conn = new mysqli("localhost", "root", "",$NDB);
if($conn->connect_error){
    die("Ошибка: " . $conn->connect_error);
}
echo "Подключение успешно установлено";
//return "$conn";
}
?>

SOLID (для того, чтобы избежать ситуации, когда какой-либо объект, класс или метод отвечает за разный функционал, было принято решение поделить на классы - каждый класс решает определенную задачу):

![SOLID](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/9a4eebdb-f039-4cf5-be25-3cf0d36b1b6c)

Объекты и методы внутри классов также отвечают только за что-то одно:

<?php
//require_once 'connect.php';
$conn = new mysqli("localhost", "root", "","Eq01");
if($conn->connect_error){
    die("Ошибка: " . $conn->connect_error);
}
//echo "Подключение успешно установлено";
//phpinfo();
$ned = (int)$_POST['ed'];
$sql="SELECT * FROM Offices WHERE id=$ned";
if($result = $conn->query($sql)){
	foreach($result as $row){
	$id=$row["id"];
	$Office=$row["Office"];
}}
echo '<form  method="post" action="OFnew1.php" target="_parent">';
echo '<p>id:<input type="text" name="id" readonly value='.$id.'></p>';
echo '<p>Подразделение:<input type="text" name="Office" value='.$Office.'></p>';
echo '<p><input type="submit" value="Обновить"></p>';
echo '</form>';
$conn->close();
echo '<form  method="post" action="main.php" target="_parent">';
echo '<p><input type="submit" value="Вернуться обратно"></p>';
echo '</form>';
   echo '<script>';
//echo 'window.location.href ="main.php";';
echo '</script>'; 
?>
