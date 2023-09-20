package ExtraCallExercises.July13th;

public enum DayOfTheWeek {
    MONDAY(1), TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);

    private int noOfDay;
    private DayOfTheWeek(int noOfDay){
        this.noOfDay = noOfDay;
    }
    private int getNoOfDay(){
        return noOfDay;
    }

    public static void main(String[] args){
        System.out.println(DayOfTheWeek.FRIDAY);
    }

}
