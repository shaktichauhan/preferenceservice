<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Set"%>
<%@ page import="com.readersdigest.onepass.db.EmailAddressOptStatus"%>
<%@ page import="com.readersdigest.onepass.util.StringUtils"%>

<html:html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reader's Digest</title>
<script type="text/javascript" src="js/onepass/countries.js"></script>


<link rel="STYLESHEET" type="text/css" href="css/onepass/onePassIpad.css" />

<%
		String sourceId = (String) request.getParameter("sourceId");

		if(sourceId == null || "".equals(sourceId.trim())) {
			sourceId = "769"; // default ipad Rd source id
		}
		
		String addressToggle = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "addressToggle");
		String customerName = (String) request.getParameter("customerName");
		String street1 = (String) request.getParameter("street1");
		String city = (String) request.getParameter("city");
		String state = (String) request.getParameter("state");
		String postalCode = (String) request.getParameter("postalCode");
		String emailAddress = (String) request.getParameter("emailAddress");
		String token = (String) request.getParameter("token");
		String country = (String) request.getParameter("country");
		String transactionCompleted = (String) request.getParameter("transactionCompleted") != null ? (String) request.getParameter("transactionCompleted") : "";

		if (country == null) {
			country = "";
		}
		String[] promotables = request.getParameterValues("promotable");
		String selectedPreferences = "";

		if("true".equalsIgnoreCase(transactionCompleted)) {
			customerName = "";
			street1 = "";
			city = "";
			state = "";
			postalCode = "";
			country = "";
			promotables = null;
			
		}
		if (promotables != null) {
			for (int i = 0; i < promotables.length; i++) {
				if (!"".equals(selectedPreferences.trim())) {
					selectedPreferences = selectedPreferences + ":";
				}
				selectedPreferences = selectedPreferences
						+ promotables[i];
			}
		}
%>


<script type="text/javascript">

function selectedPromotables(){
	var cbs = document.forms[0].elements["promotable"];
	var z = '<%=selectedPreferences%>';
	var n = z.split(":");
	for(var i=0; i<cbs.length; i++){
		for(var j=0; j<n.length; j++) {
			if(cbs[i].value == n[j]) {
				cbs[i].checked = true;
			}
		}
	}
		
}

function selectedState(){
	var x = document.getElementsByTagName('select')[1];
	for(var i=0; i<x.length; i++) {
		if(x[i].value == '<%=state%>') {
				x[i].selected = true;
			}
		}

	}

	function selectedCountry() {
		var x = document.getElementsByTagName('select')[0];
		var state_index = x.selectedIndex;
		if (state_index != 0) {
			print_state('state', state_index);
			selectedState();
		}

		selectedPromotables();
	}

	window.onunload = refreshParent;

	function refreshParent() {
		if (window.opener != null && window.opener != undefined) {
			alert('shakti');
			window.opener.location.reload();
		}
	}
</script>

</head>

