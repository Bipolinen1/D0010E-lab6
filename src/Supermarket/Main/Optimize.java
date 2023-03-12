package Supermarket.Main;
/**
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import General.EventQueue;
import General.Simulator;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.EndEvent;
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;
import Supermarket.View.SupermarketView;

public class Optimize {
     public static void main(String [] args){
          int result = findMinRegistersSeed(0, 8.00, 7, 3.0,
                  13, 0.35, 0.6, 0.6, 0.9);
          System.out.println("Smallest amount of registers yielding least missed customers: "  + result);
     }

     public static SupermarketState runSimulationOnce(
             double openingTime, double closingTime, int maxCustomers, int maxOpenRegisters, double lambda,
             long seed, double kMin, double kMax, double pMin, double pMax){
          EventQueue eventQueue = new EventQueue();
          SupermarketState state = new SupermarketState(
                  maxCustomers,
                  maxOpenRegisters,
                  lambda,
                  seed,
                  kMin,
                  kMax,
                  pMin,
                  pMax);

          eventQueue.addEvent(new StartEvent(eventQueue, openingTime, state));
          eventQueue.addEvent(new CloseEvent(eventQueue, closingTime, state));
          eventQueue.addEvent(new EndEvent(eventQueue, 999, state));

          Simulator simulator = new Simulator(eventQueue, state);
          simulator.run();
          return state;
     }

     public static int findMinRegistersSeed(double openingTime, double closingTime, int maxCustomers,
                                                  double lambda, long seed, double kMin, double kMax, double pMin,
                                                  double pMax) {
          int counter = 0;
          int numberOfRegisters = 0;
          int bestAmountOfRegisters = 0;
          int lowestMissed = runSimulationOnce(openingTime, closingTime, maxCustomers, numberOfRegisters,
                  lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
          while(counter < 10){
               if(runSimulationOnce(openingTime, closingTime, maxCustomers, numberOfRegisters,
                       lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers() < lowestMissed){
                    lowestMissed = runSimulationOnce(openingTime, closingTime, maxCustomers, numberOfRegisters,
                            lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
                    bestAmountOfRegisters = runSimulationOnce(openingTime, closingTime, maxCustomers, numberOfRegisters,
                            lambda, seed, kMin, kMax, pMin, pMax).getOpenRegisters();
                    counter = 0;
               }
               else{
                    counter++;
               }
               numberOfRegisters++;
          }
          return bestAmountOfRegisters;
     }

     public static int finMinRegisters(){

     }
}
