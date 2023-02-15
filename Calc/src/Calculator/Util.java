package Calculator;

public class Util {
    public static boolean CheckNumbers(String[]arrOpertaion){
        try{
            Integer.parseInt(arrOpertaion[0]);
            Integer.parseInt(arrOpertaion[2]);
        }catch(NumberFormatException e) {
            System.err.println("Калькулятор принимает на вход только целые числа");
            return false;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Неправильный формат ввода");
            return false;
        }
        if (Integer.parseInt(arrOpertaion[0])<1 || Integer.parseInt(arrOpertaion[0])>10){
            return false;
        }
        if (Integer.parseInt(arrOpertaion[2]) <1 || Integer.parseInt(arrOpertaion[2])> 10 ){
            return false;
        }
        return true;
    }
}
