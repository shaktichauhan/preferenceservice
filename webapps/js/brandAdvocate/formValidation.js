function validateform(){
	
	
	var errMsg1 = "Oops! \n\nWe have detected one or more errors on this form. Please take the time to correct them. \n";
	
	
	//Validate for first set of form
	
	var errFlag = false;
	errFlag = validateFormBlock(document.getElementById('firstName1').value, document.getElementById('lastName1').value, document.getElementById('emailAddress1').value,"m");
	if(!errFlag) {
		errFlag = validateFormBlock(document.getElementById('firstName2').value, document.getElementById('lastName2').value, document.getElementById('emailAddress2').value,"o");
	}
	if(!errFlag) {
		errFlag = validateFormBlock(document.getElementById('firstName3').value, document.getElementById('lastName3').value, document.getElementById('emailAddress3').value,"o");
	}
	
if(errFlag){
	return false;
	
}
	//validateFormBlock(document.getElementById('advocateFirstName').value, document.getElementById('advocateLastName').value, document.getElementById('advocateEmailAddress').value,"m");
	
	var firstFriendemail =document.getElementById('emailAddress1').value;
	var secondFriendemail =document.getElementById('emailAddress2').value;
	var thirdFriendemail =document.getElementById('emailAddress3').value;
	var email =document.getElementById('advocateEmailAddress').value;
	
	
	var sameEmailFlag = false;
	if(firstFriendemail!="" && secondFriendemail!="" && firstFriendemail==secondFriendemail) sameEmailFlag = true;
	if(firstFriendemail!="" && thirdFriendemail!="" && firstFriendemail==thirdFriendemail) sameEmailFlag = true;
	if(firstFriendemail!="" && email!="" && firstFriendemail==email) sameEmailFlag = true;
	
	if(thirdFriendemail!="" && secondFriendemail!="" && thirdFriendemail==secondFriendemail) sameEmailFlag = true;
	if(secondFriendemail!="" && email!="" && secondFriendemail==email) sameEmailFlag = true;
	
	if(thirdFriendemail!="" && email!="" && thirdFriendemail==email) sameEmailFlag = true;
	
     
    //if((firstFriendemail==secondFriendemail || firstFriendemail==thirdFriendemail || firstFriendemail==email) || (secondFriendemail==thirdFriendemail || secondFriendemail==email) || (thirdFriendemail==email))
    //if((firstFriendemail==secondFriendemail)||(secondFriendemail==thirdFriendemail)||(email==thirdFriendemail))
	if(sameEmailFlag)
	{
    	alert(errMsg1+"You are using same email more than once");
    	return false;
    }
	return true;
}


function validateFormBlock(fname, lname, email, form_type){
	var errMsg = "Oops! \n\nWe have detected one or more errors on this form. Please take the time to correct them. \n";
	var errFlag = false;
	if(form_type=="o") {
		
		if(fname!="") {
			if(lname=="") {
				errMsg = errMsg + "\n - Please enter your friend last Name";
				errFlag = true;
			}
			if(email=="" || (!isValidEmailAddressFormat(email))) {
				errMsg = errMsg + "\n - Please enter your friend email Address";
				errFlag = true;
			}
		}	
		
	}
	else if(form_type=="m"){
		if(fname=="") {
			errMsg = errMsg + "\n - Please enter your friend first Name";
			errFlag = true;
		}
		if(lname=="") {
			errMsg = errMsg + "\n - Please enter your friend last Name";
			errFlag = true;
		}
		if(email=="" || (!isValidEmailAddressFormat(email))) {
			errMsg = errMsg + "\n - Please enter your friend email Address";
			errFlag = true;
		}
	}
	
	//Main user
	if((document.getElementById('advocateFirstName').value ==null)|| (Trim(document.getElementById('advocateFirstName').value )=="") ){
		errFlag = true;
    	errMsg = errMsg + "\n - Please enter your first name.";
    	
    }
    if((document.getElementById('advocateLastName').value ==null)|| (Trim(document.getElementById('advocateLastName').value )=="") ){
    	errFlag = true;
    	errMsg = errMsg + "\n - Please enter your last name.";
    	
    }
    if ((document.getElementById('advocateEmailAddress').value ==null)|| (Trim(document.getElementById('advocateEmailAddress').value )==""))
	{
    	errFlag = true;
	errMsg = errMsg + "\n - Please enter your email address.";
	
	}
    else if (!isValidEmailAddressFormat(document.getElementById('advocateEmailAddress').value)){
    	errFlag = true;
    	errMsg = errMsg + "\n -  The email address you entered is not valid. Please enter a valid, correctly-formatted email address.";
    	
    }
	
	if(errFlag) 
		alert(errMsg);
	return errFlag;
}


//Trims spaces left and right of a string
function Trim(str){
  str = str.replace(/^[ \t\n\r\f\v]*/,'');
  str = str.replace(/[ \t\n\r\f\v]*$/,'');
  return str;
}

function isValidEmailAddressFormat(email){
    var myregexp = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+[.][a-zA-Z][a-zA-Z]+$/
	if (email.match(myregexp)){
		return true;
	}
	return false;
}