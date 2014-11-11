/**
 * @name: errorList
 * @description: errorList is a array that is filled with the ErrorClass object instances 
 * that are in error. it is declared as a global variable.
 */
var errorList = null;

/**
 * @author pversai
 * @classDescription This Class Contains the Form field with it's label and error message. It also contains the validation function and validate.
 */
var ErrorClass = function(){}
ErrorClass.prototype = {
	field:null,
	label:"",
	message:"",
	validationFunction:null,
	validate:function(){
		if (this.validationFunction != null){
			return this.validationFunction.call(this);
		}else{
			return true;
		}
	}
}
/**
 * @param {Object} form
 */
var FieldListManager = {
	fieldList:null,
	collectFormFields:function(form){
		if (form.elements){
			for( var i = 0; i < form.elements.length; i ++){
				if (form.elements[i].tagName == "INPUT" || 
					form.elements[i].tagName == "SELECT" || 
					form.elements[i].tagName == "TEXTAREA"){
					if (form.elements[i].type != "hidden"){
						if (form.elements[i].type == "radio"){
							if (this.firstIndexByFieldName(form.elements[i].name) < 0){
								var element = new ErrorClass();
								element.field = form[form.elements[i].name];
								element.field.name = form.elements[i].name;
								element.field.type = "radio";
								this.fieldList.push(element);
							}
						}else{
							var element = new ErrorClass();
							element.field = form.elements[i];
							this.fieldList.push(element);
						}
					}
				}
			}
		}
	},
	setDefaultProperties:function(defaultPropertiesListObj){
		for (var i = 0; i< this.fieldList.length; i++){
			var propertiesListObj = defaultPropertiesListObj[this.fieldList[i].field.name];
			if (propertiesListObj){
				this.fieldList[i].label = propertiesListObj[0];
				this.fieldList[i].message = propertiesListObj[1];
				this.fieldList[i].validationFunction = propertiesListObj[2];
			}
		}
	},
	setCustomPropertiesByFieldName:function(name, label, msg, validationFunction){
		var index = this.firstIndexByFieldName(name);
		if (index > 0){
			this.fieldList[index].label = label;
			this.fieldList[index].message = msg;
			this.fieldList[index].validationFunction = validateFunction;
		}
	},
	firstIndexByFieldName:function(name){
		var i = 0;
		while ((i < this.fieldList.length) && (this.fieldList[i].field.name != name)){
			i++;
		}
		if (i==this.fieldList.length){
			return -1;
		}else{
			return i;
		}
	},
	createErrorList:function(){
		var errorList = new Array();
		for (var i=0;i<this.fieldList.length;i++){
			if(!this.fieldList[i].validate()){
				errorList.push(this.fieldList[i]);
			}
		}
		return errorList;
	},
	createFieldList:function(form){
		this.fieldList = new Array();
		this.collectFormFields(form);
	}
}

/**
 * 
 */
