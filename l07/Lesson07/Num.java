class Num {
    void add(int num1, int num2) {
        int add_num = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + add_num);
    }

    void mul(int num1, int num2) {
        int mul_num = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + mul_num);
    }

    void div(int num1, int num2) {
        if (num2 == 0) {
            System.out.println(num1 + " / " + num2 + " はゼロ除算です");
        } else {
            int div_num = num1 / num2;
            System.out.println(num1 + " / " + num2 + " = " + div_num);
        }
    }

    void mod(int num1, int num2) {
        if (num2 == 0) {
            System.out.println(num1 + " % " + num2 + " はゼロ除算です");
        } else {
            int mod_num = num1 % num2;
            System.out.println(num1 + " % " + num2 + " = " + mod_num);
        }
    }
}