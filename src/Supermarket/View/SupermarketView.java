package Supermarket.View;

import General.View;
import Supermarket.States.SupermarketState;

public class SupermarketView extends View{
    //TODO När programmet startar (startEvent) skriver SupermarketView ut alla parametrar
    //TODO Även rubriken förlopp samt kolumnnamn skrivs ut. Tiden 0 och namnet på starthändelsen skrivs ut
    //TODO Varje gång en händelse inträffar skrivs alla värden på parametrarna ut (när update kallas)
    //TODO Vid stängning skrivs allt förutom kundummer ut
    //TODO Vid stopp skrivs tid och händelsenamn ut. Därefter en rubrik resultat med statistik
    //TODO Skrive en update() metod som uppdaterar vad som visas
    private SupermarketState state;
    public  SupermarketView(SupermarketState state){
        super();
        this.state = state;
    }

    private void writeParameters() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N...........: " + state.getOpenRegisters());
        System.out.println("Max som ryms, M..........: " + state.getMaxCustomers());
        System.out.println("Ankomshastighet, lambda..: 1.0" + );
        System.out.println("Plocktider, [P_min..Pmax]: [" + state.getpMin() + ".." + state.getpMax() + "]:");
        System.out.println("Betaltider, [K_min..Kmax]: [" + state.getkMin() + ".." + state.getkMax() + "]:");
        System.out.println("Frö, f...................: "+ state.getSeed());
    }

    private void writeStart() {
        System.out.println("FÖRLOPP");
        System.out.println("=======");
        System.out.println("=======");
        System.out.println(" Tid Händelse  Kund  ?  led   ledT   I   $   :-(   köat    köT   köar  [Kassakö..]");
        System.out.println(0.0 + " Start");
    }
    private void writeState() {
        System.out.println(state.getCurrentTime() + " ");
        switch(eventName) {
            case "Ankomst":
                System.out.print("Ankomst      ");
            case "Plock":
                System.out.print("Plock        ");
            case "Betalning":
                System.out.print("Betalning    ");
            case "Stänger":
                System.out.print("Stänger      ");
        }
        System.out.print(customerNumber + "  ");
        System.out.print(openOrClosed + "    ");
        System.out.print(unusedRegisters + "    ");
        System.out.print(unusedRegistersTime + "    ");
        System.out.print(currentCustomers + "    ");
        System.out.print(customersThatPayed + "    ");
        System.out.print(customersMissed + "     ");
        System.out.print(customersThatQueued + "    ");
        System.out.print(timeOfQueuedCustomers + "     ");
        System.out.print(currentlyQueuedCustomers + "  ");
        System.out.print(listOfQueuedCustomers);
    }
    public void update() {
        setChanged();
        notifyObservers();
    }
}
