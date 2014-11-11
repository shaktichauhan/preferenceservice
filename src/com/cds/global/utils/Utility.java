package com.cds.global.utils;


public class Utility {
	
	/**
	 * Returns true if string is Y, Yes or True.  Default is false
	 * @param stringValue
	 * @return
	 */
	public static final boolean stringMeansYes(String stringValue) {
		if ("Y".equalsIgnoreCase(stringValue) || "Yes".equalsIgnoreCase(stringValue) || "True".equalsIgnoreCase(stringValue) || "1".equals(stringValue)) {
			return true;
		}
		return false;
	}
	/**
	 * Defaults to N.  Unless string means Y.
	 * @param stringValue
	 * @return
	 */
	public static final String stringMeansY(String stringValue) {
		if ("Y".equalsIgnoreCase(stringValue) || "Yes".equalsIgnoreCase(stringValue) || "True".equalsIgnoreCase(stringValue) || "1".equals(stringValue)) {
			return "Y";
		}
		return "N";
	}
	/**
	 * Defaults to Y.  Unless string means N.
	 * @param stringValue
	 * @return
	 */
	public static final String stringMeansN(String stringValue) {
		if ("N".equalsIgnoreCase(stringValue) || "No".equalsIgnoreCase(stringValue) || "False".equalsIgnoreCase(stringValue) || "0".equals(stringValue)) {
			return "N";
		}
		return "Y";
	}
	/**
	 * Defaults to false,  Unless string means no, then it returns true.
	 * @param stringValue
	 * @return
	 */
	public static final boolean stringMeansNo(String stringValue) {
		if ("N".equalsIgnoreCase(stringValue) || "No".equalsIgnoreCase(stringValue) || "False".equalsIgnoreCase(stringValue) || "0".equals(stringValue)) {
			return true;
		}
		return false;
	}
	/**
	 * Returns Y or N.  If value is null or space, will return ' '.  No, False or N = N
	 * @param stringValue
	 * @return
	 */
	public static final String stringMeansNKeepSpace(String stringValue) {
		if (stringValue == null || "".equals(stringValue)) {
			return " ";
		}
		if ("N".equalsIgnoreCase(stringValue) || "No".equalsIgnoreCase(stringValue) || "False".equalsIgnoreCase(stringValue) || "0".equals(stringValue)) {
			return "N";
		}
		return "Y";
	}
	
	public static final String stringMeansN(Object obj) {
		if (obj != null) {
			String stringValue = (String) obj;
			if ("N".equalsIgnoreCase(stringValue) || "No".equalsIgnoreCase(stringValue) || "False".equalsIgnoreCase(stringValue) || "0".equals(stringValue)) {
				return "N";
			}
		}
		return "Y";
	}
	/**
	 * This is used when downloading a csv file.
	 * @param string
	 * @return
	 */
	public static String wrapTextWithQuotesForCSV(String string) {
    	if (string.indexOf(",") != -1) {
    		string = "\"" + string + "\"";
    	}
    	return string;
    }
	/**
	 * Gets a friendly message for the seconds ago.  IE: '7 minutes ago'
	 * @param seconds
	 * @return
	 */
	public static String getTimeAgoFriendly(int seconds) {
		if (seconds == 0) {
			return "";
		} else if (seconds < 60) {
			return seconds + " seconds ago";
		} else if (seconds < 3600) {
			return seconds/60 + " minutes ago";
		} else if (seconds < 7200) {
			//less than 2 hours ago
			return "1 hour " + ((seconds - 3600)/60) + " minutes ago";
		} else if (seconds < 86400) {
			return (seconds/3600) + " hours ago";
		} else {
			return (seconds / 86400) + " days ago";
		}
	}
	public static int getDaysAgo(int seconds) {
		if (seconds < 86400) {
			return 0;//same day or last 24 hours
		} else {
			return (seconds / 86400);
		}
	}
	
	public static String padRight(String s, int n) {
		if (s == null) {
			s = "";
		}
	     return String.format("%1$-" + n + "s", s);  
	}
	/**
	 * Pads the string to the right and upper cases it.
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padRightUCase(String s, int n) {
		if (s == null) {
			s = "";
		}
	     return String.format("%1$-" + n + "s", s.toUpperCase());  
	}
	/**
	 * Pads the string to the right, and defaults the value if it's null or empty
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padRightDefault(String s, int n, String defaultValue) {
		if (s == null || "".equals(s)) {
			s = defaultValue;
		}
	     return String.format("%1$-" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
		if (s == null) {
			s = "";
		}
	    return String.format("%1$#" + n + "s", s);  
	}
	
	public static String padLeftZeros(int number, int n) {
	    return String.format("%0" + n + "d", number); 
	}
	
	public static String padLeftZeros(String num, int n) {
		if (num == null) {
			num = "";
		}
		while ( num.length() < n) {
			num = "0" + num;
		}
		return num;
	}
	/**
	 * Gets the numeric digits only.  Ignores non-digits.
	 * @param s
	 * @return
	 */
	public  static String getDigitsOnly (String s) {
	    StringBuffer digitsOnly = new StringBuffer ();
	    char c;
	    for (int i = 0; i < s.length (); i++) {
	      c = s.charAt (i);
	      if (Character.isDigit (c)) {
	        digitsOnly.append (c);
	      }
	    }
	    return digitsOnly.toString ();
	}
}