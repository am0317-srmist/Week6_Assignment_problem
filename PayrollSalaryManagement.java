public class PayrollSalaryManagement {
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: negative salary; starting at 0.");
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus rejected: amount must be positive");
                return;
            }
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax rejected: percent must be from 0 to 100");
                return;
            }
            basicSalary -= basicSalary * percent / 100.0;
            System.out.println("Tax deducted: " + percent + "%");
        }

        public double getNetSalary() { return basicSalary + bonus; }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
