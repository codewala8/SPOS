package schedulling ;

import java.util.Scanner;

public class Fcfs_1{
	public static void main(String args[])
	{
		int wt[],bst[],tat[],total=0,i,n,j,process[];
		float TAT_avg,wait_avg;
		
		Scanner s = new Scanner (System.in);
		System.out.println("Enter number of process:");
		n = s.nextInt();
		
		
		process = new int[n];
		tat = new int[n];
		wt = new int[n];
		bst = new int[n];
		
		System.out.println("Enter CPU time:");
		
		for(i=0;i<n;i++) {
			System.out.println("Process ["+(i+1)+"]");
			bst[i]=s.nextInt();
			process[i]=i+1;
		}
		
		System.out.println("***************FCFS Scheduling****************************");
		wt[0]=0;
		for(i=1;i<n;i++) {
			wt[i]=0;
			for(j=0;j<i;j++)
				
				
				wt[i]+=bst[j];
				total+=wt[i];
		}
		
		wait_avg = (float)total/n;
		total = 0;
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\tProcess \t|\tBurst_Time \t|\t Witing_time \t |\t Turnaround_time");
		System.out.println("---------------------------------------------------------------------------");
		
		for(i=0;i<n;i++)
		{
			tat[i]=bst[i]+wt[i];
			total+=tat[i];
			System.out.println("\np"+process[i]+ "\t\t|\t" +bst[i]+ "\t\t|\t" +wt[i]+ "\t\t|\t" +tat[i]);
			
		}
		TAT_avg = (float)total/n;
		System.out.println("Average of waiting time :"+wait_avg);
		System.out.println("Average of Turnaround time : "+TAT_avg);
	}
}