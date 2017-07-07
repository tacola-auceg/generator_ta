import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/** This is the main class which acts as the interface for the user*/
public class CorporateDemo extends JFrame implements ActionListener
	{

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Font f;
		JComboBox sub_jcb,adj1_jcb,noun1_jcb,case1_jcb,post_pos1_jcb,adj2_jcb,noun2_jcb,case2_jcb,post_pos2_jcb,adv_jcb,verb_jcb,aux1_jcb,aux2_jcb,aux3_jcb,aux4_jcb,tense_jcb;
		JButton ok_button,cancel_button,exit_button;
		JRadioButton sing1 = new JRadioButton("弬�",true);
		JRadioButton plur1 = new JRadioButton("�����");
		ButtonGroup bg1 = new ButtonGroup();
		JRadioButton sing2 = new JRadioButton("弬�",true);
		JRadioButton plur2 = new JRadioButton("�����");
		ButtonGroup bg2 = new ButtonGroup();
		JTextArea resultarea = new JTextArea(10,5);
		JScrollPane textpane = new JScrollPane(resultarea);



		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();

		static String[] sub_str = {"����","���","��","�����","�","�����","����","����","����","���","������","ܶ","ܬ�","ܬ����"};
		//static String[]sub1_str={"�����","������","������","���������","���������"};
		static String[] adj_str = {"�����","���","���","�����","����","����","��","����","������","����","���","�","޼","����","����","�","��","�","�좴","����","�"};
		static String[] case_str = {"����������","�","���","��","�袰","���","���","�","���","����","ܶ","޼","���","����","��","����","���","���"};
		static String[] pps_str = {"���郎�","���","����","���","����","�����","���","����","�����","���","�����","�������","��좴","����","�����좴","���","�좮","���","��������","��","����","���","���","���","ެ��","ﴫ�","������","������","����","���","�����","�������","ܼ���","����","����","����","���","����","���","������","����","�����","�����","��좴","����","��","���","���","���","���","����","��"};
		static String[] adv_str = {"������","����","����","���","ܮ��","�������","�����","����","���","�����","���","���","���","����","�����","�ꢬ�","�����","���","����","�����","���","����","�����","���","�����","�������","����","�����좴","���","�좮","���","��","���","ެ��","ﴫ�","������","����","���","�����","�������","ܼ���","����","����","����","������","����","�����","�����","��좴","��","���","���","���","���"};
		//static String[] ver_str = {"����ꢪ���","���","���","��좴","���","��","�","��","��","�颰","��","���","����","����", "���","��","��"};
		static String[] ver_str = {"����ꢪ���","���","�","���","��좴","���","�","��","��","�颰","��","���","����","���","��","��"};
		static String[] aux_str = {"���","����","޼","���","��","��","ܿ","�裴","��","���","����","��","��","�좴","�좴","�","��","��","���","��","��","�����","����","�����","ô�","�죶","�����"};
		static String[] noun_str = {"����ꢪ���","����","�����","����","���ꢲ��","�좮��","�좬�","����","���","���","���","�","�����","ݻ��"};
		static String[] tense_str = {"������","�������","�������","������"};



/** This is the constructor in which the components are
  * added in the layout*/
public CorporateDemo()
	{
		setTitle("Generator version 1.0");
		setFont(f);

		ImageIcon i = new ImageIcon(getClass().getResource("GIF.GIF"));
		setIconImage(i.getImage());

		try
		{
			InputStream inputStream = getClass().getResourceAsStream("TABANNA.TTF");
			Font f1 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			f = f1.deriveFont(Font.PLAIN, 14);
		}
		catch(Exception e)
		{
			System.out.println("Font File not Found");
		}

        sing1.setFont(f);
        plur1.setFont(f);
		bg1.add(sing1);
		bg1.add(plur1);
		p4.setLayout(new BorderLayout());
		p4.add(sing1,"North");
        p4.add(plur1,"South");

		sing2.setFont(f);
        plur2.setFont(f);
		bg2.add(sing2);
		bg2.add(plur2);
		p5.setLayout(new BorderLayout());
		p5.add(sing2,"North");
        p5.add(plur2,"South");

		p6.setLayout( new FlowLayout(FlowLayout.LEFT));
        sub_jcb   = addComboBox(p6,sub_str);
        //sub1_jcb   = addComboBox(p6,sub1_str);

		adj1_jcb  = addComboBox(p1,adj_str);
		adj1_jcb.setEditable(true);

		noun1_jcb = addComboBox(p1,noun_str);
		noun1_jcb.setEditable(true);

		p1.add(p4);

		case1_jcb = addComboBox(p1,case_str);
		post_pos1_jcb = addComboBox(p1,pps_str);
		post_pos1_jcb.addActionListener(this);

		adj2_jcb  = addComboBox(p2,adj_str);
		adj2_jcb.setEditable(true);

		noun2_jcb = addComboBox(p2,noun_str);
		noun2_jcb.setEditable(true);

		p2.add(p5);

		case2_jcb = addComboBox(p2,case_str);
		post_pos2_jcb = addComboBox(p2,pps_str);
		post_pos2_jcb.addActionListener(this);

		adv_jcb = addComboBox(p3,adv_str);


		verb_jcb = addComboBox(p3,ver_str);
		verb_jcb.setEditable(true);
		aux1_jcb = addComboBox(p3,aux_str);
		aux2_jcb = addComboBox(p3,aux_str);
		aux3_jcb = addComboBox(p3,aux_str);
		aux4_jcb = addComboBox(p3,aux_str);


		tense_jcb = addComboBox(p7,tense_str);
		ok_button = addButton(p7,"���袰");
		cancel_button = addButton(p7,"���");
		exit_button = addButton(p7,"�������");


		p8.setLayout(new BorderLayout());
		p8.add(p2,"North");
		p8.add(p3,"Center");
		p8.add(p7,"South");
		p9.setLayout(new BorderLayout());
		p9.add(p6,"North");
		p9.add(p1,"Center");


		getContentPane().add(p9,"North");
		getContentPane().add(p8,"Center");
		getContentPane().add(textpane,"South");
		resultarea.setFont(f);



		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});

		Dimension framesize = this.getPreferredSize();

		setLocation(dim.width/2 - (framesize.width/2),
                    dim.height/2 - (framesize.height/2));
		setResizable(false);
		setVisible(true);
		pack();
	}

