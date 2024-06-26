/*
 * Honesty Statement
 * This work was done individually and completely on my own. I did not share, reproduce, or alter
 * any part of this assignment for any purpose. I did not share code, upload this assignment online
 * in any form, or view/received/modified code written from anyone else. All deliverables were
 * produced entirely on my own. This assignment is part of an academic course at The University
 * of Texas at El Paso and a grade will be assigned for the work I produced.
*/

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Course: Adv. Object-Oriented Programming
 * <p>
 * Instructor: Daniel Mejia
 * <p>
 * Class Purpose: Test the method that check and control in the purchase class and main purhcase methods
 * <p>
 * Last Change: 11/16/2023
 *
 * @author Erik LaNeave
 * @version 1.4
 */

public class TestCaseForPurchase {

    /**
     * Test the ticketAmountCheck method in the Purchase class.
     */
    @Test
    public void testForUserTicketAmount() {
        Purchase testPurchase = new Purchase();

        try {
            testPurchase.ticketAmountCheck(0);
            fail("User Ticket Amount test 1 failed");
        } catch (TicketInputException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketAmountCheck(-32);
            fail("User Ticket Amount test 2 failed");
        } catch (TicketInputException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketAmountCheck(10);
            fail("User Ticket Amount test 3 failed");
        } catch (TicketInputException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketAmountCheck(Integer.MIN_VALUE);
            fail("User Ticket Amount test 4 failed");
        } catch (TicketInputException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketAmountCheck(Integer.MAX_VALUE);
            fail("User Ticket Amount test 5 failed");
        } catch (TicketInputException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketAmountCheck(4);
            assertTrue(true);
        } catch (TicketInputException e) {
            fail("User Ticket Amount test 6 failed");
        }
    }

    /**
     * Test the ticketCheck method in the purchase class
     */
    @Test
    public void testEventTicketAmount() {
        Purchase testPurchase = new Purchase();
        testPurchase.setCurrentTicketName("gold");
        Sport testEvent = new Sport();
        testPurchase.setCurrentEvent(testEvent);
        // The tickets in the event is null
        Stadium testVenue = new Stadium();
        testEvent.setVenue(testVenue);
        
        try {
            testPurchase.ticketCheck(40);
            fail("Event Ticket Amount test 1 failed");
        } catch (CheckTicketAvaException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketCheck(Integer.MIN_VALUE);
            fail("Event Ticket Amount test 2 failed");
        } catch (CheckTicketAvaException e) {
            assertTrue(true);
        }

        try {
            testPurchase.ticketCheck(Integer.MAX_VALUE);
            fail("Event Ticket Amount test 3 failed");
        } catch (CheckTicketAvaException e) {
            assertTrue(true);
        }
    }

    /**
     * Test the findTicketNum method in the purchase class
     */
    @Test
    public void testFindTicket() {
        Purchase testPurchase = new Purchase();

        testPurchase.setCurrentTicketName("Vip");
        assertEquals(0,testPurchase.findTicketNum());
        testPurchase.setCurrentTicketName("BRONZE");
        assertEquals(3,testPurchase.findTicketNum());
        testPurchase.setCurrentTicketName("GenERal AdmISSion");
        assertEquals(4,testPurchase.findTicketNum());
        testPurchase.setCurrentTicketName("Bonze");
        assertEquals(-1,testPurchase.findTicketNum());
        testPurchase.setCurrentTicketName("Not a ticket");
        assertEquals(-1,testPurchase.findTicketNum());
    }

    /**
     * Test the moneyCheckAndUpdate method in the purchase class
     */
    @Test
    public void testCustomerMoney() {
        Purchase testPurchase = new Purchase();
        Customer testCust = new Customer();
        testPurchase.setCurrentCustomer(testCust);
        
        testCust.setMoneyAvailable(0.0);
        try {
            testPurchase.moneyCheckAndUpdate(Integer.MAX_VALUE);
            fail("Customer Money test 1 failed");
        } catch (CustomerMoneyException e) {
            assertTrue(true);
        }

        testCust.setMoneyAvailable(5321.0);
        try {
            testPurchase.moneyCheckAndUpdate(2089.93);
            assertTrue(true);
        } catch (CustomerMoneyException e) {
            fail("Customer Money test 2 failed");
        }
    }

    /**
     * Test the getTotalCost method in the purchase class.
     */
    @Test
    public void testTotalCost() {
        Purchase testPurchase = new Purchase();
        Sport testEvent = new Sport();
        testEvent.setId(1);
        testEvent.setName("Test");
        testEvent.setEventType("Sport");
        testEvent.setDate("12/1/2021");
        testPurchase.setCurrentEvent(testEvent);
        testPurchase.setCurrentTicketName("gold");
        Customer testCust = new Customer();
        testPurchase.setCurrentCustomer(testCust);

        //When customer is a miner member
        testCust.setTicketMinerMember(true);
        Invoice temp1 = testPurchase.getTotalCost(0.0, 0);
        assertEquals(2.43,temp1.getTotalPrice(),0);
        Invoice temp2 = testPurchase.getTotalCost(0.0, 1);
        assertEquals(2.43,temp2.getTotalPrice(),0);
        Invoice temp3 = testPurchase.getTotalCost(14.86, 2);
        assertEquals(31.75,temp3.getTotalPrice(),0);
        Invoice temp4 = testPurchase.getTotalCost(1045.69, 4);
        assertEquals(4128.42,temp4.getTotalPrice(),0);

        //When customer is not a miner member
        testCust.setTicketMinerMember(false);
        temp1 = testPurchase.getTotalCost(0.0, 0);
        assertEquals(2.70,temp1.getTotalPrice(),0);
        temp2 = testPurchase.getTotalCost(0.0, 1);
        assertEquals(2.70,temp2.getTotalPrice(),1);
        temp3 = testPurchase.getTotalCost(14.86, 2);
        assertEquals(35.28,temp3.getTotalPrice(),0);
        temp4 = testPurchase.getTotalCost(1045.69, 4);
        assertEquals(4587.14,temp4.getTotalPrice(),0);
    }
}
