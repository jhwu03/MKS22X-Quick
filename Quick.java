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

   public static int partition(int [] data, int start, int end) {
     int range = end - start + 1;
     int pivot = (int) Math.abs(Math.random() * range);
     pivot = pivot + start;
     swap(data,start,pivot);
     int p = data[start];
     pivot = start;
     start ++;
     while(start <= end){
       if(data[start] > p){
         swap(data,start,end);
         end--;
       }else if(data[start] < p){
         start++;
       }
     }
     if(start == end){
       if(data[start] < p){
         swap(data,pivot,start);
         int temp = pivot;
         pivot = start;
         start = temp;
       }else{
         return start;
       }
     }
     return pivot;
   }
   public static void swap(int[] data,int r, int c) {
     int temp = data[r];
     data[r] = data[c];
     data[c] = temp;
}

public static void main(String[] args) {
  int[]ary = { 2, 10, 15, 23, 0,  5} ;  //sorted :  {0,2,5,10,15,23}
  String res = "" ;
  for (int i : ary) {
    res += i + ", " ;
  }
  System.out.println(res) ;
  System.out.println("We are running quickselect and finding the 0th smallest element!\n" + quickselect(ary, 0 )) ; // would return 0
  System.out.println(quickselect(ary, 1)) ; // would return 2
  System.out.println("Expected: 2\n\n") ;
  System.out.println(quickselect(ary, 2)) ; // would return 5
  System.out.println("Expected: 5\n\n") ;
  System.out.println(quickselect(ary, 3)) ; // would return 10
  System.out.println("Expected: 10\n\n") ;
  System.out.println(quickselect(ary, 4)) ; // would return 15
  System.out.println("Expected: 15\n\n") ;
  System.out.println(quickselect(ary, 5)) ; // would return 23
  System.out.println("Expected: 23\n\n") ;
}
}
