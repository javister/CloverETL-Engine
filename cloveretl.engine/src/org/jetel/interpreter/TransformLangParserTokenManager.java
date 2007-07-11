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

public class TransformLangParserTokenManager implements TransformLangParserConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1, long active2)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0xc000000000000000L) != 0L || (active1 & 0xf414fd00003b1d68L) != 0L)
         {
            jjmatchedKind = 130;
            return 48;
         }
         if ((active1 & 0x40000080400010L) != 0L)
         {
            jjmatchedKind = 130;
            return 77;
         }
         if ((active1 & 0xb80000000000000L) != 0L)
            return 178;
         if ((active1 & 0x200L) != 0L)
         {
            jjmatchedKind = 130;
            return 14;
         }
         if ((active1 & 0x2000011800005L) != 0L)
         {
            jjmatchedKind = 130;
            return 243;
         }
         if ((active1 & 0x2000000000e000L) != 0L || (active2 & 0x1L) != 0L)
         {
            jjmatchedKind = 130;
            return 12;
         }
         if ((active1 & 0x8000008040000L) != 0L)
         {
            jjmatchedKind = 130;
            return 42;
         }
         if ((active0 & 0x1000000000L) != 0L || (active1 & 0x20000000000L) != 0L)
         {
            jjmatchedKind = 130;
            return 24;
         }
         if ((active1 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 130;
            return 38;
         }
         if ((active1 & 0x1000000000000L) != 0L)
         {
            jjmatchedKind = 130;
            return 8;
         }
         if ((active1 & 0x1000000000L) != 0L)
            return 169;
         if ((active0 & 0x100000000000000L) != 0L)
            return 226;
         if ((active1 & 0x144000080L) != 0L)
         {
            jjmatchedKind = 130;
            return 53;
         }
         if ((active1 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 130;
            return 45;
         }
         return -1;
      case 1:
         if ((active1 & 0x10000001L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 244;
         }
         if ((active1 & 0x200000000000000L) != 0L)
            return 198;
         if ((active1 & 0x1000000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 7;
         }
         if ((active1 & 0x10000L) != 0L)
            return 48;
         if ((active1 & 0x80000000000000L) != 0L)
            return 180;
         if ((active1 & 0x140000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 57;
         }
         if ((active1 & 0x20000000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 11;
         }
         if ((active1 & 0x40000080000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 80;
         }
         if ((active1 & 0x4000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 52;
         }
         if ((active1 & 0x1000000L) != 0L)
            return 242;
         if ((active1 & 0x8000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 41;
         }
         if ((active1 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 44;
         }
         if ((active1 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 37;
         }
         if ((active0 & 0xc000000000000000L) != 0L || (active1 & 0xf41eff0000fefffcL) != 0L || (active2 & 0x1L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 48;
         }
         if ((active0 & 0x1000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 1;
            return 33;
         }
         return -1;
      case 2:
         if ((active0 & 0x4000000000000000L) != 0L || (active1 & 0x60010006080L) != 0L)
            return 48;
         if ((active1 & 0x80000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 129;
               jjmatchedPos = 2;
            }
            return 79;
         }
         if ((active1 & 0x4000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 51;
         }
         if ((active1 & 0x100000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 63;
         }
         if ((active1 & 0x8000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 40;
         }
         if ((active1 & 0x80000000000000L) != 0L)
            return 179;
         if ((active1 & 0x40000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 56;
         }
         if ((active0 & 0x8000001000000000L) != 0L || (active1 & 0xf47ff90000fe9f7dL) != 0L || (active2 & 0x1L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 48;
         }
         if ((active1 & 0x22000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 2;
            }
            return 246;
         }
         if ((active1 & 0x200000000000000L) != 0L)
            return 197;
         return -1;
      case 3:
         if ((active1 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
            return 62;
         }
         if ((active0 & 0x8000001000000000L) != 0L || (active1 & 0x800c00002a181061L) != 0L || (active2 & 0x1L) != 0L)
            return 48;
         if ((active1 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
            return 78;
         }
         if ((active1 & 0x40000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
            return 55;
         }
         if ((active1 & 0x7473f90000e6cf1cL) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
            return 48;
         }
         if ((active1 & 0x4000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
            return 50;
         }
         return -1;
      case 4:
         if ((active1 & 0x33100004040400L) != 0L)
            return 48;
         if ((active1 & 0x40000000L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 4;
            }
            return 54;
         }
         if ((active1 & 0x7440e90000e2cb1cL) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 4;
            }
            return 48;
         }
         if ((active1 & 0x80000000L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 4;
            }
            return 247;
         }
         if ((active1 & 0x100000000L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 4;
            }
            return 61;
         }
         return -1;
      case 5:
         if ((active1 & 0x74000100c0620310L) != 0L)
            return 48;
         if ((active1 & 0x40f8000080c80cL) != 0L)
         {
            if (jjmatchedPos != 5)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 5;
            }
            return 48;
         }
         if ((active1 & 0x100000000L) != 0L)
         {
            if (jjmatchedPos != 5)
            {
               jjmatchedKind = 130;
               jjmatchedPos = 5;
            }
            return 60;
         }
         return -1;
      case 6:
         if ((active1 & 0x80400cL) != 0L)
            return 48;
         if ((active1 & 0x7040f80000008800L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 6;
            return 48;
         }
         if ((active1 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 6;
            return 69;
         }
         return -1;
      case 7:
         if ((active1 & 0x7000f80000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 7;
            return 48;
         }
         if ((active1 & 0x40000000008800L) != 0L)
            return 48;
         if ((active1 & 0x100000000L) != 0L)
            return 68;
         return -1;
      case 8:
         if ((active1 & 0xc00000000000L) != 0L)
            return 48;
         if ((active1 & 0x7000380000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 8;
            return 48;
         }
         return -1;
      case 9:
         if ((active1 & 0x100000000000L) != 0L)
            return 48;
         if ((active1 & 0x7000280000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 9;
            return 48;
         }
         return -1;
      case 10:
         if ((active1 & 0x6000000000000000L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 10;
            return 48;
         }
         if ((active1 & 0x1000280000000000L) != 0L)
            return 48;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1, long active2)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1, active2), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 10:
         jjmatchedKind = 3;
         return jjMoveStringLiteralDfa1_0(0x20L, 0x0L, 0x0L);
      case 35:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L, 0x0L);
      case 37:
         return jjStopAtPos(0, 53);
      case 40:
         return jjStopAtPos(0, 60);
      case 41:
         return jjStopAtPos(0, 61);
      case 42:
         return jjStopAtPos(0, 51);
      case 43:
         jjmatchedKind = 50;
         return jjMoveStringLiteralDfa1_0(0x40000000000000L, 0x0L, 0x0L);
      case 44:
         return jjStopAtPos(0, 97);
      case 45:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x80000000000000L, 0x0L, 0x0L);
      case 46:
         jjmatchedKind = 123;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x380000000000000L, 0x0L);
      case 47:
         jjmatchedKind = 52;
         return jjMoveStringLiteralDfa1_0(0x240L, 0x0L, 0x0L);
      case 58:
         jjmatchedKind = 101;
         return jjMoveStringLiteralDfa1_0(0x2000000000L, 0x0L, 0x0L);
      case 59:
         return jjStopAtPos(0, 35);
      case 61:
         return jjStartNfaWithStates_0(0, 100, 169);
      case 91:
         return jjStopAtPos(0, 102);
      case 93:
         return jjStopAtPos(0, 103);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x100000000428L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x80800L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000011800005L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10000000101000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000000000e000L, 0x1L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x20000000L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x4000000000000000L, 0x8004050000210000L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x8000000000000000L, 0x7400000000000040L, 0x0L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x144000080L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x1000000000L, 0x20000000000L, 0x0L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x200L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x0L, 0xc80000000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x200000020100L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x40000080400010L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1000000000000L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8000008040000L, 0x0L);
      case 121:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x2000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 98);
      case 125:
         return jjStopAtPos(0, 99);
      case 126:
         return jjStartNfaWithStates_0(0, 56, 226);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0, long active1, long active2)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1, active2);
      return 1;
   }
   switch(curChar)
   {
      case 13:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 42:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 43:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStopAtPos(1, 54);
         break;
      case 45:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(1, 55);
         break;
      case 47:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(1, 9);
         break;
      case 61:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(1, 37);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x28200010080081L, active2, 0L);
      case 98:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x200L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x100000000000000L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x4200008a820104L, active2, 0L);
      case 102:
         if ((active1 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 80, 48);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x40000L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L, active1, 0x40140000040L, active2, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x1000L, active2, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x200000L, active2, 0L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000000L, active1, 0x8084000000100000L, active2, 0L);
      case 111:
         if ((active1 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(1, 88, 242);
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000000000L, active1, 0x7400000024006808L, active2, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x211d80000000400L, active2, 0x1L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x10000000000L, active2, 0L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x10L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000000L, active1, 0x8000L, active2, 0L);
      case 118:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x20000000000L, active2, 0L);
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x400000L, active2, 0L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x20L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1, active2);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(0, old0, old1, old2); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1, active2);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x1000002000000L, active2, 0L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x2000000000000L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x80000104L, active2, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x280100008000400L, active2, 0x1L);
      case 102:
         if ((active1 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 106, 48);
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x4000000800000L, active2, 0L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x8000e80000440000L, active2, 0L);
      case 106:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x200L, active2, 0L);
      case 108:
         if ((active1 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 105, 48);
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000L, active1, 0x100000000L, active2, 0L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000001000L, active1, 0x10044008800L, active2, 0L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x7400000000000008L, active2, 0L);
      case 112:
         if ((active1 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(2, 71, 48);
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x200000L, active2, 0L);
      case 113:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x40000000000000L, active2, 0L);
      case 114:
         if ((active1 & 0x2000L) != 0L)
         {
            jjmatchedKind = 77;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x18000000004010L, active2, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x81040L, active2, 0L);
      case 116:
         if ((active0 & 0x4000000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 62, 48);
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x20000000020021L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x100000020100000L, active2, 0L);
      case 121:
         if ((active1 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(2, 92, 48);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1, active2);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(1, old0, old1, old2); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, active1, active2);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x20100000800400L, active2, 0L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L, active1, 0x1000000008000L, active2, 0L);
      case 101:
         if ((active1 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(3, 64, 48);
         else if ((active1 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 69, 48);
         else if ((active1 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 76, 48);
         else if ((active1 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 83, 48);
         else if ((active2 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(3, 128, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x4200L, active2, 0L);
      case 103:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 63, 48);
         break;
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x14L, active2, 0L);
      case 107:
         if ((active1 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 91, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x7400000000000000L, active2, 0L);
      case 108:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 36, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x100040008L, active2, 0L);
      case 109:
         if ((active1 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 84, 48);
         break;
      case 110:
         if ((active1 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 115, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0xc80000000000L, active2, 0L);
      case 111:
         if ((active1 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 114, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x10000080200100L, active2, 0L);
      case 114:
         if ((active1 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 89, 48);
         else if ((active1 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(3, 93, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x100000000000000L, active2, 0L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x200200000000000L, active2, 0L);
      case 116:
         if ((active1 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(3, 70, 48);
         else if ((active1 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 127, 48);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x4400800L, active2, 0L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x42010040020000L, active2, 0L);
      case 120:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x80000000000000L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, active1, active2);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(2, old0, old1, old2); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, active1, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x4000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x400200L);
      case 101:
         if ((active1 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(4, 82, 48);
         else if ((active1 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 112, 48);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x240200000000008L);
      case 103:
         if ((active1 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 113, 48);
         break;
      case 104:
         if ((active1 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(4, 90, 48);
         break;
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x100000800L);
      case 107:
         if ((active1 & 0x400L) != 0L)
         {
            jjmatchedKind = 74;
            jjmatchedPos = 4;
         }
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x100000000000L);
      case 108:
         if ((active1 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 117, 48);
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L, active1, 0x10000000000L);
      case 109:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x4L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x80000010L);
      case 114:
         if ((active1 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 116, 48);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x100000000220100L);
      case 116:
         if ((active1 & 0x80000000000000L) != 0L)
            return jjStopAtPos(4, 119);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0xc80040008000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x7400000000800000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, active1, 0L);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(3, old0, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, active1, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0xe80000000000L);
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0xcL);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x4000L);
      case 100:
         if ((active1 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(5, 72, 48);
         else if ((active1 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 95, 48);
         break;
      case 101:
         if ((active1 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(5, 94, 48);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x100000000000000L);
      case 103:
         if ((active1 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(5, 68, 48);
         break;
      case 104:
         if ((active1 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(5, 86, 48);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x8000L);
      case 108:
         if ((active1 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 104, 48);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x800000L);
      case 110:
         if ((active1 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(5, 81, 48);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x40000000000800L);
      case 112:
         if ((active1 & 0x400000000000000L) != 0L)
         {
            jjmatchedKind = 122;
            jjmatchedPos = 5;
         }
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x7000100000000000L);
      case 115:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x100000000L);
      case 116:
         if ((active1 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(5, 73, 48);
         else if ((active1 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(5, 85, 48);
         else if ((active1 & 0x200000000000000L) != 0L)
            return jjStopAtPos(5, 121);
         break;
      case 117:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, active1, 0L);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(4, old0, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, active1, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x7000000000000000L);
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x40000000000000L);
      case 100:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x600100000000L);
      case 104:
         if ((active1 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(6, 78, 48);
         break;
      case 108:
         if ((active1 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(6, 66, 48);
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x800000000000L);
      case 110:
         if ((active1 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(6, 67, 48);
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x100000000000000L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x100000008000L);
      case 115:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x80000000000L);
      case 116:
         if ((active1 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(6, 87, 48);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, active1, 0L);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(5, old0, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, active1, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x4000000000000000L);
      case 99:
         if ((active1 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(7, 96, 68);
         break;
      case 101:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(7, 12);
         else if ((active1 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(7, 75, 48);
         else if ((active1 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 118, 48);
         break;
      case 102:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x2000000000000000L);
      case 105:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x100000000000L);
      case 110:
         if ((active1 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(7, 79, 48);
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x1000000000000000L);
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x800000000000L);
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x600000000000L);
      case 116:
         if ((active1 & 0x100000000000000L) != 0L)
            return jjStopAtPos(7, 120);
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x80000000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0, active1, 0L);
}
private final int jjMoveStringLiteralDfa8_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(6, old0, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, 0L, active1, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa9_0(active1, 0x80000000000L);
      case 100:
         return jjMoveStringLiteralDfa9_0(active1, 0x4000000000000000L);
      case 101:
         return jjMoveStringLiteralDfa9_0(active1, 0x1000000000000000L);
      case 103:
         if ((active1 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 111, 48);
         break;
      case 110:
         return jjMoveStringLiteralDfa9_0(active1, 0x100000000000L);
      case 111:
         return jjMoveStringLiteralDfa9_0(active1, 0x2000000000000000L);
      case 114:
         if ((active1 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 110, 48);
         return jjMoveStringLiteralDfa9_0(active1, 0x200000000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, 0L, active1, 0L);
}
private final int jjMoveStringLiteralDfa9_0(long old1, long active1)
{
   if (((active1 &= old1)) == 0L)
      return jjStartNfa_0(7, 0L, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, 0L, active1, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa10_0(active1, 0x80000000000L);
      case 109:
         return jjMoveStringLiteralDfa10_0(active1, 0x4000000000000000L);
      case 111:
         return jjMoveStringLiteralDfa10_0(active1, 0x200000000000L);
      case 116:
         if ((active1 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 108, 48);
         break;
      case 117:
         return jjMoveStringLiteralDfa10_0(active1, 0x2000000000000000L);
      case 120:
         return jjMoveStringLiteralDfa10_0(active1, 0x1000000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(8, 0L, active1, 0L);
}
private final int jjMoveStringLiteralDfa10_0(long old1, long active1)
{
   if (((active1 &= old1)) == 0L)
      return jjStartNfa_0(8, 0L, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, 0L, active1, 0L);
      return 10;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa11_0(active1, 0x4000000000000000L);
      case 107:
         if ((active1 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(10, 107, 48);
         break;
      case 110:
         return jjMoveStringLiteralDfa11_0(active1, 0x2000000000000000L);
      case 114:
         if ((active1 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(10, 109, 48);
         break;
      case 116:
         if ((active1 & 0x1000000000000000L) != 0L)
            return jjStartNfaWithStates_0(10, 124, 48);
         break;
      default :
         break;
   }
   return jjStartNfa_0(9, 0L, active1, 0L);
}
private final int jjMoveStringLiteralDfa11_0(long old1, long active1)
{
   if (((active1 &= old1)) == 0L)
      return jjStartNfa_0(9, 0L, old1, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, 0L, active1, 0L);
      return 11;
   }
   switch(curChar)
   {
      case 100:
         if ((active1 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(11, 125, 48);
         break;
      case 110:
         if ((active1 & 0x4000000000000000L) != 0L)
            return jjStartNfaWithStates_0(11, 126, 48);
         break;
      default :
         break;
   }
   return jjStartNfa_0(10, 0L, active1, 0L);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 246;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 24:
               case 48:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 80:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 51:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 226:
                  if (curChar == 61)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  if (curChar == 61)
                  {
                     if (kind > 47)
                        kind = 47;
                  }
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 56:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 244:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 169:
                  if (curChar == 62)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  else if (curChar == 60)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  else if (curChar == 61)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  if (curChar == 62)
                  {
                     if (kind > 46)
                        kind = 46;
                  }
                  else if (curChar == 60)
                  {
                     if (kind > 44)
                        kind = 44;
                  }
                  else if (curChar == 61)
                  {
                     if (kind > 41)
                        kind = 41;
                  }
                  break;
               case 37:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 57:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 178:
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(0, 2);
                  break;
               case 68:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 42:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 60:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 179:
                  if (curChar == 46)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  if (curChar == 46)
                  {
                     if (kind > 42)
                        kind = 42;
                  }
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 242:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 53:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 247:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 243:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 61:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 78:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 69:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 33:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 52:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 77:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 45:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 62:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 11);
                  else if ((0x5000000000000000L & l) != 0L)
                  {
                     if (kind > 48)
                        kind = 48;
                  }
                  else if (curChar == 36)
                     jjCheckNAddStates(12, 14);
                  else if (curChar == 33)
                     jjCheckNAddTwoStates(219, 172);
                  else if (curChar == 46)
                     jjAddStates(15, 28);
                  else if (curChar == 61)
                     jjCheckNAddStates(29, 34);
                  else if (curChar == 34)
                  {
                     if (kind > 27)
                        kind = 27;
                     jjCheckNAddStates(35, 40);
                  }
                  else if (curChar == 39)
                  {
                     if (kind > 27)
                        kind = 27;
                     jjCheckNAddStates(41, 46);
                  }
                  else if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 21;
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(47, 49);
                  }
                  else if (curChar == 62)
                     jjCheckNAddTwoStates(224, 172);
                  else if (curChar == 60)
                     jjCheckNAddStates(50, 53);
                  else if (curChar == 48)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(54, 58);
                  }
                  else if (curChar == 33)
                  {
                     if (kind > 40)
                        kind = 40;
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(1);
                  if (curChar == 62)
                  {
                     if (kind > 45)
                        kind = 45;
                  }
                  else if (curChar == 60)
                  {
                     if (kind > 43)
                        kind = 43;
                  }
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 50:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 63:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 55:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 246:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 79:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 3:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(4, 5);
                  break;
               case 21:
                  if (curChar == 38 && kind > 39)
                     kind = 39;
                  break;
               case 22:
                  if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 26:
                  if (curChar == 33 && kind > 40)
                     kind = 40;
                  break;
               case 27:
                  if (curChar == 60 && kind > 43)
                     kind = 43;
                  break;
               case 28:
                  if (curChar == 62 && kind > 45)
                     kind = 45;
                  break;
               case 29:
                  if ((0x5000000000000000L & l) != 0L && kind > 48)
                     kind = 48;
                  break;
               case 82:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(47, 49);
                  break;
               case 83:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(83, 84);
                  break;
               case 85:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(85);
                  break;
               case 86:
                  if (curChar != 48)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(54, 58);
                  break;
               case 88:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(88, 84);
                  break;
               case 89:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(89, 84);
                  break;
               case 91:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 91;
                  break;
               case 92:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(92);
                  break;
               case 93:
                  if (curChar != 39)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(41, 46);
                  break;
               case 94:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(59, 61);
                  break;
               case 96:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(59, 61);
                  break;
               case 97:
                  if (curChar == 39 && kind > 24)
                     kind = 24;
                  break;
               case 98:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(62, 65);
                  break;
               case 99:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(59, 61);
                  break;
               case 100:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               case 101:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(99);
                  break;
               case 102:
                  if ((0xffffff7fffffdbffL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 104:
                  if ((0x8400000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 105:
                  if ((0x2400L & l) != 0L)
                     kind = 27;
                  break;
               case 106:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(69, 72);
                  break;
               case 107:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 108:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 109;
                  break;
               case 109:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(107);
                  break;
               case 110:
                  if (curChar != 34)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(35, 40);
                  break;
               case 111:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(73, 75);
                  break;
               case 113:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(73, 75);
                  break;
               case 114:
                  if (curChar == 34 && kind > 24)
                     kind = 24;
                  break;
               case 115:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(76, 79);
                  break;
               case 116:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(73, 75);
                  break;
               case 117:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 118;
                  break;
               case 118:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(116);
                  break;
               case 119:
                  if ((0xfffffffbffffdbffL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               case 121:
                  if ((0x8400000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               case 122:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(83, 86);
                  break;
               case 123:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               case 124:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 125;
                  break;
               case 125:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(123);
                  break;
               case 126:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 11);
                  break;
               case 127:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(127, 128);
                  break;
               case 128:
                  if (curChar != 46)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(87, 89);
                  break;
               case 129:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(87, 89);
                  break;
               case 131:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(132);
                  break;
               case 132:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(132, 5);
                  break;
               case 133:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(133, 134);
                  break;
               case 135:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(136);
                  break;
               case 136:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(136, 5);
                  break;
               case 137:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(90, 92);
                  break;
               case 139:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(140);
                  break;
               case 140:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(140, 5);
                  break;
               case 141:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 142;
                  break;
               case 142:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 143;
                  break;
               case 143:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 144;
                  break;
               case 144:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 145;
                  break;
               case 145:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(146, 147);
                  break;
               case 146:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(147);
                  break;
               case 147:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 148;
                  break;
               case 148:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 33)
                     kind = 33;
                  jjstateSet[jjnewStateCnt++] = 149;
                  break;
               case 149:
                  if ((0x3ff000000000000L & l) != 0L && kind > 33)
                     kind = 33;
                  break;
               case 150:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 151;
                  break;
               case 151:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 152;
                  break;
               case 152:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 153;
                  break;
               case 153:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 154;
                  break;
               case 154:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(155, 156);
                  break;
               case 155:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(156);
                  break;
               case 156:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 157;
                  break;
               case 157:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(158, 159);
                  break;
               case 158:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(159);
                  break;
               case 159:
                  if (curChar == 32)
                     jjstateSet[jjnewStateCnt++] = 160;
                  break;
               case 160:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(161, 162);
                  break;
               case 161:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(162);
                  break;
               case 162:
                  if (curChar == 58)
                     jjstateSet[jjnewStateCnt++] = 163;
                  break;
               case 163:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(164, 165);
                  break;
               case 164:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAdd(165);
                  break;
               case 165:
                  if (curChar == 58)
                     jjstateSet[jjnewStateCnt++] = 166;
                  break;
               case 166:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 34)
                     kind = 34;
                  jjstateSet[jjnewStateCnt++] = 167;
                  break;
               case 167:
                  if ((0x3ff000000000000L & l) != 0L && kind > 34)
                     kind = 34;
                  break;
               case 168:
                  if (curChar == 61)
                     jjCheckNAddStates(29, 34);
                  break;
               case 170:
                  if (curChar == 60 && kind > 44)
                     kind = 44;
                  break;
               case 171:
                  if (curChar == 62 && kind > 46)
                     kind = 46;
                  break;
               case 172:
                  if (curChar == 61 && kind > 48)
                     kind = 48;
                  break;
               case 173:
                  if (curChar == 60 && kind > 48)
                     kind = 48;
                  break;
               case 174:
                  if (curChar == 62 && kind > 48)
                     kind = 48;
                  break;
               case 175:
                  if (curChar == 46)
                     jjAddStates(15, 28);
                  break;
               case 176:
                  if (curChar == 46 && kind > 41)
                     kind = 41;
                  break;
               case 182:
                  if (curChar == 46 && kind > 43)
                     kind = 43;
                  break;
               case 185:
                  if (curChar == 46 && kind > 44)
                     kind = 44;
                  break;
               case 188:
                  if (curChar == 46 && kind > 45)
                     kind = 45;
                  break;
               case 191:
                  if (curChar == 46 && kind > 46)
                     kind = 46;
                  break;
               case 194:
                  if (curChar == 46 && kind > 47)
                     kind = 47;
                  break;
               case 200:
                  if (curChar == 46 && kind > 48)
                     kind = 48;
                  break;
               case 218:
                  if (curChar == 33)
                     jjCheckNAddTwoStates(219, 172);
                  break;
               case 219:
                  if (curChar == 61 && kind > 42)
                     kind = 42;
                  break;
               case 220:
                  if (curChar == 60)
                     jjCheckNAddStates(50, 53);
                  break;
               case 221:
                  if (curChar == 62 && kind > 42)
                     kind = 42;
                  break;
               case 222:
                  if (curChar == 61 && kind > 44)
                     kind = 44;
                  break;
               case 223:
                  if (curChar == 62)
                     jjCheckNAddTwoStates(224, 172);
                  break;
               case 224:
                  if (curChar == 61 && kind > 46)
                     kind = 46;
                  break;
               case 227:
                  if (curChar == 36)
                     jjCheckNAddStates(12, 14);
                  break;
               case 229:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  jjstateSet[jjnewStateCnt++] = 229;
                  break;
               case 231:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjAddStates(93, 94);
                  break;
               case 232:
                  if (curChar == 46)
                     jjCheckNAdd(233);
                  break;
               case 233:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  jjCheckNAdd(233);
                  break;
               case 234:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(234, 235);
                  break;
               case 235:
                  if (curChar == 46)
                     jjstateSet[jjnewStateCnt++] = 236;
                  break;
               case 237:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjstateSet[jjnewStateCnt++] = 237;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 24:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 23;
                  else if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 80:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 79;
                  if (curChar == 99)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 180:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 179;
                  if (curChar == 101)
                     jjCheckNAdd(200);
                  break;
               case 51:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 50;
                  break;
               case 44:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 117)
                     jjCheckNAdd(36);
                  break;
               case 8:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 56:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 55;
                  break;
               case 244:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 121)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 37:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 97)
                     jjCheckNAdd(36);
                  break;
               case 57:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 73;
                  else if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 56;
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 11:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 178:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 198;
                  else if ((0x8000000080L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 192;
                  else if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 186;
                  else if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 180;
                  else if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 177;
                  if ((0x8000000080L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 189;
                  else if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 183;
                  else if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 216;
                  else if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 203;
                  else if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 201;
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 211;
                  else if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 207;
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 209;
                  else if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 205;
                  break;
               case 68:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 42:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 41;
                  break;
               case 60:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 69;
                  if (curChar == 101)
                     jjCheckNAdd(59);
                  break;
               case 54:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 242:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 241;
                  break;
               case 53:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 74;
                  else if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 52;
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 64;
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 247:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 100)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 243:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 244;
                  else if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 242;
                  break;
               case 61:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 70;
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 60;
                  break;
               case 40:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 107)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 78:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 110)
                     jjCheckNAdd(66);
                  break;
               case 69:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 68;
                  if (curChar == 99)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 33:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 52:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 51;
                  break;
               case 14:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if ((0x4000000040000L & l) != 0L)
                  {
                     if (kind > 38)
                        kind = 38;
                  }
                  break;
               case 77:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 80;
                  if (curChar == 101)
                     jjCheckNAdd(59);
                  break;
               case 45:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 62:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 71;
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  else if (curChar == 126)
                     jjAddStates(95, 96);
                  else if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 16;
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 24;
                  else if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  else if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 14;
                  else if (curChar == 100)
                     jjAddStates(97, 98);
                  else if (curChar == 115)
                     jjAddStates(99, 100);
                  else if (curChar == 109)
                     jjAddStates(101, 104);
                  else if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 45;
                  else if (curChar == 119)
                     jjstateSet[jjnewStateCnt++] = 42;
                  else if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 38;
                  else if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 12;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 8;
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 38:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 50:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 104)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 12:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 63:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 72;
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 117)
                     jjCheckNAdd(6);
                  break;
               case 55:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 54;
                  break;
               case 246:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 114)
                  {
                     if (kind > 129)
                        kind = 129;
                  }
                  break;
               case 41:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 198:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 197;
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 215;
                  break;
               case 79:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 130)
                        kind = 130;
                     jjCheckNAdd(48);
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 78;
                  break;
               case 197:
                  if ((0x8000000080L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 196;
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 214;
                  break;
               case 2:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(105, 106);
                  break;
               case 5:
                  if ((0x5000000050L & l) != 0L && kind > 22)
                     kind = 22;
                  break;
               case 6:
                  if (curChar == 101 && kind > 30)
                     kind = 30;
                  break;
               case 9:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 115)
                     jjCheckNAdd(6);
                  break;
               case 13:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 15:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 124 && kind > 38)
                     kind = 38;
                  break;
               case 17:
                  if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 18:
                  if ((0x1000000010L & l) != 0L && kind > 39)
                     kind = 39;
                  break;
               case 19:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 23:
                  if ((0x10000000100000L & l) != 0L && kind > 40)
                     kind = 40;
                  break;
               case 25:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 30:
                  if (curChar == 114 && kind > 65)
                     kind = 65;
                  break;
               case 31:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 34:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 35:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 36:
                  if (curChar == 114 && kind > 129)
                     kind = 129;
                  break;
               case 39:
                  if (curChar == 121)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 43:
                  if (curChar == 119)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 46:
                  if (curChar == 104)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 47:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 48:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 130)
                     kind = 130;
                  jjCheckNAdd(48);
                  break;
               case 49:
                  if (curChar == 109)
                     jjAddStates(101, 104);
                  break;
               case 58:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 59:
                  if (curChar == 99 && kind > 129)
                     kind = 129;
                  break;
               case 64:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 65:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 64;
                  break;
               case 66:
                  if (curChar == 100 && kind > 129)
                     kind = 129;
                  break;
               case 67:
                  if (curChar == 110)
                     jjCheckNAdd(66);
                  break;
               case 70:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 69;
                  break;
               case 71:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 70;
                  break;
               case 72:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 71;
                  break;
               case 73:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 74:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 73;
                  break;
               case 75:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 74;
                  break;
               case 76:
                  if (curChar == 115)
                     jjAddStates(99, 100);
                  break;
               case 81:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 80;
                  break;
               case 84:
                  if ((0x100000001000L & l) != 0L && kind > 15)
                     kind = 15;
                  break;
               case 87:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(88);
                  break;
               case 88:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddTwoStates(88, 84);
                  break;
               case 90:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(91);
                  break;
               case 91:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(91);
                  break;
               case 94:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(59, 61);
                  break;
               case 95:
                  if (curChar == 92)
                     jjAddStates(107, 109);
                  break;
               case 96:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(59, 61);
                  break;
               case 102:
                  if ((0xffffffffefffffffL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 103:
                  if (curChar == 92)
                     jjAddStates(110, 112);
                  break;
               case 104:
                  if ((0x14404410000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 111:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(73, 75);
                  break;
               case 112:
                  if (curChar == 92)
                     jjAddStates(113, 115);
                  break;
               case 113:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(73, 75);
                  break;
               case 119:
                  if ((0xffffffffefffffffL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               case 120:
                  if (curChar == 92)
                     jjAddStates(116, 118);
                  break;
               case 121:
                  if ((0x14404410000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               case 130:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(119, 120);
                  break;
               case 134:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(121, 122);
                  break;
               case 138:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(123, 124);
                  break;
               case 177:
                  if ((0x2000000020000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 176;
                  break;
               case 181:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 180;
                  break;
               case 183:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 182;
                  break;
               case 184:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 183;
                  break;
               case 186:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 185;
                  break;
               case 187:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 186;
                  break;
               case 189:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 188;
                  break;
               case 190:
                  if ((0x8000000080L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 189;
                  break;
               case 192:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 191;
                  break;
               case 193:
                  if ((0x8000000080L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 192;
                  break;
               case 195:
                  if ((0x100000001000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 194;
                  break;
               case 196:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 195;
                  break;
               case 199:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 198;
                  break;
               case 201:
                  if (curChar == 113)
                     jjCheckNAdd(200);
                  break;
               case 202:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 201;
                  break;
               case 203:
               case 207:
               case 211:
                  if (curChar == 101)
                     jjCheckNAdd(200);
                  break;
               case 204:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 203;
                  break;
               case 205:
               case 209:
                  if (curChar == 116)
                     jjCheckNAdd(200);
                  break;
               case 206:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 205;
                  break;
               case 208:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 207;
                  break;
               case 210:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 209;
                  break;
               case 212:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 211;
                  break;
               case 213:
                  if (curChar == 120)
                     jjCheckNAdd(200);
                  break;
               case 214:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 213;
                  break;
               case 215:
                  if (curChar == 103)
                     jjstateSet[jjnewStateCnt++] = 214;
                  break;
               case 216:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 215;
                  break;
               case 217:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 216;
                  break;
               case 225:
                  if (curChar == 126)
                     jjAddStates(95, 96);
                  break;
               case 228:
               case 229:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 57)
                     kind = 57;
                  jjCheckNAdd(229);
                  break;
               case 230:
               case 231:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddTwoStates(231, 232);
                  break;
               case 233:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  jjstateSet[jjnewStateCnt++] = 233;
                  break;
               case 236:
               case 237:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 59)
                     kind = 59;
                  jjCheckNAdd(237);
                  break;
               case 238:
                  if (curChar == 100)
                     jjAddStates(97, 98);
                  break;
               case 239:
                  if (curChar == 101 && kind > 65)
                     kind = 65;
                  break;
               case 240:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 239;
                  break;
               case 241:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 240;
                  break;
               case 245:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 244;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 94:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(59, 61);
                  break;
               case 102:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(66, 68);
                  break;
               case 111:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(73, 75);
                  break;
               case 119:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAddStates(80, 82);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 246 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 10);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x80L);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      default :
         return 2;
   }
   return 2;
}
private final int jjMoveStringLiteralDfa0_4()
{
   return 1;
}
private final int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 13);
      default :
         return 1;
   }
}
static final int[] jjnextStates = {
   1, 2, 5, 127, 128, 133, 134, 137, 138, 5, 141, 150, 228, 230, 234, 178, 
   181, 184, 187, 190, 193, 199, 202, 204, 206, 208, 210, 212, 217, 169, 170, 171, 
   172, 173, 174, 111, 112, 114, 119, 120, 105, 94, 95, 97, 102, 103, 105, 83, 
   84, 85, 221, 222, 174, 172, 87, 89, 84, 90, 92, 94, 95, 97, 94, 95, 
   99, 97, 102, 103, 105, 102, 103, 107, 105, 111, 112, 114, 111, 112, 116, 114, 
   119, 120, 105, 119, 120, 123, 105, 129, 130, 5, 137, 138, 5, 231, 232, 226, 
   172, 243, 245, 77, 81, 53, 58, 65, 75, 3, 4, 96, 98, 100, 104, 106, 
   108, 113, 115, 117, 121, 122, 124, 131, 132, 135, 136, 139, 140, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default : 
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, "\73", "\156\165\154\154", "\72\75", 
null, null, null, null, null, null, null, null, null, null, null, "\55", "\53", 
"\52", "\57", "\45", "\53\53", "\55\55", "\176", null, null, null, "\50", "\51", 
"\151\156\164", "\154\157\156\147", "\144\141\164\145", null, "\144\145\143\151\155\141\154", 
"\142\157\157\154\145\141\156", "\163\164\162\151\156\147", "\142\171\164\145", "\154\151\163\164", 
"\155\141\160", "\162\145\143\157\162\144", "\157\142\152\145\143\164", 
"\142\162\145\141\153", "\143\157\156\164\151\156\165\145", "\145\154\163\145", "\146\157\162", 
"\146\157\162\145\141\143\150", "\146\165\156\143\164\151\157\156", "\151\146", "\162\145\164\165\162\156", 
"\167\150\151\154\145", "\143\141\163\145", "\145\156\165\155", "\151\155\160\157\162\164", 
"\163\167\151\164\143\150", "\144\145\146\141\165\154\164", "\144\157", "\171\145\141\162", 
"\155\157\156\164\150", "\167\145\145\153", "\144\141\171", "\150\157\165\162", 
"\155\151\156\165\164\145", "\163\145\143\157\156\144", "\155\151\154\154\151\163\145\143", "\54", "\173", 
"\175", "\75", "\72", "\133", "\135", "\151\163\156\165\154\154", "\156\166\154", 
"\151\151\146", "\160\162\151\156\164\137\163\164\141\143\153", 
"\142\162\145\141\153\160\157\151\156\164", "\162\141\151\163\145\137\145\162\162\157\162", 
"\160\162\151\156\164\137\145\162\162", "\160\162\151\156\164\137\154\157\147", "\164\162\141\143\145", 
"\144\145\142\165\147", "\151\156\146\157", "\167\141\162\156", "\145\162\162\157\162", 
"\146\141\164\141\154", "\163\145\161\165\145\156\143\145", "\56\156\145\170\164", 
"\56\143\165\162\162\145\156\164", "\56\162\145\163\145\164", "\154\157\157\153\165\160", "\56", 
"\154\157\157\153\165\160\137\156\145\170\164", "\154\157\157\153\165\160\137\146\157\165\156\144", 
"\154\157\157\153\165\160\137\141\144\155\151\156", "\151\156\151\164", "\146\162\145\145", null, null, null, };
public static final String[] lexStateNames = {
   "DEFAULT", 
   "WithinComment", 
   "WithinLineComment", 
   "WithinInclude", 
   "WithingInclude", 
};
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, 0, -1, 3, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xfffffffe49788001L, 0xffffffffffffffffL, 0xfL, 
};
static final long[] jjtoSkip = {
   0x36feL, 0x0L, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x36c0L, 0x0L, 0x0L, 
};
static final long[] jjtoMore = {
   0x4900L, 0x0L, 0x0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[246];
private final int[] jjstateSet = new int[492];
StringBuffer image;
int jjimageLen;
int lengthOfMatch;
protected char curChar;
public TransformLangParserTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public TransformLangParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 246; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = null;
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100002200L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         if (jjmatchedPos == 0 && jjmatchedKind > 131)
         {
            jjmatchedKind = 131;
         }
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 8)
         {
            jjmatchedKind = 8;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 11)
         {
            jjmatchedKind = 11;
         }
         break;
       case 3:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_3();
         break;
       case 4:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_4();
         if (jjmatchedPos == 0 && jjmatchedKind > 14)
         {
            jjmatchedKind = 14;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else 
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        jjimageLen += jjmatchedPos + 1;
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
}
