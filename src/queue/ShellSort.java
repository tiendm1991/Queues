package queue;

import java.util.Arrays;

public class ShellSort {
	public void sort(int[] arr){
		int N = arr.length;
		int h = 1;
		while (h < N/3) {
			h = 3*h+1;
		}
		while (h > 0) {
			for(int i = 0; i < N-h; i++){
				for(int j = i+h ; j >= 0; j-= h){
					if(arr[j-h] >= arr[j]) swap(arr, j, j-h);
					else {
						break;
					}
				}
			}
			h = h/3;
		}
	}
	
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,8,9,54,65,34,12,54,89,76,23,12,65,34};
		System.out.println(Arrays.toString(arr));
		ShellSort shell = new ShellSort();
		shell.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
