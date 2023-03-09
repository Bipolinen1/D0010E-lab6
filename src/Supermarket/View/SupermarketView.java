package Supermarket.View;

import General.EventQueue;
import General.View;
import Supermarket.States.SupermarketState;

import java.io.ObjectStreamClass;
import java.io.ObjectStreamException;
import java.util.Observable;

public class SupermarketView extends View{
    //TODO När programmet startar (startEvent) skriver SupermarketView ut alla parametrar
    //TODO Även rubriken förlopp samt kolumnnamn skrivs ut. Tiden 0 och namnet på starthändelsen skrivs ut
    //TODO Varje gång en händelse inträffar skrivs alla värden på parametrarna ut (när update kallas)
    //TODO Vid stängning skrivs allt förutom kundummer ut
    //TODO Vid stopp skrivs tid och händelsenamn ut. Därefter en rubrik resultat med statistik
    //TODO Skrive en update() metod som uppdaterar vad som visas
    private SupermarketState state;
    private EventQueue eventQueue;
    public  SupermarketView(SupermarketState state){
        super();
        this.state = state;
    }

    private void writeParameters() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N...........: " + state.getOpenRegisters());
        System.out.println("Max som ryms, M..........: " + state.getMaxCustomers());
        System.out.println("Ankomshastighet, lambda..:" + state.getLambda());
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
    private void writeState(Observable o, Object arg) {
        System.out.println(state.getCurrentTime() + " ");

        System.out.print(arg);
        System.out.print(state.getCurrentCustomerNumber() + "  ");
        System.out.print(state.isClosed() + "    ");
        System.out.print(state.getUnUsedRegisterTime() + "    ");
        System.out.print(state.getUnUsedRegisters() + "    ");
        System.out.print(state.getCustomersInStore()+ "    ");
        System.out.print(state.getPayedCustomers() + "    ");
        System.out.print(state.getMissedCustomers() + "     ");
        System.out.print(state.getCustomersThatQueued() + "    ");
        System.out.print(state.getTimeOfQueuedCustomers() + "     ");
        System.out.print(state.getCurrentlyQueuedCustomers() + "  ");
        System.out.print(state.getCheckoutQueue());
    }
    public void update(Observable o, Object arg) {
        writeParameters();
        writeStart();
        writeState(o, arg);
    }
}
