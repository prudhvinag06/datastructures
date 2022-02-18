/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Pair{
    int val;
    int count;
    
    Pair(int val, int count){
        this.val = val;
        this.count = count;
    }
}

class Sort implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        if(a.count == b.count){
            return a.val - b.val;
        }
        else{
            return b.count - a.count; 
        }
    }
}
class GFG {
    
    public static void solve(int n, int[] arr){
        int[] count = new int[60];
        for(int x : arr)
        count[x]++;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < 60; i++){
            if(count[i] > 0)
            list.add(new Pair(i, count[i]));
        }
        
        Collections.sort(list, new Sort());
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < count[list.get(i).val]; j++)
            System.out.print(list.get(i).val + " ");
        }
        System.out.println();
    }
    
    
	public static void main (String[] args) {
		//code
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		while(tc-- > 0){
		    int n = scan.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < n; i++)
		    arr[i] = scan.nextInt();
		    solve(n, arr);
		}
		
	}
}
