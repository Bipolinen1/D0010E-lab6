package Supermarket.View;
import General.Event;
import General.EventQueue;
import General.View;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.CustomerEvent;
import Supermarket.Events.EndEvent;
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;
import java.util.Observable;

public class SupermarketView extends View{
    //TODO När programmet startar (startEvent) skriver SupermarketView ut alla parametrar
    //TODO Även rubriken förlopp samt kolumnnamn skrivs ut. Tiden 0 och namnet på starthändelsen skrivs ut
    //TODO Varje gång en händelse inträffar skrivs alla värden på parametrarna ut (när update kallas)
    //TODO Vid stängning skrivs allt förutom kundummer ut
    //TODO Vid stopp skrivs tid och händelsenamn ut. Därefter en rubrik resultat med statistik
    //TODO Skrive en update() metod som uppdaterar vad som visas
    private SupermarketState state;
    private double lastToPay;
    private EventQueue eventQueue;
    public  SupermarketView(SupermarketState state){
        super();
        this.state = state;
    }


    private void writeStart(Observable o, Object arg) {
        Event event = (Event) arg;
        System.out.println(String.format(
                """
                PARAMETRAR
                ==========
                Antal kassor, N...........: %s
                Max som ryms, M...........: %s
                Ankomsthastighet, lambda..: %s
                Plocktider, [P-min..Pmax]: [%s..%s]
                Betaltider, [K_min..Kmax]: [%s..%s]
                Frö, f...................: %s
                
                Förlopp
                =======
                   Tid Händelse  Kund  ?  led   ledT   I   $   :-(  köat   köT   köar    [Kasakö..]
                  %.2f %s""",
                state.getOpenRegisters(),
                state.getMaxCustomers(),
                state.getLambda(),
                state.getpMin(),
                state.getpMax(),
                state.getkMin(),
                state.getkMax(),
                state.getSeed(),
                state.getCurrentTime(),
                event.getName()
        ));

    }
    private void writeState(Observable o, Object arg) {
        Event event = (Event) arg;


        if(event instanceof StartEvent){
            writeStart(o, arg);
        }
        else if(event instanceof EndEvent){
            writeEnd();
        }
        else if (event instanceof CloseEvent){
            state.updateT();
            System.out.println(String.format(
                    "%6.2f %-9s %4s %2s %4d %6.2f % 3d %3d %4d %5d %6.2f %6d    %s",
                    state.getCurrentTime(),
                    event.getName(),
                    "---",
                    state.isClosed() ? "S" : "Ö",
                    state.getUnUsedRegisters(),
                    state.getUnUsedRegisterTime(),
                    state.getCustomersInStore(),
                    state.getPayedCustomers(),
                    state.getMissedCustomers(),
                    state.getCustomersThatQueued(),
                    state.getTimeOfQueuedCustomers(),
                    state.getCurrentlyQueuedCustomers(),
                    state.getCheckOutQueueString()
            ));
        }
        else {
            CustomerEvent customerEvent = (CustomerEvent) event;
            state.updateT();
            System.out.println(String.format(
                    "%6.2f %-9s %4d %2s %4d %6.2f %3d %3d %4d %5d %6.2f %6d    %s",
                    state.getCurrentTime(),
                    event.getName(),
                    customerEvent.getCustomer().getCustomerNumber(),
                    state.isClosed() ? "S" : "Ö",
                    state.getUnUsedRegisters(),
                    state.getUnUsedRegisterTime(),
                    state.getCustomersInStore(),
                    state.getPayedCustomers(),
                    state.getMissedCustomers(),
                    state.getCustomersThatQueued(),
                    state.getTimeOfQueuedCustomers(),
                    state.getCurrentlyQueuedCustomers(),
                    state.getCheckOutQueueString()
            ));
        }

    }

    private void writeEnd() {
        System.out.println(String.format(
                """
                        %.2f Stop
                          
                          RESULTAT
                          ========  
                           
                          1) Av %d kunder handlade %d medan %d missades.
                           
                          2) Total tid %d kassor varit lediga: %.2f te.
                             Genomsnittlig ledig kassatid: %.2f te (dvs %.2f%% av tiden från öppning tills sista kunden betalat).
                               
                          Total tid %d kunder tvingats köa: %.2f te.
                          Genomsnittlig kötid: %.2f te.
                               
                            
                        """,
                state.getCurrentTime(),
                state.getTotalCustomers(),
                state.getPayedCustomers(),
                state.getMissedCustomers(),
                state.getUnUsedRegisters(),
                state.getUnUsedRegisterTime(),
                (state.getUnUsedRegisterTime() / state.getUnUsedRegisters()),
                ((state.getUnUsedRegisterTime() / state.getUnUsedRegisters()) / state.getPreviousTime()) * 100,
                state.getCustomersThatQueued(),
                state.getTimeOfQueuedCustomers(),
                (state.getTimeOfQueuedCustomers() / state.getCustomersThatQueued())



        ));
    }
    public void update(Observable o, Object arg) {
        writeState(o, arg);
    }
}
