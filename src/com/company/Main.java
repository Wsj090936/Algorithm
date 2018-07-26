package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AtomicInteger ai = new AtomicInteger();
        System.out.println(ai);

        int andIncrement = ai.getAndIncrement();
        System.out.println(ai);

    }
}
