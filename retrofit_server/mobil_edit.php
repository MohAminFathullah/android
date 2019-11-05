<?php
   require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='POST') {
   $merk = $_POST['merk'];
   $type = $_POST['type'];
     $sql = "UPDATE tbmobil SET merk = '$merk', type='$type' WHERE id_mobil = '$id_mobil'";
     if(mysqli_query($con,$sql)) {
       $response["success"] = 1;
       $response["message"] = "Berhasil";
       echo json_encode($response);
     } else {
       $response["success"] = 0;
       $response["message"] = "Gagal";
       echo json_encode($response);
     }
   mysqli_close($con);
  } else {
    $response["success"] = 0;
    $response["message"] = "Error";
    echo json_encode($response);
  }
?>