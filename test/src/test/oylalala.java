package test;

public class oylalala {
	//решение задачи малого ШАДа https://contest.yandex.ru/contest/1627/problems/
	//Выберите на сайте Nikoli любую головоломку, кроме судоку: http://www.nikoli.co.jp/en/puzzles/.
	//Напишите для неё функцию, которая получает первоначальное заполнение поля, а возвращает поле с решенной головоломкой. 
	//Функция должна быть написана по возможности в декларативном стиле с использованием рекурсии 
	//и других элементов функционального программирования.
	//ссылка на задачу http://www.nikoli.co.jp/en/puzzles/akari.html
	//кодировка значений
	//"0"-черное поле с цифрой 0 внутри
	//"1"-чёрное поле с цифрой 1 внутри
	//"2"-чёрное поле с цифрой 2 внутри
	//"3"-чёрное поле с цифрой 3 внутри
	//"4"-чёрное поле с цифрой 4 внутри
	//"5"-пустое черное поле
	//"6"-пустое поле
	//"7"-пустое подсвеченное поле
	//"8"-пустое поле в котором не может быть лампочек
	//"9"-поле с лампочкой
	//"10"-поле с лампочкой которая засвечена другой лампочкой 
	private static int zasvetka = 0;
	public static void main(String[] args) {
		int[][] myArray = new int[10][10];
		 int[][] myArray1 = new int[10][10];
		int[] Array_z = new int[64];
		int kol_pust_pole=0;
		int kol_pust_pole_end=0;
		setpolye(myArray); 				  							 //инициализируем первоначальное значение
		vivod_polya(myArray,"Исходное поле");						 //вывод значений на консоль
		Obrabotka_black_pole(myArray);								 //расстоновка лампочек и полей мимо вокруг чёрных полей с цифрами
		providim_svet( myArray);									 //от каждой лампочки в четыре стороны заполняем поля "7" и если попадаем на другую лампочку,то "10" 
		vivod_polya(myArray,"Первый раз провели свет");				 //вывод значений на консоль
		kol_pust_pole = count_pust_pole (myArray);					 //подсчет полей "6"(в них можно ставить "9"
		double kol_variantov=Math.pow(2, kol_pust_pole);			 //подсчет количества вариантов результат помещаем в переменную kol_variantov
			for(int i =1; i < kol_variantov; i++){				
				//перебор всех вариантов		
				sozdanie_variantov_perebora (kol_pust_pole,Array_z,i);//создание массива с вариантом расстоновки "9"
				save_array(myArray,myArray1);						  //сохранение массива myArray в массив myArray1
				podstanovka(myArray,Array_z);						  //подстановка значений Array_z на пустые поля myArray
				providim_svet( myArray);							  //от каждой лампочки в четыре стороны заполняем поля "7" и если попадаем на другую лампочку,то "10" 
				kol_pust_pole_end=count_pust_pole_end (myArray);	  //подсчет полей "6" и "8" после выполнения всех операций 
				if (kol_pust_pole_end==0 & zasvetka==0){
					//если пустых полей нет и случаев засветки нет, то выводим массив myArray
					vivod_polya(myArray,"Решение задачи");					
				}
				restor_array( myArray, myArray1);//восстанавливаем исходное значение массива myArray
			}
	}
	
	public static void sozdanie_variantov_perebora (int kol_pust_pole, int[]  Array_z, int i){
		String str1 = Integer.toBinaryString(i);//в переменную str1 записываем текстовый двоичный код числа
		for(int k=0; k<64; k++){Array_z[k]=0;}
		//обнуление массива Array_z
		for(int k1=1; k1<=str1.length();k1++){
			//перевод переменной str1 в массив Array_z
			if (str1.charAt(k1-1)=='1'){
				Array_z[kol_pust_pole-str1.length()+k1]=1;//переводим строку в массив Array_z(с поправкой на длинну строки)
			}
		}
	}
	
