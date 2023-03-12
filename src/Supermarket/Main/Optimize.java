package Supermarket.Main;
/**
 * Main program to optimize th simulation
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import General.EventQueue;
import General.Simulator;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.EndEvent;
import Supermarket.Events.StartEvent;
import Supermarket.K;
import Supermarket.States.SupermarketState;
import Supermarket.View.SupermarketView;

import java.awt.*;
import java.util.Random;

public class Optimize {
     /**
      * Runs the differnt optimization methods
      * @param args
      */
     public static void main(String [] args){
          /*int result = findMinRegistersSeed(0, K.END_TIME, K.STOP_TIME, K.M, K.L,
                  K.SEED, K.LOW_PAYMENT_TIME, K.HIGH_PAYMENT_TIME, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME);
          System.out.println("Smallest amount of registers yielding least missed customers: "  + result);*/
          int result = findMinRegisters(0, K.END_TIME, K.STOP_TIME, K.M, K.L,
                  K.LOW_PAYMENT_TIME, K.HIGH_PAYMENT_TIME, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME);
          System.out.println("Smallest amount of registers yielding least missed customers: "  + result);
     }

     /**
      * Runs a simulation and returns the end state
      * @param openingTime the opening time
      * @param closingTime the closing time
      * @param maxCustomers max amount of customers allowed in the store
      * @param maxOpenRegisters the amount of openRegister
      * @param lambda the arrival rate of customers
      * @param seed the seed
      * @param kMin the minimum pay time
      * @param kMax maximum pay time
      * @param pMin minimum pick time
      * @param pMax maximum pick time
      * @return the state
      */
     public static SupermarketState runSimulationOnce(
             double openingTime, double closingTime, double stopTime, int maxCustomers, int maxOpenRegisters, double lambda,
             long seed, double kMin, double kMax, double pMin, double pMax){
          // Creates an EventQueue
          EventQueue eventQueue = new EventQueue();
          // Creates a State
          SupermarketState state = new SupermarketState(
                  maxCustomers,
                  maxOpenRegisters,
                  lambda,
                  seed,
                  kMin,
                  kMax,
                  pMin,
                  pMax);

          // Adds start, closing and end events
          eventQueue.addEvent(new StartEvent(eventQueue, openingTime, state));
          eventQueue.addEvent(new CloseEvent(eventQueue, closingTime, state));
          eventQueue.addEvent(new EndEvent(eventQueue, stopTime, state));

          // Creates a instance of simulator
          Simulator simulator = new Simulator(eventQueue, state);
          simulator.run();
          return state;
     }

     /**
      * Finds the minimum amount of register yielding the least missed customer for a specific seed
      * @param openingTime the opening time
      * @param closingTime the closing time
      * @param maxCustomers max amount of customers allowed in the store
      * @param lambda the arrival rate of customers
      * @param seed the seed
      * @param kMin the minimum pay time
      * @param kMax maximum pay time
      * @param pMin minimum pick time
      * @param pMax maximum pick time
      * @return the amount of registers yielding least missed customers
      */
     public static int findMinRegistersSeed(double openingTime, double closingTime, double stopTime, int maxCustomers,
                                                  double lambda, long seed, double kMin, double kMax, double pMin,
                                                  double pMax) {
          int counter = 0;
          int numberOfRegisters = 0;
          int bestAmountOfRegisters = 0;
          int lowestMissed = runSimulationOnce(openingTime, closingTime, stopTime, maxCustomers, numberOfRegisters,
                  lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
          // Loops until same result 10 times
          while(counter < 20){
               // updates lowestMissed, bestAmountOfRegister and counter if the simulation yields a better result
               if(runSimulationOnce(openingTime, closingTime, stopTime, maxCustomers, numberOfRegisters,
                       lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers() < lowestMissed){
                    lowestMissed = runSimulationOnce(openingTime, closingTime, stopTime, maxCustomers, numberOfRegisters,
                            lambda, seed, kMin, kMax, pMin, pMax).getMissedCustomers();
                    bestAmountOfRegisters = runSimulationOnce(openingTime, closingTime, stopTime, maxCustomers, numberOfRegisters,
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

     public static int findMinRegisters(double openingTime, double closingTime, double stopTime, int maxCustomers,
                                        double lambda, double kMin, double kMax, double pMin,
                                        double pMax){
          int counter = 0;
          Random rand = new Random();
          int minRegisters = findMinRegistersSeed(openingTime, closingTime, stopTime, maxCustomers,
                  lambda, rand.nextInt(), kMin, kMax, pMin, pMax);

          while(counter < 100){
               int currentRegisters = findMinRegistersSeed(openingTime, closingTime, stopTime, maxCustomers,
                       lambda, rand.nextInt(), kMin, kMax, pMin, pMax);
               if(currentRegisters <= minRegisters){
                    counter++;
               }
               else{
                    minRegisters = currentRegisters;
                    counter = 0;
               }
          }
          return minRegisters;
     }
}
