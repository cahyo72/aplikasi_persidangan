														/* 		TUGAS BESAR ALGORITMA
															ISKANDAR JATI C			[M3114082] 
															ISNAINI CHORYSYA H		[M3114083]
															MUHAMMAD AKBAR FAIRUS A	[M3114103]
															MUHAMMAD SURFA'I		[M3114106] */
	
import java.io.*;
public class Pengadilan
{
static BufferedReader iskahn= new BufferedReader(new InputStreamReader(System.in));
	static perkara pkr=new perkara();
	static String Perkara[]= new String [100];
	static String m [] = new String [100];
	static String cari1 [] = new String [100] ;
	static int jenis [] = new int [100];
	static int top,tip;
	static int pilih;
	
//Main Method
public static void main(String[] args)throws IOException{
		String InputData="";
		
		
		System.out.println("-------------------------------------------------------- ");
		System.out.println("|=========Selamat Datang di System Persidangan=========| ");
		System.out.println("-------------------------------------------------------- ");
		do{ 
			menu();
			try{
				System.out.print(" Masukan Pilihan Anda : ");
				InputData=iskahn.readLine();
				pilih= Integer.parseInt(InputData);
				
			}
			catch (NumberFormatException exc){
				System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Masukan Pilihan Anda : ");
				InputData=iskahn.readLine();
				pilih= Integer.parseInt(InputData);
			}
			
		
			switch(pilih){
				case 1 : inputdata(pkr);
				break;
				case 2 : cetak();
				break;
				case 3 : cari(); 
				break;
				case 4 : PencarianMaxMin(); 
				break;
				case 5 : hapus(pkr.nama,pkr.nomor,pkr.masuk,pkr.bulan,pkr.tahun);
				break;
				case 6 : pengurutan() ;
				break;
				case 7 : trans ();
				break;
				case 8 : simpankep ();
				break;
				case 9 : edit();
				break;
				case 0 : System.out.println(" Anda Keluar dari Program\n\tTerima Kasih");
				break;
				default: System.out.println(" Maaf Program Error, Silahkan Input Ulang");
			}	
		}
		while (pilih!=0);
		
	}
			
//MENU PROGRAM
public static void menu(){
		System.out.println("-----------------------------------------");
		System.out.println("|==============Menu Perkara=============|");
		System.out.println("|---------------------------------------|");
		System.out.println("| 1. Masukan data pelanggar             |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 2. Daftar Berkas Pengajuan            |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 3. Pencarian Berkas Pelanggar         |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 4. Pencarian Usia Maksimum dan Minimum|");
		System.out.println("|---------------------------------------|");
		System.out.println("| 5. Pengambilan Berkas Pelanggar       |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 6. Pengurutan Berkas Pelanggar        |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 7. Data yang belum masuk dipengadilan |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 8. Data yang sudah masuk dipengadilan |");
		System.out.println("|---------------------------------------|");
		System.out.println("| 9. Pengeditan data                    |");
		System.out.println("|                                       |");
		System.out.println("| 0. Keluar program                     |");
		System.out.println("-=---------------------------------------");
	}		
//CEK KOSONG
public static boolean cekkosong(){
		boolean kosong;
		if(top==0){
			kosong = true;
		}else{
			kosong = false;
		}
		return kosong;
	}
	
//INPUT DATA

public static void inputdata(perkara pkr)throws IOException
{
	
		top++;
		System.out.println("\n========[Form Pengisian Data]==========");
		try{
		System.out.print("\n Nama\t\t\t: ");
		pkr.nama [top] =iskahn.readLine();}
		catch(IOException e) {
		System.out.println("Error!");}
		System.out.print("\n Tempat Lahir\t\t: ");
		pkr.TTL[top]=iskahn.readLine();
		do{
			try{
			System.out.print(" Tanggal Lahir\t\t: ");
			pkr.tanggalL[top] = Integer.parseInt(iskahn.readLine());
				}catch(NumberFormatException exc){
				System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tanggal Lahir\t\t: ");
				pkr.tanggalL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.tanggalL[top]>=1 & pkr.tanggalL[top] <=30)
				System.out.print("");
					else{System.out.println("Maaf Tanggal Invalid");}}
					while((pkr.tanggalL[top]>=1 & pkr.tanggalL[top] <=30)==false);
		do{
			try{
		System.out.print(" Bulan  Lahir\t\t: ");
		pkr.bulanL[top] = Integer.parseInt(iskahn.readLine());
			}catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Bulan Lahir\t\t: ");
				pkr.bulanL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.bulanL[top] >=1 & pkr.bulanL[top] <=12)
				System.out.print("");
				else{System.out.println("Maaf bulan Invalid");}}
					while((pkr.bulanL[top]>=1 & pkr.bulanL[top] <=12)==false);
		do{
			try{
		System.out.print(" Tahun  Lahir\t\t: ");
		pkr.tahunL[top] = Integer.parseInt(iskahn.readLine());
			}catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tahun Lahir\t\t: ");
				pkr.tahunL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.tahunL[top]>=1)
				System.out.print("");
				else{System.out.println("Maaf Tahun Invalid");}}
					while((pkr.tahunL[top]>=1)==false);
		do{
			try{
		System.out.print("\n No Identitas(KTP/SIM)\t: ");
		pkr.nomor[top] = Long.parseLong(iskahn.readLine());
			}
			catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
			System.out.print("\n No Identitas(KTP/SIM)\t: ");
			pkr.nomor[top] = Long.parseLong(iskahn.readLine());
			}
		}
			while((pkr.nomor[top]>0)==false);
		System.out.print("\n Alamat\t\t\t: ");
		pkr.alamat[top] = iskahn.readLine();
		do{
			try{
			System.out.print(" Tanggal Masuk\t\t: ");
			pkr.masuk[top] = Integer.parseInt(iskahn.readLine());
				}catch(NumberFormatException exc){
				System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tanggal Masuk\t\t: ");
				pkr.masuk[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.masuk[top] >=1 & pkr.masuk[top] <=30)
			System.out.print("");
				else{System.out.println("Maaf Tanggal Invalid");}}
					while((pkr.masuk[top]>=1 & pkr.masuk[top] <=30)==false);
		try{
			do{
			System.out.print(" Bulan  Masuk\t\t: ");
			pkr.bulan[top] = Integer.parseInt(iskahn.readLine());
			if(pkr.bulan[top] >=1 & pkr.bulan[top] <=12)
				System.out.print("");
				else{System.out.println("Maaf bulan Invalid");}}
					while((pkr.bulan[top]>=1 & pkr.bulan[top] <=12)==false);
			}
			catch (NumberFormatException exc)
			{
			System.out.println(" Masukkan bulan dengan angka!");
			System.out.print(" Bulan  Masuk\t\t: ");
			pkr.bulan[top] = Integer.parseInt(iskahn.readLine());
			}
		
		
		System.out.print(" Tahun Masuk\t\t: ");
		pkr.tahun[top] = Integer.parseInt(iskahn.readLine());
		MenuPerkara(jenis);
		pkr.usia[top]=2015-pkr.tahunL[top];
	}
	
