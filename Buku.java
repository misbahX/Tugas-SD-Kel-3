package latian2;


import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
public class Buku {
    int id,tahun;
    String judul;
    Buku next;
    public static Scanner in=new Scanner(System.in);
    public static Scanner str=new Scanner(System.in);
    public void input(){
        System.out.print("| Masukkan id buku      : ");
        id=in.nextInt();
        System.out.print("| Masukkan judul        : ");
        judul=str.nextLine();
        System.out.print("| Masukkan tahun terbit : ");
        tahun=in.nextInt();
        next=null;
    }
    public void view(){
        System.out.printf("| id buku    : %-20d        |\n",id);
        System.out.printf("| judul        : %-20s      |\n",judul);
        System.out.printf("| tahun terbit : %-20d      |\n",tahun);
        System.out.println("+------------------------------------------+");
    }
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        int menu=0;
        linked st=new linked();
        clearScreen();
        while(menu!=4){
            System.out.println("+------------------------------------------+");
            System.out.println("| 1.push                                   |");
            System.out.println("| 2.pop                                    |");
            System.out.println("| 3.view                                   |");
            System.out.println("| 4.exit                                   |");
            System.out.print("| masukan pilihan: ");
            menu=in.nextInt();
            if(menu==1){
                Buku baru=new Buku();
                baru.input();
                st.push(baru);
            }
            else if(menu==2) st.pop();
            else if(menu==3) st.view();
                             
            else if(menu==4) System.out.println("| keluar . . .                             |");
            else System.out.println("| salah . . .                              |");
                 
            System.out.println(" ");
        }
    }    
}

class linked{
    Buku top;
    public linked(){
        top=null;
    }
    public void push(Buku a){
        if(top==null) top=a;
        else{
            a.next=top;
            top=a;
        }
    }
    public void pop(){
        if(top==null) System.out.println("| kosong                                   |");
        else{
            System.out.println("| Popping Data . . .                       |");
            top.view();
            top=top.next;
        }
    }
    public void view(){
        if(top==null) System.out.println("| kosong                                   |");

        else{
            Buku ptr=top;
            while(ptr!=null){
                System.out.println("| - - - - -                                |");
                ptr.view();
                ptr=ptr.next;
            }
        }
    }
}
