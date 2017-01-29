<?php
require 'learnphp_hackveda.php';
$user_name="Kartik123";
$user_pass="Kartik321";
$sql_query="select name from user_info where Username like '$user_name' and Userpass like '$user_pass'  ";

$result=mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0)
{
	$row=mysqli_fetch_assoc($result);
	$name=$row["name"];
	echo "Welcome ".$name;

}
	else {
		echo "no info available";
	}
	

?>