//Pemilihan Perkara
public static void MenuPerkara(int[]jenis)throws IOException{
	int pilihP=0;
		do{
			try{
		System.out.println("Kasus Perkara\t:");
		System.out.print("(1). Pidana\n(2). Perdata\n");
		System.out.print("Pilih Kasus\t: ");
		jenis[top]=Integer.parseInt(iskahn.readLine());
		pilihP=	jenis[top];
		}
		catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
			System.out.print(" Masukan Pilihan Anda : ");
			jenis[top]=Integer.parseInt(iskahn.readLine());
			pilihP=	jenis[top];
			}
			switch(pilihP){
				case 1:	
						SyaratPidana();
					break;
	
				case 2:
						HukumPerdata(jenis);
					break;
				default:
						System.out.println("invalid");
			}
		}			
			while(pilihP!=1 & pilihP!=2);
}

//Syarat Hukum Pidana
public static void SyaratPidana(){
		System.out.println("Syarat Hukum Pidana");
		System.out.println("Syarat Formal");
		System.out.println("\n1. Nama Terdakwa\n2. Tempat Lahir\n3. Tanggal Lahir\n4. Usia\n5. Tempat Tinggal\n6. Pekerjaan\n7. Jenis Kelamin\n8. Agama\n9. Kebangsaan\n\n");
		System.out.println("Syarat Materiil");
		System.out.println("\n1. Waktu dan Tindak Pidana dilakukan\n2. Perbuatan yang dilakukan\n3. Hal-hal yang menyertai perbuatan-perbuatan Pidana");
	}

