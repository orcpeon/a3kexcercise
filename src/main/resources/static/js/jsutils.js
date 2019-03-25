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