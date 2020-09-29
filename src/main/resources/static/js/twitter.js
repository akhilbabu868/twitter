$(document).ready(function() {

	fetchTweets();
	

// FUNCTION FOR SERACHING KEYWORDS
	$("#serach").on('click', function(e) {
		var html = "";
		var key = $("#serachtext").val();
		$.post("/tweets", { keyword: key }, function(result, status) {
			var result = JSON.parse(JSON.stringify(result))

			for (var i = 0; i < result.length; i++) {
		
				html += "<div class='card' style='margin-top: 25px'>"
					+ "<div class='card-header' id='userfeed'>Featured</div>"
					+ "<div class='card-body'>"
					+ "<div class='profile-img'>"
					+ "<img id='profileImageUrl' src=" + result[i]['profileurl'] + "   class='rounded-circle' alt='logo'/>"
					+ "</div>"
					+ "<h5 class='card-title' id='fromUser'>" + result[i]['name'] + "</h5>"
					+ "<p class='card-text' id='tweet'>" + result[i]['latesttweet'] + "</p>"
					+ "</div>"
					+ "</div>";
			}
			$('#UserfeedContainer').html(html);


		})



	});



// FUNCTION FOR FETCHING FOLLOWERS TWEETS ON WHEN APPLICATION  LOAD

	function fetchTweets() {

		$.post("/timeline", {}, function(result, status) {
			
			var re = JSON.parse(JSON.stringify(result))
			var html = "";

			for (var i = 0; i < re.length; i++) {
				html += "<div class='card' style='margin-top: 25px'>"
					+ "<div class='card-header' id='userfeed'>Featured</div>"
					+ "<div class='card-body'>"
					+ "<div class='profile-img'>"
					+ "<img id='profileImageUrl' src=" + re[i]['imageurl'] + "   class='rounded-circle' alt='logo'/>"
					+ "</div>"
					+ "<h5 class='card-title' id='fromUser'>" + re[i]['username'] + "</h5>"
					+ "<p class='card-text' id='tweet'>" + re[i]['text'] + "</p>"
					+ "</div>"
					+ "</div>";
			}
			$('#UserfeedContainer').append(html);
		})
	}






});