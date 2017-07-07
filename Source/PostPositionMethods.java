/** This class adds case markers to the noun according
  *  to the postposition input given*/
public class PostPositionMethods
	{
		 TabMethods tm = new TabMethods();
		 ByteMethods bm = new ByteMethods();
		 byte[] ukku = {5,14,14,5};
		 byte[] kku = {14,14,5};
		 byte[] rrku = {3,30,14,5};
		 byte[] ku = {14,5};
		 byte[] ai = {9};
    	 byte[] in = {3,31};
    	 /** This method adds the case markers according to the
    	   *  postposition input given as well as it checks for the
    	   *  singular or not
    	   *  Return type is string */
		public String addPostPositions(String noun,String postposition,int num,boolean isSingular)
			{

			   String return_string = "";
               if(isSingular)
                              {
				if(noun.endsWith("�"))
                  noun=noun.substring(0,noun.length()-2).concat("��");
				if((postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("�����"))||(postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("�����"))||(postposition.equals("���"))||(postposition.equals("�����"))||(postposition.equals("�������"))||(postposition.equals("��좴")) || (postposition.equals("����")) || (postposition.equals("�����좴")) || (postposition.equals("���")) || (postposition.equals("�좮")) || (postposition.equals("���")) || (postposition.equals("��������")))
					{
						return_string=tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ai,tm.convert(postposition))));
					}
				else if(postposition.equals("����") || postposition.equals("��") || postposition.equals("���") ||postposition.equals("���") || postposition.equals("���") || postposition.equals("���") || postposition.equals("����") ||postposition.equals("��"))
					{
						return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
					}
				else if(postposition.equals("�����") ||postposition.equals("����") ||postposition.equals("����") || postposition.equals("����") || postposition.equals("���") || postposition.equals("����") || postposition.equals("���"))
					{
						if(num==1)
							return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))));
						else if(num==2)
						 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(kku,tm.convert(postposition))));
						else if(num==3)
						 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(rrku,tm.convert(postposition))));
						else if(num==4)
						 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ku,tm.convert(postposition))));
					}
				else if(postposition.equals("���") ||postposition.equals("��") || postposition.equals("����"))
				     return_string = tm.revert( bm.addarray(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))),bm.addarray(tm.convert(" / "+noun),tm.convert(postposition))) );
			    else if(postposition.equals("������") || postposition.equals("����") || postposition.equals("�����") || postposition.equals("�����") || postposition.equals("��좴") )
				     {
				    	 //if(num==1)
				    	   return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
				    	 //else if(num==2)
				    	 //  return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
				    }
				else if(postposition.equals("����") || postposition.equals("���") ||postposition.equals("���") || postposition.equals("���") || postposition.equals("ެ��") || postposition.equals("ﴫ�") ||postposition.equals("������") ||postposition.equals("������") ||postposition.equals("����") ||postposition.equals("���") || postposition.equals("�����") || postposition.equals("�������") || postposition.equals("ܼ���")|| postposition.equals("��被�"))
				{
					if(num==1)
                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( ukku, tm.convert(postposition))));
                    else if(num==2)
                        return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( rrku, tm.convert(postposition))));
                    else if(num==3)
                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray(kku, tm.convert(postposition))));
                    else if(num==4)
                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( ku, tm.convert(postposition))));
                    else if(num==5)
                    	return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
                    else if(num==6)
                    	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
				}
			}
			else
			{
				noun = singularToPlural(noun);
				 			if(noun.endsWith("�"))
				                  noun=noun.substring(0,noun.length()-2).concat("��");

								if((postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("�����"))||(postposition.equals("���"))||(postposition.equals("����"))||(postposition.equals("�����"))||(postposition.equals("���"))||(postposition.equals("�����"))||(postposition.equals("�������"))||(postposition.equals("��좴")) || (postposition.equals("����")) || (postposition.equals("�����좴")) || (postposition.equals("���")) || (postposition.equals("�좮")) || (postposition.equals("���")) || (postposition.equals("��������")))
									{
										return_string=tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ai,tm.convert(postposition))));
									}
								else if(postposition.equals("����") || postposition.equals("��") || postposition.equals("���") ||postposition.equals("���") || postposition.equals("���") || postposition.equals("���") || postposition.equals("����") ||postposition.equals("��"))
									{
										return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
									}
								else if(postposition.equals("�����") ||postposition.equals("����") ||postposition.equals("����") || postposition.equals("����") || postposition.equals("���") || postposition.equals("����") || postposition.equals("���"))
									{
										if(num==1)
											return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))));
										else if(num==2)
										 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(kku,tm.convert(postposition))));
										else if(num==3)
										 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(rrku,tm.convert(postposition))));
										else if(num==4)
										 	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ku,tm.convert(postposition))));
									}
								else if(postposition.equals("���") ||postposition.equals("��") || postposition.equals("����"))
								     return_string = tm.revert( bm.addarray(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))),bm.addarray(tm.convert(" / "+noun),tm.convert(postposition))) );
							    else if(postposition.equals("������") || postposition.equals("����") || postposition.equals("�����") || postposition.equals("�����") || postposition.equals("��좴") )
								     {
								    	 //if(num==1)
								    	   return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
								    	 //else if(num==2)
								    	 //  return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
								    }
								else if(postposition.equals("����") || postposition.equals("���") ||postposition.equals("���") || postposition.equals("���") || postposition.equals("ެ��") || postposition.equals("ﴫ�") ||postposition.equals("������") ||postposition.equals("������") ||postposition.equals("����") ||postposition.equals("���") || postposition.equals("�����") || postposition.equals("�������") || postposition.equals("ܼ���")|| postposition.equals("��被�"))
								{
									if(num==1)
				                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( ukku, tm.convert(postposition))));
				                    else if(num==2)
				                        return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( rrku, tm.convert(postposition))));
				                    else if(num==3)
				                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray(kku, tm.convert(postposition))));
				                    else if(num==4)
				                    	return_string = tm.revert(bm.addarray( tm.convert(noun) , bm.addarray( ku, tm.convert(postposition))));
				                    else if(num==5)
				                    	return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
				                    else if(num==6)
				                    	return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
								}

			}
			  return return_string;
			}
/** This  method converts sinular to plural
  * for the given noun input*/
public String singularToPlural(String noun)
	{
		byte[] kal = {14,1,29} ;
		byte[] kkal = {14,14,1,29} ;
	    byte[] nounbyte = tm.convert(noun);

		if(nounbyte[nounbyte.length-1]==23)
			{
				nounbyte[nounbyte.length-1]=15;
				nounbyte = bm.addarray1(nounbyte,kal);
				noun = tm.revert(nounbyte);
			}
		else if((nounbyte[nounbyte.length-1]==4)||(nounbyte[nounbyte.length-1]==6))
			{
				nounbyte = bm.addarray1(nounbyte,kkal);
				noun = tm.revert(nounbyte);
			}
		else
			{
				nounbyte = bm.addarray1(nounbyte,kal);
				noun = tm.revert(nounbyte);
			}
		return noun;
	}
}