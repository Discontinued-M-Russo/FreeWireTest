package com.company;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Test class for IpManipulation class
 *
 * Created by 105051313 on 2/12/18.
 */
class IpManipulationTest {
    @Test
    void testReturnMostCommon() {
        //

        // Maps of the ips, without repetition. Key is the ip, value is the num. of occurrences
        Map<String, Integer> refIps = new HashMap<>();
        // Maps of the most common ips, defined based on a rank
        Map<String, Integer> testMostCommonIps = new HashMap<>();
        Map<String, Integer> refMostCommonIps = new HashMap<>();

        // Define a reference Map of ips
        refIps.put("127.0.0.1",3);
        refIps.put("127.0.0.2",5);
        refIps.put("192.168.10.2",1);

        //int refMaxValueInMap = 5;
        int refRank = 2;

        IpManipulation.ReturnMostCommon(refIps,testMostCommonIps,refRank);

        // Define a reference Map of 2 most common ips
        refMostCommonIps.put("127.0.0.2",5);
        refMostCommonIps.put("127.0.0.1",3);

        //Check the method returns what is expected
        Assert.check(testMostCommonIps.equals(refMostCommonIps));
    }

}