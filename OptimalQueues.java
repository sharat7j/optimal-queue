import java.util.ArrayList;
import java.util.Collections;


public class OptimalQueues {

	private ArrayList<Integer> clientArrivals=new ArrayList<Integer>();
	private int tellerCount;
	private int serviceCount;
	OptimalQueues()
	{
		
	}
	
	OptimalQueues(ArrayList<Integer> clientArrivals,int tellerCount,int serviceCount)
	{
		this.clientArrivals=clientArrivals;
		this.tellerCount=tellerCount;
		this.serviceCount=serviceCount;
		
	}
	public int minWaitingTime()
	
	{
		
	
	int l=this.clientArrivals.size();
	Collections.sort(this.clientArrivals);
	
	for(int i=0;i<l;i++)
	{
		System.out.println(this.clientArrivals.get(i));
	}

	Integer[] waitTime=new Integer[this.tellerCount];
	for(int i=0;i<this.tellerCount;i++)
	{
		waitTime[i]=0;
	}
	
	int tellerQ=0;
	for(int i=0;i<l;i++)
	{
		tellerQ=tellerQ%this.tellerCount;
		if(waitTime[tellerQ]==0)
		{
			waitTime[tellerQ]+=this.clientArrivals.get(i);
			
		}
		if(waitTime[tellerQ]<this.clientArrivals.get(i))
		{
			waitTime[tellerQ]=this.clientArrivals.get(i);
			
		}
		waitTime[tellerQ]+=this.serviceCount;
		tellerQ++;
	}
		
		
	
	
	
		return max(waitTime);
		
	}
	
	public int max(Integer[] waitTime)
	{
		ArrayList<Integer> waitT=new ArrayList<Integer>();
		int l=waitTime.length;
		for(int i=0;i<l;i++)
		{
			waitT.add(waitTime[i]);
		}
		Collections.sort(waitT);
		int ln=waitT.size();
		System.out.println("size is ="+ln);
		System.out.println("value is="+waitT.get(ln-1));
		for(int i=0;i<waitT.size();i++)
		{
			System.out.println(waitT.get(i));
		}
		return waitT.get(ln-1);
			
		
	}
	
	/*public static void main(String[] args) {
		
		ArrayList<Integer> clientArrivals=new ArrayList<Integer>();
		clientArrivals.add(10);
		clientArrivals.add(10);
		clientArrivals.add(10);
		
		int tellerCount=2;
		int serviceTime=20;
		
		OptimalQueues optQueue=new OptimalQueues(clientArrivals,tellerCount,serviceTime);
		
		System.out.println("The min waiting time is Q is="+optQueue.minWaitingTime());
		
		
	}*/
	
	
}
