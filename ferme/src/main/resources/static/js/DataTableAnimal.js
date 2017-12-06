//
//$(document).ready( function () {
//	
//	 var table = $('#animalTable').DataTable({
//		    
//		    "order": [[ 0, "asc" ]],
//			"aoColumns": [
//			    { "mData": "id"},
//		      { "mData": "type" },
//			    { "mData": "nourritureConsomme" },
//		        { "mData": "ferme_id" }
//				
//			    
//			],
//			
//			bfilter : true,
//	 
//		 language: {
//         processing:     "Traitement en cours...",
//         search:         "Rechercher&nbsp;:",
//         lengthMenu:     "Afficher _MENU_ &eacute;l&eacute;ments",
//         info:           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
//         infoEmpty:      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
//         infoFiltered:   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
//         infoPostFix:    "",
//         loadingRecords: "Chargement en cours...",
//         zeroRecords:    "Aucun &eacute;l&eacute;ment &agrave; afficher",
//         emptyTable:     "Aucune donnée disponible dans le tableau",
//         paginate: {
//             first:      "Premier",
//             previous:   "Pr&eacute;c&eacute;dent",
//             next:       "Suivant",
//             last:       "Dernier"
//         },
//         aria: {
//             sortAscending:  ": activer pour trier la colonne par ordre croissant",
//             sortDescending: ": activer pour trier la colonne par ordre décroissant"
//         }
//     }     
//    
//		 
//	 	 });
//	 
//	 	 	 
//	 $("#animal").detach().appendTo("#col1").select2(
//	    		{
////	    			 minimumInputLength: 2,
//	    			 placeholder: "Select animal",
//	    			 dropdownAutoWidth : 'true',
//	    			 allowClear: true
//	    			}).on("change", function () {
//	    			  var selection = $(this).val();
//	    		      var table_animal = $('#animalTable tbody').find('tr');
//	    		      table_animal.show();
//	    	          table_animal.filter(function(index, item) {
//	    		        return $(item).find('td:first-child').text().split(',').indexOf(selection) === -1;
//	    		     }).hide();
//	    		});
//	    
//	 
//
//	    
//	  
//	  
//	 
//});


$.validator.setDefaults({
    errorElement: "span",
    errorClass: "help-block",
    //	validClass: 'stay',
    highlight: function (element, errorClass, validClass) {
        $(element).addClass(errorClass); //.removeClass(errorClass);
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).removeClass(errorClass); //.addClass(validClass);
        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorPlacement: function (error, element) {
        if (element.parent('.input-group').length) {
            error.insertAfter(element.parent());
        } else if (element.hasClass('select2')) {
            error.insertAfter(element.next('span'));
        } else {
            error.insertAfter(element);
        }
    }
});

//
//$("#animal").detach().appendTo("#col1").select2(
//		{
//			 minimumInputLength: 2,
//			 placeholder: "Select animal",
//			 dropdownAutoWidth : 'true',
//			 allowClear: true
//			}).on("change", function () {
//				var selection = $(this).val();
//			   var table_animal = $('#animalTable tbody').find('tr');
//		      table_animal.show();
//	          table_animal.filter(function(index, item) {
//		        return $(item).find('td:first-child').text().split(',').indexOf(selection) === -1;
//		     }).hide();
//		});



$(document).ready(function () {

    $('.select2').on('change', function () {
        $(this).valid();
        
    });

    $("#gyr_ind").select2();

    var validator = $("#documentAdmin").validate();

});



