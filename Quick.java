import java.util.* ;
import java.io.* ;
public class Quick{
  public static int quickselect(int[] data,int k){
     int ans = partition(data,0,data.length - 1);
     int end = data.length - 1 ;
     int start = 0;
     while(ans != k){
       if(ans < k){
         ans = partition(data,ans,end);
       }else{
         ans = partition(data,start,ans);
       }
     }
     return data[ans];
   }

   public static void quicksort(int[] data) {
     if(data.length > 0){
     quicksort(data, 0, data.length - 1);
     }
   }

   public static void quicksort(int[] data, int start, int end) {
     if (start >= end) {
       return;
     }
     int pivot = partition(data, start, end);
     quicksort(data, start, pivot-1);
     quicksort(data, pivot+1, end);
   }

  public static int partition (int [] data, int start, int end){
    int pivot = 0;
    Random r = new Random() ;
    int middle = data[(start + end) / 2] ;
    if(data[start] > data[end] && data[start] < middle || data[start] < data[end] && data[start] > middle ){
       pivot = start;
     }else if(data[end] > data[start] && data[end] < middle || data[end] < data[start] && data[end] > middle){
       pivot = end;
     }else{
       pivot = (start + end) / 2;
     }
     swap(data,pivot,start);
     pivot = start;
     start++;
     while(start != end) {
       int n = -1;
       if(data[start] == data[pivot] ){
         //n = ((Math.random() * 2) % 2)== 0;
         n = r.nextInt(2);
       }
       if(data[start] > data[pivot] || n == 1 ) {
         swap(data, start, end);
         end--;
       }else if(data[start] < data[pivot] || n == 0 ) {
         start++;
       }
     }
     if(data[pivot] < data[start]) {
       swap(data,start - 1, pivot);
       return start - 1;
     }else{
       swap(data, start, pivot);
       return start;
     }
  }

    public static void swap(int[] data,int r, int c) {
      int temp = data[r];
      data[r] = data[c];
      data[c] = temp;
 }

 // public static void main(String[] args) {
 //   int[]ary = { 2, 10, 15, 23, 0,  5} ;  //sorted :  {0,2,5,10,15,23}
 //   String res = "" ;
 //   for (int i : ary) {
 //     res += i + ", " ;
 //   }
 //   System.out.println(res) ;
 //   System.out.println("We are running quickselect and finding the 0th smallest element!\n" + quickselect(ary, 0 )) ; // would return 0
 //   System.out.println(quickselect(ary, 1)) ; // would return 2
 //   System.out.println("Expected: 2\n\n") ;
 //   System.out.println(quickselect(ary, 2)) ; // would return 5
 //   System.out.println("Expected: 5\n\n") ;
 //   System.out.println(quickselect(ary, 3)) ; // would return 10
 //   System.out.println("Expected: 10\n\n") ;
 //   System.out.println(quickselect(ary, 4)) ; // would return 15
 //   System.out.println("Expected: 15\n\n") ;
 //   System.out.println(quickselect(ary, 5)) ; // would return 23
 //   System.out.println("Expected: 23\n\n") ;
 // }
 // MR K DRIVER
 public static void main(String[] args) {
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
