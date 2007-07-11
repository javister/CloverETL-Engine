package org.jetel.interpreter;

import org.jetel.data.DataRecord;
import org.jetel.metadata.DataRecordMetadata;
import org.jetel.interpreter.ASTnode.*;
import org.jetel.util.StringUtils;
import org.jetel.util.FileUtils;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.Channels;

public class TransformLangParser extends ExpParser/*@bgen(jjtree)*/implements TransformLangParserTreeConstants, TransformLangParserConstants {/*@bgen(jjtree)*/
  protected JJTTransformLangParserState jjtree = new JJTTransformLangParserState();
       DataRecordMetadata[] inRecordsMetadata;
       DataRecordMetadata[] outRecordsMetadata;
       Map inDataRecordsMap;
       Map outDataRecordsMap;
           ParserHelper parserHelper;
       List<Throwable> parseExceptions;
       String sourceFilename;

       public TransformLangParser(DataRecordMetadata recordMetadata,java.io.InputStream stream){
              this(new DataRecordMetadata[] {recordMetadata}, new DataRecordMetadata[0],stream,"UTF-8");
       }


       public TransformLangParser(DataRecordMetadata[] inRecordsMetadata,
                                                        DataRecordMetadata[] outRecordsMetadata,
                                                        java.io.InputStream stream){
                        this(inRecordsMetadata,outRecordsMetadata,stream,"UTF-8");

       }


       public TransformLangParser(DataRecordMetadata[] inRecordsMetadata,
                                                        DataRecordMetadata[] outRecordsMetadata,
                                                        java.io.InputStream stream,String encoding){
              this(stream,encoding);
              parserHelper=new ParserHelper();
              this.inRecordsMetadata=inRecordsMetadata;
              this.outRecordsMetadata=outRecordsMetadata;
              inDataRecordsMap=new HashMap(inRecordsMetadata.length);
              outDataRecordsMap=new HashMap(outRecordsMetadata.length);
              parseExceptions=new LinkedList<Throwable>();
              for(int i=0;i<inRecordsMetadata.length;i++){
                inDataRecordsMap.put(inRecordsMetadata[i].getName(),new Integer(i));
              }
              for(int i=0;i<outRecordsMetadata.length;i++){
                outDataRecordsMap.put(outRecordsMetadata[i].getName(),new Integer(i));
              }
      }

      TransformLangParser(TransformLangParser parent,String filename,java.io.InputStream stream){
                          this(stream);
                          this.sourceFilename=filename;
                          this.parserHelper=parent.parserHelper;
              this.inRecordsMetadata=parent.inRecordsMetadata;
              this.outRecordsMetadata=parent.outRecordsMetadata;
              this.inDataRecordsMap=parent.inDataRecordsMap;
              this.outDataRecordsMap=parent.outDataRecordsMap;
              this.parseExceptions=parent.parseExceptions;
      }

      public final DataRecordMetadata getInRecordMeta(){
             return inRecordsMetadata[0];
      }

      public final int getInRecordNum(String name){
        try{
             return ((Integer)inDataRecordsMap.get(name)).intValue() ;
        }catch(Exception ex){
                return -1;
        }
      }

      public final int getOutRecordNum(String name){
        try{
             return ((Integer)outDataRecordsMap.get(name)).intValue() ;
        }catch(Exception ex){
                return -1;
        }
      }

      public final DataRecordMetadata getInRecordMeta(int num){
        try{
             return inRecordsMetadata[num];
        }catch(Exception ex){
                return null;
        }
      }

      public final DataRecordMetadata getOutRecordMeta(int num){
        try{
             return outRecordsMetadata[num];
        }catch(Exception ex){
                return null;
        }
      }


     /**
      *  Returns map of function symbols where
      *  under function name is saved reference to appropriate 
      *  function definition/declaration node - upon that node
      *  visit() method of TransformationLangExecutor can be called to
      *  execute function's body. 
      */

      public final Map getFunctions(){
        return parserHelper.functionSymbol;
    }

     public final CLVFFunctionDeclaration getFunction(String name){
        return (CLVFFunctionDeclaration) parserHelper.functionSymbol.get(name);
     }


     /**
      *  Returns map of global variable symbols where
      *  under variable name is saved appropriate slot in 
      *  which variable's value is saved. 
      */
      public final Map getGlobalVariables(){
        return parserHelper.globalVariableSymbol;
     }

     public final int getGlobalVariableSlot(String name){
        return parserHelper.getGlobalVariableSlot(name);
     }

     public static final String unquote(String image){
        return image.substring(1,image.length()-1);
     }

   /**
    * Save the current line number for run-time error messages
    */
   void jjtreeOpenNodeScope(Node n)
    {
       Token t = getToken(0);
       if (t!= null) {
           ((SimpleNode) n).setLineNumber(t.beginLine);
           ((SimpleNode) n).setColumnNumber(t.beginColumn);
       }
    }

   /**
    * Dummy routine, required because NODE_SCOPE_HOOK is true
    */
    void jjtreeCloseNodeScope(Node n)
    {
    }

