package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        InformasiSaldo a = new InformasiSaldo();
        Transfer c = new Transfer();String nama;
        Penarikan b = new Penarikan();
        Keluar d = new Keluar();
        int pin[] = {135779,124686,123789};int input=0,i=0,y=0,x=0,u=0;int saldor;
        int inputPIN, pilih,tarikUang,transfer,noRek;
        int noRekTeman[] = {2000018178,2000018180,2000018209,2000018216,2000018220};
        int saldo[] = {4000000,3500000,5000000}; String namarek[] = {"Rizal","Zahra","Vintya","Arif","Sendy"};
        int bonus;boolean pins = false;
        do {
            if (input < 3) {
                System.out.println("Masukan pin anda = ");
                inputPIN = masuk.nextInt();
                do {
                    if (inputPIN == pin[i]) {
                        pins = true;
                    }i++;
                }while (i >= 3);
            }
            else{
                System.out.println("MAAF ATM ANDA TELAH TERBLOKIR");
                System.exit(0);
            }
            input++;
        } while (pins == false) ;
        System.out.println("Confirm pin anda = ");
        inputPIN = masuk.nextInt();
        for(int j = 0; i < 3 ; i++) {
            if (inputPIN == pin[i]) {
                x = i;
            };
        }
        saldor = saldo[x];
        a.setMoney(saldor);
        do {
            System.out.println("+================================+");
            System.out.println("|| 1. Penarikan Uang            ||");
            System.out.println("|| 2. Transfer                  ||");
            System.out.println("|| 3. Informasi Saldo           ||");
            System.out.println("|| 4. Keluar                    ||");
            System.out.println("+================================+");
            System.out.print("Pilih Menu : ");
            pilih = masuk.nextInt();
            if (pilih == 1) {
                System.out.print("Masukkan nominal uang : ");
                tarikUang = masuk.nextInt();
                b.setTarik(tarikUang);
                saldo[x] =  a.getMoney() - b.getTarik();
                saldor = saldo[x];
                a.setMoney(saldor);
                y++;
                if(y % 3 == 0) {
                    bonus = a.getMoney() + tarikUang * (a.getMoney()*3/100);
                    a.setMoney(bonus);
                    System.out.println("Selamat ini penrikan ke-" + y + " , Anda");
                    System.out.println("berhak mendapatkan tambahan saldo sebesar : " + (tarikUang * 0.03));

                }
            } else if (pilih == 2) {
                do {
                    pilih = 3;
                    System.out.print("Masukkan Rekening Tujuan : ");
                    noRek = masuk.nextInt();
                    for(int z  = 0 ; z < 3 ; z++){
                        if (noRek == noRekTeman[z]){
                            u = z;
                        }
                    }
                }while (pilih == 4);
                for(int z  = 0 ; z < 3 ; z++){
                    if (noRek == noRekTeman[z]){
                        u = z;
                    }
                } nama = namarek[u];
                System.out.print("Masukkan Nominal uang : ");
                transfer = masuk.nextInt();
                c.setTransfer(transfer);
                saldo[x] = a.getMoney() - c.getTransfer();
                saldor = saldo[x];
                a.setMoney(saldor);
                System.out.println("Transfer sebesar "+transfer+" ke rekening "+nama+" telah berhasil");

            }else if (pilih == 3) {
                System.out.println("Saldo Anda : " + saldo[x]);
            } else if (pilih == 4) {
                System.out.println(d.getKeluar());
                System.exit(0);
            }

        } while (pilih != 4 );
    }
}

