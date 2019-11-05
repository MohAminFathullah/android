<?php
   require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='POST') {
   $id_mobil = $_POST['id_mobil'];
  $result = mysqli_query($con,"SELECT * FROM tbmobil where id_mobil='$id_mobil'") or die(mysqli_error());
  if (mysqli_num_rows($result) > 0){
      $sql = "DELETE FROM tbmobil WHERE id_mobil = '$id_mobil'";
     if(mysqli_query($con,$sql)) {
       $response["success"] = 1;
       $response["message"] = "Berhasil";
       echo json_encode($response);
     } else {
       $response["success"] = 0;
       $response["message"] = "Gagal";
       echo json_encode($response);
     }
  }else{
       $response["success"] = 0;
       $response["message"] = "Data tidak ada";
       echo json_encode($response);
  }
   mysqli_close($con);
  } else {
    $response["success"] = 0;
    $response["message"] = "Error";
    echo json_encode($response);
  }
?>

