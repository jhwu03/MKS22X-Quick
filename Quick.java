public class Quick{
  public static int quickSelect(){
    return 1;
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
         swap(data,pivot,start);
         start++;
         pivot++;
       }else{
         start++;
       }
     }
     return pivot;
   }
   public static void swap(int[] data,int r, int c) {
     int temp = data[r];
     data[r] = data[c];
     data[c] = temp;
}
}