<body onload='selectedCountry();'>

	<html:form action="completeRegistrationAction.do"
		styleId="onePassDigReg">
		
		<img src="image/readers-digest-logo.gif" width="220" height="102" border="0" />
		 <h3>COMPLETE ACCOUNT SET UP</h3>
		 
        <p>Complete your account info to stay up to date on current issues and much more.</p>

		<!-- Conditionally show errors -->
		<logic:messagesPresent message="false">
			<html:messages id="aMsg" message="false">
				<logic:present name="aMsg">
					<!-- Error -->
					<li class="errors"><bean:write name="aMsg" filter="false" /></li>

				</logic:present>
			</html:messages>
			<p></p>
		</logic:messagesPresent>
		<!-- /Conditionally show errors -->

		<html:hidden property="sourceId" value="<%=sourceId%>" />
		<html:hidden property="emailAddress" value="<%=emailAddress%>" />

		<!-- need to put the ipad source id -->
        <% if("true".equalsIgnoreCase(addressToggle)) {%>
			<fieldset>
			<ol>

				<li><label for=customerName>Name</label> <html:text
						property="customerName" maxlength="50" value="<%=customerName%>"></html:text></li>
			</ol>
			<!--  The values only for skiping the address validation.. thease will not update in DB.. -->
			<html:hidden property="country" value="country"></html:hidden>
			<html:hidden property="street1" value="street1"></html:hidden>
			<html:hidden property="city" value="city"></html:hidden>
			<html:hidden property="state" value="state"></html:hidden>
			<html:hidden property="postalCode" value="postalCode"></html:hidden>
			</fieldset>
		<% } else { %>
		<fieldset>

			<ol>
				<li><label for=country>Country/Region</label> <html:select
						onchange="print_state('state',this.selectedIndex);"
						property="country" value="<%=country%>">
						<html:option value="">Select Country/Region</html:option>
						<html:option value="US">UNITED STATES</html:option>
						<html:option value="CA">CANADA</html:option>
						<html:option value="AF">AFGHANISTAN</html:option>
						<html:option value="AL">ALBANIA</html:option>
						<html:option value="DZ">ALGERIA</html:option>
						<html:option value="AS">AMERICAN SAMOA</html:option>
						<html:option value="AD">ANDORRA</html:option>
						<html:option value="AO">ANGOLA</html:option>
						<html:option value="AI">ANGUILLA</html:option>
						<html:option value="AQ">ANTARCTICA</html:option>
						<html:option value="AG">ANTIGUA AND BARBUDA</html:option>
						<html:option value="AR">ARGENTINA</html:option>
						<html:option value="AM">ARMENIA</html:option>
						<html:option value="AW">ARUBA</html:option>
						<html:option value="AU">AUSTRALIA</html:option>
						<html:option value="AT">AUSTRIA</html:option>
						<html:option value="AZ">AZERBAIJAN</html:option>
						<html:option value="BS">BAHAMAS</html:option>
						<html:option value="BH">BAHRAIN</html:option>
						<html:option value="BD">BANGLADESH</html:option>
						<html:option value="BB">BARBADOS</html:option>
						<html:option value="BY">BELARUS</html:option>
						<html:option value="BE">BELGIUM</html:option>
						<html:option value="BZ">BELIZE</html:option>
						<html:option value="BJ">BENIN</html:option>
						<html:option value="BM">BERMUDA</html:option>
						<html:option value="BT">BHUTAN</html:option>
						<html:option value="BO">BOLIVIA</html:option>
						<html:option value="BA">BOSNIA AND HERZEGOVINA</html:option>
						<html:option value="BW">BOTSWANA</html:option>
						<html:option value="BV">BOUVET ISLAND</html:option>
						<html:option value="BR">BRAZIL</html:option>
						<html:option value="IO">BRITISH INDIAN OCEAN TERRITORY</html:option>
						<html:option value="BN">BRUNEI DARUSSALAM</html:option>
						<html:option value="BG">BULGARIA</html:option>
						<html:option value="BF">BURKINA FASO</html:option>
						<html:option value="BI">BURUNDI</html:option>
						<html:option value="KH">CAMBODIA</html:option>
						<html:option value="CM">CAMEROON</html:option>
						<html:option value="CV">CAPE VERDE</html:option>
						<html:option value="KY">CAYMAN ISLANDS</html:option>
						<html:option value="CF">CENTRAL AFRICAN REPUBLIC</html:option>
						<html:option value="TD">CHAD</html:option>
						<html:option value="CL">CHILE</html:option>
						<html:option value="CN">CHINA</html:option>
						<html:option value="CX">CHRISTMAS ISLAND</html:option>
						<html:option value="CC">COCOS (KEELING) ISLANDS</html:option>
						<html:option value="CO">COLOMBIA</html:option>
						<html:option value="KM">COMOROS</html:option>
						<html:option value="CG">CONGO</html:option>
						<html:option value="CD">CONGO, THE DEMOCRATIC REPUBLIC OF THE</html:option>
						<html:option value="CK">COOK ISLANDS</html:option>
						<html:option value="CR">COSTA RICA</html:option>
						<html:option value="CI">CÔTE D'IVOIRE</html:option>
						<html:option value="HR">CROATIA</html:option>
						<html:option value="CU">CUBA</html:option>
						<html:option value="CY">CYPRUS</html:option>
						<html:option value="CZ">CZECH REPUBLIC</html:option>
						<html:option value="DK">DENMARK</html:option>
						<html:option value="DJ">DJIBOUTI</html:option>
						<html:option value="DM">DOMINICA</html:option>
						<html:option value="DO">DOMINICAN REPUBLIC</html:option>
						<html:option value="EC">ECUADOR</html:option>
						<html:option value="EG">EGYPT</html:option>
						<html:option value="SV">EL SALVADOR</html:option>
						<html:option value="GQ">EQUATORIAL GUINEA</html:option>
						<html:option value="ER">ERITREA</html:option>
						<html:option value="EE">ESTONIA</html:option>
						<html:option value="ET">ETHIOPIA</html:option>
						<html:option value="FK">FALKLAND ISLANDS (MALVINAS)</html:option>
						<html:option value="FO">FAROE ISLANDS</html:option>
						<html:option value="FJ">FIJI</html:option>
						<html:option value="FI">FINLAND</html:option>
						<html:option value="FR">FRANCE</html:option>
						<html:option value="GF">FRENCH GUIANA</html:option>
						<html:option value="PF">FRENCH POLYNESIA</html:option>
						<html:option value="TF">FRENCH SOUTHERN TERRITORIES</html:option>
						<html:option value="GA">GABON</html:option>
						<html:option value="GM">GAMBIA</html:option>
						<html:option value="GE">GEORGIA</html:option>
						<html:option value="DE">GERMANY</html:option>
						<html:option value="GH">GHANA</html:option>
						<html:option value="GI">GIBRALTAR</html:option>
						<html:option value="GR">GREECE</html:option>
						<html:option value="GL">GREENLAND</html:option>
						<html:option value="GD">GRENADA</html:option>
						<html:option value="GP">GUADELOUPE</html:option>
						<html:option value="GU">GUAM</html:option>
						<html:option value="GT">GUATEMALA</html:option>
						<html:option value="GN">GUINEA</html:option>
						<html:option value="GW">GUINEA-BISSAU</html:option>
						<html:option value="GY">GUYANA</html:option>
						<html:option value="HT">HAITI</html:option>
						<html:option value="HM">HEARD ISLAND AND MCDONALD ISLANDS</html:option>
						<html:option value="VA">HOLY SEE (VATICAN CITY STATE)</html:option>
						<html:option value="HN">HONDURAS</html:option>
						<html:option value="HK">HONG KONG</html:option>
						<html:option value="HU">HUNGARY</html:option>
						<html:option value="IS">ICELAND</html:option>
						<html:option value="IN">INDIA</html:option>
						<html:option value="ID">INDONESIA</html:option>
						<html:option value="IR">IRAN, ISLAMIC REPUBLIC OF</html:option>
						<html:option value="IQ">IRAQ</html:option>
						<html:option value="IE">IRELAND</html:option>
						<html:option value="IL">ISRAEL</html:option>
						<html:option value="IT">ITALY</html:option>
						<html:option value="JM">JAMAICA</html:option>
						<html:option value="JP">JAPAN</html:option>
						<html:option value="JO">JORDAN</html:option>
						<html:option value="KZ">KAZAKHSTAN</html:option>
						<html:option value="KE">KENYA</html:option>
						<html:option value="KI">KIRIBATI</html:option>
						<html:option value="KP">KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF</html:option>
						<html:option value="KR">KOREA, REPUBLIC OF</html:option>
						<html:option value="KW">KUWAIT</html:option>
						<html:option value="KG">KYRGYZSTAN</html:option>
						<html:option value="LA">LAO PEOPLE’S DEMOCRATIC REPUBLIC</html:option>
						<html:option value="LV">LATVIA</html:option>
						<html:option value="LB">LEBANON</html:option>
						<html:option value="LS">LESOTHO</html:option>
						<html:option value="LR">LIBERIA</html:option>
						<html:option value="LY">LIBYAN ARAB JAMAHIRIYA</html:option>
						<html:option value="LI">LIECHTENSTEIN</html:option>
						<html:option value="LT">LITHUANIA</html:option>
						<html:option value="LU">LUXEMBOURG</html:option>
						<html:option value="MO">MACAO</html:option>
						<html:option value="MK">MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF</html:option>
						<html:option value="MG">MADAGASCAR</html:option>
						<html:option value="MW">MALAWI</html:option>
						<html:option value="MY">MALAYSIA</html:option>
						<html:option value="MV">MALDIVES</html:option>
						<html:option value="ML">MALI</html:option>
						<html:option value="MT">MALTA</html:option>
						<html:option value="MH">MARSHALL ISLANDS</html:option>
						<html:option value="MQ">MARTINIQUE</html:option>
						<html:option value="MR">MAURITANIA</html:option>
						<html:option value="MU">MAURITIUS</html:option>
						<html:option value="YT">MAYOTTE</html:option>
						<html:option value="MX">MEXICO</html:option>
						<html:option value="FM">MICRONESIA, FEDERATED STATES OF</html:option>
						<html:option value="MD">MOLDOVA, REPUBLIC OF</html:option>
						<html:option value="MC">MONACO</html:option>
						<html:option value="MN">MONGOLIA</html:option>
						<html:option value="MS">MONTSERRAT</html:option>
						<html:option value="MA">MOROCCO</html:option>
						<html:option value="MZ">MOZAMBIQUE</html:option>
						<html:option value="MM">MYANMAR</html:option>
						<html:option value="NA">NAMIBIA</html:option>
						<html:option value="NR">NAURU</html:option>
						<html:option value="NP">NEPAL</html:option>
						<html:option value="NL">NETHERLANDS</html:option>
						<html:option value="AN">NETHERLANDS ANTILLES</html:option>
						<html:option value="NC">NEW CALEDONIA</html:option>
						<html:option value="NZ">NEW ZEALAND</html:option>
						<html:option value="NI">NICARAGUA</html:option>
						<html:option value="NE">NIGER</html:option>
						<html:option value="NG">NIGERIA</html:option>
						<html:option value="NU">NIUE</html:option>
						<html:option value="NF">NORFOLK ISLAND</html:option>
						<html:option value="MP">NORTHERN MARIANA ISLANDS</html:option>
						<html:option value="NO">NORWAY</html:option>
						<html:option value="OM">OMAN</html:option>
						<html:option value="PK">PAKISTAN</html:option>
						<html:option value="PW">PALAU</html:option>
						<html:option value="PS">PALESTINIAN TERRITORY, OCCUPIED</html:option>
						<html:option value="PA">PANAMA</html:option>
						<html:option value="PG">PAPUA NEW GUINEA</html:option>
						<html:option value="PY">PARAGUAY</html:option>
						<html:option value="PE">PERU</html:option>
						<html:option value="PH">PHILIPPINES</html:option>
						<html:option value="PN">PITCAIRN</html:option>
						<html:option value="PL">POLAND</html:option>
						<html:option value="PT">PORTUGAL</html:option>
						<html:option value="PR">PUERTO RICO</html:option>
						<html:option value="QA">QATAR</html:option>
						<html:option value="RE">RÉUNION</html:option>
						<html:option value="RO">ROMANIA</html:option>
						<html:option value="RU">RUSSIAN FEDERATION</html:option>
						<html:option value="RW">RWANDA</html:option>
						<html:option value="SH">SAINT HELENA</html:option>
						<html:option value="KN">SAINT KITTS AND NEVIS</html:option>
						<html:option value="LC">SAINT LUCIA</html:option>
						<html:option value="PM">SAINT PIERRE AND MIQUELON</html:option>
						<html:option value="VC">SAINT VINCENT AND THE GRENADINES</html:option>
						<html:option value="WS">SAMOA</html:option>
						<html:option value="SM">SAN MARINO</html:option>
						<html:option value="ST">SAO TOME AND PRINCIPE</html:option>
						<html:option value="SA">SAUDI ARABIA</html:option>
						<html:option value="SN">SENEGAL</html:option>
						<html:option value="CS">SERBIA AND MONTENEGRO</html:option>
						<html:option value="SC">SEYCHELLES</html:option>
						<html:option value="SL">SIERRA LEONE</html:option>
						<html:option value="SG">SINGAPORE</html:option>
						<html:option value="SK">SLOVAKIA</html:option>
						<html:option value="SI">SLOVENIA</html:option>
						<html:option value="SB">SOLOMON ISLANDS</html:option>
						<html:option value="SO">SOMALIA</html:option>
						<html:option value="ZA">SOUTH AFRICA</html:option>
						<html:option value="GS">SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS</html:option>
						<html:option value="ES">SPAIN</html:option>
						<html:option value="LK">SRI LANKA</html:option>
						<html:option value="SD">SUDAN</html:option>
						<html:option value="SR">SURINAME</html:option>
						<html:option value="SJ">SVALBARD AND JAN MAYEN</html:option>
						<html:option value="SZ">SWAZILAND</html:option>
						<html:option value="SE">SWEDEN</html:option>
						<html:option value="CH">SWITZERLAND</html:option>
						<html:option value="SY">SYRIAN ARAB REPUBLIC</html:option>
						<html:option value="TW">TAIWAN, PROVINCE OF CHINA</html:option>
						<html:option value="TJ">TAJIKISTAN</html:option>
						<html:option value="TZ">TANZANIA, UNITED REPUBLIC OF</html:option>
						<html:option value="TH">THAILAND</html:option>
						<html:option value="TL">TIMOR-LESTE</html:option>
						<html:option value="TG">TOGO</html:option>
						<html:option value="TK">TOKELAU</html:option>
						<html:option value="TO">TONGA</html:option>
						<html:option value="TT">TRINIDAD AND TOBAGO</html:option>
						<html:option value="TN">TUNISIA</html:option>
						<html:option value="TR">TURKEY</html:option>
						<html:option value="TM">TURKMENISTAN</html:option>
						<html:option value="TC">TURKS AND CAICOS ISLANDS</html:option>
						<html:option value="TV">TUVALU</html:option>
						<html:option value="UG">UGANDA</html:option>
						<html:option value="UA">UKRAINE</html:option>
						<html:option value="AE">UNITED ARAB EMIRATES</html:option>
						<html:option value="GB">UNITED KINGDOM</html:option>
						<html:option value="UM">UNITED STATES MINOR OUTLYING ISLANDS</html:option>
						<html:option value="UY">URUGUAY</html:option>
						<html:option value="UZ">UZBEKISTAN</html:option>
						<html:option value="VU">VANUATU</html:option>
						<html:option value="VE">VENEZUELA</html:option>
						<html:option value="VN">VIET NAM</html:option>
						<html:option value="VG">VIRGIN ISLANDS, BRITISH</html:option>
						<html:option value="VI">VIRGIN ISLANDS, U.S.</html:option>
						<html:option value="WF">WALLIS AND FUTUNA</html:option>
						<html:option value="EH">WESTERN SAHARA</html:option>
						<html:option value="YE">YEMEN</html:option>
						<html:option value="ZM">ZAMBIA</html:option>
						<html:option value="ZW">ZIMBABWE</html:option>
					</html:select></li>

			</ol>

			<ol>

				<li><label for=customerName>Name</label> <html:text
						property="customerName" maxlength="50" value="<%=customerName%>"></html:text></li>
			</ol>

			<ol>

				<li><label for=addressone>Address</label> <html:text
						property="street1" maxlength="100" value="<%=street1%>"></html:text></li>

				<li><label for=city>City</label> <html:text property="city"
						maxlength="50" value="<%=city%>"></html:text></li>

				<li><label for=state>State/Province</label> <html:select
						property="state" value="<%=state%>">
						<html:option value="">Select State/Province</html:option>
					</html:select></li>

				<li><label for=postcode>Zip/Postal Code</label> <html:text
						property="postalCode" maxlength="30" value="<%=postalCode%>"></html:text></li>

			</ol>

		</fieldset>

		<% } %>

		<fieldset>
			<ol class="optbox">
			
			    <li><input type="checkbox" name="promotable" value="20" id="promotable_field" checked="checked" />Send me occasional e-mail updates and special offers from Reader's Digest.<br />
                    <input type="checkbox" name="promotable" value="30" id="promotable_field" checked="checked" />Get special offers from third parties whom we've specially selected just for you.<br /><br />
                    <strong>Return visitors:</strong> This will update your e-mail privacy preferences. Read our <a href="http://adobestorefront.rd.com/privacy-policy.php" style="text-decoration:underline;">Online Privacy Policy</a>.<br />
                    </li>	

			</ol>
		</fieldset>

		<fieldset>
			<%
				if ("true".equalsIgnoreCase(transactionCompleted)) {
			%>
			<h4 align='center'>
				<font color='#dd3937'>Account Setup Successful</font>
			</h4>
			<%
				}
			%>
			<button type="submit" name="Submit" value="Submit">SUBMIT</button>
			
			<p>&nbsp;</p>
                <p>Need help? Email<a href="mailto:digitalsupport@rd.com?subject=Digital Editions" style="text-decoration:underline;"> Customer Care</a> or call 1-877-342-4775.</p>
			
			<!--<h3>Need help? <a href="">Contact Customer Care</a>.</h3>-->
		</fieldset>

	</html:form>

</body>
</html:html>
