<?php
$db_name="webappdb";
$mysql_user="root";
$mysql_pass="mysql";	
$server_name="localhost";
$con=mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);
if(!$con)
{
//	echo "Connection error";
	//echo "Connection error...".mysqli_connect_error();
	
}
else {
	//echo "<h2>Connection Succes<h2>";
}


?>