package Examination;

import javax.swing.*;

public class Cactus extends Plant implements Poison {
    protected final int amountOfFluid = 2;

    public Cactus(String name, double height) {
        super(name, height);
    }

    @Override
    public void WateringPlan() {
        JOptionPane.showMessageDialog(null, name + " needs "
                + amountOfFluid + "CL of " + LiquidType.CACTUS.getLiquidType() + " per day.");

    }


    @Override
    public boolean poison() {
        return true;
    }
}
