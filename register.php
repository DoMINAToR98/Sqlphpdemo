<?php
require 'learnphp_hackveda.php';
$name=$_POST["user"];
$user_name=$_POST["username"];
$user_pass=$_POST["userpass"];		
$sql_query="insert into user_info values('$name','$user_name','$user_pass')";


if(mysqli_query($con, $sql_query)){
	//echo "Data insertion success";
}
else{
//	echo "Error".mysqli_error($con);
	
}
	

?>