/**
 * Created by Frenos on 18.08.2016.
 */
$(document).ready(function()
{
    $('#btnAddJobs').click(function(){
        $.get("/trigger");
    });

    $('#btnSetPoolsize').click(function () {
        var newSize = $('#newPoolsize').val();
        $.get("/poolsize/"+newSize);
    });

    setTimeout(updateProgress, 10);
});

function updateProgress(){
    $.ajax({
        url: './status',
        success: function(data){
            $.each(data,function(index, element){
                var rows = $('#tableBody').find('#'+element.jobName);
                if(rows.length === 0)
                {
                    $('#tableBody').append('<tr id="'+element.jobName+'">' +
                        '<td>'+element.jobName+'</td>'+
                            '<td>'+
                            '<div class="progress"> <div class="progress-bar" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em;"> 0%</div></div>' +
                        '</td>'+
                        '<td class="state"></td></tr>');
                }


                //set stuffs
                var parentDiv = $('#'+element.jobName);
                parentDiv.find('.progress-bar').html(element.progress +"%");
                parentDiv.find('.progress-bar').css('width',element.progress+'%').attr("aria-valuenow",element.progress);
                parentDiv.find('.state').text(element.status);
                if(element.status == "DONE")
                {
                    parentDiv.removeClass("active info success").addClass("success");
                }
                else if(element.status == "RUNNING")
                {
                    parentDiv.removeClass("active info success").addClass("active");
                }
                else if(element.status == "NEW")
                {
                    parentDiv.removeClass("active info success").addClass("info");
                }
                //end set stuffs
            })
        }
    });
    console.log($('#content').children().length);
    setTimeout(updateProgress,1000);
}