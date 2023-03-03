package com.github.mittyrobotics;


public class TrapezoidProfile {
    private TrapezoidProfile.Constraints constraints;
    private TrapezoidProfile.State desired;
    private TrapezoidProfile.State current;
    private double profUptime = 0;
    private boolean complete = false;

    public TrapezoidProfile(TrapezoidProfile.Constraints constraints, TrapezoidProfile.State desired, TrapezoidProfile.State initial){
        this.constraints=constraints;
        this.desired=desired;
        this.current=initial;

    }

    public void

//
//    public TrapezoidProfile calculate(double seconds){
//        return TrapezoidProfile.current;
//    }


    public class Constraints{
        private double maxV;
        private double maxA;

        public Constraints(double maxV, double maxA){
            this.maxV=maxV;
            this.maxA=maxA;
        }

    }

    public class State{
        private double pos;
        private double vel;
        public State(double pos, double vel){
            this.pos=pos;
            this.vel=vel;
        }
    }
}
