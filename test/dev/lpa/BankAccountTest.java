package dev.lpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
  
  private BankAccount account;
  
  @BeforeEach
  public void setup() {
    account =
      new BankAccount("Tim", "Buchalka", 1_000.00, BankAccount.CHECKING);
    System.out.println("Running a test ...");
  }
  
  @org.junit.jupiter.api.Test
  public void deposit() {
    double balance = account.deposit(200.00, true);
    assertEquals(1_200.00, balance, 0);
  }
  
  @Test
  public void withdraw() {
    fail("This test has yet to be implemented.");
  }
  
  @Test
  public void getBalance_deposit() {
    account.deposit(200.00, true);
    assertEquals(1_200.00, account.getBalance(), 0);
  }
  
  @Test
  public void getBalance_withdraw() {
    account.withdraw(200.00, true);
    assertEquals(800.00, account.getBalance(), 0);
  }
  
  @Test
  public void isChecking_true() {
    assertTrue(account.isChecking(), "The account is not a checking account.");
  }
  
//  @Test
//  public void dummyTest() {
//    assertEquals(20, 21);
//  }
}