package test;import javax.swing.*;import java.awt.*;import java.awt.event.*; class Pole {		int color;		int flag;				void vivod(){			System.out.print(color);			System.out.print(" ");		}		}	 public class Nurikabe_backup {	static int S = 0 ;	private static int flag=0;	private static final int white=0;	private static final int blank=0;	private static final int dot=-1;	private static final int black=-2;	private static final int graniza=-3;	public static void main(String[] args) {		//-1 ���� � ������� ������ ��������� ������ 		//-2 ������ ����		//0 ������ ����, ������� ���� ���������		//��� ��������� ����� - ������ ���� �� ������� ������� ���������� ����� � ������ +		//+++	int[][] myArray = new int[9][9];//	myFrame okno = new myFrame();	 	setpolye(myArray);		vivod_polya(myArray,"������ ��� ������� ����");		//���������� ������� ���������(����) 		System.out.println();		stena_poseredine_podskazok (myArray);		krasim_okolo_1(myArray);		vivod_polya(myArray,"������ ��� ������� ����");		krasim_odin_pole(myArray);		vivod_polya(myArray,"������ ��� ������� ����");		stavim_dot(myArray);		vivod_polya(myArray,"��������� ��� ������� ����");		krasim_okolo_2(myArray);		pervai_dot_ostrova(myArray);		//dot_okolo_2(myArray);		vivod_polya(myArray,"������� ���� ����� ��������� 2");		provodim_stenu_kogda_1_varian (myArray);				//soedinyem_black_corner(myArray);		vivod_polya(myArray,"������� ���� ����� ���������� �����");		soedin_steny (myArray);		prodolg_dot_ostrova_ot_podskazki  (myArray);		prodolg_dot_ostrova_ot_dot (myArray);		vivod_polya(myArray,"������� ���� ����� ����������� ����");		//okno ( myArray);		Pole[][] myPole = new Pole [9][9];		for(int i = 1; i < 8; i++){			for(int j = 1; j < 8; j++){				myPole[i][j] = new Pole();				myPole [i][j].color = myArray[i][j];				myPole [i][j].flag = 0;			}		}		vivod_new_polya(myPole, "������ ���� ����� ��������������");	//	vivod_polya(myArray,"������� ���� ����� �������� �����������");				for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				S=S+countArea(i,j, myPole);			}		}		System.out.print(S);	}					 		public static void setpolye(int[][] myArr){		//��������� �� 0		for(int i = 0; i < 9; i++){			for(int j = 0; j < 9; j++){		    myArr[i][j] = -3;			}		}		for(int i = 1; i < 8; i++){			for(int j = 1; j < 8; j++){		    myArr[i][j] =blank;			}		}		myArr[2][1] = 3;		myArr[6][1] = 1;		myArr[1][3] = 2;		myArr[4][3] = 1;		myArr[2][5] = 1;		myArr[5][5] = 2;		myArr[3][6] = 2;		myArr[1][7] = 1;		myArr[5][7] = 1;		myArr[7][7] = 6;	}	public static void vivod_polya(int[][] myArr,String textvalue){		//����� �������� �� �������		System.out.println(textvalue);		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				switch (myArr[i][j])				{				  case -2 : System.out.print("*"+" ");				  break;				  case -1 : System.out.print("X"+" ");					  break;				  default: System.out.print(myArr[i][j]+" ");				}		    }			System.out.println();			}						}	public static void krasim_okolo_1(int[][] myArr){		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				if	(myArr[j][i]==1){					if (myArr[j][i-1]==blank) {myArr[j][i-1]=black;}					if (myArr[j+1][i]==blank) {myArr[j+1][i]=black;}					if (myArr[j][i+1]==blank) {myArr[j][i+1]=black;}					if (myArr[j-1][i]==blank) {myArr[j-1][i]=black;}				}							    }			}						}	public static void krasim_odin_pole(int[][] myArr){		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				int kol_zakr_pole=0;				if (myArr[j][i]==blank){					if (myArr[j][i-1]==black || myArr[j][i-1]==graniza) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j][i+1]==black || myArr[j][i+1]==graniza) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j+1][i]==black || myArr[j+1][i]==graniza) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j-1][i]==black || myArr[j-1][i]==graniza) {kol_zakr_pole=kol_zakr_pole+1;}				  }					if (kol_zakr_pole==4){						myArr[j][i]=-2;					}				}		}	}	public static void stavim_dot(int[][] myArr){				for(int j = 1; j < 7; j++){			for(int i = 1; i < 7; i++){				if (myArr[j][i]==blank){					int kol_zakr_pole=0;					if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j-1][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (kol_zakr_pole==3){myArr[j][i]=dot;}										kol_zakr_pole=0;					if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j+1][i-1]==black) {kol_zakr_pole=kol_zakr_pole+1;}					if (kol_zakr_pole==3){myArr[j][i]=dot;}										kol_zakr_pole=0;					if (myArr[j][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j+1][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (kol_zakr_pole==3){myArr[j][i]=dot;}										kol_zakr_pole=0;					if (myArr[j][i+1]==black) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (myArr[j-1][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}					if (kol_zakr_pole==3){myArr[j][i]=dot;}				}			}		}		}	public static void krasim_okolo_2(int[][] myArr){		for(int j = 1; j < 7; j++){			for(int i = 1; i < 7; i++){				if (myArr[j][i]==2){					if (myArr[j][i-1]==dot ){						if (myArr[j+1][i]==blank)  {myArr[j+1][i]=black;}						if (myArr[j][i+1]==blank)  {myArr[j][i+1]=black;}						if (myArr[j-1][i]==blank)  {myArr[j-1][i]=black;}												if (myArr[j][i-2]==blank)   {myArr[j][i-2]=black;}						if (myArr[j+1][i-1]==blank) {myArr[j+1][i-1]=black;}						if (myArr[j-1][i-1]==blank) {myArr[j-1][i-1]=black;}					}											if (myArr[j][i+1]==dot ){						if (myArr[j][i-1]==blank)  {myArr[j][i-1]=black;}						if (myArr[j+1][i]==blank)  {myArr[j+1][i]=black;}						if (myArr[j-1][i]==blank)  {myArr[j-1][i]=black;}												if (myArr[j+1][i+1]==blank)  {myArr[j+1][i+1]=black;}						if (myArr[j][i+2]==blank)    {myArr[j][i+2]=black;}						if (myArr[j-1][i+1]==blank)  {myArr[j-1][i+1]=black;}					}					if (myArr[j+1][i]==dot ){						if (myArr[j][i-1]==blank)  {myArr[j][i-1]=black;}						if (myArr[j][i+1]==blank)  {myArr[j][i+1]=black;}						if (myArr[j-1][i]==blank)  {myArr[j-1][i]=black;}												if (myArr[j+1][i-1]==blank)  {myArr[j+1][i-1]=black;}						if (myArr[j+2][i]==blank)    {myArr[j+2][i]=black;}						if (myArr[j+1][i+1]==blank)  {myArr[j+1][i+1]=black;}					}					if (myArr[j-1][i]==dot ){						if (myArr[j][i-1]==blank)  {myArr[j][i-1]=black;}						if (myArr[j+1][i]==blank)  {myArr[j+1][i]=black;}						if (myArr[j][i+1]==blank)  {myArr[j][i+1]=black;}												if (myArr[j-1][i-1]==blank) {myArr[j-1][i-1]=black;}						if (myArr[j-1][i+1]==blank) {myArr[j-1][i+1]=black;}						if (myArr[j-2][i]==blank)   {myArr[j-2][i]=black;}					}				}			}		}	}	public static void dot_okolo_2(int[][] myArr){		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				if	(myArr[j][i]==2){					if (myArr[j][i-1]==blank) {myArr[j][i-1]=dot;}					if (myArr[j+1][i]==blank) {myArr[j+1][i]=dot;}					if (myArr[j][i+1]==blank) {myArr[j][i+1]=dot;}					if (myArr[j-1][i]==blank) {myArr[j-1][i]=dot;}									}							    }			}				}	/*public static void soedinyem_black_corner(int [][] myArr){		int i=1;		int j=1;		if(myArr[j][i]==black){			int kol_zakr_pole=0;			if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}				if (kol_zakr_pole==0){					if (myArr[j][i-1]==blank ) {myArr[j][i-1]=black;}					if (myArr[j][i+1]==blank ) {myArr[j][i+1]=black;}					if (myArr[j+1][i]==blank ) {myArr[j+1][i]=black;}					if (myArr[j-1][i]==blank ) {myArr[j-1][i]=black;}					}		}		 i=1;		 j=7;		if(myArr[j][i]==black){			int kol_zakr_pole=0;			if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}				if (kol_zakr_pole==0){					if (myArr[j][i-1]==blank ) {myArr[j][i-1]=black;}					if (myArr[j][i+1]==blank ) {myArr[j][i+1]=black;}					if (myArr[j+1][i]==blank ) {myArr[j+1][i]=black;}					if (myArr[j-1][i]==blank ) {myArr[j-1][i]=black;}									}		}				 i=7;		 j=7;		if(myArr[j][i]==black){			int kol_zakr_pole=0;			if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}				if (kol_zakr_pole==0){					if (myArr[j][i-1]==blank ) {myArr[j][i-1]=black;}					if (myArr[j][i+1]==blank ) {myArr[j][i+1]=black;}					if (myArr[j+1][i]==blank ) {myArr[j+1][i]=black;}					if (myArr[j-1][i]==blank ) {myArr[j-1][i]=black;}									}		}		 i=7;		 j=1;		if(myArr[j][i]==black){			int kol_zakr_pole=0;			if (myArr[j][i-1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j][i+1]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j+1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}			if (myArr[j-1][i]==black ) {kol_zakr_pole=kol_zakr_pole+1;}				if (kol_zakr_pole==0){					if (myArr[j][i-1]==blank ) {myArr[j][i-1]=black;}					if (myArr[j][i+1]==blank ) {myArr[j][i+1]=black;}					if (myArr[j+1][i]==blank ) {myArr[j+1][i]=black;}					if (myArr[j-1][i]==blank ) {myArr[j-1][i]=black;}									}		}					}*/	/*public static void okno (int [][] myArr){		  	    		   	      		   		  class myFrame extends JFrame{		   public myFrame(){		    myPanel np = new myPanel();		    Container cont = getContentPane();		    cont.add(np);		    setBounds(10,10,800,600);		    setVisible(true);		    		   }		  }		  class myPanel extends JPanel{		   public void paintComponent(Graphics gr){		    int y = 10;		    int x = 10;		    int y1 = 40;		    int x1 = 40;		    	for(int j = 1; j < 8; j++){		     x= x+40;		     y=10;		     		for(int i = 1; i < 8; i++){		      y=y+40;		      		    gr.setColor(Color.BLUE);		    gr.drawRect(x, y, x1,y1  );		    if (myArr[j][i]>0) {gr.drawString("myArr[j][i]", x+18, y+25);}		     		}		    	}			}		  }		}*/	public static void soedin_steny (int [][] myArr){		int flag=0;		int[][] myArr1 = myArr;		while(flag==0) {					for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				if (myArr[j][i]==white & myArr[j][i-1]==black & myArr[j-1][i]==black & myArr[j-1][i-1]!=black) {myArr[j][i]=black;}				if (myArr[j][i]==white & myArr[j][i-1]==black & myArr[j+1][i]==black & myArr[j+1][i-1]!=black) {myArr[j][i]=black;}				if (myArr[j][i]==white & myArr[j][i+1]==black & myArr[j-1][i]==black & myArr[j-1][i+1]!=black) {myArr[j][i]=black;}				if (myArr[j][i]==white & myArr[j][i+1]==black & myArr[j+1][i]==black & myArr[j+1][i+1]!=black) {myArr[j][i]=black;}				for(int j1 = 1; j1 < 8; j1++){					for(int i1 = 1; i1 < 8; i1++){						if(myArr[j1][i1]==myArr1[j1][i1]){flag=1;}					}				}				}		}	}		}	public static void stena_poseredine_podskazok (int [][] myArr){		int flag=0;		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){			if (myArr[j][i]==white){				if (myArr[j][i+1]>0){flag=flag+1;}				if (myArr[j][i-1]>0){flag=flag+1;}				if (myArr[j+1][i]>0){flag=flag+1;}				if (myArr[j-1][i]>0){flag=flag+1;}			}			if (flag>1){myArr[j][i]=black;}			flag=0;			}		}	}			public static void provodim_stenu_kogda_1_varian (int [][] myArr){		//vivod_polya(myArr,"������� ���� !!!!! ");				int pustoe_pole=0;		int[][] myArr1 =new int[9][9];		for(int j1 = 1; j1 < 8; j1++){			for(int i1 = 1; i1 < 8; i1++){				myArr1[j1][i1] = myArr[j1][i1];			}		}		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				for(int j1 = 1; j1 < 8; j1++){					for(int i1 = 1; i1 < 8; i1++){						myArr1[j1][i1] = myArr[j1][i1];					}				}				if(j==6 & i==5){ 					j=j;				}				pustoe_pole=0;				if(myArr[j][i]==black & myArr[j][i-1]!=black & myArr[j][i+1]!=black & myArr[j+1][i]!=black						& myArr[j-1][i]!=black){					if(myArr[j][i-1]==white){						pustoe_pole=pustoe_pole+1;						myArr[j][i-1]=black;					}					if(myArr[j][i+1]==white){						pustoe_pole=pustoe_pole+1;						myArr[j][i+1]=black;					}					if(myArr[j-1][i]==white){						pustoe_pole=pustoe_pole+1;						myArr[j-1][i]=black;					}					if(myArr[j+1][i]==white){						pustoe_pole=pustoe_pole+1;						myArr[j+1][i]=black;					}					if(pustoe_pole>1){						for(int j2 = 1; j2 < 8; j2++){							for(int i2 = 1; i2 < 8; i2++){								myArr[j2][i2] = myArr1[j2][i2];								}						}					}				}				if(pustoe_pole==1) {vivod_polya(myArr,"������� ���� "+i+" "+j);}			}		}	}		public static void pervai_dot_ostrova (int [][] myArr){		int kol_zakr_pole=0;		int pustoe_pole=0;						for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				pustoe_pole=0;				if (myArr[j][i-1]==white ) {pustoe_pole++;}				if (myArr[j][i+1]==white ) {pustoe_pole++;}				if (myArr[j-1][i]==white ) {pustoe_pole++;}				if (myArr[j+1][i]==white ) {pustoe_pole++;}			/*	if (myArr[j][i-1]==black ) {kol_zakr_pole++;}				if (myArr[j][i+1]==black ) {kol_zakr_pole++;}				if (myArr[j+1][i]==black ) {kol_zakr_pole++;}				if (myArr[j-1][i]==black ) {kol_zakr_pole++;}				*/								if(myArr[j][i]>0 & pustoe_pole==1){					if(myArr[j][i-1]==white){						myArr[j][i-1]=dot;					}					if(myArr[j][i+1]==white){						myArr[j][i+1]=dot;					}					if(myArr[j-1][i]==white){						myArr[j-1][i]=dot;					}					if(myArr[j+1][i]==white){						myArr[j+1][i]=dot;					}									}						}		}	}	public static void prodolg_dot_ostrova_ot_podskazki (int [][] myArr){		int kol_pust_pole=kol_pust_pole=0;		int zapoln_pole=0;		while(flag==0) {			if (zapoln_pole==0){flag=1;}			zapoln_pole=0;			for(int j = 1; j < 8; j++){				for(int i = 1; i < 8; i++){					kol_pust_pole=0;					if (myArr[j][i-1]==white & myArr[j][i-1]==dot) {kol_pust_pole++;}					if (myArr[j][i+1]==white & myArr[j][i+1]==dot) {kol_pust_pole++;}					if (myArr[j+1][i]==white & myArr[j+1][i]==dot) {kol_pust_pole++;}					if (myArr[j-1][i]==white & myArr[j-1][i]==dot) {kol_pust_pole++;}					if(myArr[j][i]>0 & kol_pust_pole==1){						if(myArr[j][i-1]==white){							myArr[j][i-1]=dot;							zapoln_pole++;						}												if(myArr[j][i+1]==white){							myArr[j][i+1]=dot;							zapoln_pole++;						}												if(myArr[j-1][i]==white){							myArr[j-1][i]=dot;							zapoln_pole++;						}												if(myArr[j+1][i]==white){							myArr[j+1][i]=dot;							zapoln_pole++;						}											}				}			}		}		flag=0;	}	public static void prodolg_dot_ostrova_ot_dot (int [][] myArr){ 		int kol_pust_pole=kol_pust_pole=0;		int zapoln_pole=0;		while(flag==0) {			if (zapoln_pole==0){flag=1;}			zapoln_pole=0;			for(int j = 1; j < 8; j++){				for(int i = 1; i < 8; i++){					kol_pust_pole=0;					if (myArr[j][i-1]==white ) {kol_pust_pole++;}					if (myArr[j][i+1]==white ) {kol_pust_pole++;}					if (myArr[j+1][i]==white ) {kol_pust_pole++;}					if (myArr[j-1][i]==white ) {kol_pust_pole++;}					if(myArr[j][i]==dot & kol_pust_pole==1){						if(myArr[j][i-1]==white){							myArr[j][i-1]=dot;							zapoln_pole++;						}												if(myArr[j][i+1]==white){							myArr[j][i+1]=dot;							zapoln_pole++;						}												if(myArr[j-1][i]==white){							myArr[j-1][i]=dot;							zapoln_pole++;						}												if(myArr[j+1][i]==white){							myArr[j+1][i]=dot;							zapoln_pole++;						}											}				}			}		}	}	public static void perevodim_massiv_v_object  (int [][] myArr){//��������� ������ �� ��������� ���� � ��������� � ������� � ��� ������� ��������		Pole[][] myPole = new Pole [9][9];		for(int i = 1; i < 8; i++){			for(int j = 1; j < 8; j++){				myPole[i][j] = new Pole();				myPole [i][j].color = myArr[i][j];				myPole [i][j].flag = 0;			}		}	}		public static void vivod_new_polya(Pole[][] myPole,String textvalue){//������ ���� ��������		System.out.println(textvalue);		for(int j = 1; j < 8; j++){			for(int i = 1; i < 8; i++){				switch (myPole[i][j].color)				{				  case -2 : System.out.print("*"+" ");				  break;				  case -1 : System.out.print("X"+" ");					  break;				  default: System.out.print(myPole[i][j].color+" ");				}		    }			System.out.println();			}			}	public static int countArea(int i, int j,Pole [][] myPole) {		int S=0;		if (IsEmpty(i,j, myPole)==false) return 0;		myPole [i][j].flag=1;		if 		(IsEmpty(i-1,j, myPole)==false				& IsEmpty(i+1,j, myPole)==false				& IsEmpty(i,j-1, myPole)==false			    & IsEmpty(i,j+1, myPole)==false				){			return   1;		}		return 1+countArea(i,j+1, myPole)+countArea(i,j-1, myPole)+countArea(i+1,j, myPole)+countArea(i-1,j, myPole);    }		public static boolean IsEmpty( int i, int j,Pole[][] myPole) {		if (myPole [i][j].color==0 & myPole [i][j].flag==0 ) 			return true;		else 			return false;			}			public static void area (Pole [][] myPole, int i, int j, int S){		if (myPole [i][j].color==0 & myPole [i][j].flag==0){			myPole[i][j].flag=1;			S=S+1;		}	}}					   