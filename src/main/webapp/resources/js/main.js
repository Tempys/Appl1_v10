/**
 * Created by mikhail on 27.09.14.
 */

$(document).ready(function() {
    if( $('.ErrorMessage').html() == '' ) {
        $('.ErrorMessage').hide();
    }


    $(document).on('click','[data-id]',function(){
        var data = $(this).data("id");
        window.location.href = '/update/'+data;
    });

    $(document).on('click','[data-name]', function(){

        var data = $(this).data("name");
        var postReqData = {}; // Create an empty object
        //  postReqData["removeName"] = data;
        window.location.href = '/remove/'+data;


    }  );



    $('#err').click(function(){
        window.location.href='/registration';

    })

    $('#search').click(function(){

        $.ajax({
            type: 'Post',
            url: "/table",
            dataType: 'json',
            data:$('#dataSearch').serialize(),
            success: function (data,jqXHR) {
              alert(data);
            },
            error:function(jqXHR){
              var obj = $.parseJSON(jqXHR.responseText);
              alert(obj);
            }

        })
    })




})


