package com.directi.training.lsp.exercice_refactored;

public class ElectronicPool
{
    public void run()
    {
        ElectronicDuck electricDuck = new ElectronicDuck();
        quack(electricDuck);
        swim(electricDuck);
    }

    private void quack(ElectronicDuck... ducks)
    {
        for (ElectronicDuck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(ElectronicDuck... ducks)
    {
        for (ElectronicDuck duck : ducks) {
            duck.swim();
        }
    }

    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
