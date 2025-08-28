// Source code is decompiled from a .class file using FernFlower decompiler.
public class two_D_Parity{
   public static int[][] stringToBitMatrix(String var0) {
      int var1 = var0.length();
      byte var2 = 8;
      int[][] var3 = new int[var1][var2];
      for(int var4 = 0; var4 < var1; ++var4) {
         int var5 = var0.charAt(var4);
         for(int var6 = var2 - 1; var6 >= 0; --var6) {
            var3[var4][var6] = var5 & 1;
            var5 >>= 1;
         }
      }
      return var3;
   }

   public static int[][] add2DParityBits(int[][] var0) {
      int var1 = var0.length;
      int var2 = var0[0].length;
      int[][] var3 = new int[var1 + 1][var2 + 1];

      int var4;
      int var5;
      for(var4 = 0; var4 < var1; ++var4) {
         for(var5 = 0; var5 < var2; ++var5) {
            var3[var4][var5] = var0[var4][var5];
         }
      }
      int var6;
      for(var4 = 0; var4 < var1; ++var4) {
         var5 = 0;

         for(var6 = 0; var6 < var2; ++var6) {
            var5 += var3[var4][var6];
         }
         var3[var4][var2] = var5 % 2;
      }
      for(var4 = 0; var4 <= var2; ++var4) {
         var5 = 0;
         for(var6 = 0; var6 < var1; ++var6) {
            var5 += var3[var6][var4];
         }
         var3[var1][var4] = var5 % 2;
      }
      return var3;
   }

   public static void printMatrix(int[][] var0) {
      int[][] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         int[] var4 = var1[var3];
         int[] var5 = var4;
         int var6 = var4.length;
         for(int var7 = 0; var7 < var6; ++var7) {
            int var8 = var5[var7];
            System.out.print("" + var8 + " ");
         }
         System.out.println();
      }

   }

   public static void main(String[] var0) {
      String var1 = "24BAI1316";
      System.out.println("Data: " + var1);
      int[][] var2 = stringToBitMatrix(var1);
      System.out.println("\nBit matrix:");
      printMatrix(var2);
      int[][] var3 = add2DParityBits(var2);
      System.out.println("\n2D parity matrix (with parity bits):");
      printMatrix(var3);
   }
}