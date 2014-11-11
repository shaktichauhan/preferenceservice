<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta name="viewport" content="width=device-width">
 <meta charset="utf-8" />

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,700italic,800,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/brandAdvocate/style.css">

 <title>Reader's Digest</title>
 
 <script src="js/brandAdvocate/jquery.js"></script> 
 <script src="js/brandAdvocate/jquery.form.js"></script> 
 <% 
	 	String trkid = request.getParameter("trkid") == null ? "":request.getParameter("trkid");
	%>
   <script> 
		$(document).ready(function() { 
			var options = { 
					beforeSubmit:  showRequest  // pre-submit callback 
				
			}; 
	     
			$('#frmS').ajaxForm(options); 
	
		}); 
	
		function showRequest(formData, jqForm, options) { 
			var radioList = document.getElementsByName('input_706880817_10_0_0');
			var otherRad = document.getElementById('input_706880817_10_8099863539_0');
			var textAr = document.getElementById('other_706880817_8099863539');
			
			var submitFlag = false;
			
			for(var i=0; i<radioList.length; i++){
		        if(radioList[i].checked==true){
		        	if(radioList[i].value==otherRad.value) {
		        		if(textAr.value == "") {
		        			alert('Ooops! It looks like you forgot to fill in the text box.');
							textAr.focus();
							return false;
		        		} else {
		        			submitFlag = true;
		        		}
		        	} else {
		        		submitFlag = true;
		        	}
		            
		        }
		    }
	
			if( submitFlag == true) {
				setTimeout(function(){
							window.location.href ='confirmation.do?trkid=<%=trkid %>&token=<%= request.getParameter("token")%>';
				}, 1500);
	
				return true;
			} else {
				alert('Ooops! It looks like you forgot to make a selection.');
				return false; 
			}
			
		    
		} 

    </script> 
	
	
	
</head>

<body>
<script language="JavaScript" src="js/brandAdvocate/comscore/comscore_udm.js" type="text/javascript"></script><script language="javascript" type="text/javascript"><!--
var trkid='<%=trkid%>';
var campaign = '&ns_campaign='+trkid+'&campaign='+trkid;
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+surveypage&category=brandadvocate&content_name=brandadvocate%3a+surveypage&pv_event=true&content_type=brandadvocate'+campaign);
--></script>
<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+surveypage&category=brandadvocate&content_name=brandadvocate%3a+surveypage&pv_event=true&content_type=brandadvocate"+campaign height="1" width="1" alt="*"></p></noscript>
	<form name="frmS" method="post"
		action="https://www.surveymonkey.com/s.aspx?sm=XB1LAuBXEeA5sIvpbA34dg%3d%3d" id="frmS">
		<div>
			<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWDgL+raDpAgKq7M2aCgLL+IOiBwKg6PF5AqnO0tsHAveko7kIAvm3qN4FAouckuUIArDpqqQBAo3HvMQNAtCN/L0JApzRpLAOAsP2pbEKAtSemZcEs5lKc1Rb2DhjpuYC6hUvzCiqct8=" />
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="" />
		</div>

		<!--content area-->

		<div id="container">
			<div id="header">
					<img src="jsp/brandAdvocate/images/logo.png" />

				</div>
			<div id="left">
				<h1>THANKS FOR SHARING!</h1>
				<p>&nbsp;</p>
				<img src="jsp/brandAdvocate/images/ipad.png" class="ipad" />
				<p>
					We pride ourselves in bringing you the very best in every issue of
					<em>Reader's Digest</em>, and we're thrilled that readers like you
					help spread the word.
				</p>
				<p>Your gift recipient(s) will receive an email announcement
					shortly.</p>
				<p>&nbsp;</p>
			</div>
			
			<div id="right">
				<h3>Want to send EVEN MORE free issues?</h3>
				<p>
					Tell us why you shared<em> Reader's Digest</em> and you'll get a
					special link for 10 friends to download a Free Issue.
					<h3>What made you want to share Reader's Digest?</h3>
					<p>
						<div class="number">
							<label for="checkbox"></label> 
							<input type="radio" id="input_706880817_10_8099861332_0"
												name="input_706880817_10_0_0" value="8099861332_0" />
						</div>
						<div class="friend">
							<p>
								The real-life dramas keep me on the edge of my seat!<br />
							</p>
						</div>

						<div class="number">
							<input type="radio" id="input_706880817_10_8099861333_0"
												name="input_706880817_10_0_0" value="8099861333_0" /> <label
								for="checkbox"></label>
						</div>
						<div class="friend">
							<p>
								I enjoy reading happy, inspiring stories.<br />
							</p>
						</div>

						<div class="number">
							<input type="radio" id="input_706880817_10_8099861334_0"
												name="input_706880817_10_0_0" value="8099861334_0" /> <label
								for="checkbox"></label>
						</div>
						<div class="friend">
							<p>
								I love the jokes and humor stories.<br />
							</p>
						</div>

						<div class="number">
							<input type="radio" name="input_706880817_10_0_0" value="8099863538_0" /><label
												id="input_706880817_10_8099863538_0" /> <label
								for="checkbox"></label>
						</div>
						<div class="friend">
							<p>
								It was free. <br />
							</p>
						</div>

						<div class="number">
							<input type="radio" id="input_706880817_10_8099863539_0"
												name="input_706880817_10_0_0" value="8099863539_11" /> <label
								for="checkbox"></label>
						</div>
						<div class="friend">
							<p>
								Other (Please tell us below)<br />
							</p>
						</div>

						<div class="number">
							<label for="checkbox"></label>
						</div>
						<div class="friend">
							<p>
								<label for="textarea"></label>
								<textarea id="other_706880817_8099863539"
											name="other_706880817_8099863539"
											title="Other (Tell us below)" rows="4" cols="50"></textarea>
								<br />
							</p>
						</div>
					<button type="submit" name="NextButton" value="Done"
						id="NextButton">
   							 <img src="jsp/brandAdvocate/images/btn2.png" alt="submit" >
					</button>
					</div>
		</div>

				
