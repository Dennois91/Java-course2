package Examination;

import javax.swing.*;

public class Palmtree extends Plant implements Poison {
    private final double amountOfFluid = super.getHeight() * 0.5;

    public Palmtree(String name, double height) {
        super(name, height);
    }

    @Override
    public void WateringPlan() {
        JOptionPane.showMessageDialog(null, name + " needs "
                + amountOfFluid + "L of " + LiquidType.PALMTREE.getLiquidType() + " per day.");
    }

    public double getAmountOfFluid() {
        return amountOfFluid;
    }

    @Override
    public boolean poison() {
        return false;
    }
}