public class Calculate {
    
    private double initialVelocity;
    private double acceleration;
    private double time;
    private double finalVelocity = 0;

    public Calculate(){
        initialVelocity = 0;
        acceleration = 0;
        time = 0;
    }

    public double getInitialVelocity(){
        return initialVelocity;
    }
    public void setInitialVelocity(double initialVelocity){
        this.initialVelocity = initialVelocity;
    }
    public double getAcceleration(){
        return acceleration;
    }
    public void setAcceleration(double acceleration){
        this.acceleration = acceleration;
    }
    public double getTime(){
        return time;
    }
    public void setTime(double time){
        this.time = time;
    }

    public double calculator(){
       
       return finalVelocity = this.getInitialVelocity() + this.getAcceleration() *
                     this.getTime();
    }
}
