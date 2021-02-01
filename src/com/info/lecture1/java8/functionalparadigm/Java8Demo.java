package com.info.lecture1.java8.functionalparadigm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Java8Demo {

    public static void main(String[] args) {



/*        List<Integer> numsList = new ArrayList<>();
        numsList.add(2);
        numsList.add(3);
        numsList.add(4);
        numsList.add(5);

        DemoFunctionalInterface sampleInterfaceImpl = (int x) -> System.out.println(Math.pow(x, 2));

        numsList.forEach(x -> sampleInterfaceImpl.square(x));

        */

        String s1 = null;

        String s2 = "";

        Optional<String> optionalS = Optional.ofNullable("Check");


        if(optionalS.isPresent()){
            System.out.println(optionalS.get());
        }else{
            System.out.println("No value");
        }


    }

}

class Aucion{
    String id;
    String name;


}


@FunctionalInterface
interface DemoFunctionalInterface{
     void square(int x);
}