//Hukum Perdata
public static void HukumPerdata(int jenis[])throws IOException{
		int j_kasus;
		do{
			try{
		System.out.println("Hukum Perdata");
		System.out.print("\n1. Perdata tentang Warisan\n2. Perdata tentang Harta/Sengketa");
		System.out.print("\nPilih Kasus Perdata\t:");
		jenis[top]=Integer.parseInt(iskahn.readLine());
		j_kasus=jenis[top];
			}
			catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
			System.out.print(" Masukan Pilihan Anda : ");
			jenis[top]=Integer.parseInt(iskahn.readLine());
			j_kasus=jenis[top];
			}
			switch(j_kasus){
				case 1:
						System.out.println("Syarat Kasus Warisan");
						System.out.print("\n1. Surat Permohonan kepada Ketua Pengadilan\n2. Membayar Panjar Biaya Perkara\n3. Identitas (KTP/SIM)\n4. Sertifikat Hak Milik (SHM)");
						System.out.print("\n5. Akta/Surat Kelahiran\n6. Surat Pengantar dari Kelurahan");
					break;
				case 2:
						System.out.println("Syarat Kasus Harta/Sengketa");
						System.out.print("\n1. Surat Permohonan\n2. Membayar Panjar Biaya Perkara\n3. KTP Penggugat\n4. Akta Cerai");
						System.out.print("\n5. Bukti Tertulis\t:\n\t(1) Sertifikat\n\t(2) Sertifikat Hak Milik(SHM)\n\t(3) Surat Tanda Nomor Kendaraan(STNK)");
						System.out.print("\n\t(4) BPKB\n\t(5) Nota Pembelian/Kwitansi Pembelian");
					break;
			}

	}
	while(j_kasus!=1 & j_kasus!=2);
}


			
//CETAK LIST DATA
public static void cetak(){
		int i;
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Berkas Pelanggar");
		}else{
			System.out.println("\n Daftar Pelanggar ");
			for(i=1;i<=top;i++){		
				System.out.println(" No "+i);
				System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
				if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
				System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+ "-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
			}
		}
	}

//Ambil DATA	
public static void hapus(String a[],long b[],int c[],int d[] ,int e[])throws IOException{
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Berkas Pelanggar");			
		}else{
			tip++ ;
			System.out.print(" Masukan Nama Pelanggar : ");
			cari1[tip]       = iskahn.readLine();
			//cari1[tip]		= iskahn.readLine();
			
			for(int i=1;i<=top;i++) {

						a[i] = a[i+1];
						b[i] = b[i+1];
						c[i] = c[i+1];
						d[i] = d[i+1];
						e[i] = e[i+1];							
					}
					System.out.println(" Data dengan Nama " + cari1[tip] +" telah masuk dalam persidangan ");
					top--;
				} 
			}
			
//Keputusan sidang
public static void trans () {
		if(cekkosong()){
			System.out.println("\n Data Kosong. Tidak Ada Berkas ");
		}else{
		for (int i=0 ; i<=top ; i++) {
			if(i==0){continue;}
			System.out.println ("Data "+i+" yang sudah masuk dalam data persidangan dengan Nama "+pkr.nama[i]);
			
			int x=1;
			}
		for (int i=0 ; i<=top ; i++) {
		if(i==0){continue;}{
		System.out.println(" No "+i);
				System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
				if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
				System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+ "-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
		}
	}
	}
	}
		
//CARI DATA
public static void cari()throws IOException{
		int pilih=0;
		do{
			try{
		System.out.println(" 1. Mencari dengan Nama ");
		System.out.println(" 2. Mencari dengan Tanggal ");
		System.out.print(" Masukan Pilihan Anda : ");
		pilih = Integer.parseInt(iskahn.readLine());
			}
			catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
			System.out.print(" Masukan Pilihan Anda : ");
			System.out.println(" 1. Mencari dengan Nama ");
			System.out.println(" 2. Mencari dengan Tanggal ");
			System.out.print(" Masukan Pilihan Anda : ");
			pilih = Integer.parseInt(iskahn.readLine());
			}
		switch (pilih){
			case 1 : cariNama();
			break ;
			case 2: caritanggal();
			break ;
		}
	}
	while(pilih!=1 & pilih!=2);
	}
	
