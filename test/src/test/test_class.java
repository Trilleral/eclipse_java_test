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
		//����� �������� �� �������
//		for(int i = 0; i < 15; i++){
//		    System.out.println((i+1) + "-� ������� ������� = " +   myArray[i]);
//		}	
	}
}
	class lalala {
		int lastvalue=0;
		void printarray(int[] arr1){
			for(int i = 0; i < 15; i++){
			    System.out.println((i+1) + "-� ������� ������� = " +   arr1[i]);
			}	
			
		}
		
		public void selectionSort(int[] arr){
			
		    /*�� ������� ����� ������������� ��� ������������
		      ��������� ������� (0 - ���������, 1-���������, 
		      2-���������,...)*/
		    for (int i = 0; i < arr.length; i++) {
		        /*������������, ��� ������ ������� (� ������
		           ������������ ���������) �������� ����������� */
		        int min = arr[i];
		        int min_i = i; 
		        /*� ���������� ����� ������������ ���� �������,
		           ������� ������ ��������������� ��������*/
		        for (int j = i+1; j < arr.length; j++) {
		            //���� �������, ���������� ��� ������
		            if (arr[j] < min) {
		                min = arr[j];
		                min_i = j;
		            }
		        }
		        /*���� ������� �������, �������, ��� �� ������� �������,
		          ������ �� �������*/
		        if (i != min_i) {
		            int tmp = arr[i];
		            arr[i] = arr[min_i];
		            arr[min_i] = tmp;
		        }
		     }
		    lastvalue=1;
		}		
	}

	
	


