$(document).ready(function() {

    fetchTweets1();
	//fetchTweets();


	$("#serach").on('click', function(e) {

        
        var html = "";
        var key = $("#serachtext").val();
          // console.log("key"+key);
		$.post("/tweets", { keyword: key }, function(result, status) {
			
           
		console.log (result);
		console.log(result.length)
		
		
		var re = JSON.parse(JSON.stringify(result))
		console.log("myJSON"+re);
		    for (var i = 0; i < result.length; i++)
            {
	         // console.log("myJSON"+re.length);
	          
                html += "<div class='card' style='margin-top: 25px'>"
                        + "<div class='card-header' id='userfeed'>Featured</div>"
                        + "<div class='card-body'>"
                        + "<div class='profile-img'>"
                        + "<img id='profileImageUrl' src="+ re[i]['profileurl'] +"   class='rounded-circle' alt='logo'/>"
                        + "</div>"
                        + "<h5 class='card-title' id='fromUser'>" + re[i]['name'] + "</h5>"
                        + "<p class='card-text' id='tweet'>" + re[i]['latesttweet'] + "</p>"
                        + "<a href='#' class='btn btn-primary'>Go somewhere</a>"
                        + "</div>"
                        + "</div>";
                        

            }
            $('#UserfeedContainer').html(html);


	})



});



function fetchTweets1() {
	//alert("ll");
	
	$.post("/timeline", { }, function(result, status) {

		console.log("result" + result);
		console.log(JSON.parse(JSON.stringify(result)))
		var re = JSON.parse(JSON.stringify(result))

		  var html = "";
		
		   for (var i = 0; i < re.length; i++)
          {
	     //  alert("hhhhhhh");
                html += "<div class='card' style='margin-top: 25px'>"
                        + "<div class='card-header' id='userfeed'>Featured</div>"
                       + "<div class='card-body'>"
                       + "<div class='profile-img'>"
                        + "<img id='profileImageUrl' src="+ re[i]['imageurl'] +"   class='rounded-circle' alt='logo'/>"
                        + "</div>"
                        + "<h5 class='card-title' id='fromUser'>" + re[i]['username'] + "</h5>"
                        + "<p class='card-text' id='tweet'>" + re[i]['text'] + "</p>"
                       + "<a href='#' class='btn btn-primary'>Go somewhere</a>"
                       + "</div>"
                       + "</div>";

       //        var accountName= re[i]['fromUser'];
       //        var image= re[i]['profileImageUrl'];
      //         var tweet= re[i]['text'];

       //       $.post("/savetweets", {name:accountName,profimg:image,tweets:tweet}, function(result, status) {
	
               

          //    })
                        

            }
            $('#UserfeedContainer').append(html);
		
		
		
		


	})
	
	
	
	}



function fetchTweets() {
	
	$.post("/timeline", { }, function(result, status) {

		console.log("result" + result);
		console.log(JSON.parse(JSON.stringify(result)))
		var re = JSON.parse(JSON.stringify(result))

		  var html = "";
		
		    for (var i = 0; i < re.length; i++)
            {
                html += "<div class='card' style='margin-top: 25px'>"
                        + "<div class='card-header' id='userfeed'>Featured</div>"
                        + "<div class='card-body'>"
                        + "<div class='profile-img'>"
                        + "<img id='profileImageUrl' src="+ re[i]['profileImageUrl'] +"   class='rounded-circle' alt='logo'/>"
                        + "</div>"
                        + "<h5 class='card-title' id='fromUser'>" + re[i]['fromUser'] + "</h5>"
                        + "<p class='card-text' id='tweet'>" + re[i]['text'] + "</p>"
                        + "<a href='#' class='btn btn-primary'>Go somewhere</a>"
                        + "</div>"
                        + "</div>";
                        

            }
            $('#UserfeedContainer').append(html);
		
		
		
		


	})
	
	
	
	}


});