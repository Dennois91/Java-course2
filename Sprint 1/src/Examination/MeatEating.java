package Examination;

import javax.swing.*;

public class MeatEating extends Plant {
   private final double baseline = 0.1;
   private final double extraProtein = super.getHeight() * 0.2 + baseline;


    public MeatEating(String name, double height) {
        super(name, height);
    }

    @Override
    public void WateringPlan() {
        JOptionPane.showMessageDialog(null,name + " needs "
                + extraProtein + "L of " + LiquidType.MEATEATER.getLiquidType() + " per day.");
    }

    public double getExtraProtein() {
        return extraProtein;
    }

    @Override
    public boolean poison() {
        return false;
    }
}

/*
• Köttätande växter: Dessa behöver alltid en basnivå av 0,1 liter proteindryck per dag och
sedan ett extra tillskott med 0,2 liter proteindryck * sin längd i meter. En köttätande växt
som är 50 cm hög behöver alltså 0,1 + (0,2*0,5) = 0,2 liter proteindryck/dag.

 */