var defaultFormFieldValidation = {
	validateInput:function(){
        if((this.field.value==null)|| (Trim(this.field.value)=="") || (this.field.value==this.label)){
        	
        return false;
        }
        else {
			if (!isValidChar(this.field.value)){
                this.message = "Only valid characters are accepted in this " + this.label + " field.";
				return false;
			} 
		}
		return true;
	},
	validateSelect:function(){
		if(this.field.selectedIndex < 1){
		    return false;
		}
		return true;
	},
	validateRadioArray:function(){
		for (var i=0; i<this.field.length; i++){
			if(this.field[i].checked == true){
				return true;
			}
		}
		return false;
	},
	validatePostalCode:function(){
        if((this.field.value==null)|| (Trim(this.field.value)=="") || (this.field.value==this.label)){
			return false;
	    } else {
			if (!isValidChar(this.field.value)){
				return false;
			} 
			if(!defaultFormFieldValidation.isValidZipCodeFormat(this.field.value)){
		        this.message = "The zip code you entered is not valid. Please enter a valid zip code.";
				return false;
	    	}
		}
		return true;
	},
	
	validateEmailAddress:function(){
        if((this.field.value==null)|| (Trim(this.field.value)=="") || (this.field.value==this.label)){
			return false;
	    } else {
			if (!isValidChar(this.field.value)){
				return false;
			} 
			if(!defaultFormFieldValidation.isValidEmailAddressFormat(this.field.value)){
		        this.message = "The email address you entered is not valid. Please enter a valid, correctly-formatted email address.";
				return false;
	    	}
		}
		return true;
	},
    validateConfEmailAddress:function(){
            if((this.field.value==null)|| (Trim(this.field.value)=="") || (this.field.value==this.label)){
                        return false;
            } else {
                if (this.field.value!=this.field.form["bill_email"].value){
                    return false;
                } 
            }
            return true;
    },
	validateCCType:function(){
		if (defaultFormFieldValidation.isPaymentOptionValid() != false){
			if (this.field.selectedIndex < 1)
				return false;
		} else if(defaultFormFieldValidation.isPaymentOptionValid() == false){
			if (defaultFormFieldValidation.getPaymentOptionType() == "CreditTypeOrder") {
				this.message = "Please choose your payment method.";
				if (this.field.selectedIndex < 1) 
					return false;
			}
		}
		return true;
	},
	validateCCName:function(){
		if (defaultFormFieldValidation.isPaymentOptionValid() != false){
            if ((this.field.value==null)|| (Trim(this.field.value)=="") || (this.field.value==this.label)){
				return false;
			}else{
				if (!isValidChar(this.field.value)) {
					return false;
				}
			}
		}
		return true;
	},
	validateCCNumber:function(){
		if (defaultFormFieldValidation.isPaymentOptionValid() != false){
			return defaultFormFieldValidation.isValidCCNumber(this.field.value);
		}
		return true;
	},
	validateCCDate:function(){
		var index = FieldListManager.firstIndexByFieldName("cc_exp_yr");
		var year = FieldListManager.fieldList[index].field;
		if (defaultFormFieldValidation.isPaymentOptionValid() != false){
			if (!defaultFormFieldValidation.isValidDate(defaultFormFieldValidation.createDate(("20"+year.value), (this.field.value-1)))){
				return false;
		    }
		}
		return true;
	},
	isValidZipCodeFormat:function(number){
		if(defaultFormFieldValidation.isValidZipCodeFormatLong(number) || defaultFormFieldValidation.isValidZipCodeFormatShort(number)) {
	        return true;
	    }
	    return false;
	},
	isValidZipCodeFormatShort:function(number) {
		var regEx = /^[0-9]{5}$/
		if (number.match(regEx)){
			return true;
		}
		return false;
	},
	isValidZipCodeFormatLong:function(number) {
		var regEx = /^[0-9]{5}[-][0-9]{4}$/
		if (number.match(regEx)){
			return true;
		}
	    return false;
	},
	isValidPostalCodeFormat:function(number) {
		var regEx = /^[a-zA-Z][0-9][a-zA-Z][ -]?[0-9][a-zA-Z][0-9]$/
		if (number.match(regEx)){
			return true;
		}
	    return false;
	},
	isValidEmailAddressFormat:function(email){
        var myregexp = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+[.][a-zA-Z][a-zA-Z]+$/
		if (email.match(myregexp)){
			return true;
		}
		return false;
	},
	isValidCCNumber:function(number){
		if(number.match(/^[0-9]+$/)){
			return true;
		} else {
			return false;
		}
	},
	isValidDate:function(date){
		var today = new Date();
		if (date>today){
			return true;
		}else{
			return false;
		}
	},
	// Returns the kind of payment option
	getPaymentOptionType:function(){
		var creditOrderIndex = FieldListManager.firstIndexByFieldName("credit_order");
		if (creditOrderIndex >= 0) {
			return "PaymentRadioOrder";
		}
		var creditType = FieldListManager.fieldList[FieldListManager.firstIndexByFieldName("cc_type")].field;
		var isCreditOption = false;
		for (var i=0; i<creditType.options.length;i++){
			if (creditType.options[i].value=="0"){
				isCreditOption = true;
				break;
			}
		}
		if (isCreditOption){
			return "CreditTypeOrder";
		}
		return null;
	},
	isPaymentOptionValid:function(){
		if (defaultFormFieldValidation.getPaymentOptionType() == "PaymentRadioOrder"){
			var credit = FieldListManager.fieldList[FieldListManager.firstIndexByFieldName("credit_order")].field;
			if (credit[0].checked == true){
				return true;
			}
			return false;
		} else if (defaultFormFieldValidation.getPaymentOptionType() == "CreditTypeOrder"){
			var creditType = FieldListManager.fieldList[FieldListManager.firstIndexByFieldName("cc_type")].field;
			var value = creditType.options[creditType.selectedIndex].value;
			if (value == "0" || value == "") {
				return false;
			}
			else {
				return true;
			}
		} else {
			return null;
		}
	},
	createDate:function(year, month){
		var date = new Date();
		date.setFullYear(year,month,01);
		return date;
	}
}
/**
 * 
 */
