$(document).ready(function(){
    $('.table .editButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
		$.get(href, function(stud, status){
			$('#studIdEdit').val(stud.stuId);
			$('#firstNameEdit').val(stud.firstName);
			$('#middleNameEdit').val(stud.middleName);
			$('#lastNameEdit').val(stud.lastName);
			$('#addressEdit').val(stud.address);
			$('#courseEdit').val(stud.course);
			$('#dobEdit').val(stud.dob);

		});
        $('#editModal').modal('show')
    });
        $('.table .deleteButton').on('click',function(event){
                event.preventDefault();
                var href = $(this).attr('href');
		        $('#deleteModel #delRef').attr('href',href);
                $('#deleteModel').modal('show');


        });

});