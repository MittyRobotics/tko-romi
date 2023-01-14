package com.github.mittyrobotics;

public class TrapezoidProfile {
    private double t=0;
    private double Tacc;
    private double Tmax;
    private double Tdec;
    private double V0;
    private double Vf;

    private double Amax;
    private double Vmax;
    private double d;
    private double P0;
    private double Pf;

    public TrapezoidProfile(TrapezoidProfile.Constraints constraints, TrapezoidProfile.State goal, TrapezoidProfile.State start){
        this.Amax=constraints.Amax;
        this.Vmax=constraints.Vmax;
        this.d=(goal.pos-start.pos);
        this.V0=start.vel;
        this.Vf=goal.vel;
        P0=start.pos;
        Pf=goal.pos;

        Tacc = (Vmax-V0)/Amax;
        Tmax = ((Pf-P0)/Vmax)
                + V0/(2*Amax*Vmax)
                - (Vmax)/Amax
                + (Vf*Vf)/(2*Amax*Vmax);
        Tdec = (Vmax-Vf)/Amax;

    }

    public State calculateNext (double dt){
        double v=0;
        double p=0;
        t+=dt;
        if (t<Tacc){
            v=Amax*t+V0;
            p=0.5*Amax*t*t + V0*t;
        }
        else if (Tacc<t && t<Tacc+Tmax){
            v=Vmax;
            p=0.5*Amax*Tacc*Tacc + V0*Tacc
                    + Vmax*t;
        }
        else if (t>Tacc+Tmax && t<Tacc+Tmax+Tdec) {
            v=-Amax*(t-Tmax-Tacc) + Vmax;
            p=0.5*Amax*Tacc*Tacc + V0*Tacc
                    + Vmax*Tmax
                    + 0.5*Amax*Tdec*Tdec + Vf*Tdec;
        }
        else{
            v=Vf;
            p=d;
        }
        return new State(p, v);

    }

    public State calculateAtT (double time){
        double v=0;
        double p=0;
        double t = time;
        if (t<Tacc){
            v=Amax*t+V0;
            p=0.5*Amax*t*t + V0*t;
        }
        else if (Tacc<t && t<Tacc+Tmax){
            v=Vmax;
            p=0.5*Amax*Tacc*Tacc + V0*Tacc
                    + Vmax*t;
        }
        else if (t>Tacc+Tmax && t<Tacc+Tmax+Tdec) {
            v=-Amax*(t-Tmax-Tacc) + Vmax;
            p=0.5*Amax*Tacc*Tacc + V0*Tacc
                    + Vmax*Tmax
                    + 0.5*Amax*Tdec*Tdec + Vf*Tdec;
        }
        else{
            v=Vf;
            p=d;
        }
        return new State(p, v);

    }

    static class Constraints {
        private double Vmax;
        private double Amax;
        public Constraints (double Vmax, double Amax){
            this.Vmax=Vmax;
            this.Amax=Amax;
        }
    }

    static class State {
        double pos;
        double vel;

        public State (double pos, double vel){
            this.pos=pos;
            this.vel=vel;
        }
    }

}

