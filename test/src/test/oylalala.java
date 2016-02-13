package test;

public class oylalala {
	//������� ������ ������ ���� https://contest.yandex.ru/contest/1627/problems/
	//�������� �� ����� Nikoli ����� �����������, ����� ������: http://www.nikoli.co.jp/en/puzzles/.
	//�������� ��� �� �������, ������� �������� �������������� ���������� ����, � ���������� ���� � �������� ������������. 
	//������� ������ ���� �������� �� ����������� � ������������� ����� � �������������� �������� 
	//� ������ ��������� ��������������� ����������������.
	//������ �� ������ http://www.nikoli.co.jp/en/puzzles/akari.html
	//��������� ��������
	//"0"-������ ���� � ������ 0 ������
	//"1"-������ ���� � ������ 1 ������
	//"2"-������ ���� � ������ 2 ������
	//"3"-������ ���� � ������ 3 ������
	//"4"-������ ���� � ������ 4 ������
	//"5"-������ ������ ����
	//"6"-������ ����
	//"7"-������ ������������ ����
	//"8"-������ ���� � ������� �� ����� ���� ��������
	//"9"-���� � ���������
	//"10"-���� � ��������� ������� ��������� ������ ��������� 
	private static int zasvetka = 0;
	public static void main(String[] args) {
		int[][] myArray = new int[10][10];
		 int[][] myArray1 = new int[10][10];
		int[] Array_z = new int[64];
		int kol_pust_pole=0;
		int kol_pust_pole_end=0;
		setpolye(myArray); 				  							 //�������������� �������������� ��������
		vivod_polya(myArray,"�������� ����");						 //����� �������� �� �������
		Obrabotka_black_pole(myArray);								 //����������� �������� � ����� ���� ������ ������ ����� � �������
		providim_svet( myArray);									 //�� ������ �������� � ������ ������� ��������� ���� "7" � ���� �������� �� ������ ��������,�� "10" 
		vivod_polya(myArray,"������ ��� ������� ����");				 //����� �������� �� �������
		kol_pust_pole = count_pust_pole (myArray);					 //������� ����� "6"(� ��� ����� ������� "9"
		double kol_variantov=Math.pow(2, kol_pust_pole);			 //������� ���������� ��������� ��������� �������� � ���������� kol_variantov
			for(int i =1; i < kol_variantov; i++){				
				//������� ���� ���������		
				sozdanie_variantov_perebora (kol_pust_pole,Array_z,i);//�������� ������� � ��������� ����������� "9"
				save_array(myArray,myArray1);						  //���������� ������� myArray � ������ myArray1
				podstanovka(myArray,Array_z);						  //����������� �������� Array_z �� ������ ���� myArray
				providim_svet( myArray);							  //�� ������ �������� � ������ ������� ��������� ���� "7" � ���� �������� �� ������ ��������,�� "10" 
				kol_pust_pole_end=count_pust_pole_end (myArray);	  //������� ����� "6" � "8" ����� ���������� ���� �������� 
				if (kol_pust_pole_end==0 & zasvetka==0){
					//���� ������ ����� ��� � ������� �������� ���, �� ������� ������ myArray
					vivod_polya(myArray,"������� ������");					
				}
				restor_array( myArray, myArray1);//��������������� �������� �������� ������� myArray
			}
	}
	
	public static void sozdanie_variantov_perebora (int kol_pust_pole, int[]  Array_z, int i){
		String str1 = Integer.toBinaryString(i);//� ���������� str1 ���������� ��������� �������� ��� �����
		for(int k=0; k<64; k++){Array_z[k]=0;}
		//��������� ������� Array_z
		for(int k1=1; k1<=str1.length();k1++){
			//������� ���������� str1 � ������ Array_z
			if (str1.charAt(k1-1)=='1'){
				Array_z[kol_pust_pole-str1.length()+k1]=1;//��������� ������ � ������ Array_z(� ��������� �� ������ ������)
			}
		}
	}
	
