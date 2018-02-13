package com.company;

import java.io.*;
import java.util.*;

/**
 * Class to read ip from text files and classify them based on occurrence
 *
 * Ips from a text file are parsed and sorted in a HashMap, with the Ip as a key and the occurrence of it as a value.
 * The map is then available for manipulation, like definiton of the 10 most common ips
 *
 * Main working assumption - ip list is auto-generated, one ip per line. No controls are in place against it here.
 * IpManipulation class could be a placeholder for such handlers
 *
 * Created by MR on 2/12/18.
 */
public class ReadIpFile {

    public static void main(String[] args) {

        // CONSOLE INPUT/OUTPUT
        // Defining the path to the file  - this could be an input variable or a configuration item
        System.out.println("************************************************");
        // Full path to the file to read
        String fileName = null;
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter full path to the input file :");
        fileName = inputReader.nextLine();
        System.out.println("You entered : " + fileName);
        System.out.println("************************************************");


        //Simple integer to check number of entries in the file
        Integer count = 0;

        // This will reference one line at a time
        String line = null;

        // Maps of the ips, without repetition. Key is the ip, value is the num. of occurrences
        Map<String, Integer> ipMap = new HashMap<>();

        // Maps of the most common ips, defined based on a rank
        Map<String, Integer> mostCommonIpMap = new HashMap<>();

        // rank indicates the degree of commonality we want to check: rank = n means find the n most common ip
        // current implementation defaults to 10, but this could easily be another input
        Integer rank = 10;

        try {
            // FileReader reads text files in the default encoding
            FileReader fileReader =
                    new FileReader(fileName);

            // Wrap FileReader in BufferedReader
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (ipMap.containsKey(line)) {
                    //increment occurrences
                    ipMap.put(line, ipMap.get(line) + 1);
                } else {
                    ipMap.put(line, 1);
                }
                //increment counter
                count = count + 1;
            }

            // Close files
            bufferedReader.close();

            // CONSOLE OUTPUT
            // For human users only - could be part of a logger
            System.out.println("************************************************");
            System.out.println("Total number of ips in the file: " + count);
            System.out.println("Number of different ips in the file (no repetitions): " + ipMap.size());
            System.out.println("************************************************");
            System.out.println("Highest number of different occurences for a single ip: " + Collections.max(ipMap.values()));
            System.out.println("************************************************");

            // Loop through the map for the  most common ips, defined by rank, decreasing from the most common
            // Values are saved in a specific map for reuse, together with their occurrence - output is also shown to console
            IpManipulation.ReturnMostCommon(ipMap, mostCommonIpMap, rank);

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

    }

}