<input type="hidden" name="hid_smC0l1d" id="hid_smC0l1d" value="dTQhp_2fAKbtJXCZA7JT5CKg_3d_3d" />
<input type="hidden" name="hid_smRsL1d" id="hid_smRsL1d" />
<input type="hidden" name="hid_smRs1d" id="hid_smRs1d" value="E6uK1MhOcpBUysyKlC0vrg_3d_3d" />
<input type="hidden" name="hid_smCSV" id="hid_smCSV" />
<input type="hidden" name="hid_smS1d" id="hid_smS1d" value="eg783TJCxFPa5XtNlX9Qjg_3d_3d" />
<input type="hidden" name="hid_smM0D" id="hid_smM0D" value="E6uK1MhOcpBUysyKlC0vrg_3d_3d" />
<input type="hidden" name="hid_smV3Rsn" id="hid_smV3Rsn" value="4D_2ffGjLNp1kpVfY8S7qdJw_3d_3d" />
<input type="hidden" name="hid_smS3CT1d" id="hid_smS3CT1d" value="HPuBHM4hYBT207jrAdqfxg_3d_3d" />
<input type="hidden" name="hid_DC" id="hid_DC" value="_2bCb5bh97XbJIJOTyZa7BNRwmEl68tg3oU_2bIBI12N6T4AV4zWYJA3jwyqPyYk44ZS" />
<input type="hidden" name="Hidden_CollectorToken" id="Hidden_CollectorToken" />

<input type="hidden" name="Hidden_Simple" id="Hidden_Simple" />
<input type="hidden" name="hid_l04dez" id="hid_l04dez" value="0KhQvxWa7bTmmV_2bzKhg8oZ1U34AJJsM1saVNA33owcw_3d" />


	</form>
 <div class="footer">
    <p>*Free, 3-issue digital subscription can only be shared with non-subscribers of <em>Reader&rsquo;s Digest</em> magazine. </p>
    <p>Apple, the Apple logo, iPad, and iPhone are trademarks of Apple Inc., registered in the U.S. and other countries. App Store is a service mark of Apple Inc. Kindle and Kindle Fire are trademarks of Amazon.com, Inc. or its affiliates.</p>
    <img src="jsp/brandAdvocate/images/app-store.png" />
    <p>&copy; 2014 The Reader's Digest Association, Inc. All rights reserved.</p>
  </div>

<script type="text/javascript">
    /* <![CDATA[ */
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-56526-1']);
    _gaq.push(['_setDomainName', '.surveymonkey.com']);
    _gaq.push(['_addIgnoredRef', 'www.surveymonkey.com']);
    var gaq_id = '1';
    if (gaq_id != '1' && gaq_id != '0') {
        _gaq.push(['_setCustomVar', 4, 'Package Type', '0', 1]);
        _gaq.push(['_setCustomVar', 5, 'User ID', '1', 1]);
    }
    _gaq.push(['_setSessionCookieTimeout', 7200000]);
    _gaq.push(['_setCampaignCookieTimeout', 2592000000]);
    _gaq.push(['_trackPageview']);
    _gaq.push(['_trackPageLoadTime']);
    (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
    /* ]]> */
</script>

<script type="text/javascript">
/* <![CDATA[ */
function nes(e){e=(e)?e:event;var c=(e.which)?e.which:e.keyCode;return(c!=13);}var is=document.getElementsByTagName("input");for(var i=0;i<is.length;i++){var _i=is[i];if(_i.type=="text")_i.onkeypress=function(e){ return nes(e); };}
/* ]]> */
</script>


<!-- Begin comScore Inline Tag 1.1302.13 -->
<% if(request.getServerPort()==80) { //Is http %>
	<script type="text/javascript" language="JavaScript1.3" src="http://b.scorecardresearch.com/c2/16404798/cs.js"></script>
<% } else { //Is https %>
	<script type="text/javascript" language="JavaScript1.3" src="https://sb.scorecardresearch.com/c2/16404798/cs.js"></script>
<% } %>
<!-- End comScore Inline Tag -->
	<!-- 14  -->
</body>
</html>
