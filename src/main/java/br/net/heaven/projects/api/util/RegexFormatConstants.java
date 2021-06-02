package br.net.heaven.projects.api.util;

public interface RegexFormatConstants {

	public static final String GENERAL_FORMAT = "\\w*\\W*";
	
	public static final String RFC3339_DATE_FORMAT = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])T(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)Z$";

}
