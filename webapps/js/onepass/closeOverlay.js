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

    jQuery('#close').bind('click', function(event) {
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

    		
});