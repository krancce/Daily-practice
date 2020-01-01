import java.util.Arrays;

public class meetingRoom{

  public static class Interval{
    int start,end;
    public Interval(int start,int end){
      this.start=start;
      this.end=end;
    }
  }

  public static int minMeetingRooms(Interval[] intervals){
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i=0; i<intervals.length; i++){
      starts[i] = intervals[i].start;
      ends[i] = intervals[i].end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    int use = 0;
    int end = 0;
    for (int i=0; i<intervals.length; i++){
      if(starts[i] < ends[end]){
        use++;
      }else{
        end++;
      }
    }
    return use;
  }

  public static void main(String[] args) {
    Interval[] tmp = new Interval[3];
    Interval x = new Interval(0,30);
    Interval y = new Interval(5,10);
    Interval z = new Interval(15,20);
    tmp[0] = x;
    tmp[1] = y;
    tmp[2] = z;
    System.out.println(minMeetingRooms(tmp));
  }
}
