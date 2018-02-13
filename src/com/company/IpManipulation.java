package com.company;

import java.util.Collections;
import java.util.Map;

/**
 * Class used to manipulate ip maps
 *
 * Created by MR on 2/12/18.
 */
public class IpManipulation {

    /**
     * Given a Map with <ip adrresses, occurrences> in input, returns a Map with the n most common, where n defined by the rank
     *
     * @param ipMap - Map<String,Integer>, where the key is the ip and the value is the numer of occurrence in the file
     * @param mostCommonIpMap - Map<String,Integer>, a subset of the ipMap, with the n most common, based on rank
     * @param rank - defines the degree of commonality to check: rank = n means find the n most common ip
     */
    public static void ReturnMostCommon(Map<String, Integer> ipMap, Map<String, Integer> mostCommonIpMap, int rank) {

        int currentValue = Collections.max(ipMap.values());
        int rankIter = 0;

        while ((currentValue > 0) & (rankIter < rank)) {

            boolean foundKey=false;

            for (Map.Entry<String, Integer> entry : ipMap.entrySet()) {

                // Iterate through hashmap
                if (entry.getValue() == currentValue) {
                    mostCommonIpMap.put(entry.getKey(), entry.getValue());

                    // Mark the key found
                    if (!foundKey) {
                        foundKey = true;
                    }

                    // CONSOLE OUTPUT
                    // For human users only - could be part of a logger
                    System.out.println("Ip : " + entry.getKey() + " has an occurrence of " +entry.getValue() + " elements");
                }
            }
            // Iterate on rank if found
            if (foundKey) {
                rankIter=rankIter+1;
            }
            currentValue = currentValue - 1;

        }
    }
}
