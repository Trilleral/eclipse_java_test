package test;

public class Akari_class {
// ойляля 
	// 2
	public static void main(String[] args) {
		int[][] myArray = new int[10][10];
		 int[][] myArray1 = new int[10][10];
		int[] Array_z = new int[64];
		int zasvetka = 0;
		int kol_pust_pole=0;
		int kol_pust_pole_end=0;
		setpolye(myArray); 				//инициализируем первоначальное значение
		vivod_polya(myArray);			//вывод значений на консоль
		Obrabotka_black_pole(myArray);
		providim_svet( myArray,zasvetka);
		vivod_polya(myArray);			//вывод значений на консоль
		kol_pust_pole=0;
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArray[j][i]==6){
					kol_pust_pole = kol_pust_pole+1;};
			}
		}
		
		double kol_variantov=Math.pow(2, kol_pust_pole);//подсчет количества вариантов результат помещаем в переменную kol_variantov
			for(int i =1; i < kol_variantov; i++){//перебор всех вариантов
				//System.out.println(Integer.toBinaryString(i));
				String str1 = Integer.toBinaryString(i);//в переменную str1 записываем текстовый двоичный код числа
				for(int k=0; k<64; k++){Array_z[k]=0;}//обнуление массива Array_z
		
				for(int k1=1; k1<=str1.length();k1++){//перевод переменной str1 в массив Array_z
					if (str1.charAt(k1-1)=='1'){
						Array_z[kol_pust_pole-str1.length()+k1]=1;
					}
				}
				System.out.println();//вывод массива
				for(int k=1; k<=kol_pust_pole; k++){
					System.out.print(Array_z[k]);
					}
				save_array(myArray,myArray1);
				podstanovka(myArray,Array_z);
				providim_svet( myArray,zasvetka);
				
				kol_pust_pole_end=0;
				for(int i2 = 1; i2 < 9; i2++){
					for(int j2 = 1; j2 < 9; j2++){
						if (myArray[j2][i2]==6 || myArray[j2][i2]==8){
							kol_pust_pole_end = kol_pust_pole_end+1;};
					}
				}
				if (zasvetka>0){
					vivod_polya(myArray);					
					
				}
				
				if (kol_pust_pole_end==0 & zasvetka==0){
					vivod_polya(myArray);					
				}

				restor_array( myArray, myArray1);

			}
		
		
		

	}

	
	
	public static void podstanovka(int[][] myArr, int[] Arr_z){
		int nomer_pustogo_pol=0;
		for(int i = 1; i < 9; i++){//подстановка вариантов в базовый массив
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]==6){// если значение массива = 6(пустое поле)
					nomer_pustogo_pol++;//задаем порядковый номер пустого поля
					if (Arr_z[nomer_pustogo_pol]==1){//если значение массива = 1 
						myArr[j][i]=9;// ставим лампочку
					}
				}
		  
			}
			
			//restor_array(myArray,myArray1);
		}
	}	
	
	public static void save_array(int[][] myArr,int[][] myArr1){//coхранение массива myArray в myArray1
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr1[i][j] =  myArr [i][j];
			}		
		}
	}	
	public static void restor_array(int[][] myArr,int[][] myArr1){//восстановление массива myArray
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr[i][j] =  myArr1 [i][j];
			}		
		}
	}	
	public static void setpolye(int[][] myArr){
		//заполняем всё 6
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
		    myArr[i][j] = 6;
			}
		}
		//Отдельные значение
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
		int kol_BEZ_lamp,kol_lamp,kol_lighton_lamp,FlagFinish,zasvetka;
		FlagFinish=0;
		zasvetka=0;
		while(FlagFinish==0) {
		kol_lighton_lamp=0;
		
		
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]<5){
					kol_BEZ_lamp=0;
					kol_lamp=0;
					if ((myArr[j][i-1]==6) & (i-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j+1][i]==6) & (j+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j][i+1]==6) & (i+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j-1][i]==6) & (j-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					   
					if ((myArr[j][i-1]==9) & (i-1>0)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j+1][i]==9) & (j+1<9)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j][i+1]==9) & (i+1<9)) {kol_lamp=kol_lamp+1;}
					if ((myArr[j-1][i]==9) & (j-1>0)) {kol_lamp=kol_lamp+1;}

					if (kol_lamp==myArr[j][i]){
					// Если количество ламп вокруг равно значению черного поля
					// То в пустые поля проставляем 8 (мимо)	
						if ((myArr[j][i-1]==6) ) {myArr[j][i-1]=8;}
						if ((myArr[j+1][i]==6) ) {myArr[j+1][i]=8;}
						if ((myArr[j][i+1]==6) ) {myArr[j][i+1]=8;}
						if ((myArr[j-1][i]==6) ) {myArr[j-1][i]=8;}
					}
					if (kol_BEZ_lamp==myArr[j][i]-kol_lamp){
						// Если количество пустых полей вокруг равно 
						// значению черного поля уменьшенное на кол ламп 
						// То в пустые поля проставляем 9 (лампы)	
							if ((myArr[j][i-1]==6) ) {myArr[j][i-1]=9;}
							if ((myArr[j+1][i]==6) ) {myArr[j+1][i]=9;}
							if ((myArr[j][i+1]==6) ) {myArr[j][i+1]=9;}
							if ((myArr[j-1][i]==6) ) {myArr[j-1][i]=9;}
							kol_lighton_lamp=kol_lighton_lamp+kol_BEZ_lamp;
					}
					
				} // if 
					
			}	//for j 
		}		//for i 
		providim_svet( myArr,zasvetka);
		if (kol_lighton_lamp==0) {FlagFinish=1;}
		} 		//while 
	}
	

	public static void providim_svet(int[][] myArr,int zasvetka){
		int i1,j1;
		
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]==9){
					i1=i-1;
					j1=j;
						while((i1>0) & (myArr[j1][i1]>5) ){
							if (myArr[j1][i1]==9){zasvetka=1;}
							myArr[j1][i1]=7;
							i1=i1-1;		
						}
						i1=i+1;
						j1=j;
						while((i1<9) & (myArr[j1][i1]>5) ){
							if (myArr[j1][i1]==9){zasvetka=1;}
							myArr[j1][i1]=7;
							i1=i1+1;		
						}
						i1=i;
						j1=j+1;
						while((j1<9) & (myArr[j1][i1]>5)){
							if (myArr[j1][i1]==9){zasvetka=1;}
							myArr[j1][i1]=7;
							j1=j1+1;		
						}
						i1=i;
						j1=j-1;
						while((j1>0) & (myArr[j1][i1]>5)){
							if (myArr[j1][i1]==9){zasvetka=1;}
							myArr[j1][i1]=7;
							j1=j1-1;		
						}
				}
				
			}
	
		}
		if (zasvetka>0){
			vivod_polya(myArr);
		}
							
	}	
	public static void vivod_polya(int[][] myArr){
		//вывод значений на консоль
		System.out.println();
		for(int j = 1; j < 9; j++){
			for(int i = 1; i < 9; i++){
		    	if (myArr[i][j]==6) {
		    		System.out.print("*"+" ");
		    		}
		    	else {
		    		System.out.print(myArr[i][j]+" ");
		    		}
			}	
			System.out.println();
		}	
		
	}
}
