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
        console.log("CALLED");
        var name = $(this).text();
        console.log(name);
//        console.log($(this).parent().next().text());
        var loh = $(this);

        $.ajax({
          type : "GET",
          url : "/upd?color=" + name,
          success : function(response) {
          console.log(response);
          console.log(loh.parent().next().text());
              loh.parent().next().html(response);
          },
          error : function(e) {
               alert('Error: ' + e);
          }
        });
    })
})



/*
function updateVotes() {

    console.log("CALLED");
    console.log($(this));
    var name = $(this).text();
    console.log(name);

    $.ajax({
      type : "GET",
      url : "/ajax?color=" + name,
      success : function(response) {
          $(this).next().text(response);
      },
      error : function(e) {
           alert('Error: ' + e);
      }
    });
}*/