//Cari Nama	
	public static void cariNama ()throws IOException {
		int x=0;
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Data Pelanggar");
		}else{
			System.out.print(" Masukan Nama Pelanggar : ");
			String cari = iskahn.readLine();
			
		
			for(int i=1;i<=top;i++) {
				if(pkr.nama[i].equalsIgnoreCase(cari)){
					System.out.println("\n Nama Pelanggar\t\t: " + pkr.nama[i]);
					System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
					System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
					System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
					if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
					System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
					System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
					x=1;
				}
				if(pkr.nama[i].equalsIgnoreCase(cari)==false && i==top && x==0){
				System.out.println(" Maaf, Data tidak ada!!");}
			}
		}
	}

//Cari Tanggal
public static void caritanggal ()throws IOException {
		int x=0;
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Data Pelanggar");
		}else{
			System.out.print(" Tanggal Masuk\t: ");
			int cari1 = Integer.parseInt(iskahn.readLine());
			System.out.print(" Bulan  Masuk\t: ");
			int cari2 = Integer.parseInt(iskahn.readLine());
			System.out.print(" Tahun Masuk\t: ");
			int cari3 = Integer.parseInt(iskahn.readLine());
			int caries = cari1 + (cari2*30) + (cari3*360) ;
			for(int i=1;i<=top;i++) 
			{
				pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
				if(pkr.tanggalmasuk[i]== caries )
				{
					System.out.println("\n Nama Pelanggar\t\t: " + pkr.nama[i]);
					System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
					System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
					System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
					if(jenis[i]==1)
					{System.out.println(" Kasus\t\t\t: Pidana");}
				else
				{System.out.println(" Kasus\t\t\t: Perdata");}
				
					System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
					pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
					int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
					int sisa1 = tanggalan1%360 ;
					pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
					int	sisa2 = sisa1%30 ;
					pkr.bulan[i] =(sisa1-sisa2)/30 ;
					pkr.tanggal[i] = sisa2 ;
					System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
					x=1;
				}
				if(pkr.tanggalmasuk[i] != caries && i==top && x==0){
				System.out.println(" Maaf, Data tidak ada!!");}
			}
		}
	}
		

