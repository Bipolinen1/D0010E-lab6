package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    @Override
    public void execute() {
        //TODO: Customer har plockat varorna o ska nu betala
        // Kolla om det finns lediga kassor. Om ja, låt de skanna varorna o betala.
        //TODO: Minska antal lediga kassor med 1 och generera en framtida PayEvent för Customer o lägg den till EventQueuen.
        // Om nej till lediga kassor, stå Customern i kassokön. OBS: Det finns endast en kassöko

        if(state.)

    }
}
