package com.algorithm;

public class test2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        //总精力值
        int totalEnergy=0;
        for (int e:energy){
            totalEnergy+=e;
        }
        int i = initialEnergy > totalEnergy ? 0 : totalEnergy + 1 - initialEnergy;
        for (int e:experience){
            if (initialExperience<=e){
                i+=e+1-initialExperience;
                initialExperience=e+1;
            }
            initialExperience+=e;
        }
        return i;
    }
}
