"use strict";

(function() {
	console.log('heremememsme');
	// the API end point, rember that this stuff is in the js terminal 
	var urll = "invalidlogin";

	$.ajax(
            {
               type: "GET",
            url: "invalidlogin",
            contentType: "application/json; charset=utf-8",
            success: function (result) { 
				 console.log(result);
				 if(result == "valid") {
					 $("#ercheck").hide();
				 }
				 else {
					 $("#ercheck").show();
				 }
				 
														}

				 		 
											}
								
					
        )
    
    console.log('done'); 
    
    
})();