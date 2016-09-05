<?php
$servername = "localhost";
$username = "jiaxing";
$password = "199315";
$dbname = "myDB";

$name = $_POST["name"];
$email = $_POST["email"];
//Create connection
$conn = mysqli_connect($servername, $username, $password);
if(!$conn){
  die("Connection failed: ". mysqli_connect_error());
}
$sql0 = "CREATE DATABASE" . $dbname;
if(mysqli_query($conn, $sql0)){
  echo "Database create successfully."
}else{
  echo "Error creating database: " . mysqli_error($conn);
}

$sql1 = "CREATE TABLE student(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  email VARCHAR(50) NOT NULL
)"

if(mysqli_query($conn, $sql1)){
  echo "Table create successfully."
}else{
  echo "Error creating table: " . mysqli_error($conn);
}

$sql2 = "INSET INTO student (name, email)
  VALUES (?,?)";
$stmt = mysqli_prepare($conn, $sql2);
mysqli_stmt_bind_param($stmt, "ss", $name, $email);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_afftected_rows($stmt)==1){
  echo "Student Inserted";
  mysqli_stmt_close($stmt);
}else{
  echo "Error :" . mysqli_error($conn);
}

mysqli_close($conn);
?>