/** In this method the items are added in the Jcombobox
  * the string array is passed
  * return type is Jcombobox*/
public JComboBox addComboBox(JPanel p,String str[])
	{
		JComboBox jcb = new JComboBox();
		for(int i=0;i<str.length;i++)
			jcb.addItem(str[i]);
		jcb.setFont(f);
		p.add(jcb);
		return jcb;
	}
/** In this method names are added in the buttons
	* the string is passed
    * return type is Jbutton*/

public JButton addButton(JPanel pa,String name)
	{
		JButton but = new JButton(name);
		but.addActionListener(this);
		but.setFont(f);
		pa.add(but);
		return but;
	}
/** In this method the actions
  * of various buttons are captured*/
public void actionPerformed(ActionEvent ae)
	{

		String giv_adj1="",giv_noun1 ="",giv_adj2="",giv_noun2 ="" ;
		if(ae.getSource()==ok_button)
		{
			if(!(sub_str[0].equals((String)sub_jcb.getSelectedItem())))
			{
				if(!(ver_str[0].equals((String)verb_jcb.getSelectedItem())))
				{
					if(!(tense_str[0].equals((String)tense_jcb.getSelectedItem())))
					{
						String giv_sub = (String)sub_jcb.getSelectedItem();//
							  giv_adj1 = (String)adj1_jcb.getSelectedItem();
							 giv_noun1 = (String)noun1_jcb.getSelectedItem();
						String giv_case1 = (String)case1_jcb.getSelectedItem();//
						String giv_post1 = (String)post_pos1_jcb.getSelectedItem();//

								giv_adj2 = (String)adj2_jcb.getSelectedItem();
							   giv_noun2 = (String)noun2_jcb.getSelectedItem();
						String giv_case2 = (String)case2_jcb.getSelectedItem();//
						String giv_post2 = (String)post_pos2_jcb.getSelectedItem();//
						String giv_adv = (String)adv_jcb.getSelectedItem();//

						String giv_verb = (String)verb_jcb.getSelectedItem();//
						String giv_aux1 = (String)aux1_jcb.getSelectedItem();//
						String giv_aux2 = (String)aux2_jcb.getSelectedItem();//
						String giv_aux3 = (String)aux3_jcb.getSelectedItem();//
						String giv_aux4 = (String)aux4_jcb.getSelectedItem();//
						String giv_tense = (String)tense_jcb.getSelectedItem();//

						boolean isSingular1 = true;
						boolean isSingular2 = true;

						if(plur1.isSelected())
						   isSingular1 = false;
						if(plur2.isSelected())
					       isSingular2 = false;

					try{	String result[] = generateSentences(giv_sub,giv_adj1,giv_noun1,giv_case1,isSingular1,giv_post1,giv_adj2,giv_noun2,giv_case2,isSingular2,giv_post2,giv_adv,giv_verb,giv_aux1,giv_aux2,giv_aux3,giv_aux4,giv_tense);


						for(int i=0;i<1&& result[i]!=null;i++)
						  resultarea.append(result[i]+"\n");}catch(Exception e){System.out.println("yes"+e);}


					}
					else
						resultarea.setText("you must select a tense");
				}
				else
					resultarea.setText("you must select an verb");
			}
			else
				resultarea.setText("you must select a subject");
		}
		if(ae.getSource()==cancel_button)
			{

				reset();

			}
		if(ae.getSource()==exit_button)
			System.exit(0);
		if(ae.getSource()==post_pos1_jcb)
			if(!(pps_str[0].equals((String)post_pos1_jcb.getSelectedItem())))
			    case1_jcb.setSelectedItem(case_str[0]);
		if(ae.getSource()==post_pos2_jcb)
			if(!(pps_str[0].equals((String)post_pos2_jcb.getSelectedItem())))
			    case2_jcb.setSelectedItem(case_str[0]);
	}