	public static  int count_pust_pole_end (int [][] myArr){
		//������� ���������� ����� �� ������� �� �������� ����
		int kol_pust_pole=0;
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]==6||myArr[j][i]==8){
					kol_pust_pole = kol_pust_pole+1;};
					
			}
		}
		return kol_pust_pole;
	}
	
	public static  int count_pust_pole (int [][] myArr){
		//������� ���������� ����� �� ������� ����� ��������� ��������
		int kol_pust_pole=0;
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]==6){
					kol_pust_pole = kol_pust_pole+1;};
			}
		}
		return kol_pust_pole;
	}
	
	public static void podstanovka(int[][] myArr, int[] Arr_z){
		//����������� �������� Array_z �� ������ ���� myArray
		int nomer_pustogo_pol=0;
		for(int i = 1; i < 9; i++){//����������� ��������� � ������� ������
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]==6){// ���� �������� ������� = 6(������ ����)
					nomer_pustogo_pol++;//������ ���������� ����� ������� ����
					if (Arr_z[nomer_pustogo_pol]==1){//���� �������� ������� = 1 
						myArr[j][i]=9;// ������ ��������
					}
				}
			}
		}
	}	
	
	public static void save_array(int[][] myArr,int[][] myArr1){
		//co�������� ������� myArray � myArray1
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr1[i][j] =  myArr [i][j];
			}		
		}
	}	
	public static void restor_array(int[][] myArr,int[][] myArr1){
		//�������������� ������� myArray
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr[i][j] =  myArr1 [i][j];
			}		
		}
	}	
	public static void setpolye(int[][] myArr){
		//��������� ��������� �������� ������� myArray
		for(int i = 0; i < 10; i++){
			//��������� �� 6
			for(int j = 0; j < 10; j++){
		    myArr[i][j] = 6;
			}
		}
		//��������� ��������
		myArr[6][1]=1;
		myArr[2][2]=3;
		myArr[3][2]=5;
		myArr[7][3]=0;
		myArr[1][4]=5;
		myArr[5][4]=5;
		myArr[4][5]=4;
		myArr[8][5]=0;
		myArr[2][6]=2;
		myArr[6][7]=1;
		myArr[7][7]=5;
		myArr[3][8]=5;
	}
	
	public static void Obrabotka_black_pole(int[][] myArr){
		// ����������� �������� � ����� ���� ������ ������ ����� � �������
		int kol_BEZ_lamp,kol_lamp,kol_lighton_lamp,FlagFinish;
		FlagFinish=0;

		while(FlagFinish==0) {
			//��������� �������� �� ��� ���, ���� �������� ��������� ��������� � ���������� ������� ��������
		kol_lighton_lamp=0;
		
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]<5){
					//������ ��� ������ �����
					kol_BEZ_lamp=0;
					kol_lamp=0;
					//������� �� ����������� ����� ������ ������� ����, �������� ��������� � ���������� kol_BEZ_lamp
					if ((myArr[j][i-1]==6) & (i-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j+1][i]==6) & (j+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j][i+1]==6) & (i+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j-1][i]==6) & (j-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					//������� �������� ������ ������� ����, ��������� �������� � ���������� kol_lamp
					if ((myArr[j][i-1]==9) & (i-1>0)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j+1][i]==9) & (j+1<9)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j][i+1]==9) & (i+1<9)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j-1][i]==9) & (j-1>0)) {kol_lamp=kol_lamp+1;}

					if (kol_lamp==myArr[j][i]){
					// ���� ���������� ���� ������ ����� �������� ������� ����
					// �� � ������ ���� ����������� 8 (����)	
						if ((myArr[j][i-1]==6) ) {myArr[j][i-1]=8;}
						if ((myArr[j+1][i]==6) ) {myArr[j+1][i]=8;}
						if ((myArr[j][i+1]==6) ) {myArr[j][i+1]=8;}
						if ((myArr[j-1][i]==6) ) {myArr[j-1][i]=8;}
					}
					if (kol_BEZ_lamp==myArr[j][i]-kol_lamp){
						// ���� ���������� ������ ����� ������ ����� 
						// �������� ������� ���� ����������� �� ��� ���� 
						// �� � ������ ���� ����������� 9 (�����) � ����������� �������� ���������� kol_lighton_lamp	
							if ((myArr[j][i-1]==6) ) {
								myArr[j][i-1]=9;
								kol_lighton_lamp++;
							}
							if ((myArr[j+1][i]==6) ) {
								myArr[j+1][i]=9;
								kol_lighton_lamp++;	
							}
							if ((myArr[j][i+1]==6) ) {
								myArr[j][i+1]=9;
								kol_lighton_lamp++;
							}
							if ((myArr[j-1][i]==6) ) {
								myArr[j-1][i]=9;
								kol_lighton_lamp++;
							}	
					}
					
				} // if 
					
			}	//for j 
		}		//for i 
		providim_svet( myArr); //�� ������ �������� � ������ ������� ��������� ���� "7" � ���� �������� �� ������ ��������,�� "10" 
		if (kol_lighton_lamp==0) {FlagFinish=1;}//���� �� �������� �� ���� ��������, �� ����������� ���������
		} 		//while 
	}
	
	public static void providim_svet(int[][] myArr){
		 //�� ������ �������� � ������ ������� ��������� ���� "7" � ���� �������� �� ������ ��������,�� "10" 
		int i1,j1;
		zasvetka=0;
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				//���������� �� ����� �������
				if (myArr[j][i]==9){
					//���� �������� ���� "9"(��������) ����� �������� ���� � 4 �������
					i1=i-1;//����
					j1=j;
						while((i1>0) & (myArr[j1][i1]>5) ){
						
							if (myArr[j1][i1]==9){
								//���� ��� ��������������� ����� ���������� �� ��������, �� � ���� ������ "10"(��������)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//������������ ������ ����	
							}

							i1=i1-1;		
						}
						i1=i+1;//�����
						j1=j;
						while((i1<9) & (myArr[j1][i1]>5) ){
							
							if (myArr[j1][i1]==9){
								//���� ��� ��������������� ����� ���������� �� ��������, �� � ���� ������ "10"(��������)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//������������ ������ ����	
							}
							i1=i1+1;		
						}
						i1=i; //������
						j1=j+1;
						while((j1<9) & (myArr[j1][i1]>5)){
							
							if (myArr[j1][i1]==9){
								//���� ��� ��������������� ����� ���������� �� ��������, �� � ���� ������ "10"(��������)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//������������ ������ ����	
							}
							j1=j1+1;		
						}
						i1=i; //�����
						j1=j-1;
						while((j1>0) & (myArr[j1][i1]>5)){
							
							if (myArr[j1][i1]==9){
								//���� ��� ��������������� ����� ���������� �� ��������, �� � ���� ������ "10"(��������)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//������������ ������ ����	
							}
							j1=j1-1;		
						}
				}
			}
		}				
	}
	
	public static void vivod_polya(int[][] myArr,String textvalue){
		//����� �������� �� �������
		System.out.println(textvalue);
		for(int j = 1; j < 9; j++){
			for(int i = 1; i < 9; i++){
		    	if (myArr[i][j]==6 || myArr[i][j]==10) {
		    		if (myArr[i][j]==6){
		    			System.out.print("*"+" ");	
		    		}
		    		else{
		    			System.out.print("�"+" ");	
		    		}
		    		
		    		}
		    	else {
		    		System.out.print(myArr[i][j]+" ");
		    		}
			}	
			System.out.println();
		}	
	}
}
