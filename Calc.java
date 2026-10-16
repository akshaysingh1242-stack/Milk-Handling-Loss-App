package in.milkhandlingloss.app;

public final class Calc {
  private Calc(){}
  public static double fatKg(double milkKg,double fatPercent){return milkKg*fatPercent/100.0;}
  public static double snfKg(double milkKg,double snfPercent){return milkKg*snfPercent/100.0;}
  public static double handlingLoss(double totalBalanceKg,double totalMilkKg){return totalBalanceKg-totalMilkKg;}
  public static double weightedPercent(double componentKg,double milkKg){return milkKg==0?0:componentKg*100.0/milkKg;}
  public static double n(double x){return Double.isFinite(x)?x:0;}
}
