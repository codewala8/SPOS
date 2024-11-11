package schedulling;

import java.util.Scanner;

public class SJF_2 {

	public static void main(String args[])
	   {
		int burst_time[],process[],waiting_time[],tat[],i,j,n,total=0,pp,temp;
		float wait_avg,TAT_avg;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of process: ");
		n = s.nextInt();
		process = new int[n];
		burst_time = new int[n];
		waiting_time = new int[n];
		tat = new int[n];

		System.out.println("\nEnter Burst time:");

		for(i=0;i<n;i++)
		{
		System.out.print("\nProcess["+(i+1)+"]: ");
		burst_time[i] = s.nextInt();;
		process[i]=i+1; //Process Number
		}
		
		System.out.println("\n \t \t*************** Shortest Job First Scheduling*********");
		//Sorting
		for(i=0;i<n;i++)
		{
		pp=i; 																																												
		for(j=i+1;j<n;j++)
		{
		if(burst_time[j]<burst_time[pp])
		pp=j;
		}
		temp=burst_time[i];
		burst_time[i]=burst_time[pp];
		burst_time[pp]=temp;
		temp=process[i];
		process[i]=process[pp];
		process[pp]=temp;
		}

		//First process has 0 waiting time

		waiting_time[0]=0;

		//calculate waiting time

		for(i=1;i<n;i++)
		{
		waiting_time[i]=0;
		for(j=0;j<i;j++)
		waiting_time[i]+=burst_time[j];
		total+=waiting_time[i];
		}

		//Calculating Average waiting time

		wait_avg=(float)total/n;
		total=0;
		System.out.println("----------------------------------------------------------");
		System.out.println("\nProcess\t| Burst Time \t|Waiting Time\t|Turnaround Time |");
	        System.out.println("----------------------------------------------------------");
		for(i=0;i<n;i++)
		{
		tat[i]=burst_time[i]+waiting_time[i];

		//Calculating Turnaround Time

		total+=tat[i];
	        System.out.println("\n p"+process[i]+"\t|\t "+burst_time[i]+"\t|\t "+waiting_time[i]+"\t|\t "+tat[i]+"\t|\t ");
	   	System.out.println("----------------------------------------------------------");
		}

		//Calculation of Average Turnaround Time

		TAT_avg=(float)total/n;
		System.out.println("\n\nAverage Waiting Time: "+wait_avg);
		System.out.println("\nAverage Turnaround Time: "+TAT_avg);
	   }

	
}
