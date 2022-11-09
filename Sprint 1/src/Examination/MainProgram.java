package Examination;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainProgram {

    List<Plant> plantList = new ArrayList<>();
    Cactus igge = new Cactus("Igge", 0.20);
    Palmtree laura = new Palmtree("Laura", 5);
    Palmtree putte = new Palmtree("Putte", 1);
    MeatEating meatloaf = new MeatEating("Meatloaf", 0.7);


    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();
    }

    public MainProgram() {
        plantList.add(igge);
        plantList.add(laura);
        plantList.add(putte);
        plantList.add(meatloaf);

        showPlantsInSystem(plantList);
        askForPlant(plantList);


    }

    public void askForPlant(List<Plant> plants) {

        while (true) {

            String input = JOptionPane.showInputDialog(null, "Type name of plant to water\n" +
                    "Press X or Cancel to exit the program");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "You exited the program");
                break;
            }

            if (!input.equals(igge.getName()) && (!input.equals(laura.getName())) &&
                    (!input.equals(meatloaf.getName())) && (!input.equals(putte.getName()))) {
                JOptionPane.showMessageDialog(null, "Invalid input. Use only the name of a plant");
            } else {
                for (Plant plant : plants) {
                    if (plant.getName().equals(input)) { //POLYMORPHISM
                        plant.WateringPlan();
                        if (plant.poison()) {
                            JOptionPane.showMessageDialog(null, "DANGER >" + plant.getName()
                                    + "< IS POISONOUS");
                        }
                    }
                }
            }
        }
    }

    public void showPlantsInSystem(List<Plant> plants) {
        for (Plant plant : plants) {
            System.out.println(plant.getName());
        }
    }
}


/*

Dessa växter bor på hotellet:
• Kaktusen Igge, 20 cm hög
• Palmen Laura, 5 meter hög
• Köttätande växten Meatloaf, 0,7 meter hög
• Palmen Putte, 1 meter hög

• Palmer: En palm behöver 0,5 liter kranvatten per dag * sin längd i meter. En palm som är 3
meter hög behöver alltså 0,5 * 3 = 1,5 liter vatten/dag.

• Köttätande växter: Dessa behöver alltid en basnivå av 0,1 liter proteindryck per dag och
sedan ett extra tillskott med 0,2 liter proteindryck * sin längd i meter. En köttätande växt
som är 50 cm hög behöver alltså 0,1 + (0,2*0,5) = 0,2 liter proteindryck/dag.

• Kaktusar: Varje kaktus ska ha 2 cl mineralvatten/dag, oberoende av kaktusens storlek.

Eftersom formlerna är så krångliga, har hotellets ägare svårt att minnas hur mycket vätska varje växt
behöver och ber er om hjälp att skriva ett litet program som hjälper till att hålla reda på hur mycket
varje växt ska ha.

Systemet ska, ur ett användarperspektiv, fungera enligt följande:
En meddelande-ruta dyker upp på skärmen med texten ”Vilken växt ska få vätska?” Och en tom rad
bredvid. Ägaren fyller i växtens namn på tomma raden och programmet visar en ny ruta där det står
hur många liter växten ska få samt vilken sorts vätska (kranvatten, mineralvatten eller proteindryck)
som ska serveras.

 */