/** This method generates sentences for the various inputs
  * inputs are the subject,adjective,verb,postpositions
  * auxillary verbs etc	*/
public static String[] generateSentences(String subject,String adjective1,String noun1,String case1,boolean issingular1,String post1,String adjective2,String noun2,String case2,boolean issingular2,String post2,String adverb,String verb,String auxilary1,String auxilary2,String auxilary3,String auxilary4,String tense)
 {
	 VerbMethods verbobj = new VerbMethods();
	 CaseMethods caseobj = new CaseMethods();
	 PostPositionMethods postobj = new PostPositionMethods();
	 AdjectiveMethods adjobj = new AdjectiveMethods();

     String post1result="",post2result="",case1result="",case2result="",adj1result="",adj2result="";

     String aux[] ={auxilary1,auxilary2,auxilary3,auxilary4};
	 String[] adv_verb_aux_tense=null;
	 adv_verb_aux_tense =verbobj.callAll(subject,verb,aux,tense,"",adverb);

	 if(!(post1.equals(pps_str[0])))
	 	post1result = " "+postobj.addPostPositions(noun1,post1,1,issingular1);
	 else if(!(case1.equals(case_str[0])))
	 	case1result = " "+caseobj.addCase(noun1,case1,"",issingular1);

	 if(!(post2.equals(pps_str[0])))
	 	 	post2result = " "+postobj.addPostPositions(noun2,post2,1,issingular2);
	 	 else if(!(case2.equals(case_str[0])))
	 	case2result = " "+caseobj.addCase(noun2,case2,"",issingular2);

	 if(!(adjective1.equals(adj_str[0])))
	 	adj1result = " "+adjobj.addAdjective(adjective1);
	 if(!(adjective2.equals(adj_str[0])))
	 	adj2result = " "+adjobj.addAdjective(adjective2);



	 for(int count=0;count<adv_verb_aux_tense.length && adv_verb_aux_tense[count]!=null;count++)
	    adv_verb_aux_tense[count]=subject + adj1result + case1result + post1result + adj2result + case2result + post2result + " " + adv_verb_aux_tense[count];

	 return adv_verb_aux_tense;
 }
/** This is the main method*/
public static void main(String ar[])
	{
		new CorporateDemo();
	}
/** thos method resets all the buttons*/
public void reset()
{
					sub_jcb.setSelectedItem("����");
					adj1_jcb.setSelectedItem("�����");
					noun1_jcb.setSelectedItem("����ꢪ���");
					case1_jcb.setSelectedItem("����������");
					post_pos1_jcb.setSelectedItem("���郎�");
					adj2_jcb.setSelectedItem("�����");
					noun2_jcb.setSelectedItem("����ꢪ���");
					case2_jcb.setSelectedItem("����������");
					post_pos2_jcb.setSelectedItem("���郎�");
					adv_jcb.setSelectedItem("������");
					verb_jcb.setSelectedItem("����ꢪ������");
					aux1_jcb.setSelectedItem("���");
					aux2_jcb.setSelectedItem("���");
					aux3_jcb.setSelectedItem("���");
					aux4_jcb.setSelectedItem("���");
					tense_jcb.setSelectedItem("������");
					resultarea.setText("");
					sing1.setSelected(true);
					sing2.setSelected(true);

}
}