/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   function validateForm() {
  var x = document.getElementById("name").value;
  if (x == " ") {
    alert("Name must be filled out");
    return false;
  }
  return true;
} 