// PENGURUTAN		
	public static void pengurutan ()throws IOException {
		int pilih=0;
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Pelanggar");
		}else{
		do{
			try{
			System.out.println(" 1. Mengurutkan dengan data usia ");
			System.out.println(" 2. Mengurutkan dengan data tanggal masuk berkas ");
			System.out.print(" Masukan Pilihan Anda : ");
			pilih = Integer.parseInt(iskahn.readLine());
			}
			catch(NumberFormatException exc){
			System.out.println(" 1. Mengurutkan dengan data usia ");
			System.out.println(" 2. Mengurutkan dengan data tanggal masuk berkas ");
			System.out.print(" Masukan Pilihan Anda : ");
			pilih = Integer.parseInt(iskahn.readLine());
			}
			switch (pilih){
				case 1 : mengurutkanusia (pkr.nama,pkr.usia);
				break ;
				case 2 : mengurutkantanggal (pkr.tanggalmasuk,pkr.nama,pkr.masuk,pkr.bulan,pkr.tahun);
				break ;
				default:
						System.out.println("invalid");
			}
		}
		while(pilih!=1 & pilih!=2);
	}
	
}
	
	
	
	//Pencarian Data Max dan Min
	public static void PencarianMaxMin()throws IOException{
		
		if(cekkosong()){
			System.out.println("\n Daftar Kosong. Tidak Ada Pelanggan");
		}else{
			do{	
				try{
			System.out.println(" 1. Mencari Usia Maksimum Pelanggar");
			System.out.println(" 2. Mencari Usia Minimum Pelanggar");
			System.out.print(" Silahkan Masukkan Pilihan Anda\t:");
			pilih=Integer.parseInt(iskahn.readLine());
			}
			catch(NumberFormatException exc){
			System.out.println(" 1. Mencari Usia Maksimum Pelanggar");
			System.out.println(" 2. Mencari Usia Minimum Pelanggar");
			System.out.print(" Silahkan Masukkan Pilihan Anda\t:");
			pilih=Integer.parseInt(iskahn.readLine());
			}
				switch(pilih){
					
					case 1: UsiaMax(pkr.usia);
					break;
					case 2: UsiaMin(pkr.usia);
					break;
				}
		}
		while(pilih!=1 & pilih!=2);
	}
}
	
	public static void UsiaMax(int usia[]) {
		int max =0 ;
		int i = 1 ;
		while (i<=top){
			if(pkr.usia[i]>max){
				max = pkr.usia[i];
			}
			i++;
		}
		System.out.println();
		System.out.println(" Usia Pelanggar Tertua adalah "+max+" tahun");
		for(i=1; i<=top; i++){
		if (max==pkr.usia[i]) {
			System.out.println(" No "+i);
				System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
				if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
				System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+ "-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
				}
		}
	}
	
	public static void UsiaMin(int usia[]){
		int x=1;
		int min =pkr.usia[top] ;
		int i = 1 ;
		while (i<=top){
			if(pkr.usia[i]<min){
				min = pkr.usia[i];
			x=1;
			}
			i++;
		}
		System.out.println();
		System.out.println(" Usia Pelanggar Termuda adalah "+min+" tahun");
		for(i=1; i<=top; i++){
		if (min==pkr.usia[i]) {
			System.out.println(" No "+i);
				System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
				if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
				System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+ "-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
				}
		}
	}
	
	public static void mengurutkanusia (String nama[] , int usia[]) {
		for(int i=1 ; i<=top ; i++ ){
			for(int j=1 ; j!= i ; j++){
				if(pkr.usia[j+1] > pkr.usia[j]){tukardata1 (j,j+1,pkr.nama);
											tukardata (j,j+1,pkr.usia);
				}
			}
		}
				
		for(int k=1 ; k<=top ;k++){
			System.out.println(" Data Usia " + pkr.usia[k] +" Tahun dengan Nama "+ pkr.nama[k] );
		}
	}
	
	public static void tukardata (int a , int b ,int A[]) {
		int c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}	
	public static void tukardata2 (int a , int b ,int A[]) {
		int c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}
	public static void tukardata1 (int a , int b ,String A[]) {
		String c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}
	
	public static void mengurutkantanggal (int tanggalmasuk2[],String nama2[],int masuk2[],int bulan2[],int tahun2[]) {
		for(int i=1 ; i<=top ; i++ ){
			tanggalmasuk2[i] = masuk2[i] + (bulan2[i]*30) + (tahun2[i]*360) ;
			for(int j=1 ; j!= i ; j++){
				if(tanggalmasuk2[j+1] > tanggalmasuk2[j]) {tukardata2 (j,j+1,tanggalmasuk2);
														   tukardata1 (j,j+1,nama2);
														   tukardata2 (j,j+1,masuk2);	 
														   tukardata2 (j,j+1,bulan2);
														   tukardata2 (j,j+1,tahun2);
				}
			}
		}
		for(int k=1 ; k<=top ;k++){
			System.out.println(" Dengan tanggal " + masuk2[k]+"-"+ bulan2[k]+"-"+tahun2[k]+"  dengan nama "+ nama2[k] );
		}		
	}
