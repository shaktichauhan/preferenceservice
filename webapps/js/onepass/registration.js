/*global jQuery, adobeExists, adobe */ /* for jslint */
jQuery(function(){

    try {
        // hide the loading overlay we are showing on iPhone
        $('#overlay-bg').css('top', window.pageYOffset);
        $('.overlay').css('top', window.pageYOffset).fadeOut();
    } catch(e){}

    jQuery("label").inFieldLabels({
        fadeOpacity: 0.0,
        fadeDuration: 100
    });

    jQuery('#cancel').bind('click', function(event) {
        // Close Webview
        event.preventDefault();
        if (adobeExists()){ adobe.dps.store.dismissCustomDialog();}
    });

    jQuery('form').bind('keypress', function(event) {
        var code = event.keyCode || event.which;
        if (code === 13) {
            jQuery('form').submit();
        }
    });

    jQuery('form').submit(function(event) {
        // Validate and submit the form
        var errorsFound = [], i;
        if (jQuery('.errorBox').length <= 0) {
            jQuery('#errors').append('<ul class="errorBox"></ul>');
        }
        jQuery('.errorBox').children().remove();

        if (jQuery('#loginform').length > 0) {
            // existing user form

            if (document.getElementById('email').value === "" ||  document.getElementById('password').value === "") {
                // Empty fields
                errorsFound.push('Please fill out all fields');

            } else if (testPattern(jQuery('#email').val(),"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])") === false ) {
                // Validate email 
                errorsFound.push('Not a valid email.  Please confirm you have entered your email correctly');
            }

        } else {
            // new user form

            if (document.getElementById('email').value === "" || document.getElementById('emailConfirm').value === "" || document.getElementById('password').value === "" || document.getElementById('passwordConfirm').value === "") {
                // Are there any empty fields?
                errorsFound.push('Please fill out all fields');

            } else {
            	if (testPattern(jQuery('#email').val(),"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])") === false ) {
                    // Validate email 
                    errorsFound.push('Not a valid email.  Please confirm you have entered your email correctly');
                } else {
                	if ((document.getElementById('email').value.toLowerCase() === document.getElementById('emailConfirm').value.toLowerCase()) === false) {
                    // Do emails match?
                		errorsFound.push('Email Address and Confirm Email Address must match');
                	}

	                if ((document.getElementById('password').value === document.getElementById('passwordConfirm').value) === false) {
	                    // Do passwords match?
	                    errorsFound.push('Password and Confirm Password must match');
	                }
                }
             
            }
            
             
            
        }

        if (errorsFound.length > 0) {
            event.preventDefault();

            for (i=0; i<errorsFound.length; i++) {
                jQuery('.errorBox').append('<li>' + errorsFound[i] + '</li>');
            }
            return false;

        } else {
            
        	return testEmailRegistration(jQuery('#email').val());
        	

        }
     });
    
    var testPattern = function(value, pattern) {   // Private Method

        var regExp = new RegExp(pattern,"");
        return regExp.test(value);
    }
    
        
    var testEmailRegistration = function(value) {
    	alert('shakti111');
    	$.ajax({
			url: 'http://test.services.rd.com/preference/EmailRegistrationValidation',
			data: 'emailAddress='+ value,
			type: 'post',
			async:'false',
			success: function(msg){
				console.log("messa >>>>> " + msg);
				if(msg != 'ERROR') // Message Sent, check and redirect
				{                // and direct to the success page
		            // No errors?  Success!
		            jQuery(this).find('#submit').parent().addClass('inprogress');
		            return true;
				} else {
					jQuery('.errorBox').append('<li> Email Address is already registered. </li>');
					return false;
				}
			 }
			});		
    	}
			
			
});