# E-Dakwah
<h1> Aplikasi E-Dakwah Pencarian Kajian Menggunakan Springboot dan Postgres Sebagai DBMSnya </h1>

<ol>
  <li><p> Masuk kedalam pom.xml lalu masukan dependency yang ingin dimasukan, gunakan maven lalu sync kan </p></li>
  <li><p> buka <strong>src/main/resources</strong> buka file <strong>application.properties</strong> masukan dari mulai PORT, DB_HOST, DB_PORT, DB_NAME
  DB_USERNAME, DB_PASSWORD, dan settingan lainnya<p></li>
</ol>

# Cara kerja aplikasi E-dakwah
<ul>
  <li>
    <p> ada 10 bagian yaitu mosque, kajian, kajian schedule, expertise, preacher, gender, user, profile, attendance, dan report </p>
  </li>
  
  <li>
    <p> pertama buat mosque terlebih dahulu, yang mana ini dibuat oleh penjaga masjid yang memasukan masjidnya, serta kajian yang ada, dan mengurus
    administrasi yang ada pada table-table yang ada</p>
  </li>
  
  <li>
    <p> kajian akan dibuat menggunakan id mosque yang mana setiap mosque akan memiliki banyak kajian, lalu dari kajian akan dibuatkan schedulenya 
    yaitu dengan membuat data di table kajian schedule untuk membuat jadwal yang ingin di tetapkan dari kapan dimulai dan berakhir </p>
   </li>
   
    <li>
      <p>
         ada table expertise, preacher(ustadz) dan gender, isikan table tersebut agar bisa memilih kajian schedule mana yang bisa preacher(ustadz)
         yang jumpai
      </p>
   </li>
   
   <li>
      <p>
         table user digunakan untuk menu auth serta mendaftarkan user yang mau mengikuti kajian yang ada
         dan harus register menggunakan email dan password untuk melakukan login dan mengisi profile pada table profile,
         setelah itu user akan bisa memilih kajian dari masjid mana yang mau dipilih
      </p>
   </li>
   
    <li>
      <p>
        ada table attandence yang berguna untuk merekam kehadiran user yang mengikuti kajian, jika user mengikuti kajian maka akan terdaftar hadir dan akan dimasukan
        ke dalam table attandence
      </p>
   </li>
   
   
   
 </ul>

