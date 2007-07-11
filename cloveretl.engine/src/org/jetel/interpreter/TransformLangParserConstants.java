package org.jetel.interpreter;

public interface TransformLangParserConstants {

  int EOF = 0;
  int INTEGER_LITERAL = 15;
  int DIGIT = 16;
  int LETTER = 17;
  int UNDERSCORE = 18;
  int DECIMAL_LITERAL = 19;
  int HEX_LITERAL = 20;
  int OCTAL_LITERAL = 21;
  int FLOATING_POINT_LITERAL = 22;
  int EXPONENT = 23;
  int STRING_LITERAL = 24;
  int QUOTED_STRING = 25;
  int DQUOTED_STRING = 26;
  int UNTERMINATED_STRING_LITERAL = 27;
  int UNTERMINATED_QUOTED_STRING = 28;
  int UNTERMINATED_DQUOTED_STRING = 29;
  int BOOLEAN_LITERAL = 30;
  int TRUE = 31;
  int FALSE = 32;
  int DATE_LITERAL = 33;
  int DATETIME_LITERAL = 34;
  int SEMICOLON = 35;
  int NULL_LITERAL = 36;
  int MAPPING = 37;
  int OR = 38;
  int AND = 39;
  int NOT = 40;
  int EQUAL = 41;
  int NON_EQUAL = 42;
  int LESS_THAN = 43;
  int LESS_THAN_EQUAL = 44;
  int GREATER_THAN = 45;
  int GREATER_THAN_EQUAL = 46;
  int REGEX_EQUAL = 47;
  int CMPOPERATOR = 48;
  int MINUS = 49;
  int PLUS = 50;
  int MULTIPLY = 51;
  int DIVIDE = 52;
  int MODULO = 53;
  int INCR = 54;
  int DECR = 55;
  int TILDA = 56;
  int FIELD_ID = 57;
  int REC_NAME_FIELD_ID = 58;
  int REC_NUM_FIELD_ID = 59;
  int OPEN_PAR = 60;
  int CLOSE_PAR = 61;
  int INT_VAR = 62;
  int LONG_VAR = 63;
  int DATE_VAR = 64;
  int DOUBLE_VAR = 65;
  int DECIMAL_VAR = 66;
  int BOOLEAN_VAR = 67;
  int STRING_VAR = 68;
  int BYTE_VAR = 69;
  int LIST_VAR = 70;
  int MAP_VAR = 71;
  int RECORD_VAR = 72;
  int OBJECT_VAR = 73;
  int BREAK = 74;
  int CONTINUE = 75;
  int ELSE = 76;
  int FOR = 77;
  int FOR_EACH = 78;
  int FUNCTION = 79;
  int IF = 80;
  int RETURN = 81;
  int WHILE = 82;
  int CASE = 83;
  int ENUM = 84;
  int IMPORT = 85;
  int SWITCH = 86;
  int CASE_DEFAULT = 87;
  int DO = 88;
  int YEAR = 89;
  int MONTH = 90;
  int WEEK = 91;
  int DAY = 92;
  int HOUR = 93;
  int MINUTE = 94;
  int SECOND = 95;
  int MILLISEC = 96;
  int DATE_FIELD_LITERAL = 129;
  int IDENTIFIER = 130;
  int ERROR = 131;

  int DEFAULT = 0;
  int WithinComment = 1;
  int WithinLineComment = 2;
  int WithinInclude = 3;
  int WithingInclude = 4;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\n\\r\"",
    "\"/*\"",
    "\"*/\"",
    "<token of kind 8>",
    "\"//\"",
    "\"\\n\"",
    "<token of kind 11>",
    "\"#include\"",
    "\"\\n\"",
    "<token of kind 14>",
    "<INTEGER_LITERAL>",
    "<DIGIT>",
    "<LETTER>",
    "<UNDERSCORE>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<STRING_LITERAL>",
    "<QUOTED_STRING>",
    "<DQUOTED_STRING>",
    "<UNTERMINATED_STRING_LITERAL>",
    "<UNTERMINATED_QUOTED_STRING>",
    "<UNTERMINATED_DQUOTED_STRING>",
    "<BOOLEAN_LITERAL>",
    "\"true\"",
    "\"false\"",
    "<DATE_LITERAL>",
    "<DATETIME_LITERAL>",
    "\";\"",
    "\"null\"",
    "\":=\"",
    "<OR>",
    "<AND>",
    "<NOT>",
    "<EQUAL>",
    "<NON_EQUAL>",
    "<LESS_THAN>",
    "<LESS_THAN_EQUAL>",
    "<GREATER_THAN>",
    "<GREATER_THAN_EQUAL>",
    "<REGEX_EQUAL>",
    "<CMPOPERATOR>",
    "\"-\"",
    "\"+\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"++\"",
    "\"--\"",
    "\"~\"",
    "<FIELD_ID>",
    "<REC_NAME_FIELD_ID>",
    "<REC_NUM_FIELD_ID>",
    "\"(\"",
    "\")\"",
    "\"int\"",
    "\"long\"",
    "\"date\"",
    "<DOUBLE_VAR>",
    "\"decimal\"",
    "\"boolean\"",
    "\"string\"",
    "\"byte\"",
    "\"list\"",
    "\"map\"",
    "\"record\"",
    "\"object\"",
    "\"break\"",
    "\"continue\"",
    "\"else\"",
    "\"for\"",
    "\"foreach\"",
    "\"function\"",
    "\"if\"",
    "\"return\"",
    "\"while\"",
    "\"case\"",
    "\"enum\"",
    "\"import\"",
    "\"switch\"",
    "\"default\"",
    "\"do\"",
    "\"year\"",
    "\"month\"",
    "\"week\"",
    "\"day\"",
    "\"hour\"",
    "\"minute\"",
    "\"second\"",
    "\"millisec\"",
    "\",\"",
    "\"{\"",
    "\"}\"",
    "\"=\"",
    "\":\"",
    "\"[\"",
    "\"]\"",
    "\"isnull\"",
    "\"nvl\"",
    "\"iif\"",
    "\"print_stack\"",
    "\"breakpoint\"",
    "\"raise_error\"",
    "\"print_err\"",
    "\"print_log\"",
    "\"trace\"",
    "\"debug\"",
    "\"info\"",
    "\"warn\"",
    "\"error\"",
    "\"fatal\"",
    "\"sequence\"",
    "\".next\"",
    "\".current\"",
    "\".reset\"",
    "\"lookup\"",
    "\".\"",
    "\"lookup_next\"",
    "\"lookup_found\"",
    "\"lookup_admin\"",
    "\"init\"",
    "\"free\"",
    "<DATE_FIELD_LITERAL>",
    "<IDENTIFIER>",
    "<ERROR>",
  };

}
