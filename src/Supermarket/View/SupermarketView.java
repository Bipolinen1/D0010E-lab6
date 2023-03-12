package Supermarket.View;
/**
 * Supermarket view handles the printing of information about the program printing out the start, each state and end.
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
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
    private EventQueue eventQueue;
    public  SupermarketView(SupermarketState state){
        super();
        this.state = state;
    }

    /**
     * writeStart() prints the starting information of the program, which includes number of registers, maximum number
     * customers, the rate of customers, range of pick time, range of pay time, and the seed.
     */
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

    /**
     * writeState() ether calls writeStart() if the program is starting, writeEnd() if the program is closing or
     * its main funcktionality of printing out the information of the current event.
     * Which includes current time, event, customer, if store is open, number of unused registers, time of unused registers
     * --- customers that payed, missed customers, number of customers who queued, total queue time, how many are queueing
     * and who is queuing.
     * In addition it also calls updateT() to update time events and calls setLastToPay to store the last paying customer.
     */
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
            if(state.getCustomersInStore() > 0 || !state.isClosed()){
                state.updateT();}
            if(event.getName() == "Pay") {
                state.setLastToPay();
            }
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

    /**
     * writeEnd() prints out the information about the number how customers that payed, that was missed,
     *  that needed to queue, the time spent queueing, and how long a number of registers has been opened.
     */
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
                ((state.getUnUsedRegisterTime() / state.getUnUsedRegisters()) / state.getLastToPay()) * 100, //Något fel här? Funkar inte för test 2
                state.getCustomersThatQueued(),
                state.getTimeOfQueuedCustomers(),
                (state.getTimeOfQueuedCustomers() / state.getCustomersThatQueued())



        ));
    }
    public void update(Observable o, Object arg) {
        writeState(o, arg);
    }
}
