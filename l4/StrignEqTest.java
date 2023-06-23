public class StrignEqTest {
    private static final String CONST_STRING = "test";

    public static void main(String[] args) {
        String varString1 = "test";
        String varString2_1 = "te";
        String varString2_2 = "st";

        System.out.println("CONST_STRING = " + CONST_STRING);
        System.out.println("varString1   = " + varString1);
        System.out.println("varString2   = " + varString2_1 + varString2_2);

        System.out.println(CONST_STRING == varString1);
        System.out.println(CONST_STRING == varString2_1 + varString2_2);
        System.out.println(varString1 == varString2_1 + varString2_2);

        System.out.println(CONST_STRING.equals(varString1));
        System.out.println(CONST_STRING.equals(varString2_1 + varString2_2));
        System.out.println(varString1.equals(varString2_1 + varString2_2));
    }
}
