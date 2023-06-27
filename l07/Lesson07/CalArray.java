public class CalArray{
    String name;
    private int sum = 0;
    private int mul = 1;

    public void output(){
        System.out.println(" [ " + name + " ] ");
        System.out.println("sum : " + sum);
        System.out.println("mul : " + mul);
    }

    public void add(int[] array){
        for(int i = 0; i < array.length; i++){
        sum = sum + array[i];
        }
    }

    public void mul(int[] array){
        for(int i = 0; i < array.length; i++){
        mul = mul * array[i];
        }
    }
}