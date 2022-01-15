class AngleBWHandsOfClock {
    public double angleClock(int hour, int minutes) {
        double degMin = minutes*6;
        double degHour = ((hour == 12)?0:hour*30) + minutes*0.5;
        double returnval = (degHour > degMin) ? degHour - degMin : degMin - degHour;
        return (returnval > 180)?360.0-returnval:returnval;
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().angleClock(1,57));
    }
}