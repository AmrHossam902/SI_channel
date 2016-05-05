
<?php

$con=mysqli_connect("127.0.0.1","root","","si_channel");

if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}

$Method=$_POST["Method"];
$sql = $_POST["Query"];


if($Method == "select")
{
	$result = mysqli_query($con, $sql);
	$response = array();

	while($row = mysqli_fetch_array($result))
	{
		array_push($response ,array("Name"=>$row[0], "ID"=>$row[1], "Grade_year"=>$row[2], "PassWord"=>$row[3]));
	}
	echo json_encode(array("server_response"=>$response));
}

elseif($Method == "insert" | $Method =="Delete")
{
	if(mysqli_query($con, $sql))
		echo "success";
	else
		echo "fail";
}

mysqli_close($con);
?>
