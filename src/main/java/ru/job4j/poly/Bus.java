package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void drive() {
        System.out.println("Bus is running");
    }

    @Override
    public void passengers(int count) {
        this.passengers += count;
    }

    @Override
    public double refuel(double liter) {
        return liter * 20.6;
    }
}
