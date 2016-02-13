package test;
class test_class {
	public static void  main(String args[]){
//		System.out.println("Hello world");
		int[] myArray = new int[15];
		for(int i = 0; i < 15; i++){
		    myArray[i] = 15-i;
		}
		lalala mmm = new lalala();
		System.out.println("lalala "+mmm.lastvalue);
		mmm.printarray(myArray);
		mmm.selectionSort(myArray);
		System.out.println("lalala "+mmm.lastvalue);
		mmm.printarray(myArray);
		//вывод значений на консоль
//		for(int i = 0; i < 15; i++){
//		    System.out.println((i+1) + "-й элемент массива = " +   myArray[i]);
//		}	
	}
}
	class lalala {
		int lastvalue=0;
		void printarray(int[] arr1){
			for(int i = 0; i < 15; i++){
			    System.out.println((i+1) + "-й элемент массива = " +   arr1[i]);
			}	
			
		}
		
		public void selectionSort(int[] arr){
			
		    /*По очереди будем просматривать все подмножества
		      элементов массива (0 - последний, 1-последний, 
		      2-последний,...)*/
		    for (int i = 0; i < arr.length; i++) {
		        /*Предполагаем, что первый элемент (в каждом
		           подмножестве элементов) является минимальным */
		        int min = arr[i];
		        int min_i = i; 
		        /*В оставшейся части подмножества ищем элемент,
		           который меньше предположенного минимума*/
		        for (int j = i+1; j < arr.length; j++) {
		            //Если находим, запоминаем его индекс
		            if (arr[j] < min) {
		                min = arr[j];
		                min_i = j;
		            }
		        }
		        /*Если нашелся элемент, меньший, чем на текущей позиции,
		          меняем их местами*/
		        if (i != min_i) {
		            int tmp = arr[i];
		            arr[i] = arr[min_i];
		            arr[min_i] = tmp;
		        }
		     }
		    lastvalue=1;
		}		
	}

	
	