	public static  int count_pust_pole_end (int [][] myArr){
		//подсчет количества полей на которых не проведен свет
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
		//подсчет количества полей на которых можно поставить лампочки
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
		//подстановка значений Array_z на пустые поля myArray
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
		}
	}	
	
	public static void save_array(int[][] myArr,int[][] myArr1){
		//coхранение массива myArray в myArray1
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr1[i][j] =  myArr [i][j];
			}		
		}
	}	
	public static void restor_array(int[][] myArr,int[][] myArr1){
		//восстановление массива myArray
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				 myArr[i][j] =  myArr1 [i][j];
			}		
		}
	}	
	public static void setpolye(int[][] myArr){
		//заполняем начальное значение массива myArray
		for(int i = 0; i < 10; i++){
			//заполняем всё 6
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
		// расстановка лампочек и полей мимо вокруг чёрных полей с цифрами
		int kol_BEZ_lamp,kol_lamp,kol_lighton_lamp,FlagFinish;
		FlagFinish=0;

		while(FlagFinish==0) {
			//повторяем операцию до тех пор, пока операция превносит изменение в количество горящих лампочек
		kol_lighton_lamp=0;
		
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				if (myArr[j][i]<5){
					//только для черных полей
					kol_BEZ_lamp=0;
					kol_lamp=0;
					//подсчет не заполненных полей вокруг черного поля, помещаем результат в переменную kol_BEZ_lamp
					if ((myArr[j][i-1]==6) & (i-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j+1][i]==6) & (j+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j][i+1]==6) & (i+1<9)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					if ((myArr[j-1][i]==6) & (j-1>0)) {kol_BEZ_lamp=kol_BEZ_lamp+1;}
					//подсчет лампочек вокруг черного поля, результат помещаем в переменную kol_lamp
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
						// То в пустые поля проставляем 9 (лампы) и увеличиваем значение переменной kol_lighton_lamp	
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
		providim_svet( myArr); //от каждой лампочки в четыре стороны заполняем поля "7" и если попадаем на другую лампочку,то "10" 
		if (kol_lighton_lamp==0) {FlagFinish=1;}//если не зажглась ни одна лампочка, то заканчиваем процедуру
		} 		//while 
	}
	
	public static void providim_svet(int[][] myArr){
		 //от каждой лампочки в четыре стороны заполняем поля "7" и если попадаем на другую лампочку,то "10" 
		int i1,j1;
		zasvetka=0;
		for(int i = 1; i < 9; i++){
			for(int j = 1; j < 9; j++){
				//проходимся по всему массиву
				if (myArr[j][i]==9){
					//если значение поля "9"(лампочка) тогда проводим свет в 4 стороны
					i1=i-1;//вниз
					j1=j;
						while((i1>0) & (myArr[j1][i1]>5) ){
						
							if (myArr[j1][i1]==9){
								//если при распространении света наткнулись на лампочку, то в поле ставим "10"(засветка)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//подсвесенное пустое поле	
							}

							i1=i1-1;		
						}
						i1=i+1;//вверх
						j1=j;
						while((i1<9) & (myArr[j1][i1]>5) ){
							
							if (myArr[j1][i1]==9){
								//если при распространении света наткнулись на лампочку, то в поле ставим "10"(засветка)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//подсвесенное пустое поле	
							}
							i1=i1+1;		
						}
						i1=i; //вправо
						j1=j+1;
						while((j1<9) & (myArr[j1][i1]>5)){
							
							if (myArr[j1][i1]==9){
								//если при распространении света наткнулись на лампочку, то в поле ставим "10"(засветка)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//подсвесенное пустое поле	
							}
							j1=j1+1;		
						}
						i1=i; //влево
						j1=j-1;
						while((j1>0) & (myArr[j1][i1]>5)){
							
							if (myArr[j1][i1]==9){
								//если при распространении света наткнулись на лампочку, то в поле ставим "10"(засветка)
								zasvetka=1;
								myArr[j1][i1]=10;
								}
							else{
								myArr[j1][i1]=7;//подсвесенное пустое поле	
							}
							j1=j1-1;		
						}
				}
			}
		}				
	}
	
	public static void vivod_polya(int[][] myArr,String textvalue){
		//вывод значений на консоль
		System.out.println(textvalue);
		for(int j = 1; j < 9; j++){
			for(int i = 1; i < 9; i++){
		    	if (myArr[i][j]==6 || myArr[i][j]==10) {
		    		if (myArr[i][j]==6){
		    			System.out.print("*"+" ");	
		    		}
		    		else{
		    			System.out.print("Х"+" ");	
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
