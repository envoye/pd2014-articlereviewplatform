/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
   
    $(".datetime").datepicker({ dateFormat: 'dd/mm/yy' ,changeMonth: true,
      changeYear: true});
    $( ".selector" ).spinner({ max: 10, min: 1});
    $( ".selector" ).spinner( "value", 5 );
    $( ".selector" ).spinner({ numberFormat: "n" });
});
