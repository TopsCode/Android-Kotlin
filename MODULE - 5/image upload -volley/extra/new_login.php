<?php
include 'animal_connect.php';

$email = $_POST['email'];
$pwd = $_POST['password']; 


$sql="select*from animal where email='$email' and password = '$pwd'";

$r=mysqli_query($con,$sql);

$response["result"]=array();

while($row=mysqli_fetch_array($r))
{
        $value=array();
    
        $value["id"] = $row["id"];
        $value["name"] = $row["name"];
        $value["email"] = $row["email"];
        $value["password"] = $row["password"];
        $value["img"] = $row["img"];

        array_push($response["result"],$value);
}

echo json_encode($response);
mysqli_close($con);
 
?>