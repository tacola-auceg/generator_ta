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
				if(noun.endsWith("ñ¢"))
                  noun=noun.substring(0,noun.length()-2).concat("î¢î¢");
				if((postposition.equals("õ¤ì"))||(postposition.equals("õ¤ì¾ñ¢"))||(postposition.equals("«ð£ô"))||(postposition.equals("«ð£ô¢"))||(postposition.equals("«ð£ù¢Á"))||(postposition.equals("ªè£í¢´"))||(postposition.equals("«ï£è¢è¤"))||(postposition.equals("ðø¢ø¤"))||(postposition.equals("°ø¤î¢¶"))||(postposition.equals("²ø¢ø¤"))||(postposition.equals("²ø¢ø¤½ñ¢"))||(postposition.equals("õ¤ì¢´")) || (postposition.equals("îõ¤ó")) || (postposition.equals("ºù¢ù¤ì¢´")) || (postposition.equals("«õí¢®")) || (postposition.equals("åì¢®")) || (postposition.equals("ªð£Áî¢¶")) || (postposition.equals("ªð£Áî¢îõ¬ó")))
					{
						return_string=tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ai,tm.convert(postposition))));
					}
				else if(postposition.equals("àìù¢") || postposition.equals("Ãì") || postposition.equals("à¬ìò") ||postposition.equals("õêñ¢") || postposition.equals("Þìñ¢") || postposition.equals("õ¬ó") || postposition.equals("«î£Áñ¢") ||postposition.equals("Ýó"))
					{
						return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
					}
				else if(postposition.equals("ðî¤ô£è") ||postposition.equals("ðî¤ô¢") ||postposition.equals("ñ£ø£è") || postposition.equals("«ïó£è") || postposition.equals("àó¤ò") || postposition.equals("à÷¢÷") || postposition.equals("î°ï¢î"))
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
				else if(postposition.equals("ð¤ø°") ||postposition.equals("Ýè") || postposition.equals("âù¢Á"))
				     return_string = tm.revert( bm.addarray(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))),bm.addarray(tm.convert(" / "+noun),tm.convert(postposition))) );
			    else if(postposition.equals("õ£ò¤ô£è") || postposition.equals("Íôñ£è") || postposition.equals("õö¤ò£è") || postposition.equals("«ðó¤ô¢") || postposition.equals("ªð£¼ì¢´") )
				     {
				    	 //if(num==1)
				    	   return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
				    	 //else if(num==2)
				    	 //  return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
				    }
				else if(postposition.equals("âù¢Á") || postposition.equals("ºù¢") ||postposition.equals("ð¤ù¢") || postposition.equals("à÷¢") || postposition.equals("Þ¬ì«ò") || postposition.equals("ï´«õ") ||postposition.equals("ñî¢î¤ò¤ô¢") ||postposition.equals("ªõ÷¤«ò") ||postposition.equals("«ñô¢") ||postposition.equals("è¦ö¢") || postposition.equals("âî¤ó¤ô¢") || postposition.equals("ðè¢èî¢î¤ô¢") || postposition.equals("Ü¼è¤ô¢")|| postposition.equals("°Áè¢«è"))
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
				 			if(noun.endsWith("ñ¢"))
				                  noun=noun.substring(0,noun.length()-2).concat("î¢î¢");

								if((postposition.equals("õ¤ì"))||(postposition.equals("õ¤ì¾ñ¢"))||(postposition.equals("«ð£ô"))||(postposition.equals("«ð£ô¢"))||(postposition.equals("«ð£ù¢Á"))||(postposition.equals("ªè£í¢´"))||(postposition.equals("«ï£è¢è¤"))||(postposition.equals("ðø¢ø¤"))||(postposition.equals("°ø¤î¢¶"))||(postposition.equals("²ø¢ø¤"))||(postposition.equals("²ø¢ø¤½ñ¢"))||(postposition.equals("õ¤ì¢´")) || (postposition.equals("îõ¤ó")) || (postposition.equals("ºù¢ù¤ì¢´")) || (postposition.equals("«õí¢®")) || (postposition.equals("åì¢®")) || (postposition.equals("ªð£Áî¢¶")) || (postposition.equals("ªð£Áî¢îõ¬ó")))
									{
										return_string=tm.revert(bm.addarray(tm.convert(noun),bm.addarray(ai,tm.convert(postposition))));
									}
								else if(postposition.equals("àìù¢") || postposition.equals("Ãì") || postposition.equals("à¬ìò") ||postposition.equals("õêñ¢") || postposition.equals("Þìñ¢") || postposition.equals("õ¬ó") || postposition.equals("«î£Áñ¢") ||postposition.equals("Ýó"))
									{
										return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
									}
								else if(postposition.equals("ðî¤ô£è") ||postposition.equals("ðî¤ô¢") ||postposition.equals("ñ£ø£è") || postposition.equals("«ïó£è") || postposition.equals("àó¤ò") || postposition.equals("à÷¢÷") || postposition.equals("î°ï¢î"))
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
								else if(postposition.equals("ð¤ø°") ||postposition.equals("Ýè") || postposition.equals("âù¢Á"))
								     return_string = tm.revert( bm.addarray(bm.addarray(tm.convert(noun),bm.addarray(ukku,tm.convert(postposition))),bm.addarray(tm.convert(" / "+noun),tm.convert(postposition))) );
							    else if(postposition.equals("õ£ò¤ô£è") || postposition.equals("Íôñ£è") || postposition.equals("õö¤ò£è") || postposition.equals("«ðó¤ô¢") || postposition.equals("ªð£¼ì¢´") )
								     {
								    	 //if(num==1)
								    	   return_string = tm.revert(bm.addarray(tm.convert(noun),bm.addarray(in,tm.convert(postposition))));
								    	 //else if(num==2)
								    	 //  return_string = tm.revert(bm.addarray(tm.convert(noun),tm.convert(postposition)));
								    }
								else if(postposition.equals("âù¢Á") || postposition.equals("ºù¢") ||postposition.equals("ð¤ù¢") || postposition.equals("à÷¢") || postposition.equals("Þ¬ì«ò") || postposition.equals("ï´«õ") ||postposition.equals("ñî¢î¤ò¤ô¢") ||postposition.equals("ªõ÷¤«ò") ||postposition.equals("«ñô¢") ||postposition.equals("è¦ö¢") || postposition.equals("âî¤ó¤ô¢") || postposition.equals("ðè¢èî¢î¤ô¢") || postposition.equals("Ü¼è¤ô¢")|| postposition.equals("°Áè¢«è"))
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