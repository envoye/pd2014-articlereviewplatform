/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('<div class="tl"></div><div class="tr"></div><div class="bl"></div><div class="br"></div>').appendTo("div.single-field");
$( document ).ready(function() {
  alert("oi1");
  //$("form.jqtransform").jqTransform();
    //$("form").highlight();
    
//   var st= $("#daaatepicker");
//   st.datepicker();
    
    $(".datetime").datepicker({ dateFormat: 'dd/mm/yy' ,changeMonth: true,
      changeYear: true});
   
  //$("#j_idt31:datanascimentoInput").datepicker();
    
});




