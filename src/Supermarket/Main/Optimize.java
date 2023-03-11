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

     }

     public SupermarketState runSimulationOnce(
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

     public int findMinRegistersSeed(double openingTime, double closingTime, int maxCustomers,
                                                  double lambda, long seed, double kMin, double kMax, double pMin,
                                                  double pMax){
          int counter = 0;
          int amountOfRegisters = 1;
          int bestAmountOfRegisters = runSimulationOnce(openingTime, closingTime, maxCustomers, amountOfRegisters,
                  lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
          while(counter < 100){
               if(runSimulationOnce(openingTime, closingTime, maxCustomers, amountOfRegisters,
                       lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers() < bestAmountOfRegisters){
                    bestAmountOfRegisters = runSimulationOnce(openingTime, closingTime, maxCustomers, amountOfRegisters,
                            lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
                    counter = 0;
               }
               else{
                    counter++;
               }
               amountOfRegisters++;
          }
          return bestAmountOfRegisters;
     }
}
