package Supermarket.Main;

import General.EventQueue;
import General.Simulator;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.EndEvent;
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;
import Supermarket.View.SupermarketView;

public class Optimize {
     public static void main(String [] args){
          int result = findMinRegistersSeed(0, 10.00, 5, 1.0,
                  1234, 2.0, 3.0, 0.5, 1.0);
          System.out.println("Result: " + result);
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
          while(counter < 10){

          }
          return 0;
     }
}
