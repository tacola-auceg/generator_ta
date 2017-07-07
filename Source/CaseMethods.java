/** This class defines methods for different cases*/
public class CaseMethods{

ByteMethods bm = new ByteMethods();
TabMethods tm = new TabMethods();

byte[] kal={14,1,29};

public String addCase(String nounstr,String case1str,String case2str,boolean number)
	{
		byte[] nounbyte  = tm.convert(nounstr.trim());
		byte[] case1 = tm.convert(case1str.trim());
		byte[] case2 = tm.convert(case2str.trim());
		byte[] result=null;
		byte[] temp = new byte[nounbyte.length+1];

		if(number)
			{
				if(case1.length==1 && case1[0]==0)
					result=nounbyte;
				else
					{
						if(nounbyte[nounbyte.length-1]==23)
							{
								for(int i=0;i<nounbyte.length-1;i++)
									temp[i]=nounbyte[i];
								temp[nounbyte.length-1]=20;
								temp[nounbyte.length]=20;
								result=bm.addarray(temp,case1);
							}
						if(nounbyte[nounbyte.length-2]==18 && nounbyte[nounbyte.length-1]==5)
							{
								for(int i=0;i<nounbyte.length-1;i++)
									temp[i]=nounbyte[i];
								temp[nounbyte.length-1]=18;
								temp[nounbyte.length]=5;
								nounbyte=temp;
								result=bm.addarray(temp,case1);
							}
						if(case2.length==1 && case2[0]==0)
							{
								if(nounbyte[nounbyte.length-1]==23)
									{
										for(int i=0;i<nounbyte.length-1;i++)
											temp[i]=nounbyte[i];
										temp[nounbyte.length-1]=20;
										temp[nounbyte.length]=20;
									}
								else
									temp=nounbyte;
								result=bm.addarray(temp,case1);
							}
						else{
								if(nounbyte[nounbyte.length-1]==23)
									{
										for(int i=0;i<nounbyte.length-1;i++)
											temp[i]=nounbyte[i];
										temp[nounbyte.length-1]=20;
										temp[nounbyte.length]=20;
									}
								else
									temp=nounbyte;
								result=bm.addarray(bm.addarray(temp,case1),case2);
							}
					}
			}

		if(!number)
			{
				if(case1.length==1 && case1[0]==0)
					{
						if(nounbyte[nounbyte.length-1]==23)
							nounbyte[nounbyte.length-1]=15;
						result=bm.addarray(nounbyte,kal);
					}
				else
					{
						if(case2.length==1 && case2[case2.length-1]==0)
							{
								if(nounbyte[nounbyte.length-1]==23)
									nounbyte[nounbyte.length-1]=15;
								result=bm.addarray(bm.addarray(nounbyte,kal),case1);
							}
						else
							{
								if(nounbyte[nounbyte.length-1]==23)
									nounbyte[nounbyte.length-1]=15;
								result=bm.addarray(bm.addarray(bm.addarray(nounbyte,kal),case1),case2);
							}
					}
			}
		return tm.revert(result);
	}
}