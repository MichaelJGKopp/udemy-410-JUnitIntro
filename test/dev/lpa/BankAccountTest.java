package dev.lpa;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
  
  private BankAccount account;
  private static int count;
  
  @BeforeAll
  public static void beforeClass(){
    System.out.println("@BeforeAll runs only once before any test method! Count = " + count++);
  }
  
  @BeforeEach
  public void setup() {
    account =
      new BankAccount("Tim", "Buchalka", 1_000.00, BankAccount.CHECKING);
    System.out.println("setup() with @BeforeEach runs before every method to start fresh.");
  }
  
  @org.junit.jupiter.api.Test
  public void deposit() {
    double balance = account.deposit(200.00, true);
    assertEquals(1_200.00, balance, 0);
  }
  
  @Test
  public void withdraw_branch() {
    double balance = account.withdraw(600.00, true);
    assertEquals(400.00, balance, 0);
  }
  
  @Test
  public void withdraw_notBranch() {
    assertThrows(IllegalArgumentException.class,
      () -> account.withdraw(600.00, false));
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
  
  @AfterAll
  public static void afterClass() {
    System.out.println("@AfterAll is executed only once after class methods. Count = " + count++);
  }
  
  @AfterEach
  public void teardown() {
    System.out.println("Count = " + count++);
  }
//  @Test
//  public void dummyTest() {
//    assertEquals(20, 21);
//  }
}