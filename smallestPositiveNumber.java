import java.util.*;
import java.lang.*;
import java.io.*;

class smallestPositiveNumber {
    
    public static int solve(int a[],int n)
    {
        //Swapping all the negative numbers to the right
	        int j=n-1;
	        for(int i=n-1;i>=0;i--)
	        {
	            if(a[i]<=0)
	            {
	                int temp=a[i];
	                a[i]=a[j];
	                a[j]=temp;
	                --j;
	            }
	            
	        }
	        
	        int ans=0;
	        
	       /*
	       -> x-1 because we use 0 based indexing.
	       if we find a number suppose 8 and if  8-1< size of mini array with only 
           positive values we will check 
	       if arr[8-1]>0(i.e positive) we will make it negative
	       */   	            
	        for(int i=0;i<=j;i++)
	        {
	            int x=Math.abs(a[i]);
	            
	            if(x!=0 && x-1<=j && a[x-1]>0)
	            {
	                a[x-1]=-a[x-1];
	            }
	        }
	        
	        /*
            We will check for positive numbers as we have made
            all available indexes negative            
            */
            
	        for(int i=0;i<=j;i++)
	        {
	            if(a[i]>=0)
	            {ans=i+1;return ans;}
	        }
	        
            /*
            this means all the numbers are positive so the last number is 
            missing therefore ans+1;     */  
            
	        return j+2;
    
    }
    
	public static void main (String[] args) {
	    Scanner input=new Scanner(System.in);
	    int t=input.nextInt();
	    while(t-->0)
	    {
	        int n=input.nextInt();
	        int a[]=new int[n];
	        //Taking the input
	        for(int i=0;i<n;i++)a[i]=input.nextInt();
	        
	        System.out.println(solve(a,n));
	        
	    }
		
	}
}