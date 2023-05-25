public  class CalculationsClass {
    private double number1;
    private double number2;
    private double answer;
    public CalculationsClass(){
        number1 = 0;
        number2 = 0;
        answer = 0;
    }
    public double getNum1(){
        return number1;
    }
    public void setNum1(double number1){
        this.number1 = number1;
    }
    public double getNum2(){
        return number2;
    }
    public void setNum2(double number2){
        this.number2 = number2;
    }
    public double addNums(){
        return answer = number1 + number2;
    }
    public double subtractNums(){
        return answer = number1 - number2;
    }
    public double multiplyNums(){
        return answer = number1 * number2;
    }
    public double divideNums(){
        return answer = number1 / number2;
    }
}
