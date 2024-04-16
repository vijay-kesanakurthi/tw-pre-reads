public class Factorial {

    public long calculate(int number) {
        if(number == 0 || number ==1) {
            return 1;
        }
        var prev = number - 1;

        return number * calculate(prev);
    }
}
