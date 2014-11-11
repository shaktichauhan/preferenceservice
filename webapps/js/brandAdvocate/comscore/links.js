jQuery(document).ready(function() {
	jQuery('a,area').filter(function () {
		 return !this.href.match(/^mailto\:/) 
				&& (this.hostname != location.hostname); 
	 }).addClass('exitLink').attr('target','_blank');
	jQuery("a,area").each(function( index ) {
		if(jQuery(this).hasClass("social")){
			jQuery(this).removeClass('exitLink');
		}
		jQuery(this).click(function() {
			if(jQuery(this).hasClass("exitLink")){
				udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&exit_link_event=true');
			}
			if(jQuery(this).hasClass("social")){
				udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&social_share_event=true');
			}
		});
	});
});