var interval;
$(function() {
    $("#start").click(function() {
         interval = setInterval(function() {
            $.ajax({
                url: "/ServerController.do",
                method: "post",
                async: true,
                success: function(data) {
                    console.log("server Program started");
                },
                error: function() {
                    console.log("Error occurred");
                }
            });
        }, 6000);
    });
	$("#end").click(function() {
        console.log("server Program stopped");
        clearInterval(interval);
       window.open('about:blank', '_self').close();
    });
});


