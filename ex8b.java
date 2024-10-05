/*The Airplane always needs to check with the Airport to see if it has an available runway
before it's able to take off or land. Simulate the above-mentioned scenario using
multithreading.*/
package ex8b;

class Airport {

    private boolean runwayAvailable = true;



    public synchronized boolean requestRunway(String airplaneName) {

        System.out.println(airplaneName + " is requesting to land on the runway...");

        

        if (runwayAvailable) {

            runwayAvailable = false; // Lock the runway

            System.out.println(airplaneName + " has been granted access to land on the runway.");

            return true;

        } else {

            System.out.println(airplaneName + " is waiting for the runway to be free.");

            return false;

        }

    }



    public synchronized void releaseRunway(String airplaneName) {

        runwayAvailable = true; // Unlock the runway

        System.out.println(airplaneName + " has left the runway.");

    }

}



class Airplane extends Thread {

    private final String name;

    private final Airport airport;



    public Airplane(String name, Airport airport) {

        this.name = name;

        this.airport = airport;

    }



    @Override

    public void run() {

        try {

            while (!airport.requestRunway(name)) {

                Thread.sleep(1000);  // Wait and try again if the runway is not free

            }

            System.out.println(name + " is taking off/landing...");

            Thread.sleep(2000);  // Simulate time taken for takeoff/landing

            airport.releaseRunway(name);

        } catch (InterruptedException e) {

            System.out.println(name + " was interrupted.");

        }

    }

}



public class ex8b {

	public static void main(String[] args) {

        Airport airport = new Airport();

        System.out.println("Ashic Paul  URK23CS1021");

        Airplane airplane1 = new Airplane("Airplane 1", airport);

        Airplane airplane2 = new Airplane("Airplane 2", airport);

        Airplane airplane3 = new Airplane("Airplane 3", airport);



        airplane1.start();

        airplane2.start();

        airplane3.start();

    }

}