var validationFields = {
	advocateFirstName:new Array("First Name", "Please enter your first name.",defaultFormFieldValidation.validateInput),
	advocateLastName:new Array("Last Name", "Please enter your last name.",defaultFormFieldValidation.validateInput),
	firstName:new Array("First Name", "Please enter your friend first name.",defaultFormFieldValidation.validateInput),
	lastName:new Array("Last Name", "Please enter your friend last name.",defaultFormFieldValidation.validateInput),
	emailAddress:new Array("Email Address", "Please enter your friend email address.",defaultFormFieldValidation.validateEmailAddress),
	recipiantFirstName:new Array("First Name", "Please enter your first name.",defaultFormFieldValidation.validateInput),
	recipiantLastName:new Array("Last Name", "Please enter your last name.",defaultFormFieldValidation.validateInput),
	recipiantEmailAddress:new Array("Email Address", "Please enter your email address.",defaultFormFieldValidation.validateEmailAddress),
	state:new Array("State", "Please select your state.",defaultFormFieldValidation.validateSelect),
	zip:new Array("Zip Code", "Please enter your zip code.",defaultFormFieldValidation.validatePostalCode),
	advocateEmailAddress:new Array("Email Address", "Please enter your email address.",defaultFormFieldValidation.validateEmailAddress),
    setField:function(fieldName, fieldLabel, errorMsg, validationFunction){
		var label = fieldLabel || "";
		var msg = errorMsg || "";
		this[fieldName] = new Array(label, msg, validationFunction);
	},
	setFieldByArray:function(fieldsArray){
		for (var i=0; i<fieldsArray.length(); i++){
			this.setField(fieldsArray[0],fieldsArray[1],fieldsArray[2],fieldsArray[3]);
		}
	}
}
/**
 * 
 * @param {Object} form
 */

function ValidateForm(form){
	clearErrors();
	FieldListManager.createFieldList(form);
	FieldListManager.setDefaultProperties(validationFields);
	errorList = FieldListManager.createErrorList();	
	if(errorList.length > 0){
		displayAlertMessage(errorList);	
		return false;
	}

	return true;
}

/**
 * 
 * @param {Object} errorList
 */
function displayAlertMessage(errorList){
	var msg = "Oops! \n\nWe have detected one or more errors on this form. Please take the time to correct them." +
	"\n\n";
	for (var i = 0; i<errorList.length; i++){
		msg += " - " + errorList[i].message + "\n";
		if (errorList[i].field.name=="cc_exp_mo"){
			FieldListManager.fieldList[FieldListManager.firstIndexByFieldName("cc_exp_yr")].field.className += " error";
			errorList[i].field.className += " error";
			errorList[i].field.tabIndex = i+1;
		}else if (errorList[i].field.type == "radio"){
			for (var j=0; j<errorList[i].field.length;j++){
				if (errorList[i].field[j].type == "radio") {
					errorList[i].field[j].parentNode.className += " error"
					errorList[i].field[j].tabIndex = i+1;
				}
			}
		}else{
			errorList[i].field.className += " error";
			errorList[i].field.tabIndex = i+1;
		}
	}
	if (errorList[0].field.type=="radio"){
		errorList[0].field[0].focus();
	}else{
		errorList[0].field.focus();
	}
	alert(msg);
}

function clearErrors(){
	if (errorList != null){
		for (var i = 0; i<errorList.length; i++){
			if (errorList[i].field.type=="radio"){
				for(var j=0;j<errorList[i].field.length;j++){
					if (errorList[i].field[j].type == "radio") {
						errorList[i].field[j].parentNode.className="";
						errorList[i].field[j].tabIndex=0;
					}
				}				
			}else if (errorList[i].field.name=="cc_exp_mo"){
				errorList[i].field.className="";
				errorList[i].field.tabIndex=0;
				document.getElementById("cc_exp_yr_field").className="";
			}else{
				errorList[i].field.className="";
				errorList[i].field.tabIndex=0;
			}
		}
		errorList = null;
	}
}

function disableButtons(form){
    if (typeof(form) == "undefined"){
        form = document;
    }
	var messageNode = document.createTextNode("Please wait while we process your order...");
    var inputs = form.getElementsByTagName("INPUT");
    if(document.getElementById("pleaseWait")){
        messageNode = document.getElementById("pleaseWait");
	}
	for (var i=0; i<inputs.length; i++){
		if(inputs[i].type == "image" || inputs[i].type == "submit"){
			inputs[i].parentNode.style.clear = "both";
            inputs[i].style.display = "none";
            inputs[i].parentNode.insertBefore(messageNode,inputs[i]);
			if (messageNode.style){
				messageNode.style.display = "inline";
			}
		}
	}
}

function isValidChar(value){
    value = value.toUpperCase();

	var invalidRegExList = new Array();

	invalidRegExList.push(/DECLARE \(/); //DECLARE
	invalidRegExList.push(/CHAR\(/); //CHAR(
	invalidRegExList.push(/CAST\(/); //CAST(
	invalidRegExList.push(/EXEC\(/); //EXEC(
	invalidRegExList.push(/DROP \(/); //DROP
	invalidRegExList.push(/SELECT \(/); //SELECT

	for (var i=0; i<invalidRegExList.length;i++){
		if(value.search(invalidRegExList[i])!= -1){
			return false;
		}
	}
	return true;
}

//Trims spaces left and right of a string
function Trim(str){
    str = str.replace(/^[ \t\n\r\f\v]*/,'');
    str = str.replace(/[ \t\n\r\f\v]*$/,'');
    return str;
}