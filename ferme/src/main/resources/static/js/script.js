(function() {
  var $select = $('select').select2({
    placeholder: 'Choose',
    allowClear: true
  });
  
  /*
   * When you change the value the select via select2, it triggers
   * a 'change' event, but the jquery validation plugin
   * only re-validates on 'blur'
   */
  $select.on('change', function() {
    $(this).trigger('blur');
  });

  $('#myForm').validate({
    ignore: 'input[type=hidden], .select2-input, .select2-focusser'
  });
  
  var test = $aminal.val();
  //alert(test);
  
  $select.rules('add', 'required');
}());