    public List<Throwable> getParseExceptions(){
        return parseExceptions;
    }

/* 
 *  The start nonterminal and its productions. 
 *  Nonterminal & productions for transformation language
 */
  final public CLVFStart Start() throws ParseException {
                     /*@bgen(jjtree) Start */
  CLVFStart jjtn000 = new CLVFStart(this, JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      CompilationUnit();
      jj_consume_token(0);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtreeCloseNodeScope(jjtn000);
        if (parseExceptions.size()>0){
                {if (true) throw (ParseException)parseExceptions.get(0);}
        }
        {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
    throw new Error("Missing return statement in function");
  }

/* 
 *  The start expression nonterminal and its productions. 
 *  Nonterminal & productions for expressions only
 */
  final public CLVFStartExpression StartExpression() throws ParseException {
                                         /*@bgen(jjtree) StartExpression */
  CLVFStartExpression jjtn000 = new CLVFStartExpression(this, JJTSTARTEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      ConditionalOrExpression();
      jj_consume_token(0);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtreeCloseNodeScope(jjtn000);
                if (parseExceptions.size()>0){
                        {if (true) throw (ParseException)parseExceptions.get(0);}
                }
                {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public void CompilationUnit() throws ParseException {
   String name;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IMPORT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      ImportSource();
      jj_consume_token(SEMICOLON);
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case OBJECT_VAR:
      case BREAK:
      case CONTINUE:
      case FOR:
      case FOR_EACH:
      case FUNCTION:
      case IF:
      case RETURN:
      case WHILE:
      case SWITCH:
      case DO:
      case 98:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case OBJECT_VAR:
        VarDeclaration();
        jj_consume_token(SEMICOLON);
        break;
      case SEMICOLON:
      case BREAK:
      case CONTINUE:
      case FOR:
      case FOR_EACH:
      case IF:
      case RETURN:
      case WHILE:
      case SWITCH:
      case DO:
      case 98:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        Statement();
        break;
      case FUNCTION:
        FunctionDeclaration();
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      Mapping();
      jj_consume_token(SEMICOLON);
    }
    jj_consume_token(0);
  }

  final public void ImportSource() throws ParseException {
 /*@bgen(jjtree) ImportSource */
        CLVFImportSource jjtn000 = new CLVFImportSource(this, JJTIMPORTSOURCE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(IMPORT);
      t = jj_consume_token(STRING_LITERAL);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtreeCloseNodeScope(jjtn000);
                String filenameURL=unquote(t.image);
                InputStream stream;
                try{
                        stream=Channels.newInputStream(FileUtils. getReadableChannel(null, filenameURL));
                        // stream=new BufferedInputStream(new FileInputStream(filenameURL));
                }catch(Exception ex){
                        {if (true) throw new ParseException(t,"can't open import file \""+filenameURL+"\"",ex);}
                }
                CLVFStart parseTree;
                try{
                        TransformLangParser parser = new TransformLangParser(this,filenameURL,stream);
                        parseTree = parser.Start();
                }catch(ParseException e){
                        e.setFilename(filenameURL);
                        {if (true) throw e;}
                        //new ParseException(t,"error when parsing import file \""+filenameURL+"\"",e);
                }
                jjtn000.jjtAddChild(parseTree, 0);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void FunctionDeclaration() throws ParseException {
 /*@bgen(jjtree) FunctionDeclaration */
        CLVFFunctionDeclaration jjtn000 = new CLVFFunctionDeclaration(this, JJTFUNCTIONDECLARATION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t,r;
        int order=0;
    try {
      jj_consume_token(FUNCTION);
      t = jj_consume_token(IDENTIFIER);
                jjtn000.setName(t.image);
                if (parserHelper.functionSymbol.put(t.image,jjtn000)!=null){
                         {if (true) throw new ParseException(t,"function "+t.image+" already declared");}
                        }
                parserHelper.enteredFunctionDeclaration(t.image);
      jj_consume_token(OPEN_PAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
                                           jjtn000.addVarName(order++, t.image);
                                                        if (!parserHelper.addLocalVariable(t.image,OBJECT_VAR)){
                                                          {if (true) throw new ParseException(t,"parameter ["+t.image+"] already declared in function"
                                                          +parserHelper.functionName);}
                                                        }
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 97:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(97);
        t = jj_consume_token(IDENTIFIER);
                                             jjtn000.addVarName(order++,t.image);
                                                        if (!parserHelper.addLocalVariable(t.image,OBJECT_VAR)){
                                                          {if (true) throw new ParseException(t,"parameter ["+t.image+"] already declared in function"
                                                          +parserHelper.functionName);}
                                                        }
      }
      jj_consume_token(CLOSE_PAR);
      jj_consume_token(98);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT_VAR:
        case LONG_VAR:
        case DATE_VAR:
        case DOUBLE_VAR:
        case DECIMAL_VAR:
        case BOOLEAN_VAR:
        case STRING_VAR:
        case LIST_VAR:
        case MAP_VAR:
        case OBJECT_VAR:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        VarDeclaration();
        jj_consume_token(SEMICOLON);
      }
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEMICOLON:
        case BREAK:
        case CONTINUE:
        case FOR:
        case FOR_EACH:
        case IF:
        case RETURN:
        case WHILE:
        case SWITCH:
        case DO:
        case 98:
        case 104:
        case 105:
        case 106:
        case 107:
        case 108:
        case 109:
        case 110:
        case 111:
        case 118:
        case 122:
        case 124:
        case 125:
        case 126:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_6;
        }
        Statement();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
        label_7:
        while (true) {
          Mapping();
          jj_consume_token(SEMICOLON);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case FIELD_ID:
          case REC_NAME_FIELD_ID:
          case REC_NUM_FIELD_ID:
            ;
            break;
          default:
            jj_la1[8] = jj_gen;
            break label_7;
          }
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RETURN:
          ReturnStatement();
          break;
        default:
          jj_la1[9] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
      jj_consume_token(99);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtreeCloseNodeScope(jjtn000);
                parserHelper.exitedFunctionDeclaration();
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

/*
 JAVACODE
    void FuncDeclarationExit() #void {
	
	  parserHelper.exitedFunctionDeclaration();	
    }
*/
  final public void VarDeclaration() throws ParseException {
 /*@bgen(jjtree) VarDeclaration */
  CLVFVarDeclaration jjtn000 = new CLVFVarDeclaration(this, JJTVARDECLARATION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t,l,p;
  int varSlot;
    try {
      try {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT_VAR:
          jj_consume_token(INT_VAR);
          break;
        case LONG_VAR:
          jj_consume_token(LONG_VAR);
          break;
        case DOUBLE_VAR:
          jj_consume_token(DOUBLE_VAR);
          break;
        case DECIMAL_VAR:
          jj_consume_token(DECIMAL_VAR);
          break;
        case STRING_VAR:
          jj_consume_token(STRING_VAR);
          break;
        case DATE_VAR:
          jj_consume_token(DATE_VAR);
          break;
        case BOOLEAN_VAR:
          jj_consume_token(BOOLEAN_VAR);
          break;
        case LIST_VAR:
          jj_consume_token(LIST_VAR);
          break;
        case MAP_VAR:
          jj_consume_token(MAP_VAR);
          break;
        case OBJECT_VAR:
          jj_consume_token(OBJECT_VAR);
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jjtn000.setType(getToken(0).kind);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case OPEN_PAR:
          jj_consume_token(OPEN_PAR);
          l = jj_consume_token(INTEGER_LITERAL);
                               jjtn000.setLength(l.image);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 97:
            jj_consume_token(97);
            p = jj_consume_token(INTEGER_LITERAL);
                                                                                         jjtn000.setPrecision(p.image);
            break;
          default:
            jj_la1[12] = jj_gen;
            ;
          }
          jj_consume_token(CLOSE_PAR);
          break;
        default:
          jj_la1[13] = jj_gen;
          ;
        }
        t = jj_consume_token(IDENTIFIER);
      if (!parserHelper.addVariable(t.image,jjtn000.getType())){
        {if (true) throw new ParseException(t, "variable ["+t.image+"] already declared");}
      }
      else {
        // is it local variable declaration ?

                if (parserHelper.inFunctionDeclaration){
          jjtn000.setVarSlot(parserHelper.getLocalVariableSlot(t.image));
          jjtn000.setLocalVariale(true);
        }
        else {
          jjtn000.setVarSlot(parserHelper.getGlobalVariableSlot(t.image));
          jjtn000.setLocalVariale(false);
        }
        jjtn000.setName(t.image);
      }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 100:
          jj_consume_token(100);
          ConditionalOrExpression();
          break;
        default:
          jj_la1[14] = jj_gen;
          ;
        }
      } catch (ParseException e) {
    parseExceptions.add(e);
//following code causes parser to cough     
//do {
//      t = getNextToken();
//    }
//    while (t.kind != SEMICOLON);

      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void Expression() throws ParseException {
    if (jj_2_1(2147483647)) {
      Assignment();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case DATE_LITERAL:
      case DATETIME_LITERAL:
      case NULL_LITERAL:
      case NOT:
      case MINUS:
      case PLUS:
      case INCR:
      case DECR:
      case TILDA:
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
      case OPEN_PAR:
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case BYTE_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case RECORD_VAR:
      case OBJECT_VAR:
      case YEAR:
      case MONTH:
      case WEEK:
      case DAY:
      case HOUR:
      case MINUTE:
      case SECOND:
      case MILLISEC:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        ConditionalOrExpression();
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Assignment() throws ParseException {
 /*@bgen(jjtree) Assignment */
  CLVFAssignment jjtn000 = new CLVFAssignment(this, JJTASSIGNMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      VarExp();
      jj_consume_token(100);
      ConditionalOrExpression();
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void Mapping() throws ParseException {
 /*@bgen(jjtree) Mapping */
  CLVFMapping jjtn000 = new CLVFMapping(this, JJTMAPPING);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t ;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FIELD_ID:
        t = jj_consume_token(FIELD_ID);
                         jjtn000.setFieldName(t.image);
        break;
      case REC_NAME_FIELD_ID:
        t = jj_consume_token(REC_NAME_FIELD_ID);
                              jjtn000.setRecordFieldName(t.image);
        break;
      case REC_NUM_FIELD_ID:
        t = jj_consume_token(REC_NUM_FIELD_ID);
                             jjtn000.setRecordNumFieldName(t.image);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(MAPPING);
      ConditionalOrExpression();
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 101:
          ;
          break;
        default:
          jj_la1[17] = jj_gen;
          break label_8;
        }
        jj_consume_token(101);
        ConditionalOrExpression();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

/* Other nonterminals and their productions */
  final public void ConditionalOrExpression() throws ParseException {
    ConditionalAndExpression();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_9;
      }
      jj_consume_token(OR);
            CLVFOr jjtn001 = new CLVFOr(this, JJTOR);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
            jjtreeOpenNodeScope(jjtn001);
      try {
        ConditionalAndExpression();
      } catch (Throwable jjte001) {
            if (jjtc001) {
              jjtree.clearNodeScope(jjtn001);
              jjtc001 = false;
            } else {
              jjtree.popNode();
            }
            if (jjte001 instanceof RuntimeException) {
              {if (true) throw (RuntimeException)jjte001;}
            }
            if (jjte001 instanceof ParseException) {
              {if (true) throw (ParseException)jjte001;}
            }
            {if (true) throw (Error)jjte001;}
      } finally {
            if (jjtc001) {
              jjtree.closeNodeScope(jjtn001,  2);
              jjtreeCloseNodeScope(jjtn001);
            }
      }
    }
  }

  final public void ConditionalAndExpression() throws ParseException {
    EqualityExpression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_10;
      }
      jj_consume_token(AND);
             CLVFAnd jjtn001 = new CLVFAnd(this, JJTAND);
             boolean jjtc001 = true;
             jjtree.openNodeScope(jjtn001);
             jjtreeOpenNodeScope(jjtn001);
      try {
        EqualityExpression();
      } catch (Throwable jjte001) {
             if (jjtc001) {
               jjtree.clearNodeScope(jjtn001);
               jjtc001 = false;
             } else {
               jjtree.popNode();
             }
             if (jjte001 instanceof RuntimeException) {
               {if (true) throw (RuntimeException)jjte001;}
             }
             if (jjte001 instanceof ParseException) {
               {if (true) throw (ParseException)jjte001;}
             }
             {if (true) throw (Error)jjte001;}
      } finally {
             if (jjtc001) {
               jjtree.closeNodeScope(jjtn001,  2);
               jjtreeCloseNodeScope(jjtn001);
             }
      }
    }
  }

  final public void EqualityExpression() throws ParseException {
    RelationalExpression();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
      case NON_EQUAL:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
        jj_consume_token(EQUAL);
        RelationalExpression();
                                      CLVFComparison jjtn001 = new CLVFComparison(this, JJTCOMPARISON);
                                      boolean jjtc001 = true;
                                      jjtree.openNodeScope(jjtn001);
                                      jjtreeOpenNodeScope(jjtn001);
        try {
                                      jjtree.closeNodeScope(jjtn001,  2);
                                      jjtc001 = false;
                                      jjtreeCloseNodeScope(jjtn001);
                                      jjtn001.cmpType=EQUAL;
        } finally {
                                      if (jjtc001) {
                                        jjtree.closeNodeScope(jjtn001,  2);
                                        jjtreeCloseNodeScope(jjtn001);
                                      }
        }
        break;
      case NON_EQUAL:
        jj_consume_token(NON_EQUAL);
        RelationalExpression();
                                          CLVFComparison jjtn002 = new CLVFComparison(this, JJTCOMPARISON);
                                          boolean jjtc002 = true;
                                          jjtree.openNodeScope(jjtn002);
                                          jjtreeOpenNodeScope(jjtn002);
        try {
                                          jjtree.closeNodeScope(jjtn002,  2);
                                          jjtc002 = false;
                                          jjtreeCloseNodeScope(jjtn002);
                                          jjtn002.cmpType=NON_EQUAL;
        } finally {
                                          if (jjtc002) {
                                            jjtree.closeNodeScope(jjtn002,  2);
                                            jjtreeCloseNodeScope(jjtn002);
                                          }
        }
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void RelationalExpression() throws ParseException {
    AdditiveExpression();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LESS_THAN:
      case LESS_THAN_EQUAL:
      case GREATER_THAN:
      case GREATER_THAN_EQUAL:
      case REGEX_EQUAL:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_12;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LESS_THAN:
        jj_consume_token(LESS_THAN);
        AdditiveExpression();
                                       CLVFComparison jjtn001 = new CLVFComparison(this, JJTCOMPARISON);
                                       boolean jjtc001 = true;
                                       jjtree.openNodeScope(jjtn001);
                                       jjtreeOpenNodeScope(jjtn001);
        try {
                                       jjtree.closeNodeScope(jjtn001,  2);
                                       jjtc001 = false;
                                       jjtreeCloseNodeScope(jjtn001);
                                       jjtn001.cmpType=LESS_THAN;
        } finally {
                                       if (jjtc001) {
                                         jjtree.closeNodeScope(jjtn001,  2);
                                         jjtreeCloseNodeScope(jjtn001);
                                       }
        }
        break;
      case GREATER_THAN:
        jj_consume_token(GREATER_THAN);
        AdditiveExpression();
                                          CLVFComparison jjtn002 = new CLVFComparison(this, JJTCOMPARISON);
                                          boolean jjtc002 = true;
                                          jjtree.openNodeScope(jjtn002);
                                          jjtreeOpenNodeScope(jjtn002);
        try {
                                          jjtree.closeNodeScope(jjtn002,  2);
                                          jjtc002 = false;
                                          jjtreeCloseNodeScope(jjtn002);
                                          jjtn002.cmpType=GREATER_THAN;
        } finally {
                                          if (jjtc002) {
                                            jjtree.closeNodeScope(jjtn002,  2);
                                            jjtreeCloseNodeScope(jjtn002);
                                          }
        }
        break;
      case LESS_THAN_EQUAL:
        jj_consume_token(LESS_THAN_EQUAL);
        AdditiveExpression();
                                             CLVFComparison jjtn003 = new CLVFComparison(this, JJTCOMPARISON);
                                             boolean jjtc003 = true;
                                             jjtree.openNodeScope(jjtn003);
                                             jjtreeOpenNodeScope(jjtn003);
        try {
                                             jjtree.closeNodeScope(jjtn003,  2);
                                             jjtc003 = false;
                                             jjtreeCloseNodeScope(jjtn003);
                                             jjtn003.cmpType=LESS_THAN_EQUAL;
        } finally {
                                             if (jjtc003) {
                                               jjtree.closeNodeScope(jjtn003,  2);
                                               jjtreeCloseNodeScope(jjtn003);
                                             }
        }
        break;
      case GREATER_THAN_EQUAL:
        jj_consume_token(GREATER_THAN_EQUAL);
        AdditiveExpression();
                                                CLVFComparison jjtn004 = new CLVFComparison(this, JJTCOMPARISON);
                                                boolean jjtc004 = true;
                                                jjtree.openNodeScope(jjtn004);
                                                jjtreeOpenNodeScope(jjtn004);
        try {
                                                jjtree.closeNodeScope(jjtn004,  2);
                                                jjtc004 = false;
                                                jjtreeCloseNodeScope(jjtn004);
                                                jjtn004.cmpType=GREATER_THAN_EQUAL;
        } finally {
                                                if (jjtc004) {
                                                  jjtree.closeNodeScope(jjtn004,  2);
                                                  jjtreeCloseNodeScope(jjtn004);
                                                }
        }
        break;
      case REGEX_EQUAL:
        jj_consume_token(REGEX_EQUAL);
        RegexLiteral();
                                        CLVFComparison jjtn005 = new CLVFComparison(this, JJTCOMPARISON);
                                        boolean jjtc005 = true;
                                        jjtree.openNodeScope(jjtn005);
                                        jjtreeOpenNodeScope(jjtn005);
        try {
                                        jjtree.closeNodeScope(jjtn005,  2);
                                        jjtc005 = false;
                                        jjtreeCloseNodeScope(jjtn005);
                                        jjtn005.cmpType=REGEX_EQUAL;
        } finally {
                                        if (jjtc005) {
                                          jjtree.closeNodeScope(jjtn005,  2);
                                          jjtreeCloseNodeScope(jjtn005);
                                        }
        }
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void AdditiveExpression() throws ParseException {
    MultiplicativeExpression();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
      case PLUS:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_13;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
              CLVFAddNode jjtn001 = new CLVFAddNode(this, JJTADDNODE);
              boolean jjtc001 = true;
              jjtree.openNodeScope(jjtn001);
              jjtreeOpenNodeScope(jjtn001);
        try {
          MultiplicativeExpression();
        } catch (Throwable jjte001) {
              if (jjtc001) {
                jjtree.clearNodeScope(jjtn001);
                jjtc001 = false;
              } else {
                jjtree.popNode();
              }
              if (jjte001 instanceof RuntimeException) {
                {if (true) throw (RuntimeException)jjte001;}
              }
              if (jjte001 instanceof ParseException) {
                {if (true) throw (ParseException)jjte001;}
              }
              {if (true) throw (Error)jjte001;}
        } finally {
              if (jjtc001) {
                jjtree.closeNodeScope(jjtn001,  2);
                jjtreeCloseNodeScope(jjtn001);
              }
        }
        break;
      case MINUS:
        jj_consume_token(MINUS);
               CLVFSubNode jjtn002 = new CLVFSubNode(this, JJTSUBNODE);
               boolean jjtc002 = true;
               jjtree.openNodeScope(jjtn002);
               jjtreeOpenNodeScope(jjtn002);
        try {
          MultiplicativeExpression();
        } catch (Throwable jjte002) {
               if (jjtc002) {
                 jjtree.clearNodeScope(jjtn002);
                 jjtc002 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte002 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte002;}
               }
               if (jjte002 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte002;}
               }
               {if (true) throw (Error)jjte002;}
        } finally {
               if (jjtc002) {
                 jjtree.closeNodeScope(jjtn002,  2);
                 jjtreeCloseNodeScope(jjtn002);
               }
        }
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void MultiplicativeExpression() throws ParseException {
    UnaryExpression();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:
      case MODULO:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_14;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
                 CLVFMulNode jjtn001 = new CLVFMulNode(this, JJTMULNODE);
                 boolean jjtc001 = true;
                 jjtree.openNodeScope(jjtn001);
                 jjtreeOpenNodeScope(jjtn001);
        try {
          UnaryExpression();
        } catch (Throwable jjte001) {
                 if (jjtc001) {
                   jjtree.clearNodeScope(jjtn001);
                   jjtc001 = false;
                 } else {
                   jjtree.popNode();
                 }
                 if (jjte001 instanceof RuntimeException) {
                   {if (true) throw (RuntimeException)jjte001;}
                 }
                 if (jjte001 instanceof ParseException) {
                   {if (true) throw (ParseException)jjte001;}
                 }
                 {if (true) throw (Error)jjte001;}
        } finally {
                 if (jjtc001) {
                   jjtree.closeNodeScope(jjtn001,  2);
                   jjtreeCloseNodeScope(jjtn001);
                 }
        }
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
               CLVFDivNode jjtn002 = new CLVFDivNode(this, JJTDIVNODE);
               boolean jjtc002 = true;
               jjtree.openNodeScope(jjtn002);
               jjtreeOpenNodeScope(jjtn002);
        try {
          UnaryExpression();
        } catch (Throwable jjte002) {
               if (jjtc002) {
                 jjtree.clearNodeScope(jjtn002);
                 jjtc002 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte002 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte002;}
               }
               if (jjte002 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte002;}
               }
               {if (true) throw (Error)jjte002;}
        } finally {
               if (jjtc002) {
                 jjtree.closeNodeScope(jjtn002,  2);
                 jjtreeCloseNodeScope(jjtn002);
               }
        }
        break;
      case MODULO:
        jj_consume_token(MODULO);
               CLVFModNode jjtn003 = new CLVFModNode(this, JJTMODNODE);
               boolean jjtc003 = true;
               jjtree.openNodeScope(jjtn003);
               jjtreeOpenNodeScope(jjtn003);
        try {
          UnaryExpression();
        } catch (Throwable jjte003) {
               if (jjtc003) {
                 jjtree.clearNodeScope(jjtn003);
                 jjtc003 = false;
               } else {
                 jjtree.popNode();
               }
               if (jjte003 instanceof RuntimeException) {
                 {if (true) throw (RuntimeException)jjte003;}
               }
               if (jjte003 instanceof ParseException) {
                 {if (true) throw (ParseException)jjte003;}
               }
               {if (true) throw (Error)jjte003;}
        } finally {
               if (jjtc003) {
                 jjtree.closeNodeScope(jjtn003,  2);
                 jjtreeCloseNodeScope(jjtn003);
               }
        }
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void PostfixOp() throws ParseException {
 /*@bgen(jjtree) Operator */
  CLVFOperator jjtn000 = new CLVFOperator(this, JJTOPERATOR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        jj_consume_token(INCR);
        break;
      case DECR:
        jj_consume_token(DECR);
        break;
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtreeCloseNodeScope(jjtn000);
    jjtn000.setOperator(getToken(0).kind);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void PostfixExpression() throws ParseException {
 /*@bgen(jjtree) #PostfixExpression(> 1) */
 CLVFPostfixExpression jjtn000 = new CLVFPostfixExpression(this, JJTPOSTFIXEXPRESSION);
 boolean jjtc000 = true;
 jjtree.openNodeScope(jjtn000);
 jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      PrimaryExpression();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
      case DECR:
        PostfixOp();
        break;
      default:
        jj_la1[29] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void UnaryOp() throws ParseException {
 /*@bgen(jjtree) Operator */
  CLVFOperator jjtn000 = new CLVFOperator(this, JJTOPERATOR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        jj_consume_token(INCR);
        break;
      case DECR:
        jj_consume_token(DECR);
        break;
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      case TILDA:
        jj_consume_token(TILDA);
        break;
      case NOT:
        jj_consume_token(NOT);
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtreeCloseNodeScope(jjtn000);
    jjtn000.setOperator(getToken(0).kind);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void UnaryExpression() throws ParseException {
 /*@bgen(jjtree) #UnaryExpression(> 1) */
  CLVFUnaryExpression jjtn000 = new CLVFUnaryExpression(this, JJTUNARYEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case DATE_LITERAL:
      case DATETIME_LITERAL:
      case NULL_LITERAL:
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
      case OPEN_PAR:
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case BYTE_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case RECORD_VAR:
      case OBJECT_VAR:
      case YEAR:
      case MONTH:
      case WEEK:
      case DAY:
      case HOUR:
      case MINUTE:
      case SECOND:
      case MILLISEC:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        PostfixExpression();
        break;
      case NOT:
      case MINUS:
      case PLUS:
      case INCR:
      case DECR:
      case TILDA:
        UnaryOp();
        UnaryExpression();
        break;
      default:
        jj_la1[31] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
           if (jjtc000) {
             jjtree.clearNodeScope(jjtn000);
             jjtc000 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte000 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte000;}
           }
           if (jjte000 instanceof ParseException) {
             {if (true) throw (ParseException)jjte000;}
           }
           {if (true) throw (Error)jjte000;}
    } finally {
           if (jjtc000) {
             jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
             jjtreeCloseNodeScope(jjtn000);
           }
    }
  }

  final public void PrimaryExpression() throws ParseException {
    if (jj_2_2(3)) {
      FunctionCall();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case BYTE_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case RECORD_VAR:
      case OBJECT_VAR:
      case YEAR:
      case MONTH:
      case WEEK:
      case DAY:
      case HOUR:
      case MINUTE:
      case SECOND:
      case MILLISEC:
        SymbolNameExp();
        break;
      case INTEGER_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case DATE_LITERAL:
      case DATETIME_LITERAL:
      case NULL_LITERAL:
        LitExp();
        break;
      case IDENTIFIER:
        VarExp();
        break;
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
        InputFieldExp();
        break;
      case OPEN_PAR:
        jj_consume_token(OPEN_PAR);
        Expression();
        jj_consume_token(CLOSE_PAR);
        break;
      default:
        jj_la1[32] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void FunctionCall() throws ParseException {
    if (jj_2_3(2)) {
      BuildInFunction();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        FunctionCallStatement();
        break;
      default:
        jj_la1[33] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void LitExp() throws ParseException {
        Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOATING_POINT_LITERAL:
      t = jj_consume_token(FLOATING_POINT_LITERAL);
          CLVFLiteral jjtn001 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
          jjtreeOpenNodeScope(jjtn001);
      try {
          jjtree.closeNodeScope(jjtn001, true);
          jjtc001 = false;
          jjtreeCloseNodeScope(jjtn001);
          jjtn001.setVal(FLOATING_POINT_LITERAL,t.image);
      } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001, true);
            jjtreeCloseNodeScope(jjtn001);
          }
      }
      break;
    case HEX_LITERAL:
      t = jj_consume_token(HEX_LITERAL);
          CLVFLiteral jjtn002 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc002 = true;
          jjtree.openNodeScope(jjtn002);
          jjtreeOpenNodeScope(jjtn002);
      try {
          jjtree.closeNodeScope(jjtn002, true);
          jjtc002 = false;
          jjtreeCloseNodeScope(jjtn002);
          jjtn002.setVal(HEX_LITERAL,t.image);
      } finally {
          if (jjtc002) {
            jjtree.closeNodeScope(jjtn002, true);
            jjtreeCloseNodeScope(jjtn002);
          }
      }
      break;
    case OCTAL_LITERAL:
      t = jj_consume_token(OCTAL_LITERAL);
          CLVFLiteral jjtn003 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc003 = true;
          jjtree.openNodeScope(jjtn003);
          jjtreeOpenNodeScope(jjtn003);
      try {
          jjtree.closeNodeScope(jjtn003, true);
          jjtc003 = false;
          jjtreeCloseNodeScope(jjtn003);
          jjtn003.setVal(OCTAL_LITERAL,t.image);
      } finally {
          if (jjtc003) {
            jjtree.closeNodeScope(jjtn003, true);
            jjtreeCloseNodeScope(jjtn003);
          }
      }
      break;
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
          CLVFLiteral jjtn004 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc004 = true;
          jjtree.openNodeScope(jjtn004);
          jjtreeOpenNodeScope(jjtn004);
      try {
          jjtree.closeNodeScope(jjtn004, true);
          jjtc004 = false;
          jjtreeCloseNodeScope(jjtn004);
          jjtn004.setVal(INTEGER_LITERAL,t.image);
      } finally {
          if (jjtc004) {
            jjtree.closeNodeScope(jjtn004, true);
            jjtreeCloseNodeScope(jjtn004);
          }
      }
      break;
    case STRING_LITERAL:
      t = jj_consume_token(STRING_LITERAL);
          CLVFLiteral jjtn005 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc005 = true;
          jjtree.openNodeScope(jjtn005);
          jjtreeOpenNodeScope(jjtn005);
      try {
          jjtree.closeNodeScope(jjtn005, true);
          jjtc005 = false;
          jjtreeCloseNodeScope(jjtn005);
          jjtn005.setVal(STRING_LITERAL,StringUtils.stringToSpecChar(unquote(t.image)));
      } finally {
          if (jjtc005) {
            jjtree.closeNodeScope(jjtn005, true);
            jjtreeCloseNodeScope(jjtn005);
          }
      }
      break;
    case BOOLEAN_LITERAL:
      t = jj_consume_token(BOOLEAN_LITERAL);
          CLVFLiteral jjtn006 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc006 = true;
          jjtree.openNodeScope(jjtn006);
          jjtreeOpenNodeScope(jjtn006);
      try {
          jjtree.closeNodeScope(jjtn006, true);
          jjtc006 = false;
          jjtreeCloseNodeScope(jjtn006);
          jjtn006.setVal(BOOLEAN_LITERAL,t.image);
      } finally {
          if (jjtc006) {
            jjtree.closeNodeScope(jjtn006, true);
            jjtreeCloseNodeScope(jjtn006);
          }
      }
      break;
    case DATE_LITERAL:
      t = jj_consume_token(DATE_LITERAL);
          CLVFLiteral jjtn007 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc007 = true;
          jjtree.openNodeScope(jjtn007);
          jjtreeOpenNodeScope(jjtn007);
      try {
          jjtree.closeNodeScope(jjtn007, true);
          jjtc007 = false;
          jjtreeCloseNodeScope(jjtn007);
          jjtn007.setVal(DATE_LITERAL,t.image);
      } finally {
          if (jjtc007) {
            jjtree.closeNodeScope(jjtn007, true);
            jjtreeCloseNodeScope(jjtn007);
          }
      }
      break;
    case DATETIME_LITERAL:
      t = jj_consume_token(DATETIME_LITERAL);
          CLVFLiteral jjtn008 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc008 = true;
          jjtree.openNodeScope(jjtn008);
          jjtreeOpenNodeScope(jjtn008);
      try {
          jjtree.closeNodeScope(jjtn008, true);
          jjtc008 = false;
          jjtreeCloseNodeScope(jjtn008);
          jjtn008.setVal(DATETIME_LITERAL,t.image);
      } finally {
          if (jjtc008) {
            jjtree.closeNodeScope(jjtn008, true);
            jjtreeCloseNodeScope(jjtn008);
          }
      }
      break;
    case NULL_LITERAL:
      t = jj_consume_token(NULL_LITERAL);
          CLVFLiteral jjtn009 = new CLVFLiteral(this, JJTLITERAL);
          boolean jjtc009 = true;
          jjtree.openNodeScope(jjtn009);
          jjtreeOpenNodeScope(jjtn009);
      try {
          jjtree.closeNodeScope(jjtn009, true);
          jjtc009 = false;
          jjtreeCloseNodeScope(jjtn009);
          jjtn009.setVal(NULL_LITERAL,t.image);
      } finally {
          if (jjtc009) {
            jjtree.closeNodeScope(jjtn009, true);
            jjtreeCloseNodeScope(jjtn009);
          }
      }
      break;
    case UNTERMINATED_STRING_LITERAL:
      t = jj_consume_token(UNTERMINATED_STRING_LITERAL);
       {if (true) throw new ParseException(t,"unterminated string literal");}
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void InputFieldExp() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FIELD_ID:
      t = jj_consume_token(FIELD_ID);
                   CLVFInputFieldLiteral jjtn001 = new CLVFInputFieldLiteral(this, JJTINPUTFIELDLITERAL);
                   boolean jjtc001 = true;
                   jjtree.openNodeScope(jjtn001);
                   jjtreeOpenNodeScope(jjtn001);
      try {
                   jjtree.closeNodeScope(jjtn001, true);
                   jjtc001 = false;
                   jjtreeCloseNodeScope(jjtn001);
                   jjtn001.setFieldName(t.image);
      } finally {
                   if (jjtc001) {
                     jjtree.closeNodeScope(jjtn001, true);
                     jjtreeCloseNodeScope(jjtn001);
                   }
      }
      break;
    case REC_NAME_FIELD_ID:
      t = jj_consume_token(REC_NAME_FIELD_ID);
                              CLVFInputFieldLiteral jjtn002 = new CLVFInputFieldLiteral(this, JJTINPUTFIELDLITERAL);
                              boolean jjtc002 = true;
                              jjtree.openNodeScope(jjtn002);
                              jjtreeOpenNodeScope(jjtn002);
      try {
                              jjtree.closeNodeScope(jjtn002, true);
                              jjtc002 = false;
                              jjtreeCloseNodeScope(jjtn002);
                              jjtn002.setRecordFieldName(t.image);
      } finally {
                              if (jjtc002) {
                                jjtree.closeNodeScope(jjtn002, true);
                                jjtreeCloseNodeScope(jjtn002);
                              }
      }
      break;
    case REC_NUM_FIELD_ID:
      t = jj_consume_token(REC_NUM_FIELD_ID);
                             CLVFInputFieldLiteral jjtn003 = new CLVFInputFieldLiteral(this, JJTINPUTFIELDLITERAL);
                             boolean jjtc003 = true;
                             jjtree.openNodeScope(jjtn003);
                             jjtreeOpenNodeScope(jjtn003);
      try {
                             jjtree.closeNodeScope(jjtn003, true);
                             jjtc003 = false;
                             jjtreeCloseNodeScope(jjtn003);
                             jjtn003.setRecordNumFieldName(t.image);
      } finally {
                             if (jjtc003) {
                               jjtree.closeNodeScope(jjtn003, true);
                               jjtreeCloseNodeScope(jjtn003);
                             }
      }
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
void OutputFieldExp() #void :// IDExp -> ID
{
  Token t;
}
{
  t = <FIELD_ID> { jjtThis.setFieldName(t.image); } #OutputFieldLiteral
  | t = <REC_NAME_FIELD_ID> { jjtThis.setRecordFieldName(t.image); } #OutputFieldLiteral
  | t = <REC_NUM_FIELD_ID> { jjtThis.setRecordNumFieldName(t.image); } #OutputFieldLiteral
}
*/
  final public void VarExp() throws ParseException {
 /*@bgen(jjtree) VariableLiteral */
        CLVFVariableLiteral jjtn000 = new CLVFVariableLiteral(this, JJTVARIABLELITERAL);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t,u;
        int varSlot;
        int varType;
    try {
      try {
        // primitive type
          t = jj_consume_token(IDENTIFIER);
                // first, look for local var reference
                if (parserHelper.inFunctionDeclaration &&
                                (varSlot=parserHelper.getLocalVariableSlot(t.image))>=0){
                        jjtn000.setLocalVariale(true);
                        varType=parserHelper.getLocalVariableType(t.image);
                }else{
                if ((varSlot=parserHelper.getGlobalVariableSlot(t.image))<0){
                                {if (true) throw new ParseException(t,"variable ["+t.image+"] is not declared");}
                }
                jjtn000.setLocalVariale(false);
                varType=parserHelper.getGlobalVariableType(t.image);
                }
        jjtn000.setVarSlot(varSlot);
        jjtn000.setVarName(t.image);
        jjtn000.setVarType(varType);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 102:
          jj_consume_token(102);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case INTEGER_LITERAL:
          case HEX_LITERAL:
          case OCTAL_LITERAL:
          case FLOATING_POINT_LITERAL:
          case STRING_LITERAL:
          case UNTERMINATED_STRING_LITERAL:
          case BOOLEAN_LITERAL:
          case DATE_LITERAL:
          case DATETIME_LITERAL:
          case NULL_LITERAL:
          case NOT:
          case MINUS:
          case PLUS:
          case INCR:
          case DECR:
          case TILDA:
          case FIELD_ID:
          case REC_NAME_FIELD_ID:
          case REC_NUM_FIELD_ID:
          case OPEN_PAR:
          case INT_VAR:
          case LONG_VAR:
          case DATE_VAR:
          case DOUBLE_VAR:
          case DECIMAL_VAR:
          case BOOLEAN_VAR:
          case STRING_VAR:
          case BYTE_VAR:
          case LIST_VAR:
          case MAP_VAR:
          case RECORD_VAR:
          case OBJECT_VAR:
          case YEAR:
          case MONTH:
          case WEEK:
          case DAY:
          case HOUR:
          case MINUTE:
          case SECOND:
          case MILLISEC:
          case 104:
          case 105:
          case 106:
          case 107:
          case 108:
          case 109:
          case 110:
          case 111:
          case 118:
          case 122:
          case 124:
          case 125:
          case 126:
          case IDENTIFIER:
            AdditiveExpression();
                                       jjtn000.indexSet=true;
            break;
          default:
            jj_la1[36] = jj_gen;
            ;
          }
          jj_consume_token(103);
                                                                      jjtn000.usedIndex=true;
          break;
        default:
          jj_la1[37] = jj_gen;
          ;
        }
      } catch (ParseException e) {
                parseExceptions.add(e);
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void RegexLiteral() throws ParseException {
        Token t;
    t = jj_consume_token(STRING_LITERAL);
                       CLVFRegexLiteral jjtn001 = new CLVFRegexLiteral(this, JJTREGEXLITERAL);
                       boolean jjtc001 = true;
                       jjtree.openNodeScope(jjtn001);
                       jjtreeOpenNodeScope(jjtn001);
    try {
                       jjtree.closeNodeScope(jjtn001, true);
                       jjtc001 = false;
                       jjtreeCloseNodeScope(jjtn001);
                       jjtn001.setRegex(t.image);
    } finally {
                       if (jjtc001) {
                         jjtree.closeNodeScope(jjtn001, true);
                         jjtreeCloseNodeScope(jjtn001);
                       }
    }
  }

  final public void SymbolNameExp() throws ParseException {
 /*@bgen(jjtree) SymbolNameExp */
  CLVFSymbolNameExp jjtn000 = new CLVFSymbolNameExp(this, JJTSYMBOLNAMEEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT_VAR:
        jj_consume_token(INT_VAR);
        break;
      case LONG_VAR:
        jj_consume_token(LONG_VAR);
        break;
      case DATE_VAR:
        jj_consume_token(DATE_VAR);
        break;
      case DOUBLE_VAR:
        jj_consume_token(DOUBLE_VAR);
        break;
      case DECIMAL_VAR:
        jj_consume_token(DECIMAL_VAR);
        break;
      case BOOLEAN_VAR:
        jj_consume_token(BOOLEAN_VAR);
        break;
      case STRING_VAR:
        jj_consume_token(STRING_VAR);
        break;
      case BYTE_VAR:
        jj_consume_token(BYTE_VAR);
        break;
      case LIST_VAR:
        jj_consume_token(LIST_VAR);
        break;
      case MAP_VAR:
        jj_consume_token(MAP_VAR);
        break;
      case RECORD_VAR:
        jj_consume_token(RECORD_VAR);
        break;
      case OBJECT_VAR:
        jj_consume_token(OBJECT_VAR);
        break;
      case YEAR:
        jj_consume_token(YEAR);
        break;
      case MONTH:
        jj_consume_token(MONTH);
        break;
      case WEEK:
        jj_consume_token(WEEK);
        break;
      case DAY:
        jj_consume_token(DAY);
        break;
      case HOUR:
        jj_consume_token(HOUR);
        break;
      case MINUTE:
        jj_consume_token(MINUTE);
        break;
      case SECOND:
        jj_consume_token(SECOND);
        break;
      case MILLISEC:
        jj_consume_token(MILLISEC);
        break;
      default:
        jj_la1[38] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtreeCloseNodeScope(jjtn000);
                jjtn000.setType(getToken(0).kind);
    } finally {
   if (jjtc000) {
     jjtree.closeNodeScope(jjtn000, true);
     jjtreeCloseNodeScope(jjtn000);
   }
    }
  }

/*
 * Statement syntax follows.
 */
  final public void Statement() throws ParseException {
  Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        jj_consume_token(SEMICOLON);
        break;
      case 98:
        Block();
        break;
      case IF:
        IfStatement();
        break;
      case SWITCH:
        SwitchStatement();
        break;
      case WHILE:
        WhileStatement();
        break;
      case FOR:
        ForStatement();
        break;
      case FOR_EACH:
        ForeachStatement();
        break;
      case DO:
        DoStatement();
        break;
      case BREAK:
        BreakStatement();
        break;
      case CONTINUE:
        ContinueStatement();
        break;
      case RETURN:
        ReturnStatement();
        break;
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        StatementExpression();
        break;
      default:
        jj_la1[39] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (ParseException e) {
                parseExceptions.add(e);

// following code causes strange behaviour in case of certain bugs
// let's put some cap on interations
//	int i=0;
//    do {
//      t = getNextToken();
//      i++;
//    } while (t.kind != SEMICOLON || t.kind != EOF || i < 99);

    }
  }

/*
* void LabeledStatement() #void :
* {}
*  {
*    <IDENTIFIER> ":" Statement()
*  }
*/
  final public void Block() throws ParseException {
 /*@bgen(jjtree) Block */
  CLVFBlock jjtn000 = new CLVFBlock(this, JJTBLOCK);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(98);
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEMICOLON:
        case BREAK:
        case CONTINUE:
        case FOR:
        case FOR_EACH:
        case IF:
        case RETURN:
        case WHILE:
        case SWITCH:
        case DO:
        case 98:
        case 104:
        case 105:
        case 106:
        case 107:
        case 108:
        case 109:
        case 110:
        case 111:
        case 118:
        case 122:
        case 124:
        case 125:
        case 126:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[40] = jj_gen;
          break label_15;
        }
        Statement();
      }
      jj_consume_token(99);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void StatementExpression() throws ParseException {
    if (jj_2_4(2147483647)) {
      Assignment();
    } else if (jj_2_5(2)) {
      IncrDecrStatement();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        FunctionCall();
        break;
      default:
        jj_la1[41] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(SEMICOLON);
  }

  final public void IncrDecrStatement() throws ParseException {
 /*@bgen(jjtree) #IncrDecrStatement(true) */
 CLVFIncrDecrStatement jjtn000 = new CLVFIncrDecrStatement(this, JJTINCRDECRSTATEMENT);
 boolean jjtc000 = true;
 jjtree.openNodeScope(jjtn000);
 jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      VarExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        t = jj_consume_token(INCR);
        break;
      case DECR:
        t = jj_consume_token(DECR);
        break;
      default:
        jj_la1[42] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                           jjtree.closeNodeScope(jjtn000, true);
                                           jjtc000 = false;
                                           jjtreeCloseNodeScope(jjtn000);
                                          jjtn000.setKind(t.kind);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void IfStatement() throws ParseException {
 /*@bgen(jjtree) IfStatement */
  CLVFIfStatement jjtn000 = new CLVFIfStatement(this, JJTIFSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(IF);
      jj_consume_token(OPEN_PAR);
      Expression();
      jj_consume_token(CLOSE_PAR);
      Statement();
      if (jj_2_6(2)) {
        jj_consume_token(ELSE);
        Statement();
      } else {
        ;
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void SwitchStatement() throws ParseException {
 /*@bgen(jjtree) SwitchStatement */
  CLVFSwitchStatement jjtn000 = new CLVFSwitchStatement(this, JJTSWITCHSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(SWITCH);
      jj_consume_token(OPEN_PAR);
      Expression();
      jj_consume_token(CLOSE_PAR);
      jj_consume_token(98);
      CaseExpression();
      label_16:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CASE:
          ;
          break;
        default:
          jj_la1[43] = jj_gen;
          break label_16;
        }
        CaseExpression();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASE_DEFAULT:
        jj_consume_token(CASE_DEFAULT);
        jj_consume_token(101);
        Statement();
                                                         jjtn000.setDefaultClause(true);
        break;
      default:
        jj_la1[44] = jj_gen;
        ;
      }
      jj_consume_token(99);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void CaseExpression() throws ParseException {
 /*@bgen(jjtree) CaseExpression */
  CLVFCaseExpression jjtn000 = new CLVFCaseExpression(this, JJTCASEEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(CASE);
      Expression();
      jj_consume_token(101);
      Statement();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void WhileStatement() throws ParseException {
 /*@bgen(jjtree) WhileStatement */
  CLVFWhileStatement jjtn000 = new CLVFWhileStatement(this, JJTWHILESTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(WHILE);
      jj_consume_token(OPEN_PAR);
      Expression();
      jj_consume_token(CLOSE_PAR);
      Statement();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void ForStatement() throws ParseException {
 /*@bgen(jjtree) ForStatement */
  CLVFForStatement jjtn000 = new CLVFForStatement(this, JJTFORSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(FOR);
      jj_consume_token(OPEN_PAR);
      Expression();
      jj_consume_token(SEMICOLON);
      Expression();
      jj_consume_token(SEMICOLON);
      Expression();
      jj_consume_token(CLOSE_PAR);
      Statement();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void ForeachStatement() throws ParseException {
 /*@bgen(jjtree) ForeachStatement */
        CLVFForeachStatement jjtn000 = new CLVFForeachStatement(this, JJTFOREACHSTATEMENT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(FOR_EACH);
      jj_consume_token(OPEN_PAR);
      VarExp();
      jj_consume_token(101);
      VarExp();
      jj_consume_token(CLOSE_PAR);
      Statement();
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void DoStatement() throws ParseException {
 /*@bgen(jjtree) #DoStatement( 2) */
  CLVFDoStatement jjtn000 = new CLVFDoStatement(this, JJTDOSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(DO);
      Statement();
      jj_consume_token(WHILE);
      jj_consume_token(OPEN_PAR);
      Expression();
      jj_consume_token(CLOSE_PAR);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000,  2);
      jjtreeCloseNodeScope(jjtn000);
    }
    }
  }

  final public void BreakStatement() throws ParseException {
 /*@bgen(jjtree) BreakStatement */
  CLVFBreakStatement jjtn000 = new CLVFBreakStatement(this, JJTBREAKSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(BREAK);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void ContinueStatement() throws ParseException {
 /*@bgen(jjtree) ContinueStatement */
  CLVFContinueStatement jjtn000 = new CLVFContinueStatement(this, JJTCONTINUESTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(CONTINUE);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void ReturnStatement() throws ParseException {
                          /*@bgen(jjtree) ReturnStatement */
  CLVFReturnStatement jjtn000 = new CLVFReturnStatement(this, JJTRETURNSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);
    try {
      jj_consume_token(RETURN);
      if (jj_2_7(2)) {
        Expression();
      } else {
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
  }

  final public void FunctionCallStatement() throws ParseException {
 /*@bgen(jjtree) FunctionCallStatement */
  CLVFFunctionCallStatement jjtn000 = new CLVFFunctionCallStatement(this, JJTFUNCTIONCALLSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t;
  CLVFFunctionDeclaration functionNode;
    try {
      t = jj_consume_token(IDENTIFIER);
                jjtn000.setName( t.image);
                // is it already declared function ??
                if ((functionNode=(CLVFFunctionDeclaration)parserHelper.functionSymbol.get(t.image))!=null){
                                        jjtn000.setCallNode(functionNode);
                }else if (parserHelper.isExternalFunction(t.image)){
                                        jjtn000.setExternalFunction(parserHelper.getExternalFunction(t.image));
                }else{
                        {if (true) throw new ParseException(t,"function \""+t.image+"\" not declared");}
                }
      jj_consume_token(OPEN_PAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case HEX_LITERAL:
      case OCTAL_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case UNTERMINATED_STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case DATE_LITERAL:
      case DATETIME_LITERAL:
      case NULL_LITERAL:
      case NOT:
      case MINUS:
      case PLUS:
      case INCR:
      case DECR:
      case TILDA:
      case FIELD_ID:
      case REC_NAME_FIELD_ID:
      case REC_NUM_FIELD_ID:
      case OPEN_PAR:
      case INT_VAR:
      case LONG_VAR:
      case DATE_VAR:
      case DOUBLE_VAR:
      case DECIMAL_VAR:
      case BOOLEAN_VAR:
      case STRING_VAR:
      case BYTE_VAR:
      case LIST_VAR:
      case MAP_VAR:
      case RECORD_VAR:
      case OBJECT_VAR:
      case YEAR:
      case MONTH:
      case WEEK:
      case DAY:
      case HOUR:
      case MINUTE:
      case SECOND:
      case MILLISEC:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 111:
      case 118:
      case 122:
      case 124:
      case 125:
      case 126:
      case IDENTIFIER:
        FunctionCallParameter();
        break;
      default:
        jj_la1[45] = jj_gen;
        ;
      }
      label_17:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 97:
          ;
          break;
        default:
          jj_la1[46] = jj_gen;
          break label_17;
        }
        jj_consume_token(97);
        FunctionCallParameter();
      }
      jj_consume_token(CLOSE_PAR);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtreeCloseNodeScope(jjtn000);
         // verify number of call parameters
                if (!jjtn000.validateParams()){
                        //System.err.println("wrong #arguments");
                        {if (true) throw new ParseException(t,"wrong number of parameters when calling \""+t.image+"\"");}
                }
    } catch (Throwable jjte000) {
           if (jjtc000) {
             jjtree.clearNodeScope(jjtn000);
             jjtc000 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte000 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte000;}
           }
           if (jjte000 instanceof ParseException) {
             {if (true) throw (ParseException)jjte000;}
           }
           {if (true) throw (Error)jjte000;}
    } finally {
           if (jjtc000) {
             jjtree.closeNodeScope(jjtn000, true);
             jjtreeCloseNodeScope(jjtn000);
           }
    }
  }

  final public void FunctionCallParameter() throws ParseException {
    ConditionalOrExpression();
  }

/* !!!! INTERNAL FUNCTIONS && PROCEDURES START HERE !!!! */
  final public void BuildInFunction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 104:
      jj_consume_token(104);
      jj_consume_token(OPEN_PAR);
      AdditiveExpression();
                                            CLVFIsNullNode jjtn001 = new CLVFIsNullNode(this, JJTISNULLNODE);
                                            boolean jjtc001 = true;
                                            jjtree.openNodeScope(jjtn001);
                                            jjtreeOpenNodeScope(jjtn001);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                                            if (jjtc001) {
                                              jjtree.closeNodeScope(jjtn001,  1);
                                              jjtreeCloseNodeScope(jjtn001);
                                            }
      }
      break;
    case 105:
      jj_consume_token(105);
      jj_consume_token(OPEN_PAR);
      AdditiveExpression();
      jj_consume_token(97);
      AdditiveExpression();
                                                                   CLVFNVLNode jjtn002 = new CLVFNVLNode(this, JJTNVLNODE);
                                                                   boolean jjtc002 = true;
                                                                   jjtree.openNodeScope(jjtn002);
                                                                   jjtreeOpenNodeScope(jjtn002);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                                                                   if (jjtc002) {
                                                                     jjtree.closeNodeScope(jjtn002,  2);
                                                                     jjtreeCloseNodeScope(jjtn002);
                                                                   }
      }
      break;
    case 106:
      jj_consume_token(106);
      jj_consume_token(OPEN_PAR);
      ConditionalOrExpression();
      jj_consume_token(97);
      AdditiveExpression();
      jj_consume_token(97);
      AdditiveExpression();
                                                                                                 CLVFIffNode jjtn003 = new CLVFIffNode(this, JJTIFFNODE);
                                                                                                 boolean jjtc003 = true;
                                                                                                 jjtree.openNodeScope(jjtn003);
                                                                                                 jjtreeOpenNodeScope(jjtn003);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                                                                                                 if (jjtc003) {
                                                                                                   jjtree.closeNodeScope(jjtn003,  3);
                                                                                                   jjtreeCloseNodeScope(jjtn003);
                                                                                                 }
      }
      break;
    case 118:
      SequenceNode();
      break;
    case 122:
    case 124:
    case 125:
    case 126:
      LookupNode();
      break;
    case 110:
      PrintErrNode();
      break;
    case 107:
      jj_consume_token(107);
      jj_consume_token(OPEN_PAR);
                             CLVFPrintStackNode jjtn004 = new CLVFPrintStackNode(this, JJTPRINTSTACKNODE);
                             boolean jjtc004 = true;
                             jjtree.openNodeScope(jjtn004);
                             jjtreeOpenNodeScope(jjtn004);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                             if (jjtc004) {
                               jjtree.closeNodeScope(jjtn004,  0);
                               jjtreeCloseNodeScope(jjtn004);
                             }
      }
      break;
    case 108:
      jj_consume_token(108);
      jj_consume_token(OPEN_PAR);
                            CLVFBreakpointNode jjtn005 = new CLVFBreakpointNode(this, JJTBREAKPOINTNODE);
                            boolean jjtc005 = true;
                            jjtree.openNodeScope(jjtn005);
                            jjtreeOpenNodeScope(jjtn005);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                            if (jjtc005) {
                              jjtree.closeNodeScope(jjtn005,  0);
                              jjtreeCloseNodeScope(jjtn005);
                            }
      }
      break;
    case 111:
      PrintLogNode();
      break;
    case 109:
      jj_consume_token(109);
      jj_consume_token(OPEN_PAR);
      AdditiveExpression();
                                                  CLVFRaiseErrorNode jjtn006 = new CLVFRaiseErrorNode(this, JJTRAISEERRORNODE);
                                                  boolean jjtc006 = true;
                                                  jjtree.openNodeScope(jjtn006);
                                                  jjtreeOpenNodeScope(jjtn006);
      try {
        jj_consume_token(CLOSE_PAR);
      } finally {
                                                  if (jjtc006) {
                                                    jjtree.closeNodeScope(jjtn006,  1);
                                                    jjtreeCloseNodeScope(jjtn006);
                                                  }
      }
      break;
    default:
      jj_la1[47] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void PrintErrNode() throws ParseException {
 /*@bgen(jjtree) PrintErrNode */
  CLVFPrintErrNode jjtn000 = new CLVFPrintErrNode(this, JJTPRINTERRNODE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
  jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(110);
      jj_consume_token(OPEN_PAR);
      AdditiveExpression();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 97:
        jj_consume_token(97);
        t = jj_consume_token(BOOLEAN_LITERAL);
                                                                        jjtn000.setPrintLine(Boolean.parseBoolean(t.image));
        break;
      default:
        jj_la1[48] = jj_gen;
        ;
      }
      jj_consume_token(CLOSE_PAR);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void PrintLogNode() throws ParseException {
 /*@bgen(jjtree) PrintLogNode */
        CLVFPrintLogNode jjtn000 = new CLVFPrintLogNode(this, JJTPRINTLOGNODE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(111);
      jj_consume_token(OPEN_PAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 112:
        jj_consume_token(112);
                   jjtn000.setLevel(0);
        break;
      case 113:
        jj_consume_token(113);
                    jjtn000.setLevel(1);
        break;
      case 114:
        jj_consume_token(114);
                   jjtn000.setLevel(2);
        break;
      case 115:
        jj_consume_token(115);
                   jjtn000.setLevel(3);
        break;
      case 116:
        jj_consume_token(116);
                    jjtn000.setLevel(4);
        break;
      case 117:
        jj_consume_token(117);
                    jjtn000.setLevel(5);
        break;
      default:
        jj_la1[49] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(97);
      AdditiveExpression();
      jj_consume_token(CLOSE_PAR);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void SequenceNode() throws ParseException {
 /*@bgen(jjtree) SequenceNode */
        CLVFSequenceNode jjtn000 = new CLVFSequenceNode(this, JJTSEQUENCENODE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(118);
      jj_consume_token(OPEN_PAR);
      t = jj_consume_token(IDENTIFIER);
                         jjtn000.setName(t.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 97:
        jj_consume_token(97);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT_VAR:
          jj_consume_token(INT_VAR);
                       jjtn000.setReturnType(INT_VAR);
          break;
        case LONG_VAR:
          jj_consume_token(LONG_VAR);
                        jjtn000.setReturnType(LONG_VAR);
          break;
        case STRING_VAR:
          jj_consume_token(STRING_VAR);
                         jjtn000.setReturnType(STRING_VAR);
          break;
        default:
          jj_la1[50] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[51] = jj_gen;
        ;
      }
      jj_consume_token(CLOSE_PAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 119:
      case 120:
      case 121:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 119:
          jj_consume_token(119);
                                  jjtn000.setOperation(0);
          break;
        case 120:
          jj_consume_token(120);
                         jjtn000.setOperation(1);
          break;
        case 121:
          jj_consume_token(121);
                       jjtn000.setOperation(2);
          break;
        default:
          jj_la1[52] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[53] = jj_gen;
        ;
      }
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void LookupNode() throws ParseException {
 /*@bgen(jjtree) LookupNode */
        CLVFLookupNode jjtn000 = new CLVFLookupNode(this, JJTLOOKUPNODE);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);
        jjtreeOpenNodeScope(jjtn000);Token t,k;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 122:
        jj_consume_token(122);
        jj_consume_token(OPEN_PAR);
        t = jj_consume_token(IDENTIFIER);
                                 jjtn000.setOperation(0); jjtn000.setLookupName(t.image);
        jj_consume_token(97);
        AdditiveExpression();
        label_18:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 97:
            ;
            break;
          default:
            jj_la1[54] = jj_gen;
            break label_18;
          }
          jj_consume_token(97);
          AdditiveExpression();
        }
        jj_consume_token(CLOSE_PAR);
        jj_consume_token(123);
        k = jj_consume_token(IDENTIFIER);
                                     jjtree.closeNodeScope(jjtn000, true);
                                     jjtc000 = false;
                                     jjtreeCloseNodeScope(jjtn000);
                                     jjtn000.setLookupField(k.image);
        break;
      case 124:
        jj_consume_token(124);
        jj_consume_token(OPEN_PAR);
        t = jj_consume_token(IDENTIFIER);
                                 jjtn000.setOperation(1); jjtn000.setLookupName(t.image);
        jj_consume_token(CLOSE_PAR);
        jj_consume_token(123);
        k = jj_consume_token(IDENTIFIER);
                                         jjtree.closeNodeScope(jjtn000, true);
                                         jjtc000 = false;
                                         jjtreeCloseNodeScope(jjtn000);
                                         jjtn000.setLookupField(k.image);
        break;
      case 125:
        jj_consume_token(125);
        jj_consume_token(OPEN_PAR);
        t = jj_consume_token(IDENTIFIER);
                                 jjtn000.setOperation(2); jjtn000.setLookupName(t.image);
        jj_consume_token(CLOSE_PAR);
        break;
      case 126:
        jj_consume_token(126);
        jj_consume_token(OPEN_PAR);
        t = jj_consume_token(IDENTIFIER);
                                 jjtn000.setLookupName(t.image);
        jj_consume_token(97);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 127:
          jj_consume_token(127);
                                         jjtn000.setOperation(3);
          break;
        case 128:
          jj_consume_token(128);
                                         jjtn000.setOperation(4);
          break;
        default:
          jj_la1[55] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(CLOSE_PAR);
        break;
      default:
        jj_la1[56] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  final private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  final private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  final private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  final private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  final private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  final private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  final private boolean jj_3R_67() {
    if (jj_3R_19()) return true;
    if (jj_scan_token(100)) return true;
    if (jj_3R_68()) return true;
    return false;
  }

  final private boolean jj_3R_75() {
    if (jj_scan_token(126)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(97)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_146()) {
    jj_scanpos = xsp;
    if (jj_3R_147()) return true;
    }
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_58() {
    if (jj_scan_token(SWITCH)) return true;
    return false;
  }

  final private boolean jj_3_1() {
    if (jj_3R_19()) return true;
    if (jj_scan_token(100)) return true;
    return false;
  }

  final private boolean jj_3R_49() {
    if (jj_3R_68()) return true;
    return false;
  }

  final private boolean jj_3R_74() {
    if (jj_scan_token(125)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_145() {
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_73() {
    if (jj_scan_token(124)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    if (jj_scan_token(123)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  final private boolean jj_3R_57() {
    if (jj_scan_token(IF)) return true;
    return false;
  }

  final private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_48()) {
    jj_scanpos = xsp;
    if (jj_3R_49()) return true;
    }
    return false;
  }

  final private boolean jj_3R_48() {
    if (jj_3R_67()) return true;
    return false;
  }

  final private boolean jj_3R_135() {
    if (jj_scan_token(REC_NUM_FIELD_ID)) return true;
    return false;
  }

  final private boolean jj_3R_134() {
    if (jj_scan_token(REC_NAME_FIELD_ID)) return true;
    return false;
  }

  final private boolean jj_3R_22() {
    if (jj_3R_19()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(54)) {
    jj_scanpos = xsp;
    if (jj_scan_token(55)) return true;
    }
    return false;
  }

  final private boolean jj_3R_72() {
    if (jj_scan_token(122)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_145()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(CLOSE_PAR)) return true;
    if (jj_scan_token(123)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  final private boolean jj_3R_133() {
    if (jj_scan_token(FIELD_ID)) return true;
    return false;
  }

  final private boolean jj_3R_122() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_133()) {
    jj_scanpos = xsp;
    if (jj_3R_134()) {
    jj_scanpos = xsp;
    if (jj_3R_135()) return true;
    }
    }
    return false;
  }

  final private boolean jj_3R_53() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_72()) {
    jj_scanpos = xsp;
    if (jj_3R_73()) {
    jj_scanpos = xsp;
    if (jj_3R_74()) {
    jj_scanpos = xsp;
    if (jj_3R_75()) return true;
    }
    }
    }
    return false;
  }

  final private boolean jj_3_4() {
    if (jj_3R_19()) return true;
    if (jj_scan_token(100)) return true;
    return false;
  }

  final private boolean jj_3R_142() {
    if (jj_scan_token(119)) return true;
    return false;
  }

  final private boolean jj_3R_137() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_142()) {
    jj_scanpos = xsp;
    if (jj_3R_143()) {
    jj_scanpos = xsp;
    if (jj_3R_144()) return true;
    }
    }
    return false;
  }

  final private boolean jj_3R_144() {
    if (jj_scan_token(121)) return true;
    return false;
  }

  final private boolean jj_3_5() {
    if (jj_3R_22()) return true;
    return false;
  }

  final private boolean jj_3R_77() {
    if (jj_3R_20()) return true;
    return false;
  }

  final private boolean jj_3R_143() {
    if (jj_scan_token(120)) return true;
    return false;
  }

  final private boolean jj_3R_138() {
    if (jj_scan_token(97)) return true;
    if (jj_scan_token(BOOLEAN_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_132() {
    if (jj_scan_token(UNTERMINATED_STRING_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_76() {
    if (jj_3R_67()) return true;
    return false;
  }

  final private boolean jj_3R_141() {
    if (jj_scan_token(STRING_VAR)) return true;
    return false;
  }

  final private boolean jj_3R_131() {
    if (jj_scan_token(NULL_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_140() {
    if (jj_scan_token(LONG_VAR)) return true;
    return false;
  }

  final private boolean jj_3R_139() {
    if (jj_scan_token(INT_VAR)) return true;
    return false;
  }

  final private boolean jj_3R_130() {
    if (jj_scan_token(DATETIME_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_66() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_76()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3R_77()) return true;
    }
    }
    return false;
  }

  final private boolean jj_3R_136() {
    if (jj_scan_token(97)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_139()) {
    jj_scanpos = xsp;
    if (jj_3R_140()) {
    jj_scanpos = xsp;
    if (jj_3R_141()) return true;
    }
    }
    return false;
  }

  final private boolean jj_3R_129() {
    if (jj_scan_token(DATE_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_128() {
    if (jj_scan_token(BOOLEAN_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_52() {
    if (jj_scan_token(118)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_136()) jj_scanpos = xsp;
    if (jj_scan_token(CLOSE_PAR)) return true;
    xsp = jj_scanpos;
    if (jj_3R_137()) jj_scanpos = xsp;
    return false;
  }

  final private boolean jj_3R_127() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_126() {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_56() {
    if (jj_scan_token(98)) return true;
    return false;
  }

  final private boolean jj_3R_125() {
    if (jj_scan_token(OCTAL_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_124() {
    if (jj_scan_token(HEX_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_123() {
    if (jj_scan_token(FLOATING_POINT_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_121() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_123()) {
    jj_scanpos = xsp;
    if (jj_3R_124()) {
    jj_scanpos = xsp;
    if (jj_3R_125()) {
    jj_scanpos = xsp;
    if (jj_3R_126()) {
    jj_scanpos = xsp;
    if (jj_3R_127()) {
    jj_scanpos = xsp;
    if (jj_3R_128()) {
    jj_scanpos = xsp;
    if (jj_3R_129()) {
    jj_scanpos = xsp;
    if (jj_3R_130()) {
    jj_scanpos = xsp;
    if (jj_3R_131()) {
    jj_scanpos = xsp;
    if (jj_3R_132()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_26() {
    if (jj_3R_51()) return true;
    return false;
  }

  final private boolean jj_3R_94() {
    if (jj_scan_token(117)) return true;
    return false;
  }

  final private boolean jj_3R_93() {
    if (jj_scan_token(116)) return true;
    return false;
  }

  final private boolean jj_3R_92() {
    if (jj_scan_token(115)) return true;
    return false;
  }

  final private boolean jj_3_3() {
    if (jj_3R_21()) return true;
    return false;
  }

  final private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) return true;
    }
    return false;
  }

  final private boolean jj_3R_91() {
    if (jj_scan_token(114)) return true;
    return false;
  }

  final private boolean jj_3R_90() {
    if (jj_scan_token(113)) return true;
    return false;
  }

  final private boolean jj_3R_47() {
    if (jj_3R_66()) return true;
    return false;
  }

  final private boolean jj_3R_46() {
    if (jj_3R_65()) return true;
    return false;
  }

  final private boolean jj_3R_89() {
    if (jj_scan_token(112)) return true;
    return false;
  }

  final private boolean jj_3R_45() {
    if (jj_3R_64()) return true;
    return false;
  }

  final private boolean jj_3R_116() {
    if (jj_3R_19()) return true;
    return false;
  }

  final private boolean jj_3R_44() {
    if (jj_3R_63()) return true;
    return false;
  }

  final private boolean jj_3R_114() {
    if (jj_3R_120()) return true;
    return false;
  }

  final private boolean jj_3R_55() {
    if (jj_scan_token(111)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_89()) {
    jj_scanpos = xsp;
    if (jj_3R_90()) {
    jj_scanpos = xsp;
    if (jj_3R_91()) {
    jj_scanpos = xsp;
    if (jj_3R_92()) {
    jj_scanpos = xsp;
    if (jj_3R_93()) {
    jj_scanpos = xsp;
    if (jj_3R_94()) return true;
    }
    }
    }
    }
    }
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_118() {
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_24()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_117() {
    if (jj_3R_122()) return true;
    return false;
  }

  final private boolean jj_3R_98() {
    if (jj_3R_106()) return true;
    if (jj_3R_85()) return true;
    return false;
  }

  final private boolean jj_3R_43() {
    if (jj_3R_62()) return true;
    return false;
  }

  final private boolean jj_3R_112() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_114()) {
    jj_scanpos = xsp;
    if (jj_3R_115()) {
    jj_scanpos = xsp;
    if (jj_3R_116()) {
    jj_scanpos = xsp;
    if (jj_3R_117()) {
    jj_scanpos = xsp;
    if (jj_3R_118()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3_2() {
    if (jj_3R_20()) return true;
    return false;
  }

  final private boolean jj_3R_115() {
    if (jj_3R_121()) return true;
    return false;
  }

  final private boolean jj_3R_42() {
    if (jj_3R_61()) return true;
    return false;
  }

  final private boolean jj_3R_41() {
    if (jj_3R_60()) return true;
    return false;
  }

  final private boolean jj_3R_113() {
    if (jj_3R_119()) return true;
    return false;
  }

  final private boolean jj_3R_40() {
    if (jj_3R_59()) return true;
    return false;
  }

  final private boolean jj_3R_54() {
    if (jj_scan_token(110)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_69()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_138()) jj_scanpos = xsp;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_97() {
    if (jj_3R_105()) return true;
    return false;
  }

  final private boolean jj_3R_39() {
    if (jj_3R_58()) return true;
    return false;
  }

  final private boolean jj_3R_85() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_97()) {
    jj_scanpos = xsp;
    if (jj_3R_98()) return true;
    }
    return false;
  }

  final private boolean jj_3R_38() {
    if (jj_3R_57()) return true;
    return false;
  }

  final private boolean jj_3R_37() {
    if (jj_3R_56()) return true;
    return false;
  }

  final private boolean jj_3R_36() {
    if (jj_scan_token(109)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_35() {
    if (jj_3R_55()) return true;
    return false;
  }

  final private boolean jj_3R_71() {
    if (jj_scan_token(97)) return true;
    if (jj_3R_82()) return true;
    return false;
  }

  final private boolean jj_3R_34() {
    if (jj_scan_token(108)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_33() {
    if (jj_scan_token(107)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_32() {
    if (jj_3R_54()) return true;
    return false;
  }

  final private boolean jj_3R_31() {
    if (jj_3R_53()) return true;
    return false;
  }

  final private boolean jj_3R_30() {
    if (jj_3R_52()) return true;
    return false;
  }

  final private boolean jj_3R_29() {
    if (jj_scan_token(106)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_68()) return true;
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_28() {
    if (jj_scan_token(105)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(97)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_106() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(54)) {
    jj_scanpos = xsp;
    if (jj_scan_token(55)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(56)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) return true;
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) {
    jj_scanpos = xsp;
    if (jj_3R_35()) {
    jj_scanpos = xsp;
    if (jj_3R_36()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_27() {
    if (jj_scan_token(104)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_69()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_105() {
    if (jj_3R_112()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_113()) jj_scanpos = xsp;
    return false;
  }

  final private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_3R_37()) {
    jj_scanpos = xsp;
    if (jj_3R_38()) {
    jj_scanpos = xsp;
    if (jj_3R_39()) {
    jj_scanpos = xsp;
    if (jj_3R_40()) {
    jj_scanpos = xsp;
    if (jj_3R_41()) {
    jj_scanpos = xsp;
    if (jj_3R_42()) {
    jj_scanpos = xsp;
    if (jj_3R_43()) {
    jj_scanpos = xsp;
    if (jj_3R_44()) {
    jj_scanpos = xsp;
    if (jj_3R_45()) {
    jj_scanpos = xsp;
    if (jj_3R_46()) {
    jj_scanpos = xsp;
    if (jj_3R_47()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_82() {
    if (jj_3R_68()) return true;
    return false;
  }

  final private boolean jj_3R_70() {
    if (jj_3R_82()) return true;
    return false;
  }

  final private boolean jj_3R_119() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(54)) {
    jj_scanpos = xsp;
    if (jj_scan_token(55)) return true;
    }
    return false;
  }

  final private boolean jj_3R_101() {
    if (jj_scan_token(MODULO)) return true;
    if (jj_3R_85()) return true;
    return false;
  }

  final private boolean jj_3R_100() {
    if (jj_scan_token(DIVIDE)) return true;
    if (jj_3R_85()) return true;
    return false;
  }

  final private boolean jj_3R_99() {
    if (jj_scan_token(MULTIPLY)) return true;
    if (jj_3R_85()) return true;
    return false;
  }

  final private boolean jj_3R_86() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_99()) {
    jj_scanpos = xsp;
    if (jj_3R_100()) {
    jj_scanpos = xsp;
    if (jj_3R_101()) return true;
    }
    }
    return false;
  }

  final private boolean jj_3R_80() {
    if (jj_3R_85()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_86()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_51() {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_70()) jj_scanpos = xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_71()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  final private boolean jj_3R_88() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_80()) return true;
    return false;
  }

  final private boolean jj_3_7() {
    if (jj_3R_24()) return true;
    return false;
  }

  final private boolean jj_3R_87() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_80()) return true;
    return false;
  }

  final private boolean jj_3R_81() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_87()) {
    jj_scanpos = xsp;
    if (jj_3R_88()) return true;
    }
    return false;
  }

  final private boolean jj_3R_111() {
    if (jj_scan_token(REGEX_EQUAL)) return true;
    if (jj_3R_148()) return true;
    return false;
  }

  final private boolean jj_3R_69() {
    if (jj_3R_80()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_81()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_120() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(62)) {
    jj_scanpos = xsp;
    if (jj_scan_token(63)) {
    jj_scanpos = xsp;
    if (jj_scan_token(64)) {
    jj_scanpos = xsp;
    if (jj_scan_token(65)) {
    jj_scanpos = xsp;
    if (jj_scan_token(66)) {
    jj_scanpos = xsp;
    if (jj_scan_token(67)) {
    jj_scanpos = xsp;
    if (jj_scan_token(68)) {
    jj_scanpos = xsp;
    if (jj_scan_token(69)) {
    jj_scanpos = xsp;
    if (jj_scan_token(70)) {
    jj_scanpos = xsp;
    if (jj_scan_token(71)) {
    jj_scanpos = xsp;
    if (jj_scan_token(72)) {
    jj_scanpos = xsp;
    if (jj_scan_token(73)) {
    jj_scanpos = xsp;
    if (jj_scan_token(89)) {
    jj_scanpos = xsp;
    if (jj_scan_token(90)) {
    jj_scanpos = xsp;
    if (jj_scan_token(91)) {
    jj_scanpos = xsp;
    if (jj_scan_token(92)) {
    jj_scanpos = xsp;
    if (jj_scan_token(93)) {
    jj_scanpos = xsp;
    if (jj_scan_token(94)) {
    jj_scanpos = xsp;
    if (jj_scan_token(95)) {
    jj_scanpos = xsp;
    if (jj_scan_token(96)) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_65() {
    if (jj_scan_token(RETURN)) return true;
    return false;
  }

  final private boolean jj_3R_64() {
    if (jj_scan_token(CONTINUE)) return true;
    return false;
  }

  final private boolean jj_3R_110() {
    if (jj_scan_token(GREATER_THAN_EQUAL)) return true;
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_109() {
    if (jj_scan_token(LESS_THAN_EQUAL)) return true;
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_148() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  final private boolean jj_3R_108() {
    if (jj_scan_token(GREATER_THAN)) return true;
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_63() {
    if (jj_scan_token(BREAK)) return true;
    return false;
  }

  final private boolean jj_3R_107() {
    if (jj_scan_token(LESS_THAN)) return true;
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_102() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_107()) {
    jj_scanpos = xsp;
    if (jj_3R_108()) {
    jj_scanpos = xsp;
    if (jj_3R_109()) {
    jj_scanpos = xsp;
    if (jj_3R_110()) {
    jj_scanpos = xsp;
    if (jj_3R_111()) return true;
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_95() {
    if (jj_3R_69()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_102()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_50() {
    if (jj_3R_69()) return true;
    return false;
  }

  final private boolean jj_3R_104() {
    if (jj_scan_token(NON_EQUAL)) return true;
    if (jj_3R_95()) return true;
    return false;
  }

  final private boolean jj_3R_25() {
    if (jj_scan_token(102)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_50()) jj_scanpos = xsp;
    if (jj_scan_token(103)) return true;
    return false;
  }

  final private boolean jj_3R_103() {
    if (jj_scan_token(EQUAL)) return true;
    if (jj_3R_95()) return true;
    return false;
  }

  final private boolean jj_3R_96() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_103()) {
    jj_scanpos = xsp;
    if (jj_3R_104()) return true;
    }
    return false;
  }

  final private boolean jj_3R_61() {
    if (jj_scan_token(FOR_EACH)) return true;
    return false;
  }

  final private boolean jj_3R_62() {
    if (jj_scan_token(DO)) return true;
    return false;
  }

  final private boolean jj_3R_83() {
    if (jj_3R_95()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_96()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_84() {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_83()) return true;
    return false;
  }

  final private boolean jj_3_6() {
    if (jj_scan_token(ELSE)) return true;
    if (jj_3R_23()) return true;
    return false;
  }

  final private boolean jj_3R_78() {
    if (jj_3R_83()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_84()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_79() {
    if (jj_scan_token(OR)) return true;
    if (jj_3R_78()) return true;
    return false;
  }

  final private boolean jj_3R_60() {
    if (jj_scan_token(FOR)) return true;
    return false;
  }

  final private boolean jj_3R_147() {
    if (jj_scan_token(128)) return true;
    return false;
  }

  final private boolean jj_3R_68() {
    if (jj_3R_78()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_79()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  final private boolean jj_3R_146() {
    if (jj_scan_token(127)) return true;
    return false;
  }

  final private boolean jj_3R_59() {
    if (jj_scan_token(WHILE)) return true;
    return false;
  }

  final private boolean jj_3R_19() {
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_25()) jj_scanpos = xsp;
    return false;
  }

  public TransformLangParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[57];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static private int[] jj_la1_4;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
      jj_la1_3();
      jj_la1_4();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x49708000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x49708000,0x49708000,0x0,0x49708000,0x0,0x49708000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x49708000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0xc0000008,0xc0000008,0xe000000,0x0,0x0,0xc0000000,0x8,0xe000000,0x0,0xe000000,0xc0000000,0x0,0x10000000,0x0,0xdfc60116,0xe000000,0x0,0x40,0x80,0x600,0x600,0xf800,0xf800,0x60000,0x60000,0x380000,0x380000,0xc00000,0xc00000,0x1c60100,0xdfc60116,0xde000016,0x0,0x16,0xe000000,0xdfc60116,0x0,0xc0000000,0x8,0x8,0x0,0xc00000,0x0,0x0,0xdfc60116,0x0,0x0,0x0,0x0,0xc0000000,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x200000,0x147eedf,0x147eedf,0x0,0x0,0x0,0x2df,0x1476c00,0x0,0x20000,0x0,0x2df,0x0,0x0,0x0,0xfe0003ff,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xfe0003ff,0xfe0003ff,0x0,0x0,0x0,0xfe0003ff,0x0,0xfe0003ff,0x1476c00,0x1476c00,0x0,0x0,0x80000,0x800000,0xfe0003ff,0x0,0x0,0x0,0x0,0x10,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_3() {
      jj_la1_3 = new int[] {0x0,0x7440ff04,0x7440ff04,0x0,0x0,0x2,0x0,0x7440ff04,0x0,0x0,0x0,0x0,0x2,0x0,0x10,0x7440ff01,0x0,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x7440ff01,0x1,0x0,0x0,0x0,0x7440ff01,0x40,0x1,0x7440ff04,0x7440ff04,0x7440ff00,0x0,0x0,0x0,0x7440ff01,0x2,0x7440ff00,0x2,0x3f0000,0x0,0x2,0x3800000,0x3800000,0x2,0x80000000,0x74000000,};
   }
   private static void jj_la1_4() {
      jj_la1_4 = new int[] {0x0,0x4,0x4,0x0,0x4,0x0,0x0,0x4,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x4,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x4,0x4,0x4,0x0,0x0,0x4,0x0,0x0,0x4,0x4,0x4,0x0,0x0,0x0,0x4,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[7];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public TransformLangParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public TransformLangParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TransformLangParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public TransformLangParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new TransformLangParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public TransformLangParser(TransformLangParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(TransformLangParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 57; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[132];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 57; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
          if ((jj_la1_4[i] & (1<<j)) != 0) {
            la1tokens[128+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 132; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 7; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
