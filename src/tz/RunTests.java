/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tz;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author лена
 */
public class RunTests{
    
     public static void main(String[] args) {
            TestSuite suite = new TestSuite("All Tests");
        TestResult result = new TestResult();
        suite.addTest(new IncrementTests("testIncrementClick"));
        suite.addTest(new ListTests("testList"));
        suite.run(result);
    }
    
    
    
}
