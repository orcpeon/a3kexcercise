function totalClicked() {
        var sum=0;
        var votesArray = document.getElementsByClassName("votesCell");

    for (i = 0; i < votesArray.length; i++) {
        var cellNumber=parseInt(votesArray[i].innerHTML);
        if(!isNaN(cellNumber)){
            sum = sum + cellNumber;
        }
    }

    document.getElementById("total-cell").innerHTML=sum;
    }



$(document).ready(function(){
    $(".js-updateVotes").on("click",function(e){
        e.preventDefault();
        var name = $(this).text();
        var cellClicked = $(this);

        $.ajax({
          type : "GET",
          url : "/upd?color=" + name,
          success : function(response) {
          console.log(response);
              cellClicked.parent().next().html(response);
          },
          error : function(e) {
               alert('Error: ' + e);
          }
        });
    })
})