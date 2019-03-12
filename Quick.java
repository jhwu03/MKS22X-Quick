public class Quick{
  public static int quickSelect(int[] data,int k){
    int ans = partition(data,0,data.length - 1);
    while(ans != k){
      if(ans < k){
        ans = partition(data,ans,data.length - 1);
      }else{
        ans = partition(data,0,ans);
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
     while(start < end){
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
}
