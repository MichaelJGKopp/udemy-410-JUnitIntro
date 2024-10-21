package dev.lpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountParameterizedTest {
  
  private BankAccount account;
  
  @BeforeEach // @Before in JUnit 4
  public void setup() {
    account = new BankAccount(
      "Tim", "Buchalka", 1_000.00, BankAccount.CHECKING);
    System.out.println("Running a test...");
  }
  
  @ParameterizedTest
  @CsvSource({
               "100.00, true, 1100.00",
               "200.00, true, 1200.00",
               "325.14, true, 1325.14",
               "489.33, true, 1489.33",
               "1_000.00, true, 2_000.00"
  })
  public void deposit(double amount, boolean branch, double expectedBalance) {
    double balance = account.deposit(amount, branch);
    assertEquals(expectedBalance, balance, .01);
  }
}
