import java.util.*;

class CompareArrayAndLists
{
    public static boolean process1(int size){

        ArrayList<Character> list=new ArrayList<>();

        char arr[]=new char[size];

        for(int i=0;i<size;i++) arr[i]='b';
        long start = System.currentTimeMillis();
        for(int i=0;i<size;i++) list.add('a');
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec);
        if(sec<10) return true;
        return false;
    }

    public static void process2()
    {
        int size=10000;
        ArrayList<Character> arrayList=new ArrayList<>();
        LinkedList<Character> linkedList=new LinkedList<>();

        char arr[]=new char[size];
        for(int i=0;i<size;i++) arr[i]='b';
        for(int i=0;i<size;i++) arrayList.add('a');
        for(int i=0;i<size;i++) linkedList.add('c');

        System.out.println("Measuring the time taken to sum the Data structures");
        int sum=0;
        long start = System.currentTimeMillis();
        for(int i=0;i<size;i++) sum+=arr[i];
        long end = System.currentTimeMillis();
        float sec = (end - start);
        System.out.println("Time taken to sum in array : "+sec);



        sum=0;
        start = System.currentTimeMillis();
        for(char a : arrayList) sum+=a;
        end = System.currentTimeMillis();
        sec = (end - start);
        System.out.println("Time taken to sum in ArrayList : "+sec);

        sum=0;
        start = System.currentTimeMillis();
        for(char a : linkedList) sum+=a;
        end = System.currentTimeMillis();
        sec = (end - start);
        System.out.println("Time taken to sum in LinkedList : "+sec);
    }


    public static void main(String gg[])
    {
        boolean shouldBreak=true;
        int size=10000;
        while(shouldBreak)
        {
            shouldBreak=process1(size);
            size=size*10;
        }
        process2();
    }
}