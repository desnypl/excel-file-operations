package exceloperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Sample1 {

public void getMyResponse(String file1, String orderId, String file2) throws IOException{
	
File fin= new File(file1);

FileInputStream fis= new FileInputStream(fin);

FileWriter filewriter= new FileWriter(file2);

BufferedWriter bufferwriter=new BufferedWriter(filewriter);

BufferedReader in = new BufferedReader(new InputStreamReader(fis));

Scanner scanner= new Scanner(fis);
ArrayList <String> al=new ArrayList<String>();
ArrayList <String> al1=new ArrayList<String>();
ArrayList <String> al2=new ArrayList<String>();
ArrayList <String> al3=new ArrayList<String>();
String s1="<soapenv:envelope";
String s2="</soapenv:envelope>";
String s3="<soap-env:envelope";
int t;

while(scanner.hasNextLine()){
	String line= scanner.nextLine();
	al.add(line.toLowerCase());
}
for(String lists:al){
t= al.indexOf(lists);
if(lists.contains(s1)){
	
	do{
		al1.add(lists);
		t++;
	}while(!al.get(t-1).contains(s2));
	
	String line1=al.get(t);
	do{
		line1=al.get(t);
		t++;
	}while(!al.get(t-1).contains(s3));
	
	if(line1.contains(s3)){
		al1.add(line1);
	}
}
else{
	t++;
	al3.add(lists);
}
	
}
al2.addAll(al1);

for(String arrayList:al2){
	if(arrayList.contains(orderId.toLowerCase())){
		
		bufferwriter.newLine();
		bufferwriter.write(arrayList.toString());
		bufferwriter.newLine();
	}
	else{
		for(String all3:al3){
			if(all3.contains(orderId.toLowerCase())){
				
				bufferwriter.newLine();
				bufferwriter.write(arrayList.toString());
				bufferwriter.newLine();	
			}
		}
	}
}

al.clear();
al1.clear();
al2.clear();
in.close();

filewriter.close();
bufferwriter.close();
}
	
public static void main(String[] args) throws IOException {
		
		//String file1="E:\WORKSPACE\eclipseneon\logs\logs.txt";
		//String orderId="OrderID";
		//String file2="E:\WORKSPACE\eclipseneon\logs\response.txt";

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the path of the log file");
		String file1  =sc.next();
		System.out.println("Enter the orderID to search in the log file");
		String orderId=sc.next();
		System.out.println("Enter the file to write the search results");
		String file2=sc.next();
		Sample1 sample= new Sample1();
		sample.getMyResponse(file1, orderId, file2);
	}

}