//simpankep	
	public static void simpankep () {
	if(cekkosong()){
			System.out.println("\n Data Kosong. Tidak Ada Berkas yang Masuk ke Pengadilan");}
		else{
		for (int i=1 ; i<=tip ; i++) {
			if(i==0){continue;}
			System.out.println ("Data "+i+" yang sudah masuk dalam data persidangan dengan Nama "+pkr.nama[i]);
			int x=1;
			}
			for (int i=1 ; i<=tip ; i++) {
			if(i==0){continue;}{
			System.out.println(" No "+i);
				System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
				if(jenis[i]==1){System.out.println(" Kasus\t\t\t: Pidana");
						}else{System.out.println(" Kasus\t\t\t: Perdata");}
				System.out.println(" Tanggal Masuk\t\t: " + pkr.masuk[i]+ "-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
							pkr.tanggalmasuk[i] = pkr.masuk[i] + (pkr.bulan[i]*30) + (pkr.tahun[i]*360) ;
							int tanggalan1 = pkr.tanggalmasuk[i] + 7 ; 
							int sisa1 = tanggalan1%360 ;
							pkr.tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							pkr.bulan[i] =(sisa1-sisa2)/30 ;
							pkr.tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Persidangan\t: " + pkr.tanggal[i]+"-"+ pkr.bulan[i]+"-"+pkr.tahun[i]);
		}
	}
}
}	
//edit
public static void edit()throws IOException{
	int i=0;
	BufferedReader data = new BufferedReader(new InputStreamReader(System.in));	
			cetak();
		do{
			try {
			System.out.print("\nUbah Identitas Pelanggar Ke-");
			i = Integer.parseInt(data.readLine());
			if (i<1 || i>top)throw new Exception();
			} catch(Exception e) {
			System.out.println("Error!");}
			}while(i<1 || i>top);
			System.out.println(" Nama Pelanggar\t\t: " + pkr.nama[i]);
				System.out.println(" Tempat, Tanggal Lahir\t: "+pkr.TTL[i]);
				System.out.println(" No Identitas\t\t: " + pkr.nomor[i]);
				System.out.println(" Alamat\t\t\t: "+pkr.alamat[i]);
				System.out.println(" Usia\t\t\t: "+ pkr.usia[i]+" tahun");
		
				System.out.println("\n========[Form Pengisian Data baru]==========");
		System.out.print("\n Nama\t\t\t: ");
		pkr.nama [top] =iskahn.readLine();
		System.out.print("\n Tempat Lahir\t\t: ");
		pkr.TTL[top]=iskahn.readLine();
		do{
			try{
			System.out.print(" Tanggal Lahir\t\t: ");
			pkr.tanggalL[top] = Integer.parseInt(iskahn.readLine());
				}catch(NumberFormatException exc){
				System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tanggal Lahir\t\t: ");
				pkr.tanggalL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.tanggalL[top]>=1 & pkr.tanggalL[top] <=30)
				System.out.print("");
					else{System.out.println("Maaf Tanggal Invalid");}}
					while((pkr.tanggalL[top]>=1 & pkr.tanggalL[top] <=30)==false);
		do{
			try{
		System.out.print(" Bulan  Lahir\t\t: ");
		pkr.bulanL[top] = Integer.parseInt(iskahn.readLine());
			}catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Bulan Lahir\t\t: ");
				pkr.bulanL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.bulanL[top] >=1 & pkr.bulanL[top] <=12)
				System.out.print("");
				else{System.out.println("Maaf bulan Invalid");}}
					while((pkr.bulanL[top]>=1 & pkr.bulanL[top] <=12)==false);
		do{
			try{
		System.out.print(" Tahun  Lahir\t\t: ");
		pkr.tahunL[top] = Integer.parseInt(iskahn.readLine());
			}catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tahun Lahir\t\t: ");
				pkr.tahunL[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.tahunL[top]>=1)
				System.out.print("");
				else{System.out.println("Maaf Tahun Invalid");}}
					while((pkr.tahunL[top]>=1)==false);
		do{
			try{
		System.out.print("\n No Identitas(KTP/SIM)\t: ");
		pkr.nomor[top] = Long.parseLong(iskahn.readLine());
			}
			catch(NumberFormatException exc){
			System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
			System.out.print("\n No Identitas(KTP/SIM)\t: ");
			pkr.nomor[top] = Long.parseLong(iskahn.readLine());
			}
		}
			while((pkr.nomor[top]>0)==false);
		System.out.print("\n Alamat\t\t\t: ");
		pkr.alamat[top] = iskahn.readLine();
		do{
			try{
			System.out.print(" Tanggal Masuk\t\t: ");
			pkr.masuk[top] = Integer.parseInt(iskahn.readLine());
				}catch(NumberFormatException exc){
				System.out.println(" Inputan anda salah. Mohon inputkan ulang !");
				System.out.print(" Tanggal Masuk\t\t: ");
				pkr.masuk[top] = Integer.parseInt(iskahn.readLine());}
			if(pkr.masuk[top] >=1 & pkr.masuk[top] <=30)
			System.out.print("");
				else{System.out.println("Maaf Tanggal Invalid");}}
					while((pkr.masuk[top]>=1 & pkr.masuk[top] <=30)==false);
		try{
			do{
			System.out.print(" Bulan  Masuk\t\t: ");
			pkr.bulan[top] = Integer.parseInt(iskahn.readLine());
			if(pkr.bulan[top] >=1 & pkr.bulan[top] <=12)
				System.out.print("");
				else{System.out.println("Maaf bulan Invalid");}}
					while((pkr.bulan[top]>=1 & pkr.bulan[top] <=12)==false);
			}
			catch (NumberFormatException exc)
			{
			System.out.println(" Masukkan bulan dengan angka!");
			System.out.print(" Bulan  Masuk\t\t: ");
			pkr.bulan[top] = Integer.parseInt(iskahn.readLine());
			}
		
		
		System.out.print(" Tahun Masuk\t\t: ");
		pkr.tahun[top] = Integer.parseInt(iskahn.readLine());
		MenuPerkara(jenis);
		pkr.usia[top]=2015-pkr.tahunL[top];
			}
}
